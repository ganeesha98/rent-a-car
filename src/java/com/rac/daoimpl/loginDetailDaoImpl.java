package com.rac.daoimpl;

import com.rac.dao.loginDetailDao;
import com.rac.databaseConnection.DatabaseConnection;
import com.rac.model.LoginDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDetailDaoImpl implements loginDetailDao {

    private String selectQuery = "select login_detail_id, login_detail_login_date, login_detail_user_id, login_detail_logout_date, login_detail_status, login_detail_detail from login_detail";

    @Override
    public void addLoginDetail(LoginDetail loginDetail) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into login_detail ( login_detail_user_id, login_detail_status,"
                + " login_detail_detail) values (?,?,?)");
        ps.setInt(1, loginDetail.getLoginDetailUserId());
        ps.setInt(2, LoginDetail.LOGIN_DETAIL_STATUS_ACTIVE);
        ps.setString(3, loginDetail.getLoginDetailDetail());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public ResultSet getAllLoginDetails() throws SQLException {
        return new commonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getLoginDetailByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

    @Override
    public boolean deleteLoginDetail(int loginDetailId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from login_detail where login_detail_id=?");
        ps.setInt(1, loginDetailId);
        ps.executeUpdate();
        return true;
    }

    public boolean UpdateLogRecordAsIdentified(int Id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update login_detail set login_detail_status=0 where login_detail_id=?");
        ps.setInt(1, Id);
        ps.executeUpdate();
        ps.close();
        return true;
    }
    public boolean UpdateLogRecordAsUnidentified(int Id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update login_detail set login_detail_status=1 where login_detail_id=?");
        ps.setInt(1, Id);
        ps.executeUpdate();
        ps.close();
        return true;
    }
    
     public int GetAllLogsCount() throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("select count(login_detail_id) as log_count FROM login_detail");
        ResultSet rset = ps.executeQuery();
        int Count = 0;
        while (rset.next()) {
            Count = rset.getInt("log_count");
        }
        return Count;
    }

}
