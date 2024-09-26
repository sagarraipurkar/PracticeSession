package athotelAutomation;

import java.io.ObjectInputStream.GetField;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelAutoSuggestionMakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String EnteredCity = "Dubai";
		String SelectCity = "Dubai Marina & JBR, Area in Dubai,";
		String Roomcount = "2";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.makemytrip.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("span[class='commonModal__close']")).click();
		driver.findElement(By.cssSelector("a[href='https://www.makemytrip.com/hotels/']")).click();
		driver.findElement(By.id("city")).click();
		driver.findElement(By.cssSelector("input[placeholder='Where do you want to stay?']")).sendKeys(EnteredCity);
		Thread.sleep(2000);
		List<WebElement> CityList = driver
				.findElements(By.cssSelector("ul[class='react-autosuggest__suggestions-list']"));
		for (int i = 0; i < CityList.size(); i++) {
			String AutoSuggestionList = CityList.get(i).getText();
			System.out.println(AutoSuggestionList);

			if (AutoSuggestionList.contains(SelectCity)) {
				CityList.get(i).click();
				System.out.println("Hotel is selected");
				break;
			}
		}
		WebElement FromDate = driver.findElement(By.xpath("//div[@aria-label='Thu Oct 17 2024']"));
		FromDate.click();
		Thread.sleep(2000);
		WebElement ToDate = driver.findElement(By.xpath("//div[@aria-label='Tue Oct 22 2024']"));
		ToDate.click();
		driver.findElement(By.cssSelector("div[data-cy='GuestSelect$$_324']")).click();
		driver.findElement(By.xpath("//li[@data-cy='GuestSelect$$_323'][text()=03]")).click();
		List<WebElement> RoomCount = driver.findElements(By.cssSelector("li[data-testid= 'room_count']"));

		for (int i = 0; i < RoomCount.size(); i++) {
			String count = RoomCount.get(i).getText();

			if (count.contains(Roomcount)) {
				RoomCount.get(i).click();
				System.out.println("Room Count selected");
				break;

			}

		}
		driver.findElement(By.cssSelector("button[data-cy='RoomsGuestsNew_327']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("hsw_search_button")).click();
		driver.quit();
	}
}
