package com.ucreativa.titasshoes.repositories;

import com.ucreativa.titasshoes.entities.Empleado;

import java.util.List;

public interface Repository {
    void save (Empleado empleado);

    List<String> get();
}
