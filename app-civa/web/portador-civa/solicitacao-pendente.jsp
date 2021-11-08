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
      <!-- /.menu ------------------------------------------------------->


      <!-- Content Wrapper. Contains page content -------------------------->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
          <div class="container-fluid">
            <div class="row mb-2">
              <div class="col-sm-6">
                <h1 class="m-0">Solicita&ccedil;&otilde;es pendentes</h1>
              </div>
              <!-- /.col -->
            </div>
            <!-- /.row -->
          </div>
          <!-- /.container-fluid -->
        </div>
        <!-- /.content-header ---------------------------------------------->



        <!-- Main content -->
        <div class="container-fluid">
          <!---------------------------------------------------------------->

          <section class="content-header">
            <div class="container-fluid">
              <div class="row">
                        <div class="col-sm-12 col-md-6 w-100">
                            <div class="card">
                                <div class="card-header">
                                    Status: <b>Pendente</b>
                                </div>
                                <div class="card-body" style="margin-bottom: -40px;">
                                    <div class="overflow-auto" style="height: 150px;">
                                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nesciunt voluptatem rerum dolorum impedit officiis quae, reiciendis asperiores nam quaerat aliquid velit iste ea ullam assumenda voluptates, molestias dolores
                                            accusamus quisquam!
                                        </p>
                                    </div>

                                    <p class="mt-2">Data solicita&ccedil;&aacute;o: 01/01/2021 </p>
                                </div>
                                <hr>
                                <div class="d-flex justify-content-between align-items-center mx-3 mb-3">
                                    <button class="btn btn-outline-danger" data-toggle="modal"
                  data-target="#modal-default">Cancelar solicita&ccedil;&atilde;o</button>

                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-6 w-100">
                            <div class="card">
                                <div class="card-header">
                                    Status: <b>Pendente</b>
                                </div>
                                <div class="card-body" style="margin-bottom: -40px;">
                                    <div class="overflow-auto" style="height: 150px;">
                                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nesciunt voluptatem rerum dolorum impedit officiis quae, reiciendis asperiores nam quaerat aliquid velit iste ea ullam assumenda voluptates, molestias dolores
                                            accusamus quisquam!
                                        </p>
                                    </div>

                                    <p class="mt-2">Data solicita&ccedil;&atilde;o: 01/01/2021 </p>
                                </div>
                                <hr>
                                <div class="d-flex justify-content-between align-items-center mx-3 mb-3">
                                  <button class="btn btn-outline-danger" data-toggle="modal"
                  data-target="#modal-default">Cancelar solicita&ccedil;&atilde;o</button>

                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <!-- /.container-fluid -->
          </section>
          <!-- /.card-footer-->
        </div>


      </div>
          <!-------------- footer ------------------->
    <%@include file="footer.jspf" %>
    <!--------------- /.footer --------------->
    <%@include file="modal-certeza.jspf" %>
    </div>

    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

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

</body>

</html>