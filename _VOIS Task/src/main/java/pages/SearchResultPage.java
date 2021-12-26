package pages;

import helpers.GUIActions;
import helpers.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class is used to implement Google search result Page and all of its used elements and All possible actions on it.
 */

public class SearchResultPage {
    private final WebDriver driver;
    private final GUIActions guiActions;
    private final By nextButton = By.xpath("//span[contains(text(),'Next')]");
    private final By bottomPageBar = By.id("fbarcnt");
    private final By searchResult =  By.cssSelector(".g");
    private List<Integer> resultList = new ArrayList<>();



    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);
    }

    /**
     * This Function is used to Scroll to Selected Element and Click on it.
     * with guiActions which are implemented before on GuiActions Class.
     */
    public void ScrollAndClickNext()  {
         //guiActions.scrollToElement(bottomPageBar);
         guiActions.clickOn(nextButton);
    }

    /**
     * This Function is used to return search List Size for the list which has all elements that have the passed locator.
     */
    public int searchListSize(){
        var ListSize = guiActions.getListSize(searchResult);
        System.out.println("#####################################################");
        System.out.println(ListSize);
        return ListSize;

    }


    /**
     * This Function is used to store search list size for Each round "Number of Clicking on Next Button = number of rounds " on one list.
     */
    public List<Integer> setSearchListSizeForEachRecords(){

        var NumberOfClickNext = Integer.parseInt(new PropertiesReader("test-data")
                .getProperty("NumberOfClickNext"));

        for(int i = 0; i < NumberOfClickNext; i++)
        {
            ScrollAndClickNext();
            resultList.add(searchListSize());
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(resultList);

        return resultList;
    }

    /**
     * This Function is used to compare between /(Validate on) List Sizes for all rounds (Number of Clicking Next)
     * then return true if all have the same size.
     */
    public boolean pagesResultIsEqual(){

        setSearchListSizeForEachRecords();
        for (Integer r : resultList) {
         if (!Objects.equals(resultList.get(0), r))
             return false;
        }
        return true;
    }

}
