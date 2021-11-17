<%@include file="header.jspf"%>
</head>

<body class="login-page " cz-shortcut-listen="true" style="min-height: 465.625px; flex-direction: row; background: fcfeff;">

    <div class="login-box">
        <!-- /.login-logo -->
        <div class="card card-outline card-primary">
            <div class="card-header text-center">
                <p class="h1" style="white-space: nowrap;">Recuperar CIVA</p>
            </div>
            <div class="card-body">
                <p class="login-box-msg">O c&oacute;digo CIVA ser&aacute; enviado para o seu email.</p>
                <form action="./recover-password.jsp" method="post">
                    <div class="input-group mb-3">
                        <input type="email" class="form-control" id="email" name="email" placeholder="maria@mail.com">
                        <div class="input-group-append">
                            <div class="input-group-text">
                                <span class="fas fa-envelope"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary btn-block">ENVIAR</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form>
                <div class="d-flex justify-content-center">
                    <p class="mt-3 mb-1 ">
                        <a href="./index.jsp"><b>Voltar</b></a>
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