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
import java.text.SimpleDateFormat;
import java.util.Date;
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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        updateDtoInput = new UpdateDtoInput();
        updateService = new UpdateServiceImpl();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        int cod_promo = Integer.parseInt(request.getParameter("cod_promo"));
        int pgr_promo = Integer.parseInt(request.getParameter("pgr_promo"));
        int pgr_riga = Integer.parseInt(request.getParameter("pgr_riga"));
        String data_inizio_promo_str = request.getParameter("data_inizio_promo");
        Date data_inizio_promo = sdf.parse(data_inizio_promo_str);
        String data_fine_promo_str = request.getParameter("data_fine_promo");
        Date data_fine_promo = sdf.parse(data_fine_promo_str);
        String seg_cli = request.getParameter("seg_cli");
        int valore_tp = Integer.parseInt(request.getParameter("valore_tp"));
        int sconto_p = Integer.parseInt(request.getParameter("sconto_p"));
        int nro_volte = Integer.parseInt(request.getParameter("nro_volte"));
        String tipo = request.getParameter("tipo");
        String tipo_promo = request.getParameter("tipo_promo");
        String descrizione = request.getParameter("descrizione");
        String iniziativa = request.getParameter("iniziativa");
        int tipo_promo_vs = Integer.parseInt(request.getParameter("tipo_promo_vs"));
        String desc_tipo = request.getParameter("desc_tipo");
        String dt_mod_str = request.getParameter("dt_mod");
        Date dt_mod = sdf.parse(dt_mod_str);

        if ((!"".equals(cod_promo)) && (!"".equals(pgr_promo)) && (!"".equals(pgr_riga)) && (!"".equals(data_inizio_promo)) && (!"".equals(data_fine_promo)) && (!"".equals(seg_cli)) && (!"".equals(valore_tp)) && (!"".equals(sconto_p)) && (!"".equals(nro_volte)) && (!"".equals(tipo)) && (!"".equals(tipo_promo)) && (!"".equals(descrizione)) && (!"".equals(iniziativa)) && (!"".equals(tipo_promo_vs)) && (!"".equals(desc_tipo)) && (!"".equals(dt_mod))) {
            updateDtoInput.setCod_promo(Integer.parseInt(request.getParameter("cod_promo")));
            updateDtoInput.setPgr_promo(Integer.parseInt(request.getParameter("pgr_promo")));
            updateDtoInput.setPgr_riga(Integer.parseInt(request.getParameter("pgr_riga")));
            //updateDtoInput.setData_inizio_promo(request.getParameter("data_inizio_promo"));
            updateDtoInput.setData_fine_promo(data_fine_promo);
            updateDtoInput.setSeg_cli(request.getParameter("seg_cli"));
            updateDtoInput.setValore_tp(Integer.parseInt(request.getParameter("valore_tp")));
            updateDtoInput.setSconto_p(Integer.parseInt(request.getParameter("scono_p")));
            updateDtoInput.setNro_volte(Integer.parseInt(request.getParameter("nro_volte")));
            updateDtoInput.setTipo(request.getParameter("tipo"));
            updateDtoInput.setTipo_promo(request.getParameter("tipo_promo"));
            updateDtoInput.setDescrizione(request.getParameter("dewcrizione"));
            updateDtoInput.setIniziativa(request.getParameter("iniziativa"));
            updateDtoInput.setTipo_promo_vs(Integer.parseInt(request.getParameter("tipo_promo_vs")));
            updateDtoInput.setDesc_tipo(request.getParameter("desc_tipo"));
            updateDtoInput.setDt_mod(dt_mod);

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
            java.util.logging.Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
