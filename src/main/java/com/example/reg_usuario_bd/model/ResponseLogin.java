package com.example.reg_usuario_bd.model;


import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResponseLogin {

    private int codigo;
    private String mensaje;
    private boolean login;

}
