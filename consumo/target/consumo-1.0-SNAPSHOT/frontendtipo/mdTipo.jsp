<%@page import="SERVICIOS.tipoRest"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="SERVICIOS.servicios"%>
<%@page import="ENTIDADES.Tipo"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.JSONObject"%>
<%
    try {
        String task = session.getAttribute("task").toString();
        HttpSession objSesion = request.getSession(false);
        String strAcc = request.getParameter("acc");
        
        if (task.equals("TipoGuardar")) {
            String JSON = session.getAttribute("item").toString();
            JSONObject objJS = new JSONObject(JSON);     
           
            Tipo objtipo = new Tipo();


            objtipo.setDescripciontipo(objJS.getString("descripcion"));

            
            tipoRest APwsr = new tipoRest();
            APwsr.create(objtipo);
            response.setCharacterEncoding("UTF-8");
           
            
        }else if (strAcc.equals("getTipo")) {
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
            RequestDispatcher rd = request.getRequestDispatcher("controladorTipo.jsp?task=tipoIngresar&tsk=mostrarTipoReporte");
            rd.forward(request, response);
            strAcc="";
        } 
        //else if (strAcc.equals("getModAP")) {
//            String rqModAP = request.getParameter("idapp");
//            String JSONAPE = sAP.listarID(rqModAP);
//            response.getWriter().write(JSONAPE); 
//            List<AccionPersonal> lista = new ArrayList<AccionPersonal>();
//            String result = "{objLista:" + JSONAPE + "}";
//            JSONObject objJSON = new JSONObject(result); 
//            JSONArray arrayJSON = objJSON.getJSONArray("objLista");
//            for (int i = 0; i < arrayJSON.length(); i++) {
//                JSONObject childJSONObject = arrayJSON.getJSONObject(i);
//                AccionPersonal objMenus = new Gson().fromJson(childJSONObject.toString(), AccionPersonal.class);
//                lista.add(objMenus);
//            }
//            session.setAttribute("AccionPersonalIU", lista);
//            RequestDispatcher rd = request.getRequestDispatcher("controladorAP.jsp?task=ModAP&tsk=mostrarModAPReporte");
//            rd.forward(request, response);
//        }
         

    } catch (Exception e) {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Error!!! modelo (ingresar AP).");
    }
%>
