package com.prs.systemcontrolapi.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prs.systemcontrolapi.rest.model.Atividades;

@Repository
public interface AtividadesRepository extends JpaRepository<Atividades, Long> {

}
