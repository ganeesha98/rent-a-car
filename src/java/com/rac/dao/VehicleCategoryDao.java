/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.dao;

import com.rac.model.Employee;
import com.rac.model.VehicleCategory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public interface VehicleCategoryDao {

    public boolean AddVehicleCategory(VehicleCategory VehicleCategory) throws SQLException;

    public boolean UpdateVehicleCategory(VehicleCategory VehicleCategory) throws SQLException;

    public boolean DeleteVehicleCategory(int VhicleCategoryId) throws SQLException;

    public ResultSet GetVehicleCategoryByOneAttribute(String Attribute, String Condition, String Value) throws SQLException;

    public ResultSet GetVehicleCategoryByMoreAttributes(ArrayList<String[]> AttributeValueList, String Operator) throws SQLException;

    public ResultSet GetAllVehicleCategories() throws SQLException;

}
