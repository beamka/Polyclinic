package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.clinic.jpa.Graphic;
import ua.clinic.repository.GraphicRepository;
import ua.ibt.clinic.api.GraphicAPI;

/**
 * Created by Iryna Tkachova on 15.03.2017.
 */
@Component
public class GraphicMapper {
    private static final Logger logger =  LoggerFactory.getLogger(GraphicMapper.class);

    @Autowired
    GraphicRepository graphicRepository;

    public Graphic toInside(GraphicAPI inData) {
        Graphic graphic = null;
        if(inData != null){
            graphic = new Graphic();
            graphic.setCabinet(inData.cabinet);
            graphic.setTime(inData.time);
            graphic.setWeekday(inData.weekday);
            logger.debug("##### toInside: result GraphicAPI = "+ graphic);
        }
        return graphic;
    }

    public GraphicAPI toOutside(Graphic inData) {
        GraphicAPI graphicAPI = null;
        if (inData != null) {
            graphicAPI = new GraphicAPI();
            graphicAPI.cabinet = inData.getCabinet();
            graphicAPI.time = inData.getTime();
            graphicAPI.weekday = inData.getWeekday();
        }
        return graphicAPI;
    }
}
