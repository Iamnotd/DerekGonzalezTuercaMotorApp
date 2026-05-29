package org.derekgonzalez.model.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/tuercamotor_in4cm?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Dkendry37.";
    
    public static Connection conectar(){
        Connection conexion = null;
        
        try {
            // driver de JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //crear la conexion 
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.print("ERROR: no hay driver");
        } catch (SQLException ex){
            System.err.print("ERROR: no se pudo conectar a la DB"+ ex.getMessage());
        }
        
        return conexion;
    }
}