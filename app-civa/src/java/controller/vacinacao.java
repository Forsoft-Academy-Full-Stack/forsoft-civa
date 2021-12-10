/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PessoaDao;
import dao.VacinacaoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Vacina;
import model.Vacinacao;

/**
 *
 * @author randel
 */
@WebServlet(name = "vacinacao", urlPatterns = {"/vacinacao"})
public class vacinacao extends HttpServlet {

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

            HttpSession session = request.getSession();
            Vacinacao vacinacao = new Vacinacao();
            Vacina vacina = new Vacina();

            try {
                Date dataAtual = new Date();
                SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd - hh:mm");
                String atual = formatador.format(dataAtual);

                vacinacao.setDataAplicacao2(atual);

            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.err.println(e.getClass());
            }

            int idVacina = Integer.parseInt(request.getParameter("vacina"));
            String lote = request.getParameter("lote");

            vacina.setIdVacina(idVacina);
            vacina.setLote(lote);
            vacinacao.setVacina(vacina);

            String codigoCiva = request.getParameter("codigo-civa");
            int idPessoa = PessoaDao.getIdPessoa(codigoCiva);
            int idAcessoPc = PessoaDao.getIdAcessoPc(idPessoa);

            int idCadastrante = (int) session.getAttribute("idPessoa");
            System.err.println("Idcadastrante :" + idCadastrante);
            int idAcessoGestao = PessoaDao.getIdAcessoGestao(idCadastrante);

            int idUnidade = Integer.parseInt(request.getParameter("unidade"));

            vacinacao.setIdUnidade(idUnidade);
            String dose = request.getParameter("numerodoses");
            vacinacao.setDoseAplicada(dose);

            System.err.println("idAcessoPc :" + idAcessoPc);
            System.err.println("idPessoa :" + idPessoa);
            System.err.println("codigoCiva :" + codigoCiva);
            System.err.println("idAcessoGestao :" + idAcessoGestao);
            System.err.println("idUnidade :" + idUnidade);
            System.err.println("dose :" + dose);
            System.err.println("idVacina :" + idVacina);
            System.err.println("lote :" + lote);

            System.err.println("vacinacao.getDataAplicacao() :" + vacinacao.getDataAplicacao());

            System.err.println("Vacina: " + vacinacao.getVacina().getIdVacina()
                    + "\nidAcessoPc: " + idAcessoPc + "\nidAcessoGestao: " + idAcessoGestao
                    + "\nLote: " + vacinacao.getVacina().getLote()
                    + "\nidUnidade: " + idUnidade
                    + "\nDose: " + vacinacao.getDoseAplicada()
                    + "\nData Aplicacao: " + vacinacao.getDataAplicacao());
            
            boolean result = VacinacaoDao.insert(idAcessoPc, idAcessoGestao, vacinacao);

            if (!result) {
                response.sendError(404);
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
