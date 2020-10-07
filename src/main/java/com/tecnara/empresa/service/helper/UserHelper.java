package com.tecnara.empresa.service.helper;

import com.tecnara.empresa.dao.DAO;
import com.tecnara.empresa.dominio.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserHelper {

    public List<Usuario> filtrarPorNombre(String nombre, List<Usuario> usuarios){
        return usuarios.stream()
                .filter(usuario -> usuario.getNombre().equals(nombre) )
                .collect(Collectors.toList());
    }

    public List<Usuario> filtrarPorEdad(int edad, List<Usuario> usuarios){
        return usuarios.stream()
                .filter(usuario -> usuario.getEdad() == edad )
                .collect(Collectors.toList());
    }

    public List<Usuario> filtrarPorSalario(float salario, List<Usuario> usuarios){
        return usuarios.stream()
                .filter(usuario -> usuario.getSalario() == salario )
                .collect(Collectors.toList());
    }

    public List<Usuario> filtrarRangoSalario(float min, float max, List<Usuario> usuarios){
        return usuarios.stream()
                .filter(usuario -> usuario.getSalario() >= min && usuario.getSalario() <= max )
                .collect(Collectors.toList());
    }

    public List<Usuario> filtrarRangoEdad(float min, float max, List<Usuario> usuarios){
        return usuarios.stream()
                .filter(usuario -> usuario.getEdad() >= min && usuario.getEdad() <= max )
                .collect(Collectors.toList());
    }

    public Usuario mayorSalario(List<Usuario> usuarios){

        return usuarios.stream().max((user1,user2)->{
            if(user1.getSalario()>user2.getSalario()){
                return 1;
            }
            if (user1.getSalario()<user2.getSalario()){
                return -1;
            }
            return 0;
        }).orElse(null);

    }

    public Usuario mayorEdad(List<Usuario> usuarios){
        return usuarios.stream().max((user1,user2)->{
            if(user1.getEdad()>user2.getEdad()){
                return 1;
            }
            if (user1.getEdad()<user2.getEdad()){
                return -1;
            }
            return 0;
        }).orElse(null);

    }

}
