<%@page import="java.util.ArrayList"%>
<%@page import="ENTIDADES.Tipo"%>
<%@page import="TipoIU.tipoIU"%>
<%
    try {
        String task = session.getAttribute("task").toString();
        String strAcc = request.getParameter("acc"); 
        
        if (strAcc.equals("getTipoVista")) {
            String resultJSON = "";
            ArrayList<Tipo> tipoIU = (ArrayList<Tipo>) session.getAttribute("TipoIU");
            tipoIU obj = new tipoIU();
            obj.setListTipo(tipoIU);
            if (obj != null) {
                resultJSON = obj.HTMLVista();              
            }            
            response.setContentType("text/plain");           
            response.getWriter().write(resultJSON);
            
        }else if (task.equals("TipoGuardar")) {
            tipoIU apiu = new tipoIU();
            String JSON = apiu.HTMLVista();
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSON);
        } 
//        
        

    } catch (Exception e) {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Error en la vista de ingresar equipo.");
    }
%>
