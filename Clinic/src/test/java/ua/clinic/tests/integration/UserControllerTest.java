package ua.clinic.tests.integration;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ua.ibt.clinic.api.UserAPI;
import ua.ibt.clinic.api.ListUsersReceive;

import java.util.Date;


/**
 * @author Iryna Tkachova
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_newUser() throws Exception{
        logger.debug(">>>>>>>>>> test_newUser >>>>>>>>>>");
        UserAPI user = new UserAPI();
        user.login = "test_login";
        //user.name = "test_name";
        //user.surname = "test_surname";
        user.email = "test_email";
        user.passwdhash = "test_passwdhash";
        //user.numcard = "test_numcard";
        user.createdby = "test_MockMvc";
        user.lastlogin = new Date();
        //user.birthday = new SimpleDateFormat("yyyy-MM-dd").parse("2008-10-10");

        ObjectMapper om = new ObjectMapper();
        String content = om.writeValueAsString(user);

        MvcResult result = mockMvc.perform(post("/user/new")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content)
        )
                .andExpect(status().isOk())
                .andReturn();

        String reply = result.getResponse().getContentAsString();
        ListUsersReceive resultData = om.readValue(reply, ListUsersReceive.class);
        assertEquals("Reurn code in not 0",resultData.retcode.longValue(), 0L);
//        if(resultData.retcode==0){
//            mockMvc.perform(delete("/users/del/"+resultData.users.get(0).user_id)
//                    .accept(MediaType.APPLICATION_JSON_UTF8)
//            )
//                    .andExpect(status().isOk());
//        }
    }
        
//    @Test
//    public void findUserTest() throws Exception {
//        this.mockMvc.perform(get("/users/byid/1"))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("librarian1")));
//    }
//
//    @Test
//    public void addUserTest() throws Exception{
//        AddUserRequest rq = new AddUserRequest();
//        rq.user = new UserAPI();
//        //rq.user.firstName = "Test1First";
//       // rq.user.isLibrarian = true;
//      //  rq.user.lastName ="Test1Last";
//        rq.user.login ="test_user_1";
//        //rq.user.email="test@test.com";
//
//        ObjectMapper om = new ObjectMapper();
//        String content = om.writeValueAsString(rq);
//
//        MvcResult result = mockMvc.perform(post("/users/add")
//                 .accept(MediaType.APPLICATION_JSON_UTF8)
//                 .contentType(MediaType.APPLICATION_JSON_UTF8)
//                 .content(content)
//         )
//           .andExpect(status().isOk())
//         .andReturn();
//
//        String reply = result.getResponse().getContentAsString();
//        UserListReply ur = om.readValue(reply, UserListReply.class);
//        assertEquals("Reurn code in not 0",ur.retcode.longValue(), 0L);
//        if(ur.retcode==0){
//            mockMvc.perform(delete("/users/del/"+ur.users.get(0).user_id)
//                                  .accept(MediaType.APPLICATION_JSON_UTF8)
//                           )
//                    .andExpect(status().isOk());
//
//
//        }
//    }
}
