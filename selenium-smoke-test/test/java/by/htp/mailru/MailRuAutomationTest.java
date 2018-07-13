package by.htp.mailru;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.mailru.steps.Steps;

public class MailRuAutomationTest {
	private static final String USERNAME = "autesttest";
	private static final String EMAIL_DOMAIN = "@mail.ru";
	private static final String PASSWORD = "test12345";
	private static final String EMAIL_RECEPIENT = "kate.ff@ya.ru";
	private static final String EMAIL_SUBJECT = "Auto message task";
	private static final String EMAIL_MESSAGE = "Auto generate message on mail.ru with Selenium WebDriver";
	private static final String CONFIRMATION_MESSAGE = "Ваше письмо отправлено";

	private Steps steps;

	@BeforeClass
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "login to mail.ru")
	public void oneCanLoginMailRu() throws InterruptedException {
		steps.loginMailRu(USERNAME, PASSWORD);
		Assert.assertTrue(steps.getLoggetUserEmail(USERNAME + EMAIL_DOMAIN));
	}

	@Test(description = "send email")
	public void twoCanSendEmail() throws InterruptedException {
		steps.navigateToCreateEmailForm();
		steps.createMessage(EMAIL_RECEPIENT, EMAIL_SUBJECT, EMAIL_MESSAGE);

		Assert.assertTrue(steps.getConfirmation(CONFIRMATION_MESSAGE));
		Assert.assertTrue(steps.getConfirmationRecepient(EMAIL_RECEPIENT));
	}

	@AfterClass
	public void stopBrowser() throws InterruptedException {
		steps.closeDriver();
	}
}
