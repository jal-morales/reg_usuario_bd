package com.example.reg_usuario_bd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.reg_usuario_bd.model.RegistroUsuario;

public interface RegistroUsuarioRepository extends JpaRepository<RegistroUsuario, Integer>{
    
    
    @Query(value= "select * from registro_usuario where correo_ru=?1 and password_ru= ?2",nativeQuery = true)
    RegistroUsuario login (String correo, String pass);
}
