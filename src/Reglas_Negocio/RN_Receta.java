/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

/**
 *
 * @author nisit
 */
import Objetos_Negocio.Receta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RN_Receta {
    
    Conexion inst = new Conexion();
    // Método para insertar una nueva receta
    public void Crear_Receta(Receta Receta) {
        String sql = "INSERT INTO receta (Nombre, Activo, Id_Usuario_Alta, Fecha_Alta) VALUES (?, ?, ?, NOW())";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, Receta.getNombre());
            pstmt.setBoolean(2, true);
            pstmt.setInt(3, Receta.getId_Usuario_Alta());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int idReceta = rs.getInt(1);
                System.out.println("Nueva receta registrada con ID: " + idReceta);
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar nueva receta: " + e.getMessage());
        }
    }

    // Método para obtener todas las recetas activas
    public List<Receta> Consultar_Receta(String query) {
        List<Receta> listaRecetas = new ArrayList<>();
        String sql = "SELECT Nombre FROM receta "+query+";";
        try (Connection conn = inst.Conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Receta receta = new Receta();
                receta.setId_Receta(rs.getInt("Id_Receta"));
                receta.setNombre(rs.getString("Nombre"));
                receta.setActivo(rs.getBoolean("Activo"));
                receta.setId_Usuario_Alta(rs.getInt("Id_Usuario_Alta"));
                receta.setFecha_Alta(rs.getTimestamp("Fecha_Alta"));
                receta.setId_Usuario_Modif(rs.getInt("Id_Usuario_Modif"));
                receta.setFecha_Modif(rs.getTimestamp("Fecha_Modif"));
                receta.setId_Usuario_Baja(rs.getInt("Id_Usuario_Baja"));
                receta.setFecha_Baja(rs.getTimestamp("Fecha_Baja"));
                listaRecetas.add(receta);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener recetas activas: " + e.getMessage());
        }
        return listaRecetas;
    }

    // Método para actualizar el nombre de una receta
    public void Actualizar_Receta(Receta receta) {
        String sql = "UPDATE receta SET Nombre = ?, Id_Usuario_Modif = ?, Fecha_Modif = NOW() WHERE Id_Receta = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, receta.getNombre());
            pstmt.setInt(2, receta.getId_Usuario_Modif());
            pstmt.setInt(3, receta.getId_Receta());
            pstmt.executeUpdate();
            System.out.println("Nombre de receta actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar nombre de receta: " + e.getMessage());
        }
    }

    // Método para dar de baja una receta (simulando un borrado lógico)
    public void Eliminar_Receta(Receta receta) {
        String sql = "UPDATE receta SET Activo = 0, Id_Usuario_Baja = ?, Fecha_Baja = NOW() WHERE Id_Receta = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, receta.getId_Usuario_Modif());
            pstmt.setInt(2, receta.getId_Receta());
            pstmt.executeUpdate();
            System.out.println("Receta dada de baja correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al dar de baja receta: " + e.getMessage());
        }
    }
   
}
