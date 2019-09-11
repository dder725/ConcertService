package se325.assignment01.concert.service.services;

import org.slf4j.LoggerFactory;
import se325.assignment01.concert.service.domain.Concert;

import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/concerts")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ConcertResource {

    private static Logger LOGGER = LoggerFactory.getLogger(Concert.class);

    @GET
    @Path("{id}")
    public Response retrieveConcert(@PathParam("id") long id){
        EntityManager em = PersistenceManager.instance().createEntityManager();
        em.getTransaction().begin();

        Concert c = em.find(Concert.class, id);
        em.getTransaction().commit();

        if(c == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return Response.ok(c).build();
    }

}
