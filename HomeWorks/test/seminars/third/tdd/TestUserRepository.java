package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestUserRepository {

    UserRepository userRepository;
    List<User> testUsers;
    List<User> testAdmins;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        testUsers = new ArrayList<>();
        testAdmins = new ArrayList<>();

        String uName = "User";
        String uPass = "uSecret";

        String aName = "AdUser";
        String aPass = "aSecret";
        for (int i = 0; i < 5; i++) {
            User user = new User(uName + i, uPass, false);
            user.authenticate(uName + i, uPass);
            User admin = new User(aName + i, aPass, true);
            admin.authenticate(aName + i, aPass);
            userRepository.addUser(user);
            testUsers.add(user);
            userRepository.addUser(admin);
            testAdmins.add(admin);
        }
    }

    @Test
    void testLogoutUser() {
        String userName = "User2";
        assertTrue(userRepository.findByName(userName));
        userRepository.logoutUser(testUsers.get(1));
        assertFalse(userRepository.findByName(userName));
    }

    @Test
    void testLogoutAllButAdm(){
        String uName = "User";
        String aName = "AdUser";
        for (int i = 0; i < 5; i++) {
            assertTrue(userRepository.findByName(uName + i));
            assertTrue(userRepository.findByName(aName + i));
        }

        userRepository.logoutAllButAdm();

        for (int i = 0; i < 5; i++) {
            assertFalse(userRepository.findByName(uName + i));
            assertTrue(userRepository.findByName(aName + i));
        }
    }
}
