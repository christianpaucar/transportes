<%@page import="javafx.scene.control.Alert"%>
<%
    try{
        String task = request.getParameter("task");
        session.setAttribute("task", task);
        
        
        if (task.equals("MostrarPubT")) {
            String strTsk = request.getParameter("tsk");
            if(strTsk.equals("IngParametro")){
                RequestDispatcher rd = request.getRequestDispatcher("mdPublicaciones.jsp?acc=getPuParametroT");
                rd.forward(request, response);
            }else if(strTsk.equals("mostrarTipos")) {
                response.sendRedirect("vwPublicaciones.jsp?acc=getAPParametroTi");
            }                    
        }else if(task.equals("mostrarPublicacionTipo")){
            String strTsk = request.getParameter("tsk");
            if(strTsk.equals("mostrarPubTipo")) {
                String JSON = request.getParameter("item");
                session.setAttribute("item", JSON);
                RequestDispatcher rd = request.getRequestDispatcher("mdPublicaciones.jsp?acc=getPubTipo");
                rd.forward(request, response);
            }else if (strTsk.equals("mostrarPubReporteT")) {
                response.sendRedirect("vwPublicaciones.jsp?acc=getPT");
            }
        }else if (task.equals("publicacionIngresar")) {
            String strTsk = request.getParameter("tsk");

            if (strTsk.equals("mostrarPublicacionIngresar")) {
                RequestDispatcher rd = request.getRequestDispatcher("mdPublicaciones.jsp?acc=getPublicacion");
                rd.forward(request, response);
            } else if (strTsk.equals("mostrarPublicacionReporte")) {
                response.sendRedirect("vwPublicaciones.jsp?acc=getFormularioPublicacion");
            }
        }else  if (task.equals("PublicacionGuardar")) {
            String JSON = request.getParameter("item");

            session.setAttribute("item", JSON);
            RequestDispatcher rd = request.getRequestDispatcher("mdPublicaciones.jsp?task=PublicacionGuardar");
            
            rd.forward(request, response);
        } 
    }catch (Exception e) {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Error!!! Controlador.");
    }
    


%>