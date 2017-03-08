package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.clinic.jpa.Ugroup;
import ua.clinic.repository.UgroupRepository;
import ua.clinic.repository.UserRepository;
import ua.ibt.clinic.api.Group;

/**
 * Created by Iryna Tkachova on 08.03.2017.
 */
@Component
public class UgroupMapper {
    private static final Logger logger =  LoggerFactory.getLogger(UgroupMapper.class);

    @Autowired
    UgroupRepository ugroupRepository;
    @Autowired
    UserRepository userRepository;

    public Ugroup toInside(Group inData) {
        Ugroup newGroup = null;
        if(inData != null){
            newGroup = new Ugroup(inData.group_id, inData.group_name, inData.description);
            logger.debug("##### newGroup: "+newGroup);
        }
        return newGroup;
    }

    public Group toOutside(Ugroup inData) {
        Group group = null;
        if (inData != null) {
            group = new Group();
            group.group_id = inData.getIdgroup();
            group.group_name = inData.getGroupname();
            group.description = inData.getDescription();
        }
        return group;
    }

}
