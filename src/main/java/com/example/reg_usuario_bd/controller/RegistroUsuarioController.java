package com.example.reg_usuario_bd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reg_usuario_bd.model.RegistroUsuario;
import com.example.reg_usuario_bd.service.RegistroUsuariosServices;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/usuarios")
public class RegistroUsuarioController {
@Autowired
private RegistroUsuariosServices registroUsuarioServices;

@GetMapping
public List<RegistroUsuario> getAllRegistroUsuarios() {
    return registroUsuarioServices.getAllRegistroUsuarios();
} 

@RequestMapping("/usuarios/login")
public String Loggin(@RequestParam("rut") String correo,String pass) {
    RegistroUsuario usuario = registroUsuarioServices.buscarPorRut(rut);
    if (usuario != null) {
        return "Acceso concedido";
    } else {
        return "Usuario no encontrado";
    }
}


 
   
}
