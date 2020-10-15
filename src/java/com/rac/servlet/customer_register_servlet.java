/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.servlet;

import com.rac.daoimpl.CustomerDaoImpl;
import com.rac.model.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "customer_register_servlet", urlPatterns = {"/customer_register_servlet"})
public class customer_register_servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            String Name = "";
            String Address = "";
            String Email = "";
            String Phone = "";
            String Detail = "";
            
            Name = request.getParameter("txt_name");
            Address = request.getParameter("txt_address");
            Email = request.getParameter("txt_email");
            Phone = request.getParameter("txt_phone");
            Detail = request.getParameter("txt_detail");
            
            Customer Customer = new Customer();
            Customer.setAddress(Address);
            Customer.setContactNo(Phone);
            Customer.setEmail(Email);
            Customer.setEtails(Detail);
            Customer.setName(Name);
            
            boolean status = new CustomerDaoImpl().AddCustomer(Customer);
            if(status){
                response.sendRedirect("home.jsp"); 
            }            
        } catch (SQLException ex) {
            Logger.getLogger(customer_register_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
