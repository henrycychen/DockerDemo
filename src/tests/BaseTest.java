package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * BaseTest class contains setup and tear down for each test case
 */

public class BaseTest {
	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeEach
	void setUp() throws Exception {
		//Create a Chrome driver. All tests and page classes will use this.
		driver = new ChromeDriver();
		
		//Create a wait. All tests and page classes will use this.
		wait = new WebDriverWait(driver, 15);
		
		//Maximize Window
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}
}
