/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

/**
 *
 * @author nisit
 */
import Objetos_Negocio.Stock_Detalle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RN_Stock_Detalle {
    Conexion inst = new Conexion();
    
    // Método para insertar un nuevo detalle de stock
    public void Crear_Stock_Detalle(Stock_Detalle stock_Detalle) {
        String sql = "INSERT INTO stock_detalle (Id_Unidad_Medida, Cantidad, Activo, Id_Usuario_Alta, Fecha_Alta, Id_Alimento, Total, Cantidad_Consumida, Fecha_Caducidad, Es_Perecedero, Id_Alimento) VALUES (?, ?, ?, 1, ?, NOW(), ?, ?, 0, ?, ?)";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, stock_Detalle.getId_Unidad_Medida());
            pstmt.setBigDecimal(2, stock_Detalle.getCantidad());
            pstmt.setInt(3, stock_Detalle.getId_Usuario_Alta());
            pstmt.setInt(4, stock_Detalle.getId_Alimento());
            pstmt.setBigDecimal(5, stock_Detalle.getCantidad());
            pstmt.setTimestamp(6, stock_Detalle.getFecha_Caducidad());
            pstmt.setBoolean(7, stock_Detalle.isEs_Perecedero());
            pstmt.setInt(8, stock_Detalle.getId_Alimento());
            pstmt.executeUpdate();
            System.out.println("Nuevo detalle de stock registrado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar nuevo detalle de stock: " + e.getMessage());
        }
    }

    // Método para obtener todos los detalles de stock activos
    public List<Stock_Detalle> Consultar_Stock_Detalle(String query) {
        List<Stock_Detalle> listaDetalles = new ArrayList<>();
        String sql = "SELECT * FROM stock_detalle "+query+";";
        try (Connection conn = inst.Conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Stock_Detalle stock_detalle = new Stock_Detalle();
                stock_detalle.setId_Stock_Detalle(rs.getInt("Id_Stock_Detalle"));
                stock_detalle.setId_Unidad_Medida(rs.getInt("Id_Unidad_Medida"));
                stock_detalle.setCantidad(rs.getBigDecimal("Cantidad"));
                stock_detalle.setActivo(rs.getBoolean("Activo"));
                stock_detalle.setId_Usuario_Alta(rs.getInt("Id_Usuario_Alta"));
                stock_detalle.setFecha_Alta(rs.getTimestamp("Fecha_Alta"));
                stock_detalle.setId_Usuario_Modif(rs.getInt("Id_Usuario_Modif"));
                stock_detalle.setFecha_Modif(rs.getTimestamp("Fecha_Modif"));
                stock_detalle.setId_Usuario_Baja(rs.getInt("Id_Usuario_Baja"));
                stock_detalle.setFecha_Baja(rs.getTimestamp("Fecha_Baja"));
                stock_detalle.setTotal(rs.getBigDecimal("Total"));
                stock_detalle.setCantidad_Consumida(rs.getBigDecimal("Cantidad_Consumida"));
                stock_detalle.setFecha_Caducidad(rs.getTimestamp("Fecha_Caducidad"));
                stock_detalle.setEs_Perecedero(rs.getBoolean("Es_Perecedero"));
                stock_detalle.setId_Alimento(rs.getInt("Id_Alimento"));
                listaDetalles.add(stock_detalle);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener detalles de stock: " + e.getMessage());
        }
        return listaDetalles;
    }

    // Método para actualizar un detalle de stock
    public void Actualizar_Stock_Detalle(Stock_Detalle stock_Detalle) {
        String sql = "UPDATE stock_detalle SET Cantidad = (Cantidad + ?), Cantidad_Consumida = (Cantidad_Consumida + ?), Total = (Cantidad - Cantidad_Consumida), Id_Usuario_Modif = ?, Fecha_Modif = NOW() WHERE Id_Stock_Detalle = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBigDecimal(1, stock_Detalle.getCantidad());
            pstmt.setBigDecimal(2, stock_Detalle.getCantidad_Consumida());
            pstmt.setInt(3, stock_Detalle.getId_Usuario_Modif());
            pstmt.setInt(4, stock_Detalle.getId_Stock_Detalle());
            pstmt.executeUpdate();
            System.out.println("Detalle de stock actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar detalle de stock: " + e.getMessage());
        }
    }
    
    // Método para actualizar un detalle de stock
    public void Editar_Stock_Detalle(Stock_Detalle stock_Detalle) {
   
        String sql = "UPDATE stock_detalle SET Id_Unidad_Medida = ?, Cantidad = ?, Activo = ?, Id_Usuario_Modif = ?, Fecha_Modif = NOW(), Id_Alimento = ?, Cantidad_Consumida = ?, Total = (Cantidad - Cantidad_Consumida), Fecha_Caducidad = ?, Es_Perecedero = ?, Id_Alimento = ? WHERE Id_Stock_Detalle = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, stock_Detalle.getId_Unidad_Medida());
            pstmt.setBigDecimal(2, stock_Detalle.getCantidad());
            pstmt.setBoolean(3, stock_Detalle.isActivo());
            pstmt.setInt(4, stock_Detalle.getId_Usuario_Modif());
            pstmt.setInt(5, stock_Detalle.getId_Alimento());
            pstmt.setBigDecimal(6, stock_Detalle.getCantidad_Consumida());
            pstmt.setTimestamp(7, stock_Detalle.getFecha_Caducidad());
            pstmt.setBoolean(8, stock_Detalle.isEs_Perecedero());
            pstmt.setInt(9, stock_Detalle.getId_Alimento());
            pstmt.setInt(10, stock_Detalle.getId_Stock_Detalle());
            pstmt.executeUpdate();
            System.out.println("Nuevo detalle de stock registrado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar nuevo detalle de stock: " + e.getMessage());
        }
    }

    // Método para dar de baja un detalle de stock (simulando un borrado lógico)
    public void Eliminar_Stock_Detalle(Stock_Detalle stock_Detalle) {
        String sql = "UPDATE stock_detalle SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Baja = NOW() WHERE Id_Stock_Detalle = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, stock_Detalle.getId_Usuario_Modif());
            pstmt.setInt(2, stock_Detalle.getId_Stock_Detalle());
            pstmt.executeUpdate();
            System.out.println("Detalle de stock dado de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja detalle de stock: " + e.getMessage());
        }
    }
    // Método para dar de baja un detalle de stock (simulando un borrado lógico)
    public void Eliminar_Stock_Detalle(int idStockDetalle, int idUsuarioBaja) {
        String sql = "UPDATE stock_detalle SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Baja = NOW() WHERE Id_Stock_Detalle = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuarioBaja);
            pstmt.setInt(2, idStockDetalle);
            pstmt.executeUpdate();
            System.out.println("Detalle de stock dado de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja detalle de stock: " + e.getMessage());
        }
    }
}
