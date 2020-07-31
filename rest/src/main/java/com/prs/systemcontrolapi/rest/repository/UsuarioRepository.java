package com.prs.systemcontrolapi.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prs.systemcontrolapi.rest.model.Usuario_model;

public interface UsuarioRepository extends JpaRepository<Usuario_model, Long>{

}
