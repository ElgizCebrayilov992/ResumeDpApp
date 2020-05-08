/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.dao.impl.UserDaoImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author virtu
 */
public abstract class AbstractDAO {
     public  Connection connect() throws Exception{
        
            //Class.forName bloku static bir blokdur.Class ise dusende bu class ise dusur
            //Icine yazdigimiz
            //Class.forName("com.mysql.jdbc.Driver");
        
        final String url="jdbc:mysql://localhost:3306/resume";
        final String username="root";
        final String password="12345";
        
        Connection c=DriverManager.getConnection(url, username, password);
        return c;
        
    }
    
}
