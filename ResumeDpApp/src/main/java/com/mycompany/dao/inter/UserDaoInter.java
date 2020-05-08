/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.bean.User;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface UserDaoInter {
    
    public List<User> getAll();
    
    public User getById(int id);
    
    public boolean updateUser(User u);
    
    public boolean removeUser(int id);
    
    
    
    
}
