
package principal;

import entidades.Alumno;
import entidades.Cursada;
import entidades.Materia;
import persistencia.AlumnoData;
import persistencia.CursadaData;
import persistencia.MateriaData;
import persistencia.miConexion;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class TestCursada {

    public static void main(String[] args) {
        // TODO code application logic here
        miConexion conexion = new miConexion("jdbc:mysql://localhost:3306/grupo4_universidad", "root", "");
        AlumnoData alumnoData = new AlumnoData(conexion);
        MateriaData materiaData = new MateriaData(conexion);
        CursadaData cursadaData = new CursadaData(conexion);
        
        int idAlumnoPrueba = 1; //segun bd salas mariano
        int idMateriaPrueba = 4; //segun bd laboratorio I
        
        Alumno alumno = alumnoData.buscarAlumnoId(idAlumnoPrueba);
        Materia materia = materiaData.buscarMateriaPorId(idMateriaPrueba);
        
       // System.out.println("------------------------se trata de inscribir un alumno a la materia-----------------------");
        //Cursada nuevaCursada = new Cursada(alumno, materia, 6.0f, 95.0f, LocalDate.of(2026, Month.MARCH, 13));
        //cursadaData.guardarCursada(nuevaCursada);
        //System.out.println("----------------listado de materias cursadas por cierto alumno---------------------------------");
        //List<Materia> materiasCursadas = cursadaData.obtenerMateriasCursadas(idAlumnoPrueba);
        //    for (Materia m : materiasCursadas) {
        //        System.out.println("  " + m.getNombre());
        //    }
//        System.out.println("-------------actualizado de notas---------");
//        List<Cursada> listaCursadas = cursadaData.obtenerCursadas();
//
//        for (Cursada c : listaCursadas) {
//            int idAlumno = c.getAlumno().getId();
//            String nombreMateria = c.getMateria().getNombre();
//
//           
//            float notaDelAlumno = c.getNota();
//
//            System.out.println("Alumno ID: " + idAlumno + " | Materia: " + nombreMateria + " | Nota: " + notaDelAlumno);
//        }
//        
//        
//        cursadaData.actualizarNota(idAlumnoPrueba, idMateriaPrueba, 9f);
//        float notaDespues = 0.0f;
//        for (entidades.Cursada c : cursadaData.obtenerCursadas()) {
//            if (c.getAlumno().getId() == idAlumnoPrueba && c.getMateria().getId_materia() == idMateriaPrueba) {
//                notaDespues = c.getNota();
//                break;
//            }
//        }
//        System.out.println("despues: " + notaDespues);
            System.out.println("---------------------------------lista las incripciones-----------------------------------");
            List<Cursada> listaGeneral = cursadaData.obtenerCursadas();
            for (Cursada c : listaGeneral) {
                System.out.println(c.getMateria().getNombre());
            }
           System.out.println("-------------------materias q no cursa el alumno-----------------");
            List<Materia> materiasNoCursadas = cursadaData.obtenerMateriasNoCursadas(idAlumnoPrueba);
            for (Materia m : materiasNoCursadas) {
                System.out.println(" - " + m.getNombre());
            }
}
}
