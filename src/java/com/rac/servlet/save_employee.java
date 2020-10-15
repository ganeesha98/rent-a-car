/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.servlet;

import com.rac.daoimpl.EmployeeDaoImpl;
import com.rac.model.Employee;
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

@WebServlet(name = "save_employee", urlPatterns = {"/save_employee"})
public class save_employee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            String name = "";
            String nic = "";
            String address = "";
            String contact = "";
            String email = "";

            name = request.getParameter("employee_name");
            nic = request.getParameter("employee_nic");
            address = request.getParameter("employee_address");
            contact = request.getParameter("employee_contact");
            email = request.getParameter("employee_email");

            Employee employee = new Employee();
            employee.setAddress(address);
            employee.setCategoryId(1);
            employee.setContactNo(contact);
            employee.setEmail(email);
            employee.setName(name);
            employee.setNic(nic);

            new EmployeeDaoImpl().AddEmployee(employee);
            
            response.sendRedirect("ManageEmployees.jsp"); 
            
        } catch (SQLException ex) {
            Logger.getLogger(save_employee.class.getName()).log(Level.SEVERE, null, ex);
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
