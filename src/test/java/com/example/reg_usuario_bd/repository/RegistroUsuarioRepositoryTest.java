package com.example.reg_usuario_bd.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.reg_usuario_bd.model.RegistroUsuario;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RegistroUsuarioRepositoryTest {
    
    @Autowired
    private RegistroUsuarioRepository registroUsuarioRepository;

    @Test
    public void createUsuarioTest() {
       /*Aca creamos un objeto pelicula  */ 
        RegistroUsuario registroUsuario = new RegistroUsuario();
        /*Aca seteamos el nombre de la pelicula  */
        registroUsuario.setNombres_ru("Dany");
        registroUsuario.setApellidos_ru("Correa");
        registroUsuario.setCorreo_ru("dcorrea@gmail.com");
        registroUsuario.setPassword_ru("pass125465");
        

        /*Aca hacemos una variable de tipo Pelicula donde donde almacenaremos la pelicula creada llamada TITANIC */
        RegistroUsuario resultado = registroUsuarioRepository.save(registroUsuario);

        /*Aca estamos usando una clase de Junit donde estamos validando que el ID de la pelicula no sea nulo */
        assertNotNull(resultado.getId_ru());
        /*Aca estamos pasando el valor que esperamos, usamos el get de la variable resultado para obtener el dato del objeto */
        assertEquals("Dany", resultado.getNombres_ru());
    }    
}
