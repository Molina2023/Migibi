/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos_Negocio;

import java.sql.Timestamp;

/**
 *
 * @author nisit
 */
public class Consumo {
    /*
    Id_Consumo int primary key auto_increment,
    Id_Receta int not null,
    Id_Usuario_Receta int not null,
    Fecha_Consumo datetime not null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    */
    private int Id_Consumo;
    private int Id_Receta;
    private int Id_Usuario_Receta;
    private Timestamp Fecha_Consumo;
    
    private boolean Activo;
    private int Id_Usuario_Alta;
    private Timestamp Fecha_Alta;
    private int Id_Usuario_Modif;
    private Timestamp Fecha_Modif;
    private int Id_Usuario_Baja;
    private Timestamp Fecha_Baja;

    public Consumo() {
    }

    
    public Consumo(int Id_Receta, int Id_Usuario_Receta, Timestamp Fecha_Consumo, boolean Activo, int Id_Usuario_Alta, Timestamp Fecha_Alta) {
        this.Id_Receta = Id_Receta;
        this.Id_Usuario_Receta = Id_Usuario_Receta;
        this.Fecha_Consumo = Fecha_Consumo;
        this.Activo = Activo;
        this.Id_Usuario_Alta = Id_Usuario_Alta;
        this.Fecha_Alta = Fecha_Alta;
    }

    public Consumo(int Id_Consumo, int Id_Receta, int Id_Usuario_Receta, Timestamp Fecha_Consumo, boolean Activo, int Id_Usuario_Modif, Timestamp Fecha_Modif) {
        this.Id_Consumo = Id_Consumo;
        this.Id_Receta = Id_Receta;
        this.Id_Usuario_Receta = Id_Usuario_Receta;
        this.Fecha_Consumo = Fecha_Consumo;
        this.Activo = Activo;
        this.Id_Usuario_Modif = Id_Usuario_Modif;
        this.Fecha_Modif = Fecha_Modif;
    }

    
    public int getId_Consumo() {
        return Id_Consumo;
    }

    public void setId_Consumo(int Id_Consumo) {
        this.Id_Consumo = Id_Consumo;
    }

    public int getId_Receta() {
        return Id_Receta;
    }

    public void setId_Receta(int Id_Receta) {
        this.Id_Receta = Id_Receta;
    }

    public int getId_Usuario_Receta() {
        return Id_Usuario_Receta;
    }

    public void setId_Usuario_Receta(int Id_Usuario_Receta) {
        this.Id_Usuario_Receta = Id_Usuario_Receta;
    }

    public Timestamp getFecha_Consumo() {
        return Fecha_Consumo;
    }

    public void setFecha_Consumo(Timestamp Fecha_Consumo) {
        this.Fecha_Consumo = Fecha_Consumo;
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
