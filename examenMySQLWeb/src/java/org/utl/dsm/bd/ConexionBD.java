/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class ConexionBD {

    Connection conn;
    
    public Connection open() {
        String url = "jdbc:mysql://bujroxowx9toet7euphl-mysql.services.clever-cloud.com:3306/bujroxowx9toet7euphl";
        String user = "u6y5eevduuyf06vt";
        String password = "qjILuKYWevtdbRJPqzBv";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        }
        catch(Exception ex){
            throw new RuntimeException(ex);
        }}
    

    public void close()
    {
        try {
            conn.close();
            
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    
}
