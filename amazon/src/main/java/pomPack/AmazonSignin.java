package pomPack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UtilityClass;

public class AmazonSignin extends UtilityClass {
	private WebDriver driver;
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	private WebElement account;
	
	@FindBy(xpath="(//span[text()='Sign in'])[1]")
	private WebElement signin;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement user;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continuebutton;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement signinbutton;
	
	public AmazonSignin(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	public String atributeText() {
		String text =account.getText();
		return text;
	}
	
	public void signInClick() {
		Actions act = new Actions(driver);
		act.moveToElement(account).moveToElement(signin).click().build().perform();
	}
	
	public void enterUser() throws IOException {
		user.sendKeys(xls(1,0));
		continuebutton.click();
	}
	
	public void enterPass() throws IOException {
		password.sendKeys(xls(1,1));
		signinbutton.click();
	}
	
	


}
