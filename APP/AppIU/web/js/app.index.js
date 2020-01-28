

function  saveArchivo() {
    try {
        //enviar el PDF
        var archivosolicitud = $('#archivosolicitud').prop('files');
        var form = new FormData();
        form.append('archivosolicitud', archivosolicitud[0]);
        // enviar ajax
        $("#msmerror").html("");
        var archivo = $("#archivosolicitud").val();
        var extensiones = archivo.substring(archivo.lastIndexOf("."));
        if (extensiones === ".pdf") {
            $.ajax({
                url: "./App/AppModelo.jsp?accion=guardarArchivos",
                type: "POST",
                data: form,
                cache: false,
                processData: false,
                contentType: false,
                success: function (result) {
                    var data = JSON.parse(result);
                    if (data.archivo === "true") {
                        $("#msmerror").html("El archivo se guardo exitosamente");
                        limpiarContendio();
                    } else {
                        $("#msmerror").html("No se guardo el archivo");
                        limpiarContendio();
                    }
                },
                error: function (err) {
                    $("#msmerror").html("Contenido no Disponible. Intentelo mas tarde.... (saveArchivo)");
                    limpiarContendio();
                }
            });
        } else {
            $("#msmerror").show();
            $("#msmerror").html("El archivo de tipo " + extensiones + " no es válido");
            limpiarContendio();
        }
    } catch (err) {
        $("#msmerror").show();
        $("#msmerror").html("No se realizó la operación");
        limpiarContendio();
    }
}

function limpiarContendio() {
    setTimeout(function () {
        $("#msmerror").html("");
    }, 4000);
}


/* *************************************************************************
 *  VER ARCHIVO 
 * *************************************************************************/
function previewArchivo1() {
    $.ajax({
        url: "./App/AppControlador.jsp",
        type: "GET",
        data: {accion: 'mostrarPreviewArchivo1'},
        success: function (datos) {
            var data = JSON.parse(datos);
            $("#dibujar").html("<div style='height: 100%;' > <iframe src='data:application/pdf;base64," + data.archivoPDF + "' id='pdfReportes' style='height: 100%;width: 100%;'></iframe></div>");
        },
        error: function (error) {
            $("#msmerror").html("Contenido no Disponible. Intentelo mas tarde....");
        }
    });
}