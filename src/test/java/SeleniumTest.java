import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeleniumTest {
    public WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    void titleTest() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        assertEquals("Google", title);
    }

    @Test
    void seleniumTest() {
        Function<String,WebElement> find = (name) -> driver.findElement(By.name(name));

        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(400, TimeUnit.MILLISECONDS);

        WebElement searchBox = find.apply("q");
        WebElement searchButton = find.apply("btnK");

        searchBox.sendKeys("Selenium");
        searchButton.click();
        searchBox = find.apply("q");
        String value = searchBox.getAttribute("value");

        assertEquals("Selenium", value);
    }
}
