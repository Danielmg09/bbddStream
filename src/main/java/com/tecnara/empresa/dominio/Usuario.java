package com.tecnara.empresa.dominio;

public class Usuario {

    private int id;
    private String nombre;
    private int edad;
    private float salario;

    public Usuario(String nombre, int edad, float salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public Usuario(int id, String nombre, int edad, float salario) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void printUsuario(){
        System.out.println("id: "+ this.id);
        System.out.println("nombre: "+ this.nombre);
        System.out.println("edad: "+ this.edad);
        System.out.println("salario: "+this.salario);
        System.out.println("----------------------------------------------------------------------");

    }
}
