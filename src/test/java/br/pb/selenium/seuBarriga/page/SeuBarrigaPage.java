package br.pb.selenium.seuBarriga.page;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeuBarrigaPage {

	private WebDriver driver;
	
	private WebDriverWait wait;

	/*
	 * Factory
	 */
	By linkNovoUsuario = By.linkText("Novo usuário?");

	By txtNome = By.id("nome");
	By txtEmail = By.id("email");
	By txtSenha = By.id("senha");

	By btnCadastrar = By.xpath("//input[@value='Cadastrar']");
	
	By msgSucesso = By.xpath("//div[@class='alert alert-success' and contains(text(), 'Usuário inserido com sucesso')]");
	
	By bodySelector = By.cssSelector("body-index");

	public SeuBarrigaPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	public void clicarLinkNovoUsuario() {
		driver.findElement(linkNovoUsuario).click();
	}

	public void escreverNome(String strNome) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(txtNome).click();
		driver.findElement(txtNome).clear();
		driver.findElement(txtNome).sendKeys(strNome);
	}

	public void escreverEmail(String strEmail) {
		wait.until(ExpectedConditions.presenceOfElementLocated(txtEmail)).click();
		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(strEmail);
	}

	public void escreverSenha(String strSenha) {
		wait.until(ExpectedConditions.presenceOfElementLocated(txtSenha)).click();
		driver.findElement(txtSenha).clear();
		driver.findElement(txtSenha).sendKeys(strSenha);
	}

	public void cadastrar() {
		driver.findElement(btnCadastrar).click();
	}
	
	public void validarMsgCadastroUsuario(String vlrMsgSucesso) {
		String getMsgSucesso = driver.findElement(msgSucesso).getText();
		
		Assert.assertEquals(vlrMsgSucesso, getMsgSucesso);		
	}
}