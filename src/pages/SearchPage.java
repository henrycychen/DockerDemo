package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage{
	
	//Constructor
	public SearchPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		System.out.println("SearchPage class initialized");
	}
	
	//Page Variables
	String baseURL = "";
	
	//Web Elements
	public String searchResultText = "#docker-search .container h2";
	public String searchResultInvalidText = ".container > h2";
	public String searchAdvanced = "a[class=fieldset-title]";
	public String searchAdvancedDropDown = "#search-form fieldset";
	public String searchAdvancedDropDownUncollapsed = "search-advanced collapsible form-wrapper collapse-processed";
	public String searchUsedText = "#edit-keys";
	public String searchResults = "#search-totals";
	public String searchValidResults = "li:nth-child(1) .title a";
	public String searchInvalidResults = "#results h2";
	
	//Page Methods
	
	//Verify "Search results" text appears after search is executed
	public void verifySearchResultText() {
		String expectedText = "Search results";
		assertEquals(getText(searchResultText), expectedText);
	}
	
	//Verify "Search results" text appears after search is executed for invalid searches
	public void verifySearchResultInvalidText() {
		String expectedText = "Search results";
		assertEquals(getText(searchResultInvalidText), expectedText);
	}
	
	//Verify Advanced search can drop down after clicking
	public void verifyAdvancedSearch() {
		click(searchAdvanced);
		assertEquals(getAttribute(searchAdvancedDropDown, "class"), searchAdvancedDropDownUncollapsed);
	}
	
	//Verify text used to search appears in the #edit-keys text box
	public void verifySearchUsedText(String searchString) {
		assertEquals(getAttribute(searchUsedText, "value"), searchString);
	}
	
	//Verify a valid search does not have empty results
	public void validSearchResult() {
		assertNotEquals("", getText(searchValidResults));
	}
	
	//Verify a invalid search results returns text stating no results yielded
	public void invalidSearchResult() {
		String invalidResultsText = "Your search yielded no results";
		assertEquals(getText(searchInvalidResults), invalidResultsText);
	}

}
