package com.selenium.ejemplos.basicos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Ejemplo Básico 3: Interacciones Básicas
 * 
 * Este ejemplo demuestra:
 * - Escribir texto en campos
 * - Limpiar campos
 * - Hacer click en botones
 * - Usar teclas especiales (ENTER, TAB)
 * - Obtener texto de elementos
 * - Obtener atributos de elementos
 */
public class Ejemplo03_InteraccionesBasicas {
    
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            driver.get("https://www.google.com");
            
            // Localizar el campo de búsqueda
            WebElement campoBusqueda = driver.findElement(By.name("q"));
            
            // Escribir texto en el campo
            campoBusqueda.sendKeys("Selenium WebDriver");
            
            // Presionar ENTER para buscar
            campoBusqueda.sendKeys(Keys.ENTER);
            
            // Esperar a que carguen los resultados
            Thread.sleep(2000);
            
            // Obtener el texto del primer resultado
            WebElement primerResultado = driver.findElement(By.cssSelector("h3"));
            String textoResultado = primerResultado.getText();
            System.out.println("Primer resultado: " + textoResultado);
            
            // Obtener atributos del elemento
            String tagName = primerResultado.getTagName();
            String className = primerResultado.getAttribute("class");
            System.out.println("Tag: " + tagName);
            System.out.println("Class: " + className);
            
            // Verificar si el elemento está visible
            boolean esVisible = primerResultado.isDisplayed();
            System.out.println("¿Está visible? " + esVisible);
            
            Thread.sleep(3000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

