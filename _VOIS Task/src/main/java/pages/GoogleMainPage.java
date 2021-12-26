package pages;

import helpers.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class is used to implement Google Main Page and all of its used elements and All possible actions on it.
 */
public class GoogleMainPage {

    private final WebDriver driver;
    private final GUIActions guiActions;
    private final By searchBar = By.xpath("//input[@title= 'Search']");

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);
    }

    /**
     * This function is used only to type on Google search Bar
     * By Clicking on Search Bar.
     * Then Send search Text to it.
     */
    public GoogleMainPage TypeOnGoogleBarSearch(String searchWord) {

        guiActions.clickOn(searchBar);
        guiActions.sendTextTo(searchBar, searchWord);
        return new GoogleMainPage(driver);
    }

    /**
     * This function is used to Confirm the search process by Clicking Enter.
     */
    public void ConfirmSearchProcess(String searchWord) {

        var googleMainPage = new GoogleMainPage(driver);
        googleMainPage.TypeOnGoogleBarSearch(searchWord);
        guiActions.clickEnter(searchBar);

    }
}
