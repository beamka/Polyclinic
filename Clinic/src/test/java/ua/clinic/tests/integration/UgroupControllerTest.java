package ua.clinic.tests.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ua.ibt.clinic.api.*;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Iryna Tkachova on 08.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UgroupControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(UgroupControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_newGroup() throws Exception{
        logger.debug(">>>>>>>>>> test_newGroup >>>>>>>>>>");
        Group group = new Group();
        group.group_name = "test_group_name";
        group.description = "test_description";

        ObjectMapper om = new ObjectMapper();
        String content = om.writeValueAsString(group);

        MvcResult result = mockMvc.perform(post("/group/new")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content)
        )
                .andExpect(status().isOk())
                .andReturn();

        String reply = result.getResponse().getContentAsString();
        ListGroupReceive resultData = om.readValue(reply, ListGroupReceive.class);
        assertEquals("Reurn code in not 0",resultData.retcode.longValue(), 0L);
    }

    @Test
    public void test_delAllGroups() throws Exception{
        logger.debug(">>>>>>>>>> test_delAllGroups >>>>>>>>>>");

        MvcResult result = mockMvc.perform(get("/group/delAll")
                .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(status().isOk())
                .andReturn();

        String reply = result.getResponse().getContentAsString();
        ObjectMapper om = new ObjectMapper();
        SysMessage resultData = om.readValue(reply, SysMessage.class);
        assertEquals("Reurn code in not 0",resultData.retcode.longValue(), 0L);
    }

}
