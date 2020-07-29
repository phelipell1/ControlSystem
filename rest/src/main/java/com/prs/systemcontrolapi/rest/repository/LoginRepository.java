package com.prs.systemcontrolapi.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prs.systemcontrolapi.rest.model.Logins_model;

@Repository
public interface LoginRepository  extends JpaRepository<Logins_model, Long>{
}
