package TacToc.TacToctest;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.AssertJUnit;
import org.openqa.selenium.interactions.Action;

import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AppTest {
	
	private WebElement element;
	private WebDriver driver;
	private String url = "http://10.0.1.86/tatoc/basic/grid/gate";
	private Tactocs handler = new Tactocs();

	@BeforeTest
	public void setup() {

		driver = handler.createInstance();

	}
	
	@Test
	public void level1() {
		
		element = driver.findElement(By.className("greenbox"));
		element.click();
		
	}
	
	@Test
	public void level2() throws Exception {

	    driver.switchTo().parentFrame();

		
		driver.switchTo().frame(0);
		
		WebElement elementFrame10 = driver.findElement(By.id("answer"));
		WebElement elementFrame11=driver.findElement(By.linkText("Repaint Box 2"));
		
		String color1 = elementFrame10.getAttribute("class");
		driver.switchTo().frame(0);
		String color2=driver.findElement(By.id("answer")).getAttribute("class");
		System.out.println(elementFrame11);

		while(!color1.equalsIgnoreCase(color2)) {
		    driver.switchTo().parentFrame();
		    elementFrame11=driver.findElement(By.linkText("Repaint Box 2"));
			elementFrame11.click();
			driver.switchTo().frame(0);
			color2=driver.findElement(By.id("answer")).getAttribute("class");
		}
		
	    driver.switchTo().parentFrame();
		driver.findElement(By.linkText("Proceed")).click();
		Assert.assertEquals(color2, color1);
	}
	
	
	@Test
	public void level3() {
		
		WebElement From = driver.findElement(By.id("dragbox"));
		WebElement To = driver.findElement(By.id("dropbox"));
		
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(From).moveToElement(To).release(To).build();
		dragAndDrop.perform();
		driver.findElement(By.linkText("Proceed")).click();
		
		
		
	}
	
	@Test
	public void level4 () {
		
		driver.findElement(By.linkText("Launch Popup Window")).click();
		List <String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.id("name")).sendKeys("Tanuj");
		driver.findElement(By.id("submit")).click();

		driver.switchTo().window(tabs.get(0));
		driver.findElement(By.linkText("Proceed")).click();
		
	}
	
	@Test
	public void level5() throws Exception {
		WebElement element = driver.findElement(By.linkText("Generate Token"));
		element.click();
		String token = driver.findElement(By.id("token")).getText();
		String[] cookie = token.split(": ");
		
		Cookie name = new Cookie("Token", cookie[1]);
		driver.manage().addCookie(name);
		driver.findElement(By.linkText("Proceed")).click();
		
		Thread.sleep(1000);

		
	}
	
	
	@AfterTest
	public void CloseInstance() {

		handler.CloseInstance(driver);
	}
	
	
}