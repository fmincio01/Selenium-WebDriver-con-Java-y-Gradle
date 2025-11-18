package com.selenium.ejemplos.basicos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Ejemplo Básico 2: Localizadores Básicos
 * 
 * Este ejemplo demuestra:
 * - Localizar elementos por ID
 * - Localizar elementos por Name
 * - Localizar elementos por ClassName
 * - Localizar elementos por TagName
 * - Interactuar con elementos (click, sendKeys)
 */
public class Ejemplo02_LocalizadoresBasicos {
    
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com");
            
            // Localizar por ID
            WebElement campoUsuario = driver.findElement(By.id("user-name"));
            campoUsuario.sendKeys("standard_user");
            
            // Localizar por Name
            WebElement campoPassword = driver.findElement(By.name("password"));
            campoPassword.sendKeys("secret_sauce");
            
            // Localizar por ClassName
            WebElement botonLogin = driver.findElement(By.className("submit-button"));
            botonLogin.click();
            
            // Esperar a que cargue la página
            Thread.sleep(2000);
            
            // Localizar por TagName (obtener todos los títulos de productos)
            var productos = driver.findElements(By.tagName("div"));
            System.out.println("Elementos encontrados: " + productos.size());
            
            // Obtener el título de la página después del login
            String titulo = driver.getTitle();
            System.out.println("Título después del login: " + titulo);
            
            Thread.sleep(3000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

