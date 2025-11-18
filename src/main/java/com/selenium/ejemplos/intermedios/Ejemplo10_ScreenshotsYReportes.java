package com.selenium.ejemplos.intermedios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Ejemplo Intermedio 6: Screenshots y Reportes
 * 
 * Este ejemplo demuestra:
 * - Tomar screenshots de la página completa
 * - Guardar screenshots con nombres únicos
 * - Crear directorios para organizar screenshots
 */
public class Ejemplo10_ScreenshotsYReportes {
    
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com");
            
            // Crear directorio para screenshots si no existe
            Path screenshotsDir = Paths.get("screenshots");
            if (!Files.exists(screenshotsDir)) {
                Files.createDirectories(screenshotsDir);
                System.out.println("Directorio 'screenshots' creado");
            }
            
            // Tomar screenshot de la página de login
            tomarScreenshot(driver, "01_login_page");
            
            // Hacer login
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.name("password")).sendKeys("secret_sauce");
            driver.findElement(By.className("submit-button")).click();
            
            Thread.sleep(2000);
            
            // Tomar screenshot después del login
            tomarScreenshot(driver, "02_after_login");
            
            // Agregar producto al carrito
            driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
            
            Thread.sleep(1000);
            
            // Tomar screenshot con producto en carrito
            tomarScreenshot(driver, "03_product_added");
            
            // Ir al carrito
            driver.findElement(By.className("shopping_cart_link")).click();
            
            Thread.sleep(2000);
            
            // Tomar screenshot del carrito
            tomarScreenshot(driver, "04_cart_page");
            
            System.out.println("Screenshots guardados exitosamente en la carpeta 'screenshots'");
            
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
    
    /**
     * Método auxiliar para tomar screenshots
     */
    private static void tomarScreenshot(WebDriver driver, String nombre) throws IOException {
        // Convertir WebDriver a TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        
        // Tomar el screenshot
        File archivoScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        
        // Generar nombre único con timestamp
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String nombreArchivo = nombre + "_" + timestamp + ".png";
        
        // Guardar el screenshot
        Path destino = Paths.get("screenshots", nombreArchivo);
        Files.copy(archivoScreenshot.toPath(), destino);
        
        System.out.println("Screenshot guardado: " + destino.toString());
    }
}

