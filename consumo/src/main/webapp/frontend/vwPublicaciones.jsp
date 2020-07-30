<%@page import="TipoIU.tipoIU"%>
<%@page import="ENTIDADES.Publicacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ENTIDADES.*"%>
<%@page import="PublicacionesIU.PublicacionesIU"%>
<%
    try {
        String strAcc = request.getParameter("acc");
        String task = session.getAttribute("task").toString();
       
        if(strAcc.equals("getAPParametroTi")){
            String resultJSON = "";
            ArrayList<Tipo> Tipos = (ArrayList<Tipo>) session.getAttribute("Tipos");
            PublicacionesIU obj = new PublicacionesIU();
            obj.setListTipo(Tipos);
            if (obj != null) {
                resultJSON = obj.HTMLVistaTipo();
            }
            response.setContentType("text/plain");
            response.getWriter().write(resultJSON);
            
        }else if (strAcc.equals("getPT")) {
            String resultJSON = "";
            ArrayList<Publicacion> PublicacionesIU = (ArrayList<Publicacion>) session.getAttribute("PublicacionIU");
            PublicacionesIU obj = new PublicacionesIU();
            obj.setListPublicacion(PublicacionesIU);
            if (obj != null) {
                resultJSON = obj.HTMLVistaReporteTipo();
            }
            response.setContentType("text/plain");
            response.getWriter().write(resultJSON);
        //
        }else if (strAcc.equals("getFormularioPublicacion")) {
            String resultJSON = "";
            ArrayList<Tipo> tipoIU = (ArrayList<Tipo>) session.getAttribute("TipoIU");
            PublicacionesIU obj = new PublicacionesIU();
            obj.setListTipo(tipoIU);
            if (obj != null) {
                resultJSON = obj.HTMLVistaFormulario();              
            }            
            response.setContentType("text/plain");           
            response.getWriter().write(resultJSON);
            
        }else if (task.equals("PublicacionGuardar")) {
            PublicacionesIU apiu = new PublicacionesIU();
            String JSON = apiu.HTMLVistaFormulario();
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSON);
        }  
    } catch (Exception e) {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Error en la vista al mostrar AP.");
    }
%>
