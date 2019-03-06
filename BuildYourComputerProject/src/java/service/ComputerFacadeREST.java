package service;

import entity.Computer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import manager.ComputerManager;

@Stateless
@Path("entity.computer")
public class ComputerFacadeREST {

    @Inject
    ComputerManager cm;

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createComputer(Computer p) {
        cm.addComputer(p);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Computer> getAllComputers() {
        return cm.getAllComputers();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Computer getPizzaById(@PathParam("id") Long id) {
        return cm.getComputer(id);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void editPizza(Computer c) {
        cm.updateComputer(c);
    }

    @DELETE
    @Path("{id}")
    public void removePizza(@PathParam("id") Long id) {
        cm.deleteComputer(id);
    }

}
