package com.ucreativa.titasshoes.entities;

public abstract class Empleado {
    private String nombre;
    private String cedula;
    private int edad;

    public Empleado(String nombre, String cedula, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }
    public String getCedula() {
        return this.cedula;
    }
    public int getEdad() {
        return this.edad;
    }
    public void setNombre(String nombre) { this.nombre = nombre;}
    public void setCedula(String cedula) { this.cedula = cedula;}
    public void setEdad(int edad) { this.edad = edad;}


}