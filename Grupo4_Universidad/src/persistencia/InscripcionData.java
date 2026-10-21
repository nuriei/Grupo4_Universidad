/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Inscripcion;
import entidades.Materia;
import java.util.ArrayList;
import java.util.List;

public class InscripcionData {

        private miConexion con;

    // Constructor que recibe tu helper de conexión
    public InscripcionData(miConexion con) {
        this.con = con;
    }

    public void guardarInscripcion(Inscripcion insc) { // Método para guardar una inscripción en la BD
        //lógica del INSERT de SQL más adelante
    }

    public List<Materia> obtenerMateriasCursadas(int idAlumno) {// Método para obtener las materias en las que el alumno SÍ está anotado
        List<Materia> materias = new ArrayList<>();
        // Lógica de consulta SQL
        return materias;
    }

    public List<Materia> obtenerMateriasNoCursadas(int idAlumno) { // Método para obtener las materias en las que el alumno NO está anotado
        List<Materia> materias = new ArrayList<>();
        // Lógica de consulta SQL
        return materias;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {// Método para borrar o anular una inscripción física de la BD
        //DELETE de SQL más adelante
    }

}