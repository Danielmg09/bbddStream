package com.tecnara.empresa.view;

import com.tecnara.empresa.dao.DAO;
import com.tecnara.empresa.dominio.Usuario;
import com.tecnara.empresa.service.helper.UserHelper;
import com.tecnara.empresa.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    UserService userService = new UserService();
    Scanner sc = new Scanner(System.in);

    public void ejecutarMenu(){
        int choice;
        do{
            choice = mostrarMenu();
            switch (choice){
                case 1:
                    mostrarUsuarios();
                    break;
                case 2:
                    anadirUsuario();
                    break;
                case 3:
                    eliminarUsuario();
                    break;
                case 4:
                    actualizarUsuario();
                    break;
                case 5:
                    int filtrarPor = mostrarMenuFiltrar();
                    switch (filtrarPor){
                        case 1:
                            filtrarPorNombre();
                            break;
                        case 2:
                            filtrarPorEdad();
                            break;
                        case 3:
                            filtrarPorSalario();
                            break;
                        case 4:
                            mayorSalario();
                            break;
                        case 5:
                            mayorEdad();
                            break;
                        case 6:
                            filtrarRangoSalario();
                            break;
                        case 7:
                            filtrarRangoEdad();
                            break;


                    }
                case 6:
                    break;
            }

        }while(choice != 6);
        System.out.println("Programa finalizado");
    }

    public int mostrarMenu(){
        System.out.println("Elija una opción: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Listar Usuarios");
        System.out.println("2. Añadir Usuario");
        System.out.println("3. Eliminar Usuario");
        System.out.println("4. Actualizar Usuario");
        System.out.println("5. Filtrar usuarios");
        System.out.println("6. Salir");

        int choice = sc.nextInt();
        return choice;
    }

    public int mostrarMenuFiltrar(){
        System.out.println("Elija una opción: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Por nombre");
        System.out.println("2. Por edad");
        System.out.println("3. Por Salario");
        System.out.println("4. Mayor Salario");
        System.out.println("5. Mayor Edad");
        System.out.println("6. Rango de salario");
        System.out.println("7. Rango de edad");


        int choice = sc.nextInt();
        return choice;
    }

    public void mostrarUsuarios(){

    }

    public void anadirUsuario(){
        System.out.println("Introduce un nombre:");
        String nombre = sc.next();
        System.out.println("Introduce edad: ");
        int edad = sc.nextInt();
        System.out.println("Introduce salario: ");
        float salario = sc.nextFloat();

        System.out.println(userService.anadirUsuario(nombre,edad,salario));



    }

    public void eliminarUsuario(){
        System.out.println("Introduce el id del usuario a eliminar:");
        int id = sc.nextInt();
        System.out.println(userService.eliminarUsuario(id));

    }

    public void actualizarUsuario(){
        System.out.println("Introduce el id del usuario a modificar: ");
        int id = sc.nextInt();
        System.out.println("Introduce el nuevo nombre:");
        String nombre = sc.next();
        System.out.println("Introduce la nueva edad: ");
        int edad = sc.nextInt();
        System.out.println("Introduce el nuevo salario: ");
        float salario = sc.nextFloat();

        System.out.println(userService.actualizarUsuario(id,nombre,edad,salario));



    }

    public void filtrarPorNombre(){
        System.out.println("Introduce un nombre: ");
        String nombre = sc.next();
        userService.filtrarPorNombre(nombre).stream().forEach(usuario -> usuario.printUsuario());
    }

    public void filtrarPorEdad(){
        System.out.println("Introduce edad: ");
        int edad = sc.nextInt();
        userService.filtrarPorEdad(edad).stream().forEach(usuario -> printUsuario(usuario));

    }

    public void filtrarPorSalario(){
        System.out.println("Introduce edad: ");
        int salario = sc.nextInt();
        userService.filtrarPorSalario(salario).stream().forEach(usuario -> printUsuario(usuario));

    }

    public void mayorSalario(){
        if(userService.mayorSalario()!=null){
            userService.mayorSalario().printUsuario();
        }else{
            System.out.println("no se ha podido encontrar");
        }
    }

    public void mayorEdad(){
        if(userService.mayorEdad()!=null){
            userService.mayorEdad().printUsuario();
        }else{
            System.out.println("no se ha podido encontrar");
        }

    }

    public void filtrarRangoSalario(){
        System.out.println("Introduce salario minimo: ");
        float min = sc.nextInt();
        System.out.println("Introduce salario maximo: ");
        float max = sc.nextInt();

        userService.filtrarRangoSalario(min,max).stream()
                .forEach(usuario -> printUsuario(usuario));

    }

    public void filtrarRangoEdad(){
        System.out.println("Introduce edad minima: ");
        int min = sc.nextInt();
        System.out.println("Introduce edad maxima: ");
        int max = sc.nextInt();
        userService.filtrarRangoEdad(min,max).stream()
                .forEach(usuario -> printUsuario(usuario));

    }

    public void printUsuario(Usuario usuario){
        System.out.println("id: "+ usuario.getId());
        System.out.println("nombre: "+ usuario.getNombre());
        System.out.println("edad: "+ usuario.getEdad());
        System.out.println("salario: "+usuario.getSalario());
        System.out.println("----------------------------------------------------------------------");

    }




}
