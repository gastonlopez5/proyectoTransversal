/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoabasededatos.modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author programador
 */
public class Prueba {
    
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Conexion conexion = new Conexion("jdbc:mysql://localhost/universidad", "root", "");
            CursadaData cd = new CursadaData(conexion);
            
            List<Materia> lista = cd.obtenerMateriasCursadas(2);
            
            for (Materia item:lista){
                System.out.println(item.getNombre());
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
