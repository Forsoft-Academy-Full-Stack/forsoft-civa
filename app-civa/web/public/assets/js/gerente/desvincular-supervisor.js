$('.select2').select2();
campos = ["codigo-civa"];

codigoCiva =  $("#codigo-civa");

$("#pesquisa").click(function () {
    if (tratar_campos(campos)) {
        $.post("/app-civa/desvincularSupervisor", codigoCiva.serialize(), (data, status) => {
            console.log(status, data);
            if (status === 'success') {
                
                Toast.fire({
                    icon: 'success',
                    title: 'Supervisor encontrado'
                })
                
                console.log(data.val, status)

            } else {
                Toast.fire({
                    icon: 'error',
                    title: 'Supervisor não encontrado'
                })
            }
            
            event.preventDefault(); 
        });
    } else {
        Toast.fire({
            icon: 'info',
            title: 'Preencha o campo código civa'
        })
    }
});