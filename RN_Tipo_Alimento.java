/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

import Interfaces.Interfaz_Inicio;
import Objetos_Negocio.Tipo_Alimento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *Este doc es para el crud de Tipo Alimento y se conecta con la Base de Datos
 */
public class RN_Tipo_Alimento {
    Conexion inst = new Conexion();
    Connection connect;
    DefaultTableModel modelo;
    Statement statement;
    ResultSet set;
    int idk;

    public RN_Tipo_Alimento() {
    }
    
    public void Crear_Tipo_Alimento (Tipo_Alimento tipo_alimento) {
        int Activo =0;
        if (tipo_alimento.isActivo()== true) {
            Activo = 1; 
        } else {
            Activo = 0;
        }
        if (tipo_alimento.getId_Usuario_Alta() == 0) {
            tipo_alimento.setId_Usuario_Alta(1);
        }
        try {
            String query = "insert into "
                    + "cat_Tipo_Alimento(Tipo_Alimento, Activo, "
                    + "Id_Usuario_Alta, Fecha_Alta) "
                    + "values ('"+tipo_alimento.getTipo_Alimento()+"','"+Activo+"','"
                    + tipo_alimento.getId_Usuario_Alta() + "','"+tipo_alimento.getFecha_Alta()+"')";

            connect = this.inst.Conectar();
            statement = connect.createStatement();
            statement.executeUpdate(query);
            System.out.println("Nuevo cliente registrado");
            
                
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
