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
 * Ejemplo Intermedio 5: Validaciones y Assertions
 * 
 * Este ejemplo demuestra:
 * - Validar títulos de página
 * - Validar URLs
 * - Validar presencia de elementos
 * - Validar texto de elementos
 * - Validar estados de elementos (visible, habilitado, seleccionado)
 */
public class Ejemplo09_ValidacionesYAssertions {
    
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com");
            
            // ===== VALIDACIONES BÁSICAS =====
            
            // Validar título de la página
            String tituloEsperado = "Swag Labs";
            String tituloActual = driver.getTitle();
            if (tituloActual.equals(tituloEsperado)) {
                System.out.println("✓ Título correcto: " + tituloActual);
            } else {
                System.out.println("✗ Título incorrecto. Esperado: " + tituloEsperado + ", Actual: " + tituloActual);
            }
            
            // Validar URL
            String urlEsperada = "https://www.saucedemo.com/";
            String urlActual = driver.getCurrentUrl();
            if (urlActual.equals(urlEsperada)) {
                System.out.println("✓ URL correcta: " + urlActual);
            } else {
                System.out.println("✗ URL incorrecta. Esperada: " + urlEsperada + ", Actual: " + urlActual);
            }
            
            // ===== VALIDAR ELEMENTOS =====
            
            // Validar que el campo de usuario existe y está visible
            WebElement campoUsuario = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))
            );
            
            if (campoUsuario.isDisplayed()) {
                System.out.println("✓ Campo de usuario está visible");
            }
            
            if (campoUsuario.isEnabled()) {
                System.out.println("✓ Campo de usuario está habilitado");
            }
            
            // Hacer login
            campoUsuario.sendKeys("standard_user");
            driver.findElement(By.name("password")).sendKeys("secret_sauce");
            driver.findElement(By.className("submit-button")).click();
            
            // Validar que el login fue exitoso
            wait.until(ExpectedConditions.urlContains("inventory"));
            System.out.println("✓ Login exitoso - URL contiene 'inventory'");
            
            // Validar que aparecen productos
            WebElement primerProducto = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[@class='inventory_item_name']")
                )
            );
            
            if (primerProducto.isDisplayed()) {
                System.out.println("✓ Productos visibles en la página");
                System.out.println("  Primer producto: " + primerProducto.getText());
            }
            
            // Validar que el botón "Add to cart" está presente
            WebElement botonAgregar = driver.findElement(
                By.xpath("//button[text()='Add to cart']")
            );
            
            if (botonAgregar.isDisplayed() && botonAgregar.isEnabled()) {
                System.out.println("✓ Botón 'Add to cart' está visible y habilitado");
                botonAgregar.click();
            }
            
            Thread.sleep(2000);
            
            // Validar que el botón cambió a "Remove"
            WebElement botonRemover = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//button[text()='Remove']")
                )
            );
            
            if (botonRemover.isDisplayed()) {
                System.out.println("✓ Producto agregado correctamente - Botón cambió a 'Remove'");
            }
            
            Thread.sleep(2000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

