/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.daoimpl;

import com.rac.dao.EmployeeDao;
import com.rac.model.Employee;
import com.rac.databaseConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDaoImpl implements EmployeeDao {

    private String SelectQuery = "select employee_id, employee_name, employee_nic, employee_category_id, "
            + "employee_address, employee_contact, employee_email, employee_remark, employee_status from employees";

    @Override
    public boolean AddEmployee(Employee Employee) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into employees (employee_name, "
                + "employee_nic, employee_address, employee_contact, "
                + "employee_email, employee_remark) values (?,?,?,?,?,?)");
        ps.setString(1, Employee.getName());
        ps.setString(2, Employee.getNic());
        ps.setString(3, Employee.getAddress());
        ps.setString(4, Employee.getContactNo());
        ps.setString(5, Employee.getEmail());
        ps.setString(6, Employee.getRemark());
        ps.executeUpdate();
        return true;
    }

    @Override
    public boolean UpdateEmployee(Employee Employee) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update employees set , "
                + "employee_name=?, employee_nic=?, employee_category_id=?, employee_address=?, "
                + "employee_contact=?, employee_email=?, employee_remark=?, employee_status=? where employee_id=?");
        ps.setInt(1, Employee.getId());
        ps.setString(2, Employee.getName());
        ps.setString(3, Employee.getNic());
        ps.setInt(4, Employee.getCategoryId());
        ps.setString(5, Employee.getAddress());
        ps.setString(6, Employee.getContactNo());
        ps.setString(7, Employee.getEmail());
        ps.setString(8, Employee.getRemark());
        ps.setInt(9, 1);
        ps.executeUpdate();
        return true;
    }

    @Override
    public boolean DeleteEmployee(int EmployeeId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from employees where employee_id =?");
        ps.setInt(1, EmployeeId);
        ps.executeUpdate();
        return true;
    }

    @Override
    public ResultSet GetEmployeeByOneAttribute(String Attribute, String Condition, String Value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(SelectQuery, Attribute, Condition, Value);
    }

    @Override
    public ResultSet GetEmployeeByMoreAttributes(ArrayList<String[]> AttributeValueList, String Operator) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet GetAllEmployees() throws SQLException {
        return new commonDaoImpl().getAllRecords(SelectQuery);
    }

    public boolean UpdateEmployeeAsActive(int Id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update employees set employee_status=1 where employee_id=?");
        ps.setInt(1, Id);
        ps.executeUpdate();
        ps.close();
        return true;
    }
    
    public boolean UpdateEmployeeAsInactive(int Id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update employees set employee_status=0 where employee_id=?");
        ps.setInt(1, Id);
        ps.executeUpdate();
        ps.close();
        return true;
    }
}
