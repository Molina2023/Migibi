/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reglas_Negocio;

/**
 *
 * @author nisit
 */

import Objetos_Negocio.vw_Stock_Detalle_Disponible;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RN_vw_Receta_Detalle_Disponible {
    Conexion inst = new Conexion();
    
    public RN_vw_Receta_Detalle_Disponible() {}
    
    public List<vw_Stock_Detalle_Disponible> Consultar_Recetas_Disponible() {
        List<vw_Stock_Detalle_Disponible> listaRecetas = new ArrayList<>();
        String sql = "SELECT * FROM receta where Activo=1;";
        Connection conn = inst.Conectar();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                listaRecetas.add(Consultar_Receta_Disponible(rs.getInt("Id_Receta")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RN_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaRecetas;
    }
    
    private vw_Stock_Detalle_Disponible Consultar_Receta_Disponible(int Id_Receta) {
        vw_Stock_Detalle_Disponible receta_Disponible = new vw_Stock_Detalle_Disponible();
        String sql = "SELECT * FROM vw_receta_detalle_Disponible WHERE Id_Receta = "+Id_Receta+" AND Total_Disponible - Cantidad_Receta >= 0;";
        try (Connection conn = inst.Conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             while (rs.next()) {
                
                receta_Disponible.setId_Receta(rs.getInt("Id_Receta"));
                receta_Disponible.setId_Unidad_Medida(rs.getInt("Id_Unidad_Medida"));
                receta_Disponible.setId_Alimento(rs.getInt("Id_Alimento"));
                receta_Disponible.setAlimento(rs.getString("Alimento"));
                receta_Disponible.setUnidad_Medida(rs.getString("Unidad_Medida"));
                receta_Disponible.setCantidad_Receta(rs.getBigDecimal("Cantidad_Receta"));
                receta_Disponible.setId_Stock_Detalle(rs.getInt("Id_Stock_Detalle"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener detalles de stock: " + e.getMessage());
        }
        return receta_Disponible;
    }
}
