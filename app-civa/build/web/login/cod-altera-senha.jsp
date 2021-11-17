<%@include file="header.jspf"%>
</head>

<body class="login-page " cz-shortcut-listen="true" style="min-height: 465.625px; flex-direction: row; background: fcfeff;">

    <div class="login-box">
        <!-- /.login-logo -->
        <div class="card card-outline card-primary" style="min-width: 400px;">
            <div class="card-header text-center">
                <p class="h1" style="white-space: nowrap;">Recuperar senha</p>
            </div>
            <div class="card-body">
                <p class="login-box-msg">Insira o c&oacute;digo para alterar a senha.</p>
                <form action="recover-password.jsp" method="post">
                    <div class="form-group">
                        <label for="codigo-enviado">C&oacute;digo enviado</label>
                        <input type="text" class="form-control mb-1" placeholder="123456" id="codigo-enviado" name="codigo-enviado">
                        <div class="input-group-append">
                        </div>
                        <p>Não recebeu? <a href="./recuperar-civa.jsp">Reenviar o c&oacute;digo.</a></p>
                        <div class="row">
                            <div class="col-12">
                                <button type="submit" class="btn btn-primary btn-block"> <b>AVAN&Ccedil;AR</b></button>
                            </div>
                            <!-- /.col -->
                        </div>
                </form>
                <div class="d-flex justify-content-center">
                    <p class="mt-3 mb-1 ">
                        <a href="./index.jsp"><b>VOLTAR</b></a>
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