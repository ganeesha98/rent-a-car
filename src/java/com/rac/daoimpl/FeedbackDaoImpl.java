/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.daoimpl;

import com.rac.dao.FeedbackDao;
import com.rac.databaseConnection.DatabaseConnection;
import com.rac.model.Feedback;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public class FeedbackDaoImpl implements FeedbackDao {

    private String selectQuery = "select feedback_id, feedback_comment, feedback_name, feedback_email, feedback_status from feedbacks";

    @Override
    public boolean addFeedback(Feedback feedback) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into feedbacks "
                + "(feedback_comment, feedback_name, feedback_email) values(?,?,?)");
        ps.setString(1, feedback.getComment());
        ps.setString(2, feedback.getName());
        ps.setString(3, feedback.getEmail());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deleteFeedBack(int id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from feedbacks where feedback_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getAllFeedbacks() throws SQLException {
        return new commonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getFeedbackByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

    public boolean updateFeedbackAsValid(int Id) throws SQLException {
        System.out.println("  in dao impllll" + Id);
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update feedbacks set feedback_status=1 where feedback_id=?");
        ps.setInt(1, Id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public boolean updateFeedbackAsInvalid(int Id) throws SQLException {
        System.out.println("  in dao impllll 2222" + Id);
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update feedbacks set feedback_status=0 where feedback_id=?");
        ps.setInt(1, Id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

}
