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
import dao.ProfissionalSaudeDao;
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
import model.ProfissionalSaude;

/**
 *
 * @author randel
 */
@WebServlet(name = "profissionalSaude", urlPatterns = {"/profissionalSaude"})
public class profissionalSaude extends HttpServlet {

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
            ProfissionalSaude profissionalSaude = new ProfissionalSaude();
            Pessoa pessoa = new Pessoa();
            Docs documento1 = new Docs();
            Docs documento2 = new Docs();
            Docs documento3 = new Docs();
            Docs documento4 = new Docs();
            Docs documento5 = new Docs();
            Endereco endereco = new Endereco();

            String option = request.getParameter("option");

            HttpSession session = request.getSession();

            switch (option) {
                case "cadastrar":
                    int idPais = Integer.parseInt(request.getParameter("nome-pais"));
                    pessoa.setNomePessoa(request.getParameter("nome"));
                    pessoa.setSobrenomePessoa(request.getParameter("sobrenome"));
                    pessoa.setGenero(request.getParameter("genero"));
                    pessoa.setDataNascimento(request.getParameter("data-nascimento"));
                    pessoa.setNacionalidade(request.getParameter("nacionalidade"));
                    pessoa.setTelefoneDdd(request.getParameter("tele"));
                    pessoa.setEmail(request.getParameter("email"));

                    documento1.setNomeTipoDoc(request.getParameter("tipo-doc1"));
                    documento1.setDocumento(request.getParameter("doc1"));

                    // Pegar o restante dos documentos opcionais
                    documento2.setNomeTipoDoc(request.getParameter("tipo-doc2"));
                    documento2.setDocumento(request.getParameter("doc2"));

                    documento3.setNomeTipoDoc(request.getParameter("tipo-doc3"));
                    documento3.setDocumento(request.getParameter("doc3"));

                    documento4.setNomeTipoDoc(request.getParameter("tipo-doc4"));
                    documento4.setDocumento(request.getParameter("doc4"));

                    documento5.setNomeTipoDoc(request.getParameter("tipo-doc5"));
                    documento5.setDocumento(request.getParameter("doc5"));

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
                   
                    endereco.setIdPais(idPais);
                    String nomePais = PaisDao.getNomeById(idPais);
                    endereco.setNomePais(nomePais);

                    profissionalSaude.setPessoa(pessoa);
                    profissionalSaude.setDocumento1(documento1);
                    profissionalSaude.setDocumento2(documento2);
                    profissionalSaude.setDocumento3(documento3);
                    profissionalSaude.setDocumento4(documento4);
                    profissionalSaude.setDocumento5(documento5);
                    profissionalSaude.setEndereco(endereco);

                    int idCadastrante = (int) session.getAttribute("idPessoa");

                    Boolean result = ProfissionalSaudeDao.insert(profissionalSaude, idCadastrante);

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
                    
                    try {
                         
                        documento1.setNomeTipoDoc(request.getParameter("tipo-doc1"));
                        documento1.setDocumento(request.getParameter("doc1"));                      
                        documento1.setIdTipoDoc(DocsDao.findIdTipodoc(documento1.getNomeTipoDoc()));                     
                        documento1.setIdDocs(DocsDao.getIdDocs(pessoa.getIdPessoa(), documento1.getIdTipoDoc()));                                                 
                        
                        documento2.setNomeTipoDoc(request.getParameter("tipo-doc-2"));
                        documento2.setDocumento(request.getParameter("doc-2"));
                        documento2.setIdTipoDoc(DocsDao.findIdTipodoc(documento2.getNomeTipoDoc()));
                        documento2.setIdDocs(DocsDao.getIdDocs(pessoa.getIdPessoa(), documento2.getIdTipoDoc()));

                        documento3.setNomeTipoDoc(request.getParameter("tipo-doc-3"));
                        documento3.setDocumento(request.getParameter("doc-3"));
                        documento3.setIdTipoDoc(DocsDao.findIdTipodoc(documento3.getNomeTipoDoc()));
                        documento3.setIdDocs(DocsDao.getIdDocs(pessoa.getIdPessoa(), documento3.getIdTipoDoc()));

                        documento4.setNomeTipoDoc(request.getParameter("tipo-doc-4"));
                        documento4.setDocumento(request.getParameter("doc-4"));
                        documento4.setIdTipoDoc(DocsDao.findIdTipodoc(documento4.getNomeTipoDoc()));
                        documento4.setIdDocs(DocsDao.getIdDocs(pessoa.getIdPessoa(), documento4.getIdTipoDoc()));

                        documento5.setNomeTipoDoc(request.getParameter("tipo-doc-5"));
                        documento5.setDocumento(request.getParameter("doc-5"));
                        documento5.setIdTipoDoc(DocsDao.findIdTipodoc(documento5.getNomeTipoDoc()));
                        documento5.setIdDocs(DocsDao.getIdDocs(pessoa.getIdPessoa(), documento5.getIdTipoDoc()));

                        profissionalSaude.setDocumento2(documento2);
                        profissionalSaude.setDocumento3(documento3);
                        profissionalSaude.setDocumento4(documento4);
                        profissionalSaude.setDocumento5(documento5);
                    } catch (Exception e) {
                        System.err.println("erro docs");
                    }
                    // Pegar o restante dos documentos opcionais

        
                    endereco.setNomePais(request.getParameter("nome-pais"));
                    pessoa.setIdNacionalidade(PaisDao.getIdPaisByName(endereco.getNomePais()));
                    pessoa.setDdiContato(PaisDao.getDdiByName(endereco.getNomePais()));
                    
                    endereco.setCodigoPostal(request.getParameter("cod-postal"));
                    endereco.setLogradouro(request.getParameter("nome-logrd"));
                    endereco.setNumero(request.getParameter("nome-num"));
                    endereco.setComplemento(request.getParameter("nome-comple"));
                    endereco.setNomesubdivisao3(request.getParameter("bairro"));
                    endereco.setNomesubdivisao2(request.getParameter("municipio"));
                    endereco.setNomesubdivisao1(request.getParameter("estado"));
                    endereco.setIdPais(PaisDao.getIdPaisByName(endereco.getNomePais()));
                    endereco.setIdEndereco(EnderecoDao.getIdEnderecoByIdPessoa(pessoa.getIdPessoa()));                  
                    
                    profissionalSaude.setPessoa(pessoa);
                    profissionalSaude.setDocumento1(documento1);
                    profissionalSaude.setEndereco(endereco);

                    result = ProfissionalSaudeDao.update(profissionalSaude);                   
                    
                    System.err.println("Atualizou: " + result ); 

                    if (!result) {
                        response.sendError(404);
                    }

                    break;

                 case "deletar":                    
                    System.err.println("deletado");
                    System.err.println(request.getParameter("codigo-civa"));
                    String codigoCiva = request.getParameter("codigo-civa");    
                    
                    pessoa.setIdPessoa(PessoaDao.getIdPessoa(codigoCiva));
                    profissionalSaude.setPessoa(pessoa);
                                      
                    result = ProfissionalSaudeDao.delete(profissionalSaude);

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
