package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class GUIActions {
    private final WebDriver driver;
    private final WebDriverWait wait;


    public GUIActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 100);
    }

    /**
     * This function is used to do the clickOn action on any selected element
     * by passing the target element to it and wait till this element is presence and clickable
     * then do the click action
     */
    public void clickOn(By by)  {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * This function is used to do the Click Enter action "KeyBoards Actions" at any time you need.
     * by passing any element we need to it and wait till this element is clickable
     * then do the enter action
     */

    public void  clickEnter(By by)  {
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(Keys.ENTER);
    }

    /**
     * This function is used to send data to element "Type on selected Element"
     * by passing the target element to it and wait till this element is presence and clickable
     * then Clear it as it might has cached data, then send (Type) the text on this element
     */
    public void sendTextTo(By by, String text) {
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    /**
     * This function is used to perform the Scrolling Action to Selected element or "position" on the UI with JavaScript Execution
     */
    public void scrollToElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor JS =((JavascriptExecutor)driver);
        JS.executeScript("arguments[0].scrollIntoView(true)",by);

    }
    /**
     * This function is used to confine any List Of element when need to interact with it or with any index on it.
     */
    public int getListSize(By by) {
        List<WebElement> list = driver.findElements(by);
        return list.size();
    }
}

