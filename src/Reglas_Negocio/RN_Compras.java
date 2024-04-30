/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

/**
 *
 * @author nisit
 */
import Objetos_Negocio.Compras;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RN_Compras {
    Conexion inst = new Conexion();
    
    // Método para insertar una nueva compra
    public void Crear_Compra(Compras compra) {
        String sql = "INSERT INTO compras (Id_Usuario_Compra, Id_Unidad_Medida, Fecha_Compra, Cantidad, Activo, Id_Usuario_Alta, Fecha_Alta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, compra.getId_Usuario_Compra());
            pstmt.setInt(2, compra.getId_Unidad_Medida());
            pstmt.setTimestamp(3, new java.sql.Timestamp(compra.getFecha_Compra().getTime()));
            pstmt.setBigDecimal(4, compra.getCantidad());
            pstmt.setBoolean(5, compra.isActivo());
            pstmt.setInt(6, compra.getId_Usuario_Alta());
            pstmt.setTimestamp(7, new java.sql.Timestamp(compra.getFecha_Alta().getTime()));
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                compra.setId_Compras(rs.getInt(1));
            }
            System.out.println("Nueva compra registrada con ID: " + compra.getId_Compras());
        } catch (SQLException e) {
            System.out.println("Error al registrar nueva compra: " + e.getMessage());
        }
    }

    // Método para obtener todas las compras
    public List<Compras> Consultar_Compra(String query) {
        List<Compras> listaCompras = new ArrayList<>();
        String sql = "SELECT * FROM compras " + query+";";
        try (Connection conn = inst.Conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Compras compra = new Compras();
                compra.setId_Compras(rs.getInt("Id_Compras"));
                compra.setId_Usuario_Compra(rs.getInt("Id_Usuario_Compra"));
                compra.setId_Unidad_Medida(rs.getInt("Id_Unidad_Medida"));
                compra.setFecha_Compra(rs.getTimestamp("Fecha_Compra"));
                compra.setCantidad(rs.getBigDecimal("Cantidad"));
                compra.setActivo(rs.getBoolean("Activo"));
                compra.setId_Usuario_Alta(rs.getInt("Id_Usuario_Alta"));
                compra.setFecha_Alta(rs.getTimestamp("Fecha_Alta"));
                compra.setId_Usuario_Modif(rs.getInt("Id_Usuario_Modif"));
                compra.setFecha_Modif(rs.getTimestamp("Fecha_Modif"));
                compra.setId_Usuario_Baja(rs.getInt("Id_Usuario_Baja"));
                compra.setFecha_Baja(rs.getTimestamp("Fecha_Baja"));
                listaCompras.add(compra);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener compras: " + e.getMessage());
        }
        return listaCompras;
    }

    // Método para actualizar una compra
    public void Actualizar_Compra(Compras compra) {
        String sql = "UPDATE compras SET Id_Usuario_Compra = ?, Id_Unidad_Medida = ?, Fecha_Compra = ?, Cantidad = ?, Activo = ?, Id_Usuario_Modif = ?, Fecha_Modif = ? WHERE Id_Compras = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, compra.getId_Usuario_Compra());
            pstmt.setInt(2, compra.getId_Unidad_Medida());
            pstmt.setTimestamp(3, new java.sql.Timestamp(compra.getFecha_Compra().getTime()));
            pstmt.setBigDecimal(4, compra.getCantidad());
            pstmt.setBoolean(5, compra.isActivo());
            pstmt.setInt(6, compra.getId_Usuario_Modif());
            pstmt.setTimestamp(7, new java.sql.Timestamp(new Date().getTime()));
            pstmt.setInt(8, compra.getId_Compras());
            pstmt.executeUpdate();
            System.out.println("Compra actualizada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar compra: " + e.getMessage());
        }
    }

    // Método para dar de baja una compra (simulando un borrado lógico)
    public void Eliminar_Compra (Compras compra) {
        String sql = "UPDATE compras SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Baja = NOW() WHERE Id_Compras = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, compra.getId_Usuario_Modif());
            pstmt.setInt(2, compra.getId_Compras());
            pstmt.executeUpdate();
            System.out.println("Compra dada de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja compra: " + e.getMessage());
        }
    }
}
