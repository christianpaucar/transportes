function IngresarTipo() {
    $.ajax({
        url: 'frontendtipo/controladorTipo.jsp',
        type: 'POST',
        data: {task: 'tipoIngresar', tsk:'mostrarTipo'},
        success: function (cont) {
            $("#contenidoDinamico").html(cont);
        },
        error: function (jqXHR) {
            alert("Error al ingresartipo.js" + jqXHR);
        }
    });
}

$("#btnAPIngAP").click(function () {
    TipoGuardar()();
});

function TipoGuardar() {

    var item = "{descripcion: " + $('#tipoip').val()+ "}";

    alert(item); 
    $.ajax({
        url: 'frontendtipo/controladorTipo.jsp',
        type: 'POST',
        data: {task: 'TipoGuardar',
            item: item},
        success: function (cont) {
            $("#estadoingreso").html(cont);
          
            
        },
        error: function (jqXHR) {
            alert("Error Tipo Publicacion Guardar.js" + jqXHR);
        }
    });

    return false;
}

function clicModalMuestra(idap) {  
    alert(idap);
    $.ajax({
        url: "AccionPersonal/controladorAP.jsp",
        type: "GET",
        data: {task: 'ModAP', tsk: 'mostrarModAP', idap: idap},
        contentType: "application/json ; charset=UTF-8",
        success: function (datos) {  
            var data = JSON.parse(datos);
            $("#contenidoDinamico").html(data.contenidoDinamico);
        }
        ,
        error: function (error) {
            $("#contenidoDinamico").html("Error");
        }
    });
}
