package com.example.reg_usuario_bd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reg_usuario_bd.model.RegistroUsuario;

public interface RegistroUsuarioRepository extends JpaRepository<RegistroUsuario, Integer>{
    
    
}
