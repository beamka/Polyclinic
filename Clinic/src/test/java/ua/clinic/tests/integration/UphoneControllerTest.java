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
import ua.ibt.clinic.api.ListPhones;
import ua.ibt.clinic.api.PhoneAPI;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UphoneControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(UphoneControllerTest.class);

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void test_addPhone() throws Exception {
        logger.debug(">>>>>>>>>> test_addPhone >>>>>>>>>>");
        PhoneAPI phoneAPI = new PhoneAPI();
        phoneAPI.phone = "77-77-777";
        phoneAPI.phoneinfo = "test_phone";
        phoneAPI.iduser = Long.valueOf(984844);

        ObjectMapper om = new ObjectMapper();
        String content = om.writeValueAsString(phoneAPI);

        MvcResult result = mockMvc.perform(post("/phone/add")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content)
        )
                .andExpect(status().isOk())
                .andReturn();

        String reply = result.getResponse().getContentAsString();
        ListPhones resultData = om.readValue(reply, ListPhones.class);
        assertEquals("Reurn code in not 0",resultData.retcode.longValue(), 0L);

    }
}
