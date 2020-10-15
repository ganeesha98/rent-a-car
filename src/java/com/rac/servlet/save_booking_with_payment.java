/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.servlet;

import com.rac.controller.commonController;
import com.rac.daoimpl.BookingDaoImpl;
import com.rac.daoimpl.PaymentDaoImpl;
import com.rac.model.Booking;
import com.rac.model.Payment;
import com.rac.model.Vehicle;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author personal
 */
@WebServlet(name = "save_booking_with_payment", urlPatterns = {"/save_booking_with_payment"})
public class save_booking_with_payment extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");

            String CustomerName = request.getParameter("booking_customer_id");
            String BookingDetail = request.getParameter("booking_detail");
            String Location = request.getParameter("booking_targeted_location");
            String booking_payment_amount = request.getParameter("booking_payment_amount");

            HttpSession ses = request.getSession();

            String VehicleNo = (String) ses.getAttribute("VehicleNo");
            Booking booking = new Booking();
            booking.setVehicleId(VehicleNo);
            booking.setStatus(1);
            booking.setPaymentType("CASH");
            booking.setCustomerId(CustomerName);
            booking.setDetails(BookingDetail);
            booking.setTargetedLocation(Location);
            booking.setPaymentAmount(commonController.getBigDecimalOrZeroFromString(booking_payment_amount));

            Payment payment = new Payment();
            payment.setAmount(commonController.getBigDecimalOrZeroFromString(booking_payment_amount));
            payment.setRefNo(VehicleNo);
            payment.setRemark("Cust Name : " + CustomerName);
            payment.setStatus(1);

            new PaymentDaoImpl().AddPayment(payment);
            new BookingDaoImpl().AddBooking(booking);

            response.sendRedirect("home.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(save_booking_with_payment.class.getName()).log(Level.SEVERE, null, ex);
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
