/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.dao.impl.CountrlDaoImpl;
import com.mycompany.dao.impl.EmploymnetHistoryDaoImpl;
import com.mycompany.dao.impl.SkillDaoImpl;
import com.mycompany.dao.impl.UserDaoImpl;
import com.mycompany.dao.impl.UserSkillDaoImpl;
import com.mycompany.dao.inter.CountrylDaoInter;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.dao.inter.UserSkillDaoInter;

/**
 *
 * @author virtu
 */
public class Contex {
    
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
     public static UserSkillDaoInter instanceUserSkillDao(){
        return new UserSkillDaoImpl();
    }
     
     public static EmploymentHistoryDaoInter instanceEmploymentHistoryDao(){
        return new EmploymnetHistoryDaoImpl();
    }
     
     public static CountrylDaoInter instanceCountryDao(){
        return new CountrlDaoImpl();
    }
     
     public static SkillDaoInter instanceSkillDao(){
        return new SkillDaoImpl();
    }
    
}
