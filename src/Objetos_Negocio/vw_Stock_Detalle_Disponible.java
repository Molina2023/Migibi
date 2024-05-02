/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos_Negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author nisit
 */
public class vw_Stock_Detalle_Disponible {
    private int Id_Receta;
    private int Id_Unidad_Medida;
    private int Id_Alimento;
    private String Alimento;
    private String Unidad_Medida;
    private BigDecimal Cantidad_Receta;
    private BigDecimal Total_Disponible;
    private int Id_Stock_Detalle;

    public vw_Stock_Detalle_Disponible() {
    }

    
    public int getId_Receta() {
        return Id_Receta;
    }

    public void setId_Receta(int Id_Receta) {
        this.Id_Receta = Id_Receta;
    }

    public int getId_Unidad_Medida() {
        return Id_Unidad_Medida;
    }

    public void setId_Unidad_Medida(int Id_Unidad_Medida) {
        this.Id_Unidad_Medida = Id_Unidad_Medida;
    }

    public int getId_Alimento() {
        return Id_Alimento;
    }

    public void setId_Alimento(int Id_Alimento) {
        this.Id_Alimento = Id_Alimento;
    }

    public String getAlimento() {
        return Alimento;
    }

    public void setAlimento(String Alimento) {
        this.Alimento = Alimento;
    }

    public String getUnidad_Medida() {
        return Unidad_Medida;
    }

    public void setUnidad_Medida(String Unidad_Medida) {
        this.Unidad_Medida = Unidad_Medida;
    }

    public BigDecimal getCantidad_Receta() {
        return Cantidad_Receta;
    }

    public void setCantidad_Receta(BigDecimal Cantidad_Receta) {
        this.Cantidad_Receta = Cantidad_Receta;
    }

    public BigDecimal getTotal_Disponible() {
        return Total_Disponible;
    }

    public void setTotal_Disponible(BigDecimal Total_Disponible) {
        this.Total_Disponible = Total_Disponible;
    }

    public int getId_Stock_Detalle() {
        return Id_Stock_Detalle;
    }

    public void setId_Stock_Detalle(int Id_Stock_Detalle) {
        this.Id_Stock_Detalle = Id_Stock_Detalle;
    }

    
}
