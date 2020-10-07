package com.tecnara.empresa.service;

import com.tecnara.empresa.dao.DAO;
import com.tecnara.empresa.dominio.Usuario;
import com.tecnara.empresa.service.helper.UserHelper;

import java.util.List;

public class UserService {

    DAO dao = new DAO();
    UserHelper userHelper = new UserHelper();

    public void mostrarUsuarios(){

    }

    public String anadirUsuario(String nombre, int edad, float salario){

        Usuario user = new Usuario(nombre,edad,salario);
        if (user!= null){
            if(dao.insertUsuario(user) == 1){
                return "usuario añadido";
            }else{
                return "no se ha podido añadir usuario";
            }
        }
        return "no se ha podido añadir usuario";
    }

    public String eliminarUsuario(int id){

        if(id!=-1){
            if (dao.deleteUsuario(id) == 1){
                return "usuario eliminado";
            }else {
                return "el usuario no se ha podido eliminar";
            }
        }return "el usuario no se ha podido eliminar";

    }

    public String actualizarUsuario(int id, String nombre, int edad, float salario){
        Usuario user = new Usuario(id,nombre,edad,salario);
        if (user!=null){
            if (dao.actualizarUsuario(user)==1){
                return "usuario modificado";
            }else{
                return "no se ha podido modificar";
            }
        }return "no se ha podido modificar";

    }

    public List<Usuario> filtrarPorNombre(String nombre){

        List<Usuario> usuarios = dao.getUsuariosList();
        List<Usuario> usuarioFiltrado = userHelper.filtrarPorNombre(nombre,usuarios);

        if(usuarioFiltrado != null){
            return usuarioFiltrado;
        }
        return null;

    }

    public List<Usuario> filtrarPorEdad(int edad){
        List<Usuario> usuarios = dao.getUsuariosList();
        List<Usuario> usuarioFiltrado = userHelper.filtrarPorEdad(edad,usuarios);

        if(usuarioFiltrado != null){
            return usuarioFiltrado;
        }
        return null;

    }

    public List<Usuario> filtrarPorSalario(float salario){
        List<Usuario> usuarios = dao.getUsuariosList();
        List<Usuario> usuarioFiltrado = userHelper.filtrarPorSalario(salario,usuarios);

        if(usuarioFiltrado != null){
            return usuarioFiltrado;
        }
        return null;

    }

    public Usuario mayorSalario(){
        List<Usuario> usuarios = dao.getUsuariosList();
        Usuario usuarioFiltrado = userHelper.mayorSalario(usuarios);

        if(usuarioFiltrado != null){
            return usuarioFiltrado;
        }
        return null;


    }

    public Usuario mayorEdad(){
        List<Usuario> usuarios = dao.getUsuariosList();
        Usuario usuarioFiltrado = userHelper.mayorEdad(usuarios);

        if(usuarioFiltrado != null){
            return usuarioFiltrado;
        }
        return null;

    }

    public List<Usuario> filtrarRangoSalario(float min, float max){
        List<Usuario> usuarios = dao.getUsuariosList();
        List<Usuario> usuarioFiltrado = userHelper.filtrarRangoSalario(min,max,usuarios);

        if(usuarioFiltrado != null){
            return usuarioFiltrado;
        }
        return null;


    }

    public List<Usuario> filtrarRangoEdad(int min, int max){
        List<Usuario> usuarios = dao.getUsuariosList();
        List<Usuario> usuarioFiltrado = userHelper.filtrarRangoEdad(min, max, usuarios);

        if(usuarioFiltrado != null){
            return usuarioFiltrado;
        }
        return null;

    }
}
