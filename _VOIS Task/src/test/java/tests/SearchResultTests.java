package tests;

import base.BaseTests;
import helpers.PropertiesReader;
import helpers.TestngListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import pages.SearchResultPage;

@Listeners(TestngListener.class)
public class SearchResultTests extends BaseTests {
    /**
     * This Method is used to implement Test Scenario which is needed.
     * We take an instance from Google Main Page and search Result Page to has the accessibility to use all of its functions to go through the test scenario
     * from Google main page we used ConfirmSearch process which is used to do the search "from send the text to click enter"
     * then from search Result Page we start to scroll to next and click on it then store search list size till the last round then validate the lists size.
     * Finally we do the Assertion, as the PageResultIsEqual function return boolean, so we validate on it.
     */
    @Test
    public void GoogleSearch() {

        var SearchText =  new PropertiesReader("test-data")
                .getProperty("SearchText");

        var googleMainPage  = new GoogleMainPage(getDriver());
        googleMainPage.ConfirmSearchProcess(SearchText);

        var searchResultPage = new SearchResultPage(getDriver());
        boolean ActualResult = searchResultPage.pagesResultIsEqual();

        Assert.assertTrue(ActualResult);

    }



}
