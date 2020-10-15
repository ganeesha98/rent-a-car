/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.dao;

import com.rac.model.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public interface DriverDao {
    
    public boolean addDriver(Driver Driver) throws SQLException;
    
    public boolean updateDriver(Driver Driver) throws SQLException;
    
    public boolean deleteDriver(int DriverId)throws SQLException;
    
    public ResultSet getAllDrivers()throws SQLException;
    
    public ResultSet getDriverByOneAttribute(String Attribute, String Condition, String Value)throws SQLException;
    
}
