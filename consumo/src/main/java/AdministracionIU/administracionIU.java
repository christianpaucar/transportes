/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministracionIU;

import ENTIDADES.Publicacion;
import ENTIDADES.Tipo;
import java.util.ArrayList;
import org.json.JSONException;

/**
 *
 * @author SICOJUMP
 */
public class administracionIU {
    
    
  private ArrayList<Publicacion> listPublicacion = new ArrayList<>();
    
    private Publicacion objPublicacion = new Publicacion();
    
    public administracionIU() {
    }

//    public administracionIU(Integer id) {
//        super(id);
//    }

    public ArrayList<Publicacion> getListPublicacion() {
        return listPublicacion;
    }

    public void setListPublicacion(ArrayList<Publicacion> listPublicacion) {
        this.listPublicacion = listPublicacion;
    }

    public Publicacion getObjPublicacion() {
        return objPublicacion;
    }

    public void setObjPublicacion(Publicacion objPublicacion) {
        this.objPublicacion = objPublicacion;
    }
    
      private ArrayList<Tipo> listTipo = new ArrayList<>();
    
    private Tipo objTipo = new Tipo();

    public ArrayList<Tipo> getListTipo() {
        return listTipo;
    }

    public void setListTipo(ArrayList<Tipo> listTipo) {
        this.listTipo = listTipo;
    }

    public Tipo getObjTipo() {
        return objTipo;
    }

    public void setObjTipo(Tipo objTipo) {
        this.objTipo= objTipo;
    }
 
     public String HTMLVistaAdministracion() throws JSONException {
       
        String result = "";
        result += "<form  id='frmIngresarAP'>"
                + "<script>  $('#f').on('change', function(ev) {   var f = ev.target.files[0];    var fr = new FileReader();     fr.onload = function(ev2) { console.dir(ev2);$('#i').attr('src', ev2.target.result);};   var src = $(this).attr('src');  fr.readAsDataURL(f); console.info(src);});</script>"
                + " <div id='faq' role='tablist' aria-multiselectable='true'>"
                + "     <div class='card'>"
                + "          <div class='card-header' role='tab' id='questionTwo'>"
                + "             <h5 class='card-title'>"
                + "                 <a class='collapsed' data-toggle='collapse' data-parent='#faq' href='#answerTwo' aria-expanded='false' aria-controls='answerTwo'>"
                + "                     <p align='right'><i class='fa fa-plus-circle' title='INGRESAR PUBLICACION'> Nueva Publicacion.</i></p>"
                + "                 </a>"
                + "             </h5>"
                + "          </div>"
                + "          <div id='answerTwo' class='collapse' role='tabcard' aria-labelledby='questionTwo'>"
                + "              <div class='card-header'>"
                + "                 <form >"
                + "                     <div class='form-row'>"
                + "                         <div class='form-group row'>"                                            
                + "                             <div class='input-group'>"
                + "                                 <br>"
                + "                                 <label class='col-sm-2 col-form-label'>Autor</label>"
                +"                                   <div class=\"col-sm-10\">"
                + "                                 <input type=\"text\" class=\"form-control Curso\" id=\"autor\" name=\"autor\"  value=\"\" required=\"required\" placeholder=\"autor\"/>"
                + "                             </div>"
                + "                             </div>"
                  + "                             <div class='input-group'>"
                + "                                 <br>"
                + "                                 <label class='col-sm-2 col-form-label'>Url</label>"
                +"                                   <div class=\"col-sm-10\">"
                + "                                 <input type=\"text\" class=\"form-control Curso\" id=\"url\" name=\"url\"  value=\"\" required=\"required\" placeholder=\"url\"/>"
                + "                             </div>"
                + "                             </div>"
                  + "                             <div class='input-group'>"
                + "                                 <br>"
                + "                                 <label class='col-sm-2 col-form-label'>Descripcion</label>"
                +"                                   <div class=\"col-sm-10\">"
                + "                                 <input type=\"text\" class=\"form-control Curso\" id=\"descripcion\" name=\"descripcion\"  value=\"\" required=\"required\" placeholder=\"descripcion\"/>"
                + "                             </div>"
                + "                             </div>"
                  + "                             <div class='input-group'>"
                + "                                 <br>"
                + "                                 <label class='col-sm-2 col-form-label'>Correo</label>"
                +"                                   <div class=\"col-sm-10\">"
                + "                                 <input type=\"url\" class=\"form-control Curso\" id=\"correo\" name=\"correo\"  value=\"\" required=\"required\" placeholder=\"correo\"/>"
                + "                             </div>"
                + "                             </div>"
                + "                             <div class='input-group'>"
                + "                                 <br>"
                + "                                 <label class='col-sm-2 col-form-label'>Coautor</label>"
                +"                                   <div class=\"col-sm-10\">"
                + "                                 <input type=\"text\" class=\"form-control Curso\" id=\"coautor\" name=\"coautor\"  value=\"\" required=\"required\" placeholder=\"coautor\"/>"
                + "                             </div>"
                + "                             </div><br>"
               + "                             <div class='input-group'><br>"
                + "                                 <label class='col-sm-2 col-form-label'>Régimen</label>"
                +"                                   <div class=\"col-sm-10\">"
                + "                                 <select class='form-control' name=\"tipo\" id=\"tipo\">"
                +"</div>";
                 int cont = 0;
        for (Tipo oTipo : listTipo) {
            cont++;
        result += "                                  <option value='"+oTipo.getIdtipo()+"' selected>"+oTipo.getDescripciontipo()+"</option>";
                                           
               
                       }
        result  += "                                 </select>"
                + "                             </div>"
                +"</div>"
                +"</div>"
                + "                         </div>\n"
                + "                         <div class='col-md-12 class='form-row' align='right'><br>"
                + "                             <button type='button' class='btn btn-primary' data-toggle='modal' data-target='#exampleModal'>"
                + "                                Guardar"
                + "                             </button>"
                + "                             <div id=\"estadoingreso\" style=\"color: blue\">\n"
                + "                                 \n"
                + "                             </div>\n"
                + "                         </div>"
                + "                    </div>"
                + "                 </form>"
                + "              </div>"
                + "          </div>"
               
                + "<!-- Modal Ingresa-->"
                + " <div class='modal fade' id='exampleModal' tabindex='-1' role='dialog' aria-labelledby='exampleModalLabel' aria-hidden='true'>"
                + "    <div class='modal-dialog' role='document'>"
                + "       <div class='modal-content'>"
                + "              <div class='modal-header' align='center'>"
                + "                 <h5 class='modal-title' id='exampleModalLabel'>INGRESAR PUBLICACION</h5>"
                + "                 <button type='button' class='close' data-dismiss='modal' aria-label='Close'>"
                + "                     <span aria-hidden='true'>&times;</span>"
                + "                 </button>"
                + "              </div>"
            + "                  <div class='modal-body'>"
            + "                      Desea ingresar publicacion a la DB?"
            + "                  </div>"
            + "                  <div class='modal-footer'>"
            + "                      <button type='button' class='btn btn-secondary' data-dismiss='modal'>Cancelar</button>"
            + "                      <button type='button' class='btn btn-primary' data-dismiss='modal' onclick='AdministracionGuardar(); return false;' >Aceptar</button>"
            + "                  </div>"
            + "             </div>"
            + "         </div>"
            + "     </div>"
            + " </form>"
            + " <script src=\"frontendmodelimin/PublicacionmodificacionJS.js\" type=\"text/javascript\"></script>"
            + "          <div class='card'>"
                + "             <div class='card-header' role='tab' id='questionOne'>"
                + "                 <h5 class='card-title'>"
                + "                     <a data-toggle='collapse' data-parent='#faq'  href='#answerOne' aria-expanded='true' aria-controls='answerOne'>"
                + "                         <p align='left'><i class='fa fa-eye' title='VER TIPO'> Listar Publicaciones</i></p>"
                + "                     </a>"
                + "                 </h5>"
                + "             </div>"
                +"         <div class='card'>"
                + "             <div class='card-header fluid' role='tab' id='questionOne'>"
                + "                 <h5 class='card-title'>"
                + "                     <p align='left'><i class='fa fa-eye' title='VER PUBLICACIONES'> Publicaciones todas las publicaciones</i></p>"
                + "                 </h5>"
                + "             </div>"
                + "             <div id='answerOne' class='collapse in' role='tabcard' aria-labelledby='questionOne'>"
                + "                 <div class='card-title'>"
                +"<div class='table-responsive'>"
                + "                     <table class='table table-responsive  table-bordered' id='tablaid'>"
                + "                         <thead>"
                + "                             <tr>"
                + "                                 <th scope='col'>N.</th>"
                + "                                 <th scope='col'>Autores</th>"
                + "                                 <th scope='col'>URL</th>"
                + "                                 <th scope='col'>Coautores</th>"
                + "                                 <th scope='col'>Tipo Publicación</th>"
                + "                                 <th scope='col'>Descripción</th>"
                + "                             </tr>"
                + "                         </thead>"
                +"<tbody>";
        
        int cont1 = 0;
        
        for (Publicacion oPublicacion : listPublicacion) {
            cont1++;
        result += "                             <tr onclick='clicModalMuestra(" + oPublicacion.getIdpublicacion()+ "); return false;'>"
                + "                                 <th style='font-weight: ;'>" + cont1 + "</th>"
                + "                                 <th style='font-weight: ;'>" + oPublicacion.getAutores() + "</th>"
                + "                                 <th style='font-weight: ;'><a href=\"" + oPublicacion.getUrl() + "\"> " + oPublicacion.getUrl() + " </a></th>"
                + "                                 <th style='font-weight: ;'>" + oPublicacion.getCoautores()+ "</th>"
                + "                                 <th style='font-weight: ;'>" + oPublicacion.getIdtipo().getDescripciontipo() + "</th>"
                + "                                 <th style='font-weight: ;'>" + oPublicacion.getDescripcion()+ "</th>"
                + "                             </tr>";
                
        }
        result += "                          </tbody>"
                + "</table>"
                +"</div>"
                + "                 </div>"
                + "             </div>"
                + "         </div>"
                + "     </div>"
                + "</div>"
                + " <script src=\"frontendmodelimin/PublicacionmodificacionJS.js\" type=\"text/javascript\"></script>"
                +"<script type='text/javascript'>$(document).ready(function(){$('#tablaid').DataTable();});</script>";              
        return result;
    }
     
    public String HTMLModalAP() throws JSONException {

        String result = "";

        result += "<form id='frmModificaAP'>"
                + "<script>  $('#f').on('change', function(ev) {   var f = ev.target.files[0];    var fr = new FileReader();     fr.onload = function(ev2) { console.dir(ev2);$('#i').attr('src', ev2.target.result);};   var src = $(this).attr('src');  fr.readAsDataURL(f); console.info(src);});</script>"
                + "<script>$(document).ready(function(){$('#ModalMostrarAP').modal('show');$('#BtnMostrar').click(function(){$('#ModalMostrarAP').modal('hide');});$('#BtnModifica').click(function(){});$('#ModalMostrarAP').on('hidden.bs.modal', function(){clickReporteLibro('Metodo');});});</script> "
                + " <!-- Modal Mostrar-->"
                + " <div class='modal fade' id='ModalMostrarAP' tabindex='-1' role='dialog' aria-labelledby='ModalMostrarLibroLabel' aria-hidden='true'>"
                + "     <div class='modal-dialog' role='document'>"
                + "         <div class='modal-content'>"
                + "             <div class='modal-header' align='center'>"
                + "                 <h5 class='modal-title' id='exampleModalLabel'><b>PUBLICACION</b></h5>"
                + "                 <button type='button' class='close' data-dismiss='modal' aria-label='Close'>"
                + "                     <span aria-hidden='true'>&times;</span>"
                + "                 </button>"
                + "             </div>"
                + "             <div class='modal-body'>"
                + "                 <div class='container-fluid'>"
                + "                     <div class='col-md-8'>"
                + "                             <div class='input-group'>"
                + "                                 <br>"
                + "                                 <label class='col-sm-2 col-form-label'>Autor</label>"
                +"                                   <div class=\"col-sm-10\">"
                + "                                 <input type=\"text\" class=\"form-control Curso\" id=\"autorm\" name=\"autorm\"  value=\""+ objPublicacion.getAutores()+"\" required=\"required\" placeholder=\"autor\"/>"
                + "                             </div>"
                + "                             </div>"
                  + "                             <div class='input-group'>"
                + "                                 <br>"
                + "                                 <label class='col-sm-2 col-form-label'>Url</label>"
                +"                                   <div class=\"col-sm-10\">"
                + "                                 <input type=\"text\" class=\"form-control Curso\" id=\"urlm\" name=\"urlm\"  value=\""+ objPublicacion.getUrl()+"\" required=\"required\" placeholder=\"url\"/>"
                + "                             </div>"
                + "                             </div>"
                  + "                             <div class='input-group'>"
                + "                                 <br>"
                + "                                 <label class='col-sm-2 col-form-label'>Descripcion</label>"
                +"                                   <div class=\"col-sm-10\">"
                + "                                 <input type=\"text\" class=\"form-control Curso\" id=\"descripcionm\" name=\"descripcionm\"  value=\""+ objPublicacion.getDescripcion()+"\" required=\"required\" placeholder=\"descripcion\"/>"
                + "                             </div>"
                + "                             </div>"
                  + "                             <div class='input-group'>"
                + "                                 <br>"
                + "                                 <label class='col-sm-2 col-form-label'>Correo</label>"
                +"                                   <div class=\"col-sm-10\">"
                + "                                 <input type=\"url\" class=\"form-control Curso\" id=\"correom\" name=\"correom\"  value=\""+ objPublicacion.getCorreoelectronico()+"\" required=\"required\" placeholder=\"correo\"/>"
                + "                             </div>"
                + "                             </div>"
                + "                             <div class='input-group'>"
                + "                                 <br>"
                + "                                 <label class='col-sm-2 col-form-label'>Coautor</label>"
                +"                                   <div class=\"col-sm-10\">"
                + "                                 <input type=\"text\" class=\"form-control Curso\" id=\"coautorm\" name=\"coautorm\"  value=\""+ objPublicacion.getCoautores()+"\" required=\"required\" placeholder=\"coautor\"/>"
                + "                             </div>"
                + "                             </div><br>"
               + "                             <div class='input-group'><br>"
                + "                                 <label class='col-sm-2 col-form-label'>Tipo</label>"
                +"                                   <div class=\"col-sm-10\">"
                + "                                 <select class='form-control' name=\"tipom\" id=\"tipom\">"
                +"</div>";
        for (Tipo oTipo : listTipo) {
            if (oTipo.getDescripciontipo().equals(objPublicacion.getIdtipo().getDescripciontipo())){
                result += "                          <option value='"+oTipo.getIdtipo()+"' selected>"+oTipo.getDescripciontipo()+"</option>";
            }
            if (!oTipo.getDescripciontipo().equals(objPublicacion.getIdtipo().getDescripciontipo())){
                result += "                          <option value='"+oTipo.getIdtipo()+"' >"+oTipo.getDescripciontipo()+"</option>";
            }
        }
        result  += "                                 </select>"
                + "                             </div>"
                + "                     </div>"
                + "                 </div>"
                + "             </div>"
                + "             <div class='modal-footer'>"
                + "                    <button type='button' id='BtnCerrar' class='btn btn-secondary' data-dismiss='modal' >Cerrar</button>"
                + "                    <button type='button' id='BtnActual' class='btn btn-primary' data-toggle='modal' data-target='#ModalActualiza'>Actualizar</button>"
                + "                    <button type='button' id='BtnElimin' class='btn btn-danger' data-toggle='modal' data-target='#ModalElimina'> Eliminar</button>"
                + "             </div>"
                + "         </div>"
                + "     </div>"
                + " </div>"
                + "<!-- Modal Actualiza-->"
                + "<div class='modal fade' id='ModalActualiza' tabindex='-1' role='dialog' aria-labelledby='ModalActualizaLabel' aria-hidden='true'>"
                + "     <div class='modal-dialog' role='document'>"
                + "          <div class='modal-content'>"
                + "               <div class='modal-header' align='center'>"
                + "                    <h5 class='modal-title' id='exampleModalLabel'>EDITAR PUBLICACIÓN</h5>"
                + "                    <button type='button' class='close' data-dismiss='modal' aria-label='Close'>"
                + "                         <span aria-hidden='true'>&times;</span>"
                + "                    </button>"
                + "               </div>"
                + "               <div class='modal-body'>"
                + "                    Esta seguro de guardar los cambios efectuados sobre la publicación <b></b>"
                + "               </div>"
                + "               <div class='modal-footer'>"
                + "                    <button type='button' class='btn btn-secondary' data-dismiss='modal'>Cancelar</button>"
                + "                    <button type='button' class='btn btn-primary' data-dismiss='modal' onclick='clickActPublicacion(" + objPublicacion.getIdpublicacion() + "); return false;' >Aceptar</button>"
                + "               </div>"
                + "          </div>"
                + "     </div>"
                + "</div>"
                + "<!-- Modal Elimina-->"
                + "<div class='modal fade' id='ModalElimina' tabindex='-1' role='dialog' aria-labelledby='ModalEliminaLabel' aria-hidden='true'>"
                + "     <div class='modal-dialog' role='document'>"
                + "          <div class='modal-content'>"
                + "               <div class='modal-header' align='center'>"
                + "                    <h5 class='modal-title' id='exampleModalLabel'>ELIMINAR PUBLICACIÓN</h5>"
                + "                    <button type='button' class='close' data-dismiss='modal' aria-label='Close'>"
                + "                         <span aria-hidden='true'>&times;</span>"
                + "                    </button>"
                + "               </div>"
                + "               <div class='modal-body'>"
                + "                    Esta seguro de eliminar la publicación <b></b>"
                + "               </div>"
                + "               <div class='modal-footer' align='center'>"
                + "                    <button type='button' class='btn btn-secondary' data-dismiss='modal'>Cancelar</button>"
                + "                    <button type='button' class='btn btn-primary' data-dismiss='modal' onclick='clickElimPublicacion(" + objPublicacion.getIdpublicacion() + "); return false;' >Aceptar</button>"
                + "               </div>"
                + "          </div>"
                + "     </div>"
                + "</div>"
                + "</form>";
        return result;
    }
}
