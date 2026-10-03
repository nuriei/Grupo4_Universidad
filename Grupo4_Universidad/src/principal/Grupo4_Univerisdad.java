/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import entidades.Alumno;
import persistencia.AlumnoData;
import java.time.LocalDate;
import persistencia.miConexion;

public class Grupo4_Univerisdad {
   
    private AlumnoData alumnoData;//variable q se usa para la conexion
    private miConexion conexion;//igual
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        LocalDate fecha = LocalDate.now(); //se usa solo si quiero ponerle a la fecha de nacimiento la fecha de hoy
        //Alumno estudioso = new Alumno(41879635, "costa","Carlos", LocalDate.now(),true); // como en este caso si no se pasa por parametro en el constructor
       
        Alumno estudioso = new Alumno(35999888, "Garrido", "Sandra", LocalDate.of(2000, 3, 15), true);//esta es otra forma de crear un alumno donde le paso la fecha con localDate.of
        //importante q la linea de arriba donde instancio un alumno se comente si ya existe o si no quiero agregar otro alumno y solo quiero listar lo que tengo en la bd
        new Grupo4_Univerisdad().conectar(estudioso);//con esto llamo el metodo conectar q conecta a la base de datos
    } 

    void conectar(Alumno estudioso) {
        
        conexion = new miConexion("jdbc:mysql://localhost:3306/grupo4_universidad", "root", ""); //aca accedo a la base de datos
        alumnoData = new AlumnoData(conexion);   //instancio un alumno data

        //alumnoData.guardarAlumno(estudioso); //aca guardo el alumno pasandole el estudioso q viene de la linea 25 por eso el metodo recibe por parametro estudioso
        System.out.println("-------------------------------------lista de mi sql local------------------------------------------------");
        alumnoData.listarAlumnos();//esto es empleando el metodo de listar alumno de la clase lista data q recorre la tabla de sql y los trae e imprime
        System.out.println("--------------------------------------busqueda de alumno por id-------------------------------------------");
        alumnoData.buscarAlumnoId(5);
         
    }
           
       
             

}

