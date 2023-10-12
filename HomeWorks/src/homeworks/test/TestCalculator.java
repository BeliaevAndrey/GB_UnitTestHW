package homeworks.test;

import org.assertj.core.api.Assertions;
import seminars.first.Calculator.Calculator;

public class TestCalculator {

    public static void main(String[] args) {
        TestCalculator tc = new TestCalculator();
        tc.testCalculateDiscountPositive();
        tc.testCalculateDiscountNegativePrice();
        tc.testCalculateDiscountNegativeDiscount();
        tc.testCalculateDiscountNegativeOverDiscount();
    }

    void testCalculateDiscountPositive() {
        double purchaseAmount = 100;
        int discountAmount = 33;
        double expected = 67.0;
        Assertions.assertThat(Calculator.calculatingDiscount(purchaseAmount, discountAmount)).isEqualTo(expected);
    }

    void testCalculateDiscountNegativePrice() {
        double purchaseAmount = -100;
        int discountAmount = 33;
        Assertions.assertThatThrownBy(() ->
                        Calculator.calculatingDiscount(purchaseAmount, discountAmount))
                .isInstanceOf(ArithmeticException.class);
    }

    void testCalculateDiscountNegativeDiscount() {
        double purchaseAmount = -100;
        int discountAmount = 33;
        Assertions.assertThatThrownBy(() ->
                        Calculator.calculatingDiscount(purchaseAmount, discountAmount))
                .isInstanceOf(ArithmeticException.class);
    }

    void testCalculateDiscountNegativeOverDiscount() {
        double purchaseAmount = 100;
        int discountAmount = 133;
        Assertions.assertThatThrownBy(() ->
                        Calculator.calculatingDiscount(purchaseAmount, discountAmount))
                .isInstanceOf(ArithmeticException.class);
    }

}
