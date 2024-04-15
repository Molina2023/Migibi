/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

import Interfaces.Interfaz_Inicio;
import Objetos_Negocio.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nisit
 */
public class RN_Usuario {
    Conexion inst = new Conexion();
    Connection connect;
    DefaultTableModel modelo;
    Statement statement;
    ResultSet set;
    int idk;
    
    public void Crear_Usuario (Usuario usuario) {
        try {
            String query = "insert into "
                    + "Usuario(Nombre_Usuario, Contrasenia) "
                    + "values ('"+usuario.getNombre_Usuario()+"', '"+usuario.getContrasenia()+"')";

            connect = this.inst.Conectar();
            statement = connect.createStatement();
            statement.executeUpdate(query);
            System.out.println("Nuevo usuario registrado");
                
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
