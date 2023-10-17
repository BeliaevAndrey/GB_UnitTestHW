package seminars.third;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @ParameterizedTest
    @ValueSource(doubles = {-5.0, 0, 5.0,})
    void testComputeAreaCircle(double radius) {
        Calculator calculator = new Calculator();
        if(radius < 0){
            Exception error = assertThrows(
                    IllegalArgumentException.class,
                    () -> calculator.computeAreaCircle(radius));
            assertThat(error.getMessage()).isEqualTo(Calculator.errorMessage);
        } else {
            assertEquals(Math.PI * radius * radius, calculator.computeAreaCircle(radius));
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {-5.0, 0, 5.0})
    void testComputeLengthCircle(double radius) {
        Calculator calculator = new Calculator();
        if(radius < 0){
            Exception error = assertThrows(
                    IllegalArgumentException.class,
                    () -> calculator.computeLengthCircle(radius));
            assertThat(error.getMessage()).isEqualTo(Calculator.errorMessage);
        } else {
            assertEquals(2 * Math.PI * radius, calculator.computeLengthCircle(radius));
        }
    }
}