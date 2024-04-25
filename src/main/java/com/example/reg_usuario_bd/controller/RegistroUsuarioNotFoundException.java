package com.example.reg_usuario_bd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class RegistroUsuarioNotFoundException  extends RuntimeException{

        public RegistroUsuarioNotFoundException(String mensaje)
        {
            super(mensaje);
        }
}
