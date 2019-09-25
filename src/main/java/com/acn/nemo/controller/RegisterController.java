package com.acn.nemo.controller;

import com.acn.nemo.dto.LoginDtoInput;
import com.acn.nemo.service.LoginService;
import com.acn.nemo.service.impl.LoginServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author amedeo.feroce
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginController.class);

    private LoginDtoInput loginDtoInput;
    private LoginService loginService;

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

        loginDtoInput = new LoginDtoInput();
        loginService = new LoginServiceImpl();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ((!"".equals(username)) && (!"".equals(password))) {
            loginDtoInput.setUsername(request.getParameter("username"));
            loginDtoInput.setPassword(request.getParameter("password"));
            if (loginService.insertLogin(loginDtoInput)) {
                session.setAttribute("register", loginDtoInput);

                this.getServletContext().getRequestDispatcher("/userMenu.jsp").forward(request, response);
            } else {
                logger.error("user already exists");
                this.getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
            }

        }

    }

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
