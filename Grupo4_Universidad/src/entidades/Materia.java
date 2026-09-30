/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Nuri
 */
public class Materia {
    private int  id_materia;
    private String  nombre;
    private boolean  activo;

    public Materia(int id_materia, String nombre, boolean activo) {
        this.id_materia = id_materia;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getId_materia() {
        return id_materia;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Materia{" + "id_materia=" + id_materia + ", nombre=" + nombre + ", activo=" + activo + '}';
    }
    
    
    
}
