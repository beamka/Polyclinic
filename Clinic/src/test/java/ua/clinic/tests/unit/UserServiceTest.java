package ua.clinic.tests.unit;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import ua.clinic.jpa.Userdetails;
import ua.clinic.jpa.Group;
import ua.clinic.jpa.User;
import ua.clinic.repository.UgroupRepository;
import ua.clinic.repository.UserRepository;
import ua.clinic.services.UgroupService;
import ua.clinic.services.UserService;
import ua.clinic.services.UserdetailsService;

/**
 * @author Iryna Tkachova
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class UserServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserdetailsService userdetailsService;
    @Autowired
    UgroupService ugroupService;
    @Autowired
    UgroupRepository ugroupRepository;


    @Test
    public void setDefoultdata(){
        User user = new User();
        Userdetails userdetails = new Userdetails();
        List<Group> groups = new ArrayList<>();
//        try {
//            ugroupService.createDefoultGroups();
//            for (Group ugroup : ugroupService.getAllUgroup()) {
//                groups.add(ugroup);
//            }
//        } catch (Exception e) {
//            logger.error(">>>>>>> Error createDefoultGroups. Expetion: " + e.getMessage(), e);
//        }


        //-----------
        user.setLogin("aaaaa");
        user.setPasswdhash("11111");
        user.setEmail("test_email");
        user.setCreatedby("test");
        user.setLastlogin(new Date());
        User user1 = userService.newUser(user);
        assertNotNull("New user not add!", user1);

        userdetails.setIduser(user1.getIduser());
        userdetails.setNumcard("aa-111");
        userdetails.setName("Ivan");
        userdetails.setSurname("Ivanenko");
        userdetails.setMiddlename("Ivanovich");
        userdetails.setBirthday(new Date(Long.valueOf("2001-01-01")));
        userdetails.setNotes("test");
        Userdetails userdetails1 = userdetailsService.addDetails(userdetails);
        assertNotNull("New userdetails not add!", userdetails1);
        //-----------
        user.setLogin("bbbbb");
        user.setPasswdhash("22222");
        user.setEmail("test_email");
        user.setCreatedby("test");
        user.setLastlogin(new Date());
        User user2= userService.newUser(user);
        assertNotNull("New user not add!", user2);

        userdetails.setIduser(user1.getIduser());
        userdetails.setNumcard("bb-222");
        userdetails.setName("Petro");
        userdetails.setSurname("Petrenko");
        userdetails.setMiddlename("Petrovich");
        userdetails.setBirthday(new Date(Long.valueOf("2002-02-02")));
        userdetails.setNotes("test");
        Userdetails userdetails2 = userdetailsService.addDetails(userdetails);
        assertNotNull("New userdetails not add!", userdetails2);
        //-----------
        user.setLogin("ccccc");
        user.setPasswdhash("33333");
        user.setEmail("test_email");
        user.setCreatedby("test");
        user.setLastlogin(new Date());
        User user3 = userService.newUser(user);
        assertNotNull("New user not add!", user3);

        userdetails.setIduser(user1.getIduser());
        userdetails.setNumcard("cc-333");
        userdetails.setName("Mikolay");
        userdetails.setSurname("Mikolaenko");
        userdetails.setMiddlename("Mikolaiovich");
        userdetails.setBirthday(new Date(Long.valueOf("2003-03-03")));
        userdetails.setNotes("test");
        Userdetails userdetails3 = userdetailsService.addDetails(userdetails);
        assertNotNull("New userdetails not add!", userdetails3);

    }

    
//    @Test
//    public void findUserTest() throws Exception {
//        int count = userServie.getAllUsers().size();
//        assert(count>=6);
//    }
//
//    @Test
//    public void findByNameTest(){
//        //List<Appuser> ul = userServie.findUserByName("Ivan", "Ivanov");
//        List<User> ul = userServie.findUserByName("Ivan", "Ivanow");
//        int count = ul.size();
//        assertEquals("Can not find pre-defined user",1, count);
//    }
//
//    @Test
//    public void addUserTest(){
//        Long user_id = EntityIdGenerator.random();
//        User au = new User(user_id);
//        Userdetails ud = new Userdetails(user_id);
//        au.setCreatedby("test");
//        au.setLogin("test_username");
//        au.setEmail("ttt@test.com");
//        au.setPasswdhash("none");
//       // ud.setFirstName("TestUserFirst");
//       // ud.setLastName("TestUserLast");
//        //this one is not optional in JPA, fix it!
//        ud.setNotes("none");
//        au.setUserdetails(ud);
//        userServie.addUser(au);
//        User u = userServie.getUserById(user_id);
//        assertNotNull("New user not found!", u);
//        userServie.delUser(user_id);
//        u = userServie.getUserById(user_id);
//        assertNull("Can not delete user!", u);
//    }
}
