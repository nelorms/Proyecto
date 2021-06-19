package com.ucreativa.titasshoes.entities;

public class Bodeguero extends Empleado {
    private String bodega;

    public Bodeguero(String nombre, String cedula, int edad, String bodega){
        super(nombre, cedula, edad);
        this.bodega = bodega;
    }

    public String getBodega() { return this.bodega; }
    public void setBodega(String bodega) {this.bodega = bodega;}
}
