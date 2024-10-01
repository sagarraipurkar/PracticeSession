package athotelAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Athotelobjects.athotelmain;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Autosuggestion {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.cssSelector("input[data-cy='fromCity']")).click();

		WebElement FromSearhBox = driver.findElement(By.cssSelector("input[placeholder='From']"));
		FromSearhBox.sendKeys(FromLocationName);
		Thread.sleep(2000);
		List<WebElement> FromListofAutosuggestion = driver.findElements(By.className("react-autosuggest__suggestion"));
		for (int i = 0; i < FromListofAutosuggestion.size(); i++) {
			String text = FromListofAutosuggestion.get(i).getText();
			System.out.println(text);

			if (text.contains(FromDestinationName)) {
				FromListofAutosuggestion.get(i).click();
				System.out.println("From Desination Successfully Selected");
				System.out.println("From Desination Successfully Selected");
				break;
			}
		}
		driver.findElement(By.cssSelector("input[data-cy='toCity']")).click();
		WebElement ToSearchBox = driver.findElement(By.cssSelector("input[placeholder='To']"));
		ToSearchBox.sendKeys(ToLocationName);
		Thread.sleep(2000);
		List<WebElement> ToListofAutosuggestion = driver.findElements(By.className("react-autosuggest__suggestion"));
		for (int i1 = 0; i1 < ToListofAutosuggestion.size(); i1++) {
			String ToText = ToListofAutosuggestion.get(i1).getText();
			System.out.println(ToText);

			if (ToText.contains(ToDestinationName)) {
				ToListofAutosuggestion.get(i1).click();
				System.out.println("To Desination Successfully Selected");
				break;
			}
		}
//		driver.findElement(By.cssSelector("p[data-cy='departureDate']")).click();
		driver.findElement(By.cssSelector("div[aria-label='Mon Oct 07 2024']")).click();
		driver.findElement(By.cssSelector("p[data-cy='returnDefaultText']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[aria-label='Wed Oct 09 2024']")).click();
//		boolean Radiobutton = driver.findElement(By.cssSelector("li[data-cy='roundTrip']")).isSelected();
//		System.out.println(Radiobutton);
//		if (Radiobutton == true) {
//			System.out.println("RoundTrip Radio is Selected");
//		} else {
//			System.out.println("One trip is selected");
//		}
		driver.findElement(By.cssSelector("div[data-cy='flightTraveller']")).click();
		driver.findElement(By.cssSelector("li[data-cy='adults-3'")).click();
		driver.findElement(By.cssSelector("li[data-cy='children-2']")).click();
		driver.findElement(By.cssSelector("button[data-cy='travellerApplyBtn']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[contains(@class,'specialFareContainer relative makeFlex centerContainer')]//div[contains(@class,'')]//div[2]//div[2]//div[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
	}
}
