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
    
    if (task.equals("ingresarAdministrarT")) {
       String strTsk = request.getParameter("tsk");
        if (strTsk.equals("mostrarAdministrarT")) {
            RequestDispatcher rd = request.getRequestDispatcher("mdTipoAdmin.jsp?acc=getAdministrarT");
            rd.forward(request, response);
        } else if (strTsk.equals("mostrarAdministrarTReporte")) {
            response.sendRedirect("vwTipoAdmin.jsp?acc=getTipoAdministracion");
        }
    }else if (task.equals("AdministracionGuardarTipo")) {
        RequestDispatcher rd = request.getRequestDispatcher("mdTipoAdmin.jsp");
        String JSON = request.getParameter("item");
        session.setAttribute("item", JSON);
        rd.forward(request, response);
    }else if (task.equals("mostrarModalTipo")) {
        String idTipo = request.getParameter("idTipo");
        session.setAttribute("idTipo", idTipo);
        response.sendRedirect("mdTipoAdmin.jsp?acc=getModalT");
    } else if (task.equals("mostrarModalTReporte")) {
        response.sendRedirect("vwTipoAdmin.jsp?acc=getModalT");
    } else if (task.equals("tipoModificarGuardar")){
        String idTipo = request.getParameter("idTipo");
        session.setAttribute("idtipo", idTipo);
        String JSON = request.getParameter("item");
        session.setAttribute("item", JSON);
        RequestDispatcher rd = request.getRequestDispatcher("mdTipoAdmin.jsp?acc=guardarModificarTipoAdmin");
        rd.forward(request, response);
    } else if (task.equals("tipoEliminar")){
        String idtipo = request.getParameter("idtipo");
        session.setAttribute("idtipo", idtipo);
        RequestDispatcher rd = request.getRequestDispatcher("mdTipoAdmin.jsp?acc=eliminarTipo");
        rd.forward(request, response);
    }
%>
