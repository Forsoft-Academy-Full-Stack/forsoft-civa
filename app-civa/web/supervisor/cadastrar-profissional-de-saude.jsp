<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Transformando os dados que foram colocados na sessão
    // em um objeto pessoa novamente
    Pessoa pessoa = (Pessoa) session.getAttribute("dados");
   
    // Verificando se o objeto pessoa não existe e se não é supervisor
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
            <h1 class="m-0">Cadastrar Profissional de Sa&uacute;de</h1>
          </div><!-- /.col -->

          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="./index.jsp">Voltar</a></li>
              <li class="breadcrumb-item active">Cadastrar Profissional de Sa&uacute;de</li>
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
        <h3 class="card-title">Dados Profissional de Sa&uacute;de</h3>
    </div>
    <!-- /.card-header -->
    <!-- form start -->
    <form id="form-meus-dados" action="#" method="post">
        <div class="card-body">
            <%@ include file="../partials/dadospessoais-ps-cadastro.jspf" %>
            <hr>
             <%@ include file="../partials/enderecos-cadastro.jspf" %>
              <hr>
             <%@ include file="../partials/contatos-cadastro.jspf" %>
        </div>
            
    </form>
</div>
          </div>
          

            <div class="col-12 mb-4">
                <button type="submit" class="btn btn-primary btn-lg" form="form-meus-dados">Cadastrar</button>
            </div>
        
          
                  <!-- /.row -->
        </div>


        <!-- /.row -->
      </div>
      </div>
    </div>
    <!-- /.container-fluid -->
            <%@ include file="../partials/modals-cad.jspf" %>

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

document.getElementById('form-meus-dados').onsubmit = tratarCampos;

  function tratarCampos() {
    let erro = false;
    let campos = ['name','surname','genero','date-birth','nacionalidade','tipo-doc-1','doc-1','tipo-doc-2','doc-2','tipo-doc-3','doc-3','country-name', 'postal-code', 'logrd-name','num-name','comple-name','local','city','state','telf','email'];
    
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


</script>

<!-- VIACEP API -->
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
  const html = {
    get(element) {
        return document.querySelector(element);
    }
}

async function getUser() {
    const campoEstado = html.get("#state");
    const campoCidade = html.get("#city");
    const campoBairro = html.get("#local");
    const campoLogradouro = html.get("#logrd-name");
    // const campoDdd = html.get("#inputDdd");
    const cepDigitado = html.get("#postal-code");


    const response = await axios.get(`https://viacep.com.br/ws/${cepDigitado.value}/json/`);
    const estado = response.data.uf;
    const cidade = response.data.localidade;
    const bairro = response.data.bairro;
    const logradouro = response.data.logradouro;
    // const ddd = response.data.ddd;
    



    campoEstado.innerHTML = `<option selected="">${estado}</option>`;
    campoCidade.innerHTML = `<option selected="">${cidade}</option>`;
    campoBairro.innerHTML = `<option selected="">${bairro}</option>`;
    campoLogradouro.value = `${logradouro}` ;
    // campoDdd.value = `${ddd}`;
};
</script>
<script>
  $(function () {
    $('.select2').select2()
  });
</script>
</body>
</html>
