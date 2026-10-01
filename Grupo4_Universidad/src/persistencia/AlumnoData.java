/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Alumno;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
            
        if (rs.next()) {
                a.setId(rs.getInt(1)); // Asigna el id_alumno autogenerado por MySQL
                System.out.println("¡Alumno guardado con exito! ID: " + a.getId());
            } else {
                System.out.println("No se pudo obtener el ID autogenerado.");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar alumno: " + ex.getMessage());    
        }
        }
        public List <Alumno> listarAlumnos() {

            List<Alumno> listaAlumno = new ArrayList<>();
                
                    String sql = "SELECT * FROM alumno ";
                try {
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        Alumno alumno = new Alumno();

                        alumno.setId(rs.getInt("id_alumno"));
                        alumno.setDni(rs.getInt("dni"));
                        alumno.setApellido(rs.getString("apellido"));
                        alumno.setNombre(rs.getString("nombre"));
                        alumno.setFecNac(rs.getDate("fechaNacimiento").toLocalDate());
                        alumno.setActivo(rs.getBoolean("estado"));
                        listaAlumno.add(alumno);
                        System.out.println(alumno.toString());
                    }
                    ps.close();


                } catch (SQLException ex) {
                    System.out.println("no se pudo acceder a la tabla para listarla");
                }
                    return listaAlumno;
                }


        
            
       
}
