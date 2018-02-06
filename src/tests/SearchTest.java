package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SearchPage;


class SearchTest extends BaseTest{

	@Test
	void validSearchResult() throws InterruptedException {
		//Page instantiations
		HomePage homepage = new HomePage(driver, wait);
		SearchPage searchpage = new SearchPage(driver, wait);
		//Test Variables
		String searchString = "Hello World";
		//Page Methods
		homepage.goToHomePage();
		homepage.click(homepage.navBarSearch);
		homepage.fillFields(homepage.navBarSearchTextField, searchString);
		searchpage.verifySearchResultText();
		searchpage.verifyAdvancedSearch();
		searchpage.verifySearchUsedText(searchString);
		searchpage.validSearchResult();
	}
	
	@Test
	void invalidSearchResult() throws InterruptedException {
		//Page instantiations
		HomePage homepage = new HomePage(driver, wait);
		SearchPage searchpage = new SearchPage(driver, wait);
		//Test Variables
		String searchString = "dafdsfdasjfkldas";
		//Page Methods
		homepage.goToHomePage();
		homepage.click(homepage.navBarSearch);
		homepage.fillFields(homepage.navBarSearchTextField, searchString);
		searchpage.verifySearchResultInvalidText();
		searchpage.verifyAdvancedSearch();
		searchpage.verifySearchUsedText(searchString);
		searchpage.invalidSearchResult();
	}
}
