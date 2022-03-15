package com.selenium;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Medicare {

	WebDriver driver;

	@BeforeMethod
	public void begin() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// To Test Admin
	@Test(priority = '1')
	public void testMedicareAdmin() throws InterruptedException 
	{
		driver.get("http://localhost:4200/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// To check View Customers
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg'][3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='one']")).click();
		Thread.sleep(2000);

		// To check View Products
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg'][1]")).click();

	}

	// To Test User
	@Test(priority = '2')
	public void testMedicareUser() throws InterruptedException 
	{
		driver.get("http://localhost:4200/");
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Tariq123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/html/body/app-home/div/div/app-customerlogin/form/div/button"))
				.click();

		// To check View Products
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='two'][3]")).click();

		// To check Add to Cart
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("/html/body/app-root/html/body/app-customerproducts/div/form/table/tbody/tr[2]/td[5]/button"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='one']")).click();

		// To check My Cart
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='two']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/html/body/app-customercart/div/form/button")).click();

		// To check confirm order
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/html/body/app-payment/div/div/button[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='one']")).click();

	}

	@AfterMethod
	public void end() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
