/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.CountrylDaoInter;
import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author virtu
 */
public class CountrlDaoImpl extends AbstractDAO implements CountrylDaoInter {



    private Country getCountry(ResultSet rs) throws SQLException {

        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");
      

        return new Country(id, name, nationality);
    }

  

    @Override
    public List<Country> getAll() {
        List<Country> result= new ArrayList<>();
    
    
        try(Connection c=connect()) {
            Statement stm=c.createStatement();
            stm.execute("Select * from country");
            ResultSet rs=stm.getResultSet();
            
            while (rs.next()) {                
                Country con=getCountry(rs);
                result.add(con);
            }
        } catch (Exception e) {
        }
        
        return result;
    }


}
