/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS.service;

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
@Path("entidades.tipo")
public class TipoFacadeREST extends AbstractFacade<Tipo> {

    @PersistenceContext(unitName = "ADTRANSPORTESPU")
    private EntityManager em;

    public TipoFacadeREST() {
        super(Tipo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Tipo entity) {
        super.create(entity);
    }
    
    

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Tipo entity) {
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
    public Tipo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tipo> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("findall")
    @Produces({"application/json"})
    public ArrayList<Tipo> Tipos() {
        try {
            List<Tipo> t = super.findAll();
            ArrayList<Tipo> tip = new ArrayList<>(); 
            for (int i = 0; i < t.size(); i++) {
                    tip.add(t.get(i)); 
            }
            return tip; 
        } catch (Exception e) {
            Logger.getLogger("TipoFacadeREST").log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tipo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
