function APMostrarTipoParametro() {
    $.ajax({
        url: 'frontend/controladorPublicaciones.jsp',
        type: 'POST',
        data: {task: 'MostrarPubT', tsk:'IngParametro'},
        success: function (cont) {
            $("#contenidoDinamico").html(cont);
        },
        error: function (jqXHR) {
            alert("Error Mostrar Reporte por Tipo (Parámetro) PublicacionJS.js" + jqXHR);
        }
    });
}

function APMostrarPublicacionTipo() {
    var item = "{tipoPub: " + $('#tipoPub').val() + "}";
    $.ajax({
        url: 'frontend/controladorPublicaciones.jsp',
        type: 'POST',
        data: {task: 'mostrarPublicacionTipo', tsk:'mostrarPubTipo',item: item},
        success: function (cont) {
            $("#contenidoDinamico").html(cont);
        },
        error: function (jqXHR) {
            alert("Error Mostrar Reporte por Tipo PublicacionJS.js" + jqXHR);
        }
    });
}

function IngresarPublicacion() {
    $.ajax({
        url: 'frontend/controladorPublicaciones.jsp',
        type: 'POST',
        data: {task: 'publicacionIngresar', tsk:'mostrarPublicacionIngresar'},
        success: function (cont) {
            $("#contenidoDinamico").html(cont);
        },
        error: function (jqXHR) {
            alert("Error al ingresar publicacion.js" + jqXHR);
        }
    });
}


function PublicacionGuardar() {
  var item = "{\"autor\": \"" + $('#autor').val()
            + "\", \"url\": \"" + $("#url").val()
            + "\", \"descripcion\": \"" + $('#descripcion').val()
            + "\", \"correo\": \"" + $('#correo').val()
            + "\", \"coautor\": \"" + $('#coautor').val()
            + "\", \"tipo\": \"" + $('#tipo').val()
             + "\"}";
     
     
          
    $.ajax({
        url: 'frontend/controladorPublicaciones.jsp',
        type: 'POST',
        data: {task: 'PublicacionGuardar',
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




