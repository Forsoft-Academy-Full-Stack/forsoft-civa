$('.select2').select2();

$(function () {
    $.validator.setDefaults({
        submitHandler: function () {
            alert("Form successful submitted!");
        }
    });
    $('#form-cadastrar-gestor').validate({
        rules: {
            nome: {
                required: true,
            },
            sobrenome: {
                required: true,
            },
            identidade: {
                required: true,
            },
            datadenascimento: {
                required: true,
            },
            email: {
                required: true,
                email: true,
            },
            contato: {
                required: true,
            },
            nacionalidade: {
                required: true,
            },
            codigopostal: {
                required: true,
            },
            endereco: {
                required: true,
            },
            numero: {
                required: true,
            },
            complemento: {
                required: true,
            },
            subdiv1: {
                required: true,
            },
            subdiv2: {
                required: true,
            },
            subdiv3: {
                required: true,
            },

        },

        errorElement: 'span',
        errorPlacement: function (error, element) {
            error.addClass('invalid-feedback');
            element.closest('.form-group').append(error);
        },
        highlight: function (element, errorClass, validClass) {
            $(element).addClass('is-invalid');
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).removeClass('is-invalid');
        }
    });
});

function tratarCampos() {
    let erro = false;
    let campos = ['name', 'surname', 'identity', 'date-birth', 'nationality', 'tel', 'email'];

    for (i = 0; i < campos.length; i++) {
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

document.getElementById('form-cadastrar-gestor').onsubmit = tratarCampos;
