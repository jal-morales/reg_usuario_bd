package com.example.reg_usuario_bd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reg_usuario_bd.model.RegistroUsuario;
import com.example.reg_usuario_bd.repository.RegistroUsuarioRepository;



@Service
public class RegistroUsuariosServicesImpl  implements  RegistroUsuariosServices{
@Autowired
private  RegistroUsuarioRepository registroUsuarioRepository;
@Override
    public List<RegistroUsuario> getAllRegistroUsuarios(){
        return registroUsuarioRepository.findAll();
    }

@Override
    public Optional<RegistroUsuario> getRegistroUsuarioById(Integer id_ru){
 
     return registroUsuarioRepository.findById(id_ru);
    }
@Override
    public RegistroUsuario createUsuario(RegistroUsuario registroUsuario)
    {

        return registroUsuarioRepository.save(registroUsuario);
    }
@Override
    public RegistroUsuario updateUsuario(Integer id_ru, RegistroUsuario registro_usuario){
        registro_usuario.setId_ru(id_ru);
        return registroUsuarioRepository.save(registro_usuario);  
    } 
@Override
    public void deleteUsuarios(Integer id_ru){
        registroUsuarioRepository.deleteById(id_ru);
    }

    @Override
    public Boolean login(String correo, String pass) {
        RegistroUsuario a= new RegistroUsuario();
        Boolean estado;
        a =registroUsuarioRepository.login(correo,pass);

        if(a != null){
            estado=true;
            return estado;
        }else{
            estado=false;
            return estado;
        }

}
}
