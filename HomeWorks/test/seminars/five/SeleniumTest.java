package seminars.five;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTest {
    // Задание No4
    //  Напишите автоматизированный тест, который выполнит следующие шаги:
    //  1. Открывает главную страницу Google.
    //  2. Вводит "Selenium" в поисковую строку и нажимает кнопку "Поиск в Google".
    //  3. В результатах поиска ищет ссылку на официальный сайт Selenium
    //  (https://www.selenium.dev) и проверяет, что ссылка действительно присутствует среди
    //  результатов поиска.

    @Test
    void testGoogleSearch() {
//        String chromeDriverPath = "/large/data2/Home/Andrew/Documents/geekbrains/UnitTest_20231007/Seminars/selenium/chromedriver/chromedriver_linux64/chromedriver";
//        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        WebElement seleniumLink = driver.findElement(By.tagName("cite"));
        assertThat(seleniumLink.getText()).isEqualTo("https://www.selenium.dev");

        driver.quit();
    }

    // Задание No5
    //  Нужно написать сквозной тест с использованием Selenium, который авторизует
    // пользователя на сайте
    // https://www.saucedemo.com/
    // . Данные для входа - логин:
    //  "standard_user",
    //  пароль:
    //  "secret_sauce".
    // Проверить, что авторизация прошла успешно и отображаются товары.
    // Вам необходимо использовать WebDriver для открытия страницы и методы sendKeys()
    // для ввода данных в поля формы, и submit() для отправки формы. После этого,
    // проверьте, что на странице отображаются продукты
    // (productsLabel.getText() = "Products").

    @Test
    void testSauce() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement nameElement = driver.findElement(By.id("user-name"));
        WebElement passElement = driver.findElement(By.id("password"));

        nameElement.sendKeys("standard_user");
        passElement.sendKeys("secret_sauce");
        passElement.submit();

        WebElement siteElement = driver.findElement(By.className("title"));
        assertThat(siteElement.getText()).isEqualTo("Products");

        driver.quit();

    }
}
