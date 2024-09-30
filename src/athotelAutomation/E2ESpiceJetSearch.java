package athotelAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2ESpiceJetSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String EnteredCity = "Dubai";
		String SelectCity = "Dubai, Al Maktoum International";
		String ToEnteredCity = "Mumbai";
		String ToSelectedCity = "Mumbai";
		String UserCurrency = "HKD";
		String Roomcount = "2";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.spicejet.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		System.out.println(driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']"))
				.getAttribute("style"));
//		driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")).click();
		System.out.println(driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']"))
				.getAttribute("style"));
		if (!driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']"))
				.getAttribute("style").contains("238")) {
			System.out.println("It is enabled");
		} else {
			System.out.println("It not enabled");
		}

		driver.findElement(By.cssSelector("div[data-testid='to-testID-origin']")).click();
		driver.findElement(By.cssSelector("input[class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']"))
				.sendKeys(EnteredCity);
		List<WebElement> FromList = driver.findElements(By.cssSelector("div[class='css-1dbjc4n r-19yat4t r-1rt2jqs']"));
		for (int i = 0; i < FromList.size(); i++) {
			String List = FromList.get(i).getText();

			if (List.contains(SelectCity)) {
				FromList.get(i).click();
			}
		}

		driver.findElement(By.cssSelector("div[data-testid='to-testID-destination']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(
				"div[data-testid='to-testID-destination'] input[class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']"))
				.sendKeys(ToEnteredCity);
		List<WebElement> ToList = driver.findElements(By.cssSelector("div[class='css-1dbjc4n r-19yat4t r-1rt2jqs']"));
		for (int i = 0; i < ToList.size(); i++) {
			String List1 = ToList.get(i).getText();

			if (List1.contains(ToSelectedCity)) {
				ToList.get(i).click();
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(
				"div[class='css-1dbjc4n r-1awozwy r-19m6qjp r-156aje7 r-y47klf r-1phboty r-1d6rzhh r-1pi2tsx r-1777fci r-13qz1uu']"))
				.click();
//		driver.findElement(By.xpath(
//				"//div[@class='css-1dbjc4n r-150rngu r-18u37iz r-16y2uox r-1wbh5a2 r-lltvgl r-buy8e9 r-1sncvnh']//div[2]//div[1]//div[3]//div[2]//div[3]//div[1]//div[1]"))
//				.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[data-testid='home-page-travellers']")).click();
		WebElement AdultCount = driver.findElement(By.cssSelector(
				"div[class='css-1dbjc4n r-1awozwy r-18u37iz'] div[data-testid='Adult-testID-plus-one-cta']"));

		int i1 = 1;
		while (i1 < 5) {
			AdultCount.click();
			i1++;
		}

		driver.findElement(By.cssSelector("div[data-testid='home-page-travellers-done-cta']")).click();
		Thread.sleep(2000);
		driver.findElement(By
				.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[5]/div[2]/div[1]/div[2]/div[1]"))
				.click();
		List<WebElement> Currency = driver.findElements(By.cssSelector("div[class='css-76zvg2 r-homxoj r-ubezar']"));

		for (int i = 0; i < Currency.size(); i++) {
			String SelectCurrency = Currency.get(i).getText();
//			System.out.println(SelectCurrency);
			if (SelectCurrency.contains(UserCurrency)) {
				Currency.get(i).click();
				break;
			}
		}
		driver.findElement(By.cssSelector("div[data-testid='home-page-flight-cta']")).click();
	}
}
