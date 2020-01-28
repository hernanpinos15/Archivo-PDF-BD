
<%@page import="app.archivo.iu.ArchivoIU"%>
<%@page import="java.util.Base64"%>
<%@page import="java.util.logging.Logger"%>

<%
    try {

        String vista = request.getParameter("vista");

        if (vista.equals("guardarArchivos")) {
            Boolean result = false;
            result = (Boolean) session.getAttribute("archivo");
            String resultado = "{"
                    + "\"archivo\":\"" + result + "\""
                    + "}";
            response.setContentType("text/plain");
            response.getWriter().write(resultado);
        } else if (vista.equals("mostrarPreviewArchivo1")) {
            ArchivoIU archivo = (ArchivoIU) session.getAttribute("resultArchivo");
            String base64Encoded = Base64.getEncoder().encodeToString(archivo.getArchivo());
            System.err.println("ver vista: " + base64Encoded);
            String resultado = "{"
                    + "\"archivoPDF\":\"" + base64Encoded + "\""
                    + "}";
            response.setContentType("text/plain");
            response.getWriter().write(resultado);
        }

    } catch (Exception e) {
        Logger.getLogger("AppVista").log(java.util.logging.Level.SEVERE, "AppVista", e.getClass().getName() + "-----" + e.getMessage());
        System.err.println("ERROR: " + e.getClass().getName() + "----" + e.getMessage());
    }

%>


