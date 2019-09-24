package se325.assignment01.concert.service.services;
/*
This class provides implementation of Performer-related services
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se325.assignment01.concert.common.dto.PerformerDTO;
import se325.assignment01.concert.service.domain.Performer;
import se325.assignment01.concert.service.mapper.PerformerMapper;
import sun.misc.Perf;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("concert-service/performers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerformerResource {
    private static Logger LOGGER = LoggerFactory.getLogger(ConcertResource.class);

    @GET
    @Path("{id}")
    public PerformerDTO getPerformer(@PathParam("id") long id){
        EntityManager em = PersistenceManager.instance().createEntityManager();
        em.getTransaction().begin();

        Performer p = em.find(Performer.class, id);
        em.getTransaction().commit();


        if(p == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return PerformerMapper.toDTO(p);
    }

    @GET
    @Path("")
    public List<PerformerDTO> getAllPerformers(){
        EntityManager em = PersistenceManager.instance().createEntityManager();

        em.getTransaction().begin();
        List<Performer> allPerformers = em.createQuery("SELECT p from Performer p").getResultList();
        em.getTransaction().commit();
        List<PerformerDTO> performerDTOS = new ArrayList<PerformerDTO>();

        for(Performer p : allPerformers){
            performerDTOS.add(PerformerMapper.toDTO(p));
        }
        return performerDTOS;
    }

}
