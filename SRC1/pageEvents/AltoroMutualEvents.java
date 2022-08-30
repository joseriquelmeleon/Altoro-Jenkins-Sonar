package pageEvents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import baseClass.ClaseBase;
import pageObjects.AltoroMutualElements;
import utils.ElementFetch;
import utils.Events;
import utils.Utils;
import utils.Validations;
import testMutual.AltoroMutualTest;

public class AltoroMutualEvents extends AltoroMutualTest {

	public AltoroMutualEvents(WebDriver driver) {
		AltoroMutualTest.driver = driver;
	}

	public static void iniciarSesion(String usuario, String contrasena) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			Utils.outputInfo("Ha comenzado el evento: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			ElementFetch elementFetch = new ElementFetch();

			WebElement inputNombreUsuarioElement = elementFetch.getWebElement("CSS",
					AltoroMutualElements.inputUsuario);
			wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
			Events.writeOnInput(inputNombreUsuarioElement, usuario);
			Thread.sleep(3000);

			WebElement inputContrasenaElement = elementFetch.getWebElement("CSS",
					AltoroMutualElements.inputContrasena);
			wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
			Events.writeOnInput(inputContrasenaElement, contrasena);
			Thread.sleep(3000);

			WebElement buttonIniciarSesionElement = elementFetch.getWebElement("CSS",
					AltoroMutualElements.btnSubmit);
			wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
			Events.clickButton(buttonIniciarSesionElement);
			Thread.sleep(3000);

			WebElement labelPaginaProductosElement = elementFetch.getWebElement("XPATH",
					AltoroMutualElements.labelInicioSesion);
			wait.until(ExpectedConditions.visibilityOf(labelPaginaProductosElement));
			String textoPagina = labelPaginaProductosElement.getText();
			Thread.sleep(3000);

			Validations.trueBooleanCondition(textoPagina.equalsIgnoreCase("Hello John Smith"),
					"Se ha ingresado a la página '" + textoPagina + "' correctamente",
					"No se ha ingresado a la página correcta", currentEvent);
			

		} catch (Exception e) {
			Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
	public static void transferMount(String monto) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			Utils.outputInfo("Ha comenzado el evento: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			ElementFetch elementFetch = new ElementFetch();
			
			WebElement buttonTransferencia = elementFetch.getWebElement("CSS",
					AltoroMutualElements.btnTransfer);
			wait.until(ExpectedConditions.visibilityOf(buttonTransferencia));
			Events.clickButton(buttonTransferencia);
			Thread.sleep(3000);
			
			WebElement labelPaginaTransfer = elementFetch.getWebElement("XPATH",
					AltoroMutualElements.labelPageTransfer);
			wait.until(ExpectedConditions.visibilityOf(labelPaginaTransfer));
			String textoPagina = labelPaginaTransfer.getText();
			Thread.sleep(3000);

			Validations.trueBooleanCondition(textoPagina.equalsIgnoreCase("Transfer Funds"),
					"Se ha ingresado a la página '" + textoPagina + "' correctamente",
					"No se ha ingresado a la página correcta", currentEvent);

			WebElement fromAccount = elementFetch.getWebElement("XPATH",
					AltoroMutualElements.fromAccount);
			wait.until(ExpectedConditions.visibilityOf(fromAccount));
			Events.clickButton(fromAccount);
			Thread.sleep(3000);

			WebElement toAccount = elementFetch.getWebElement("XPATH",
					AltoroMutualElements.toAccount);
			wait.until(ExpectedConditions.elementToBeClickable(toAccount));
			Events.clickButton(toAccount);
			Thread.sleep(3000);
			
			WebElement transferAmmount = elementFetch.getWebElement("XPATH",
					AltoroMutualElements.Ammount);
			wait.until(ExpectedConditions.visibilityOf(transferAmmount));
			Events.writeOnInput(transferAmmount, monto);
			
			WebElement btnTransferMonto = elementFetch.getWebElement("XPATH",
					AltoroMutualElements.btnTransferMonto);
			wait.until(ExpectedConditions.visibilityOf(btnTransferMonto));
			Events.clickButton(btnTransferMonto);
			
			WebElement labelTransfer = elementFetch.getWebElement("XPATH",
					AltoroMutualElements.labelTransfer);
			wait.until(ExpectedConditions.visibilityOf(labelTransfer));
			String textoPagina2 = labelTransfer.getText();
			System.out.println(textoPagina2);
			textoPagina2 = textoPagina2.substring(0,5);
			String mensajeEsperado = "100.0";
			

			Validations.trueBooleanCondition(textoPagina2.equalsIgnoreCase(mensajeEsperado),
					"El monto es el correcto'" + textoPagina2 + "' correctamente",
					"El monto es incorrecto", currentEvent);
			
			
			

		} catch (Exception e) {
			Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
	public static void signOff() {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			Utils.outputInfo("Ha comenzado el evento: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			ElementFetch elementFetch = new ElementFetch();
			
			WebElement buttonCerrarSesion = elementFetch.getWebElement("XPATH",
					AltoroMutualElements.signOut);
			wait.until(ExpectedConditions.visibilityOf(buttonCerrarSesion));
			Events.clickButton(buttonCerrarSesion);
			Thread.sleep(3000);
			
			WebElement labelSignoff = elementFetch.getWebElement("XPATH",
					AltoroMutualElements.labelSignOff);
			wait.until(ExpectedConditions.visibilityOf(labelSignoff));
			String textoPagina2 = labelSignoff.getText();

			Validations.trueBooleanCondition(textoPagina2.equalsIgnoreCase("Sign In"),
					"Esta en la pagina correcta'" + textoPagina2 + "' correctamente",
					"Pagina incorrecta", currentEvent);
			
			

		} catch (Exception e) {
			Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
	
}
