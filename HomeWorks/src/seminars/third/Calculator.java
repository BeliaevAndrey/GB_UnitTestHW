package seminars.third;

public class Calculator {

    //HW3.1L: Попробуйте реализовать в калькуляторе с
    // помощью методологии TDD (с описанием шагов)
    // функцию расчета длины окружности
    // P=2πR
    public final static String errorMessage = "radius must be great than 0";

    public double computeAreaCircle(double radius) {
        if( radius < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
        return Math.PI * radius * radius;
    }

    public double computeLengthCircle(double radius) {
        if( radius < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
        return 2 * Math.PI * radius;
    }
}