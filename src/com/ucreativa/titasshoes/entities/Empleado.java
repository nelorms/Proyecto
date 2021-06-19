package com.ucreativa.titasshoes.entities;

public class Empleado {
    private String nombre;
    private String cedula;

    public Empleado(String nombre, String cedula){
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return this.nombre;
    }
    public String getCedula() {
        return this.cedula;
    }
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setCedula(String cedula){this.cedula = cedula;}
}
