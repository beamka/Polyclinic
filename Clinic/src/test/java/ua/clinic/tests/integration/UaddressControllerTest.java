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
import ua.ibt.clinic.api.AddressAPI;
import ua.ibt.clinic.api.ListAddresses;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UaddressControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(UaddressControllerTest.class);

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void test_addAddress() throws Exception {
        logger.debug(">>>>>>>>>> test_addAddress >>>>>>>>>>");
        AddressAPI addressAPI = new AddressAPI();
        addressAPI.country = "Ukraine";
        addressAPI.city = "Chernigiv";
        addressAPI.street = "street";
        addressAPI.numhouse = "123";
        addressAPI.hull= "A";
        addressAPI.flat = "1";
        addressAPI.iduser = Long.valueOf(984844);

        ObjectMapper om = new ObjectMapper();
        String content = om.writeValueAsString(addressAPI);

        MvcResult result = mockMvc.perform(post("/address/add")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content)
        )
                .andExpect(status().isOk())
                .andReturn();

        String reply = result.getResponse().getContentAsString();
        ListAddresses resultData = om.readValue(reply, ListAddresses.class);
        assertEquals("Reurn code in not 0",resultData.retcode.longValue(), 0L);

    }
}
