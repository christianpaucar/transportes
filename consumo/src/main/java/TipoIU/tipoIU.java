/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TipoIU;

import ENTIDADES.Tipo;
import java.util.ArrayList;
import org.json.JSONException;

/**
 *
 * @author SICOJUMP
 */
public class tipoIU {
    
    private ArrayList<Tipo> listTipo = new ArrayList<>();
    
    private Tipo objTipo = new Tipo();
    
    public tipoIU() {
    }

//    public tipoIU(Integer id) {
//        super(id);
//    }

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
        this.objTipo = objTipo;
    }
 
    public String HTMLVista() throws JSONException {
       
        String result = "";
        result += "<form  id='frmIngresarAP'>"
                + "<script>  $('#f').on('change', function(ev) {   var f = ev.target.files[0];    var fr = new FileReader();     fr.onload = function(ev2) { console.dir(ev2);$('#i').attr('src', ev2.target.result);};   var src = $(this).attr('src');  fr.readAsDataURL(f); console.info(src);});</script>"
                + " <div id='faq' role='tablist' aria-multiselectable='true'>"
                + "     <div class='card'>"
                + "          <div class='card-header' role='tab' id='questionTwo'>"
                + "             <h5 class='card-title'>"
                + "                 <a class='collapsed' data-toggle='collapse' data-parent='#faq' href='#answerTwo' aria-expanded='false' aria-controls='answerTwo'>"
                + "                     <p align='right'><i class='fa fa-plus-circle' title='INGRESAR TIPO'> Nuevo Tipo.</i></p>"
                + "                 </a>"
                + "             </h5>"
                + "          </div>"
                + "          <div id='answerTwo' class='collapse' role='tabcard' aria-labelledby='questionTwo'>"
                + "              <div class='card-header'>"
                + "                 <form>"
                + "                     <div class='form-row'>"
                + "                         <div class='col-md-8'>"                                            
                + "                             <div class='input-group'>"
                + "                                 <br>"
                + "                                 <label>Descripcion</label>"
                + "                                 <input type=\"text\" class=\"form-control Curso\" id=\"tipoip\" name=\"tipoip\"  value=\"\" required=\"required\" placeholder=\"Descripcion\"/>"
                + "                             </div>"                                       
                + "                         </div>"
                + "                         <div class='col-md-12 class='form-row' align='right'>"
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
                + "          <div class='card'>"
                + "             <div class='card-header' role='tab' id='questionOne'>"
                + "                 <h5 class='card-title'>"
                + "                     <a data-toggle='collapse' data-parent='#faq'  href='#answerOne' aria-expanded='true' aria-controls='answerOne'>"
                + "                         <p align='left'><i class='fa fa-eye' title='VER TIPO'> Tipos Registrados</i></p>"
                + "                     </a>"
                + "                 </h5>"
                + "             </div>"
                + "             <div id='answerOne' class='collapse in' role='tabcard' aria-labelledby='questionOne'>"
                + "                 <div class='card-title'>"
                + "                     <table class='table table-hover'>"
                + "                         <thead>"
                + "                             <tr>"
                + "                             <th scope='col'>N.</th>"
                + "                             <th scope='col'>Descripcion</th>"                                           
                + "                             </tr>"
                + "                         </thead>";
        int cont = 0;
        for (Tipo oTipo : listTipo) {
            cont++;
        result += "                         <tbody>"
                + "                             <tr onclick='clicModalMuestra(" + oTipo.getIdtipo()+ "); return false;'>"
                + "                             <th style='font-weight: bold;'>" + cont + "</th>"
                + "                             <th style='font-weight: bold;'>" + oTipo.getDescripciontipo()+ "</th>"                                       
                + "                             </tr>"
                + "                         </tbody>";
        }
        result += "                     </table>"
                + "                 </div>"
                + "             </div>"
                + "         </div>"
                + "     </div>"
                + "</div>"
                + "<!-- Modal Ingresa-->"
                + " <div class='modal fade' id='exampleModal' tabindex='-1' role='dialog' aria-labelledby='exampleModalLabel' aria-hidden='true'>"
                + "    <div class='modal-dialog' role='document'>"
                + "       <div class='modal-content'>"
                + "              <div class='modal-header' align='center'>"
                + "                 <h5 class='modal-title' id='exampleModalLabel'>INGRESAR TIPO</h5>"
                + "                 <button type='button' class='close' data-dismiss='modal' aria-label='Close'>"
                + "                     <span aria-hidden='true'>&times;</span>"
                + "                 </button>"
                + "              </div>"
            + "                  <div class='modal-body'>"
            + "                      Desea ingresar el tipo de publicacion a la DB?"
            + "                  </div>"
            + "                  <div class='modal-footer'>"
            + "                      <button type='button' class='btn btn-secondary' data-dismiss='modal'>Cancelar</button>"
            + "                      <button type='button' class='btn btn-primary' data-dismiss='modal' onclick='TipoGuardar(); return false;' >Aceptar</button>"           
            + "                  </div>"
            + "             </div>"
            + "         </div>"
            + "     </div>"
            + " </form>"
            + " <script src=\"frontendtipo/TipoJS.js\" type=\"text/javascript\"></script>";
        return result;
    }
}
