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
        String task = session.getAttribute("task").toString();
        HttpSession objSesion = request.getSession(false);
        String strAcc = request.getParameter("acc");
        
        if (task.equals("AdministracionGuardar")) {
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
           
            
        }else if (strAcc.equals("getAdministrarP")) {
            // Datos de Publicacion
            String JSONAP = servicios.todosPublicacion();
            List<Publicacion> Publicaciones = new ArrayList<Publicacion>();
            String result = "{respuesta:" + JSONAP + "}";
            JSONObject objJSON = new JSONObject(result); 
            JSONArray arrayJSON = objJSON.getJSONArray("respuesta");
            for (int i = 0; i < arrayJSON.length(); i++) {
                JSONObject childJSONObject = arrayJSON.getJSONObject(i);
                Publicacion objMenus = new Gson().fromJson(childJSONObject.toString(), Publicacion.class);
                Publicaciones.add(objMenus);
            }
            session.setAttribute("AdministracionIU",Publicaciones);
            // Datos de Tipo
            String JSONAP2 = servicios.todosTipo();
            List<Tipo> listaTipo = new ArrayList<Tipo>();
            String result2 = "{respuesta:" + JSONAP2 + "}";
            JSONObject objJSON2 = new JSONObject(result2); 
            JSONArray arrayJSON2 = objJSON2.getJSONArray("respuesta");
            for (int i = 0; i < arrayJSON2.length(); i++) {
                JSONObject childJSONObject2 = arrayJSON2.getJSONObject(i);
                Tipo objMenus = new Gson().fromJson(childJSONObject2.toString(), Tipo.class);
                listaTipo.add(objMenus);
            }
            session.setAttribute("TipoIU", listaTipo);
            RequestDispatcher rd = request.getRequestDispatcher("controladorModificacion.jsp?task=ingresarAdministrarP&tsk=mostrarAdministrarPReporte");
            rd.forward(request, response);
            strAcc="";
        } 
        else if (strAcc.equals("getModalP")) {
            String idPub = request.getParameter("idPub");
            String JSONAPE = servicios.listarID(idPub);
            List<Publicacion> lista = new ArrayList<Publicacion>();
            String result = "{objLista:[" + JSONAPE + "]}";
            JSONObject objJSON = new JSONObject(result); 
            JSONArray arrayJSON = objJSON.getJSONArray("objLista");
            for (int i = 0; i < arrayJSON.length(); i++) {
                JSONObject childJSONObject = arrayJSON.getJSONObject(i);
                Publicacion objMenus = new Gson().fromJson(childJSONObject.toString(), Publicacion.class);
                lista.add(objMenus);
            }
            session.setAttribute("ModalPublicacionIU", lista);
            // Datos de Tipo
            String JSONAP2 = servicios.todosTipo();
            List<Tipo> listaTipo = new ArrayList<Tipo>();
            String result2 = "{respuesta:" + JSONAP2 + "}";
            JSONObject objJSON2 = new JSONObject(result2); 
            JSONArray arrayJSON2 = objJSON2.getJSONArray("respuesta");
            for (int i = 0; i < arrayJSON2.length(); i++) {
                JSONObject childJSONObject2 = arrayJSON2.getJSONObject(i);
                Tipo objMenus = new Gson().fromJson(childJSONObject2.toString(), Tipo.class);
                listaTipo.add(objMenus);
            }
            session.setAttribute("TipoIU", listaTipo);
            RequestDispatcher rd = request.getRequestDispatcher("controladorModificacion.jsp?task=mostrarModalPReporte");
            rd.forward(request, response);
        }
        else if (strAcc.equals("guardarModificar")) {
            String idPub = request.getParameter("idPub");
            Integer idP = Integer.parseInt(idPub); 
            String JSON = session.getAttribute("item").toString();
            JSONObject objJS = new JSONObject(JSON);     
           
            Publicacion objPublicacion= new Publicacion(); 

            Tipo objTipo =new Tipo();
            objTipo.setIdtipo(objJS.getInt("tipo"));
           
            objPublicacion.setIdpublicacion(idP);
            objPublicacion.setAutores(objJS.getString("autor"));
            objPublicacion.setUrl(objJS.getString("url"));
            objPublicacion.setDescripcion(objJS.getString("descripcion"));
            objPublicacion.setCorreoelectronico(objJS.getString("correo"));
            objPublicacion.setCoautores(objJS.getString("coautor"));
            objPublicacion.setIdtipo(objTipo);
            
            publicacionRest APwsr = new publicacionRest();
            APwsr.edit(objPublicacion, idPub);
//            RequestDispatcher rd = request.getRequestDispatcher("controladorModificacion.jsp?task=ingresarAdministrarP&tsk=mostrarAdministrarPReporte");
//            rd.forward(request, response);
        }else if (strAcc.equals("eliminarPublicacion")){
            String idPub = request.getParameter("idPub");
            publicacionRest APwsr = new publicacionRest();
            APwsr.remove(idPub);
//            RequestDispatcher rd = request.getRequestDispatcher("controladorModificacion.jsp?task=ingresarAdministrarP&tsk=mostrarAdministrarPReporte");
//            rd.forward(request, response);
        }
    } catch (Exception e) {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Error!!! modelo (ingresar Publicacion).");
    }
%>
