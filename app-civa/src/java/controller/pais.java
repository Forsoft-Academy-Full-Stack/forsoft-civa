package controller;

import dao.SuporteCivaDao;
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
import model.SuporteCiva;
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
            boolean result = false;

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
                            + pais.getNomePais() + "\nContinente: " + pais.getNomeContinente()
                            + "\nDDI: " + pais.getDdi() + "\nPadrão contato: " + pais.getPadraoContato()
                            + "\nOrgão responsavel: " + pais.getOrgaoResponsavel()
                            + "\nFuso horario" + pais.getFusoHorario() + "\n");

                } catch (Exception e) {
                }

                System.err.println("Entrou em cadastrar");

                for (int i = 1; i <= 10; i++) {

                    TipoDoc tipoDoc = new TipoDoc();

                    tipoDoc.setNivel(request.getParameter("tipo-doc" + i));
                    tipoDoc.setNomeDoc(request.getParameter("doc" + i));
                    tipoDoc.setFormatoDoc(request.getParameter("form-doc" + i));
                    tiposDoc.add(tipoDoc);

                    System.err.println("Nível: " + tipoDoc.getNivel() + "\nNome: " + tipoDoc.getNomeDoc() + "\nFormato: " + tipoDoc.getFormatoDoc() + "\n");
                }

                pais.setTiposDoc(tiposDoc);

                try {
                    divisaoTerritorial.setTiposubdivisao1(request.getParameter("subdivisao1"));
                    divisaoTerritorial.setTiposubdivisao2(request.getParameter("subdivisao2"));
                    divisaoTerritorial.setTiposubdivisao3(request.getParameter("subdivisao3"));
                    divisaoTerritorial.setTiposubdivisao4(request.getParameter("subdivisao4"));
                    divisaoTerritorial.setTiposubdivisao5(request.getParameter("subdivisao5"));
                    divisaoTerritorial.setTiposubdivisao6(request.getParameter("subdivisao6"));
                    divisaoTerritorial.setTiposubdivisao7(request.getParameter("subdivisao7"));

                    System.err.println("Sub1: " + divisaoTerritorial.getTiposubdivisao1()
                            + "\nSub2: " + divisaoTerritorial.getTiposubdivisao2()
                            + "\nSub3: " + divisaoTerritorial.getTiposubdivisao3()
                            + "\nSub4: " + divisaoTerritorial.getTiposubdivisao4()
                            + "\nSub5: " + divisaoTerritorial.getTiposubdivisao5()
                            + "\nSub6: " + divisaoTerritorial.getTiposubdivisao6()
                            + "\nSub7: " + divisaoTerritorial.getTiposubdivisao7() + "\n");

                    pais.setDivisaoTerritorial(divisaoTerritorial);

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
                        + "\nSobrenome: " + pessoaGestorNacional.getSobrenomePessoa()
                        + "\nGenero: " + pessoaGestorNacional.getGenero()
                        + "\nData Nascimento: " + pessoaGestorNacional.getDataNascimento()
                        + "\nNacionalidade: " + pessoaGestorNacional.getNacionalidade()
                        + "\nTelefone: " + pessoaGestorNacional.getTelefoneDdd()
                        + "\nE-mail: " + pessoaGestorNacional.getEmail() + "\n");

                gestorNacional.setPessoa(pessoaGestorNacional);

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
                        + "\nDocumento: " + docsGestorNacional.getDocumento()
                        + "\nDoc2 Nome: " + docsGestorNacional2.getNomeTipoDoc()
                        + "\nDocumento 2: " + docsGestorNacional2.getDocumento()
                        + "\nDoc3: " + docsGestorNacional3.getNomeTipoDoc()
                        + "\nDocumento 3: " + docsGestorNacional3.getDocumento()
                        + "\nDoc4: " + docsGestorNacional4.getNomeTipoDoc()
                        + "\nDocumento 4: " + docsGestorNacional4.getDocumento()
                        + "\nDoc5: " + docsGestorNacional5.getNomeTipoDoc()
                        + "\nDocumento 5: " + docsGestorNacional5.getDocumento() + "\n");

                gestorNacional.setDocumento1(docsGestorNacional);
                gestorNacional.setDocumento2(docsGestorNacional2);
                gestorNacional.setDocumento3(docsGestorNacional3);
                gestorNacional.setDocumento4(docsGestorNacional4);
                gestorNacional.setDocumento5(docsGestorNacional5);

                enderecoGestorNacional.setNomePais(request.getParameter("nome-pais-gn"));
                enderecoGestorNacional.setCodigoPostal(request.getParameter("cod-postal-gn"));
                enderecoGestorNacional.setLogradouro(request.getParameter("nome-logrd-gn"));
                enderecoGestorNacional.setNumero(request.getParameter("nome-num-gn"));
                enderecoGestorNacional.setComplemento(request.getParameter("nome-comple-gn"));
                enderecoGestorNacional.setNomesubdivisao1(request.getParameter("bairro-gn"));
                enderecoGestorNacional.setNomesubdivisao2(request.getParameter("municipio-gn"));
                enderecoGestorNacional.setNomesubdivisao3(request.getParameter("estado-gn"));

                System.err.println("Endereco nome: " + enderecoGestorNacional.getNomePais()
                        + "\nCodido Postal: " + enderecoGestorNacional.getCodigoPostal()
                        + "\nLogradouro: " + enderecoGestorNacional.getNumero()
                        + "\nNumero: " + enderecoGestorNacional.getNumero()
                        + "\nComplemento: " + enderecoGestorNacional.getComplemento()
                        + "\nSubdivisao1: " + enderecoGestorNacional.getNomesubdivisao1()
                        + "\nSubdivisao2: " + enderecoGestorNacional.getNomesubdivisao2()
                        + "\nSubdivisao3: " + enderecoGestorNacional.getNomesubdivisao3() + "\n");

                gestorNacional.setEndereco(enderecoGestorNacional);
                // Suporte                
                Pessoa pessoaSuporteCiva = new Pessoa();
                Endereco enderecoSuporteCiva = new Endereco();
                Docs docsSuporteCiva = new Docs();
                Docs docsSuporteCiva2 = new Docs();
                Docs docsSuporteCiva3 = new Docs();
                Docs docsSuporteCiva4 = new Docs();
                Docs docsSuporteCiva5 = new Docs();
                SuporteCiva suporteCiva = new SuporteCiva();

                pessoaSuporteCiva.setNomePessoa(request.getParameter("nome-sp"));
                pessoaSuporteCiva.setSobrenomePessoa(request.getParameter("sobrenome-sp"));
                pessoaSuporteCiva.setGenero(request.getParameter("genero-sp"));
                pessoaSuporteCiva.setDataNascimento(request.getParameter("data-nascimento-sp"));
                pessoaSuporteCiva.setNacionalidade(request.getParameter("nacionalidade-sp"));
                pessoaSuporteCiva.setTelefoneDdd(request.getParameter("tele"));
                pessoaSuporteCiva.setEmail(request.getParameter("email"));

                System.err.println("Nome pessoa: " + pessoaSuporteCiva.getNomePessoa()
                        + "\nSobrenome: " + pessoaSuporteCiva.getSobrenomePessoa()
                        + "\nGenero: " + pessoaSuporteCiva.getGenero()
                        + "\nData Nascimento: " + pessoaSuporteCiva.getDataNascimento()
                        + "\nNacionalidade: " + pessoaSuporteCiva.getNacionalidade()
                        + "\nTelefone: " + pessoaSuporteCiva.getTelefoneDdd()
                        + "\nE-mail: " + pessoaSuporteCiva.getEmail() + "\n");

                suporteCiva.setPessoa(pessoaSuporteCiva);

                docsSuporteCiva.setNomeTipoDoc(request.getParameter("tipo-doc1-sp"));
                docsSuporteCiva.setDocumento(request.getParameter("doc1-sp"));

                docsSuporteCiva2.setNomeTipoDoc(request.getParameter("tipo-doc2-sp"));
                docsSuporteCiva2.setDocumento(request.getParameter("doc2-sp"));

                docsSuporteCiva3.setNomeTipoDoc(request.getParameter("tipo-doc3-sp"));
                docsSuporteCiva3.setDocumento(request.getParameter("doc3-sp"));

                docsSuporteCiva4.setNomeTipoDoc(request.getParameter("tipo-doc4-sp"));
                docsSuporteCiva4.setDocumento(request.getParameter("doc4-sp"));

                docsSuporteCiva5.setNomeTipoDoc(request.getParameter("tipo-doc5-sp"));
                docsSuporteCiva5.setDocumento(request.getParameter("doc5-sp"));

                System.err.println("Doc1 Nome: " + docsSuporteCiva.getNomeTipoDoc()
                        + "\nDocumento: " + docsSuporteCiva.getDocumento()
                        + "\nDoc2 Nome: " + docsSuporteCiva2.getNomeTipoDoc()
                        + "\nDocumento 2: " + docsSuporteCiva2.getDocumento()
                        + "\nDoc3: " + docsSuporteCiva3.getNomeTipoDoc()
                        + "\nDocumento 3: " + docsSuporteCiva3.getDocumento()
                        + "\nDoc4: " + docsSuporteCiva4.getNomeTipoDoc()
                        + "\nDocumento 4: " + docsSuporteCiva4.getDocumento()
                        + "\nDoc5: " + docsSuporteCiva5.getNomeTipoDoc()
                        + "\nDocumento 5: " + docsSuporteCiva5.getDocumento() + "\n");

                suporteCiva.setDocumento1(docsSuporteCiva);
                suporteCiva.setDocumento2(docsSuporteCiva2);
                suporteCiva.setDocumento3(docsSuporteCiva3);
                suporteCiva.setDocumento4(docsSuporteCiva4);
                suporteCiva.setDocumento5(docsSuporteCiva5);

                enderecoSuporteCiva.setNomePais(request.getParameter("nome-pais"));
                enderecoSuporteCiva.setCodigoPostal(request.getParameter("cod-postal"));
                enderecoSuporteCiva.setLogradouro(request.getParameter("nome-logrd"));
                enderecoSuporteCiva.setNumero(request.getParameter("nome-num"));
                enderecoSuporteCiva.setComplemento(request.getParameter("nome-comple"));
                enderecoSuporteCiva.setNomesubdivisao1(request.getParameter("bairro"));
                enderecoSuporteCiva.setNomesubdivisao2(request.getParameter("municipio"));
                enderecoSuporteCiva.setNomesubdivisao3(request.getParameter("estado"));

                System.err.println("Endereco nome: " + enderecoSuporteCiva.getNomePais()
                        + "\nCodido Postal: " + enderecoSuporteCiva.getCodigoPostal()
                        + "\nLogradouro: " + enderecoSuporteCiva.getNumero()
                        + "\nNumero: " + enderecoSuporteCiva.getNumero()
                        + "\nComplemento: " + enderecoSuporteCiva.getComplemento()
                        + "\nSubdivisao1: " + enderecoSuporteCiva.getNomesubdivisao1()
                        + "\nSubdivisao2: " + enderecoSuporteCiva.getNomesubdivisao2()
                        + "\nSubdivisao3: " + enderecoSuporteCiva.getNomesubdivisao3() + "\n");

                suporteCiva.setEndereco(enderecoSuporteCiva);

                try {
                    
                    int idCadastrante = (int) session.getAttribute("idPessoa");
                    result = SuporteCivaDao.insert(suporteCiva, idCadastrante);

                } catch (Exception e) {
                }

                if (!result) {
                    response.sendError(404);
                }

                // Mostrar os dados             
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
