package com.selenium.ejemplos.intermedios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Ejemplo Intermedio 1: Esperas Explícitas
 * 
 * Este ejemplo demuestra:
 * - Esperas explícitas con WebDriverWait
 * - Diferentes condiciones de espera
 * - Ventajas sobre Thread.sleep()
 */
public class Ejemplo05_EsperasExplicitas {
    
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            
            // Configurar espera implícita (opcional, pero útil)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            
            driver.get("https://www.saucedemo.com");
            
            // Crear instancia de WebDriverWait (espera explícita)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // Esperar a que el elemento sea visible
            WebElement campoUsuario = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))
            );
            campoUsuario.sendKeys("standard_user");
            
            // Esperar a que el elemento sea clickeable
            WebElement campoPassword = wait.until(
                ExpectedConditions.elementToBeClickable(By.name("password"))
            );
            campoPassword.sendKeys("secret_sauce");
            
            // Hacer login
            WebElement botonLogin = wait.until(
                ExpectedConditions.elementToBeClickable(By.className("submit-button"))
            );
            botonLogin.click();
            
            // Esperar a que la URL cambie (confirmar que el login fue exitoso)
            wait.until(ExpectedConditions.urlContains("inventory"));
            
            // Esperar a que aparezcan los productos
            WebElement primerProducto = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[@class='inventory_item_name']")
                )
            );
            
            System.out.println("Login exitoso! Producto encontrado: " + primerProducto.getText());
            
            Thread.sleep(2000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

