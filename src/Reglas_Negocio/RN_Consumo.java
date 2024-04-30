/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

/**
 *
 * @author nisit
 */
import Objetos_Negocio.Consumo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RN_Consumo {
    Conexion inst = new Conexion();
    
    // Método para insertar un nuevo consumo
    public void Crear_Consumo(Consumo consumo) {
        String sql = "INSERT INTO consumo (Id_Receta, Id_Usuario_Receta, Fecha_Consumo, Activo, Id_Usuario_Alta, Fecha_Alta) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, consumo.getId_Receta());
            pstmt.setInt(2, consumo.getId_Usuario_Receta());
            pstmt.setTimestamp(3, new java.sql.Timestamp(consumo.getFecha_Consumo().getTime()));
            pstmt.setBoolean(4, consumo.isActivo());
            pstmt.setInt(5, consumo.getId_Usuario_Alta());
            pstmt.setTimestamp(6, new java.sql.Timestamp(consumo.getFecha_Alta().getTime()));
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                consumo.setId_Consumo(rs.getInt(1));
            }
            System.out.println("Nuevo consumo registrado con ID: " + consumo.getId_Consumo());
        } catch (SQLException e) {
            System.out.println("Error al registrar nuevo consumo: " + e.getMessage());
        }
    }

    // Método para obtener todos los consumos
    public List<Consumo> Consultar_Consumo(String query) {
        List<Consumo> listaConsumos = new ArrayList<>();
        String sql = "SELECT * FROM consumo "+query+";";
        try (Connection conn = inst.Conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Consumo consumo = new Consumo();
                consumo.setId_Consumo(rs.getInt("Id_Consumo"));
                consumo.setId_Receta(rs.getInt("Id_Receta"));
                consumo.setId_Usuario_Receta(rs.getInt("Id_Usuario_Receta"));
                consumo.setFecha_Consumo(rs.getTimestamp("Fecha_Consumo"));
                consumo.setActivo(rs.getBoolean("Activo"));
                consumo.setId_Usuario_Alta(rs.getInt("Id_Usuario_Alta"));
                consumo.setFecha_Alta(rs.getTimestamp("Fecha_Alta"));
                consumo.setId_Usuario_Modif(rs.getInt("Id_Usuario_Modif"));
                consumo.setFecha_Modif(rs.getTimestamp("Fecha_Modif"));
                consumo.setId_Usuario_Baja(rs.getInt("Id_Usuario_Baja"));
                consumo.setFecha_Baja(rs.getTimestamp("Fecha_Baja"));
                listaConsumos.add(consumo);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener consumos: " + e.getMessage());
        }
        return listaConsumos;
    }

    // Método para actualizar un consumo
    public void Actualizar_Consumo(Consumo consumo) {
        String sql = "UPDATE consumo SET Id_Receta = ?, Id_Usuario_Receta = ?, Fecha_Consumo = ?, Activo = ?, Id_Usuario_Modif = ?, Fecha_Modif = ? WHERE Id_Consumo = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, consumo.getId_Receta());
            pstmt.setInt(2, consumo.getId_Usuario_Receta());
            pstmt.setTimestamp(3, new java.sql.Timestamp(consumo.getFecha_Consumo().getTime()));
            pstmt.setBoolean(4, consumo.isActivo());
            pstmt.setInt(5, consumo.getId_Usuario_Modif());
            pstmt.setTimestamp(6, new java.sql.Timestamp(new Date().getTime()));
            pstmt.setInt(7, consumo.getId_Consumo());
            pstmt.executeUpdate();
            System.out.println("Consumo actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar consumo: " + e.getMessage());
        }
    }

    // Método para dar de baja un consumo (simulando un borrado lógico)
    public void Eliminar_Consumo(Consumo consumo) {
        String sql = "UPDATE consumo SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Baja = NOW() WHERE Id_Consumo = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, consumo.getId_Usuario_Modif());
            pstmt.setInt(2, consumo.getId_Consumo());
            pstmt.executeUpdate();
            System.out.println("Consumo dado de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja consumo: " + e.getMessage());
        }
    }
    // Método para dar de baja un consumo (simulando un borrado lógico)
    public void Eliminar_Consumo(int Id_Consumo, int Id_Usuario_Modif) {
        String sql = "UPDATE consumo SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Baja = NOW() WHERE Id_Consumo = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Id_Usuario_Modif);
            pstmt.setInt(2, Id_Consumo);
            pstmt.executeUpdate();
            System.out.println("Consumo dado de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja consumo: " + e.getMessage());
        }
    }
}
