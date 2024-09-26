package athotelAutomation;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Athotelobjects.athotelmain;
import dev.failsafe.internal.util.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
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

public class Signup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String Trips = "My Trips";
		String Email = "Sagar.raipurkar@techspian.com";
		String singupin = "Sign in";
		WebDriverManager.chromedriver().browserVersion("129.0.6668.59").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// TODO Auto-generated method stub
		driver.get("https://athotel.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		WebElement signin = driver.findElement(By.cssSelector("button[data-testid='sign-in-link']"));
		signin.click();
		driver.findElement(By.cssSelector("input[placeholder='Enter your email']")).sendKeys(Email);
		driver.findElement(By.cssSelector("button[data-testid='auth-modal-login-button']")).click();
		WebElement otp_input1 = driver.findElement(By.cssSelector("input[aria-label='OTP character 1']"));
		System.out.println("Enter the OTP Number");
		Scanner scanner = new Scanner(System.in);
		String OTP = scanner.next();
		otp_input1.click();
		otp_input1.sendKeys(OTP);
		driver.findElement(By.cssSelector("button[data-testid='auth-modal-verify-button']")).click();
		driver.findElement(By.cssSelector("button[data-testid='user-nav-menu']")).click();
		WebElement Trip = driver.findElement(By.cssSelector("div[data-key='my-trips']"));
		System.out.println(Trip.getText());
		String username = Trip.getText();
		System.out.println(username);
		System.out.println(username.contentEquals(Trips));
		driver.findElement(By.cssSelector("div[data-testid='user-account-logout']")).click();
		driver.close();
		driver.quit();
		}
}