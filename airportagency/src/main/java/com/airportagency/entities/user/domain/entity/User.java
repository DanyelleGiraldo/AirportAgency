package com.airportagency.entities.user.domain.entity;


public class User {
    private long id_usuario;
    private String nombre_usuario;
    private String password;
    private int rol_id;

    public User() {
        
    }

    public User(int id_usuario, String nombre_usuario, String password, int rol_id) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.rol_id = rol_id;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }


}
