/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface UserSkillDaoInter {
    
    
    
    public List<UserSkill> getAllSkillByUserId(int userId);
    
    public void DeleteUserSkill(int id);
    
    public void InsertUserSkill(UserSkill uk);
    
    public void updateUserSkill(UserSkill uk);
    
    
    
}
