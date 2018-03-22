/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JTextField;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hp
 */
public class loginTest  {
    
    static login login;
    
    public loginTest() {
        //login l= new login();
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class login.
     * @throws java.lang.Exception
     */
    @Test
    public void testMain() throws Exception{
        //System.out.println("working");
        StudentInfor student = new StudentInfor("sbhdsbfvj");
        //student.setVisible(true);
        /*
        assertNotNull(login);
        JTextField input = (JTextField)TestUtils.getChildNamed(login, "TF1");
        */
       
        /*
        Method m = login.class.getDeclaredMethod("jButton1ActionPerformed");
        m.setAccessible(true);
        m.invoke(l);
        */
        
    }
    @Test
    public void test2() throws Exception{
        login l = new login();
        String tf1="mayank";
        String tf2="mayank";
        String type = "Admin";
        l.test(tf1, tf2, type);
        
    }
    @Test
    public void test3() throws Exception{
        StudentDetails student = new StudentDetails();
        String id = "20";
        student.test(id);
    }
}
