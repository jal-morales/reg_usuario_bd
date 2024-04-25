package com.example.reg_usuario_bd.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reg_usuario_bd.model.RegistroUsuario;
import com.example.reg_usuario_bd.model.RequestLogin;
import com.example.reg_usuario_bd.model.ResponseLogin;
import com.example.reg_usuario_bd.service.RegistroUsuariosServices;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/usuarios")
public class RegistroUsuarioController {
    private static final Logger log = LoggerFactory.getLogger(RegistroUsuarioController.class);
@Autowired
private RegistroUsuariosServices registroUsuarioServices;

@Autowired
ResponseLogin responseLogin;

/*
@GetMapping
public List<RegistroUsuario> getAllRegistroUsuarios() {
    return registroUsuarioServices.getAllRegistroUsuarios();
} */
@GetMapping
public CollectionModel<EntityModel<RegistroUsuario>> getAllRegistroUsuarios() {
    List<RegistroUsuario> registroUsuarios = registroUsuarioServices.getAllRegistroUsuarios();
    log.info("GET /usuarios");
    log.info("Retornando todos los usuarios");

    List<EntityModel<RegistroUsuario>> registroUsuarioResourse = registroUsuarios.stream()
            .map(registroUsuario -> EntityModel.of(registroUsuario, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass())
                    .getRegistroUsuarioById(registroUsuario.getId_ru())).withSelfRel()))
            .collect(Collectors.toList());

    WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllRegistroUsuarios());
    CollectionModel<EntityModel<RegistroUsuario>> resources = CollectionModel.of(registroUsuarioResourse, linkTo.withRel("registroUsuario"));

    return resources;
}

/*CREAR  */
@PostMapping
public RegistroUsuario createPelicula(@RequestBody RegistroUsuario registroUsuario){
    return registroUsuarioServices.createUsuario(registroUsuario);
}
/*Modificar */

@PutMapping("/{id}")
public RegistroUsuario modificarPelicula(@PathVariable int id, @RequestBody RegistroUsuario registroUsuario) {
    
    
    return registroUsuarioServices.updateUsuario(id, registroUsuario);
}

/*Get UsuarioBYID */
@GetMapping("/{id_registroUsuario}")
public EntityModel<RegistroUsuario>  getRegistroUsuarioById(@PathVariable int id_registroUsuario) {


    Optional<RegistroUsuario> registroUsuario = registroUsuarioServices.getRegistroUsuarioById(id_registroUsuario);
    if (registroUsuario.isPresent()) {
        return EntityModel.of(registroUsuario.get(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getRegistroUsuarioById(id_registroUsuario)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllRegistroUsuarios()).withRel("all-RegistroUsuario"));
    } else {
        throw new RegistroUsuarioNotFoundException("id usuario no existe: " + id_registroUsuario);
    } 
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
