package by.htp.mailru.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPage extends AbstractPage {

	private static final String CONFIRMATION_TEXT_XPATH = "//*[@id='b-compose__sent']/div/div[1]/div";
	private static final String CONFIRMATION_RECEPIENT_XPATH = "//*[@id='b-compose__sent']/div/div[2]/div[1]/span";

	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
	}

	public String getConfirmationToSendEmail() {
		WebElement confirmationMessageElement = driver.findElement(By.xpath(CONFIRMATION_TEXT_XPATH));
		String confirmationMessage = null;
		if (confirmationMessageElement != null) {
			confirmationMessage = confirmationMessageElement.getText();
			System.out.println(confirmationMessage);
		}
		return confirmationMessage;
	}

	public String getConfirmationRecepient() {
		WebElement confirmationRecepientElement = driver.findElement(By.xpath(CONFIRMATION_RECEPIENT_XPATH));
		String confirmationRecepient = null;
		if (confirmationRecepientElement != null) {
			confirmationRecepient = confirmationRecepientElement.getText();
			System.out.println(confirmationRecepient);
		}
		return confirmationRecepient;
	}

}
