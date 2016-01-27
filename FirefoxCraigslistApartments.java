package automationFramework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class FirefoxCraigslistApartments {

	public static void main(String[] args) throws InterruptedException, IOException {
		// create file for writing
		File file = new File("C:\\Users\\Joe\\Desktop\\SearchResults.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream out = new PrintStream(fos);
		System.setOut(out);
		
		
		// set browser to Firefox and nav to url
		WebDriver driver = new FirefoxDriver();
		driver.get("http://seattle.craigslist.org");
		
		// nav to apartment listings
		driver.findElement(By.xpath(".//*[@id='hhh0']/li[1]/a/span")).click();
		
		// set up search filters
		
		// "posted today"
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[2]/ul[1]/li[3]/label/input"));
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[2]/ul[1]/li[3]/label/input")).click();
		System.out.println("Posted Today selected");
		Thread.sleep(1000);
		
		// "within distance"
		driver.findElement(By.xpath(".//*[@id='insideRange']"));
		driver.findElement(By.xpath(".//*[@id='insideRange']")).click();
		System.out.println("Within Distance selected");
		driver.findElement(By.xpath(".//*[@id='searchRange']/input[2]")).sendKeys("5");
		driver.findElement(By.xpath(".//*[@id='searchRange']/input[3]")).sendKeys("98121");
		System.out.println("Distance criteria added: 5 miles of zip code 98121");
		Thread.sleep(1000);
		
		// "price"
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[3]/input[1]"));
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[3]/input[1]")).sendKeys("1400");
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[3]/input[2]"));
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[3]/input[2]")).sendKeys("1700");
		System.out.println("Price filters added: $1400 min, $1700 max.");
		Thread.sleep(1000);
		
		// "bedrooms"
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[4]/select[1]"));
		Select droplist = new Select(driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[4]/select[1]")));
		droplist.selectByVisibleText("1+ bedrooms");
		System.out.println("Bedroom filter added: 1+ bedrooms");
		Thread.sleep(1000);
		
		// "bathrooms"
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[4]/select[2]"));
		Select droplist2 = new Select(driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[4]/select[2]")));
		droplist2.selectByVisibleText("1+ bathrooms");
		System.out.println("Bathroom filter added: 1+ bathrooms");
		Thread.sleep(1000);
		
		// square footage
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[5]/input[1]"));
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[5]/input[1]")).sendKeys("625");
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[5]/input[2]"));
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[5]/input[2]")).sendKeys("700");
		System.out.println("Square footage filter added: 625 min, 700 max");
		Thread.sleep(1000);
		
		// pets
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[6]/label[1]/input"));
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[6]/label[1]/input")).click();
		System.out.println("Pet filter added: cats");
		Thread.sleep(1000);
		
		// housing type selection
		driver.findElement(By.xpath(".//*[@id='headerattr_housing_type']"));
		driver.findElement(By.xpath(".//*[@id='headerattr_housing_type']")).click();
		driver.findElement(By.xpath(".//*[@id='apartment_1']"));
		driver.findElement(By.xpath(".//*[@id='apartment_1']")).click();
		driver.findElement(By.xpath(".//*[@id='house_6']"));
		driver.findElement(By.xpath(".//*[@id='house_6']")).click();
		System.out.println("Housing type filter added: apartment, house");
		Thread.sleep(1000);
		
		// laundry
		driver.findElement(By.xpath(".//*[@id='headerattr_laundry']"));
		driver.findElement(By.xpath(".//*[@id='headerattr_laundry']")).click();
		driver.findElement(By.xpath(".//*[@id='w/d_in_unit_1']"));
		driver.findElement(By.xpath(".//*[@id='w/d_in_unit_1']")).click();
		System.out.println("Laundry filter added: washer/dryer in unit");
		Thread.sleep(1000);
		
		// parking
		driver.findElement(By.xpath(".//*[@id='headerattr_parking']"));
		driver.findElement(By.xpath(".//*[@id='headerattr_parking']")).click();
		driver.findElement(By.xpath(".//*[@id='carport_1']"));
		driver.findElement(By.xpath(".//*[@id='carport_1']")).click();
		driver.findElement(By.xpath(".//*[@id='attached_garage_2']"));
		driver.findElement(By.xpath(".//*[@id='attached_garage_2']")).click();
		driver.findElement(By.xpath(".//*[@id='detached_garage_3']"));
		driver.findElement(By.xpath(".//*[@id='detached_garage_3']")).click();
		driver.findElement(By.xpath(".//*[@id='off-street_parking_4']"));
		driver.findElement(By.xpath(".//*[@id='off-street_parking_4']")).click();
		System.out.println("Parking filters added: carport, attached garage, detached garage, off-street");
		Thread.sleep(1000);
		
		// execute search
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[9]/button"));
		driver.findElement(By.xpath(".//*[@id='searchform']/div[1]/div[4]/div[9]/button")).click();
		System.out.println("Executing search...");
		Thread.sleep(1000);
		
		
		
		// Get the list of links from search results and write to a file
		List <WebElement> totalLinks = driver.findElements(By.tagName("a"));
		for (WebElement url : totalLinks) {
			// filter valid links
			if ((url.getAttribute("href").trim().length() != 0) && (url.getText().trim().length() !=0)) {
				// print page links
				System.out.println(url.getText().trim() + " --> " + url.getAttribute("href").trim());
				
			}
		}		
	}
}


