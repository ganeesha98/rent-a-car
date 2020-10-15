/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.servlet;

import com.rac.controller.commonConstants;
import com.rac.controller.loginDetailController;
import com.rac.daoimpl.CustomerDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "static_admin_login", urlPatterns = {"/static_admin_login"})
public class static_admin_login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String uname = "";
            String password = "";

            uname = request.getParameter("uname");
            password = request.getParameter("pw");

            if (uname.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
                response.sendRedirect("dashboard.jsp");
            } else {
                ArrayList<String[]> AttributeConditionValue = new ArrayList<>();
                String[] ACV1 = {"customer_email", commonConstants.Sql.EQUAL, uname};
                AttributeConditionValue.add(ACV1);

                String[] ACV2 = {"customer_detail", commonConstants.Sql.EQUAL, password};
                AttributeConditionValue.add(ACV2);

                ResultSet rset = new CustomerDaoImpl().GetCustomerByMoreAttributes(AttributeConditionValue, commonConstants.Sql.AND);
                boolean status = false;

                if (rset.next()) {
                    status = true;
                } else {
                    status = false;
                }
                HttpSession session = request.getSession();
                if (status) {
                    session.setAttribute("uname", uname);
                }
                //=======================================================

                String browserDetails = request.getHeader("User-Agent");
                String userAgent = browserDetails;
                String user = userAgent.toLowerCase();

                String os = "";
                String browser = "";

                //=================OS=======================
                if (userAgent.toLowerCase().indexOf("windows") >= 0) {
                    os = "Windows";
                } else if (userAgent.toLowerCase().indexOf("mac") >= 0) {
                    os = "Mac";
                } else if (userAgent.toLowerCase().indexOf("x11") >= 0) {
                    os = "Unix";
                } else if (userAgent.toLowerCase().indexOf("android") >= 0) {
                    os = "Android";
                } else if (userAgent.toLowerCase().indexOf("iphone") >= 0) {
                    os = "IPhone";
                } else {
                    os = "UnKnown, More-Info: " + userAgent;
                }
                //===============Browser===========================
                if (user.contains("msie")) {
                    String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
                    browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
                } else if (user.contains("safari") && user.contains("version")) {
                    browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
                } else if (user.contains("opr") || user.contains("opera")) {
                    if (user.contains("opera")) {
                        browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
                    } else if (user.contains("opr")) {
                        browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
                    }
                } else if (user.contains("chrome")) {
                    browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
                } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1) || (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1)) {
                    //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
                    browser = "Netscape-?";

                } else if (user.contains("firefox")) {
                    browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
                } else if (user.contains("rv")) {
                    browser = "IE-" + user.substring(user.indexOf("rv") + 3, user.indexOf(")"));
                } else {
                    browser = "UnKnown, More-Info: " + userAgent;
                }

                loginDetailController.addLoginDetail(1, " User " + uname + " - " + " browser " + browser + " - " + " os " + os);

                //========================
                response.sendRedirect("home.jsp");
            }

        } catch (SQLException ex) {
            Logger.getLogger(static_admin_login.class.getName()).log(Level.SEVERE, null, ex);
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
