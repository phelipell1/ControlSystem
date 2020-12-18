package com.prs.systemcontrolapi.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prs.systemcontrolapi.rest.model.Costureira;

@Repository
public interface CostureiraRepository extends CrudRepository<Costureira, Long>{

}
