/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.bean.User;
import com.mycompany.dao.impl.UserDaoImpl;
import com.mycompany.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author virtu
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao=Contex.instanceUserDao();
        List<User> list=userDao.getAll();
        System.out.println(list);
        
        User user=userDao.getById(2);
        user.setName("Elgiz");
        
        userDao.updateUser(user);       
        List<User> list1=userDao.getAll();
        System.out.println(list1);
        
    }
    
}
