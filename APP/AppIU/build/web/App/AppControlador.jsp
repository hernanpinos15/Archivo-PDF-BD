<%@page import="java.util.logging.Logger"%>
<%
    try {
            String accion = (String) request.getParameter("accion");
            if (accion != null) {
                if (accion.equals("show")) {
                    String vista = request.getParameter("vista");
                    response.sendRedirect("AppVista.jsp?vista=" + vista);
                }else if (accion.equals("mostrarPreviewArchivo1")) {
                    response.sendRedirect("AppModelo.jsp?accion=" + accion);
                }
            }

    } catch (Exception e) {
        Logger.getLogger("AppControlador").log(java.util.logging.Level.SEVERE, "AppControlador", e.getClass().getName() + "-----" + e.getMessage());
        System.err.println("ERROR: " + e.getClass().getName() + "----" + e.getMessage());
    }
%>