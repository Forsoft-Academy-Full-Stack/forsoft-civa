<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na seção
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");

    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("portador-civa"))) {
        // Caso for uma das duas opções
        // Redirecionar para o login
        response.sendRedirect("../login/");

    }

    // Caso contrário é um usuário válido, pode entrar na página

%>
<%@include file="header.jspf"%>
<script src="../public/assets/js/portador-civa/nova-senha.js"></script>
</head>

<body class="login-page " cz-shortcut-listen="true"
      style="min-height: 465.625px; flex-direction: row; background: fcfeff;">

    <div class="login-box">
        <!-- /.login-logo -->
        <div class="card card-outline card-primary" style="min-width: 500px;">
            <div class="card-header text-center">
                <p class="h1" style="white-space: nowrap;">Configurar nova senha</p>
            </div>
            <div class="card-body">
                <p class="login-box-msg">Insira a sua nova senha abaixo.</p>
                <form id="nova-senha" method="post">
                    <div class="input-group mb-3">
                        <input type="password" class="form-control" id="senha" name="senha" placeholder="Digite a senha">
                    </div>
                    <div class="input-group mb-3">
                        <input type="password" class="form-control" id="conf-senha" name="conf-senha" placeholder="Confirme a senha">
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <button type="button" class="btn btn-primary btn-block" id="enviar">ENVIAR</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form>
                <div class="d-flex justify-content-center">
                    <p class="mt-3 mb-1 ">
                        <a href="./login.jsp"><b>Voltar</b></a>
                    </p>
                </div>
                <div class="mt-5 text-center">
                    <strong>CIVA &copy; <a href="https://www.forsoftacademy.com.br/">Forsoft Academy</a>.</strong>
                </div>
            </div>
            <!-- /.card-body -->
        </div>
        <!-- /.card -->
    </div>

    <!-- /.login-box -->

</body>
</html>