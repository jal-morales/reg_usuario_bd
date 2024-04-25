package com.example.reg_usuario_bd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.reg_usuario_bd.model.RegistroUsuario;
import com.example.reg_usuario_bd.repository.RegistroUsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class RegistroUsuariosServicesTest {
    @InjectMocks
    private RegistroUsuariosServicesImpl registroUsuariosServicesImpl;

    @Mock
    private RegistroUsuarioRepository RegistroUsuarioRepositoryMock;

    @Test
    public void guardarPeliculaTest() {

        RegistroUsuario registroUsuario = new RegistroUsuario();
        registroUsuario.setNombres_ru("Daniela");

        when(RegistroUsuarioRepositoryMock.save(any())).thenReturn(registroUsuario);

        RegistroUsuario resultado = registroUsuariosServicesImpl.createUsuario(registroUsuario);

        assertEquals("Daniela", resultado.getNombres_ru());
    }
}
