package controller;

import dao.AdministradorOmsDao;
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
import model.AdministradorOms;
import model.Docs;
import model.Endereco;
import model.Pessoa;

@WebServlet(name = "administradorOms", urlPatterns = {"/administradorOms"})
public class administradorOms extends HttpServlet {

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

            AdministradorOms administradorOms = new AdministradorOms();
            Pessoa pessoa = new Pessoa();
            Docs documento1 = new Docs();
            Endereco endereco = new Endereco();

            String option = request.getParameter("option");

            HttpSession session = request.getSession();

            switch (option) {
                case "cadastrar":
                    System.err.println("Entro");
                    pessoa.setNomePessoa(request.getParameter("nome"));
                    pessoa.setSobrenomePessoa(request.getParameter("sobrenome"));
                    pessoa.setGenero(request.getParameter("genero"));
                    pessoa.setDataNascimento(request.getParameter("data-nascimento"));
                    pessoa.setNacionalidade(request.getParameter("nacionalidade"));
                    pessoa.setTelefoneDdd(request.getParameter("tele"));
                    pessoa.setEmail(request.getParameter("email"));

                    documento1.setNomeTipoDoc(request.getParameter("tipo-doc1"));
                    documento1.setDocumento(request.getParameter("doc1"));

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

                    administradorOms.setPessoa(pessoa);
                    administradorOms.setDocumento1(documento1);
                    administradorOms.setEndereco(endereco);

                    int idCadastrante = (int) session.getAttribute("idPessoa");

                    Boolean result = AdministradorOmsDao.insert(administradorOms, idCadastrante);

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

                    documento1.setNomeTipoDoc(request.getParameter("tipo-doc1"));
                    documento1.setDocumento(request.getParameter("doc1"));
                    documento1.setIdTipoDoc(DocsDao.findIdTipodoc(documento1.getNomeTipoDoc()));
                    documento1.setIdDocs(DocsDao.getIdDocs(pessoa.getIdPessoa(), documento1.getIdTipoDoc()));

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

                    administradorOms.setPessoa(pessoa);
                    administradorOms.setDocumento1(documento1);
                    administradorOms.setEndereco(endereco);

                    result = AdministradorOmsDao.update(administradorOms);

                    if (!result) {
                        response.sendError(404);
                    }

                    break;

                case "deletar":
                    System.err.println("deletado");
                    System.err.println(request.getParameter("codigo-civa"));
                    String codigoCiva = request.getParameter("codigo-civa");

                    pessoa.setIdPessoa(PessoaDao.getIdPessoa(codigoCiva));
                    administradorOms.setPessoa(pessoa);

                    result = AdministradorOmsDao.delete(administradorOms);

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
