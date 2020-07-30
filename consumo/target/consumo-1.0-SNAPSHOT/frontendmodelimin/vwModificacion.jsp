<%@page import="AdministracionIU.administracionIU"%>
<%@page import="ENTIDADES.Publicacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ENTIDADES.Tipo"%>
<%@page import="TipoIU.tipoIU"%>
<%
    try {
        String task = session.getAttribute("task").toString();
        String strAcc = request.getParameter("acc"); 
        
        if (strAcc.equals("getPublicacionAdministracion")) {
            String resultJSON = "";
            ArrayList<Publicacion> administracionIU = (ArrayList<Publicacion>) session.getAttribute("AdministracionIU");
            ArrayList<Tipo> administracionTipoIU = (ArrayList<Tipo>) session.getAttribute("TipoIU");
            administracionIU obj =new administracionIU();
            obj.setListPublicacion(administracionIU);     
            obj.setListTipo(administracionTipoIU);
            if (obj != null) {
                resultJSON = obj.HTMLVistaAdministracion();              
            }            
            response.setContentType("text/plain");           
            response.getWriter().write(resultJSON);
            
        }else if (task.equals("AdministracionGuardar")) {
            administracionIU apiu = new administracionIU();
            String JSON = apiu.HTMLVistaAdministracion();
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSON);
        } else if (strAcc.equals("getModalP")) {
            String resultJSON = "";
            ArrayList<Publicacion> publicacionIU = (ArrayList<Publicacion>) session.getAttribute("ModalPublicacionIU");
            ArrayList<Tipo> administracionTipoIU = (ArrayList<Tipo>) session.getAttribute("TipoIU");
            administracionIU obj = new administracionIU();
            obj.setObjPublicacion(publicacionIU.get(0));
            obj.setListTipo(administracionTipoIU);
            if (obj != null) {
//                resultJSON = "{"
//                        + "\"contenidoDinamico\":\"" + obj.HTMLModalAP() + "\""
//                        + "}";
                  resultJSON = obj.HTMLModalAP();
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
