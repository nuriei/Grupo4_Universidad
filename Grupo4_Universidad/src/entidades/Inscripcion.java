/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import entidades.Inscripcion;
import entidades.Materia;
import java.util.ArrayList;
import java.util.List;

public class Inscripcion {
    
    private int id_inscripcion;
    private Alumno alumno;   // Relación con la entidad Alumno
    private Materia materia; // Relación con la entidad Materia
    private double nota;
    
    public Inscripcion(){}

    public Inscripcion(int id_inscripcion, Alumno alumno, Materia materia, double nota) {
        this.id_inscripcion = id_inscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Inscripcion(Alumno alumno, Materia materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    @Override
    
    public String toString(){
    
        return "Inscripcion{" + "id_inscripcion=" + id_inscripcion + ", alumno=" + alumno.getApellido() + ", materia=" + materia.getNombre() + ", nota=" + nota + '}';
    }
}

    
    

