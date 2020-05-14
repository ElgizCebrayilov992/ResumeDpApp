/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;


import com.mycompany.dao.inter.SkillDaoInter;


/**
 *
 * @author virtu
 */
public class Main {

    public static void main(String[] args) throws Exception {
        SkillDaoInter  cd=Contex.instanceSkillDao();
      
        System.out.println(cd.getAll());
        System.out.println("");
        
    }
    
}
