/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

import Interfaces.Interfaz_Inicio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nisit
 */
public class Conexion {
    
    private String Base_Datos;
    private String url = "jdbc:mysql://localhost:3306/";
    private String usuario; //root
    private String contraseña; //""
    private String driver = "com.mysql.cj.jdbc.Driver";
    Connection conexion;

    public Conexion() {
        this.Base_Datos = "migibi";
        this.usuario = "root";
        this.contraseña = "/jfdD8$&9J$H7_$%12G6_%";
    }

    public Conexion(String Base_Datos, String usuario, String contraseña) {
        this.Base_Datos = Base_Datos;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    public Connection Conectar() {
        try {
            Class.forName(this.driver);
            conexion = DriverManager.getConnection(this.url+ this.Base_Datos, this.usuario, this.contraseña);
            System.out.println("Se conectó exitosamente.");
            return conexion;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
    public void Desconectar () {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        
        Conexion connect = new Conexion();
        connect.Conectar();
    }
    
    
}
