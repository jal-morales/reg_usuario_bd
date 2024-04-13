package com.example.reg_usuario_bd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "otras_direcciones")
public class OtrasDirecciones extends RegistroUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_od")
    private int id_od;

    @Column(name = "direccion_od")
    private String direccion_od;

    @Column(name = "comuna_od")
    private String comuna_od;

    @Column(name = "ciudad_od")
    private String ciudad_od;

    @ManyToOne
    @JoinColumn(name = "id_ru")
    private RegistroUsuario registroUsuario;

    public int getId_od() {
        return this.id_od;
    }

    public void setId_od(int id_od) {
        this.id_od = id_od;
    }
    public String getDireccion_od() {
        return this.direccion_od;
    }

    public void setDireccion_od(String direccion_od) {
        this.direccion_od = direccion_od;
    }
    public String getComuna_od() {
        return this.comuna_od;
    }

    public void setComuna_od(String comuna_od) {
        this.comuna_od = comuna_od;
    }
    public String getCiudad_od() {
        return this.ciudad_od;
    }

    public void setCiudad_od(String ciudad_od) {
        this.ciudad_od = ciudad_od;
    }
    public RegistroUsuario getRegistroUsuario() {
        return this.registroUsuario;
    }

    public void setRegistroUsuario(RegistroUsuario registroUsuario) {
        this.registroUsuario = registroUsuario;
    }
}