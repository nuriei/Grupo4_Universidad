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

        
        String url = "jdbc:mysql://localhost:3306/universidad"; //  URL de la base de datoss
        String usuario = "root";                              // usuario de BD
        String password = "";                                  // contraseña de BD
        
        miConexion conexionHelper = new miConexion(url, usuario, password);

        // 2. Instanciamos MateriaData pasándole el helper de conexión
        MateriaData matData = new MateriaData(conexionHelper);
      }
}
