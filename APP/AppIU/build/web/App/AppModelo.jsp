
<%@page import="app.archivo.iu.ArchivoIU"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="org.apache.commons.fileupload.FileUploadException"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="app.archivos.Archivo"%>
<%@page import="com.google.gson.Gson"%>
<%
    try {
        //Se declara el web service el cual se va a consultar
        app.bd.AppSW_Service service = new app.bd.AppSW_Service();
        app.bd.AppSW port = service.getAppSWPort();
        //Se obtiene los parametros de la sesion
        String accion = request.getParameter("accion");
        Archivo archivoPDF = new Archivo();
        Gson gson = new Gson();
        if (accion.equals("guardarArchivos")) {
            //Codigo de generar en byte el pdf
            byte[] bytessolicitud = null;
            if (ServletFileUpload.isMultipartContent(request)) {
                ServletFileUpload SFileUpload = new ServletFileUpload(new DiskFileItemFactory());
                Iterator iter = null;
                try {
                    iter = SFileUpload.parseRequest(request).iterator();
                    while (iter.hasNext()) {
                        FileItem FItem = (FileItem) iter.next();
                        if (!FItem.isFormField()) {
                            if (FItem.getFieldName().equals("archivosolicitud")) {
                                bytessolicitud = IOUtils.toByteArray(FItem.getInputStream());
                            }
                        }
                    }
                } catch (FileUploadException e) {
                    out.println(e.toString());
                }
            }
            archivoPDF.setArchivo(bytessolicitud);
            Boolean result = port.saveArchivo(gson.toJson(archivoPDF));
            session.setAttribute("archivo", result);
            response.sendRedirect("AppControlador.jsp?accion=show&vista=guardarArchivos");
        } else if (accion.equals("mostrarPreviewArchivo1")) {
            String resultArchivo = port.loadArchivo();
            ArchivoIU datoArchivo = gson.fromJson(resultArchivo, ArchivoIU.class);
            System.err.println("modelo: "+datoArchivo.getArchivo());
            session.setAttribute("resultArchivo", datoArchivo);
            response.sendRedirect("AppControlador.jsp?accion=show&vista=mostrarPreviewArchivo1");
        }
    } catch (Exception e) {
        Logger.getLogger("AppModelo").log(java.util.logging.Level.SEVERE, "AppModelo", e.getClass().getName() + "-----" + e.getMessage());
        System.err.println("ERROR: " + e.getClass().getName() + "----" + e.getMessage());

    }
%>

