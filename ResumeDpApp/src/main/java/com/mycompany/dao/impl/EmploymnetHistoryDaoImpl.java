/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.User;
import com.mycompany.main.Contex;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author virtu
 */
public class EmploymnetHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {



    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws SQLException {
        String header=rs.getString("header");
        Date beginDate=rs.getDate("begin_date");
        Date endDate=rs.getDate("end_date");
        String jobDescription=rs.getString("jobDescription");
        int userId=rs.getInt("user_id");
        return new EmploymentHistory(null, header, beginDate, endDate, jobDescription, Contex.instanceUserDao().getById(userId));
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection connect = connect()) {

            PreparedStatement stm = connect.prepareStatement("select * from employment_history where user_id = ?");
            stm.setInt(1, userId);
            stm.execute();
            ResultSet rs = stm.getResultSet();

            while (rs.next()) {
                EmploymentHistory u = getEmploymentHistory(rs);
                result.add(u);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

}
