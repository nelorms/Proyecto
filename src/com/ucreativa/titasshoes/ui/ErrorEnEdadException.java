package com.ucreativa.titasshoes.ui;

public class ErrorEnEdadException extends Exception{
    public ErrorEnEdadException(){
        super("La edad debe ser número válido");
    }
}
