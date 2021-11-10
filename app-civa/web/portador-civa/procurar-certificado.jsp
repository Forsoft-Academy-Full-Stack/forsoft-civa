<%
if ((session.getAttribute("dados") == null) || (session.getAttribute("perfil") != "usuario" )) { 
    response.sendRedirect("../login/");
} 
%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CIVA</title>

        <link rel="shortcut icon" href="../public/img/favicon-pc.svg" type="image/x-icon">

        <!-- Google Font: Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
            rel="stylesheet">


        <!-- Font Icons Google -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">


        <!-- Font Icones -->
        <link rel="stylesheet" href="../public/plugins/fontawesome-free/css/all.css">

        <!-- Estilo pagina -->
        <link rel="stylesheet" href="../public/dist/css/adminlte.min.css">

        <!-- Estilo Adicional -->
        <link rel="stylesheet" href="../public/dist/css/style.css">


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

        <!-- REQUIRED SCRIPTS -->

        <!-- jQuery -->
        <script src="../public/plugins/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="../public/plugins/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE App -->
        <script src="../public/dist/js/adminlte.min.js"></script>


        <!-- VERIFICA O CAMPO 
        <script src="./verifica-campo.js"></script>-->
    </body>

</html>