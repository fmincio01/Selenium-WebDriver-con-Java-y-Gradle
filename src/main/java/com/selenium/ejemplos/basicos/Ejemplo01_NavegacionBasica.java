package com.selenium.ejemplos.basicos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Ejemplo Básico 1: Navegación Básica
 * 
 * Este ejemplo demuestra:
 * - Configuración inicial de WebDriver
 * - Navegación a una URL
 * - Obtener información de la página (título, URL)
 * - Cerrar el navegador
 */
public class Ejemplo01_NavegacionBasica {
    
    public static void main(String[] args) {
        // Configurar WebDriverManager (descarga y configura el driver automáticamente)
        WebDriverManager.chromedriver().setup();
        
        // Crear instancia de ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            // Maximizar la ventana del navegador
            driver.manage().window().maximize();
            
            // Navegar a una URL
            driver.get("https://www.google.com");
            
            // Obtener y mostrar el título de la página
            String titulo = driver.getTitle();
            System.out.println("Título de la página: " + titulo);
            
            // Obtener y mostrar la URL actual
            String urlActual = driver.getCurrentUrl();
            System.out.println("URL actual: " + urlActual);
            
            // Esperar 3 segundos para visualizar
            Thread.sleep(3000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
            driver.quit();
        }
    }
}

