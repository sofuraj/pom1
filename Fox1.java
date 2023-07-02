package pom;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Fox1 {

    public static void main(String[] args) throws IOException{
    	
    	String [] fn= {"sweety","sofy","rosey","dolly","rocky"};
    	String [] ln= {"sweet","sof","rose","doll","rock"};
    	String [] eid= {"sweety@gmail.com","sofy@gmail.com","rosey@gmail.com","dolly@gmail.com","rocky@gmail.com"};
    	String [] tn= {"45678978","198376452","1234567845","78563445674","567856345645"};
String title="Register Account";
    	
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        
        
        //window maximization and adding implicit value
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       //using action to perform actions
    	Actions action=new Actions(driver);
    	
    	//to take screen shot
    	TakesScreenshot ts = (TakesScreenshot)driver;

    	
        // Navigate to the given url
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

       
        
        
        // Find the input fields and test
        
        for(int i=0;i<5;i++)
        {
        
        	 //click the register link
            driver.findElement(By.id("Register")).click();
            
        	driver.findElement(By.id("input-firstname")).sendKeys(fn[i]);

        	driver.findElement(By.id("input-lastname")).sendKeys(ln[i]);

        	driver.findElement(By.id("input-email")).sendKeys(eid[i]);

        	driver.findElement(By.id("input-telephone")).sendKeys(tn[i]);


            driver.findElement(By.id("input-password")).sendKeys(tn[i]);


           driver.findElement(By.id("input-confirm")).sendKeys(tn[i]);

           if(i%2==0)
        	{
        WebElement radiono=driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input"));
        	action.click(radiono).perform();

        	}
        	else
        	{
        WebElement radioyes=driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input"));
        	action.click(radioyes).perform();

        	}
        	
       WebElement checkbox= driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        action.click(checkbox).perform();

         // Click the signup button
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();

        
        if(title.contentEquals(title))
        {
        	System.out.println("signup failed for "+(i+1)+"details given");
        	 
        	File destination = new File ("./errorshot/image1.png");
    		
    		File webpageScreenshot = ts.getScreenshotAs(OutputType.FILE);
    		
    		FileHandler.copy(webpageScreenshot, destination);

              	
        }
        else
        {
        	System.out.println("signup pass for "+(i+1)+"details given");
        	
        	driver.findElement(By.linkText("Logout")).click();
        }
        
        }
           

        // Close the browser
        driver.quit();
    }
}