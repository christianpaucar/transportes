<%@page import="AdministracionIU.administracionTipoIU"%>
<%@page import="AdministracionIU.administracionIU"%>
<%@page import="ENTIDADES.Publicacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ENTIDADES.Tipo"%>
<%@page import="TipoIU.tipoIU"%>
<%
    try {
        String task = session.getAttribute("task").toString();
        String strAcc = request.getParameter("acc"); 
        
        if (strAcc.equals("getTipoAdministracion")) {
            String resultJSON = "";
            ArrayList<Tipo> administracionTipoIU = (ArrayList<Tipo>) session.getAttribute("TipoIU");
            administracionTipoIU obj =new administracionTipoIU();     
            obj.setListTipo(administracionTipoIU);
            if (obj != null) {
                resultJSON = obj.HTMLVistaAdministracionTipo();             
            }            
            response.setContentType("text/plain");           
            response.getWriter().write(resultJSON);
            
        }else if (task.equals("AdministracionGuardar")) {
            administracionTipoIU apiu = new administracionTipoIU();
            String JSON = apiu.HTMLVistaAdministracionTipo();
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSON);
        } else if (strAcc.equals("getModalT")) {
            String resultJSON = "";
            ArrayList<Tipo> administracionTipoIU = (ArrayList<Tipo>) session.getAttribute("ModalTipoIU");
            administracionTipoIU obj = new administracionTipoIU();
            obj.setObjTipo(administracionTipoIU.get(0));
            if (obj != null) {
                  resultJSON = obj.HTMLModalTipo();
            }
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(resultJSON);
        } 
        
    } catch (Exception e) {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Error en la vista de ingresar tipo.");
    }
%>
