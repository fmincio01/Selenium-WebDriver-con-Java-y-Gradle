package com.selenium.ejemplos.intermedios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

/**
 * Ejemplo Intermedio 3: Múltiples Ventanas y Tabs
 * 
 * Este ejemplo demuestra:
 * - Manejar múltiples ventanas/tabs
 * - Cambiar entre ventanas
 * - Obtener handles de ventanas
 * - Cerrar ventanas específicas
 */
public class Ejemplo07_MultiplesVentanas {
    
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/browser-windows");
            
            // Obtener el handle de la ventana actual
            String ventanaPrincipal = driver.getWindowHandle();
            System.out.println("Ventana principal: " + ventanaPrincipal);
            
            // Hacer click en el botón que abre una nueva ventana
            WebElement botonNuevaVentana = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("windowButton"))
            );
            botonNuevaVentana.click();
            
            // Esperar un momento para que se abra la nueva ventana
            Thread.sleep(2000);
            
            // Obtener todos los handles de ventanas abiertas
            Set<String> todasLasVentanas = driver.getWindowHandles();
            System.out.println("Total de ventanas: " + todasLasVentanas.size());
            
            // Cambiar a la nueva ventana
            for (String ventana : todasLasVentanas) {
                if (!ventana.equals(ventanaPrincipal)) {
                    driver.switchTo().window(ventana);
                    System.out.println("Cambiado a nueva ventana: " + ventana);
                    break;
                }
            }
            
            // Interactuar con la nueva ventana
            WebElement textoNuevaVentana = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.tagName("body"))
            );
            System.out.println("Texto en nueva ventana: " + textoNuevaVentana.getText());
            
            Thread.sleep(2000);
            
            // Cerrar la ventana actual (la nueva)
            driver.close();
            
            // Volver a la ventana principal
            driver.switchTo().window(ventanaPrincipal);
            System.out.println("Regresado a la ventana principal");
            
            Thread.sleep(2000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Cerrar todas las ventanas
            driver.quit();
        }
    }
}

