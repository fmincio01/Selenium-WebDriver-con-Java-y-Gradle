package com.selenium.ejemplos.intermedios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Ejemplo Intermedio 4: Alertas y Pop-ups
 * 
 * Este ejemplo demuestra:
 * - Manejar alertas JavaScript
 * - Aceptar alertas
 * - Cancelar alertas
 * - Obtener texto de alertas
 * - Escribir en alertas de prompt
 */
public class Ejemplo08_AlertasYPopups {
    
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/alerts");
            
            // ===== ALERTA SIMPLE =====
            WebElement botonAlertaSimple = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("alertButton"))
            );
            botonAlertaSimple.click();
            
            // Esperar a que aparezca la alerta y aceptarla
            Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
            String textoAlerta = alerta.getText();
            System.out.println("Texto de la alerta: " + textoAlerta);
            alerta.accept();
            
            Thread.sleep(1000);
            
            // ===== ALERTA CON CONFIRMACIÓN =====
            WebElement botonConfirmacion = driver.findElement(By.id("confirmButton"));
            botonConfirmacion.click();
            
            Alert alertaConfirmacion = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Texto de confirmación: " + alertaConfirmacion.getText());
            alertaConfirmacion.dismiss(); // Cancelar
            
            Thread.sleep(1000);
            
            // ===== ALERTA CON PROMPT =====
            WebElement botonPrompt = driver.findElement(By.id("promtButton"));
            botonPrompt.click();
            
            Alert alertaPrompt = wait.until(ExpectedConditions.alertIsPresent());
            alertaPrompt.sendKeys("Selenium WebDriver");
            alertaPrompt.accept();
            
            Thread.sleep(2000);
            
            // Verificar el resultado
            WebElement resultado = driver.findElement(By.id("promptResult"));
            System.out.println("Resultado del prompt: " + resultado.getText());
            
            Thread.sleep(2000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

