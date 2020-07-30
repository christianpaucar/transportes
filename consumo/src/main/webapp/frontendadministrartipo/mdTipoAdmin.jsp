<%@page import="SERVICIOS.tipoRest"%>
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
        String strAcc = request.getParameter("acc");
        
        if (task.equals("AdministracionGuardarTipo")) {
            String JSON = session.getAttribute("item").toString();
            JSONObject objJS = new JSONObject(JSON);
           
           Tipo objTipo =new Tipo();
           
            objTipo.setDescripciontipo(objJS.getString("descripcion"));
            
            tipoRest APwsr = new tipoRest();
            APwsr.create(objTipo);
            response.setCharacterEncoding("UTF-8");
        }else if (strAcc.equals("getAdministrarT")) {
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
            RequestDispatcher rd = request.getRequestDispatcher("controladorTipoAdmin.jsp?task=ingresarAdministrarT&tsk=mostrarAdministrarTReporte");
            rd.forward(request, response);
            strAcc="";
        } 
        else if (strAcc.equals("getModalT")) {
            String idTipo = session.getAttribute("idTipo").toString();
            String JSONAPE = servicios.listarIDTipo(idTipo);
            List<Tipo> listaTipo = new ArrayList<Tipo>();
            String result = "{objLista:[" + JSONAPE + "]}";
            JSONObject objJSON = new JSONObject(result); 
            JSONArray arrayJSON = objJSON.getJSONArray("objLista");
            for (int i = 0; i < arrayJSON.length(); i++) {
                JSONObject childJSONObject = arrayJSON.getJSONObject(i);
                Tipo objMenus = new Gson().fromJson(childJSONObject.toString(), Tipo.class);
                listaTipo.add(objMenus);
            }
            session.setAttribute("ModalTipoIU", listaTipo);
            RequestDispatcher rd = request.getRequestDispatcher("controladorTipoAdmin.jsp?task=mostrarModalTReporte");
            rd.forward(request, response);
        }
        else if (strAcc.equals("guardarModificarTipoAdmin")) {
            String idTipo = session.getAttribute("idTipo").toString();
            Integer idT = Integer.parseInt(idTipo); 
            String JSON = session.getAttribute("item").toString();
            JSONObject objJS = new JSONObject(JSON);     
           
            Tipo objTipo =new Tipo();
            objTipo.setIdtipo(idT);
            objTipo.setDescripciontipo(objJS.getString("descripcion"));
            
            tipoRest wsrTipo = new tipoRest();
            wsrTipo.edit(objTipo, idTipo);
        }else if (strAcc.equals("eliminarTipo")){
            String idTipo = session.getAttribute("idtipo").toString();
            tipoRest wsrTipo = new tipoRest();
            wsrTipo.remove(idTipo);
        }
    } catch (Exception e) {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Error!!! modelo (ingresar Publicacion).");
    }
%>
