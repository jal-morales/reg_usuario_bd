package com.example.reg_usuario_bd.controller;

import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.EntityModel;
import org.springframework.test.web.servlet.MockMvc;

import com.example.reg_usuario_bd.model.RegistroUsuario;
import com.example.reg_usuario_bd.service.RegistroUsuariosServices;

@WebMvcTest(RegistroUsuarioController.class)
public class RegistroUsuarioControllerTest {
    
     @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegistroUsuariosServices registroUsuarioServiceMock;

    /*
    @Test
    public void obtenerTodosTest() throws Exception {
        RegistroUsuario registroUser = new RegistroUsuario();
        registroUser.setDirecciones_despacho_ru("Los martines 1045");

        RegistroUsuario registroUser2 = new RegistroUsuario();
        registroUser2.setDirecciones_despacho_ru("los cristales 5055");
        
        List<RegistroUsuario> registroUsuarios = List.of(registroUser, registroUser2);

        List<EntityModel<RegistroUsuario>> registroUsuarioResourse = registroUsuarios.stream()
            .map(student -> EntityModel.of(student))
            .collect(Collectors.toList());

        when(registroUsuarioServiceMock.getAllRegistroUsuarios()).thenReturn(registroUsuarios);

        mockMvc.perform(get("/registro"))
                .andExpect(status().isOk())
                // Here, use direct JSON path matching without Matchers
                .andExpect(jsonPath("$._embedded.students.length()").value(2))
                .andExpect(jsonPath("$._embedded.students[0].name").value("John"))
                .andExpect(jsonPath("$._embedded.students[1].name").value("Doe"))
                .andExpect(jsonPath("$._embedded.students[0]._links.self.href").value("http://localhost:8080/students/1"))
                .andExpect(jsonPath("$._embedded.students[1]._links.self.href").value("http://localhost:8080/students/2"));
    }*/
    
}

