package com.uniovi.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uniovi.tests.util.SeleniumUtils;

public class PO_PrivateView extends PO_NavView {
	static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep) {
		// Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
		SeleniumUtils.esperarSegundos(driver, 5);
		// Seleccionamos el alumnos userOrder
		new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
		// Rellenemos el campo de descripción
		WebElement description = driver.findElement(By.name("description"));
		description.clear();
		description.sendKeys(descriptionp);
		WebElement score = driver.findElement(By.name("score"));
		score.click();
		score.clear();
		score.sendKeys(scorep);
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
	
	static public void login(WebDriver driver,String user,String passwd,String pageText) {
		clickOption(driver, "login", "class", "btn btn-primary");
		PO_LoginView.fillForm(driver, user, passwd);
		checkElement(driver, "text", pageText);
	}
	
	static public void logout(WebDriver driver) {
		clickOption(driver, "logout", "text", "Identifícate");
	}
}
