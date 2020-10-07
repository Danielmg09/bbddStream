package com.tecnara.empresa.dao;

import com.tecnara.empresa.dominio.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

public class DAO {

    Connection conexion;

    public DAO(){
        try {
            String url ="jdbc:mysql://127.0.0.1:3306/empresa" ;
            String url2 = "jdbc:mysql://localhost:3306/empresa?serverTimezone=" + TimeZone.getDefault().getID();
            String user = "root";
            String password = "Administrator";
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection(url2,user,password);
            System.out.println("Conectado");

        }catch(SQLException | ClassNotFoundException ex){
            System.out.println("An error ocurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }

    public List<Usuario> getUsuariosList() {

        try{
            List<Usuario> usuarios = new ArrayList<>();
            String sql = "SELECT * FROM usuarios";
            Statement statement = this.conexion.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                Usuario u = new Usuario (rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getFloat("salario"));
                usuarios.add(u);
            }
            statement.close();
            return usuarios;

        }catch (SQLException ex) {
            System.out.println("An error ocurred. Maybe user/password is invalid");
            ex.printStackTrace();
            return null;
        }


    }

    public int insertUsuario(Usuario usuario) {
        String nombre = usuario.getNombre();
        int edad = usuario.getEdad();
        float salario = usuario.getSalario();

        String sql = "INSERT INTO usuarios (nombre, edad, salario) " +
                "VALUES ('"+nombre+"','"+edad+"','"+salario+"')";

        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            sentencia.close();
            return 1;

        }catch(SQLException ex){
            System.out.println("An error ocurred. Maybe user/password is invalid");
            ex.printStackTrace();
            return 0;
        }

    }

    public int deleteUsuario(int id){
        String sql = "DELETE FROM usuarios WHERE id = '"+id+"'";
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            sentencia.close();
            return 1;

        }catch(SQLException ex){
            ex.printStackTrace();
            return 0;
        }

    }

    public int actualizarUsuario(Usuario usuario) {
        String nombre = usuario.getNombre();
        int edad = usuario.getEdad();
        float salario = usuario.getSalario();

        String sql = "UPDATE usuarios SET nombre = '" +usuario.getNombre()+"'" +
                ", edad = '" +usuario.getEdad()+"'" +
                ", salario = '" +usuario.getSalario()+ "'" +
                " WHERE id = '"+usuario.getId()+"'";

        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            sentencia.close();
            return 1;

        }catch(SQLException ex){
            ex.printStackTrace();
            return 0;
        }

    }







}
