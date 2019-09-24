package se325.assignment01.concert.service.mapper;

import se325.assignment01.concert.common.dto.ConcertDTO;
import se325.assignment01.concert.common.dto.ConcertSummaryDTO;
import se325.assignment01.concert.service.domain.Concert;
/*
This class handles transformation from Concert class to ConcertSummaryDTO
 */
public class ConcertSummaryMapper {
    public static ConcertSummaryDTO toDTO(Concert c){
        return new ConcertSummaryDTO(c.getId(), c.getTitle(), c.getImageName());
    }
}
