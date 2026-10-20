/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author Nuri
 */
public class Cursada {
    private int id_cursada=-1;
    private Alumno alumno;
    private Materia materia;
    private float nota;
    private float asis;
    private LocalDate cursa;

    public Cursada() {
    }

    public Cursada(Alumno alumno, Materia materia, float nota, float asis, LocalDate cursa) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.asis = asis;
        this.cursa = cursa;
    }

    public int getId_cursada() {
        return id_cursada;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public float getNota() {
        return nota;
    }

    public float getAsis() {
        return asis;
    }

    public LocalDate getCursa() {
        return cursa;
    }

    public void setId_cursada(int id_cursada) {
        this.id_cursada = id_cursada;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public void setAsis(float asis) {
        this.asis = asis;
    }

    public void setCursa(LocalDate cursa) {
        this.cursa = cursa;
    }

    @Override
    public String toString() {
        return "Cursada{" + "id_cursada=" + id_cursada + ", alumno=" + alumno + ", materia=" + materia + ", nota=" + nota + ", asis=" + asis + ", cursa=" + cursa + '}';
    }

    
}