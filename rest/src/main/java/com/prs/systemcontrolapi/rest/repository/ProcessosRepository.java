package com.prs.systemcontrolapi.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prs.systemcontrolapi.rest.model.Processo;

public interface ProcessosRepository extends JpaRepository<Processo, Long> {

}
