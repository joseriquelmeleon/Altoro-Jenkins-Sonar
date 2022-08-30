package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import baseClass.ClaseBase;

public class ElementFetch {
	public WebElement getWebElement(String identifierType, String identifierValue) {
		switch (identifierType) {
		case "ID":
			return ClaseBase.driver.findElement(By.id(identifierValue));
		case "CSS":
			return ClaseBase.driver.findElement(By.cssSelector(identifierValue));
		case "TAGNAME":
			return ClaseBase.driver.findElement(By.tagName(identifierValue));
		case "XPATH":
			return ClaseBase.driver.findElement(By.xpath(identifierValue));
		case "LINK TEXT":
			return ClaseBase.driver.findElement(By.linkText(identifierValue));
		default:
			return null;
		}
	}

	public List<WebElement> getListWebElements(String identifierType, String identifierValue) {
		switch (identifierType) {
		case "ID":
			return ClaseBase.driver.findElements(By.id(identifierValue));
		case "CSS":
			return ClaseBase.driver.findElements(By.cssSelector(identifierValue));
		case "TAGNAME":
			return ClaseBase.driver.findElements(By.tagName(identifierValue));
		case "XPATH":
			return ClaseBase.driver.findElements(By.xpath(identifierValue));
		case "LINK TEXT":
			return ClaseBase.driver.findElements(By.linkText(identifierValue));
		default:
			return null;
		}
	}
}
