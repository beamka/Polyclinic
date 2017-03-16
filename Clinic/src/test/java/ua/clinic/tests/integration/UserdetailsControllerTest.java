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
import ua.ibt.clinic.api.DetailsAPI;
import ua.ibt.clinic.api.DoctorAPI;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Iryna Tkachova on 11.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserdetailsControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(UserdetailsControllerTest.class);

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void test_addDetails() throws Exception {
        logger.debug(">>>>>>>>>> test_addDetails >>>>>>>>>>");
        DetailsAPI detailsAPI = new DetailsAPI();
        detailsAPI.iduser = Long.valueOf(984844);
        detailsAPI.numcard = "aa-111";
        detailsAPI.name = "Ivan";
        detailsAPI.surname = "Ivanenko";
        detailsAPI.middlename = "Ivanovich";
        detailsAPI.birthday = new SimpleDateFormat("yyyy-MM-dd").parse("2001-10-10");
        detailsAPI.sex = "M";
        detailsAPI.notes = "test";

        ObjectMapper om = new ObjectMapper();
        String content = om.writeValueAsString(detailsAPI);

        MvcResult result = mockMvc.perform(post("/details/set")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content)
        )
                .andExpect(status().isOk())
                .andReturn();

        String reply = result.getResponse().getContentAsString();
        DetailsAPI resultData = om.readValue(reply, DetailsAPI.class);
        assertEquals("Reurn code in not 0",resultData.retcode.longValue(), 0L);
    }

    @Test
    public void test_setDoctor() throws Exception {
        logger.debug(">>>>>>>>>> test_setDoctor >>>>>>>>>>");
        DoctorAPI doctorAPI = new DoctorAPI();
        doctorAPI.iduser = Long.valueOf(984844);
        doctorAPI.tabnumber = Long.valueOf(22222);

        ObjectMapper om = new ObjectMapper();
        String content = om.writeValueAsString(doctorAPI);

        MvcResult result = mockMvc.perform(post("/doctor/set")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content)
        )
                .andExpect(status().isOk())
                .andReturn();

        String reply = result.getResponse().getContentAsString();
        DetailsAPI resultData = om.readValue(reply, DetailsAPI.class);
        assertEquals("Reurn code in not 0",resultData.retcode.longValue(), 0L);
    }

}
