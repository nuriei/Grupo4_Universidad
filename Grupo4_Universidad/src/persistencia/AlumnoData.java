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

    public AlumnoData(miConexion conec) {  
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
        
       //buscar alumno por id
    public Alumno buscarAlumnoId(int id) {
        Alumno alumno = null; //creo una variable del tipo alimno q si pasa algo lo inicia en null para q no haya error
    
        String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE id_alumno = ?";//consulta de sql(consultar si todos o solo los activos?)
        PreparedStatement ps = null;//variable p conexion

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id); //aca le digo q cambie de la consulta de arriba el ? por 1 q es la posicion en mi base de datos y le digo q se concentre en el numero que le paso por el parametro id
            ResultSet rs = ps.executeQuery(); 

            if (rs.next()) {//si encontro algo
                alumno = new Alumno();
                alumno.setId(id); // le carga los datos
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFecNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
                System.out.println("alumno encontrado sus datos son: "+alumno.toString());
            } else {
                System.out.println("No se encontro alumno");//aca iria el cartel cuando sea vista
            }
            ps.close();

        } catch (SQLException ex) { 
            System.out.println("no se pudo acceder a la base de datos");//esto tambien seria un joptionpane
        }

        return alumno;
    }
    
    public void actualizarAlumno(Alumno alumno) {

    
    String sql = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?, fechaNacimiento = ? WHERE id_alumno = ?";//modificacion en sql teniendo en cuenta q solo va a modificar lo q encuentre distinto, si no no se va a modificar nada
    PreparedStatement ps = null;

    try {
        ps = con.prepareStatement(sql);
        
        ps.setInt(1, alumno.getDni());
        ps.setString(2, alumno.getApellido());
        ps.setString(3, alumno.getNombre());
        ps.setDate(4, Date.valueOf(alumno.getFecNac()));
        ps.setInt(5, alumno.getId());
        //el activo lo dejaremos para la baja logica                    

        int modificado = ps.executeUpdate(); //aca pongo una variable q me guarda si se modifico algo o no para poder largar los carteles

        if (modificado == 1) {//porque 1 porque si modifico algo en la fila devuelve 1 si el UPDATE
            System.out.println("Alumno modificado exitosamente.");
            System.out.println("el alumno del id: "+alumno.getId()+" ahora esta actuaizado asi: "+alumno.toString());
        } else {
            System.out.println("No se encontró el alumno a modificar.");
        }

        ps.close();

    } catch (SQLException ex) {
        System.out.println("Error al acceder a la tabla Alumno: " + ex.getMessage());
    }
}


        
            
       
}
