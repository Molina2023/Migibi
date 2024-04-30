/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

/**
 *
 * @author nisit
 */
import Objetos_Negocio.Receta_Instrucciones;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RN_Receta_Instrucciones {
    Conexion inst = new Conexion();
    
    // Método para insertar una nueva instrucción de receta
    public void crearRecetaInstruccion(Receta_Instrucciones receta_instrucciones) {
        String sql = "INSERT INTO receta_instrucciones (Id_Receta, Instruccion, Orden, Activo, Id_Usuario_Alta, Fecha_Alta) VALUES (?, ?, ?, 1, ?, NOW())";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, receta_instrucciones.getId_Receta());
            pstmt.setString(2, receta_instrucciones.getInstruccion());
            pstmt.setInt(3, receta_instrucciones.getOrden());
            pstmt.setInt(4, receta_instrucciones.getId_Usuario_Alta());
            pstmt.executeUpdate();
            System.out.println("Nueva instrucción de receta registrada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar nueva instrucción de receta: " + e.getMessage());
        }
    }

    // Método para obtener todas las instrucciones de una receta
    public List<Receta_Instrucciones> Consultar_Receta(String query) {
        List<Receta_Instrucciones> listaInstrucciones = new ArrayList<>();
        String sql = "SELECT Instruccion FROM receta_instrucciones "+query+";";
        try (Connection conn = inst.Conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Receta_Instrucciones instrucciones = new Receta_Instrucciones();
                instrucciones.setId_Receta_Instrucciones(rs.getInt("Id_Receta_Instrucciones"));
                instrucciones.setId_Receta(rs.getInt("Id_Receta"));
                instrucciones.setInstruccion(rs.getString("Instruccion"));
                instrucciones.setOrden(rs.getInt("Orden"));
                instrucciones.setActivo(rs.getBoolean("Activo"));
                instrucciones.setId_Usuario_Alta(rs.getInt("Id_Usuario_Alta"));
                instrucciones.setFecha_Alta(rs.getTimestamp("Fecha_Alta"));
                instrucciones.setId_Usuario_Modif(rs.getInt("Id_Usuario_Modif"));
                instrucciones.setFecha_Modif(rs.getTimestamp("Fecha_Modif"));
                instrucciones.setId_Usuario_Baja(rs.getInt("Id_Usuario_Baja"));
                instrucciones.setFecha_Baja(rs.getTimestamp("Fecha_Baja"));
                listaInstrucciones.add(instrucciones);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener instrucciones de receta: " + e.getMessage());
        }
        return listaInstrucciones;
    }

    // Método para actualizar una instrucción de receta
    public void Actualizar_Receta_Instruccion(Receta_Instrucciones receta_instrucciones) {
        String sql = "UPDATE receta_instrucciones SET Instruccion = ?, Id_Usuario_Modif = ?, Fecha_Modif = NOW() WHERE Id_Receta_Instrucciones = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, receta_instrucciones.getInstruccion());
            pstmt.setInt(2, receta_instrucciones.getId_Usuario_Modif());
            pstmt.setInt(3, receta_instrucciones.getId_Receta_Instrucciones());
            pstmt.executeUpdate();
            System.out.println("Instrucción de receta actualizada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar instrucción de receta: " + e.getMessage());
        }
    }

    // Método para dar de baja una instrucción de receta (simulando un borrado lógico)
    public void Eliminar_Receta_Instruccion(Receta_Instrucciones receta_instrucciones) {
        String sql = "UPDATE receta_instrucciones SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Baja = NOW() WHERE Id_Receta_Instrucciones = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, receta_instrucciones.getId_Usuario_Modif());
            pstmt.setInt(2, receta_instrucciones.getId_Receta_Instrucciones());
            pstmt.executeUpdate();
            System.out.println("Instrucción de receta dada de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja instrucción de receta: " + e.getMessage());
        }
    }
    // Método para dar de baja una instrucción de receta (simulando un borrado lógico)
    public void Eliminar_Receta_Instruccion(int idRecetaInstruccion, int idUsuarioBaja) {
        String sql = "UPDATE receta_instrucciones SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Baja = NOW() WHERE Id_Receta_Instrucciones = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuarioBaja);
            pstmt.setInt(2, idRecetaInstruccion);
            pstmt.executeUpdate();
            System.out.println("Instrucción de receta dada de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja instrucción de receta: " + e.getMessage());
        }
    }
}
