package base;

import helpers.PropertiesReader;
import helpers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    /**
    * used to generate an object "driver" from getdriver function, before the starting of each class
    */
    @BeforeClass
    public void beforeClassSetUp() {
        driver = WebDriverFactory.getDriver();
        }

    /**
     * used to read the Base-url from properties file then get (open) it, before the starting of each method
     */
    @BeforeMethod
    public void beforeMethodSetUp() {
        driver = WebDriverFactory.getDriver();
        var url = new PropertiesReader("test-configurations")
                .getProperty("base-url");
        driver.get(url);
        driver.manage().window().maximize();
    }

    /**
     * used to close the browser, after complete each method
     */
    @AfterMethod
    public void afterMethodSetUp() {driver.quit();}

    @AfterClass
    public void afterClassSetUp() {}


}
