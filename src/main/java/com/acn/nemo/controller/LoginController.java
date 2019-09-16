/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.acn.nemo.dto.LoginDtoInput;
import com.acn.nemo.service.LoginService;
import com.acn.nemo.service.impl.LoginServiceImpl;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private LoginDtoInput loginDtoInput;
    private LoginService loginService;

    //private DBManager dbm;
    private static final Logger logger = Logger.getLogger(LoginController.class);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        try {

            loginDtoInput = new LoginDtoInput();
            loginService = new LoginServiceImpl();

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println(" password: " + password + " username: " + username);
            if ((!"".equals(username)) && (!"".equals(password))) {
                loginDtoInput.setUsername(request.getParameter("username"));
                loginDtoInput.setPassword(request.getParameter("password"));

                if (loginService.checkUsers(username)) {
                    if (loginService.checkLogin(loginDtoInput)) {
                        session.setAttribute("user", loginDtoInput);
                        this.getServletContext().getRequestDispatcher("/userMenu.jsp").forward(request, response);
                    }
                } else {

                    this.getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);

                }
            } else {
                System.out.println("Sorry username or password error");
                logger.info("null value!");
                response.sendRedirect("login.jsp");
            }

        } catch (Exception ex) {
            logger.error("Errore: " + ex.getMessage());
        }

        out.close();

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
