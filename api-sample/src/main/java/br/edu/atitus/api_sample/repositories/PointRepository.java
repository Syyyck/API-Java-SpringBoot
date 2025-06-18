
package br.edu.atitus.api_sample.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.atitus.api_sample.entities.PointEntity;
import java.util.List;
import br.edu.atitus.api_sample.entities.UserEntity;


@Repository
public interface PointRepository extends JpaRepository<PointEntity, UUID>{
	
	List<PointEntity> findByUser(UserEntity user);
	// Retornar em formato de List o que encontrar na tabela PointEntity com o valor de "user"
}

