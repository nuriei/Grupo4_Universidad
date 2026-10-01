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
public class Alumno {
    private int id = -1;
    private int dni;
    private String apellido;
    private String nombre;
    private LocalDate fecNac;
    private boolean activo;

    public Alumno() {
    }
    
    public Alumno(int dni, String apellido, String nombre, LocalDate fecNac, boolean activo) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fecNac = fecNac;
        this.activo = activo;
        this.id = -1;
    }
        public Alumno( int id, int dni, String apellido, String nombre, LocalDate fecNac, boolean activo) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fecNac = fecNac;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public String toString(){
        return id+"-"+nombre+"-"+apellido+" dni: "+dni+" fecha de nacimiento: "+fecNac+" esta activo? "+activo;
    }
}
