package com.uniovi.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginView extends PO_NavView{
	static public void fillForm(WebDriver driver, String username, String password) {
		WebElement dni = driver.findElement(By.name("username"));
		dni.click();
		dni.clear();
		dni.sendKeys(username);
		
		WebElement passwd = driver.findElement(By.name("password"));
		passwd.click();
		passwd.clear();
		passwd.sendKeys(password);
		
		// Pulsar el boton de login.
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
}
