package athotelAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Athotelobjects.athotelmain;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SkipSignin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://athotel.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		WebElement Searchbox = driver.findElement(By.cssSelector("input[placeholder='Where are you going?']"));
		WebElement Searchbox1 = athotelmain.Searchinputbox(driver);
		Searchbox1.click();
		Searchbox1.sendKeys("Dubai");
		Thread.sleep(2000);
		Searchbox1.sendKeys(Keys.ARROW_DOWN);
		Searchbox1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[data-testid='home-search-button']")).click();
		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("button[data-testid='modal-skip-button']")).click();

	}

}
