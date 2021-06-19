package com.ucreativa.titasshoes.entities;

public class Vendedor extends Empleado {
    private String codigo;

    public Vendedor(String nombre, String cedula, String codigo){
        super(nombre, cedula);
        this.codigo = codigo;
    }
    public String getCodigo() { return this.codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}
}
