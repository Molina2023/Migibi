/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

/**
 *
 * @author nisit
 */
import Objetos_Negocio.Cat_Tipo_Alimento;
import Objetos_Negocio.Cat_Tipo_Consumo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RN_Cat_Tipo_Consumo {
    Conexion inst = new Conexion();

    // Método para insertar un nuevo tipo de consumo
    public void Crear_Tipo_Consumo(Cat_Tipo_Consumo tipoConsumo) {
        String sql = "INSERT INTO cat_tipo_consumo (Tipo_Consumo, Activo, Id_Usuario_Alta, Fecha_Alta) VALUES (?, ?, ?, ?)";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, tipoConsumo.getTipo_Consumo());
            pstmt.setBoolean(2, tipoConsumo.isActivo());
            pstmt.setInt(3, tipoConsumo.getId_Usuario_Alta());
            pstmt.setTimestamp(4, new java.sql.Timestamp(tipoConsumo.getFecha_Alta().getTime()));
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                tipoConsumo.setId_Tipo_Consumo(rs.getInt(1));
            }
            System.out.println("Nuevo tipo de consumo registrado con ID: " + tipoConsumo.getId_Tipo_Consumo());
        } catch (SQLException e) {
            System.out.println("Error al registrar nuevo tipo de consumo: " + e.getMessage());
        }
    }

    // Método para obtener todos los tipos de consumo
    public List<Cat_Tipo_Consumo> Consulta_Tipo_Consumo(String query) {
        List<Cat_Tipo_Consumo> listaTiposConsumo = new ArrayList<>();
        String sql = "SELECT * FROM cat_tipo_consumo WHERE "+ query + ";";
        try (Connection conn = inst.Conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cat_Tipo_Consumo tipoConsumo = new Cat_Tipo_Consumo();
                tipoConsumo.setId_Tipo_Consumo(rs.getInt("Id_Tipo_Consumo"));
                tipoConsumo.setTipo_Consumo(rs.getString("Tipo_Consumo"));
                tipoConsumo.setActivo(rs.getBoolean("Activo"));
                tipoConsumo.setId_Usuario_Alta(rs.getInt("Id_Usuario_Alta"));
                tipoConsumo.setFecha_Alta(rs.getTimestamp("Fecha_Alta"));
                tipoConsumo.setId_Usuario_Modif(rs.getInt("Id_Usuario_Modif"));
                tipoConsumo.setFecha_Modif(rs.getTimestamp("Fecha_Modif"));
                tipoConsumo.setId_Usuario_Baja(rs.getInt("Id_Usuario_Baja"));
                tipoConsumo.setFecha_Baja(rs.getTimestamp("Fecha_Baja"));
                listaTiposConsumo.add(tipoConsumo);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener tipos de consumo: " + e.getMessage());
        }
        return listaTiposConsumo;
    }

    // Método para actualizar un tipo de consumo
    public void Actualizar_Tipo_Consumo(Cat_Tipo_Consumo tipoConsumo) {
        String sql = "UPDATE cat_tipo_consumo SET Tipo_Consumo = ?, Activo = ?, Id_Usuario_Modif = ?, Fecha_Modif = ? WHERE Id_Tipo_Consumo = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipoConsumo.getTipo_Consumo());
            pstmt.setBoolean(2, tipoConsumo.isActivo());
            pstmt.setInt(3, tipoConsumo.getId_Usuario_Modif());
            pstmt.setTimestamp(4, new java.sql.Timestamp(new Date().getTime()));
            pstmt.setInt(5, tipoConsumo.getId_Tipo_Consumo());
            pstmt.executeUpdate();
            System.out.println("Tipo de consumo actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar tipo de consumo: " + e.getMessage());
        }
    }

    // Método para dar de baja un tipo de consumo (simulando un borrado lógico)
    public void Eliminar_Tipo_Consumo(Cat_Tipo_Consumo tipoConsumo) {
        String sql = "UPDATE cat_tipo_consumo SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Baja = NOW() WHERE Id_Tipo_Consumo = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tipoConsumo.getId_Usuario_Modif());
            pstmt.setInt(2, tipoConsumo.getId_Tipo_Consumo());
            pstmt.executeUpdate();
            System.out.println("Tipo de consumo dado de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja tipo de consumo: " + e.getMessage());
        }
    }
    
    
}
