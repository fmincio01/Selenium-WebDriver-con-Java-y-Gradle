package com.selenium.ejemplos.basicos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Ejemplo Básico 4: CSS Selector y XPath
 * 
 * Este ejemplo demuestra:
 * - Localizar elementos con CSS Selector
 * - Localizar elementos con XPath
 * - Diferentes formas de usar estos localizadores
 */
public class Ejemplo04_CSSyXPath {
    
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com");
            
            // ===== CSS SELECTOR =====
            
            // Por ID
            WebElement usuarioCSS = driver.findElement(By.cssSelector("#user-name"));
            usuarioCSS.sendKeys("standard_user");
            
            // Por atributo
            WebElement passwordCSS = driver.findElement(By.cssSelector("input[name='password']"));
            passwordCSS.sendKeys("secret_sauce");
            
            // Por clase
            WebElement botonCSS = driver.findElement(By.cssSelector(".submit-button"));
            botonCSS.click();
            
            Thread.sleep(2000);
            
            // ===== XPATH =====
            
            // XPath relativo por atributo
            WebElement productoXPath = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
            String nombreProducto = productoXPath.getText();
            System.out.println("Producto encontrado con XPath: " + nombreProducto);
            
            // XPath con texto
            WebElement botonAgregar = driver.findElement(By.xpath("//button[text()='Add to cart']"));
            botonAgregar.click();
            
            Thread.sleep(2000);
            
            // XPath con contains
            WebElement carrito = driver.findElement(By.xpath("//a[contains(@class, 'shopping_cart')]"));
            carrito.click();
            
            Thread.sleep(2000);
            
            System.out.println("Ejemplo completado exitosamente");
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

