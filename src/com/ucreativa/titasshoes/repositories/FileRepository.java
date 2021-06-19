package com.ucreativa.titasshoes.repositories;

import com.ucreativa.titasshoes.entities.Empleado;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileRepository implements Repository{

    private final String FILE_PATH = "db.txt";

    @Override
    public void save(Empleado empleado) {
        String text = empleado.getNombre() + " " + empleado.getCedula() + "\n";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            writer.append(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<String> get(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            return reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
