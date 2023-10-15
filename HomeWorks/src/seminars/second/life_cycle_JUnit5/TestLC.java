package seminars.second.life_cycle_JUnit5;

import org.junit.jupiter.api.*;

@Disabled
// reason -- when ran through 'run all tests' results in:
// java.lang.NullPointerException
// at seminars.second.life_cycle_JUnit5.TestLC.setup(TestLC.java:8)
// at java.base/java.util.ArrayList.forEach(ArrayList.java:1541
public class TestLC {
    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    void setupThis() {
        System.out.println("@BeforeEach");
    }

    @Test
    void testOne() {
        System.out.println("testOne");
    }

    @Test
    void testTwo() {
        System.out.println("testTwo");
    }

    @AfterEach
    void tearThis() {
        System.out.println("@AfterEach");
    }

    @AfterAll
    static void tear() {
        System.out.println("@AfterAll");
    }
}
