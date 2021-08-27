import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Streams1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// 1.  CHeck the items in the list are sorted
		// Click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();		
		// Capture all Web elements in to list
		List<WebElement> webElements =driver.findElements(By.xpath("//tr/td[1]"));
		// Capture text of all web elements in to new Original list
		List<String> originalList =webElements.stream().map(s->s.getText()).collect(Collectors.toList());
		// Sort the Original list -- Sorted list
		List<String> sortedList	=originalList.stream().sorted().collect(Collectors.toList());
		// Compare Original list vs Sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		/*
		//2. Scan the name column with getText() ->Beans -> Print the price of the rice The item present in the 1st page
		List<String> price = webElements.stream().filter(s->s.getText().contains("Beans"))
			.map(s->getPriceVeggiee(s)).collect(Collectors.toList());	// We create a new customized method getPriceVeggiee
		price.forEach(a->System.out.println(a));
	}
	private static String getPriceVeggiee(WebElement s) 		// Need to pass webElement s in method
	{		
		// TODO Auto-generated method stub
		String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
*/
		
		// 3. If the item not present in the 1st page. There is pagination technique
		// For this we using Do While technique
		// Do while loop do and go. I.e, it will check and go
		// While loop is going iteration keep on
		List<Object> price;				// 
		do																		// checking first page
		{
			List<WebElement> rows =driver.findElements(By.xpath("//tr/td[1]"));	// checking 1st page web elements
			 price = rows.stream().filter(s->s.getText().contains("Rice"))
					.map(s->getPriceVeggiee(s)).collect(Collectors.toList());	// We create a new customized method getPriceVeggiee
			 price.forEach(a->System.out.println(a));							// printing price
			 if(price.size()<1)
			 {
				 driver.findElement(By.cssSelector("[aria-label='Next']")).click();	// clicking next button
			 }
		
		}while(price.size()<1);	// checking next page
	}
	private static Object getPriceVeggiee(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
}
