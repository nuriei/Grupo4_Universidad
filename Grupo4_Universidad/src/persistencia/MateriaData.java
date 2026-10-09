/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nuri
 */
public class MateriaData {
     private Connection con = null; //atributo conexion

    public MateriaData(miConexion conec) {  
        this.con = (Connection) conec.buscarConexion();//establecemos la conexion con el constructor
    }
    
    //aca iria guardar materia
    
    
    //aca listar materia
    
    //aca buscar materia por nombre
    
    
    //aca baja materia
   
    
    //aca alta materia
    
    
    //aca eliminar materia
   
}
