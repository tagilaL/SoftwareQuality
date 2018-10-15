/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import ConexaoBanco.ConnectionBD;
import Model.DAO.UserDAO;
import Model.User;
import junit.framework.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tagil
 */
public class UserTest extends TestCase{
    
    private UserDAO dao = new UserDAO();
    private User user = new User();
    
    public static void main(String[] args) {
        ConnectionBD con = new ConnectionBD();
        con.conectar();
    }
    @Test
    public void testIsertUser() {
        
        user.setName("Usuario de Teste");
        user.setEmail("usuario@gmail.com");
        user.setPassword("usuario");
        assertTrue(dao.insert(user));
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
