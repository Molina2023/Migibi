/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.util.Date;
import java.sql.Time;

/**
 *
 * @author nisit
 */
public class Ingrediente {
    //Este es un comentario
    private String nombre;
    private int cantidad;
    private Enum.Unidad unidades;
    private Time caducidad;
    private Date FechaCompra;
    private Date FechaCaducidad;
    private Enum.Clasificacion clasificacion;

    public Ingrediente(String nombre, int cantidad, Enum.Unidad unidades, Time caducidad, Enum.Clasificacion clasificacion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidades = unidades;
        this.caducidad = caducidad;
        this.clasificacion = clasificacion;
    }

    public Ingrediente(String nombre, int cantidad, Enum.Unidad unidades, Time caducidad, Date FechaCompra, Date FechaCaducidad, Enum.Clasificacion clasificacion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidades = unidades;
        this.caducidad = caducidad;
        this.FechaCompra = FechaCompra;
        this.FechaCaducidad = FechaCaducidad;
        this.clasificacion = clasificacion;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Enum.Unidad getUnidades() {
        return unidades;
    }

    public void setUnidades(Enum.Unidad unidades) {
        this.unidades = unidades;
    }

    public Time getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Time caducidad) {
        this.caducidad = caducidad;
    }

    public Date getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(Date FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    public Enum.Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Enum.Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }
    
    
}
