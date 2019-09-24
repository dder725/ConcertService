package se325.assignment01.concert.service.services;

import se325.assignment01.concert.common.dto.ConcertDTO;
import se325.assignment01.concert.common.dto.ConcertSummaryDTO;
import se325.assignment01.concert.service.domain.Concert;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se325.assignment01.concert.service.domain.Performer;
import se325.assignment01.concert.service.mapper.ConcertMapper;
import se325.assignment01.concert.service.mapper.ConcertSummaryMapper;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
/*
This classes provides implementation of Concert-related services
 */
@Path("concert-service/concerts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConcertResource {

    private static Logger LOGGER = LoggerFactory.getLogger(ConcertResource.class);

    @GET
    @Path("{id}")
    public ConcertDTO retrieveConcert(@PathParam("id") long id){
        EntityManager em = PersistenceManager.instance().createEntityManager();
        em.getTransaction().begin();

        Concert c = em.find(Concert.class, id);
        em.getTransaction().commit();

        if(c == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return ConcertMapper.toDTO(c);
    }

    @GET
    @Path("/summaries")
    public List<ConcertSummaryDTO> rerieveSummary(){
        List<ConcertSummaryDTO> concertSummaryDTOS= new ArrayList<ConcertSummaryDTO>();
        List<Concert> allConcerts = getAllConcerts();
        for(Concert c : allConcerts){
            concertSummaryDTOS.add(ConcertSummaryMapper.toDTO(c));
        }

        return concertSummaryDTOS;
    }

    @GET
    @Path("")
    public List<ConcertDTO> retrieveAllConcerts(){
        List<Concert> allConcerts = getAllConcerts();
        List<ConcertDTO> allConcertsDTOs = new ArrayList<ConcertDTO>();

        for(Concert c: allConcerts){
            allConcertsDTOs.add(ConcertMapper.toDTO(c));
        }

        return allConcertsDTOs;
    }

    public List<Concert> getAllConcerts(){
        EntityManager em = PersistenceManager.instance().createEntityManager();

        em.getTransaction().begin();
        List<Concert> allConcerts = em.createQuery("SELECT c from Concert c").getResultList();
        em.getTransaction().commit();

        return allConcerts;
    }


}
