package com.example.reg_usuario_bd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reg_usuario_bd.model.RegistroUsuario;
import com.example.reg_usuario_bd.model.RequestLogin;
import com.example.reg_usuario_bd.model.ResponseLogin;
import com.example.reg_usuario_bd.service.RegistroUsuariosServices;






@RestController
@RequestMapping("/usuarios")
public class RegistroUsuarioController {
@Autowired
private RegistroUsuariosServices registroUsuarioServices;

@Autowired
ResponseLogin responseLogin;

@GetMapping
public List<RegistroUsuario> getAllRegistroUsuarios() {
    return registroUsuarioServices.getAllRegistroUsuarios();
} 

@DeleteMapping("/{id}")
public void deleteUsuarios(@PathVariable Integer id){
    try {
        registroUsuarioServices.deleteUsuarios(id);
        new ResponseEntity<>("Usuario  Eliminado Correctamente",HttpStatus.OK);     
    } catch (Exception e) {
        new ResponseEntity<>("Error al eliminar la pelicula id:"+id,HttpStatus.BAD_REQUEST);  
    }     
}

@PostMapping("/login")
public ResponseEntity<ResponseLogin> login (@RequestBody RequestLogin usuario) {

    if(usuario.getCorreo() != null){
        Boolean usuarios = registroUsuarioServices.login(usuario.getCorreo(), usuario.getPass());
        if (usuarios) {
            responseLogin.setCodigo(00);
            responseLogin.setMensaje("Login ok");
            responseLogin.setLogin(usuarios);
            return new ResponseEntity<>(responseLogin,HttpStatus.OK);
        }
        else{
            responseLogin.setCodigo(01);
            responseLogin.setMensaje("Acceso denegado");
            return new ResponseEntity<>(responseLogin,HttpStatus.BAD_REQUEST);
        }
        
    }else{
        responseLogin.setCodigo(01);
        responseLogin.setMensaje("parametros vacios");

        return new ResponseEntity<>(responseLogin,HttpStatus.BAD_REQUEST);
    }


    

    
}


 
   
}
