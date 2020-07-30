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
    try {
        String strAcc = request.getParameter("acc");
        String task = request.getParameter("task");
        if (task.equals("PublicacionGuardar")) {
            String JSON = session.getAttribute("item").toString();
            
            JSONObject objJS = new JSONObject(JSON);     
           
           Publicacion objPublicacion= new Publicacion(); 
           Tipo objTipo =new Tipo();
           objTipo.setIdtipo(objJS.getInt("tipo"));


            objPublicacion.setAutores(objJS.getString("autor"));
            objPublicacion.setUrl(objJS.getString("url"));
            objPublicacion.setDescripcion(objJS.getString("descripcion"));
            objPublicacion.setCorreoelectronico(objJS.getString("correo"));
            objPublicacion.setCoautores(objJS.getString("coautor"));
            objPublicacion.setIdtipo(objTipo);
            

            
            publicacionRest APwsr = new publicacionRest();
            APwsr.create(objPublicacion);
            response.setCharacterEncoding("UTF-8");
           
            
        }
        if(strAcc.equals("getPuParametroT")){
            String JSONAP = servicios.todosTipo();
            List<Tipo> tipos = new ArrayList<Tipo>();
            String result = "{respuesta:" + JSONAP + "}";
            JSONObject objJSON = new JSONObject(result); 
            JSONArray arrayJSON = objJSON.getJSONArray("respuesta");
            for (int i = 0; i < arrayJSON.length(); i++) { 
                JSONObject childJSONObject = arrayJSON.getJSONObject(i);
                Tipo objMenus = new Gson().fromJson(childJSONObject.toString(), Tipo.class);
                tipos.add(objMenus);
            }
            session.setAttribute("Tipos", tipos);
            RequestDispatcher rd = request.getRequestDispatcher("controladorPublicaciones.jsp?task=MostrarPubT&tsk=mostrarTipos");
            rd.forward(request, response);
        }else if (strAcc.equals("getPubTipo")) {
            String JSON = session.getAttribute("item").toString();
            JSONObject objJS = new JSONObject(JSON);
            String JSONAP = servicios.listarTipo(objJS.getInt("tipoPub"));
            List<Publicacion> listatipo = new ArrayList<Publicacion>();
            String result = "{respuesta:" + JSONAP + "}";
            JSONObject objJSON = new JSONObject(result); 
            JSONArray arrayJSON = objJSON.getJSONArray("respuesta");
            for (int i = 0; i < arrayJSON.length(); i++) {
                JSONObject childJSONObject = arrayJSON.getJSONObject(i);
                Publicacion objMenus = new Gson().fromJson(childJSONObject.toString(), Publicacion.class);
                listatipo.add(objMenus);
            }
            session.setAttribute("PublicacionIU", listatipo);
            RequestDispatcher rd = request.getRequestDispatcher("controladorPublicaciones.jsp?task=mostrarPublicacionTipo&tsk=mostrarPubReporteT");
            rd.forward(request, response);
        }else if (strAcc.equals("getPublicacion")) {
            
            String JSONAP = servicios.todosTipo();
            List<Tipo> listaTipo = new ArrayList<Tipo>();
            String result = "{respuesta:" + JSONAP + "}";
            JSONObject objJSON = new JSONObject(result); 
            JSONArray arrayJSON = objJSON.getJSONArray("respuesta");
            for (int i = 0; i < arrayJSON.length(); i++) {
                JSONObject childJSONObject = arrayJSON.getJSONObject(i);
                Tipo objMenus = new Gson().fromJson(childJSONObject.toString(), Tipo.class);
                listaTipo.add(objMenus);
            }
            session.setAttribute("TipoIU", listaTipo);

            
            RequestDispatcher rd = request.getRequestDispatcher("controladorPublicaciones.jsp?task=publicacionIngresar&tsk=mostrarPublicacionReporte");
            rd.forward(request, response);
            strAcc="";
        } 
    } catch (Exception e) {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Error!!! modelo (Mostrar Reporte AP).");
    }
%>