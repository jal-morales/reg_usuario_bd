package com.example.reg_usuario_bd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro_usuario")
public class RegistroUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_ru")
    private int id_ru;

    @Column(name = "nombres_ru")
    private String nombres_ru;

    @Column(name = "apellidos_ru")
    private String apellidos_ru;

    @Column(name = "rut_ru")
    private String rut_ru;

    @Column(name = "telefono_ru")
    private String telefono_ru;

    @Column(name = "rol_ru")
    private String rol_ru;

    @Column(name = "direcciones_despacho_ru")
    private String direcciones_despacho_ru;

    @Column(name = "correo_ru")
    private String correo_ru;

    @Column(name = "password_ru")
    private String password_ru;

     /*GET and SET*/
     public int getId_ru() {
        return this.id_ru;
    }

    public void setId_ru(int id_ru) {
        this.id_ru = id_ru;
    }

    public String getNombres_ru() {
        return this.nombres_ru;
    }

    public void setNombres_ru(String nombres_ru) {
        this.nombres_ru = nombres_ru;
    }

    public String getApellidos_ru() {
        return this.apellidos_ru;
    }

    public void setApellidos_ru(String apellidos_ru) {
        this.apellidos_ru = apellidos_ru;
    }

    public String getRut_ru() {
        return this.rut_ru;
    }

    public void setRut_ru(String rut_ru) {
        this.rut_ru = rut_ru;
    }

    public String getTelefono_ru() {
        return this.telefono_ru;
    }

    public void setTelefono_ru(String telefono_ru) {
        this.telefono_ru = telefono_ru;
    }

    public String getRol_ru() {
        return this.rol_ru;
    }

    public void setRol_ru(String rol_ru) {
        this.rol_ru = rol_ru;
    }
    public String getDirecciones_despacho_ru() {
        return this.direcciones_despacho_ru;
    }

    public void setDirecciones_despacho_ru(String direcciones_despacho_ru) {
        this.direcciones_despacho_ru = direcciones_despacho_ru;
    }

    public String getCorreo_ru() {
        return this.correo_ru;
    }

    public void setCorreo_ru(String correo_ru) {
        this.correo_ru = correo_ru;
    }

    public String getPassword_ru() {
        return this.password_ru;
    }

    public void setPassword_ru(String password_ru) {
        this.password_ru = password_ru;
    }

}
