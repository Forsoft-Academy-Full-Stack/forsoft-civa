<!DOCTYPE html>
<html lang="pt-br">

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CIVA</title>

    <link rel="shortcut icon" href="../public/img/Grupo-pc.svg" type="image/x-icon">

    <!-- Google Font: Poppins -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
      rel="stylesheet">


    <!-- Font Icones -->
    <link rel="stylesheet" href="../public/plugins/fontawesome-free/css/all.min.css">

    <!-- Estilo pagina -->
    <link rel="stylesheet" href="../public/dist/css/adminlte.min.css">

  </head>

  <body class="hold-transition sidebar-mini">
    <div class="wrapper">

      <!-- Navbar --------------------------------------------->
      <%@include file="navbar.jspf" %>
      <!-- /.navbar ------------------------------------------------------->

      <!-- MENU Main Sidebar Container ------------------------------------>
      <%@include file="menu.jspf" %>





      <!-- Content Wrapper. Contains page content -------------------------->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
          <div class="container-fluid">
            <div class="row mb-2">
              <div class="col-sm-6">
                <h1 class="m-0">Contatar suporte</h1>
              </div><!-- /.col -->
            </div><!-- /.row -->
          </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header ---------------------------------------------->







        <!-- Main content -->

        <div class="col-12">
          <div class="card card-primary card-outline">
            <div class="card-header">
              <h3 class="card-title">Entre em contato com nosso suporte</h3>
            </div>
            <!-- ./card-header -->
            <div class="card-body">
              <form action="" id="contato-suporte">
                <div class="form-group">
                  <label for="name">Nome</label>
                  <input type="text" class="form-control" id="name" name="name" placeholder="Maria">
                </div>
                <div class="form-group">
                  <label for="email">Email preferido para contato</label>
                  <input type="text" class="form-control" id="email" name="email" placeholder="maria@gmail.com">
                </div>
                <div class="form-group">
                  <label for="problema">Escreva seu problema, d&uacute;vida ou sugest&atilde;o.</label>
                  <textarea id="compose-textarea" id="problema" name="problema" class="form-control"></textarea>
                </div>
              </form>
            </div>
            <!-- ./card-body -->
            <div class="card-footer">
              <div class="float-right">
                <button type="button" class="btn btn-primary" form="contato-suporte" data-toggle="modal"
                        data-target="#modal-default">Enviar</button>
              </div>

            </div>
          </div>
        </div>

        <!-- /.content -->
      </div>
      <!-- /.content-wrapper -->

      <!-- modal start -->
      <%@include file="modal-mensagem-enviada.jspf" %>
      <!-- ./modal -->
      <!-- Main Footer -->
      <%@include file="footer.jspf" %>

    </div>


    <!-- ./wrapper -->

    <!-- REQUIRED SCRIPTS -->

    <!-- jQuery -->
    <script src="../public/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="../public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- AdminLTE App -->
    <script src="../public/dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="../public/dist/js/demo.js"></script>


    <script>
      $('#modal-default').modal('hide');
    </script>

</html>