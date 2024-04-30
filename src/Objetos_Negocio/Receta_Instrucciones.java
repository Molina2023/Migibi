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
public class Receta_Instrucciones {
    /*
    Id_Receta_Instrucciones int primary key auto_increment,
    Id_Receta int not null,
    Instruccion varchar(3000) not null,
    Orden int not null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    */
    private int Id_Receta_Instrucciones;
    private int Id_Receta;
    private String Instruccion;
    private int Orden;
    
    private boolean Activo;
    private int Id_Usuario_Alta;
    private Timestamp Fecha_Alta;
    private int Id_Usuario_Modif;
    private Timestamp Fecha_Modif;
    private int Id_Usuario_Baja;
    private Timestamp Fecha_Baja;

    public Receta_Instrucciones() {
    }

    public Receta_Instrucciones(int Id_Receta, String Instruccion, int Orden, boolean Activo, int Id_Usuario_Alta, Timestamp Fecha_Alta) {
        this.Id_Receta = Id_Receta;
        this.Instruccion = Instruccion;
        this.Orden = Orden;
        this.Activo = Activo;
        this.Id_Usuario_Alta = Id_Usuario_Alta;
        this.Fecha_Alta = Fecha_Alta;
    }

    public Receta_Instrucciones(int Id_Receta_Instrucciones, int Id_Receta, String Instruccion, int Orden, int Id_Usuario_Modif) {
        this.Id_Receta_Instrucciones = Id_Receta_Instrucciones;
        this.Id_Receta = Id_Receta;
        this.Instruccion = Instruccion;
        this.Orden = Orden;
        this.Id_Usuario_Modif = Id_Usuario_Modif;
    }

    public int getId_Receta_Instrucciones() {
        return Id_Receta_Instrucciones;
    }

    public void setId_Receta_Instrucciones(int Id_Receta_Instrucciones) {
        this.Id_Receta_Instrucciones = Id_Receta_Instrucciones;
    }

    public int getId_Receta() {
        return Id_Receta;
    }

    public void setId_Receta(int Id_Receta) {
        this.Id_Receta = Id_Receta;
    }

    public String getInstruccion() {
        return Instruccion;
    }

    public void setInstruccion(String Instruccion) {
        this.Instruccion = Instruccion;
    }

    public int getOrden() {
        return Orden;
    }

    public void setOrden(int Orden) {
        this.Orden = Orden;
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
