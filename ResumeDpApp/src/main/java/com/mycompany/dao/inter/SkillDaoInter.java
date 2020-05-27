/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.Country;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import java.util.List;

/**
 *
 * @author virtu
 */
public interface SkillDaoInter {
    
    
    
    public List<Skill> getAll();
    
    public void insertSkill(Skill skill);
    
    public void updateSkill(Skill skill);
    
    public void deleteSkill(int skill);
    
    
  
    
    
    
}
