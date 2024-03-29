package StepsDefination;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormSteps {
	WebDriver driver;
	
	@Given("the user will land on Protocommerce")
	public void the_user_will_land_on_protocommerce() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@When("the user enters all reqired fields \\(username: {string}, email: {string}, pass: {string} ,date: {string})")
	public void the_user_enters_all_reqired_fields(String name, String mail ,String password, String BDY ) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement status=driver.findElement(By.name("name"));
		System.out.println("Display status:"+ status.isDisplayed());
		System.out.println("Enabled status:"+status.isEnabled());  
		
		driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("email")).sendKeys(mail);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
		//isSelected
		WebElement checkbox_status=driver.findElement(By.xpath("//input[@type='checkbox']"));
		System.out.println("checkbox status:"+ checkbox_status.isSelected());  //false
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		System.out.println("checkbox status:"+ checkbox_status.isSelected());  //true
		
		// satic dropdown
		WebElement dropdown=driver.findElement(By.cssSelector("#exampleFormControlSelect1"));
		
		Select abc = new Select(dropdown);  //create an object and if select tag is present in html content

		abc.selectByVisibleText("Male");
		//driver.findElement(By.xpath("//*[text()='male']")).click();
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys(BDY);
	}

	@When("the user clicks on the summit button")
	public void the_user_clicks_on_the_summit_button() {
		driver.findElement(By.className("btn-success")).click();


	}

	@Then("the user should see a Success message")
	public void the_user_should_see_a_success_message() {
		System.out.println(driver.findElement(By.className("alert-success")).getText());

	}

}
