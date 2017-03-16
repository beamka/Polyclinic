package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.clinic.repository.GraphicRepository;

/**
 * Created by Iryna Tkachova on 15.03.2017.
 */
@Service
public class GraphicService {
    private static final Logger logger = LoggerFactory.getLogger(GraphicService.class);

    @Autowired
    GraphicRepository graphicRepository;


}
