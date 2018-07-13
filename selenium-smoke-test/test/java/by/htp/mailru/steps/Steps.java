package by.htp.mailru.steps;

import org.openqa.selenium.WebDriver;

import by.htp.mailru.driver.DriverSingleton;
import by.htp.mailru.page.ConfirmationPage;
import by.htp.mailru.page.CreateEmailPage;
import by.htp.mailru.page.EmailMainPage;
import by.htp.mailru.page.MainPage;

public class Steps {

	private WebDriver driver;

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void loginMailRu(String username, String password) throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.login(username, password);
	}

	public void navigateToCreateEmailForm() {
		EmailMainPage emailMainPage = new EmailMainPage(driver);
		emailMainPage.openPage();
		emailMainPage.openCreateEmailForm();
	}

	public void createMessage(String recepientEmail, String subject, String message) {
		CreateEmailPage createEmailPage = new CreateEmailPage(driver);
		createEmailPage.openPage();
		createEmailPage.createEmail(recepientEmail, subject, message);
	}

	public boolean getLoggetUserEmail(String userEmail) {
		EmailMainPage emailMainPage = new EmailMainPage(driver);
		String actualUserEmail = emailMainPage.getLoggetUserEmail();
		return userEmail.equals(actualUserEmail);
	}

	public boolean getConfirmation(String confirmationMessage) {
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		String actualMessage = confirmationPage.getConfirmationToSendEmail();
		return actualMessage.contains(confirmationMessage);
	}

	public boolean getConfirmationRecepient(String confirmationRecepient) {
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		String actualRecepient = confirmationPage.getConfirmationRecepient();
		return confirmationRecepient.equals(actualRecepient);
	}

}
