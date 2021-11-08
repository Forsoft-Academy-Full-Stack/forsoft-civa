<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>CIVA</title>

  <link rel="shortcut icon" href="./../public/img/favicon-gs.svg" type="image/x-icon">

  <!-- Google Font: Poppins -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link
    href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
    rel="stylesheet">


  <!-- Estilo icones -->
  <link rel="stylesheet" href="../public/plugins/fontawesome-free/css/all.min.css">

  <!-- Estilo pagina -->
  <link rel="stylesheet" href="./../public/dist/css/adminlte.min.css">
  <script src="../public/plugins/sweetalert2/sweetalert2.all.min.js"></script>

</head>

<body class="hold-transition sidebar-mini">
  <div class="wrapper">

    <!-- Navbar --------------------------------------------->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
      <!-- Left navbar links -->
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" data-widget="pushmenu" href="#" role="button">
            <i class="fas fa-bars"></i>
          </a>
        </li>
        <li class="nav-item d-none d-sm-inline-block">
          <a href="" class="nav-link">Portador CIVA</a>
        </li>
      </ul>
    </nav>
    <!-- /.navbar ------------------------------------------------------->
    
    <!-- MENU Main Sidebar Container ------------------------------------>
    <%@ include file="menu.jspf" %>
    <!-- /.sidebar ------------------------------------------------------>

    <!-- Content Wrapper. Contains page content -------------------------->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <div class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-6">
              <h1 class="m-0">Vacina&ccedil;&atilde;o internacional</h1>
            </div><!-- /.col -->
            <div class="col-sm-6">
              <ol class="breadcrumb float-sm-right">
                <li class="breadcrumb-item"><a href="./">Voltar</a></li>
                <li class="breadcrumb-item active">Consultador portador</li>
              </ol>
            </div>
          </div><!-- /.row -->
        </div><!-- /.container-fluid -->
      </div>
      <!-- /.content-header ---------------------------------------------->

      <!-- Main content -->
      <div class="content">
        <div class="container-fluid">
          <!---------------------------------------------------------------->
          <div class="row">
            <div class="col-12 mb-4">
              <form id="vacinacao-internacional">
                <div class="input-group">
                  <input type="search" class="form-control form-control-lg"
                    placeholder="Insira o codigo civa do portador">
                  <div class="input-group-append">
                    <button type="submit" class="btn btn-lg btn-primary">
                      Pesquisar
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>

          <!-- DADOS PORTADOR -->
          <div class="row mb-3">
            <div class="col-12">
              <div class="card card-primary">
                <div class="card-header">
                  <h3 class="card-title">Dados Portador CIVA</h3>
                </div>
                <!-- /.card-header -->
                <!-- form start -->
                <form>
                  <div class="card-body">
                                                                        <%@ include file="../partials/codigociva.jspf" %>
                                                                        <hr>
                                                                        <%@ include file="../partials/dadospessoais-disabled.jspf" %>
                                                                        <hr>
                                                  
                  </div>
                </form>
              </div>
            </div>
          </div>

          <!-- TABELA VACINAS -->
          <div class="row">
            <div class="col-12">
              <div class="card card-primary">
                <div class="card-header">
                  <h3 class="card-title">Hist&oacute;rico de vacinas</h3>
                </div>
                <!-- /.card-header -->
                <div class="card-body table-responsive p-0">
                  <table class="table table-hover text-nowrap">
                    <thead>
                      <tr>
                        <th>Vacina</th>
                        <th>Laborat&oacute;rio</th>
                        <th>Dose</th>
                        <th>Pa&iacute;s</th>
                        <th>Data</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>Coronavac</td>
                        <td>Sinovac</td>
                        <td>1&ordf; Dose</td>
                        <td><span class="tag tag-success">Brasil</span></td>
                        <td>11/03/2021</td>
                      </tr>
                      <tr>
                        <td>Coronavac</td>
                        <td>Sinovac</td>
                        <td>1&ordf; Dose</td>
                        <td><span class="tag tag-success">Brasil</span></td>
                        <td>11/03/2021</td>
                      </tr>
                      <tr>
                        <td>Coronavac</td>
                        <td>Sinovac</td>
                        <td>1&ordf; Dose</td>
                        <td><span class="tag tag-success">Brasil</span></td>
                        <td>11/03/2021</td>
                      </tr>
                      <tr>
                        <td>Coronavac</td>
                        <td>Sinovac</td>
                        <td>1&ordf; Dose</td>
                        <td><span class="tag tag-success">Brasil</span></td>
                        <td>11/03/2021</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <!-- /.card-body -->
              </div>
              <!-- /.card -->
            </div>
          </div>
          <div class="col-12 row">
            <div class="mb-3 mt-3">
              <a href="./cadastrar-vacinacao-internacional.jsp">
                <button type="button" id="cadastro" class="btn btn-primary btn-lg">Cadastrar vacina&ccedil;&atilde;o</button>
              </a>
            </div>
          </div>
          <!-- /.row -->
        </div><!-- /.container-fluid -->
      </div>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <%@ include file="footer.jspf" %>
    <!-- ./footer -->
  </div>
  <!-- ./wrapper -->

  <!-- REQUIRED SCRIPTS -->

  <!-- jQuery -->
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.9/dist/sweetalert2.all.min.js"></script>
  <script src="./../public/plugins/jquery/jquery.min.js"></script>
  <!-- Bootstrap 4 -->
  <script src="./../public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- AdminLTE App -->
  <script src="./../public/dist/js/adminlte.min.js"></script>
  <!-- AdminLTE for demo purposes -->
  <script src="./../public/dist/js/demo.js"></script>
  <script src="../public/assets/js/vacinacao-internacional.js"></script>

  

  <script>
    let form = $("#vacinacao-internacional");
    $("#cadastro").click(function () {

      if (tratar_campos()) {
        $.get("", form.serialize(), (data, status) => {
          if (status === 'success') {
            //$('#exampleModal').modal('hide');
            //$('#exampleModal2').modal('show');
            Swal.fire({
              icon: 'success',
              title: 'Cadastro realizado com sucesso!',
              confirmButtonText: 'Finalizar',
              confirmButtonColor: '#007bff'
            });

            console.log("Dados enviados com sucesso :) !");
            // Limpando os campos do modal de altera&ccedil;&atilde;o e confirma&ccedil;&atilde;o de senha ap&oacute;s o envio
            //$('#exampleModal').find("#confirm-password").val("");
            //$('#exampleModal').find("#message-text").val("");
          } else {
            // Abrir Modal informando o erro
            // Por enquanto mostrar=ndo somente com o console.log()
            console.log("Ops... Algum erro ocorreu e seus dados n&atilde;o foram enviados :(");
            //$('#exampleModal').modal('hide');

            Swal.fire({
              icon: 'error',
              title: '',
              text: 'Ops... Algum erro ocorreu e seus dados n&atilde;o foram enviados :(!',
              confirmButtonText: 'Finalizar'
              //confirmButtonColor: '#007bff'
            });

            //$('#exampleModal').find("#confirm-password").val("");
            //$('#exampleModal').find("#message-text").val("");

          }
        });
      }
    });
  </script>
</body>

</html>