import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class signupMMT {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String Password = "Sagar@91";
		String CPassword = "Sagar@91";
		String regex = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$\"";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.spicejet.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("div[class='css-1dbjc4n r-1jkjb'] a[rel='noopener noreferrer']")).click();
		Thread.sleep(3000);
		Set<String> Windowhandle = driver.getWindowHandles();
		System.out.println(Windowhandle);

		Iterator<String> iterator = Windowhandle.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();

		driver.switchTo().window(childwindow);
		System.out.println("New window");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[class='col-sm-4 mt-2 px-sm-4']")).click();
		WebElement titledropdown = driver
				.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/select"));
		Select title = new Select(titledropdown);
		title.selectByVisibleText("Mr");
		driver.findElement(By.id("first_name")).sendKeys("John");
		driver.findElement(By.id("last_name")).sendKeys("Deo");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[1]/select"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[1]/select"))
				.sendKeys("Barbados");
//		List<WebElement> CountryList = driver.findElements(
//				By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[1]/select"));
//
//		for (int i = 0; i < CountryList.size(); i++) {
//			String list = CountryList.get(i).getText();
//			System.out.println(list);
//			
//			if(CountryList.contains("Barbados")) {
//				CountryList.get(i).click();
//				break;
//			}
//		}

		driver.findElement(By.cssSelector("div[class='react-datepicker-wrapper']")).click();
		driver.findElement(By.className("react-datepicker__year-select")).click();
		WebElement birth = driver.findElement(By.className("react-datepicker__year-select"));
		Select birthyear = new Select(birth);
		birthyear.selectByValue("1992");

		driver.findElement(By.className("react-datepicker__month-select")).click();
		WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
		Select birthmonth = new Select(month);
		birthmonth.selectByValue("10");

		driver.findElement(By.cssSelector("div[class='react-datepicker__day react-datepicker__day--002']")).click();
		driver.findElement(By.cssSelector("input[placeholder='+91 01234 56789']")).sendKeys("8871488970");
//		driver.findElement(By.cssSelector("input[id='email_id']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='email_id']")).sendKeys("sagar@mailinator.com");
////		
//		List<WebElement> CountryList = driver.findElements(By.cssSelector("li[class='country']"));
//		for (int i = 0; i < CountryList.size(); i++) {
//			String list = CountryList.get(i).getText();
//			System.out.println(list);
//
////			if(CountryList.contains("Barbados")) {
////				CountryList.get(i).click();
////				break;
////////			}
		driver.findElement(By.id("new-password")).sendKeys(Password);
//		if (Password.matches(regex)) {
//			System.out.println("Password matched");
//		} else {
//			System.out.println(
//					"Password length should be min 8 & max 16 with at least 1 uppercase, 1 lowercase, a numeric value & a special character.\r\n"
//							+ "");
//		}
		driver.findElement(By.id("c-password")).sendKeys(CPassword);

		if (Password.equals(CPassword)) {
			System.out.println("Password mactched");
		} else {
			System.out.println(driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[5]/div[1]/div[3]/div[1]/div[1]"))
					.getText());
		}
//		WebElement Checkbox = driver.findElement(By.cssSelector("label[class='form-check-label font-14']"));
//				Checkbox.click();
		driver.quit();
	}
}
