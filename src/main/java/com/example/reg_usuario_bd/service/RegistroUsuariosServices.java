package com.example.reg_usuario_bd.service;

import java.util.List;
import java.util.Optional;

import com.example.reg_usuario_bd.model.RegistroUsuario;

public interface RegistroUsuariosServices {
    List<RegistroUsuario> getAllRegistroUsuarios();
    Optional <RegistroUsuario> getRegistroUsuarioById(Integer id_ru);

/*CREAR METODOS*/

    RegistroUsuario createUsuario(RegistroUsuario registro_usuario);
    RegistroUsuario  updateUsuario(Integer id_ru, RegistroUsuario registro_usuario);
    void deleteUsuarios(Integer id_ru);
 
}
