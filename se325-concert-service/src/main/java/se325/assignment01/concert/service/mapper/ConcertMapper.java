package se325.assignment01.concert.service.mapper;

import se325.assignment01.concert.common.dto.ConcertDTO;
import se325.assignment01.concert.common.dto.PerformerDTO;
import se325.assignment01.concert.service.domain.Concert;
import se325.assignment01.concert.service.domain.Performer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class handles transformation between ConcertDTO and Concert classes
 */
public class ConcertMapper {
    public static ConcertDTO toDTO(Concert c){
        return new ConcertDTO(c.getId(), c.getTitle(), c.getImageName(), c.getBlurb(), new ArrayList<>(c.getDates()), new ArrayList<>(c.getPerformers()));
    }
    public static Concert fromDTO(ConcertDTO c){
        Set<Performer> performers = new HashSet<>();
        List<PerformerDTO> performerDTOS = c.getPerformers();
        for(PerformerDTO p: performerDTOS){
            performers.add(PerformerMapper.fromDTO(p));
        }
        return new Concert(c.getId(), c.getTitle(), c.getImageName(), new HashSet<>(c.getDates()), performers);
    }
}
