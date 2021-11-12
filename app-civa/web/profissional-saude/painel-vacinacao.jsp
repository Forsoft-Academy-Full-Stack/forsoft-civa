<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na sessão
    // em um objeto pessoa novamente
    
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");
   
    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("profissional-saude"))) {
        // Caso for uma das duas opções
        // Redicionar para o login
        response.sendRedirect("../login/");

    }
    
   // Caso contrário é um usuário válido, pode entrar na página  
%>
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
              <h1 class="m-0">Painel vacina&ccedil;&atilde;o</h1>
            </div><!-- /.col -->
            <div class="col-sm-6">
              <ol class="breadcrumb float-sm-right">
                  <li class="breadcrumb-item"><a href="./gerenciar-portador.jsp">Voltar</a></li>
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
            <div class="col-12 mb-4">
              <div class="card card-primary">
                <div class="card-header">
                  <h3 class="card-title">Dados portador</h3>
                </div>
                <div class="card-body">
                  <div class="row">
                    <div class="form-group col-xl-6">
                      <label for="name">Nome</label>
                      <input type="text" id="name" id="name" class="form-control"  value="Elis" disabled>
                    </div>
                    <div class="form-group col-xl-6">
                      <label for="surname">Sobrenome</label>
                      <input type="text" id="surname" name="surname" class="form-control" value="Regina" disabled>
                    </div>
                  </div>
                  <div class="row">
                    <div class="form-group col-xl-6">
                        <label for="date-birth">Data de nascimento</label>
                        <input type="date" id="date-birth" name="date-birth"
                            class="form-control" placeholder="00/00/0000" disabled>
                    </div>
                    <div class="form-group col-xl-6">
                        <label for="doc">Documento</label>
                        <input type="text" id="doc" name="doc"
                         class="form-control"placeholder="884.054.264-05" disabled>
                    </div>
                </div>
                </div>
              </div>
            </div>
          </div>

          <!-- DADOS VACINA&ccedil;&atildeO -->
          <form class="row" id="form-painel-vacinacao" >
            <div class="col-12 mb-4">
              <div class="card card-primary">
                <div class="card-header">
                  <h3 class="card-title">Dados vacina&ccedil;&atilde;o</h3>
                </div>
                <!-- /.card-header -->
                <div class="card-body">
                  <div class="row">
                    <div class="form-group col-xl-12">
                      <label for="idvacinacao">ID vacina&ccedil;&atilde;o</label>
                      <input type="text" class="form-control" id="idvacinacao" name="idvacinacao" value="5649841"
                        readonly>
                    </div>
                  </div>
                  <div class="row">
                    <div class="form-group col-xl-6">
                      <label for="vacina">Vacina</label>
                      <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                        aria-hidden="true" id="vacina" name="vacina" disabled>
                        <option value="2" selected>CoronaVac</option>
                        <option value="3">Pfizer</option>
                        <option value="3">AstraZeneca</option>
                      </select>
                    </div>
                    <div class="form-group col-xl-6">
                      <label for="laboratorio">Laborat&oacute;rio</label>
                      <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                        aria-hidden="true" id="laboratorio" name="laboratorio" disabled>
                        <option value="2" selected>Sinovac</option>
                        <option value="3">Oxford</option>
                        <option value="3">Sputinik V</option>
                      </select>
                    </div>
                  </div>
                  <div class="row">
                    <div class="form-group col-xl-6">
                      <label for="dose">Dose</label>
                      <select class="select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1"
                        aria-hidden="true" id="dose" name="dose" disabled>
                        <option value="2" selected>2Â° Dose</option>
                        <option value="3">1Â° Dose</option>
                        <option value="3">Dose unica</option>
                      </select>
                    </div>
                    <div class="form-group col-xl-6">
                      <label for="dataaplicacao">Data de aplica&ccedil;;&atilde;o</label>
                      <input type="date" class="form-control" value="2021-03-17" id="dataaplicacao" name="dataaplicacao"
                        disabled>
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="form-group col-xl-12">
                      <label for="pais">Pa&iacute;s</label>
                      <input type="text" class="form-control" id="pais" name="pais" value="Brasil" disabled>
                    </div>
                  </div>
                  <div class="row">
                    <div class="form-group col-xl-6">
                      <label for="idunidade">ID unidade</label>
                      <input type="text" class="form-control" id="idunidade" name="idunidade" value="6518842" disabled>
                    </div>
                    <div class="form-group col-xl-6">
                      <label for="unidade">Unidade de vacina&ccedil;&atilde;o</label>
                      <input type="text" class="form-control" id="unidade" name="unidade" value="Hospital Pan" disabled>
                    </div>
                  </div>
                  <div class="row">
                    <div class="form-group col-xl-6">
                      <label for="codigociva">C&oacute;digo CIVA profissional</label>
                      <input type="text" class="form-control" id="codigociva" name="codigociva" value="BRA55123456789"
                        disabled>
                    </div>
                    <div class="form-group col-xl-6">
                      <label for="lote">Lote</label>
                      <input type="text" class="form-control" id="lote" name="lote" value="12412412-21" disabled>
                    </div>
                  </div>
                  
                  <!--<div class="d-flex justify-content-between align-items-center">
                    <div id="toggle-user">
                     <div class="custom-control custom-switch">
                        <input type="checkbox" class="custom-control-input bg-success" id="customSwitch2" checked>
                        <label class="custom-control-label" for="customSwitch2"></label><b
                          class="text-primary">ATIVADO</b>
                      </div>
                    </div>
                  </div>-->
                </div>
              </div>
            </div>
          </form>
          <!-- /.row -->
          <div class="row">
            <div class="col-12 mb-4">
              <button type="button" class="btn btn-primary btn-lg" id="salvar">Salvar</button>
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
  <script src="./../public/assets/js/painel-vacinacao.js"></script>

  <script>
    $(function () {
      $('.select2').select2()
    });

    let form = $("#form-painel-vacinacao");

    $("#salvar").click(function () {

      if (tratar_campos()) {
        $.get("", form.serialize(), (data, status) => {
          if (status === 'success') {
           
            Swal.fire({
              icon: 'success',
              title: 'Dados alterados com sucesso!',
              text: "Altera&ccedil;&atildeo realizada.",
              confirmButtonText: 'Finalizar',
              confirmButtonColor: '#007bff'
            });

            console.log("Dados enviados com sucesso :) !");
            
          } else {
           
            console.log("Ops... Algum erro ocorreu e seus dados n&atildeo foram enviados :(");

            Swal.fire({
              icon: 'error',
              title: '',
              text: 'Ops... Algum erro ocorreu e seus dados n&atildeo foram enviados :(!',
              confirmButtonText: 'Finalizar'
            });
          }
        });
      } else {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Todos os campos precisam ser preenchidos!',
          confirmButtonColor: '#007bff'
        })
      }
    });



  </script>
</body>

</html>