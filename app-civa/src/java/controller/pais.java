package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DivisaoTerritorial;
import model.Docs;
import model.Endereco;
import model.GestorNacional;
import model.Pais;
import model.Pessoa;
import model.TipoDoc;

/**
 *
 * @author randel
 */
@WebServlet(name = "pais", urlPatterns = {"/pais"})
public class pais extends HttpServlet {

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
            Pais pais = new Pais();
            DivisaoTerritorial divisaoTerritorial = new DivisaoTerritorial();
            List<TipoDoc> tiposDoc = new ArrayList<>();

            String option = request.getParameter("option");

            HttpSession session = request.getSession();

            switch (option) {
                case "cadastrar":
                   
                    try {
                    // pegar os dados do país pelo request
                    pais.setNomePais(request.getParameter("pais"));
                    pais.setNomeContinente(request.getParameter("continente"));
                    pais.setDdi(Integer.parseInt(request.getParameter("ddi")));
                    pais.setPadraoContato(request.getParameter("padrao-contato"));
                    pais.setOrgaoResponsavel(request.getParameter("orgao-saude"));
                    pais.setFusoHorario(request.getParameter("fuso-horario"));
                    System.err.println("Pais Nome: "
                        + pais.getNomePais()+"\nContinente: " + pais.getNomeContinente()
                        +"\nDDI: " +pais.getDdi()+"\nPadrão contato: " +pais.getPadraoContato()
                            +"\nOrgão responsavel: " + pais.getOrgaoResponsavel()
                            +"\nFuso horario" + pais.getFusoHorario()+"\n");

                } catch (Exception e) {
                }

                System.err.println("Entrou em cadastrar");

                for (int i = 1; i <= 10; i++) {
                    try {

                        TipoDoc tipoDoc = new TipoDoc();

                        tipoDoc.setNivel(request.getParameter("tipo-doc" + i));
                        tipoDoc.setNomeDoc(request.getParameter("doc" + i));
                        tipoDoc.setFormatoDoc(request.getParameter("form-doc" + i));
                        tiposDoc.add(tipoDoc);
                        
                        System.err.println("Nível: " + tipoDoc.getNivel() + "\nNome: " + tipoDoc.getNomeDoc() + "\nFormato: " + tipoDoc.getFormatoDoc()+"\n");
                    } catch (Exception e) {
                        System.err.println("Erro");
                    }

                }
                
                try {
                    divisaoTerritorial.setTiposubdivisao1(request.getParameter("subdivisao1"));
                    divisaoTerritorial.setTiposubdivisao2(request.getParameter("subdivisao2"));
                    divisaoTerritorial.setTiposubdivisao3(request.getParameter("subdivisao3"));
                    divisaoTerritorial.setTiposubdivisao4(request.getParameter("subdivisao4"));
                    divisaoTerritorial.setTiposubdivisao5(request.getParameter("subdivisao5"));
                    divisaoTerritorial.setTiposubdivisao6(request.getParameter("subdivisao6"));
                    divisaoTerritorial.setTiposubdivisao7(request.getParameter("subdivisao7"));
                   
                    System.err.println("Sub1: " + divisaoTerritorial.getTiposubdivisao1()
                    +"\nSub2: " + divisaoTerritorial.getTiposubdivisao2()
                    +"\nSub3: " + divisaoTerritorial.getTiposubdivisao3()
                    +"\nSub4: " + divisaoTerritorial.getTiposubdivisao4()
                    +"\nSub5: " + divisaoTerritorial.getTiposubdivisao5()
                    +"\nSub6: " + divisaoTerritorial.getTiposubdivisao6()
                    +"\nSub7: " + divisaoTerritorial.getTiposubdivisao7()+"\n");
                    
                } catch (Exception e) {
                }
                
                
                Pessoa pessoaGestorNacional = new Pessoa();
                Endereco enderecoGestorNacional = new Endereco();
                Docs docsGestorNacional = new Docs();
                Docs docsGestorNacional2 = new Docs();
                Docs docsGestorNacional3 = new Docs();
                Docs docsGestorNacional4 = new Docs();
                Docs docsGestorNacional5 = new Docs();
                GestorNacional gestorNacional = new GestorNacional();
                
                pessoaGestorNacional.setNomePessoa(request.getParameter("nome-gn"));
                pessoaGestorNacional.setSobrenomePessoa(request.getParameter("sobrenome-gn"));
                pessoaGestorNacional.setGenero(request.getParameter("genero-gn"));
                pessoaGestorNacional.setDataNascimento(request.getParameter("data-nascimento-gn"));
                pessoaGestorNacional.setNacionalidade(request.getParameter("nacionalidade-gn"));
                pessoaGestorNacional.setTelefoneDdd(request.getParameter("tele-gn"));
                pessoaGestorNacional.setEmail(request.getParameter("email-gn"));
                
                System.err.println("Nome pessoa: " + pessoaGestorNacional.getNomePessoa()
                        +"\nSobrenome: " + pessoaGestorNacional.getSobrenomePessoa()
                        +"\nGenero: " + pessoaGestorNacional.getGenero()
                        +"\nData Nascimento: " + pessoaGestorNacional.getDataNascimento()
                        +"\nNacionalidade: " + pessoaGestorNacional.getNacionalidade()
                        +"\nTelefone: " + pessoaGestorNacional.getTelefoneDdd()
                        +"\nE-mail: " + pessoaGestorNacional.getEmail()+"\n");
                
                
                docsGestorNacional.setNomeTipoDoc(request.getParameter("tipo-doc1-gn"));
                docsGestorNacional.setDocumento(request.getParameter("doc1-gn"));
                
                docsGestorNacional2.setNomeTipoDoc(request.getParameter("tipo-doc2-gn"));
                docsGestorNacional2.setDocumento(request.getParameter("doc2-gn"));
                
                docsGestorNacional3.setNomeTipoDoc(request.getParameter("tipo-doc3-gn"));
                docsGestorNacional3.setDocumento(request.getParameter("doc3-gn"));
                
                docsGestorNacional4.setNomeTipoDoc(request.getParameter("tipo-doc4-gn"));
                docsGestorNacional4.setDocumento(request.getParameter("doc4-gn"));
                
                docsGestorNacional5.setNomeTipoDoc(request.getParameter("tipo-doc5-gn"));
                docsGestorNacional5.setDocumento(request.getParameter("doc5-gn"));
                
                System.err.println("Doc1 Nome: " + docsGestorNacional.getNomeTipoDoc()
                        +"\nDocumento: " + docsGestorNacional.getDocumento()
                        +"\nDoc2 Nome: " + docsGestorNacional2.getNomeTipoDoc()
                        +"\nDocumento 2: " + docsGestorNacional2.getDocumento()
                        +"\nDoc3: "+ docsGestorNacional3.getNomeTipoDoc()
                        +"\nDocumento 3: " + docsGestorNacional3.getDocumento()
                        +"\nDoc4: " + docsGestorNacional4.getNomeTipoDoc()
                        +"\nDocumento 4: " + docsGestorNacional4.getDocumento()
                        +"\nDoc5: " + docsGestorNacional5.getNomeTipoDoc()
                        +"\nDocumento 5: " + docsGestorNacional5.getDocumento()+"\n");
                
                enderecoGestorNacional.setNomePais(request.getParameter("nome-pais-gn"));
                enderecoGestorNacional.setCodigoPostal(request.getParameter("cod-postal-gn"));
                enderecoGestorNacional.setLogradouro(request.getParameter("nome-logrd-gn"));
                enderecoGestorNacional.setNumero(request.getParameter("nome-num-gn"));
                enderecoGestorNacional.setComplemento(request.getParameter("nome-comple-gn"));
                enderecoGestorNacional.setNomesubdivisao1(request.getParameter("bairro-gn"));
                enderecoGestorNacional.setNomesubdivisao2(request.getParameter("municipio-gn"));
                enderecoGestorNacional.setNomesubdivisao3(request.getParameter("estado-gn"));
                
                
                // Mostrar os dados
                System.err.println();
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
