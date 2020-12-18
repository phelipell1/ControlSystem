package com.prs.systemcontrolapi.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prs.systemcontrolapi.rest.model.Cidade;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, Long>{

}
