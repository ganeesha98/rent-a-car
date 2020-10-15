/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.daoimpl;

import com.rac.dao.CustomerDao;
import com.rac.model.Customer;
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
public class CustomerDaoImpl implements CustomerDao {

    private String SelectQuery = "select customer_id, customer_name, customer_email, customer_contact_no, "
            + " customer_address, customer_status, customer_detail from customers";

    @Override
    public boolean AddCustomer(Customer Customer) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into customers (customer_id, customer_name, "
                + "customer_email, customer_contact_no, customer_address, customer_status, customer_detail) "
                + "values (?,?,?,?,?,?,?)");
        ps.setInt(1, Customer.getId());
        ps.setString(2, Customer.getName());
        ps.setString(3, Customer.getEmail());
        ps.setString(4, Customer.getContactNo());
        ps.setString(5, Customer.getAddress());
        ps.setInt(6, 1);
        ps.setString(7, Customer.getEtails());
        ps.executeUpdate();
        return true;
    }

    @Override
    public boolean UpdateCustomer(Customer Customer) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update customer set , customer_name, "
                + "customer_email, customer_contact_no, customer_address, customer_status, "
                + "customer_detail where customer_id");
        ps.setInt(1, Customer.getId());
        ps.setString(2, Customer.getName());
        ps.setString(3, Customer.getEmail());
        ps.setString(4, Customer.getContactNo());
        ps.setString(5, Customer.getAddress());
        ps.setInt(6, 1);
        ps.setString(7, Customer.getEtails());
        ps.executeUpdate();
        return true;
    }

    @Override
    public boolean DeleteCustomer(int Customerid) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from customers where customer_id=?");
        ps.setInt(1, Customerid);
        ps.executeUpdate();
        return true;
    }

    @Override
    public ResultSet GetCustomerByOneAttribute(String Attribute, String Condition, String Value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(SelectQuery, Attribute, Condition, Value);
    }

    @Override
    public ResultSet GetCustomerByMoreAttributes(ArrayList<String[]> AttributeValueList, String Operator) throws SQLException {
        return new commonDaoImpl().getResultByAttributesWithJoinOperator(SelectQuery, AttributeValueList, Operator);
    }

    @Override
    public ResultSet GetAllCustomers() throws SQLException {
        return new commonDaoImpl().getAllRecords(SelectQuery);
    }

    public boolean UpdateAsInactive(int Id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update customers set customer_status=0 where customer_id=?");
        ps.setInt(1, Id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public boolean UpdateAsActive(int Id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update customers set customer_status=1 where customer_id=?");
        ps.setInt(1, Id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public int GetAllActiveCustomersCount() throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("select count(customer_name) as cust_count FROM customers where customer_status=1");
        ResultSet rset = ps.executeQuery();
        int Count = 0;
        while (rset.next()) {
            Count = rset.getInt("cust_count");
        }
        return Count;
    }
}
