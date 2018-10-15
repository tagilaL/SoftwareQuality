/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBanco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tagil
 */
public class ConnectionBD {
    
    public static String status = "Não conectou...";

    public ConnectionBD() {
    }
    public static void main(String[] args) {
        ConnectionBD con = new ConnectionBD();
        con.conectar();
        System.out.println(con.status());
    }
    public Connection conectar() {
        
        Connection conn;
        
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easytasks?useTimezone=true&serverTimezone=UTC", "root", "");                      
            if (conn != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão"); 
            }            
            return conn;
        } catch (SQLException e) {           
            throw new RuntimeException(e); 
        }
    }
    
    public String status() {
        return status;
    }
  
    public boolean fecharConexao() {
 
        ConnectionBD con = new ConnectionBD();
        try {
 
            con.conectar().close();
 
            return true;
 
        } catch (SQLException e) {
 
            return false;
 
        }
    }
 
    public static Connection reiniciarConexao() {
        ConnectionBD con = new ConnectionBD();
        con.fecharConexao();
        return con.conectar();
 
    }
      
}