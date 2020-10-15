/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.dao;

import com.rac.model.Feedback;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public interface FeedbackDao {
    
    public boolean addFeedback(Feedback feedback)throws SQLException;
    
    public boolean deleteFeedBack(int id)throws SQLException;
    
    public ResultSet getAllFeedbacks()throws SQLException;
    
    public ResultSet getFeedbackByOneAttribute(String attribute, String condition, String value)throws SQLException; 
    
}
