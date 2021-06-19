package com.ucreativa.titasshoes.services;

import com.ucreativa.titasshoes.entities.Bodeguero;
import com.ucreativa.titasshoes.entities.Empleado;
import com.ucreativa.titasshoes.entities.Vendedor;
import com.ucreativa.titasshoes.repositories.Repository;
import com.ucreativa.titasshoes.ui.ErrorEnEdadException;

import java.util.List;

public class Planilla {

    private Repository repository;

    public Planilla(Repository repository) {
        this.repository = repository;
    }

    public void save(String nombre, String cedula, String edad, String codigo, String bodega) throws ErrorEnEdadException {
        int edadInt;
        try {
            edadInt = Integer.parseInt(edad);
        } catch (NumberFormatException ex){
            throw new ErrorEnEdadException();
        }
        Empleado empleado;
        if(codigo.equals("")){
            empleado = new Bodeguero(nombre, cedula, edadInt, bodega);
        }
        else{
            empleado = new Vendedor(nombre, cedula, edadInt, codigo);
        }
        this.repository.save(empleado);
    }

    public List<String> get() {return this.repository.get(); }

}
