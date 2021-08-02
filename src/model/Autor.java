package model;

import java.util.ArrayList;

public class Autor {

    private ArrayList<Libro> libro = new ArrayList<>();
    private String nombre;
    private String apellido;

    public Autor() {
    }

    public Autor(String nombre, String apellido, ArrayList<Libro> libro) {
        this.libro = libro;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public ArrayList<Libro> getLibro() {
        return libro;
    }

    public void agregarLibro(Libro libro){
        this.libro.add(libro);

    }

    @Override
    public String toString() {
        return nombre +" "+apellido;
    }

    public void setLibro(ArrayList<Libro> libro) {
        this.libro = libro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
