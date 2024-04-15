/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.util.ArrayList;
import java.sql.Time;

/**
 *
 * @author nisit
 */
public class Receta {
    private String nombre;
    private ArrayList<Ingrediente> arrayIngredientes;
    private int porciones; //para cuántas personas es la receta
    private String instrucciones;
    private Time tiempo;
    private Enum.Dificultad dificultad;
    

    public Receta(String nombre, ArrayList arrayIngredientes, int porciones, String instrucciones) {
        this.nombre = nombre;
        this.arrayIngredientes = arrayIngredientes;
        this.porciones = porciones;
        this.instrucciones = instrucciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList getArrayIngredientes() {
        return arrayIngredientes;
    }

    public void setArrayIngredientes(ArrayList arrayIngredientes) {
        this.arrayIngredientes = arrayIngredientes;
    }

    public int getPorciones() {
        return porciones;
    }

    public void setPorciones(int porciones) {
        this.porciones = porciones;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    
}
