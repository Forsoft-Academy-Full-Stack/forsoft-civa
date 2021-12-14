package controller;

import dao.PessoaDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ludwig Gonzaga
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            boolean result = false;
            String tipo = "";
            int idAtor = -1;
            String path = "";

            String option = request.getParameter("option");

            switch (option) {
                case "validar":
                    System.err.println(request.getParameter("cod-ver"));

                    break;

                case "validar-cod":
                    response.setContentType("application/text");

                    tipo = request.getParameter("tipo");
                    String codigoRecuperacao = request.getParameter("codigo-enviado");
                    idAtor = Integer.parseInt(request.getParameter("idAtor"));

                    // verifica o último cod daquele portador e compara se é igual
                    result = PessoaDao.validarCodigoRecuperacao(idAtor, tipo, codigoRecuperacao);

                    if (!result) {
                        response.sendError(404);
                    }

                    System.err.println(request.getParameter("codigo-enviado"));
                    System.err.println(request.getParameter("tipo"));
                    System.err.println(request.getParameter("idAtor"));
                    System.err.println("Resultado: " + result);

                    path = "'./alterar-senha.jsp?tipo=" + tipo + "&idAtor=" + idAtor + "'";

                    System.err.println("Location: " + path);

                    response.getWriter().write(path);

                    break;
                    
                case "recuperar-civa":
                    response.setContentType("application/text");
                    String email = request.getParameter("email");
                    System.err.println("Email: " + email);
                    
                    int idAcessoPc = PessoaDao.verificarEmail(email, "portador");
                    int idAcessoGestao = PessoaDao.verificarEmail(email, "gestor");
                    String codigoCivaRecuperacao = "";
                    
                    System.err.println("idAcessoPc: " + idAcessoPc);
                    System.err.println("idAcessoGestao: " + idAcessoGestao);
                    
                   
                    
                    if(idAcessoPc != -1){
                         codigoCivaRecuperacao = PessoaDao.getCodigoCivaByEmail(email, "portador");
                         System.err.println("codigoCivaRecuperacao: " + codigoCivaRecuperacao);
                         
                    }else if(idAcessoGestao != -1){
                         codigoCivaRecuperacao = PessoaDao.getCodigoCivaByEmail(email, "gestor");
                    }
                    
                    if (idAcessoPc == -1 && idAcessoGestao == -1) {
                        response.sendError(404);
                    }                     
                    
                   response.getWriter().write(codigoCivaRecuperacao);
                    
                    break;

                case "nova-senha":
                    response.setContentType("application/text");

                    String novaSenha = request.getParameter("nova-senha");

                    System.err.println(request.getParameter("nova-senha"));
                    System.err.println(request.getParameter("confimar-senha"));

                    tipo = request.getParameter("tipo");
                    System.err.println(request.getParameter("tipo"));

                    idAtor = Integer.parseInt(request.getParameter("idAtor"));

                    if (tipo.endsWith("portador")) {
                        // Alterar senha do portador
                        System.err.println(request.getParameter("idAtor"));
                        result = PessoaDao.updateAcessoPcSenha(novaSenha, idAtor);

                    } else if (tipo.endsWith("gestor")) {
                        // Alterar senha do gestor
                        System.err.println(request.getParameter("idAtor"));
                           result = PessoaDao.updateAcessoGestaoSenha(novaSenha, idAtor);
                    }

                    if (!result) {
                        response.sendError(404);
                    }

                    path = "'./'";
                    // String location = "{ 'success': true, 'location': "+path+" }";

                    System.err.println("Location: " + path);

                    response.getWriter().write(path);

                    break;

                case "recuperar-senha":
                    tipo = request.getParameter("tipo");
                    email = request.getParameter("email");

                    switch (tipo) {
                        case "portador":
                             String codigo = "";

                            // verificar se email existe
                            System.err.println("Estrou no portador");
                            idAcessoPc = PessoaDao.verificarEmail(email, tipo);
                            System.err.println("idAcessoPc: " + idAcessoPc);
                            if (idAcessoPc != -1) {
                                // Criar o código de recuperação
                                codigo = PessoaDao.gerarCodigoRecuperacao(idAcessoPc, tipo, email);
                                System.err.println("Resultado: " + codigo);
                                 result = true;
                            }

                            if (!result) {
                                response.sendError(404);
                            }

                            response.setContentType("application/text");

                            //request.setAttribute("idAcessoPc", idAcessoPc);
                            //request.setAttribute("tipo", tipo);
                            //RequestDispatcher rd =  request.getRequestDispatcher("login/alterar-senha.jsp"); 
                            //rd.forward(request, response);  
                            // String path = "'./alterar-senha.jsp?tipo=" + tipo + "&idAtor=" + idAcessoPc + "'";
                            path = "'./cod-altera-senha.jsp?tipo=" + tipo + "&idAtor=" + idAcessoPc + "&codigo="+codigo+"'";
                            // String location = "{ 'success': true, 'location': "+path+" }";

                            System.err.println("Location: " + path);

                            response.getWriter().write(path);
                            //response.sendRedirect("./alterar-senha.jsp?tipo="+tipo+"&idAcessoPc="+idAcessoPc);

                            break;

                        case "gestor":
                            codigo = "";
                            // verificar se email existe
                            idAcessoGestao = PessoaDao.verificarEmail(email, tipo);

                            if (idAcessoGestao != -1) {
                                codigo = PessoaDao.gerarCodigoRecuperacao(idAcessoGestao, tipo, email);
                                result = true;
                            }

                            if (!result) {
                                response.sendError(404);
                            }

                            response.setContentType("application/text");
                            path = "'./cod-altera-senha.jsp?tipo=" + tipo + "&idAtor=" + idAcessoGestao + "&codigo="+codigo+"'";
                            System.err.println("Location: " + path);

                            response.getWriter().write(path);

                            break;
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
