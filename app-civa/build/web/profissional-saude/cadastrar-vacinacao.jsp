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



  <!-- Select2 -->
  <link rel="stylesheet" href="./../public/plugins/select2/css/select2.min.css">

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
              <h1 class="m-0">Cadastrar nova vacina&ccedil;&atilde;o</h1>
            </div><!-- /.col -->
            <div class="col-sm-6">
              <ol class="breadcrumb float-sm-right">
                <li class="breadcrumb-item"><a href="./painel-portador.jsp">Voltar</a></li>
                <li class="breadcrumb-item active">Painel portador CIVA</li>
              </ol>
            </div>
          </div><!-- /.row -->
        </div><!-- /.container-fluid -->
      </div>

      <!-- Main content -->
      <div class="content">
        <div class="container-fluid">
          <!---------------------------------------------------------------->

          <!-- DADOS PORTADOR -->
          <div class="row">
            <div class="col-12">
              <div class="card card-primary">
                <div class="card-header">
                  <h3 class="card-title">Dados portador</h3>
                </div>
                <div class="card-body">
                  <div class="row">
                    <div class="form-group col-xl-6">
                      <label for="nome">Nome</label>
                      <input type="text" class="form-control" id="nome" name="nome" placeholder="Ex: Frank" value="Elis"
                        disabled>
                    </div>
                    <div class="form-group col-xl-6">
                      <label for="sobrenome">Sobrenome</label>
                      <input type="text" class="form-control" id="sobrenome" name="sobrenome" placeholder="Ex: Sinatra"
                        value="Regina" disabled>
                    </div>
                  </div>
                  <div class="row">
                    <div class="form-group col-xl-6">
                      <label for="data-nasc">Data de Nascimento</label>
                      <input type="date" class="form-control" id="data-nasc" name="data-nasc" value="1945-05-17"
                        disabled>
                    </div>
                    <div class="form-group col-xl-6">
                      <label for="identidade">Documento</label>
                      <input type="text" class="form-control" id="identidade" name="identidade" value="884.054.264-05" disabled>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- DADOS VACINAÇÃO -->
          <form class="row" id="form-painel-portador" >
            <div class="col-12 mb-4">
              <div class="card card-primary">
                <div class="card-header">
                  <h3 class="card-title">Dados vacina&ccedil;&atilde;o</h3>
                </div>
                <!-- /.card-header -->
                <!-- form start -->
                <div class="card-body">
                  <div class="row">
                    <div class="form-group col-xl-6">
                      <label for="laboratorio">Laborat&oacute;rio</label>
                      <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                        aria-hidden="true" name="laboratorio" id="laboratorio">
                        <option selected disabled value="">Selecionar</option>
                        <option>BioNTech</option>
                        <option>Oxford</option>
                        <option>Sputnik V</option>
                      </select>
                    </div>
                    <div class="form-group col-xl-6">
                      <label for="vacina">Vacina</label>
                      <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                        aria-hidden="true" name="vacina" id="vacina" >
                        <option selected disabled value="">Selecionar</option>
                        <option>Pfizer</option>
                        <option>AstraZeneca</option>
                        <option>Johnson & Johnson</option>
                      </select>
                    </div>
                  </div>
                  <div class="row">
                    <div class="form-group col-xl-6">
                      <label for="numerodoses">N&uacute;mero da dose</label>
                      <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                        aria-hidden="true" name="numerodoses" id="numerodoses">
                        <option selected disabled value="">Selecionar</option>
                        <option>1&ordf Dose</option>
                        <option>2&ordf Dose</option>
                        <option>Dose unica</option>
                      </select>
                    </div>
                    <div class="form-group col-xl-6">
                      <label for="lote">Lote</label>
                      <input type="text" class="form-control" name="lote" id="lote" placeholder="Ex: 123123-21">
                    </div>
                  </div>
                  <div class="row">
                    <div class="form-group col-12">
                      <label for="unidade">Unidade da vacina&ccedil;&atilde;o</label>
                      <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                        aria-hidden="true" id="unidade" name="unidade">
                        <option selected disabled value="">Selecionar</option>
                        <option>Hospital Pan</option>
                        <option>Hospital Casa Italiano</option>
                        <option>Hospital Federal do Andaraí</option>
                      </select>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- /.row -->
          </form>

          <div class="row">
            <div class="col-12 mb-4">
              <button type="button" class="btn btn-primary btn-lg" id="cadastro">Cadastrar</button>
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

  <!-- REQUIRED SCRIPTS ------------------------------------------------------->

  <!-- jQuery -->
  <script src="./../public/plugins/jquery/jquery.min.js"></script>
  <!-- Bootstrap 4 -->
  <script src="./../public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Select2 -->
  <script src="./../public/plugins/select2/js/select2.full.min.js"></script>


  <!-- AdminLTE App -->
  <script src="./../public/dist/js/adminlte.min.js"></script>
  <!-- AdminLTE for demo purposes -->
  <script src="./../public/dist/js/demo.js"></script>
  <script src="./../public/assets/js/cadastrar-vacinacao.js"></script>
  <script>
    $(function () {
      $('.select2').select2()
    });
  </script>
  
</body>

</html>
