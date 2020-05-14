/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import java.sql.Connection;
import java.sql.Date;
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
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private User getUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("Surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        int natioanlityId = rs.getInt("nationality_id");
        int birthPlaceId = rs.getInt("birthplace_id");
        String natioanlityStr = rs.getString("nationality");
        String birthPlaceStr = rs.getString("birthplace");
        Date birthDate = rs.getDate("birthdate");

        Country nationality = new Country(natioanlityId, null, natioanlityStr);
        Country birthPlace = new Country(birthPlaceId, birthPlaceStr, null);
        return new User(id, name, surname, email, phone, birthDate, nationality, birthPlace);

    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection connect = connect()) {

            Statement stm = connect.createStatement();
            stm.execute("SELECT u.*,"
                    + " n.nationality ,"
                    + "	c.name AS birthplace "
                    + "FROM 	user u "
                    + "	LEFT JOIN country n ON u.nationality_id = n.id 	"
                    + "LEFT JOIN country c ON u.birthplace_id=c.id");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
 @Override
    public User getById(int userId) {
        User result = null;
        try (Connection c = connect()) {
//            PreparedStatement ps = c.prepareStatement("SELECT u.*,"
//                    + " n.nationality ,"
//                    + "	c.name AS birthplace "
//                    + "FROM 	user u "
//                    + "	LEFT JOIN country n ON u.nationality_id = n.id 	"
//                    + "LEFT JOIN country c ON u.birthplace_id=c.id where u.id = ?");
//            ps.setInt(1, userId);
            Statement stm = c.createStatement();
            stm.execute("SELECT u.*,"
                    + " n.nationality ,"
                    + "	c.name AS birthplace "
                    + "FROM 	user u "
                    + "	LEFT JOIN country n ON u.nationality_id = n.id 	"
                    + "LEFT JOIN country c ON u.birthplace_id=c.id where u.id="+userId);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                result = getUser(rs);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean updateUser(User u) {

        try (Connection c = connect()) {

            PreparedStatement ps = c.prepareStatement("update user set name=?,surname=?,email=?,phone=? where id=?");
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
        try (Connection connect = connect()) {

            Statement stm = connect.createStatement();
            stm.execute("SELECT u.*,"
                    + " n.nationality,"
                    + "	c.name AS birthplace "
                    + "FROM 	user u "
                    + "	LEFT JOIN country n ON u.nationality_id = n.id 	"
                    + "LEFT JOIN country c ON u.birthplace_id=c.id where u.id" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

   
    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {

            PreparedStatement ps = c.prepareStatement("insert into user(name , surname, email, phone) values (?,?,?,?)");
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
