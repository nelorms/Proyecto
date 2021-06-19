package com.ucreativa.titasshoes.services;

import com.ucreativa.titasshoes.entities.Bodeguero;
import com.ucreativa.titasshoes.entities.Empleado;
import com.ucreativa.titasshoes.entities.Vendedor;
import com.ucreativa.titasshoes.repositories.Repository;

import java.util.List;

public class Planilla {

    private Repository repository;

    public Planilla(Repository repository) {
        this.repository = repository;
    }

    public void save(String nombre, String cedula, String codigo, String bodega){

        Empleado empleado;
        if(codigo.equals("")){
            empleado = new Bodeguero(nombre, cedula, bodega);
        }
        else{
            empleado = new Vendedor(nombre, cedula, codigo);
        }
        this.repository.save(empleado);
    }

    public List<String> get() {return this.repository.get(); }

}
