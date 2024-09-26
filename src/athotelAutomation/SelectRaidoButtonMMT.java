package athotelAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectRaidoButtonMMT {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String FromLocationName = "Dubai";
		String FromDestinationName = "Dubai Al Maktoum";
		String ToLocationName = "Mumbai";
		String ToDestinationName = "Mumbai";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.makemytrip.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("span[class='commonModal__close']")).click();
		driver.findElement(By.cssSelector("li[data-cy='roundTrip']")).click();

	}

}
