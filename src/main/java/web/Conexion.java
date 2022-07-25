/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author alanh
 */
public class Conexion {
    //Requerimientos de castores
    private static final String JDBC_URL="jdbc:mysql://192.168.0.126:3306/castores_test_alan?useSSL=false&useTimezone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="password";
    //Uso interno
    /*private static final String JDBC_URL="jdbc:mysql://localhost:3306/castores_test_alan?useSSL=false&useTimezone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="password";*/
    private static BasicDataSource dataSource;
   
    public static DataSource getDataSource(){
        if (dataSource == null){
           dataSource = new BasicDataSource();
           dataSource.setUrl(JDBC_URL);
           dataSource.setUsername(JDBC_USER);
           dataSource.setPassword(JDBC_PASSWORD);
           dataSource.setInitialSize(50);
        }
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    
    public static void Close(ResultSet rs){
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void Close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void Close(Connection conn){
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
