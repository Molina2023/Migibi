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
public class Stock_Detalle {
    /*
    Id_Stock_Detalle int primary key auto_increment,
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
    private int Id_Stock_Detalle;
    private int Id_Unidad_Medida;
    private BigDecimal Cantidad;
    private BigDecimal Total;
    private BigDecimal Cantidad_Consumida;
    private Timestamp Fecha_Caducidad;
    private boolean Es_Perecedero;
    private int Id_Alimento;
    
    private boolean Activo;
    private int Id_Usuario_Alta;
    private Timestamp Fecha_Alta;
    private int Id_Usuario_Modif;
    private Timestamp Fecha_Modif;
    private int Id_Usuario_Baja;
    private Timestamp Fecha_Baja;

    public Stock_Detalle() {
    }

    public Stock_Detalle(int Id_Unidad_Medida, BigDecimal Cantidad, Timestamp Fecha_Caducidad, boolean Es_Perecedero, int Id_Alimento, int Id_Usuario_Alta, Timestamp Fecha_Alta) {
        
        this.Id_Unidad_Medida = Id_Unidad_Medida;
        this.Cantidad = Cantidad;
        this.Fecha_Caducidad = Fecha_Caducidad;
        this.Es_Perecedero = Es_Perecedero;
        this.Id_Alimento = Id_Alimento;
        this.Id_Usuario_Alta = Id_Usuario_Alta;
        this.Fecha_Alta = Fecha_Alta;
    }

    public Stock_Detalle(int Id_Stock_Detalle, int Id_Unidad_Medida, BigDecimal Cantidad, BigDecimal Total, BigDecimal Cantidad_Consumida, Timestamp Fecha_Caducidad, boolean Es_Perecedero, int Id_Alimento, int Id_Usuario_Modif) {
        this.Id_Stock_Detalle = Id_Stock_Detalle;
        this.Id_Unidad_Medida = Id_Unidad_Medida;
        this.Cantidad = Cantidad;
        this.Total = Total;
        this.Cantidad_Consumida = Cantidad_Consumida;
        this.Fecha_Caducidad = Fecha_Caducidad;
        this.Es_Perecedero = Es_Perecedero;
        this.Id_Alimento = Id_Alimento;
        this.Id_Usuario_Modif = Id_Usuario_Modif;
    }

    public Stock_Detalle(int Id_Stock_Detalle, BigDecimal Cantidad, BigDecimal Cantidad_Consumida, int Id_Usuario_Modif) {
        this.Id_Stock_Detalle = Id_Stock_Detalle;
        this.Cantidad = Cantidad;
        this.Cantidad_Consumida = Cantidad_Consumida;
        this.Id_Usuario_Modif = Id_Usuario_Modif;
    }

    public int getId_Stock_Detalle() {
        return Id_Stock_Detalle;
    }

    public void setId_Stock_Detalle(int Id_Stock_Detalle) {
        this.Id_Stock_Detalle = Id_Stock_Detalle;
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

    public BigDecimal getTotal() {
        return Total;
    }

    public void setTotal(BigDecimal Total) {
        this.Total = Total;
    }

    public BigDecimal getCantidad_Consumida() {
        return Cantidad_Consumida;
    }

    public void setCantidad_Consumida(BigDecimal Cantidad_Consumida) {
        this.Cantidad_Consumida = Cantidad_Consumida;
    }

    public Timestamp getFecha_Caducidad() {
        return Fecha_Caducidad;
    }

    public void setFecha_Caducidad(Timestamp Fecha_Caducidad) {
        this.Fecha_Caducidad = Fecha_Caducidad;
    }

    public boolean isEs_Perecedero() {
        return Es_Perecedero;
    }

    public void setEs_Perecedero(boolean Es_Perecedero) {
        this.Es_Perecedero = Es_Perecedero;
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
