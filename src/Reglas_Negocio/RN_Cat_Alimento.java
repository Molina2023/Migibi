/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;
import Objetos_Negocio.Cat_Alimento;
import Objetos_Negocio.Cat_Tipo_Consumo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author nisit
 */
public class RN_Cat_Alimento {
    Conexion inst = new Conexion();
    
    public void Crear_Alimento(Cat_Alimento alimento) {
        String sql = "INSERT INTO cat_alimento (Id_Tipo_Alimento, Alimento, Activo, Id_Usuario_Alta, Fecha_Alta, Es_Perecedero) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = inst.Conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, alimento.getId_Tipo_Alimento());
            pstmt.setString(2, alimento.getAlimento());
            pstmt.setBoolean(3, alimento.isActivo());
            pstmt.setInt(4, alimento.getId_Usuario_Alta());
            pstmt.setTimestamp(5, alimento.getFecha_Alta());
            pstmt.setBoolean(6, alimento.isEs_Perecedero());
            pstmt.executeUpdate();
            System.out.println("Nuevo alimento registrado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar el alimento: " + e.getMessage());
        }
    }
    
    public Cat_Alimento Consultar_Alimento(int Id_Alimento) {
        String sql = "SELECT * FROM cat_alimento WHERE Id_Alimento = ?";
        try (Connection conn = inst.Conectar();
            PreparedStatement PStatement = conn.prepareStatement(sql)) {
            PStatement.setInt(1, Id_Alimento);
            try (ResultSet set = PStatement.executeQuery()) {
                if (set.next()) {
                    Cat_Alimento alimento = new Cat_Alimento();
                    alimento.setId_Alimento(set.getInt("Id_Alimento"));
                    alimento.setId_Tipo_Alimento(set.getInt("Id_Tipo_Alimento"));
                    alimento.setAlimento(set.getString("Alimento"));
                    alimento.setActivo(set.getBoolean("Activo"));
                    alimento.setId_Usuario_Alta(set.getInt("Id_Usuario_Alta"));
                    alimento.setFecha_Alta(set.getTimestamp("Fecha_Alta"));
                    alimento.setId_Usuario_Modif(set.getInt("Id_Usuario_Modif"));
                    alimento.setFecha_Modif(set.getTimestamp("Fecha_Modif"));
                    alimento.setId_Usuario_Baja(set.getInt("Id_Usuario_Baja"));
                    alimento.setFecha_Baja(set.getTimestamp("Fecha_Baja"));
                    alimento.setEs_Perecedero(set.getBoolean("Es_Perecedero"));
                    return alimento;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el alimento: " + e.getMessage());
        }
        return null;
    }
    
    
    public List<Cat_Alimento> Consultar_Alimento(String query) {
        List<Cat_Alimento> listaAlimentos = new ArrayList<>();
        String sql = "SELECT * FROM cat_alimento "+ query + ";";
        try (Connection conn = inst.Conectar();
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql)) {
            while (set.next()) {
                Cat_Alimento alimento = new Cat_Alimento();
                alimento.setId_Alimento(set.getInt("Id_Alimento"));
                alimento.setId_Tipo_Alimento(set.getInt("Id_Tipo_Alimento"));
                alimento.setAlimento(set.getString("Alimento"));
                alimento.setActivo(set.getBoolean("Activo"));
                alimento.setId_Usuario_Alta(set.getInt("Id_Usuario_Alta"));
                alimento.setFecha_Alta(set.getTimestamp("Fecha_Alta"));
                alimento.setId_Usuario_Modif(set.getInt("Id_Usuario_Modif"));
                alimento.setFecha_Modif(set.getTimestamp("Fecha_Modif"));
                alimento.setId_Usuario_Baja(set.getInt("Id_Usuario_Baja"));
                alimento.setFecha_Baja(set.getTimestamp("Fecha_Baja"));
                alimento.setEs_Perecedero(set.getBoolean("Es_Perecedero"));
                listaAlimentos.add(alimento);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener tipos de consumo: " + e.getMessage());
        }
        return listaAlimentos;
    }
    
    public void Actualizar_Alimento(Cat_Alimento alimento) {
        String sql = "UPDATE cat_alimento SET Id_Tipo_Alimento = ?, Alimento = ?, "
                   + "Activo = ?, Id_Usuario_Modif = ?, Fecha_Modif = ?, Es_Perecedero = ? "
                   + "WHERE Id_Alimento = ?";
        try (Connection conn = inst.Conectar();
            PreparedStatement PStatement = conn.prepareStatement(sql)) {
            PStatement.setInt(1, alimento.getId_Tipo_Alimento());
            PStatement.setString(2, alimento.getAlimento());
            PStatement.setBoolean(3, alimento.isActivo());
            PStatement.setInt(4, alimento.getId_Usuario_Modif());
            PStatement.setTimestamp(5, alimento.getFecha_Modif());
            PStatement.setBoolean(6, alimento.isEs_Perecedero());
            PStatement.setInt(7, alimento.getId_Alimento());
            PStatement.executeUpdate();
            System.out.println("Alimento actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el alimento: " + e.getMessage());
        }
    }
    
    public void Eliminar_Alimento (Cat_Alimento alimento) {
        String sql = "UPDATE cat_alimento SET Id_Tipo_Alimento = ?, Alimento = ?, "
                   + "Activo = ?, Id_Usuario_Baja = ?, Fecha_Baja = ?, Es_Perecedero = ? "
                   + "WHERE Id_Alimento = ?";
        try (Connection conn = inst.Conectar();
            PreparedStatement PStatement = conn.prepareStatement(sql)) {
            PStatement.setInt(1, alimento.getId_Tipo_Alimento());
            PStatement.setString(2, alimento.getAlimento());
            PStatement.setBoolean(3, false);
            PStatement.setInt(4, alimento.getId_Usuario_Modif());
            PStatement.setTimestamp(5, alimento.getFecha_Modif());
            PStatement.setBoolean(6, alimento.isEs_Perecedero());
            PStatement.setInt(7, alimento.getId_Alimento());
            PStatement.executeUpdate();
            System.out.println("Alimento eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el alimento: " + e.getMessage());
        }
    }
    
    public void eliminarAlimento(int Id_Alimento) {
        String sql = "DELETE FROM cat_alimento WHERE Id_Alimento = ?";
        try (Connection conn = inst.Conectar();
             PreparedStatement PStatement = conn.prepareStatement(sql)) {
            PStatement.setInt(1, Id_Alimento);
            PStatement.executeUpdate();
            System.out.println("Alimento eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el alimento: " + e.getMessage());
        }
    }
}
