/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos_Negocio;

import java.sql.Timestamp;
import java.math.BigDecimal;
/**
 *
 * @author nisit
 */
public class Receta_Detalle {
    /*
    Id_Receta_Detalle int primary key auto_increment,
    Id_Receta int not null,
    Id_Tipo_Alimento int not null,
    Id_Unidad_Medida int not null,
    Cantidad decimal null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    */
    private int Id_Receta_Detalle;
    private int Id_Receta;
    private int Id_Tipo_Alimento;
    private int Id_Unidad_Medida;
    private BigDecimal Cantidad;
    private int Id_Alimento;
    
    private boolean Activo;
    private int Id_Usuario_Alta;
    private Timestamp Fecha_Alta;
    private int Id_Usuario_Modif;
    private Timestamp Fecha_Modif;
    private int Id_Usuario_Baja;
    private Timestamp Fecha_Baja;

    public Receta_Detalle() {
    }

    
    public Receta_Detalle(int Id_Receta, int Id_Tipo_Alimento, int Id_Unidad_Medida, BigDecimal Cantidad, int Id_Alimento, int Id_Usuario_Alta) {
        this.Id_Receta = Id_Receta;
        this.Id_Tipo_Alimento = Id_Tipo_Alimento;
        this.Id_Unidad_Medida = Id_Unidad_Medida;
        this.Cantidad = Cantidad;
        this.Id_Alimento = Id_Alimento;
        this.Activo = Activo;
        this.Id_Usuario_Alta = Id_Usuario_Alta;
        this.Fecha_Alta = Fecha_Alta;
    }

    public Receta_Detalle(int Id_Receta_Detalle, int Id_Receta, int Id_Tipo_Alimento, int Id_Unidad_Medida, BigDecimal Cantidad, int Id_Alimento, int Id_Usuario_Modif) {
        this.Id_Receta_Detalle = Id_Receta_Detalle;
        this.Id_Receta = Id_Receta;
        this.Id_Tipo_Alimento = Id_Tipo_Alimento;
        this.Id_Unidad_Medida = Id_Unidad_Medida;
        this.Cantidad = Cantidad;
        this.Id_Alimento = Id_Alimento;
        this.Id_Usuario_Alta = Id_Usuario_Modif;
    }
    
    public int getId_Receta_Detalle() {
        return Id_Receta_Detalle;
    }

    public void setId_Receta_Detalle(int Id_Receta_Detalle) {
        this.Id_Receta_Detalle = Id_Receta_Detalle;
    }

    public int getId_Receta() {
        return Id_Receta;
    }

    public void setId_Receta(int Id_Receta) {
        this.Id_Receta = Id_Receta;
    }

    public int getId_Tipo_Alimento() {
        return Id_Tipo_Alimento;
    }

    public void setId_Tipo_Alimento(int Id_Tipo_Alimento) {
        this.Id_Tipo_Alimento = Id_Tipo_Alimento;
    }

    public int getId_Unidad_Medida() {
        return Id_Unidad_Medida;
    }

    public void setId_Unidad_Medida(int Id_Unidad_Medida) {
        this.Id_Unidad_Medida = Id_Unidad_Medida;
    }

    public BigDecimal getCantidad() {
        return Cantidad;
    }

    public void setCantidad(BigDecimal Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getId_Alimento() {
        return Id_Alimento;
    }

    public void setId_Alimento(int Id_Alimento) {
        this.Id_Alimento = Id_Alimento;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    public int getId_Usuario_Alta() {
        return Id_Usuario_Alta;
    }

    public void setId_Usuario_Alta(int Id_Usuario_Alta) {
        this.Id_Usuario_Alta = Id_Usuario_Alta;
    }

    public Timestamp getFecha_Alta() {
        return Fecha_Alta;
    }

    public void setFecha_Alta(Timestamp Fecha_Alta) {
        this.Fecha_Alta = Fecha_Alta;
    }

    public int getId_Usuario_Modif() {
        return Id_Usuario_Modif;
    }

    public void setId_Usuario_Modif(int Id_Usuario_Modif) {
        this.Id_Usuario_Modif = Id_Usuario_Modif;
    }

    public Timestamp getFecha_Modif() {
        return Fecha_Modif;
    }

    public void setFecha_Modif(Timestamp Fecha_Modif) {
        this.Fecha_Modif = Fecha_Modif;
    }

    public int getId_Usuario_Baja() {
        return Id_Usuario_Baja;
    }

    public void setId_Usuario_Baja(int Id_Usuario_Baja) {
        this.Id_Usuario_Baja = Id_Usuario_Baja;
    }

    public Timestamp getFecha_Baja() {
        return Fecha_Baja;
    }

    public void setFecha_Baja(Timestamp Fecha_Baja) {
        this.Fecha_Baja = Fecha_Baja;
    }
    
    
}
