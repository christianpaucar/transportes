function AdministrarPublicacion() {
    $.ajax({
        url: 'frontendmodelimin/controladorModificacion.jsp',
        type: 'POST',
        data: {task: 'ingresarAdministrarP',tsk:'mostrarAdministrarP'},
        success: function (cont) {
            $("#contenidoDinamico").html(cont);
        },
        error: function (jqXHR) {
            alert("Error en el modificarJS" + jqXHR);
        }
    });
}

$("#btnAPIngAP").click(function () {
    AdministracionGuardar()();
});

function AdministracionGuardar() {

     var item = "{\"autor\": \"" + $('#autor').val()
            + "\", \"url\": \"" + $("#url").val()
            + "\", \"descripcion\": \"" + $('#descripcion').val()
            + "\", \"correo\": \"" + $('#correo').val()
            + "\", \"coautor\": \"" + $('#coautor').val()
            + "\", \"tipo\": \"" + $('#tipo').val()
             + "\"}";
     
//    alert(item); 
    $.ajax({
        url: 'frontendmodelimin/controladorModificacion.jsp',
        type: 'POST',
        data: {task: 'AdministracionGuardar',
            item: item},
        success: function (cont) {
            alert("Se ha guardado correctamente");
            AdministrarPublicacion();
//            $("#resultado").html("Se ha guardado correctamente");
        },
        error: function (jqXHR) {
            alert("Error en Publicacion Publicacionmodificacion.js" + jqXHR);
        }
    });
    return false;
}

function clicModalMuestra(idap) {  
    $.ajax({
        url: "frontendmodelimin/controladorModificacion.jsp",
        type: "GET",
        data: {task: 'mostrarModalPub', idPub: idap},
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
 
 function clickActPublicacion(idpub)
{
    var item = "{\"autor\": \"" + $('#autorm').val()
            + "\", \"url\": \"" + $("#urlm").val()
            + "\", \"descripcion\": \"" + $('#descripcionm').val()
            + "\", \"correo\": \"" + $('#correom').val()
            + "\", \"coautor\": \"" + $('#coautorm').val()
            + "\", \"tipo\": \"" + $('#tipom').val()
            + "\"}";
     
    $.ajax({
        url: 'frontendmodelimin/controladorModificacion.jsp',
        type: 'POST',
        data: {task: 'publicacionModificarGuardar',
            item: item, idPub: idpub},
        success: function (cont) {
            alert("Modificación Exitosa.");
            AdministrarPublicacion();
//            $("#resultado").html("Modificación Exitosa.");
        },
        error: function (jqXHR) {
            alert("Error Modificar Publicacionmodificacion.js" + jqXHR);
        }
    });
    return false;
}

function clickElimPublicacion(idpub)
{
    $.ajax({
        url: 'frontendmodelimin/controladorModificacion.jsp',
        type: 'POST',
        data: {task: 'publicacionEliminar',
            idpub: idpub},
        success: function (cont) {
            alert("Se eliminó satisfactoriamente!");
            AdministrarPublicacion();
//            $("#resultado").html("Se eliminó satisfactoriamente!");
        },
        error: function (jqXHR) {
            alert("Error  Publicacion Eliminar Publicacionmodificacion.js" + jqXHR);
        }
    });
}