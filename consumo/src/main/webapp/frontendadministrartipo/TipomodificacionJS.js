function AdministrarTipo() {
    $.ajax({
        url: 'frontendadministrartipo/controladorTipoAdmin.jsp',
        type: 'POST',
        data: {task: 'ingresarAdministrarT',tsk:'mostrarAdministrarT'},
        success: function (cont) {
            $("#contenidoDinamico").html(cont);
        },
        error: function (jqXHR) {
            alert("Error en Administrar Tipo TipomodificacionJS.js" + jqXHR);
        }
    });
}

$("#btnAPIngAP").click(function () {
    AdministracionGuardarTipo();
});

function AdministracionGuardarTipo() {

     var item = "{\"descripcion\": \"" + $('#descripcion').val()
             + "\"}";
     
//    alert(item); 
    $.ajax({
        url: 'frontendadministrartipo/controladorTipoAdmin.jsp',
        type: 'POST',
        data: {task: 'AdministracionGuardarTipo',
            item: item},
        success: function (cont) {
            alert("Se ha guardado correctamente");
            AdministrarTipo();
//            $("#resultado").html("Se ha guardado correctamente");
        },
        error: function (jqXHR) {
            alert("Error en GuardarTipo Tipomodificacion.js" + jqXHR);
        }
    });
    return false;
}

function clicModalMuestraTipo(idtipo) {  
    $.ajax({
        url: "frontendadministrartipo/controladorTipoAdmin.jsp",
        type: "GET",
        data: {task: 'mostrarModalTipo', idTipo: idtipo},
        contentType: "application/json ; charset=UTF-8",
        success: function (cont) {  
//            $("#contenidoDinamico").html(cont);
            $("#resultado").html(cont);
        },
        error: function (error) {
            $("#contenidoDinamico").html("Error");
        }
    });
 }
 
 function clickActTipo(idtipo)
{
    var item = "{\"descripcion\": \"" + $('#descripcionm').val()
             + "\"}";
     
    $.ajax({
        url: 'frontendadministrartipo/controladorTipoAdmin.jsp',
        type: 'POST',
        data: {task: 'tipoModificarGuardar',
            item: item, idTipo: idtipo},
        success: function (cont) {
            alert("Modificación Exitosa.");
            AdministrarTipo();
//            $("#resultado").html("Modificación Exitosa.");
        },
        error: function (jqXHR) {
            alert("Error Modificar Tipomodificacion.js" + jqXHR);
        }
    });
    return false;
}

function clickElimTipo(idtipo)
{
    $.ajax({
        url: 'frontendadministrartipo/controladorTipoAdmin.jsp',
        type: 'POST',
        data: {task: 'tipoEliminar',
            idtipo: idtipo},
        success: function (cont) {
            alert("Se eliminó satisfactoriamente!");
            AdministrarTipo();
//            $("#resultado").html("Se eliminó satisfactoriamente!");
        },
        error: function (jqXHR) {
            alert("Error  Tipo Eliminar Tiponmodificacion.js" + jqXHR);
        }
    });
}