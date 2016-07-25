package registration;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;




public class WebParser implements Runnable {

	
	WebDriver driver;
	LinkedBlockingQueue<User> userFIFO;
	boolean running = true;
	
	private static final int[] jobs = {0,39,56,72,88,117,136,177,206,211,295};
	
    // Ekonomi/juridik = 0
    // Försäljning = 39
    // Hotell/resturang/turism = 56
    // Industri/tillverkning = 72
    // IT = 88
    // Kontor/administration = 117
    // Lager/logistik = 136
    // Marknadsföring/information = 177
    // Pedagogik = 206
    // Teknik = 211
    // Telefoni/kundtjänst = 295
	
	private static final int[] locations = {0,9,18,21,27,33,35,45,53,57,70,71,93,107,117,120,125,133,144,150,157,183,193};

    // Blekinge län = 0
    // Dalarnas län = 9
    // Gotlands län = 18
    // Gävleborgs län = 21
    // Hallands län = 27
    // Jämtlands län = 33
    // Jönköpings län = 35
    // Kalmar län = 45
    // Kronobergs län = 53
    // Norrbottens län = 57
    // Ospecificerad arbetsort = 70
    // Skåne län = 71
    // Stockholms län = 93
    // Södermanlands län = 107
    // Uppsala län = 117
    // Utomlands = 120
    // Värmlands län = 125
    // Västerbottens län = 133
    // Västernorrlands län = 144
    // Västmanlands län = 150
    // Västra Gätalands län = 157
    // Örebro län = 183
    // Östergötlands län = 193

    //new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("t1")));

	
	public WebParser(LinkedBlockingQueue<User> userFIFO)
	{
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		this.driver = new FirefoxDriver();
		this.userFIFO = userFIFO;
		
        driver.get("https://www.academicwork.se/login");
		//driver.findElement(By.xpath("//div[@id='cookie-message-content']/div[2]/button")).click();  //Finding cookie-info banner


	}
	
	public void terminate()
	{
		running = false;
		driver.quit();
	}
		
	public void login(User user)
	{
        driver.get("https://www.academicwork.se/login");

        WebElement emailField = driver.findElement(By.id("LoginViewModel_LoginName"));
        WebElement passwordField = driver.findElement(By.id("LoginViewModel_Password")); 
        
        emailField.sendKeys(user.email);
        passwordField.sendKeys(user.password);
        emailField.submit();
        
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("my-profile"));
        
        
	}
	
	
	public void edit (User user)
	{

		driver.get("https://www.academicwork.se/my-profile");

        WebElement partTime = driver.findElement(By.id("t1"));
        WebElement fullTime = driver.findElement(By.id("t2"));
        WebElement consultant = driver.findElement(By.id("t3"));
        WebElement recruitment = driver.findElement(By.id("t4"));        
        
        WebElement jobOptionList = driver.findElement(By.xpath("//form[@id='create-subscription-form']/fieldset/div[3]/div[1]/div[2]/ul"));
        List<WebElement> allJobOptions = jobOptionList.findElements(By.className("filter"));
        
        if(!user.jobOptions[0])
        {
        	partTime.click();
        }
        if(!user.jobOptions[1])
        {
        	fullTime.click();
        }
        if(!user.jobOptions[2])
        {
        	consultant.click();
        }
        if(!user.jobOptions[3])
        {
        	recruitment.click();
        }
        
        
        int i = 0;
        for (boolean j : user.jobs)
        {
        	if (j)
        	{
        		allJobOptions.get(jobs[i]).click();
        	}
        	i++;
        }
        
        WebElement locationOptionList = driver.findElement(By.xpath("//form[@id='create-subscription-form']/fieldset/div[4]/div[1]/div[2]/ul"));
        List<WebElement> allLocationOptions = locationOptionList.findElements(By.className("filter"));
        
        i = 0;
        for (boolean j : user.locations)
        {
        	if (j)
        	{
        		allLocationOptions.get(locations[i]).click();
        	}
        	i++;
        }
        partTime.submit();        
        user.isDone = true;
	}
	
	
	public void edit2(User user)
	{
		driver.get("https://www.academicwork.se/my-profile/cv");
		
		driver.findElement(By.xpath("//div[@id='cv-educations']/header/nav/a")).click(); //"Lägg till" button for Utbildning
		WebElement schoolField = driver.findElement(By.id("School"));
		WebElement educationField = driver.findElement(By.id("Subject"));
		Select startYearField = new Select(driver.findElement(By.name("StartYear")));
		Select startMonthField = new Select(driver.findElement(By.name("StartMonth")));
		Select endYearField = new Select(driver.findElement(By.name("EndYear")));
		Select endMonthField = new Select(driver.findElement(By.name("EndMonth")));

		schoolField.sendKeys(user.school);
		educationField.sendKeys(user.education);
		startYearField.selectByValue(user.startYear);
		startMonthField.selectByValue(user.startMonth);
		endYearField.selectByValue(user.endYear);
		endMonthField.selectByValue(user.endMonth);
		schoolField.submit();

	}
	
	
	public void register(User user)
	{
        driver.get("https://www.academicwork.se/register");
        
        WebElement emailField = driver.findElement(By.id("registration-form-email"));
        WebElement passwordField = driver.findElement(By.id("registration-form-password"));
        WebElement firstNameField = driver.findElement(By.id("registration-form-firstname"));
        WebElement lastNameField = driver.findElement(By.id("registration-form-lastname"));
        WebElement phoneNumberField = driver.findElement(By.id("MobileNo"));
        WebElement PUL = driver.findElement(By.id("HasAgreedToPUL"));
        
        emailField.sendKeys(user.email);
        passwordField.sendKeys(user.password);
        firstNameField.sendKeys(user.firstName);
        lastNameField.sendKeys(user.lastName);
        phoneNumberField.sendKeys(user.phoneNumber);
        PUL.click();
        PUL.submit();
        
        new WebDriverWait(driver, 4).until(ExpectedConditions.urlContains("my-profile"));
        
        user.isCreated = true;
	}
	
	public void logout()
	{
		driver.findElement(By.xpath("//a[contains(@href,'/my-profile')]")).click();
		driver.findElement(By.id("lock-logout")).click();
		driver.findElement(By.xpath("//div[@id='logoutModal']/div/div[2]/a")).click();
	}

	@Override
	public void run() 
	{
		while (running)
		{
			try 
			{
				User user = userFIFO.take();
				try
				{
					register(user);
					user.isCreated = true;
					user.message = "Användaren skapades";
					user.significantChange();
					edit(user);
					edit2(user);
					logout();
					user.isDone = true;
					user.message = "Användaren är klar!";
					user.significantChange();
				}
				catch (TimeoutException q)
				{
					user.isAlive = false;
					user.message = "Registrering misslyckades";
					user.significantChange();
				}
				
	
			} 
			catch (InterruptedException e) 
			{
				terminate();
			}
		}
	}	
}
