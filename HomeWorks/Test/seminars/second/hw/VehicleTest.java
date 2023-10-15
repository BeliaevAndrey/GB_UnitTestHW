package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    Домашнее задание к семинару №2 JUnit:
    1. Настроить новый проект:
        a). Нужно создать новый проект, с представленной структурой классов
        b). Настроить тестовую среду
            (создать тестовый класс VehicleTest, пометить папку как Test sources (зеленая папка),
            импортировать необходимые для тестов библиотеки (JUnit, assertJ - все что было на семинаре))
        c). Написать следующие тесты:
            - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
            - проверка того, объект Car создается с 4-мя колесами
            - проверка того, объект Motorcycle создается с 2-мя колесами
            - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
            - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
            - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
            - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
   */
class VehicleTest {

    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void steUp() {
        car = new Car("Dodge", "Ram", 2010);
        motorcycle = new Motorcycle("TestMC", "Tested", 1900);
    }

    /* проверка того, что экземпляр объекта Car также является экземпляром
     транспортного средства; (instanceof) */
    @Test
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    /* проверка того, объект Car создается с 4-мя колесами  */
    @Test
    public void testCarGetNumWheels() {
        assertEquals(car.getNumWheels(), 4);
    }

    /* проверка того, объект Motorcycle создается с 2-мя колесами  */
    @Test
    public void testMCGetNumWheels() {
        assertEquals(motorcycle.getNumWheels(), 2);
    }

   /* проверка того, объект Car развивает скорость 60 в режиме
   тестового вождения (testDrive()) */
    @Test
    public void testCarGetSpeed() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

   /* проверка того, объект Motorcycle развивает скорость 75 в режиме
   тестового вождения (testDrive()) */
   @Test
   public void testMCGetSpeed() {
       motorcycle.testDrive();
       assertEquals(75, motorcycle.getSpeed());
   }

   /* проверить, что в режиме парковки (сначала testDrive, потом park, т.е
   эмуляция движения транспорта) машина останавливается (speed = 0) */
    @Test
    public void testCarStopsOnParkMode() {
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    /* проверить, что в режиме парковки (сначала testDrive, потом park  т.е
    эмуляция движения транспорта) мотоцикл останавливается (speed = 0) */
   @Test
   public void testMCStopsOnParkMode() {
       motorcycle.testDrive();
       motorcycle.park();
       assertEquals(0, car.getSpeed());

   }
}