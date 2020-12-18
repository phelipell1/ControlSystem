package com.prs.systemcontrolapi.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prs.systemcontrolapi.rest.model.Loja;

@Repository
public interface LojaRepository extends CrudRepository<Loja, Long>{

}
