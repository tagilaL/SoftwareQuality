/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import ConexaoBanco.ConnectionBD;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author tagila
 */
public class UserDAO {
    
    private Connection connection;
    
    public UserDAO(){
        this.connection = new ConnectionBD().conectar();
    }
    
    public Boolean insert(User user){
        
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
                    
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);            
        }
        
    }
}
