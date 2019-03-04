package TacToc.TacToctest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tactocs {

	private String url = "http://10.0.1.86/tatoc/basic/grid/gate";

	// Create browser instance
	public WebDriver createInstance() {

		System.setProperty("webdriver.chrome.driver",
				"/home/qainfotech/Eclipse Workspace New Data And Version/testng/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get(url);

		return driver;

	}
	
	/*
	 * public void GetTargetElement(WebDriver driver) { WebElement element =
	 * driver.findElement(By.className("greenbox")); element.click();
	 * 
	 * }
	 */

	//Close Instance
	public void CloseInstance(WebDriver driver) {
//		driver.quit();
		driver.close();

	}

}