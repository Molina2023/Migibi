/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author nisit
 */
public class Enum {
    
    public enum Unidad {
        KILOS,
        CUDAS,
        CUDITAS,
        LITROS,
        GRAMOS,
        TAZAS;
    }
    
    public enum Clasificacion {
        FRUTA,
        VEGETAL,
        LACTEO,
        CEREAL,
        ESPECIE,
        MARISCO; 
    }
    
    public enum Dificultad {
        FACIL,
        INTERMEDIO,
        AVANZADO;
    }
    
    public enum Comida {
        DESAYUNO,
        ALMUERZO,
        COMIDA,
        MERIENDA,
        CENA,
        BEBIDA,
        POSTRE,
    }
    
    public enum Preferencias {
        VEGANO,
        VEGETARIANO,
        OMNIVORO,
        CELIACO,
    }
}
