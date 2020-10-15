/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.dao;

import com.rac.model.Vehicle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public interface VehicleDao {

    public boolean AddVehicle(Vehicle Vehicle) throws SQLException;

    public boolean UpdateVehicle(Vehicle Vehicle) throws SQLException;

    public boolean DeleteVehicle(int VehicleId) throws SQLException;

    public ResultSet GetVehicleByOneAttribute(String Attribute, String Condition, String Value) throws SQLException;

    public ResultSet GetVehicleByMoreAttributes(ArrayList<String[]> AttributeValueList, String Operator) throws SQLException;

    public ResultSet GetAllVehicles() throws SQLException;

}
