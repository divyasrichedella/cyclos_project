package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class adv {
	public WebDriver driver;
  @Test
  public void catg() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","E:\\selenium training\\selenium jars\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://localhost:8585");
	  
	  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
	  driver.findElement(By.id("cyclosPassword")).click();
	  driver.findElement(By.xpath("//input[@value='1']")).click();
	  driver.findElement(By.xpath("//input[@value='2']")).click();
	  driver.findElement(By.xpath("//input[@value='3']")).click();
	  driver.findElement(By.xpath("//input[@value='4']")).click();
	  driver.findElement(By.xpath("//input[@value='Submit']")).click();
	  
	  driver.findElement(By.xpath("//li[@id='menu6']")).click();
	  driver.findElement(By.xpath("//li[@id='submenu6.1']")).click();
	  
	  driver.findElement(By.id("newButton")).click();
	  
	  driver.findElement(By.name("category(name)")).sendKeys("anil");
	  driver.findElement(By.id("saveButton")).click();
	  
	  Alert alt1=driver.switchTo().alert();
	  alt1.accept();
	  
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  
	  Alert alt2=driver.switchTo().alert();
	  alt2.accept();
	  
	  driver.findElement(By.xpath("//li[@id='menu0']")).click();
	  
	  driver.findElement(By.id("memberUsername")).sendKeys("anil");
	 
	  JavascriptExecutor j=(JavascriptExecutor)driver;
	  j.executeScript("window.scrollBy(0,700)");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@linkurl='memberAds?memberId=15']")).click();
	  
	  driver.findElement(By.id("newButton")).click();
	  
	  driver.findElement(By.name("ad(title)")).sendKeys("anil");
	  driver.findElement(By.name("ad(category)")).click();
	  driver.findElement(By.xpath("//td//select//option[@value='1']")).click();
	  driver.findElement(By.name("ad(price)")).sendKeys("7");
	  driver.findElement(By.id("notExpirableCheck")).click();
	  
	  driver.switchTo().parentFrame();
	  driver.findElement(By.tagName("iframe")).sendKeys("new offer");
	  
	  driver.findElement(By.id("saveButton")).click();
	  
	  Alert alt3=driver.switchTo().alert();
	  alt3.accept();
	  
	  driver.findElement(By.id("backButton")).click();
	  
	  driver.findElement(By.xpath("//li[@id='menu15']")).click();
	  
	  Alert alt4=driver.switchTo().alert();
	  alt4.accept();
	  
	  driver.findElement(By.id("cyclosUsername")).sendKeys("anil");
	  driver.findElement(By.id("cyclosPassword")).click();
	  driver.findElement(By.xpath("//input[@value='1']")).click();
	  driver.findElement(By.xpath("//input[@value='2']")).click();
	  driver.findElement(By.xpath("//input[@value='3']")).click();
	  driver.findElement(By.xpath("//input[@value='4']")).click();
	  driver.findElement(By.xpath("//input[@value='Submit']")).click();
	  
	  driver.findElement(By.xpath("//li[@id='menu1']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//li[@id='submenu1.2']")).click();
	 
	  
  }
}
