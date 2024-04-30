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
public class Compras {
    /*
    Id_Compras int primary key auto_increment,
    Id_Usuario_Compra int not null,
    Id_Unidad_Medida int not null,
    Fecha_Compra datetime not null,
    Cantidad decimal null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    */
    private int Id_Compras;
    private int Id_Usuario_Compra;
    private int Id_Unidad_Medida;
    private Timestamp Fecha_Compra;
    private BigDecimal Cantidad;
    
    private boolean Activo;
    private int Id_Usuario_Alta;
    private Timestamp Fecha_Alta;
    private int Id_Usuario_Modif;
    private Timestamp Fecha_Modif;
    private int Id_Usuario_Baja;
    private Timestamp Fecha_Baja;

    public Compras() {
    }

    public Compras(int Id_Usuario_Compra, int Id_Unidad_Medida, Timestamp Fecha_Compra, BigDecimal Cantidad, boolean Activo, int Id_Usuario_Alta, Timestamp Fecha_Alta) {
        this.Id_Usuario_Compra = Id_Usuario_Compra;
        this.Id_Unidad_Medida = Id_Unidad_Medida;
        this.Fecha_Compra = Fecha_Compra;
        this.Cantidad = Cantidad;
        this.Activo = Activo;
        this.Id_Usuario_Alta = Id_Usuario_Alta;
        this.Fecha_Alta = Fecha_Alta;
    }

    public Compras(int Id_Compras, int Id_Usuario_Compra, int Id_Unidad_Medida, Timestamp Fecha_Compra, BigDecimal Cantidad, boolean Activo, int Id_Usuario_Modif, Timestamp Fecha_Modif) {
        this.Id_Compras = Id_Compras;
        this.Id_Usuario_Compra = Id_Usuario_Compra;
        this.Id_Unidad_Medida = Id_Unidad_Medida;
        this.Fecha_Compra = Fecha_Compra;
        this.Cantidad = Cantidad;
        this.Activo = Activo;
        this.Id_Usuario_Modif = Id_Usuario_Modif;
        this.Fecha_Modif = Fecha_Modif;
    }
    
    public int getId_Compras() {
        return Id_Compras;
    }

    public void setId_Compras(int Id_Compras) {
        this.Id_Compras = Id_Compras;
    }

    public int getId_Usuario_Compra() {
        return Id_Usuario_Compra;
    }

    public void setId_Usuario_Compra(int Id_Usuario_Compra) {
        this.Id_Usuario_Compra = Id_Usuario_Compra;
    }

    public int getId_Unidad_Medida() {
        return Id_Unidad_Medida;
    }

    public void setId_Unidad_Medida(int Id_Unidad_Medida) {
        this.Id_Unidad_Medida = Id_Unidad_Medida;
    }

    public Timestamp getFecha_Compra() {
        return Fecha_Compra;
    }

    public void setFecha_Compra(Timestamp Fecha_Compra) {
        this.Fecha_Compra = Fecha_Compra;
    }

    public BigDecimal getCantidad() {
        return Cantidad;
    }

    public void setCantidad(BigDecimal Cantidad) {
        this.Cantidad = Cantidad;
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
