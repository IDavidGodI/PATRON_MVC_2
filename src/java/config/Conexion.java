 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author PAHUENA
 */
public class Conexion {
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String SERVER_NAME = "SI\\SQLEXPRESS"; //Es el nombre que permite autenticarse con Windows en SQL Server
  
    private static final String PORT_NUMBER = "1433"; // Es el puerto en el que el servicio de SQL Server se encuentra corriendo
    private static final String DATABASE_NAME = "UCC"; // Es el nombre de la base de datos a la que se desea conectar dentro del servidor
    private static final String URL = "jdbc:sqlserver://" + SERVER_NAME + ":" + PORT_NUMBER + ";databaseName=" + DATABASE_NAME+";TrustServerCertificate=True";
    
    private static final String USERNAME = "admin"; // Es el nombre del usuario que debe estar creado en SQL Server
   
    private static final String PASSWORD = "admin";
  
    
    //Método para establecer la conexión
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
    
    // Método para cerrar la conexión
    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            System.out.println("conectado");
           connection.close();
        }
    }

   

   
}
