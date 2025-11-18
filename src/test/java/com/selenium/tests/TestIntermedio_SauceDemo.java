package com.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Intermedio: E-commerce SauceDemo
 * 
 * Este test demuestra:
 * - Login en aplicación web
 * - Navegación entre páginas
 * - Agregar productos al carrito
 * - Validaciones complejas
 */
public class TestIntermedio_SauceDemo {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test
    void testLoginExitoso() {
        // Navegar a la aplicación
        driver.get("https://www.saucedemo.com");
        
        // Validar que estamos en la página correcta
        assertEquals("Swag Labs", driver.getTitle(), 
            "El título debe ser 'Swag Labs'");
        
        // Hacer login
        WebElement campoUsuario = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))
        );
        campoUsuario.sendKeys("standard_user");
        
        WebElement campoPassword = driver.findElement(By.name("password"));
        campoPassword.sendKeys("secret_sauce");
        
        WebElement botonLogin = driver.findElement(By.className("submit-button"));
        botonLogin.click();
        
        // Validar que el login fue exitoso
        wait.until(ExpectedConditions.urlContains("inventory"));
        assertTrue(driver.getCurrentUrl().contains("inventory"), 
            "Debe estar en la página de inventario después del login");
        
        // Validar que aparecen productos
        WebElement productos = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.className("inventory_list")
            )
        );
        assertTrue(productos.isDisplayed(), 
            "Debe haber productos visibles");
    }
    
    @Test
    void testAgregarProductoAlCarrito() {
        // Login primero
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        
        // Esperar a que cargue la página de productos
        wait.until(ExpectedConditions.urlContains("inventory"));
        
        // Agregar primer producto al carrito
        WebElement botonAgregar = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Add to cart']")
            )
        );
        botonAgregar.click();
        
        // Validar que el botón cambió a "Remove"
        WebElement botonRemover = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[text()='Remove']")
            )
        );
        assertTrue(botonRemover.isDisplayed(), 
            "El botón debe cambiar a 'Remove'");
        
        // Ir al carrito
        WebElement carrito = driver.findElement(By.className("shopping_cart_link"));
        carrito.click();
        
        // Validar que estamos en la página del carrito
        wait.until(ExpectedConditions.urlContains("cart"));
        assertTrue(driver.getCurrentUrl().contains("cart"), 
            "Debe estar en la página del carrito");
        
        // Validar que hay un producto en el carrito
        WebElement productoEnCarrito = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.className("cart_item")
            )
        );
        assertTrue(productoEnCarrito.isDisplayed(), 
            "Debe haber un producto en el carrito");
    }
}

