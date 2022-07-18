package com.cts.automation.mavenproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMaven1 {
	public static void main(String[] args) throws InterruptedException, IOException {
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\Maven1\\Driver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://www.Amazon.in/");
		
		driver.findElement(By.xpath(" //input [@ id='twotabsearchtextbox']")).sendKeys("Rolex");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//img[@ alt='Rolex GMT-Master 16750 Watch Review']")).click();
	 
		Set<String> allTabs1 = driver.getWindowHandles();
		List<String> allTabsLi1 = new ArrayList<String>(allTabs1);
		driver.switchTo().window(allTabsLi1.get(1));
   
	    WebElement txtPriceValue =driver.findElement(By.xpath("//span [@id='kindle-price']"));
	    System.out.println(txtPriceValue.getText());
	    
	   TakesScreenshot ts =(TakesScreenshot) driver;
	    File source =ts.getScreenshotAs(OutputType.FILE);
	    File destination =new File("C:\\Users\\Dell\\eclipse-workspace\\Maven1\\src\\test\\resources\\Screenshot\\Amazon.jpeg");
	    Thread.sleep(2000);
	    FileUtils.copyFile(source,destination);		
	}
}
