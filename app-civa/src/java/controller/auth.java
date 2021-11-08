
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            
            System.err.println("Login: " + login.getPerfil());
       
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
      
            // Fazer o devido redirecionamento
            // Para a página do ator adequado
            // Sempre redirecionar para o index.jsp
            switch(login.getPerfil()){
                case "usuario":
                    request.getSession().setAttribute("dados", pessoaPortadorCiva);
                    request.setAttribute("dados", pessoaPortadorCiva);
                    rd = request.getRequestDispatcher("portador-civa/");
                    rd.forward(request, response);
                    break;
                    
                case "gerente":
                    request.getSession().setAttribute("dados", pessoaGerente);
                    request.setAttribute("dados", pessoaGerente);
                    rd = request.getRequestDispatcher("gerente/");
                    rd.forward(request, response);
                    break;
                   
                case "supervisor":
                    request.getSession().setAttribute("dados", pessoaSupervisor);                       ;
                    request.setAttribute("dados", pessoaSupervisor);
                    rd = request.getRequestDispatcher("supervisor/");
                    rd.forward(request, response);
                    break;
                    
                case "profissional-saude":
                    request.getSession().setAttribute("dados", pessoaProfissionalSaude);
                    request.setAttribute("dados", pessoaProfissionalSaude);
                    rd = request.getRequestDispatcher("profissional-saude/");
                    rd.forward(request, response);
                    break;
                    
                case "suporte-civa":
                    request.getSession().setAttribute("dados", pessoaSuporteCiva);                    
                    request.setAttribute("dados", pessoaSuporteCiva);
                    rd = request.getRequestDispatcher("suporte-civa/");
                    rd.forward(request, response);
                    break;
                    
                case "gestor-nacional":
                    request.getSession().setAttribute("dados", pessoaGestorNacional);                    
                    request.setAttribute("dados", pessoaGestorNacional);
                    rd = request.getRequestDispatcher("gestor-nacional/");
                    rd.forward(request, response);
                    break;
                    
                case "gestor-oms":
                    request.getSession().setAttribute("dados", pessoaGestorOms);
                    request.setAttribute("dados", pessoaGestorOms);
                    rd = request.getRequestDispatcher("gestor-oms/");
                    rd.forward(request, response);
                    break;
                    
                case "not-user":
                    String redirectURL = "./login/";               
                    response.sendRedirect(redirectURL);
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
