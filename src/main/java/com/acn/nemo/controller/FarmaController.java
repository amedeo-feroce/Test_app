/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.controller;

import com.acn.nemo.dto.UpdateDtoInput;
import com.acn.nemo.dto.UpdateDtoOutput;
import com.acn.nemo.service.UpdateService;
import com.acn.nemo.service.impl.UpdateServiceImpl;

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
@WebServlet(name = "FarmaController", urlPatterns = {"/FarmaController"})
public class FarmaController extends HttpServlet {

    private UpdateDtoInput updateDtoInput;
    private UpdateService updateService;
    private UpdateDtoOutput updateDtoOutput;

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(FarmaController.class);

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
        String op = request.getParameter("op");
        

        updateDtoInput = new UpdateDtoInput();
        updateService = new UpdateServiceImpl();

        if (op.equals("update")) {
            HttpSession session = request.getSession(true);
            String choiceControl = "cu";
            session.setAttribute("choiceControl", choiceControl);
            this.getServletContext().getRequestDispatcher("/getChoice.jsp").forward(request, response);
        } else if (op.equals("control_upd")) {
            HttpSession session = request.getSession(true);
            int id = Integer.parseInt(request.getParameter("id"));
            if (updateService.readCod(id)) {
                String choice = "u";
                session.setAttribute("choice", choice);
                session.setAttribute("id", id);
                this.getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
            } else {

                this.getServletContext().getRequestDispatcher("/errorPage2.jsp").forward(request, response);
            }
        } else if (op.equals("delete")) {
            HttpSession session = request.getSession(true);
            String choiceControl = "cd";
            session.setAttribute("choiceControl", choiceControl);
            this.getServletContext().getRequestDispatcher("/getChoice.jsp").forward(request, response);
        } else if (op.equals("control_del")) {
            HttpSession session = request.getSession(true);
            int id = Integer.parseInt(request.getParameter("id"));
            if (updateService.readCod(id)) {
                String choice = "d";
                session.setAttribute("choice", choice);
                session.setAttribute("id", id);
                updateDtoInput.setId(Integer.parseInt(request.getParameter("id")));
                if (updateService.deleteData(updateDtoInput)) {
                    this.getServletContext().getRequestDispatcher("/userMenu.jsp").forward(request, response);
                }else {

                this.getServletContext().getRequestDispatcher("/errorPage2.jsp").forward(request, response);
            }
            }
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
