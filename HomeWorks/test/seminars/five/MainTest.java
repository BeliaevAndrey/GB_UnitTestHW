package seminars.five;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    //5.1. Создайте два модуля. Первый модуль генерирует список случайных чисел. Второй модуль находит
    //  максимальное число в этом списке.
    //  Вам нужно сначала написать юнит-тесты для каждого модуля, затем написать интеграционный
    //  тест, который проверяет, что оба модуля работают вместе правильно
    List<Integer> randomList;

    @BeforeEach
    void setUp() {
        randomList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    void testMaxNumberModule() {
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        int actual = maxNumberModule.getMax(randomList);
        assertThat(actual).isEqualTo(7);
    }

    @Test
    void testMaxNumberModuleFail() {
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        int actual = maxNumberModule.getMax(new ArrayList<>());
        assertThat(actual).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void testRandomNumberModule() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        List<Integer> actual = randomNumberModule.getRandList(10);
        assertThat(actual).isNotEmpty().hasSize(10);
    }

    @Test
    void testMaxAndRandom() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        randomList = randomNumberModule.getRandList(10);

        int expected = Collections.max(randomList);
        int actual = maxNumberModule.getMax(randomList);

        assertEquals(expected, actual);
    }

    // 5.2. У вас есть два класса - UserService и UserRepository.
    //  UserService использует UserRepository для получения информации о пользователе.
    //  Ваша задача - написать интеграционный тест, который проверяет, что UserService
    //  и UserRepository работают вместе должным образом.
    @Test
    void testUserService() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        int id = 11;
        String expected = "User " + id;

        assertEquals(expected, userService.getUserName(id));
    }

    @Test
    void testUserServiceFail() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        int id = 11;
        String expected = "user " + id;

        assertNotEquals(expected, userService.getUserName(id));
    }

    //5.3. У вас есть сервис по обработке заказов, состоящий из двух классов:
    // OrderService и PaymentService. Класс OrderService обрабатывает заказы и
    // делает вызовы к PaymentService для обработки платежей. Ваша задача - написать
    // интеграционный тест, который проверяет, что OrderService и PaymentService
    // взаимодействуют корректно
    @Test
    void TestOrderService() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("order id", 100D);

        assertTrue(result);
    }

}