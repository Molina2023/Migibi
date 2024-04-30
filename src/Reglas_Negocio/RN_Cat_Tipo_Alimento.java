/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

import Objetos_Negocio.Cat_Tipo_Alimento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *Este doc es para el crud de Tipo Alimento y se conecta con la Base de Datos
 */
public class RN_Cat_Tipo_Alimento {
    Conexion inst = new Conexion();
    Connection connect;
    Statement statement;
    ResultSet set;
    int idk;

    public RN_Cat_Tipo_Alimento() {
    }
    
    // Método para insertar un nuevo tipo de alimento
    public void Crear_Tipo_Alimento(Cat_Tipo_Alimento tipoAlimento) {
        String sql = "INSERT INTO cat_tipo_alimento (Tipo_Alimento, Activo, Id_Usuario_Alta, Fecha_Alta) VALUES (?, ?, ?, ?)";
        try (Connection conn = inst.Conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, tipoAlimento.getTipo_Alimento());
            pstmt.setBoolean(2, tipoAlimento.isActivo());
            pstmt.setInt(3, tipoAlimento.getId_Usuario_Alta());
            pstmt.setTimestamp(4, new java.sql.Timestamp(tipoAlimento.getFecha_Alta().getTime()));
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                tipoAlimento.setId_Tipo_Alimento(rs.getInt(1));
            }
            System.out.println("Nuevo tipo de alimento registrado con ID: " + tipoAlimento.getId_Tipo_Alimento());
        } catch (SQLException e) {
            System.out.println("Error al registrar nuevo tipo de alimento: " + e.getMessage());
        }
    }

    // Método para los tipos de alimento según la sentencia del query
    public List<Cat_Tipo_Alimento> Consultar_Tipo_Alimento(String query) {
        List<Cat_Tipo_Alimento> listaTiposAlimento = new ArrayList<>();
        String sql = "SELECT * FROM cat_tipo_alimento "+query+";";
        try (Connection conn = inst.Conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cat_Tipo_Alimento tipoAlimento = new Cat_Tipo_Alimento();
                tipoAlimento.setId_Tipo_Alimento(rs.getInt("Id_Tipo_Alimento"));
                tipoAlimento.setTipo_Alimento(rs.getString("Tipo_Alimento"));
                tipoAlimento.setActivo(rs.getBoolean("Activo"));
                tipoAlimento.setId_Usuario_Alta(rs.getInt("Id_Usuario_Alta"));
                tipoAlimento.setFecha_Alta(rs.getTimestamp("Fecha_Alta"));
                tipoAlimento.setId_Usuario_Modif(rs.getInt("Id_Usuario_Modif"));
                tipoAlimento.setFecha_Modif(rs.getTimestamp("Fecha_Modif"));
                tipoAlimento.setId_Usuario_Baja(rs.getInt("Id_Usuario_Baja"));
                listaTiposAlimento.add(tipoAlimento);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener tipos de alimento: " + e.getMessage());
        }
        return listaTiposAlimento;
    }

    // Método para actualizar un tipo de alimento
    public void Actualizar_Tipo_Alimento(Cat_Tipo_Alimento tipoAlimento) {
        String sql = "UPDATE cat_tipo_alimento SET Tipo_Alimento = ?, Activo = ?, Id_Usuario_Modif = ?, Fecha_Modif = ? WHERE Id_Tipo_Alimento = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipoAlimento.getTipo_Alimento());
            pstmt.setBoolean(2, tipoAlimento.isActivo());
            pstmt.setInt(3, tipoAlimento.getId_Usuario_Modif());
            pstmt.setTimestamp(4, new java.sql.Timestamp(new Date().getTime()));
            pstmt.setInt(5, tipoAlimento.getId_Tipo_Alimento());
            pstmt.executeUpdate();
            System.out.println("Tipo de alimento actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar tipo de alimento: " + e.getMessage());
        }
    }

    // Método para "dar de baja" un tipo de alimento (simulando un delete)
    public void Eliminar_Tipo_Alimento(int Id_Tipo_Alimento, int Id_Usuario_Baja) {
        String sql = "UPDATE cat_tipo_alimento SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Modif = NOW() WHERE Id_Tipo_Alimento = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Id_Tipo_Alimento);
            pstmt.setInt(2, Id_Usuario_Baja);
            pstmt.executeUpdate();
            System.out.println("Tipo de alimento dado de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja tipo de alimento: " + e.getMessage());
        }
    }
    
    public void Eliminar_Tipo_Alimento(Cat_Tipo_Alimento tipoAlimento) {
        String sql = "UPDATE cat_tipo_alimento SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Modif = NOW() WHERE Id_Tipo_Alimento = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tipoAlimento.getId_Usuario_Modif());
            pstmt.setInt(2, tipoAlimento.getId_Tipo_Alimento());
            pstmt.executeUpdate();
            System.out.println("Tipo de alimento dado de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja tipo de alimento: " + e.getMessage());
        }
    }
    
    
    
}
