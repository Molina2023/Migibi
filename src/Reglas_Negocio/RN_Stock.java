/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

/**
 *
 * @author nisit
 */
import Objetos_Negocio.Stock;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RN_Stock {
    Conexion inst = new Conexion();
    
    // Método para insertar un nuevo registro en stock
    public void Crear_Stock(int Id_Usuario_Alta) {
        String sql = "INSERT INTO stock (Activo, Id_Usuario_Alta, Fecha_Alta) VALUES (1, ?, NOW())";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Id_Usuario_Alta);
            pstmt.executeUpdate();
            System.out.println("Nuevo registro de stock creado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear nuevo registro de stock: " + e.getMessage());
        }
    }

    // Método para obtener el ID del último registro de stock activo
    public List<Stock> Consultar_Stock(String query) {
        List<Stock> listaStock = new ArrayList<>();
        String sql = "SELECT * FROM stock "+query+";";
        try (Connection conn = inst.Conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Stock stock = new Stock();
                stock.setId_Stock(rs.getInt("Id_Stock"));
                stock.setActivo(rs.getBoolean("Activo"));
                stock.setId_Usuario_Alta(rs.getInt("Id_Usuario_Alta"));
                stock.setFecha_Alta(rs.getTimestamp("Fecha_Alta"));
                stock.setId_Usuario_Modif(rs.getInt("Id_Usuario_Modif"));
                stock.setFecha_Modif(rs.getTimestamp("Fecha_Modif"));
                stock.setId_Usuario_Baja(rs.getInt("Id_Usuario_Baja"));
                stock.setFecha_Baja(rs.getTimestamp("Fecha_Baja"));
                listaStock.add(stock);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener consumos: " + e.getMessage());
        }
        return listaStock;
    }

    // Método para dar de baja un registro de stock (simulando un borrado lógico)
    public void Eliminar_Stock(Stock stock) {
        String sql = "UPDATE stock SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Baja = NOW() WHERE Id_Stock = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, stock.getId_Usuario_Modif());
            pstmt.setInt(2, stock.getId_Stock());
            pstmt.executeUpdate();
            System.out.println("Registro de stock dado de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja registro de stock: " + e.getMessage());
        }
    }
    
    // Método para dar de baja un registro de stock (simulando un borrado lógico)
    public void Eliminar_Stock(int Id_Stock, int Id_Usuario_Baja) {
        String sql = "UPDATE stock SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Baja = NOW() WHERE Id_Stock = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Id_Usuario_Baja);
            pstmt.setInt(2, Id_Stock);
            pstmt.executeUpdate();
            System.out.println("Registro de stock dado de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja registro de stock: " + e.getMessage());
        }
    }
}
