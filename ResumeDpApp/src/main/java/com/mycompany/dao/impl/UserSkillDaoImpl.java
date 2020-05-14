/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author virtu
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {



    private UserSkill getUserSkill(ResultSet rs) throws SQLException {

        int skillId = rs.getInt("skill_id");
        int userId = rs.getInt("id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        return new UserSkill(userId, new User(userId), new Skill(skillId, skillName), power);
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection connect = connect()) {

            PreparedStatement stm = connect.prepareStatement("SELECT"
                    + "	u.*,"
                    + "	us.skill_id,"
                    + "	s.`name` AS skill_name,"
                    + "	us.power "
                    + "FROM"
                    + "	user_skill us"
                    + "	LEFT JOIN `user` u ON us.user_id = u.id"
                    + "	LEFT JOIN skill s ON us.skill_id = s.id "
                    + "WHERE"
                    + "	us.user_id = ?");
            stm.setInt(1, userId);
            stm.execute();
            ResultSet rs = stm.getResultSet();

            while (rs.next()) {
                UserSkill u = getUserSkill(rs);
                result.add(u);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

}
