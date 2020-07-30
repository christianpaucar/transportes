/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS.service;

import ENTIDADES.Publicacion;
import ENTIDADES.Tipo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author SICOJUMP
 */
@Stateless
@Path("entidades.publicacion")
public class PublicacionFacadeREST extends AbstractFacade<Publicacion> {

    @PersistenceContext(unitName = "ADTRANSPORTESPU")
    private EntityManager em;

    public PublicacionFacadeREST() {
        super(Publicacion.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Publicacion entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Publicacion entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Publicacion find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Publicacion> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("findTipo/{idtipo}")
    @Produces({"application/json"})
    public ArrayList<Publicacion> publicacionesPorTipo(@PathParam("idtipo") Integer idtipo) {
        try {
            List<Publicacion> p = super.findAll();
            ArrayList<Publicacion> pub = new ArrayList<>(); 
            for (int i = 0; i < p.size(); i++) {
                if(p.get(i).getIdtipo().getIdtipo().equals(idtipo))
                    pub.add(p.get(i)); 
            }
            return pub; 
        } catch (Exception e) {
            Logger.getLogger("PublicacionFacadeREST").log(Level.SEVERE, e.getMessage());
        }
        return null;
    }
    
      @GET
    @Path("findall")
    @Produces({"application/json"})
    public ArrayList<Publicacion> Publicaciones() {
        try {
            List<Publicacion> t = super.findAll();
            ArrayList<Publicacion> tip = new ArrayList<>(); 
            for (int i = 0; i < t.size(); i++) {
                    tip.add(t.get(i)); 
            }
            return tip; 
        } catch (Exception e) {
            Logger.getLogger("PublicacionFacadeREST").log(Level.SEVERE, e.getMessage());
        }
        return null;
    }


    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Publicacion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
