/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.bean.User;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author virtu
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter{

    @Override
    public List<User> getAll() {
        List<User> result=new ArrayList<>();
        try(Connection connect=connect()) {
            
            Statement stm=connect.createStatement();
            stm.execute("Select * from user");
            ResultSet rs=stm.getResultSet();
            while (rs.next()) {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String surname=rs.getString("Surname");
                String email=rs.getString("email");
                String phone=rs.getString("phone");
                
                result.add(new User(id, name, surname, email, phone));
                
            }
        } catch (Exception ex) {
        ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {
        
        try( Connection c=connect()) {
           
            PreparedStatement ps=c.prepareStatement("update user set name=?,surname=?,email=?,phone=? where id=?");
            ps.setString(1, u.getName());
            ps.setString(2, u.getSurname());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPhone());
            ps.setInt(5, u.getId());
            return ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
        
    }

    @Override
    public boolean removeUser(int id) {
         try(Connection connect=connect()) {
            
            Statement stm=connect.createStatement(); 
            stm.execute("Delete from user where id="+id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public User getById(int userId) {
         User result=null;
        try(Connection connect=connect()) {
            
            Statement stm=connect.createStatement();
            stm.execute("Select * from user where id="+userId);
            ResultSet rs=stm.getResultSet();
            while (rs.next()) {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String surname=rs.getString("Surname");
                String email=rs.getString("email");
                String phone=rs.getString("phone");
                
                result=new User(id, name, surname, email, phone);
                
            }
        } catch (Exception ex) {
        ex.printStackTrace();
        }
        return result;
    
    }

    @Override
    public boolean addUser(User u) {
     try( Connection c=connect()) {
           
            PreparedStatement ps=c.prepareStatement("insert into user(name , surname, email, phone) values (?,?,?,?)");
            ps.setString(1, u.getName());
            ps.setString(2, u.getSurname());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPhone());
            
            return ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }    
    }
       
   
    
}
