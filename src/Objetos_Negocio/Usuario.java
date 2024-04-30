/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos_Negocio;

/**
 *
 * @author nisit
 */
public class Usuario {
    private int Id_Usuario;
    private String Nombre_Usuario;
    private String Contraseña;
    private int Cohabitantes;

    public Usuario() {
    }

    public Usuario(String Nombre_Usuario, String Contraseña, int Cohabitantes) {
        this.Nombre_Usuario = Nombre_Usuario;
        this.Contraseña = Contraseña;
        this.Cohabitantes = Cohabitantes;
    }

    public Usuario(String Nombre_Usuario, String Contraseña) {
        this.Nombre_Usuario = Nombre_Usuario;
        this.Contraseña = Contraseña;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public int getCohabitantes() {
        return Cohabitantes;
    }

    public void setCohabitantes(int Cohabitantes) {
        this.Cohabitantes = Cohabitantes;
    }
    
    
}
