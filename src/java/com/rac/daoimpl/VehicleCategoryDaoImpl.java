/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.daoimpl;

import com.rac.dao.VehicleCategoryDao;
import com.rac.model.VehicleCategory;
import com.rac.databaseConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public class VehicleCategoryDaoImpl implements VehicleCategoryDao {

    private String SelectQuery = "select vehicle_category_id, vehicle_category_name, "
            + "vehicle_category_detail, vehicle_category_status from vehicle_categories";

    @Override
    public boolean AddVehicleCategory(VehicleCategory VehicleCategory) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into vehicle_categories (vehicle_category_id, vehicle_category_name, "
                + "vehicle_category_detail, vehicle_category_status) values (?,?,?,?)");
        ps.setInt(1, VehicleCategory.getId());
        ps.setString(2, VehicleCategory.getCategoryName());
        ps.setString(3, VehicleCategory.getCategoryDetail());
        ps.setInt(4, 1);
        ps.setInt(5, 1);
        ps.executeUpdate();
        return true;
    }

    @Override
    public boolean UpdateVehicleCategory(VehicleCategory VehicleCategory) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update vehicle_categories set , "
                + "vehicle_category_name=?, vehicle_category_detail=?, vehicle_category_status=? where vehicle_category_id=?");
        ps.setString(1, VehicleCategory.getCategoryName());
        ps.setString(2, VehicleCategory.getCategoryDetail());
        ps.setInt(3, 1);
        ps.setInt(4, 1);
        ps.setInt(5, VehicleCategory.getId());
        ps.executeUpdate();
        return true;
    }

    @Override
    public boolean DeleteVehicleCategory(int VhicleCategoryId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from vehicle_categories where vehicle_category_id=?");
        ps.setInt(1, VhicleCategoryId);
        ps.executeUpdate();
        return true;
    }

    @Override
    public ResultSet GetVehicleCategoryByOneAttribute(String Attribute, String Condition, String Value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(SelectQuery, Attribute, Condition, Value);
    }

    @Override
    public ResultSet GetVehicleCategoryByMoreAttributes(ArrayList<String[]> AttributeValueList, String Operator) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet GetAllVehicleCategories() throws SQLException {
        return new commonDaoImpl().getAllRecords(SelectQuery);
    }

}
