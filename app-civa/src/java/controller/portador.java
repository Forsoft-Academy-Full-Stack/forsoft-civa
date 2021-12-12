/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DocsDao;
import dao.EnderecoDao;
import dao.PaisDao;
import dao.PessoaDao;
import dao.PortadorCivaDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Docs;
import model.Endereco;
import model.Pessoa;
import model.PortadorCiva;

/**
 *
 * @author randel
 */
@WebServlet(name = "portador", urlPatterns = {"/portador"})
public class portador extends HttpServlet {

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
            PortadorCiva portadorCiva = new PortadorCiva();
            Pessoa pessoa = new Pessoa();
            Docs documento1 = new Docs();
            Endereco endereco = new Endereco();

            String option = request.getParameter("option");

            HttpSession session = request.getSession();

            switch (option) {
                case "cadastrar":
                     System.err.println("Entrou no cadastrar");
                    int idPais = Integer.parseInt(request.getParameter("nome-pais"));
                    pessoa.setNomePessoa(request.getParameter("nome"));
                    pessoa.setSobrenomePessoa(request.getParameter("sobrenome"));
                    pessoa.setGenero(request.getParameter("genero"));
                    pessoa.setDataNascimento(request.getParameter("data-nascimento"));
                    pessoa.setNacionalidade(request.getParameter("nacionalidade"));
                    pessoa.setTelefoneDdd(request.getParameter("tele"));
                    pessoa.setEmail(request.getParameter("email"));
                    pessoa.setIdPessoa(PessoaDao.getIdPessoa(request.getParameter("codigo-civa")));
                    pessoa.setSenha(request.getParameter("senha"));
                  
                    documento1.setNomeTipoDoc(request.getParameter("tipo-doc1"));
                    documento1.setDocumento(request.getParameter("doc1"));

                    pessoa.setIdNacionalidade(idPais);
                    String ddi = PaisDao.getDdiById(idPais);                
                    pessoa.setDdiContato(ddi);
                    
                    

                    endereco.setCodigoPostal(request.getParameter("cod-postal"));
                    endereco.setLogradouro(request.getParameter("nome-logrd"));
                    endereco.setNumero(request.getParameter("nome-num"));
                    endereco.setComplemento(request.getParameter("nome-comple"));
                    endereco.setNomesubdivisao3(request.getParameter("bairro"));
                    endereco.setNomesubdivisao2(request.getParameter("municipio"));
                    endereco.setNomesubdivisao1(request.getParameter("estado"));
                    
                    ;
                    
                    endereco.setIdPais(idPais);
                    String nomePais = PaisDao.getNomeById(idPais);
                    endereco.setNomePais(nomePais);
                    
                  

                    portadorCiva.setPessoa(pessoa);
                    portadorCiva.setDocumento1(documento1);
                    portadorCiva.setEndereco(endereco);   
                    
                    int idCadastrante = -1;
                    
                    try {
                        idCadastrante = (int) session.getAttribute("idPessoa") ;
                    } catch (Exception e) {
                    }
                                                                                       
                        
                    System.err.println("Senha: " + pessoa.getSenha());
                      
                    Boolean result = PortadorCivaDao.insert(portadorCiva, idCadastrante);

                    if (!result) {
                        response.sendError(404);
                    }

                    break;

                case "atualizar":
                    
                    pessoa.setNomePessoa(request.getParameter("nome"));
                    pessoa.setSobrenomePessoa(request.getParameter("sobrenome"));
                    pessoa.setGenero(request.getParameter("genero"));
                    pessoa.setDataNascimento(request.getParameter("data-nascimento"));
                    pessoa.setNacionalidade(request.getParameter("nacionalidade"));                   
                    pessoa.setTelefoneDdd(request.getParameter("tele"));
                    pessoa.setEmail(request.getParameter("email"));
                    pessoa.setIdPessoa(PessoaDao.getIdPessoa(request.getParameter("codigo-civa")));
                    //pessoa.setDdiContato(request.getParameter("ddi"));
                    System.err.println("DDI da pessoa: " + pessoa.getDdiContato());
                   
                   
                    documento1.setNomeTipoDoc(request.getParameter("tipo-doc1"));
                    documento1.setDocumento(request.getParameter("doc1"));
                    documento1.setIdTipoDoc(DocsDao.findIdTipodoc(documento1.getNomeTipoDoc()));
                    documento1.setIdDocs(DocsDao.getIdDocs(pessoa.getIdPessoa()));

                    endereco.setNomePais(request.getParameter("nome-pais"));

                    endereco.setCodigoPostal(request.getParameter("cod-postal"));
                    endereco.setLogradouro(request.getParameter("nome-logrd").trim());
                    endereco.setTipoLogradouro("");
                    endereco.setNumero(request.getParameter("nome-num"));
                    System.err.println("Pessoa numero: " + endereco.getNumero());
                    endereco.setComplemento(request.getParameter("nome-comple"));
                    endereco.setNomesubdivisao3(request.getParameter("bairro"));
                    endereco.setNomesubdivisao2(request.getParameter("municipio"));
                    endereco.setNomesubdivisao1(request.getParameter("estado"));
                    endereco.setIdPais(PaisDao.getIdPaisByName(endereco.getNomePais()));

                    pessoa.setIdNacionalidade(PaisDao.getIdPaisByName(endereco.getNomePais()));
                    pessoa.setDdiContato(PaisDao.getDdiByName(endereco.getNomePais()));
  
                    System.err.println("Pessoa nacionalidade: " + pessoa.getNacionalidade());

                    endereco.setIdEndereco(EnderecoDao.getIdEnderecoByIdPessoa(pessoa.getIdPessoa()));

                    portadorCiva.setPessoa(pessoa);
                    portadorCiva.setDocumento1(documento1);
                    portadorCiva.setEndereco(endereco);

                    result = PortadorCivaDao.update(portadorCiva);

                    if (!result) {
                        response.sendError(404);
                    }
                    break;

                case "deletar":                    
                    
                    System.err.println(request.getParameter("codigo-civa"));
                  
                    String codigoCiva = request.getParameter("codigo-civa");    
                      System.err.println("idPessoa: " + PessoaDao.getIdPessoa(codigoCiva));
                    
                    pessoa.setIdPessoa(PessoaDao.getIdPessoa(codigoCiva));
                    portadorCiva.setPessoa(pessoa);
                                      
                    result = PortadorCivaDao.delete(portadorCiva);

                    System.err.println("deletado: "+ result);
                    if (!result) {
                        response.sendError(404);
                    }
                    break;

                default:
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
