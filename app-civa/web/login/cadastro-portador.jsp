<%@page import="model.Pais"%>
<%@page import="dao.PaisDao"%>
<%@page import="dao.ContinenteDao"%>
<%@page import="java.util.List"%>
<%@page import="model.Continente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
try {      
    
         List<Pais> paises = PaisDao.listPais();
          pageContext.setAttribute("paises", paises);
            
        } catch (Exception e) {
        }

%>
<%@include file="header.jspf"%>
   <script src="../public/assets/js/login/cadastrar-portador.js" defer></script>
</head>

<body class="content-wrapper" style="background: #fff;">
        <!-- Main content -->
        <%@include file="navbar.jspf" %>
        <div class="container d-flex align-items-center justify-content-center">
            <!-- Default box -->
            <div class="mb-0">
                <div class="card-body row">
                    <div class="card card-primary card-outline" style="min-width: 800px;">
                        <div class="card-header">
                            <h3 class="card-title">Dados Pessoais</h3>
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form id="form-meus-dados">
                            <div class="card-body">                     
                                <%@ include file="../partials/dadospessoais-cadastro.jspf" %>
                                <hr  class = "mb-4 mt-4">
                                <%@ include file="../partials/enderecos-cadastro.jspf" %>
                                <hr  class = "mb-4 mt-4">
                                <%@ include file="../partials/contatos-cadastro.jspf" %>
                                <hr  class = "mb-4 mt-4">
                                <%@ include file="../partials/senha-cadastro.jspf" %>
                                <input type="hidden" vslue="cadastrar" name="option">
                                <div class="form-check">
                                    <input type="checkbox" class="form-check-input" id="termos-uso">
                                    <label class="form-check-label" for="termos-uso">Li e concordo com os <a href="./termo-uso.jsp">Termos de Uso e Pol&iacute;ticas de Privacidade.</a></label>
                                </div>
                                <div class="mb-3 mt-3 d-flex justify-content-center">
                                    <a href="../" class="btn btn-secondary btn-lg mr-3">Voltar</a>
                                    <button type="button" class="btn btn-primary btn-lg" id="salvar">Cadastrar</button>
                                </div>
                            </div>
                        </form>
                            
                    </div>
                </div>
                <%@include file="conta-criada.jspf" %>
                                
            </div>
                
        </div>
        <%@include file="footer.jspf" %>

</body>
</html>
