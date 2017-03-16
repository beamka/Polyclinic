package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.clinic.jpa.Group;
import ua.clinic.repository.UgroupRepository;
import ua.clinic.repository.UserRepository;
import ua.ibt.clinic.api.GroupAPI;

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

    public Group toInside(GroupAPI inData) {
        Group newGroup = null;
        if(inData != null){
            newGroup = new Group(inData.group_id, inData.group_name, inData.description);
            logger.debug("##### newGroup: "+newGroup);
        }
        return newGroup;
    }

    public GroupAPI toOutside(Group inData) {
        GroupAPI groupAPI = null;
        if (inData != null) {
            groupAPI = new GroupAPI();
            groupAPI.group_id = inData.getIdgroup();
            groupAPI.group_name = inData.getGroupname();
            groupAPI.description = inData.getDescription();
        }
        return groupAPI;
    }

}
