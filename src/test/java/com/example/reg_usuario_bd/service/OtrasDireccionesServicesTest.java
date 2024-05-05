package com.example.reg_usuario_bd.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.reg_usuario_bd.model.OtrasDirecciones;
import com.example.reg_usuario_bd.repository.OtrasDireccionesRepository;


@ExtendWith(MockitoExtension.class)
public class OtrasDireccionesServicesTest {
     @InjectMocks
    private OtrasDireccionesServicesImpl otrasDireccionesServicesImpl;

    @Mock
    private OtrasDireccionesRepository otrasDireccionesRepositoryMock;

    @Test
    public void createOtraDireccionTest() {

        OtrasDirecciones otrasDirecciones = new OtrasDirecciones();
        otrasDirecciones.setDireccion_od("Los Gorriones 10528");

        when(otrasDireccionesRepositoryMock.save(any())).thenReturn(otrasDirecciones);

        OtrasDirecciones resultado = otrasDireccionesServicesImpl.createOtraDireccion(otrasDirecciones);

        assertEquals("Los Gorriones 10528", resultado.getDireccion_od());
    }
}
