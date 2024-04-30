/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

/**
 *
 * @author nisit
 */
import Objetos_Negocio.Cat_Unidad_Medida;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RN_Cat_Unidad_Medida {
    Conexion inst = new Conexion();
    
    // Método para insertar una nueva unidad de medida
    public void Crear_Unidad_Medida(Cat_Unidad_Medida unidadMedida) {
        String sql = "INSERT INTO cat_unidad_medida (Unidad_Medida, Abreviatura, Activo, Id_Usuario_Alta, Fecha_Alta) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, unidadMedida.getUnidad_Medida());
            pstmt.setString(2, unidadMedida.getAbreviatura());
            pstmt.setBoolean(3, unidadMedida.isActivo());
            pstmt.setInt(4, unidadMedida.getId_Usuario_Alta());
            pstmt.setTimestamp(5, new java.sql.Timestamp(unidadMedida.getFecha_Alta().getTime()));
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                unidadMedida.setId_Unidad_Medida(rs.getInt(1));
            }
            System.out.println("Nueva unidad de medida registrada con ID: " + unidadMedida.getId_Unidad_Medida());
        } catch (SQLException e) {
            System.out.println("Error al registrar nueva unidad de medida: " + e.getMessage());
        }
    }

    // Método para obtener todas las unidades de medida
    public List<Cat_Unidad_Medida> Consultar_Unidad_Medida(String query) {
        List<Cat_Unidad_Medida> listaUnidadesMedida = new ArrayList<>();
        String sql = "SELECT * FROM cat_unidad_medida where "+query+";";
        try (Connection conn = inst.Conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cat_Unidad_Medida unidadMedida = new Cat_Unidad_Medida();
                unidadMedida.setId_Unidad_Medida(rs.getInt("Id_Unidad_Medida"));
                unidadMedida.setUnidad_Medida(rs.getString("Unidad_Medida"));
                unidadMedida.setAbreviatura(rs.getString("Abreviatura"));
                unidadMedida.setActivo(rs.getBoolean("Activo"));
                unidadMedida.setId_Usuario_Alta(rs.getInt("Id_Usuario_Alta"));
                unidadMedida.setFecha_Alta(rs.getTimestamp("Fecha_Alta"));
                unidadMedida.setId_Usuario_Modif(rs.getInt("Id_Usuario_Modif"));
                unidadMedida.setFecha_Modif(rs.getTimestamp("Fecha_Modif"));
                unidadMedida.setId_Usuario_Baja(rs.getInt("Id_Usuario_Baja"));
                unidadMedida.setFecha_Baja(rs.getTimestamp("Fecha_Baja"));
                listaUnidadesMedida.add(unidadMedida);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener unidades de medida: " + e.getMessage());
        }
        return listaUnidadesMedida;
    }

    // Método para actualizar una unidad de medida
    public void Actualizar_Unidad_Medida(Cat_Unidad_Medida unidadMedida) {
        String sql = "UPDATE cat_unidad_medida SET Unidad_Medida = ?, Abreviatura = ?, Activo = ?, Id_Usuario_Modif = ?, Fecha_Modif = ? WHERE Id_Unidad_Medida = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, unidadMedida.getUnidad_Medida());
            pstmt.setString(2, unidadMedida.getAbreviatura());
            pstmt.setBoolean(3, unidadMedida.isActivo());
            pstmt.setInt(4, unidadMedida.getId_Usuario_Modif());
            pstmt.setTimestamp(5, new java.sql.Timestamp(new Date().getTime()));
            pstmt.setInt(6, unidadMedida.getId_Unidad_Medida());
            pstmt.executeUpdate();
            System.out.println("Unidad de medida actualizada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar unidad de medida: " + e.getMessage());
        }
    }

    // Método para dar de baja una unidad de medida (simulando un borrado lógico)
    public void Eliminar_Unidad_Medida(Cat_Unidad_Medida unidadMedida) {
        String sql = "UPDATE cat_unidad_medida SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Baja = NOW() WHERE Id_Unidad_Medida = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, unidadMedida.getId_Usuario_Modif());
            pstmt.setInt(2, unidadMedida.getId_Unidad_Medida());
            pstmt.executeUpdate();
            System.out.println("Unidad de medida dada de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja unidad de medida: " + e.getMessage());
        }
    }
}
