package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.tdd.UserRepository;

public class TestUserRepositoryLogoutFunc {

    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    void testLogoutAllButAdm(){

    }
}
