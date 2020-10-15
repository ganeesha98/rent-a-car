/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.dao;

import com.rac.model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public interface CustomerDao {

    public boolean AddCustomer(Customer Customer) throws SQLException;

    public boolean UpdateCustomer(Customer Customer) throws SQLException;

    public boolean DeleteCustomer(int Customerid) throws SQLException;

    public ResultSet GetCustomerByOneAttribute(String Attribute, String Condition, String Value) throws SQLException;

    public ResultSet GetCustomerByMoreAttributes(ArrayList<String[]> AttributeValueList, String Operator) throws SQLException;

    public ResultSet GetAllCustomers() throws SQLException;

}
