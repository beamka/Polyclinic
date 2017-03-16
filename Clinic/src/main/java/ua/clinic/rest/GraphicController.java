package ua.clinic.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ua.clinic.repository.GraphicRepository;

/**
 * Created by Iryna Tkachova on 15.03.2017.
 */
@RestController
public class GraphicController {
    private static final Logger logger =  LoggerFactory.getLogger(GraphicController.class);

    @Autowired
    GraphicRepository graphicRepository;
}
