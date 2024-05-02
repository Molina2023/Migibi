/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BackEnd;

/**
 *
 * @author nisit
 */
import Objetos_Negocio.Cat_Alimento;
import Objetos_Negocio.vw_Stock_Detalle_Disponible;
import Reglas_Negocio.RN_Cat_Alimento;
import Reglas_Negocio.RN_vw_Receta_Detalle_Disponible;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MigibiV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Prueba del método RN_Cat_Alimento.Consultar_Alimento();
           
        RN_vw_Receta_Detalle_Disponible fun = new RN_vw_Receta_Detalle_Disponible();
        List<vw_Stock_Detalle_Disponible> listaRecetas = new ArrayList<>();
        listaRecetas = fun.Consultar_Recetas_Disponible();
        
        for (int i = 0; i < listaRecetas.size(); i++) {
            System.out.println(listaRecetas.get(i).getId_Stock_Detalle());
        }
        
        
        /* //Prueba RN_Cat_Alimento.Consultar_Alimento(1);
        RN_Cat_Alimento RN_Cat_Alimento = new RN_Cat_Alimento();
        Cat_Alimento alimento = new Cat_Alimento();
        alimento = RN_Cat_Alimento.Consultar_Alimento(1);
        System.out.println("Id: "+alimento.getId_Alimento());
        System.out.println("Id_Tipo_Alimento: "+alimento.getId_Alimento());
        System.out.println("Alimento: "+alimento.getAlimento());
        System.out.println("Activo: "+alimento.isActivo());
        System.out.println("Id_Usuario_Alta: "+alimento.getId_Usuario_Alta());
        System.out.println("Fecha_Alta: "+alimento.getFecha_Alta());
        System.out.println("Id_Usuario_Modif: "+alimento.getId_Usuario_Modif());
        System.out.println("Fecha_Modif: "+alimento.getFecha_Modif());
        System.out.println("Id_Usuario_Baja: "+alimento.getId_Usuario_Baja());
        System.out.println("Fecha_Baja: "+alimento.getFecha_Baja());
        System.out.println("Es_Perecedero: "+alimento.isEs_Perecedero());
        */
        /*// Prueba del método Crear_Alimento
        RN_Cat_Alimento RN_Cat_Alimento = new RN_Cat_Alimento();
        Cat_Alimento alimento = new Cat_Alimento(2, "Fresa", true, 1 , new java.sql.Timestamp(new java.util.Date().getTime()), true);
        RN_Cat_Alimento.Crear_Alimento(alimento);
        */
        /* //Prueba del método Eliminar
        RN_Cat_Alimento RN_Cat_Alimento = new RN_Cat_Alimento();
        Cat_Alimento alimentoModif = new Cat_Alimento(5, 2, "Mango", true, 1 , new java.sql.Timestamp(new java.util.Date().getTime()), true);
        RN_Cat_Alimento.actualizarAlimento(alimentoModif);
        */
        /* //Prueba del método Eliminar
        RN_Cat_Alimento RN_Cat_Alimento = new RN_Cat_Alimento();
        Cat_Alimento alimentoElim = new Cat_Alimento(5, 2, "Mango", true, 1 , new java.sql.Timestamp(new java.util.Date().getTime()), true);
        RN_Cat_Alimento.Eliminar_Alimento(alimentoElim);
        */
    }
    
}
