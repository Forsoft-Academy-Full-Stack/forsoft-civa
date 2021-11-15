<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na sessão
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");
   
    // Verificando se o objeto pessoa não existe e se não é usuário
    if ((pessoa == null) || (!session.getAttribute("perfil").equals("supervisor"))) {
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

  <link rel="shortcut icon" href="../public/img/favicon-gs.svg" type="image/x-icon">

  <!-- Google Font: Poppins -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">


 <!-- Google Font: Poppins -->
 <link rel="preconnect" href="https://fonts.googleapis.com">
 <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
 <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">



 <!-- Select2 -->
 <link rel="stylesheet" href="../public/plugins/select2/css/select2.min.css">

 <!-- Estilo icones -->
 <link rel="stylesheet" href="../public/plugins/fontawesome-free/css/all.min.css">
 
 <!-- Estilo pagina -->
 <link rel="stylesheet" href="../public/dist/css/adminlte.min.css">

</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <!-- Navbar --------------------------------------------->
   <%@ include file="navbar.jspf" %>
  <!-- /.navbar ------------------------------------------------------->




  <!-- MENU Main Sidebar Container ------------------------------------>
   <%@ include file="menu.jspf" %>



  <!-- Content Wrapper. Contains page content -------------------------->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Vincular Unidade</h1>
          </div><!-- /.col -->

          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="painel-profissional-saude.jsp">Voltar</a></li>
              <li class="breadcrumb-item active">Vincular Unidade</li>
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
<div class="col-12">
          
          
<div class="card card-primary">
<div class="card-header">
<h3 class="card-title">Dados Unidade</h3>
</div>
<!-- /.card-header -->
<!-- form start -->
<form id="form-meus-dados">
<div class="p-2">
  <div class="row">
    <div class="form-group col-xl-12">
      <label for="id-unidade">ID Unidade</label>
      <input type="text" class="form-control" id="id-unidade" name="id-unidade" value="1234567">
    </div>
  </div>
  <hr>
<div class="row">
  <div class="form-group col-xl-12">
      <label for="name">Nome</label>
      <input type="text" class="form-control" id="name" name="name" value="Hospital" disabled>
  </div>
</div>
<hr>
 <!-- ENDERE&Ccedil;O -->
<div class="row"> 
  <div class="form-group col-6">
    <label for="country-name">Pais</label>
      <input type="text" class="form-control" id="country-name" name="country-name" value="Brazil" disabled>    <!-- Adicionar no JS tratarCampos() -->
  </div>
  <div class="form-group col-6">
      <label for="postal-code">CEP</label>
      <input type="text" class="form-control" id="postal-code" name="postal-code" value="23066-854" disabled>
  </div>
</div>

<div class="row"> 
  <div class="form-group col-6">
    <label for="logrd-name">Endere&ccedil;o</label>
      <input type="text" class="form-control" id="logrd-name" name="logrd-name" value="Rua Logo Ali" disabled>
  </div>
  <div class="form-group col-6">
    <label for="num-name">N&uacute;mero</label>
      <input type="number" class="form-control" id="num-name" name="num-name" value="555" disabled>    <!-- Adicionar no JS tratarCampos() -->
  </div>
</div>


<div class="row">
  <div class="form-group col-6">
    <label for="comple-name">Complemento</label>
      <input type="text" class="form-control" id="comple-name" name="comple-name" value="Anexo 2" disabled>    <!-- Adicionar no JS tratarCampos() -->
  </div>
  <div class="form-group col-xl-6">
    <label for="local">Bairro</label>
    <select class=" form-control select2 select2-hidden-accessible" id="local" name="local" style="width: 100%;" tabindex="-1" aria-hidden="true" disabled="true">
      <option id="local-option" selected="" disabled="">Selecionar</option> 
      <option>Niteroi</option>
      <option>S&atilde;o Gon&ccedil;alo</option>
      <option selected="">Centro</option>
      <option>Itaborai</option>
      <option>Marica</option>
    </select>
  </div>
</div>

<div class="row">
  <div class="form-group col-xl-6">
    <label for="city">Municipio</label>
    <select class="select2 select2-hidden-accessible"  id="city" name="city" style="width: 100%;" tabindex="-1" aria-hidden="true" disabled="true">
      <option id="city-option" selected="" disabled="" >Selecionar</option> 
      <option>Niteroi</option>
      <option>S&atilde;o Gon&ccedil;alo</option>
      <option selected="" >Rio de Janeiro</option>
      <option>Itaborai</option>
      <option>Marica</option>
  </select>
  </div>
  <div class="form-group col-6">
      <label for="state">Estado</label>
      <select class="select2 select2-hidden-accessible" id="state" name="state" style="width: 100%;" tabindex="-1" aria-hidden="true" disabled="true">
        <option id="state-option" disabled="">Selecionar</option>
        <option selected="" >Rio de Janeiro</option>
        <option>S&atilde;o Paulo</option>
        <option>Minas Gerais</option>
        <option>Rio Grande do Sul</option>
        <option>Bahia</option>
    </select>
  </div>
</div>
<!-- //ENDERE&Ccedil;O -->
<div class="row">
  <div class="form-group col-xl-6">
      <label for="telf">Contato</label>
        <input type="text" class="form-control" id="telf" name="telf" value="21987654321" disabled>
  </div>
<div class="form-group col-xl-6">
  <label for="local">Loca&ccedil;&atilde;o</label>
  <select class="select2 select2-hidden-accessible" id="local" name="local" style="width: 100%;" tabindex="-1" aria-hidden="true" disabled>
    <option selected disabled>Fixa</option>
    <option>Movel</option>
  </select>
</div>
</div>
<div class="row">
<div class="form-group col-xl-6">
  <label for="natureza">Loca&ccedil;&atilde;o</label>
  <select class="select2 select2-hidden-accessible" style="width: 100%;" id="natureza" name="natureza" tabindex="-1" aria-hidden="true" disabled>
    <option selected disabled>P&uacute;blica</option>
    <option>Privada</option>
  </select>
</div>
  <div class="form-group col-xl-6">
    <label for="tipo-estab">Tipo de Estabelecimento</label>
    <input type="text" class="form-control" id="tipo-estab" name="tipo-estab" value="Hospital" disabled>
  </div>
</div>
</div>
</div>
          </div>
          

            <div class="col-12 mb-4">
                <button type="submit" class="btn btn-primary btn-lg" form="form-meus-dados">Adicionar</button>
            </div>
        
        
                  <!-- /.row -->
        </div>


        <!-- /.row -->
      </div><!-- /.container-fluid -->
      <%@ include file="../partials/modals-unidade-vinc.jspf" %>
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->



  
 














  <!-- Main Footer -->
 <%@ include file="footer.jspf" %>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS ------------------------------------------------------->

<!-- jQuery -->
<script src="../public/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../public/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Select2 -->
<script src="../public/plugins/select2/js/select2.full.min.js"></script>
<!-- AdminLTE App -->
<script src="../public/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../public/dist/js/demo.js"></script>
<script>
  function tratarCampos() {
    let erro = false;
    let campos = ['id-unidade'];
   
        for (i=0;i<campos.length;i++) {
            if (document.getElementById(campos[i]).value == '') {
                erro = true;
            }
        }

        if (erro) {
            alert('Todos os campos devem ser preenchidos!');
        } else {
            // Exibe o modal desejado, baseado no id definido.
            $('#modal-default').modal('show');
            console.log('funcionou');
            event.preventDefault();

        }

        return !erro;
}
  document.getElementById('form-meus-dados').onsubmit = tratarCampos;
</script>
<script>
  $(function () {
    $('.select2').select2()
  });
</script>
</body>
</html>
