/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bladimir
 */
public class conexionMysql {
    public static Connection conectar() throws SQLException{
        String url="jdbc:mysql://localhost:3306/practica1";
        return DriverManager.getConnection(url,"root","59012221");
    }
    public static void close(Connection cerrar){
        try {
            cerrar.close();
        } catch (SQLException eX) {
            
        }
    }
    public static void close(PreparedStatement cerrar){
        try {
            cerrar.close();
        } catch (SQLException eX) {
            
        }
    }
}
