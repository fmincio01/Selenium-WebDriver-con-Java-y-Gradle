package com.selenium.ejemplos.intermedios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Ejemplo Intermedio 2: Formularios Completos
 * 
 * Este ejemplo demuestra:
 * - Llenar formularios completos
 * - Trabajar con dropdowns (Select)
 * - Trabajar con checkboxes
 * - Trabajar con radio buttons
 * - Validar campos
 */
public class Ejemplo06_FormulariosCompletos {
    
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/automation-practice-form");
            
            // Llenar campos de texto
            WebElement nombre = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))
            );
            nombre.sendKeys("Juan");
            
            WebElement apellido = driver.findElement(By.id("lastName"));
            apellido.sendKeys("Pérez");
            
            WebElement email = driver.findElement(By.id("userEmail"));
            email.sendKeys("juan.perez@example.com");
            
            // Radio button
            WebElement radioGenero = driver.findElement(By.cssSelector("input[value='Male']"));
            radioGenero.click();
            
            // Campo de teléfono
            WebElement telefono = driver.findElement(By.id("userNumber"));
            telefono.sendKeys("1234567890");
            
            // Date picker (usando JavaScript para simplificar)
            WebElement fechaNacimiento = driver.findElement(By.id("dateOfBirthInput"));
            fechaNacimiento.click();
            
            // Seleccionar mes y año (ejemplo simplificado)
            Thread.sleep(1000);
            
            // Checkbox - Hobbies
            WebElement checkboxHobby = driver.findElement(
                By.xpath("//label[text()='Sports']")
            );
            checkboxHobby.click();
            
            // Textarea
            WebElement direccion = driver.findElement(By.id("currentAddress"));
            direccion.sendKeys("Calle Principal 123, Ciudad");
            
            // Scroll para ver el botón submit
            ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
            
            Thread.sleep(2000);
            
            // Botón submit
            WebElement botonSubmit = driver.findElement(By.id("submit"));
            botonSubmit.click();
            
            // Esperar a que aparezca el modal de confirmación
            WebElement modal = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.className("modal-content")
                )
            );
            
            System.out.println("Formulario enviado exitosamente!");
            System.out.println("Modal visible: " + modal.isDisplayed());
            
            Thread.sleep(3000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

