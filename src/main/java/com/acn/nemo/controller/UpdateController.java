/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.controller;

import com.acn.nemo.dto.UpdateDtoInput;
import com.acn.nemo.service.UpdateService;
import com.acn.nemo.service.impl.UpdateServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
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
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    private UpdateDtoInput updateDtoInput;
    private UpdateService updateService;

    private static final Logger logger = Logger.getLogger(UpdateController.class);

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        updateDtoInput = new UpdateDtoInput();
        updateService = new UpdateServiceImpl();

        String op = request.getParameter("op");

        short cod_promo = Short.parseShort(request.getParameter("cod_promo"));
        short pgr_promo = Short.parseShort(request.getParameter("pgr_promo"));
        short pgr_riga = Short.parseShort(request.getParameter("pgr_riga"));
        int sconto_p = Integer.parseInt(request.getParameter("sconto_p"));
        String tipo_promo = request.getParameter("tipo_promo");
        String descrizione = request.getParameter("descrizione");
        String desc_tipo = request.getParameter("desc_tipo");
        int id = Integer.parseInt(request.getParameter("id"));

        if ((!"".equals(cod_promo)) && (!"".equals(pgr_promo)) && (!"".equals(pgr_riga)) && (!"".equals(sconto_p)) && (!"".equals(tipo_promo)) && (!"".equals(descrizione)) && (!"".equals(desc_tipo))&& (!"".equals(id))) {
            updateDtoInput.setCod_promo(Short.parseShort(request.getParameter("cod_promo")));
            updateDtoInput.setPgr_promo(Short.parseShort(request.getParameter("pgr_promo")));
            updateDtoInput.setPgr_riga(Short.parseShort(request.getParameter("pgr_riga")));
            updateDtoInput.setSconto_p(Integer.parseInt(request.getParameter("sconto_p")));
            updateDtoInput.setTipo_promo(request.getParameter("tipo_promo"));
            updateDtoInput.setDescrizione(request.getParameter("descrizione"));
            updateDtoInput.setDesc_tipo(request.getParameter("desc_tipo"));
            updateDtoInput.setId(Integer.parseInt(request.getParameter("id")));

            if (updateService.updateData(updateDtoInput)) {
                if (op.equals("updated")) {
                    this.getServletContext().getRequestDispatcher("/updateSuccessfully.jsp").forward(request, response);
                }
            } else {
                logger.error("Update failed!");
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
        try {
            processRequest(request, response);

        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(UpdateController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);

        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(UpdateController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
