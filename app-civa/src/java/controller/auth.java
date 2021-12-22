package controller;

import dao.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Login;
import model.Pessoa;

/**
 *
 * @author randel
 */
@WebServlet(name = "auth", urlPatterns = {"/auth"})
public class auth extends HttpServlet {

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
 /* String pathApp = request.getContextPath();*/
            RequestDispatcher rd;

            System.err.println("Entrou no auth");
            // Pegando as informações de loginAcesso
            Login loginAcesso = new Login();
            loginAcesso.setPerfil(request.getParameter("perfil"));
            loginAcesso.setEmail(request.getParameter("email"));
            loginAcesso.setSenha(request.getParameter("senha"));
            loginAcesso.setCodigoCiva(request.getParameter("civa"));

            HttpSession session = request.getSession();
            if (request.getParameter("JSESSIONID") != null) {
                Cookie userCookie = new Cookie("JSESSIONID", request.getParameter("JSESSIONID"));
                response.addCookie(userCookie);
            } else {
                String sessionId = session.getId();
                Cookie userCookie = new Cookie("JSESSIONID", sessionId);
                response.addCookie(userCookie);
              
            }
            // Fazer o devido redirecionamento
            // Para a página do ator adequado
            // Sempre redirecionar para o index.jsp
            Pessoa pessoa = LoginDao.validar(loginAcesso);

            System.out.println("Pessoa nome: " + pessoa.getNomePessoa());
            System.out.println("Pessoa sobrenome: " + pessoa.getSobrenomePessoa());
            System.out.println("Pessoa id: " + pessoa.getIdPessoa());

            if (pessoa != null) {
                session.setAttribute("perfil", loginAcesso.getPerfil());
                System.out.println("Perfil: " + session.getAttribute("perfil"));

                session.setAttribute("dados", pessoa);
                System.out.println("dados nome: " + session.getAttribute("dados"));

                Pessoa pessoa2 = (Pessoa) session.getAttribute("dados");
                System.out.println("dados nome2: " + pessoa2.getNomePessoa());

                session.setAttribute("idPessoa", pessoa.getIdPessoa());
                System.out.println("idpessoa" + session.getAttribute("idPessoa"));

                //session.setMaxInactiveInterval(60 * 90);
                //RequestDispatcher rs = request.getRequestDispatcher("/" + loginAcesso.getPerfil() + "/");
                //rs.forward(request,response);
                response.sendRedirect("/" + loginAcesso.getPerfil() + "/");
                //response.sendRedirect("/portador-civa" + "/");

            } else {
                //Login errado
                System.out.println("Credenciais erradas");
                response.sendRedirect("/exit");
            }

            /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet teste</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet teste at " + request.getContextPath() + "</h1>");
            out.println("Nome: " + pessoa.getNomePessoa() + "</h1>");            
            out.println("Sobrenome: " + pessoa.getSobrenomePessoa()+ "</h1>");            
            out.println("CodigoCiva: " + pessoa.getCodigoCiva()+ "</h1>");            
            out.println("IdPessoa: " + pessoa.getIdPessoa()+ "</h1>");            
            out.println("</body>");
            out.println("</html>");*/
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
