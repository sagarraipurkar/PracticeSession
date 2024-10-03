package athotelAutomation;

import java.sql.Time;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Athotelobjects.athotelmain;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CallHomepage {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		browserLaunch();
		int i;
	}

	public static void browserLaunch() throws InterruptedException {
		String Trips = "My Trips";
		String Email = "Sagar.raipurkar@techspian.com";
		String singupin = "Sign in";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://athotel.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
//		WebElement signin = driver.findElement(By.cssSelector("button[data-testid='sign-in-link']"));
//		signin.click();
//		driver.findElement(By.cssSelector("input[placeholder='Enter your email']")).sendKeys(Email);
//		driver.findElement(By.cssSelector("button[data-testid='auth-modal-login-button']")).click();
//		WebElement otp_input1 = driver.findElement(By.cssSelector("input[aria-label='OTP character 1']"));
//		System.out.println("Enter the OTP Number");
//		Scanner scanner = new Scanner(System.in);
//		String OTP = scanner.next();
//		otp_input1.click();
//		otp_input1.sendKeys(OTP);
//		driver.findElement(By.cssSelector("button[data-testid='auth-modal-verify-button']")).click();
		WebElement Searchbox = driver.findElement(By.cssSelector("input[placeholder='Where are you going?']"));

//		WebElement Searchbox = athotelmain.Searchinputbox(driver);
		Searchbox.click();
		Thread.sleep(2000);
		Searchbox.sendKeys("Dubai");
		Thread.sleep(2000);
		Searchbox.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		Searchbox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[data-testid='guests-search-button']")).click();
		for (int i = 2; i<3; i++) {
			driver.findElement(By.cssSelector("button[data-testid= 'room-editor-room-row-adult-add']")).click();
		}
		driver.findElement(By.cssSelector("button[data-testid='room-editor-submit-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[data-testid='home-search-button']")).click();
		Thread.sleep(3000);
		System.out.println();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
//			wait.until(ExpectedConditions
//					.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Sign in to get lower prices']")));
////			WebElement textVisible =driver.findElement(By.xpath("//div[text()='Sign in to get lower prices']"));
			driver.findElement(By.cssSelector("button[data-testid='modal-close-button']")).click();

		} catch (Exception e) {
			System.out.println("Element not found");
		}
		wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Breakfast available']")));
		List<WebElement> hotelName = driver.findElements(By.cssSelector("div[data-testid='hotel-card-name']"));

		for (int i = 0; i < hotelName.size(); i++) {
			String hotellist = hotelName.get(i).getText();
			System.out.println(hotellist);

			if (hotellist.contains("Sofitel Dubai The Obelisk")) {
				hotelName.get(i).click();
			}
		}
		Set<String> window = driver.getWindowHandles();
		Iterator<String> newwindow = window.iterator();
		String Parentwindow = newwindow.next();
		String Childwindow = newwindow.next();
		driver.switchTo().window(Childwindow);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		System.out.println(driver.findElement(By.xpath("//h2[text()='You are not seeing discounts']")).getText());
		try {
			driver.findElement(By.cssSelector("button[data-testid='signup-banner-dismiss']")).click();
		} catch (Exception e) {
			System.out.println("Element Not found");
		}
//		driver.findElement(By.xpath(
//				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[7]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/button[1]"))
//				.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[7]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/button[1]")))
				.click();
//		driver.findElement(By.cssSelector("button[data-testid='book-now-button']"))
	}
}
