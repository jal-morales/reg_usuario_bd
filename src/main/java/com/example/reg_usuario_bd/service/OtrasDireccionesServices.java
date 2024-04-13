package com.example.reg_usuario_bd.service;

import java.util.List;
import java.util.Optional;

import com.example.reg_usuario_bd.model.OtrasDirecciones;

public interface OtrasDireccionesServices {

    List<OtrasDirecciones> getAllOtrasDirecciones();
    Optional <OtrasDirecciones> getOtrasDireccionById(Integer id_od);

/*CREAR METODOS*/

    OtrasDirecciones createOtraDireccion(OtrasDirecciones otrasDirecciones);
    OtrasDirecciones  updateOtrasDireccion(Integer id_od, OtrasDirecciones otrasDirecciones);
    void deleteOtrasDireccion(Integer id_od);
}
