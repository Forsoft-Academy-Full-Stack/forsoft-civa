/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EnderecoDao;
import dao.PaisDao;
import dao.PessoaDao;
import dao.UnidadeDao;
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
import model.Docs;
import model.Endereco;
import model.Pessoa;
import model.Unidade;

/**
 *
 * @author randel
 */
@WebServlet(name = "unidade", urlPatterns = {"/unidade"})
public class unidade extends HttpServlet {

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
            Unidade unidade = new Unidade();
            Docs documento1 = new Docs();
            Endereco endereco = new Endereco();
            Pessoa pessoa = new Pessoa();

            String option = request.getParameter("option");

            HttpSession session = request.getSession();

            switch (option) {
                case "cadastrar":
                    int idPais = Integer.parseInt(request.getParameter("nome-pais"));
                    unidade.setNome(request.getParameter("nome"));
                    unidade.setRegistro(request.getParameter("documento-registro"));
                    unidade.setNatureza(request.getParameter("natureza"));
                    unidade.setTipoEstabelecimento(request.getParameter("tipo-estabelecimento"));
                    unidade.setContato(request.getParameter("tele"));
                    unidade.setLocacao(request.getParameter("locacao"));
                    unidade.setSituacao("ativo");                 
                    
                    endereco.setNomePais(request.getParameter("nome-pais"));
                    endereco.setCodigoPostal(request.getParameter("cod-postal"));
                    endereco.setLogradouro(request.getParameter("nome-logrd"));
                    endereco.setNumero(request.getParameter("nome-num"));
                    endereco.setComplemento(request.getParameter("nome-comple"));
                    endereco.setNomesubdivisao3(request.getParameter("bairro"));
                    endereco.setNomesubdivisao2(request.getParameter("municipio"));
                    endereco.setNomesubdivisao1(request.getParameter("estado"));
                    
                    endereco.setIdPais(idPais);
                    String nomePais = PaisDao.getNomeById(idPais);
                    endereco.setNomePais(nomePais);

                    unidade.setEndereco(endereco);

                    Date data = new Date();
                    SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd");

                    unidade.setDataCadastro(formatador.format(data));

                    System.err.println(data);

                    int idCadastrante = (int) session.getAttribute("idPessoa");

                    System.err.println("teste: " + idCadastrante);

                    Boolean result = UnidadeDao.insert(unidade);
                    System.err.println("depois de unidade: " + result);

                    if (!result) {
                        response.sendError(404);
                    }

                    break;

                case "atualizar":
                                        
                    unidade.setNome(request.getParameter("name"));
                    unidade.setRegistro(request.getParameter("doc-register"));
                    unidade.setNatureza(request.getParameter("natureza"));
                    unidade.setTipoEstabelecimento(request.getParameter("tipo-estabelecimento"));
                    unidade.setLocacao(request.getParameter("locacao"));
                    unidade.setContato(request.getParameter("tele"));
                    unidade.setIdUnidade(Integer.parseInt(request.getParameter("idUnidade")));
                    unidade.setSituacao("ativo");
                    
                    endereco.setIdEndereco(UnidadeDao.getIdEndereco(unidade.getIdUnidade()));
                                                           
                    endereco.setNomePais(request.getParameter("nome-pais"));                                     
                    endereco.setCodigoPostal(request.getParameter("cod-postal"));
                    endereco.setLogradouro(request.getParameter("nome-logrd"));
                    endereco.setNumero(request.getParameter("nome-num"));
                    endereco.setComplemento(request.getParameter("nome-comple"));
                    endereco.setNomesubdivisao3(request.getParameter("bairro"));
                    endereco.setNomesubdivisao2(request.getParameter("municipio"));
                    endereco.setNomesubdivisao1(request.getParameter("estado"));
                    endereco.setIdPais(PaisDao.getIdPaisByName(endereco.getNomePais()));
                    
                    unidade.setEndereco(endereco);
                    result = UnidadeDao.update(unidade);
                    
                    if (!result) {
                        response.sendError(404);
                    }
                    break;

                case "deletar":
                    System.err.println("deletado");
                    System.err.println(request.getParameter("nome"));
                    System.err.println(request.getParameter("sobrenome"));
                    break;

                case "vincular":
                    System.err.println("vincular");
                    pessoa.setIdPessoa(PessoaDao.getIdPessoa(request.getParameter("codigoCiva")));
                    int idUnidade = Integer.parseInt(request.getParameter("idUnidade"));

                    System.err.println("Cód: " + pessoa.getIdPessoa());
                    System.err.println("id: " + idUnidade);
                    
                    result = UnidadeDao.insertProficionalUnidade(idUnidade, PessoaDao.getIdAcessoGestao(pessoa.getIdPessoa()));

                    if (!result) {
                        response.sendError(404);
                    }

                    break;
                    
                 case "desvincular":
                    System.err.println("desvincular");
                   
                    pessoa.setIdPessoa(PessoaDao.getIdPessoa(request.getParameter("codigoCiva")));
                    int idAcessoGestao = PessoaDao.getIdAcessoGestao(pessoa.getIdPessoa());
                    
                    idUnidade = Integer.parseInt(request.getParameter("idUnidade"));

                    System.err.println("id acesso gestao" + idAcessoGestao);
                    System.err.println("id: " + idUnidade);
                    
                    int idGestaoUnidade = UnidadeDao.getIdGestaoUnidade(idUnidade, idAcessoGestao);
                    
                     System.err.println("idGestaoUnidade: " + idGestaoUnidade);
                    result = UnidadeDao.deleteGestaoUnidade(idGestaoUnidade);

                    if (!result) {
                        response.sendError(404);
                    }

                    break;

                default:
                    response.sendError(404);
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
