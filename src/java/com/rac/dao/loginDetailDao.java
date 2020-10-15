
package com.rac.dao;

import com.rac.model.LoginDetail;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface loginDetailDao {
    
    void addLoginDetail(LoginDetail loginDetail)throws SQLException;
    
    ResultSet getAllLoginDetails()throws SQLException;
    
    ResultSet getLoginDetailByOneAttribute(String attribute, String condition, String value)throws SQLException;
    
    boolean deleteLoginDetail(int loginDetailId)throws SQLException;
}
