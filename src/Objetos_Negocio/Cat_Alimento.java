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
public class Cat_Alimento {
    /*
    Id_Alimento int primary key auto_increment,
    Id_Tipo_Alimento int not null,
    Id_Unidad_Medida int not null,
    Alimento varchar(250)  not null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    */
    
    private int Id_Alimento;
    private int Id_Tipo_Alimento;
    private String Alimento;
    private boolean Es_Perecedero;
            
    private boolean Activo;
    private int Id_Usuario_Alta;
    private Timestamp Fecha_Alta;
    private int Id_Usuario_Modif;
    private Timestamp Fecha_Modif;
    private int Id_Usuario_Baja;
    private Timestamp Fecha_Baja;

    public Cat_Alimento() {
    }
    
    public Cat_Alimento(int Id_Tipo_Alimento, String Alimento, boolean Activo, int Id_Usuario_Alta, Timestamp Fecha_Alta, boolean Es_Perecedero ) {
        this.Id_Tipo_Alimento = Id_Tipo_Alimento;
        this.Alimento = Alimento;
        this.Es_Perecedero = Es_Perecedero;
        this.Activo = Activo;
        this.Id_Usuario_Alta = Id_Usuario_Alta;
        this.Fecha_Alta = Fecha_Alta;
    }

    public Cat_Alimento(int Id_Alimento, int Id_Tipo_Alimento, String Alimento, boolean Activo, int Id_Usuario_Modif, Timestamp Fecha_Modif, boolean Es_Perecedero ) {
        this.Id_Alimento = Id_Alimento;
        this.Id_Tipo_Alimento = Id_Tipo_Alimento;
        this.Alimento = Alimento;
        this.Es_Perecedero = Es_Perecedero;
        this.Activo = Activo;
        this.Id_Usuario_Modif = Id_Usuario_Modif;
        this.Fecha_Modif = Fecha_Modif;
    }

    public Cat_Alimento(int Id_Alimento, int Id_Tipo_Alimento, String Alimento, boolean Activo, int Id_Usuario_Alta, Timestamp Fecha_Alta, int Id_Usuario_Modif, Timestamp Fecha_Modif, boolean Es_Perecedero ) {
        this.Id_Alimento = Id_Alimento;
        this.Id_Tipo_Alimento = Id_Tipo_Alimento;
        this.Alimento = Alimento;
        this.Es_Perecedero = Es_Perecedero;
        this.Activo = Activo;
        this.Id_Usuario_Alta = Id_Usuario_Alta;
        this.Fecha_Alta = Fecha_Alta;
        this.Id_Usuario_Modif = Id_Usuario_Modif;
        this.Fecha_Modif = Fecha_Modif;
    }

    public Cat_Alimento(int Id_Alimento, int Id_Tipo_Alimento, String Alimento, boolean Es_Perecedero, boolean Activo, int Id_Usuario_Alta, Timestamp Fecha_Alta, int Id_Usuario_Modif, Timestamp Fecha_Modif, int Id_Usuario_Baja, Timestamp Fecha_Baja) {
        this.Id_Alimento = Id_Alimento;
        this.Id_Tipo_Alimento = Id_Tipo_Alimento;
        this.Alimento = Alimento;
        this.Es_Perecedero = Es_Perecedero;
        this.Activo = Activo;
        this.Id_Usuario_Alta = Id_Usuario_Alta;
        this.Fecha_Alta = Fecha_Alta;
        this.Id_Usuario_Modif = Id_Usuario_Modif;
        this.Fecha_Modif = Fecha_Modif;
        this.Id_Usuario_Baja = Id_Usuario_Baja;
        this.Fecha_Baja = Fecha_Baja;
    }

    
    public int getId_Alimento() {
        return Id_Alimento;
    }

    public void setId_Alimento(int Id_Alimento) {
        this.Id_Alimento = Id_Alimento;
    }

    public int getId_Tipo_Alimento() {
        return Id_Tipo_Alimento;
    }

    public void setId_Tipo_Alimento(int Id_Tipo_Alimento) {
        this.Id_Tipo_Alimento = Id_Tipo_Alimento;
    }

    public String getAlimento() {
        return Alimento;
    }

    public void setAlimento(String Alimento) {
        this.Alimento = Alimento;
    }

    public boolean isEs_Perecedero() {
        return Es_Perecedero;
    }

    public void setEs_Perecedero(boolean Es_Perecedero) {
        this.Es_Perecedero = Es_Perecedero;
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
