/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoabasededatos.modelo;

import accesoabasededatos.modelo.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejo
 */
public class AlumnoData {
    private Connection connection = null;

    public AlumnoData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    
    public void guardarAlumno(Alumno alumno){
        try {
            
            String sql = "INSERT INTO alumno (nombre, fecNac, activo) VALUES ( ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, alumno.getNombre());
            statement.setDate(2, Date.valueOf(alumno.getFecNac()));
            statement.setBoolean(3, alumno.getActivo());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                alumno.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un alumno");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
    }
    
    public List<Alumno> obtenerAlumnos(){
        List<Alumno> alumnos = new ArrayList<Alumno>();
            

        try {
            String sql = "SELECT * FROM alumno;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Alumno alumno;
            while(resultSet.next()){
                alumno = new Alumno();
                alumno.setId(resultSet.getInt("idAlumno"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setFecNac(resultSet.getDate("fecNac").toLocalDate());
                alumno.setActivo(resultSet.getBoolean("activo"));

                alumnos.add(alumno);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
        
        
        return alumnos;
    }
    
    public void borrarAlumno(int id){
    try {
            
            String sql = "DELETE FROM alumno WHERE idAlumno =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarAlumno(Alumno alumno){
    
        try {
            
            String sql = "UPDATE alumno SET nombre =?, fecNac =? , activo =? WHERE idAlumno = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, alumno.getNombre());
            statement.setDate(2, Date.valueOf(alumno.getFecNac()));
            statement.setBoolean(3, alumno.getActivo());
            statement.setInt(4, alumno.getId());
            statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
    
    }
    
    public Alumno buscarAlumno(int id){
    Alumno alumno=null;
    try {
            
            String sql = "SELECT * FROM alumno WHERE idAlumno =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                alumno = new Alumno();
                alumno.setId(resultSet.getInt("idAlumno"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setFecNac(resultSet.getDate("fecNac").toLocalDate());
                alumno.setActivo(resultSet.getBoolean("activo"));

                
            }      
            statement.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        
        return alumno;
    }
    
}
