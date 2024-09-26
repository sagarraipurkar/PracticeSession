package athotelAutomation;

import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import Athotelobjects.athotelmain;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CallHomepage {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		browserLaunch();
		int i;
	}

	public static void browserLaunch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://athotel.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
///		WebElement Searchbox = driver.findElement(By.cssSelector("input[placeholder='Where are you going?']"));
		WebElement Searchbox = athotelmain.Searchinputbox(driver);
		Searchbox.click();
		Thread.sleep(2000);
		Searchbox.sendKeys("Dubai");
		Thread.sleep(2000);
		Searchbox.sendKeys(Keys.ARROW_DOWN);
		Searchbox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[data-testid='guests-search-button']")).click();
		for (int i = 0; i < 6; i++) {
			driver.findElement(By.cssSelector("button[data-testid= 'room-editor-room-row-adult-add']")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[data-testid='room-editor-submit-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[data-testid='home-search-button']")).click();
	}
}