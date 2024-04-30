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
public class Cat_Tipo_Alimento {
    private int Id_Tipo_Alimento;
    private String Tipo_Alimento;
            
    private boolean Activo;
    private int Id_Usuario_Alta;
    private Timestamp Fecha_Alta;
    private int Id_Usuario_Modif;
    private Timestamp Fecha_Modif;
    private int Id_Usuario_Baja;
    private Timestamp Fecha_Baja;

    public Cat_Tipo_Alimento() {
    }
    
    public Cat_Tipo_Alimento(String Tipo_Alimento, boolean Activo, int Id_Usuario_Alta, Timestamp Fecha_Alta) {
        this.Tipo_Alimento = Tipo_Alimento;
        this.Activo = Activo;
        this.Id_Usuario_Alta = Id_Usuario_Alta;
        this.Fecha_Alta = Fecha_Alta;
    }

    public Cat_Tipo_Alimento(int Id_Tipo_Alimento, String Tipo_Alimento, boolean Activo, int Id_Usuario_Modif, Timestamp Fecha_Modif) {
        this.Id_Tipo_Alimento = Id_Tipo_Alimento;
        this.Tipo_Alimento = Tipo_Alimento;
        this.Activo = Activo;
        this.Id_Usuario_Modif = Id_Usuario_Modif;
        this.Fecha_Modif = Fecha_Modif;
    }
    
    
    
    public int getId_Tipo_Alimento() {
        return Id_Tipo_Alimento;
    }

    public void setId_Tipo_Alimento(int Id_Tipo_Alimento) {
        this.Id_Tipo_Alimento = Id_Tipo_Alimento;
    }

    public String getTipo_Alimento() {
        return Tipo_Alimento;
    }

    public void setTipo_Alimento(String Tipo_Alimento) {
        this.Tipo_Alimento = Tipo_Alimento;
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
