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
public class Conexao {
    
    public static String status = "Não conectou...";

    public Conexao() {
    }
    
    public static Connection conectar() {
        
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
            //System.out.println("Nao foi possivel conectar ao Banco de Dados.");
 
            //return null;
 
        }
 
    }
    
    public static String statusConection() {
 
        return status;
 
    }
  
    public static boolean FecharConexao() {
 
        try {
 
            Conexao.conectar().close();
 
            return true;
 
        } catch (SQLException e) {
 
            return false;
 
        }
    }
 
    public static Connection ReiniciarConexao() {
 
        FecharConexao();
        return Conexao.conectar();
 
    }
      
}