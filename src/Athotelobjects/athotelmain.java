package Athotelobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class athotelmain {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebElement Searchbox= null;

	}
	public static WebElement Searchinputbox (WebDriver driver) throws InterruptedException {
		WebElement Searchbox = driver.findElement(By.cssSelector("input[placeholder='Where are you going?']"));
		return Searchbox;
	}
	
	public static void browserlauch() {
		WebDriverManager.chromedriver().browserVersion("129.0.6668.59").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// TODO Auto-generated method stub
		driver.get("https://athotel.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

}
