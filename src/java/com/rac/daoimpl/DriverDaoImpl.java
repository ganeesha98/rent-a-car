/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.daoimpl;

import com.rac.dao.DriverDao;
import com.rac.databaseConnection.DatabaseConnection;
import com.rac.model.Driver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public class DriverDaoImpl implements DriverDao {

    private String SelectQuery = "select driver_id, driver_name, driver_reg_date, driver_email, "
            + " driver_address, driver_contact, driver_remark from drivers";

    /**
     * driver_id, driver_name, driver_reg_date, driver_email, driver_address,
     * driver_contact, driver_remark
     *
     * @param Driver
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public boolean addDriver(Driver Driver) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into drivers(driver_name, driver_email, driver_address, "
                + " driver_contact, driver_remark) values (?,?,?,?,?)");
        ps.setString(1, Driver.getName());
        ps.setString(2, Driver.getEmail());
        ps.setString(3, Driver.getAddress());
        ps.setString(4, Driver.getContact());
        ps.setString(5, Driver.getDetail());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean updateDriver(Driver Driver) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteDriver(int DriverId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from drivers where driver_id=?");
        ps.setInt(1, DriverId);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getAllDrivers() throws SQLException {
        return new commonDaoImpl().getAllRecords(SelectQuery);
    }

    @Override
    public ResultSet getDriverByOneAttribute(String Attribute, String Condition, String Value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(SelectQuery, Attribute, Condition, Value);
    }

    public boolean UpdateDriverAsActive(int Id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update drivers set driver_remark=1 where driver_id=?");
        ps.setInt(1, Id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public boolean UpdateDriverAsInactive(int Id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update drivers set driver_remark=0 where driver_id=?");
        ps.setInt(1, Id);
        ps.executeUpdate();
        ps.close();
        return true;
    }
}
