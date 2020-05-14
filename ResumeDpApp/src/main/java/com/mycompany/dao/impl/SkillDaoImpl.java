/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.entity.Skill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author virtu
 */
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {



    private Skill getSkill(ResultSet rs) throws SQLException {

        int id = rs.getInt("id");
        String name = rs.getString("name");
       
        return new Skill(id,name);
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> result= new ArrayList<>();
    
    
        try(Connection c=connect()) {
            Statement stm=c.createStatement();
            stm.execute("Select * from skill");
           
            ResultSet rs=stm.getResultSet();
            
            while (rs.next()) {                
                Skill con=getSkill(rs);
                result.add(con);
            }
        } catch (Exception e) {
        }
        
        return result;
    }  }

  


