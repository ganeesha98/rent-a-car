/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.dao;

import com.rac.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public interface EmployeeDao {

    public boolean AddEmployee(Employee Employee) throws SQLException;

    public boolean UpdateEmployee(Employee Employee) throws SQLException;

    public boolean DeleteEmployee(int EmployeeId) throws SQLException;

    public ResultSet GetEmployeeByOneAttribute(String Attribute, String Condition, String Value) throws SQLException;

    public ResultSet GetEmployeeByMoreAttributes(ArrayList<String[]> AttributeValueList, String Operator) throws SQLException;

    public ResultSet GetAllEmployees() throws SQLException;

}
