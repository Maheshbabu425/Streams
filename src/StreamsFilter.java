import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamsFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Almond");
		List<WebElement> veggies =	driver.findElements(By.xpath("//tr/td[1]"));
		
	List<WebElement> filteredList =	veggies.stream().filter(s->s.getText().contains("Almond"))
	.collect(Collectors.toList());
	
	Assert.assertEquals(veggies.size(), filteredList.size());
	}

}
