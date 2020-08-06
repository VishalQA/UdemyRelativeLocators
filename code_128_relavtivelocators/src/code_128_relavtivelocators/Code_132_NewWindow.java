package code_128_relavtivelocators;

import java.io.File;

import java.io.IOException;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

public class Code_132_NewWindow {

public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaju_v\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
driver.get("https://rahulshettyacademy.com/angularpractice/");

//Switching Window
System.out.println("1");
driver.switchTo().newWindow(WindowType.WINDOW);
System.out.println("2");
Set<String> handles=driver.getWindowHandles();
Iterator<String> it=handles.iterator();
String parentWindowId = it.next();
String childWindow =it.next();
driver.switchTo().window(childWindow);
driver.get("https://rahulshettyacademy.com/");
String courseName = driver.findElements(By.cssSelector("//div[@class='nav-outer clearfix']//a[contains(text(),'Courses')]"))
.get(1).getText();
driver.switchTo().window(parentWindowId);

WebElement name=driver.findElement(By.cssSelector("[name='name']"));
name.sendKeys(courseName);
//Screenshot
File file=name.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(file, new File("logo1.png"));
//driver.quit();
//GEt Height & Width
System.out.println(name.getRect().getDimension().getHeight());
System.out.println(name.getRect().getDimension().getWidth());
}

}

