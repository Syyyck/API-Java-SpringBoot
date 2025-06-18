package br.edu.atitus.api_sample.services;

import java.util.List;
import java.util.UUID;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.edu.atitus.api_sample.entities.PointEntity;
import br.edu.atitus.api_sample.entities.UserEntity;
import br.edu.atitus.api_sample.repositories.PointRepository;

@Service
public class PointService {
	
	private final PointRepository repository;
	
	public PointService(PointRepository repository) {
		super();
		this.repository = repository;
	}
	public PointEntity save(PointEntity point) throws Exception
	{
		if (point == null)
			throw new Exception("O Ponto não pode ser nulo");
		if (point.getDescription() == null || point.getDescription().isEmpty())
			throw new Exception("Descrição Inválida");
		point.setDescription(point.getDescription().trim());
		
		if (point.getLatitude()>= -90 || point.getLatitude()<= 90)
			throw new Exception("Latitude inválida");
					
		if (point.getLongitude()>= -90 || point.getLongitude()<= 90) 
			throw new Exception("Longitude inválida");

		UserEntity userAuth = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();				
		point.setUser(userAuth);
		return 	repository.save(point);
	}
	public void deleteById(UUID id) throws Exception {
		PointEntity point = repository.findById(id)
				.orElseThrow(() -> new Exception("Não existe este ponto cadastrado com este Id"));
		
		UserEntity userAuth = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();				
		if(!point.getUser().getId().equals(userAuth.getId()))
			throw new Exception("Você não tem permissão para apagar este registro");
		repository.deleteById(id);
	}
	public List<PointEntity> findAll(){
		UserEntity userAuth = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return repository.findByUser(userAuth);
	}
	
}
