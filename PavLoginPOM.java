package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PavLoginPOM {
	private WebDriver driver; 
	
	public PavLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement click1;
	
	public void But1(){
	this.click1.click();
	}
	
	@FindBy(xpath="//input[@value='2']")
	private WebElement click2;
	
	public void But2()
	{
	this.click2.click();
	}
	
	@FindBy(xpath="//input[@value='3']")
	private WebElement click3;
	
	public void But3()
	{
	this.click3.click();
	}
	@FindBy(xpath="//input[@value='4']")
	private WebElement click4;
	
	public void But4(){
	this.click4.click();
	}	
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn; 
	
	public void submit() {
		this.loginBtn.click(); 
	}
	
	@FindBy(xpath="//input[@id='memberUsername']")
	private WebElement member;
	
	public void member1() {
		this.member.sendKeys("pavan");
	}
	
	@FindBy(xpath="//input[@linkurl='grantLoan?memberId=12']")
	private WebElement grant;
	
	public void grant1() {
		this.grant.click();
	}
	
	@FindBy(xpath="//input[@name='loan(amount)']")
	private WebElement loan;
	
	public void loan1() {
		this.loan.sendKeys("10000");
	}
	
	@FindBy(xpath="//textarea[@name='loan(description)']")
	private WebElement desc;
	
	public void dep() {
		this.desc.sendKeys("Home Loan");
	}
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement sub4;
	
	public void subm() {
		this.sub4.click();
	}
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement sub5;
	
	public void subm1() {
		this.sub5.click();
	}	
	@FindBy(xpath="//input[@linkurl='searchLoans?memberId=12']")
	private WebElement viewloan;
	
	public void viewloan1() {
		this.viewloan.click();
	}
	@FindBy(xpath="//li[@id='menu15']")
	private WebElement logoutBtn; 
	
	public void logout1() {
		this.logoutBtn.click(); 
	}
	@FindBy(id="cyclosUsername")
	private WebElement userName1; 
	
	public void sendUserName1(String userName1) {
		this.userName1.clear();
		this.userName1.sendKeys(userName1);
	}

	
	@FindBy(id="cyclosPassword")
	private WebElement password1;
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement click11;
	
	public void But11(){
	this.click1.click();
	}
	
	@FindBy(xpath="//input[@value='2']")
	private WebElement click21;
	
	public void But21()
	{
	this.click2.click();
	}
	
	@FindBy(xpath="//input[@value='3']")
	private WebElement click31;
	
	public void But31()
	{
	this.click3.click();
	}
	@FindBy(xpath="//input[@value='4']")
	private WebElement click41;
	
	public void But41(){
	this.click4.click();
	}	
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn1; 
	
	public void submit1() {
		this.loginBtn1.click(); 
	}
	@FindBy(xpath="//li[@id='menu2']")
	private WebElement accountPOM; 
	
	public void accountLink() {
		this.accountPOM.click(); 
	}
	@FindBy(xpath="//li[@id='submenu2.3']")
	private WebElement loansLink; 
	
	public void loansLink() {
		this.loansLink.click(); 
	}
	@FindBy(xpath="//td/img[@class='details view']")
	private WebElement viewIcon; 
	
	public void viewIcon() {
		this.viewIcon.click(); 
	}
	@FindBy(id="amountText")
	private WebElement amountText; 
	
	public void amountText() {
		this.amountText.clear();
		this.amountText.sendKeys("4567");
	}
	@FindBy(xpath="//input[@value='Repay']")
	private WebElement repayBtn; 
	
	public void repayBtn() {
		this.repayBtn.click(); 
	}

	public void clickLoginBtn() {
		
		
	}

	

	
	
	
}
	
