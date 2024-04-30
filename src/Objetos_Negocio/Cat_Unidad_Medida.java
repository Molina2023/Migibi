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
public class Cat_Unidad_Medida {
    /*
    Id_Unidad_Medida int primary key auto_increment,
    Unidad_Medida varchar(50)  not null,
    Abreviatura varchar(5)  not null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    */
    
    private int Id_Unidad_Medida;
    private String Unidad_Medida;
    private String Abreviatura;
    
    private boolean Activo;
    private int Id_Usuario_Alta;
    private Timestamp Fecha_Alta;
    private int Id_Usuario_Modif;
    private Timestamp Fecha_Modif;
    private int Id_Usuario_Baja;
    private Timestamp Fecha_Baja;

    public Cat_Unidad_Medida() {
    }
    
    public Cat_Unidad_Medida(String Unidad_Medida, String Abreviatura, boolean Activo, int Id_Usuario_Alta, Timestamp Fecha_Alta) {
        this.Unidad_Medida = Unidad_Medida;
        this.Abreviatura = Abreviatura;
        this.Activo = Activo;
        this.Id_Usuario_Alta = Id_Usuario_Alta;
        this.Fecha_Alta = Fecha_Alta;
    }

    public Cat_Unidad_Medida(int Id_Unidad_Medida, String Unidad_Medida, String Abreviatura, boolean Activo, int Id_Usuario_Modif, Timestamp Fecha_Modif) {
        this.Id_Unidad_Medida = Id_Unidad_Medida;
        this.Unidad_Medida = Unidad_Medida;
        this.Abreviatura = Abreviatura;
        this.Activo = Activo;
        this.Id_Usuario_Modif = Id_Usuario_Modif;
        this.Fecha_Modif = Fecha_Modif;
    }

    public int getId_Unidad_Medida() {
        return Id_Unidad_Medida;
    }

    public void setId_Unidad_Medida(int Id_Unidad_Medida) {
        this.Id_Unidad_Medida = Id_Unidad_Medida;
    }

    public String getUnidad_Medida() {
        return Unidad_Medida;
    }

    public void setUnidad_Medida(String Unidad_Medida) {
        this.Unidad_Medida = Unidad_Medida;
    }

    public String getAbreviatura() {
        return Abreviatura;
    }

    public void setAbreviatura(String Abreviatura) {
        this.Abreviatura = Abreviatura;
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
