package com.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Básico: Búsqueda en Google
 * 
 * Este test demuestra:
 * - Configuración de WebDriver en tests
 * - Navegación y búsqueda
 * - Validaciones con JUnit
 */
public class TestBasico_GoogleSearch {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    @BeforeEach
    void setUp() {
        // Configurar WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Inicializar WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Configurar espera explícita
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @AfterEach
    void tearDown() {
        // Cerrar el navegador después de cada test
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test
    void testBusquedaGoogle() {
        // Navegar a Google
        driver.get("https://www.google.com");
        
        // Aceptar cookies si aparece (puede variar según región)
        try {
            WebElement aceptarCookies = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("L2AGLb"))
            );
            aceptarCookies.click();
        } catch (Exception e) {
            // Si no aparece el botón, continuar
        }
        
        // Localizar campo de búsqueda
        WebElement campoBusqueda = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.name("q"))
        );
        
        // Verificar que el campo está visible
        assertTrue(campoBusqueda.isDisplayed(), "El campo de búsqueda debe estar visible");
        
        // Escribir término de búsqueda
        campoBusqueda.sendKeys("Selenium WebDriver");
        campoBusqueda.sendKeys(Keys.ENTER);
        
        // Esperar a que carguen los resultados
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
        
        // Validar que la URL contiene el término de búsqueda
        String urlActual = driver.getCurrentUrl();
        assertTrue(urlActual.contains("selenium"), 
            "La URL debe contener 'selenium'");
        
        // Validar que hay resultados
        WebElement resultados = driver.findElement(By.id("search"));
        assertTrue(resultados.isDisplayed(), 
            "Debe haber resultados de búsqueda visibles");
        
        // Validar título de la página
        String titulo = driver.getTitle();
        assertTrue(titulo.contains("Selenium") || titulo.contains("Google"), 
            "El título debe contener 'Selenium' o 'Google'");
    }
}

