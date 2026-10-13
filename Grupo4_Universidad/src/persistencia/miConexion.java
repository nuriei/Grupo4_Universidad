
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class miConexion {
//    private String url;
//    private String usuario; //
//    private String password;
//    
//    private static Connection conexion = null;  // lo que importa  
//    
//    public miConexion(String url, String usr, String pass){     
//        this.url= url;  
//        usuario=usr;
//        password=pass;
//    }
//    public Connection buscarConexion(){
//        if (conexion==null) {  // si es la primera vez
//            try {
//                //cargamos las clases de mariadb que implementan JDBC
//                    Class.forName("com.mysql.jdbc.Driver");
//                //  Class.forName("org.mariadb.jdbc.Driver");  // 1
//                conexion = DriverManager.getConnection(url, usuario, password);  // 2
//            } catch (SQLException | ClassNotFoundException ex) {  // si me olvide de importar la libreria // error al cargar los drivers
//                System.out.println("No se puede conectar o no se puede cargar el driver. Error: "+ ex.getMessage());
//            }
//        }
//        return conexion; // retorna la conexion establecida
//    }
    private String url;
    private String usuario; 
    private String password;
    
    private static Connection conexion = null;  
    
    public miConexion(String url, String usr, String pass){     
        this.url = url;  
        usuario = usr;
        password = pass;
    }
    
    public Connection buscarConexion(){
        if (conexion == null) {  
            try {
                // Usamos el driver clásico que coincide con el mensaje de error de tu entorno
                Class.forName("com.mysql.jdbc.Driver"); 
                
                conexion = DriverManager.getConnection(url, usuario, password);  
                System.out.println("¡Conexión establecida con éxito a la base de datos!");
            } catch (SQLException | ClassNotFoundException ex) {  
                System.out.println("No se puede conectar o no se puede cargar el driver. Error: " + ex.getMessage());
            }
        }
        return conexion; 
    }
}

