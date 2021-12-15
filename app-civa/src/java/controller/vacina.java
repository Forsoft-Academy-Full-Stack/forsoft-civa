/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.PaisDao;
import dao.VacinaDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vacina;

/**
 *
 * @author ANAPAULA
 */
@WebServlet(name = "vacina", urlPatterns = {"/vacina"})
public class vacina extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Vacina vacina = new Vacina();
            boolean result = false;
            String option = request.getParameter("option");

            switch (option) {
                case "cadastrar":
                    vacina.setNomeVacina(request.getParameter("nome"));
                    vacina.setLaboratorio(request.getParameter("lab"));
                    vacina.setTipoVacina(request.getParameter("tipo-vacina"));
                    vacina.setNumeroDoses(request.getParameter("doses"));
                    vacina.setTempoEntreDoses(Integer.parseInt(request.getParameter("intervalo-dose")));
                    vacina.setTempoReforco(Integer.parseInt(request.getParameter("tempo-reforco")));

                    result = VacinaDao.insert(vacina);

                    if (!result) {
                        response.sendError(404);
                    }

                    break;

                case "atualizar":
                    System.err.println("Atualizar Vacina de ID: " + request.getParameter("idVacina"));
                    vacina.setIdVacina(Integer.parseInt(request.getParameter("idVacina")));
                    vacina.setNomeVacina(request.getParameter("nome"));
                    vacina.setLaboratorio(request.getParameter("lab"));
                    vacina.setTipoVacina(request.getParameter("tipo-vacina"));
                    vacina.setNumeroDoses(request.getParameter("doses"));
                    vacina.setTempoEntreDoses(Integer.parseInt(request.getParameter("intervalo-dose")));
                    vacina.setTempoReforco(Integer.parseInt(request.getParameter("tempo-reforco")));

                    result = VacinaDao.update(vacina);

                    if (!result) {
                        response.sendError(404);
                    }

                    break;

                case "deletar":
                    break;
                    
                    
                case "vincular":
                    int idVacina =  Integer.parseInt(request.getParameter("id-vacina"));
                    int idPais =  Integer.parseInt(request.getParameter("id-pais"));
                    
                   
                    result = PaisDao.vincularVacina(idVacina, idPais);
                                        
                    if (!result) {
                        response.sendError(404);
                    }

                    
                    break;
                    
                    
            }

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
