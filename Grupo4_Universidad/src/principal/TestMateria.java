/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;


import entidades.Materia;
import persistencia.MateriaData;
import persistencia.miConexion;
import java.util.List;

public class TestMateria {
      public static void main(String[] args) {
        System.out.println("=== INICIANDO TEST DE CONSOLA PARA MATERIAS ===");

        
        String url = "jdbc:mysql://localhost:3306/grupo4_universidad"; //  URL de la base de datoss 
        String usuario = "root";                              // usuario de BD
        String password = "";                                  // contraseña de BD
        
        miConexion conexionHelper = new miConexion(url, usuario, password);

       // 2. Instanciamos MateriaData pasándole el helper de conexión
        MateriaData matData = new MateriaData(conexionHelper);
        
          System.out.println("Probando: insertar materia");
          Materia nuevaMateria = new Materia("Laboratorio de Programacion II", true);
          matData.guardarMateria(nuevaMateria);
          
          int idGenerado = nuevaMateria.getId_materia();
          
          if (idGenerado > 0){
          
              System.out.println("Probando:Buscar por Id");
              Materia matEncontradaId = matData.buscarMateriaPorId(idGenerado);
              
              System.out.println("Probando:Buscar por Nombre");
              Materia matEncontradaNombre = matData.buscarMateriaPorNombre("Laboratorio de programacion II");
              
              System.out.println("Probando: Alta logica de materia");
              matData.altaMateria(idGenerado);
              
              System.out.println("Listando materias activas");
              List<Materia> activas = matData.listarMaterias(true);
              for (Materia m : activas){
                  System.out.println(m);
              }
              
              System.out.println("Probando: Eliminar base de datos");
              matData.eliminarMateriaBaseDatos(idGenerado);
              
          }else{
              System.out.println("[ERROR] no se puede continuar con la verificacion porque no se genero in IDvalido");
          }  
          System.out.println("Testeo de Materia FINALIZADO");
      }
}
