/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Alumno;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class AlumnoData {
    
    private Connection con = null;

    public AlumnoData(miConeccion conec) {  
        this.con = (Connection) conec.buscarConexion();
    }
        public void guardarAlumno(Alumno a){    // obj alumno sin id valido
        String sql = "INSERT INTO alumno(dni, apellido, nombre, fechaNacimiento, estado) VALUES (?,?,?,?,?)";  //1
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //2
            ps.setInt(1,a.getDni());
            ps.setString(2,a.getApellido());
            ps.setString(3,a.getNombre());
            ps.setDate(4, Date.valueOf(a.getFecNac()));
            ps.setBoolean(5,a.isActivo());
            ps.executeUpdate();     // 3
            
            ResultSet rs = ps.getGeneratedKeys();  // recupero y asigno
            if(rs.next())
                a.setId(rs.getInt(1));
            else
                System.out.println("No se pudo tener ID");
            ps.close();
            System.out.println("Guardado!");
        } catch (SQLException ex) {
            System.out.println("No pude insertar");    
        }
        
    } 
    
}
