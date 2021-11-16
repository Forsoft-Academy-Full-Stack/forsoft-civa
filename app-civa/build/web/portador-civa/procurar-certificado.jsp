<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("usuario"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%@include file="header.jspf"%>
</head>

<body class="login-page " cz-shortcut-listen="true"
      style="min-height: 465.625px; flex-direction: row; background: fcfeff;">
    <div class="login-box" >
        <!-- /.login-logo -->
        <div class="card card-primary card-outline">
            <div class="card-header">
                <h3 class="card-title" style="text-align: center; float: none; font-size: 1.8rem;">
                    Procurar Certificado CIVA
                </h3>
            </div>
            <div class="card-body" style="height: 50%;">
                <div class="col-md-8 offset-md-2">
                    <form action="simple-results.jsp">
                        <div class="input-group">
                            <input type="search" class="form-control ds-input" placeholder="Digite o c&oacute;digo CIVA">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-primary">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <p class="h1 text-center p-5">PDF</p>
                </div>
                <a href="../login/index.jsp">
                    <button type="button" class="btn btn-block btn-outline-primary">Voltar</button></a>

            </div>
            <!-- /.card -->
            <div class="mt-5 text-center">
                <strong>CIVA &copy; <a href="https://www.forsoftacademy.com.br/">Forsoft Academy</a>.</strong>
            </div>
        </div>
        <!-- /.card -->
    </div>


    <!-- /.login-box -->
</body>

</html>