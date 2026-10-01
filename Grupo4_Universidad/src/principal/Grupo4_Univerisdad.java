/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import entidades.Alumno;
import persistencia.AlumnoData;
import java.time.LocalDate;
import persistencia.miConeccion;

public class Grupo4_Univerisdad {

   
 
   
    private AlumnoData alumnoData;
    private miConeccion conexion;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        LocalDate fecha = LocalDate.now();
        Alumno estudioso = new Alumno(28180533, "Salas","Mariano", LocalDate.now(),false); // entidad
        new Grupo4_Univerisdad().conectar(estudioso);
        System.out.println("Alumno "+ estudioso.getNombre() + " guardado con exito");
    } 
    
    void conectar(Alumno estudioso){
           //conexionS = conexionS.buscarConexion();
           
          //conexion = new miConexion("jdbc:mariadb://localhost/universidad", "root", ""); 
           conexion = new miConeccion("jdbc:mysql://localhost/vera_barz_universidad", "root", "");  // construct 
           alumnoData = new AlumnoData(conexion);   // alumno
           alumnoData.guardarAlumno(estudioso);     // persistencia
           /*Alumno alu = alumnoData.buscarAlumno(estudioso.getId());*/
          /* System.out.println("Datos: "+ alu);*/
    }
}

