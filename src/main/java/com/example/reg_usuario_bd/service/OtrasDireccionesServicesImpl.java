package com.example.reg_usuario_bd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reg_usuario_bd.model.OtrasDirecciones;
import com.example.reg_usuario_bd.repository.OtrasDireccionesRepository;

@Service
public class OtrasDireccionesServicesImpl implements OtrasDireccionesServices {
@Autowired
private  OtrasDireccionesRepository otrasDireccionesRepository;

@Override
    public List<OtrasDirecciones> getAllOtrasDirecciones(){
        return otrasDireccionesRepository.findAll();
    }

@Override
    public Optional<OtrasDirecciones> getOtrasDireccionById(Integer id_od){
 
     return otrasDireccionesRepository.findById(id_od);
    }
@Override
    public OtrasDirecciones createOtraDireccion(OtrasDirecciones otrasDirecciones)
    {

        return otrasDireccionesRepository.save(otrasDirecciones);
    }
@Override
    public OtrasDirecciones  updateOtrasDireccion(Integer id_od, OtrasDirecciones otrasDirecciones){
       otrasDirecciones.setId_od(id_od);
       return otrasDireccionesRepository.save(otrasDirecciones);
        
    } 
@Override
public void deleteOtrasDireccion(Integer id_od){
    otrasDireccionesRepository.deleteById(id_od);
}
   
}
