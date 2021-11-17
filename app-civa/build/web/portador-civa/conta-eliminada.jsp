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
</head>

<body class="hold-transition sidebar-mini">
    <!-- Main content -->
    <div class="modal fade show " id="modal-default" style="display: block; padding-right: 17px;" aria-modal="true">
        <div class="modal-dialog ">
            <div class="modal-content card-primary card-outline">
                <div class="card-body">
                    <div class="col d-flex flex-column justify-content-center align-items-center">
                        <img src="../public/img/confirmacao.svg" alt="Dados eliminados"><br>

                        <p class="text-center">Conta deletada</p>
                        <p>Seus dados foram exclu&iacute;dos com sucesso.</p>
                        <div class="">

                            <a href="../login/index.jsp"><button type="button" class="btn btn-primary">Concluir</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.modal-content -->

    </div>
    <!-- /.modal-dialog -->
</body>

</html>