<%
    String task = request.getParameter("task");
    session.setAttribute("task", task);
    HttpSession objSesion = request.getSession(true);
    
    if (task.equals("tipoIngresar")) {
        String strTsk = request.getParameter("tsk");
        if (strTsk.equals("mostrarTipo")) {
            RequestDispatcher rd = request.getRequestDispatcher("mdTipo.jsp?acc=getTipo");
            rd.forward(request, response);
        } else if (strTsk.equals("mostrarTipoReporte")) {
            response.sendRedirect("vwTipo.jsp?acc=getTipoVista");
        }
    } else if (task.equals("TipoGuardar")) {
        RequestDispatcher rd = request.getRequestDispatcher("mdTipo.jsp");
        String JSON = request.getParameter("item");
      
        session.setAttribute("item", JSON);
        rd.forward(request, response);
    } 

%>