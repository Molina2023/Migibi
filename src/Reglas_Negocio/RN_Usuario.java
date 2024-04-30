/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

import Objetos_Negocio.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nisit
 */
public class RN_Usuario {
    Conexion inst = new Conexion();
    Connection connect;
    Statement statement;
    ResultSet set;
    //El código de usuario no es necesario pero facilita la escritura de los querys
    Usuario usuario;
    String Id_Usuario = ""+usuario.getId_Usuario();
    String Nombre_Usuario = "'"+usuario.getNombre_Usuario()+"'";
    String Contraseña = "'"+usuario.getContraseña()+"'";
    String Cohabitantes = ""+usuario.getCohabitantes();
    
    
    public void Crear_Usuario (Usuario usuario) {
        this.usuario = usuario;
        String Nombre_Usuario = usuario.getNombre_Usuario();
        String Contraseña = usuario.getContraseña();
        int Cohabitantes = usuario.getCohabitantes();
        String query = "";
        if (Cohabitantes == 0) {
            query = "insert into "
                + "Usuario(Nombre_Usuario, Contraseña) "
                + "values ('"+Nombre_Usuario+"', '"+Contraseña+"')";
        } else {
            query = "insert into "
                + "Usuario(Nombre_Usuario, Contraseña, Cohabitantes) "
                + "values ('"+Nombre_Usuario+"', '"+Contraseña+"', '"+Cohabitantes+"')";
        }
        connect = this.inst.Conectar();
        try {
            statement = connect.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("No se registró el usuario"); 
            Logger.getLogger(RN_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Nuevo usuario registrado");                 
    }
    
    public List<Usuario> Consultar_Usuario (String query) {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "select * from usuario where "+query+";";
        this.connect = this.inst.Conectar();
        
        try {
            statement = this.connect.createStatement();
            set = statement.executeQuery(sql);
            while (set.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_Usuario(set.getInt("Id_Usuario"));
                usuario.setNombre_Usuario(set.getString("Nombre_Usuario"));
                usuario.setContraseña(set.getString("Contraseña"));
                usuario.setCohabitantes(set.getInt("Cohabitantes"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RN_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaUsuarios;
    }
    
    public ResultSet Consultar_Usuario (Usuario usuario) {
        this.usuario = usuario;
        String query = "select * from usuario where Id_Usuario = "+Id_Usuario+";";
        this.connect = this.inst.Conectar();
        
        try {
            statement = this.connect.createStatement();
            set = statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(RN_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return set;
    }
    
    public void Modificar_Usuario (Usuario usuario){
        this.usuario = usuario;
        String query = "update Usuario "
                + "set Nombre_Usuario = "+Nombre_Usuario+", Contraseña = "+Contraseña+", Cohabitantes = "+Cohabitantes
                + " where Id_Usuario = "+Id_Usuario+";";
        
        connect = this.inst.Conectar();
        try {
            statement = connect.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("No se modificó el usuario");
            Logger.getLogger(RN_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Usuario modificado");
    }
    
    public void Eliminar_Usuario (Usuario usuario){
        this.usuario = usuario;
        String query = "delete from usuario where Id_Usuario = "+Id_Usuario+";";
        
        connect = this.inst.Conectar();
        try {
            statement = connect.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("No se eliminó el usuario");
            Logger.getLogger(RN_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Se eliminó el usuario");
    }
    
}
