<%@page import="SERVICIOS.publicacionRest"%>
<%@page import="WS.service.PublicacionFacadeREST"%>
<%@page import="SERVICIOS.servicios"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javafx.scene.control.Alert"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ENTIDADES.*"%>
<%@page import="org.json.JSONObject"%>
<%@page import="com.google.gson.JsonObject"%> 
<%
    String task = request.getParameter("task");
    session.setAttribute("task", task);
    
    if (task.equals("ingresarAdministrarP")) {
       String strTsk = request.getParameter("tsk");
        if (strTsk.equals("mostrarAdministrarP")) {
            RequestDispatcher rd = request.getRequestDispatcher("mdModificacion.jsp?acc=getAdministrarP");
            rd.forward(request, response);
        } else if (strTsk.equals("mostrarAdministrarPReporte")) {
            response.sendRedirect("vwModificacion.jsp?acc=getPublicacionAdministracion");
        }
    }else if (task.equals("AdministracionGuardar")) {
        RequestDispatcher rd = request.getRequestDispatcher("mdModificacion.jsp");
        String JSON = request.getParameter("item");
        session.setAttribute("item", JSON);
        rd.forward(request, response);
    }else if (task.equals("mostrarModalPub")) {
        String idPub = request.getParameter("idPub");
        response.sendRedirect("mdModificacion.jsp?acc=getModalP&idPub=" + idPub);
    } else if (task.equals("mostrarModalPReporte")) {
        response.sendRedirect("vwModificacion.jsp?acc=getModalP");
    } else if (task.equals("publicacionModificarGuardar")){
        String idPub = request.getParameter("idPub");
        String JSON = request.getParameter("item");
        session.setAttribute("item", JSON);
        RequestDispatcher rd = request.getRequestDispatcher("mdModificacion.jsp?acc=guardarModificar&idPub=" + idPub);
        rd.forward(request, response);
    } else if (task.equals("publicacionEliminar")){
        String idPub = request.getParameter("idpub");
        RequestDispatcher rd = request.getRequestDispatcher("mdModificacion.jsp?acc=eliminarPublicacion&idPub=" + idPub);
        rd.forward(request, response);
    }
%>
