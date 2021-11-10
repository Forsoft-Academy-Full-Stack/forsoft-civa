
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
            Login login = new Login();
          
            login.setPerfil(request.getParameter("perfil"));
            
            if(login.getPerfil().equals("usuario") ){
                login.setEmail(request.getParameter("email"));
                login.setSenha(request.getParameter("senha"));
               
            }else{
                login.setCodigoCiva(request.getParameter("civa"));
                login.setSenha(request.getParameter("senha"));
            }
            
   
       
            // Fazer consulta no Banco de dados, com os dados vindo do formulário de login
            // Pegar os dados da pessoa
            // Construir o objeto Pessoa com os dados obtidos
            
            // Usuário
            Pessoa pessoaPortadorCiva = new Pessoa();
            pessoaPortadorCiva.setNome("João");
            pessoaPortadorCiva.setSobrenome("Lopes");
            
            
            // Gerente
            Pessoa pessoaGerente = new Pessoa();
            pessoaGerente.setNome("Lucia");
            pessoaGerente.setSobrenome("Alves");
            
            // Supervisor
            Pessoa pessoaSupervisor = new Pessoa();
            pessoaSupervisor.setNome("Pedro");
            pessoaSupervisor.setSobrenome("Almeida");
                        
            // Profissional de Saúde
            Pessoa pessoaProfissionalSaude = new Pessoa();
            pessoaProfissionalSaude.setNome("Victoria");
            pessoaProfissionalSaude.setSobrenome("Strada");
            
            // Suporte CIVA
            Pessoa pessoaSuporteCiva = new Pessoa();
            pessoaSuporteCiva.setNome("Maria");
            pessoaSuporteCiva.setSobrenome("Ferreira Gular");
            
            // Gestor Nacional
            Pessoa pessoaGestorNacional = new Pessoa();
            pessoaGestorNacional.setNome("Lucas");
            pessoaGestorNacional.setSobrenome("Santos");
            
            // Gestor OMS
            Pessoa pessoaGestorOms = new Pessoa();
            pessoaGestorOms.setNome("Ruth");
            pessoaGestorOms.setSobrenome("Alencar");
            
            HttpSession session = request.getSession();
      
            // Fazer o devido redirecionamento
            // Para a página do ator adequado
            // Sempre redirecionar para o index.jsp
            
            if (login.getPerfil().equals("usuario") && login.getSenha().equals("123") ) {  
                session.setAttribute("dados", pessoaPortadorCiva);
                session.setAttribute("perfil", login.getPerfil());
                response.sendRedirect("portador-civa/");
                
            }
            else if (login.getPerfil().equals("gerente") && login.getSenha().equals("1234")){
                session.setAttribute("dados", pessoaGerente);
                session.setAttribute("perfil", login.getPerfil());
                response.sendRedirect("gerente/");
                
            }
            else if (login.getPerfil().equals("supervisor") && login.getSenha().equals("12345")){
                session.setAttribute("dados", pessoaSupervisor);                       ;
                session.setAttribute("perfil", login.getPerfil());
                response.sendRedirect("supervisor/");
                
            }
            else if (login.getPerfil().equals("profissional-saude") && login.getSenha().equals("123456")){
                session.setAttribute("dados", pessoaProfissionalSaude);
                session.setAttribute("perfil", login.getPerfil());
                response.sendRedirect("profissional-saude/");
                
            }
            else if (login.getPerfil().equals("suporte-civa") && login.getSenha().equals("1234567")){
                session.setAttribute("dados", pessoaSupervisor);                       ;
                session.setAttribute("perfil", login.getPerfil());
                response.sendRedirect("profissional-saude/");
                
            }
            else if (login.getPerfil().equals("gestor-nacional") && login.getSenha().equals("12345678")){
                session.setAttribute("dados", pessoaSupervisor);                       ;
                session.setAttribute("perfil", login.getPerfil());
                response.sendRedirect("gestor-nacional/");
                
            }
            else if (login.getPerfil().equals("gestor-oms") && login.getSenha().equals("123456789")){
                session.setAttribute("dados", pessoaSupervisor);                       ;
                session.setAttribute("perfil", login.getPerfil());
                response.sendRedirect("gestor-oms/");
            }
            else {
                // Login errado
                response.sendRedirect(" login/");
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
