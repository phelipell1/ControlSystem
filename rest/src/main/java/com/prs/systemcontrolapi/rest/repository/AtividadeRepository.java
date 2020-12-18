package com.prs.systemcontrolapi.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prs.systemcontrolapi.rest.model.Atividade;

@Repository
public interface AtividadeRepository extends PagingAndSortingRepository<Atividade, Long>{
	
	@Query(value = "select * from atividade where data_inicio like ?", nativeQuery = true)
	Optional<Atividade> findByDataInicio(@Param("dataInicio") String dataInicio);
	
	@Query(value = "select * from atividade where nome_atividade like %?%", nativeQuery = true)
	Optional<Atividade> findByNomeAtividade(@Param("nomeAtividade") String nomeAtividade);
	
}
