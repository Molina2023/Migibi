/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

/**
 *
 * @author nisit
 */
import Objetos_Negocio.Receta_Detalle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RN_Receta_Detalle {
    Conexion inst = new Conexion();
    
    // Método para insertar un nuevo detalle de receta
    public void Crear_Receta_Detalle(Receta_Detalle receta_detalle) {
        String sql = "INSERT INTO receta_detalle (Id_Receta, Id_Unidad_Medida, Cantidad, Activo, Id_Usuario_Alta, Fecha_Alta, Id_Alimento) VALUES (?, ?, ?, 1, ?, NOW(), ?)";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, receta_detalle.getId_Receta());
            pstmt.setInt(2, receta_detalle.getId_Unidad_Medida());
            pstmt.setBigDecimal(3, receta_detalle.getCantidad());
            pstmt.setInt(4, receta_detalle.getId_Usuario_Alta());
            pstmt.setInt(5, receta_detalle.getId_Alimento());
            pstmt.executeUpdate();
            System.out.println("Nuevo detalle de receta registrado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar nuevo detalle de receta: " + e.getMessage());
        }
    }

    // Método para obtener todos los detalles de receta asociados a una receta específica
    public List<Receta_Detalle> Consultar_Receta_Detalle(String query) {
        List<Receta_Detalle> listaDetalles = new ArrayList<>();
        String sql = "SELECT * FROM consumo "+query+";";
        try (Connection conn = inst.Conectar();
              Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Receta_Detalle receta_detalle = new Receta_Detalle();
                receta_detalle.setId_Receta_Detalle(rs.getInt("Id_Receta_Detalle"));
                receta_detalle.setId_Receta(rs.getInt("Id_Receta"));
                receta_detalle.setId_Unidad_Medida(rs.getInt("Id_Unidad_Medida"));
                receta_detalle.setCantidad(rs.getBigDecimal("Cantidad"));
                receta_detalle.setActivo(rs.getBoolean("Activo"));
                receta_detalle.setId_Usuario_Alta(rs.getInt("Id_Usuario_Alta"));
                receta_detalle.setFecha_Alta(rs.getTimestamp("Fecha_Alta"));
                receta_detalle.setId_Usuario_Modif(rs.getInt("Id_Usuario_Modif"));
                receta_detalle.setFecha_Modif(rs.getTimestamp("Fecha_Modif"));
                receta_detalle.setId_Usuario_Baja(rs.getInt("Id_Usuario_Baja"));
                receta_detalle.setFecha_Baja(rs.getTimestamp("Fecha_Baja"));
                receta_detalle.setId_Alimento(rs.getInt("Id_Alimento"));
                listaDetalles.add(receta_detalle);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener detalles de receta: " + e.getMessage());
        }
        return listaDetalles;
    }

    // Método para actualizar un detalle de receta
    public void Actualizar_Receta_Detalle(Receta_Detalle Receta_Detalle) {
        String sql = "UPDATE receta_detalle SET Id_Unidad_Medida = ?, Cantidad = ?, Id_Alimento = ?, Id_Usuario_Modif = ?, Fecha_Modif = NOW() WHERE Id_Receta_Detalle = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Receta_Detalle.getId_Unidad_Medida());
            pstmt.setBigDecimal(2, Receta_Detalle.getCantidad());
            pstmt.setInt(3, Receta_Detalle.getId_Alimento());
            pstmt.setInt(4, Receta_Detalle.getId_Usuario_Modif());
            pstmt.setInt(5, Receta_Detalle.getId_Receta_Detalle());
            pstmt.executeUpdate();
            System.out.println("Detalle de receta actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar detalle de receta: " + e.getMessage());
        }
    }

    // Método para dar de baja un detalle de receta (simulando un borrado lógico)
    public void Eliminar_Receta_Detalle(Receta_Detalle receta_Detalle) {
        String sql = "UPDATE receta_detalle SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Baja = NOW() WHERE Id_Receta_Detalle = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, receta_Detalle.getId_Usuario_Modif());
            pstmt.setInt(2, receta_Detalle.getId_Receta_Detalle());
            pstmt.executeUpdate();
            System.out.println("Detalle de receta dado de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja detalle de receta: " + e.getMessage());
        }
    }

}
