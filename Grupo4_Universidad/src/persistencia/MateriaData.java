
package persistencia;

import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MateriaData {
     private Connection con = null; //atributo conexion

    public MateriaData(miConexion conec) {  
        this.con = (Connection) conec.buscarConexion();//establecemos la conexion con el constructor
    }
    
    //Metodo guardar materia
    public void guardarMateria(Materia m) {
    // Consulta SQL con los campos de la tabla 'materia'
    String sql = "INSERT INTO materia(nombre, estado) VALUES (?,?)"; 
    
    try {
         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
         ps.setString(1, m.getNombre());
         ps.setBoolean(2, m.isActivo()); 
        
         ps.executeUpdate();     
        
       
        ResultSet rs = ps.getGeneratedKeys();  
        
        if (rs.next()) {
            m.setId_materia(rs.getInt(1)); // Asigna el id_materia generado por MySQL a tu objeto
            System.out.println("materia" + m.getNombre() + " ID: " + m.getId_materia() + " agregada con exito");
        } else {
            System.out.println("no se pudo obtener el ID autogenerado para la materia");
        }
        
        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al insertar materia: " + ex.getMessage());    
    }
}
    
    //aca listar materia
    public List<Materia> listarMaterias(boolean condicion) {
    List<Materia> listaMaterias = new ArrayList<>();
    String sql = "SELECT * FROM materia WHERE estado = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setBoolean(1, condicion); // <-- Le pasamos el true o false recibido
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Materia materia = new Materia();
            materia.setId_materia(rs.getInt("id_materia"));
            materia.setNombre(rs.getString("nombre"));
            materia.setActivo(rs.getBoolean("estado")); 
            
            listaMaterias.add(materia);
        }
        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al acceder a la tabla materia para listarla: " + ex.getMessage());
    }
    return listaMaterias;
}
    
    //buscar materia por nombre
    public Materia buscarMateriaPorNombre(String nombreBuscar) {
    Materia materia = null; // Si no encuentra nada, retornará null

    String sql = "SELECT id_materia, nombre, estado FROM materia WHERE nombre = ?";
    PreparedStatement ps = null;

    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, nombreBuscar); 
        
        ResultSet rs = ps.executeQuery(); 

        if (rs.next()) { // Si encontró la materia exacta
            materia = new Materia();
            materia.setId_materia(rs.getInt("id_materia")); 
            materia.setNombre(rs.getString("nombre"));
            materia.setActivo(rs.getBoolean("estado")); 
            
            System.out.println("materia encontrada: " + materia.toString());
        } else {
            System.out.println("no se encontro la materia con el nombre: " + nombreBuscar);
        }
        ps.close();

    } catch (SQLException ex) { 
        System.out.println("no se pudo acceder a la base de datos para buscar la materia: " + ex.getMessage());
    }

    return materia;
}
    // Buscar materia por ID
    public Materia buscarMateriaPorId(int id) {
        Materia materia = null;
        String sql = "SELECT id_materia, nombre, estado FROM materia WHERE id_materia = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setId_materia(rs.getInt("id_materia"));
                materia.setNombre(rs.getString("nombre"));
                materia.setActivo(rs.getBoolean("estado"));
                
                System.out.println("materia encontrada id: : " + materia.toString());
            } else {
                System.out.println("no se encontro materia con el siguiente id:  " + id);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("ni se pudo acceder a la bd " + ex.getMessage());
        }

        return materia;
    }
    
    
    public void bajaMateria(int id) {       
    String sql = "UPDATE materia SET estado = false WHERE id_materia = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        int exito = ps.executeUpdate();
        if (exito == 1) {
            System.out.println("La materia fue dada de baja");
            //JOptionPane.showMessageDialog(null,"Materia Eliminada");
        }
        ps.close();
    }
    catch (SQLException ex) {
        System.out.println("No se puede acceder a la base de datos");
        //JOptionPane.showMessageDialog (null, "Error"); 
    }
}
   
    
    public void altaMateria(int id) {       
    String sql = "UPDATE materia SET estado = true WHERE id_materia = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id); // a la incognita 1 le paso el valor de id
        
        int altaDada = ps.executeUpdate();
        
        if (altaDada == 1) {//si detecta un cambio la variable toma el valor 1
            System.out.println("materia id " + id + " ahora está activa");
        } else {
            System.out.println("se encontró el id de la materia, pero no se modificó porque ya estaba activa o el id no existe");
        }
        
        ps.close();
    } catch (SQLException ex) {
        System.out.println("error al intentar activar materia " + ex.getMessage()); 
    }
}
    
    
    public void eliminarMateriaBaseDatos(int id) {       
    String sql = "DELETE FROM materia WHERE id_materia = ?";
    
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int materiaEliminada = ps.executeUpdate();

            if (materiaEliminada == 1) {//aca lo mismo la variable toma valor 1 si hay un cambio
                System.out.println("se elimino la materia con el id " + id + " definitivamente de la base de datos");
            } else {
                //si no si queda en cero porque no hizo cambios o no lo encontro queda en 0
                System.out.println("el id " + id + " no se pudo borrar o no existe");
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al intentar eliminar la materia " + ex.getMessage()); 
        }
    }
   
}
