# 🧪 Proyecto Selenium WebDriver con Java y Gradle

**Asignatura:** Automatización de Pruebas Funcionales  
**Tema:** Introducción al Selenium WebDriver - Parte 1  
**Fecha:** 2025

Este proyecto contiene ejemplos prácticos **básicos e intermedios** de Selenium WebDriver implementados en Java con Gradle.

---

## 🚀 Inicio Rápido

### Requisitos Previos

- Java JDK 11 o superior
- Gradle 7.x o superior (o usar Gradle Wrapper incluido)
- Navegador Chrome instalado

### Configuración del Proyecto

1. **Clonar o descargar el proyecto**

2. **Verificar Java y Gradle:**
```bash
java -version
gradle --version
```

3. **Compilar el proyecto:**
```bash
gradle build
```

4. **Ejecutar los tests:**
```bash
gradle test
```

### Estructura del Proyecto

```
curso/
├── build.gradle              # Configuración de Gradle y dependencias
├── src/
│   ├── main/java/com/selenium/ejemplos/
│   │   ├── basicos/          # Ejemplos básicos
│   │   │   ├── Ejemplo01_NavegacionBasica.java
│   │   │   ├── Ejemplo02_LocalizadoresBasicos.java
│   │   │   ├── Ejemplo03_InteraccionesBasicas.java
│   │   │   └── Ejemplo04_CSSyXPath.java
│   │   ├── intermedios/      # Ejemplos intermedios
│   │   │   ├── Ejemplo05_EsperasExplicitas.java
│   │   │   ├── Ejemplo06_FormulariosCompletos.java
│   │   │   ├── Ejemplo07_MultiplesVentanas.java
│   │   │   ├── Ejemplo08_AlertasYPopups.java
│   │   │   ├── Ejemplo09_ValidacionesYAssertions.java
│   │   │   └── Ejemplo10_ScreenshotsYReportes.java
│   │   └── Main.java         # Clase principal
│   └── test/java/com/selenium/tests/
│       ├── TestBasico_GoogleSearch.java
│       └── TestIntermedio_SauceDemo.java
└── README.md
```

---

## 📚 Ejemplos Incluidos

### Ejemplos Básicos

1. **Ejemplo01_NavegacionBasica** - Navegación básica, obtener título y URL
2. **Ejemplo02_LocalizadoresBasicos** - Localizadores por ID, Name, ClassName, TagName
3. **Ejemplo03_InteraccionesBasicas** - Click, sendKeys, obtener texto y atributos
4. **Ejemplo04_CSSyXPath** - Uso de CSS Selector y XPath

### Ejemplos Intermedios

5. **Ejemplo05_EsperasExplicitas** - WebDriverWait y ExpectedConditions
6. **Ejemplo06_FormulariosCompletos** - Formularios, dropdowns, checkboxes, radio buttons
7. **Ejemplo07_MultiplesVentanas** - Manejo de múltiples ventanas y tabs
8. **Ejemplo08_AlertasYPopups** - Manejo de alertas JavaScript
9. **Ejemplo09_ValidacionesYAssertions** - Validaciones y verificaciones
10. **Ejemplo10_ScreenshotsYReportes** - Captura de pantallas

### Tests con JUnit

- **TestBasico_GoogleSearch** - Test de búsqueda en Google
- **TestIntermedio_SauceDemo** - Tests de login y carrito de compras

---

## 💻 Cómo Ejecutar los Ejemplos

### Opción 1: Desde el IDE

1. Abre el proyecto en IntelliJ IDEA, Eclipse o VS Code
2. Navega a la clase que quieres ejecutar (ej: `Ejemplo01_NavegacionBasica.java`)
3. Haz clic derecho → Run o ejecuta el método `main()`

### Opción 2: Desde la Terminal

```bash
# Compilar el proyecto
gradle build

# Ejecutar un ejemplo específico
gradle run --args="com.selenium.ejemplos.basicos.Ejemplo01_NavegacionBasica"

# O ejecutar la clase Main
gradle run
```

### Opción 3: Ejecutar Tests

```bash
# Ejecutar todos los tests
gradle test

# Ejecutar un test específico
gradle test --tests "TestBasico_GoogleSearch"
```

---

## 📖 Guía Completa de Conceptos

---

## 📋 Tabla de Contenidos

1. [Introducción a Selenium](#introducción-a-selenium)
2. [Conceptos Fundamentales](#conceptos-fundamentales)
3. [Arquitectura de Selenium](#arquitectura-de-selenium)
4. [Tipos de Selenium](#tipos-de-selenium)
5. [Drivers según Navegador](#drivers-según-navegador)
6. [Localizadores de Elementos](#localizadores-de-elementos)
7. [Comandos Principales](#comandos-principales-de-webdriver)
8. [Configuración del Entorno](#configuración-del-entorno-de-pruebas)
9. [Actividad Práctica](#actividad-práctica)
10. [Referencias y Recursos](#referencias-y-recursos)

---

## 🎯 Introducción a Selenium

### ¿Qué es Selenium?

Selenium es un **framework de código abierto** diseñado para automatizar pruebas de aplicaciones web. Permite simular acciones de usuarios en navegadores web reales, lo que lo convierte en una herramienta esencial para el testing funcional.

### Características Principales

- ✅ **Open Source:** Gratuito y con una comunidad activa
- ✅ **Multi-navegador:** Chrome, Firefox, Safari, Edge, Opera
- ✅ **Multi-plataforma:** Windows, Linux, macOS
- ✅ **Multi-lenguaje:** Java, Python, C#, JavaScript, Ruby
- ✅ **Integración CI/CD:** Jenkins, GitLab CI, GitHub Actions, etc.

### Casos de Uso

1. **Pruebas de Regresión:** Verificar que nuevos cambios no afecten funcionalidades existentes.
2. **Pruebas Funcionales:** Validar que la aplicación cumple con los requisitos.
3. **Pruebas de Humo:** Verificación rápida de funcionalidades críticas.
4. **Web Scraping:** Extracción automatizada de datos.
5. **Automatización de Tareas:** Procesos repetitivos en navegadores.

---

## 💡 Conceptos Fundamentales

### WebDriver

WebDriver es una **interfaz de programación** que permite controlar navegadores web mediante código. Actúa como un puente entre tu script de prueba y el navegador.

### Elemento Web (WebElement)

Representa cualquier elemento HTML en una página web (botones, campos de texto, enlaces, etc.). Se identifican mediante **localizadores**.

### Navegador Driver

Software específico que permite a Selenium comunicarse con cada navegador. Cada navegador requiere su propio driver (ChromeDriver, GeckoDriver, etc.).

### Test Framework

Herramienta para estructurar y ejecutar pruebas (JUnit, TestNG, pytest, etc.).

---

## 🏗️ Arquitectura de Selenium

```
┌─────────────────────────────────────┐
│   Script de Prueba (Java/Python)   │
│   - Código de prueba escrito por   │
│     el desarrollador/tester        │
└──────────────┬──────────────────────┘
               │
               ▼
┌─────────────────────────────────────┐
│     Selenium WebDriver API          │
│   - Comandos estandarizados         │
│   - Abstracción del navegador       │
└──────────────┬──────────────────────┘
               │
               ▼
┌─────────────────────────────────────┐
│    JSON Wire Protocol / W3C         │
│   - Protocolo de comunicación       │
└──────────────┬──────────────────────┘
               │
       ┌───────┴───────┬───────────┐
       ▼               ▼           ▼
┌──────────┐    ┌──────────┐  ┌──────────┐
│ Chrome   │    │ Firefox  │  │  Edge    │
│ Driver   │    │ Driver   │  │  Driver  │
└────┬─────┘    └────┬─────┘  └────┬─────┘
     │               │             │
     ▼               ▼             ▼
┌──────────┐    ┌──────────┐  ┌──────────┐
│ Chrome   │    │ Firefox  │  │  Edge    │
│ Browser  │    │ Browser  │  │  Browser │
└──────────┘    └──────────┘  └──────────┘
```

### Flujo de Ejecución

1. El script envía un comando a la API de Selenium.
2. La API traduce el comando al protocolo del navegador.
3. El driver específico ejecuta el comando en el navegador.
4. El navegador realiza la acción solicitada.
5. El resultado se devuelve al script.

---

## 🔧 Tipos de Selenium

### 1. Selenium IDE 🎬

**Características:**

- Extensión de navegador (Chrome/Firefox).
- Interfaz gráfica para grabar y reproducir pruebas.
- No requiere programación.

**Ventajas:** fácil de aprender, rápido para pruebas simples.  
**Desventajas:** limitado para proyectos grandes.

### 2. Selenium WebDriver ⭐ (MÁS USADO)

**Características:** API programática, control total del navegador, soporta múltiples lenguajes.

**Ventajas:** flexible, potente, integrable con frameworks y CI/CD.  
**Desventajas:** requiere saber programar.

### 3. Selenium Grid 🌐

Permite **ejecución distribuida** en múltiples máquinas, navegadores y sistemas operativos.

### 4. Selenium RC ⚠️

> **⚠️ DEPRECADO:** Reemplazado por WebDriver. No usar en proyectos nuevos.

---

## 🌐 Drivers según Navegador

### ChromeDriver (Google Chrome)

```
Navegador: Google Chrome
Driver: chromedriver / chromedriver.exe
Descarga: https://chromedriver.chromium.org/
Versión: Debe coincidir con la versión de Chrome
```

```java
// Configuración manual
System.setProperty("webdriver.chrome.driver", "/ruta/chromedriver");
WebDriver driver = new ChromeDriver();
```

### GeckoDriver (Mozilla Firefox)

```
Navegador: Mozilla Firefox
Driver: geckodriver / geckodriver.exe
Descarga: https://github.com/mozilla/geckodriver/releases
Protocolo: W3C WebDriver
```

```java
System.setProperty("webdriver.gecko.driver", "/ruta/geckodriver");
WebDriver driver = new FirefoxDriver();
```

### EdgeDriver (Microsoft Edge)

```
Navegador: Microsoft Edge
Driver: msedgedriver / msedgedriver.exe
Descarga: https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
Basado en: Chromium
```

```java
System.setProperty("webdriver.edge.driver", "/ruta/msedgedriver");
WebDriver driver = new EdgeDriver();
```

### SafariDriver (Safari - macOS)

```
Navegador: Safari
Driver: Incluido en macOS
Activación: safaridriver --enable
Plataforma: Solo macOS
```

### 💡 WebDriverManager (Recomendado)

```java
// build.gradle
implementation 'io.github.bonigarcia:webdrivermanager:5.6.2'

// Uso
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
```

---

## 🎯 Localizadores de Elementos

Los localizadores permiten encontrar elementos en una página web. Selenium ofrece 8 tipos:

### 1. ID (Más confiable y rápido)

```java
// HTML: <input id="username" type="text">
WebElement elemento = driver.findElement(By.id("username"));
```

### 2. Name

```java
// HTML: <input name="email" type="email">
WebElement elemento = driver.findElement(By.name("email"));
```

### 3. ClassName

```java
// HTML: <button class="btn-primary">Enviar</button>
WebElement elemento = driver.findElement(By.className("btn-primary"));
```

### 4. TagName

```java
// HTML: <button>Click</button>
WebElement elemento = driver.findElement(By.tagName("button"));
```

### 5. LinkText

```java
// HTML: <a href="/login">Iniciar Sesión</a>
WebElement elemento = driver.findElement(By.linkText("Iniciar Sesión"));
```

### 6. PartialLinkText

```java
// HTML: <a href="/contact">Contáctanos ahora</a>
WebElement elemento = driver.findElement(By.partialLinkText("Contáctanos"));
```

### 7. CSS Selector ⭐

```java
// Por ID
driver.findElement(By.cssSelector("#username"));

// Por clase
driver.findElement(By.cssSelector(".btn-primary"));

// Por atributo
driver.findElement(By.cssSelector("input[name='email']"));

// Combinado
driver.findElement(By.cssSelector("form#loginForm input[type='password']"));
```

### 8. XPath

```java
// Absoluto (no recomendado)
driver.findElement(By.xpath("/html/body/div[1]/form/input[1]"));

// Relativo (recomendado)
driver.findElement(By.xpath("//input[@id='username']"));

// Con texto
driver.findElement(By.xpath("//button[text()='Enviar']"));

// Con contains
driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
```

### 📊 Comparación de Localizadores

| Localizador | Velocidad | Confiabilidad | Flexibilidad | Recomendación |
|-------------|-----------|---------------|--------------|---------------|
| ID | Alta | Alta | Media | Primera opción |
| Name | Alta | Media | Media | Formularios |
| CSS Selector | Alta | Alta | Alta | Segunda opción |
| ClassName | Media | Media | Media | Con cuidado |
| TagName | Media | Baja | Baja | Casos simples |
| LinkText | Media | Media | Media | Solo enlaces |
| PartialLinkText | Media | Baja | Media | Solo enlaces |
| XPath | Baja | Media | Muy alta | Último recurso |

---

## ⚙️ Comandos Principales de WebDriver

### Navegación

```java
// Abrir URL
driver.get("https://www.ejemplo.com");

// Navegar atrás
driver.navigate().back();

// Navegar adelante
driver.navigate().forward();

// Recargar página
driver.navigate().refresh();

// Navegar a URL (alternativa)
driver.navigate().to("https://www.ejemplo.com");
```

### Obtener Información

```java
// Título de la página
String titulo = driver.getTitle();

// URL actual
String url = driver.getCurrentUrl();

// Código fuente de la página
String html = driver.getPageSource();
```

### Interacción con Elementos

```java
// Click en elemento
elemento.click();

// Escribir texto
elemento.sendKeys("Texto a escribir");

// Limpiar campo
elemento.clear();

// Teclas especiales
elemento.sendKeys(Keys.ENTER);
elemento.sendKeys(Keys.TAB);

// Obtener texto
String texto = elemento.getText();

// Atributos
String valor = elemento.getAttribute("value");
String clase = elemento.getAttribute("class");

// Visibilidad / estado
boolean visible = elemento.isDisplayed();
boolean habilitado = elemento.isEnabled();
boolean seleccionado = elemento.isSelected();
```

### Gestión de Ventanas

```java
// Cerrar ventana actual
driver.close();

// Cerrar todas las ventanas
driver.quit();

// Maximizar
driver.manage().window().maximize();

// Cambiar de ventana
Set<String> ventanas = driver.getWindowHandles();
for (String ventana : ventanas) {
    driver.switchTo().window(ventana);
}
```

### Esperas (Waits)

```java
// Espera implícita
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// Espera explícita
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement elemento = wait.until(
    ExpectedConditions.presenceOfElementLocated(By.id("boton"))
);
```

### Alertas y Pop-ups

```java
Alert alerta = driver.switchTo().alert();
alerta.accept();
alerta.dismiss();
String textoAlerta = alerta.getText();
alerta.sendKeys("Respuesta");
```

### Frames e IFrames

```java
driver.switchTo().frame(0);
driver.switchTo().frame("nombreFrame");
driver.switchTo().defaultContent();
```

### Cookies

```java
Set<Cookie> cookies = driver.manage().getCookies();
driver.manage().addCookie(new Cookie("nombre", "valor"));
driver.manage().deleteCookieNamed("nombre");
driver.manage().deleteAllCookies();
```

### Screenshots

```java
File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screenshot, new File("screenshot.png"));
```

---

## 💻 Configuración del Entorno de Pruebas

### Requisitos Previos

- Java JDK 11 o superior
- Gradle 7.x o superior
- IDE (IntelliJ, Eclipse o VS Code)
- Navegador (Chrome, Firefox, Edge)

### Java JDK

```bash
java -version
javac -version
```

### Gradle

```bash
gradle --version
```

### Creación de Proyecto con Gradle

```bash
mkdir selenium-proyecto
cd selenium-proyecto
gradle init
```

### Ejemplo de build.gradle (resumen)

```groovy
plugins {
    id 'java'
    id 'application'
}

group = 'com.pruebas'
version = '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.seleniumhq.selenium:selenium-java:4.16.0'
    implementation 'io.github.bonigarcia:webdrivermanager:5.6.2'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.1'
}

test {
    useJUnitPlatform()
}

application {
    mainClass = 'com.pruebas.selenium.App'
}
```

---

## 📝 Actividad Práctica

**Objetivo:** Configurar un proyecto de automatización con Selenium WebDriver usando Gradle y Java, e implementar pruebas funcionales básicas.

### Requisitos de la Actividad

- **Configuración del Entorno (30%)** – Java, Gradle, IDE, estructura.
- **Implementación de Pruebas (50%)** – Mínimo 5 casos, diferentes localizadores, esperas explícitas.
- **Documentación (20%)** – README, comentarios, screenshots y reporte.

### Ejemplo: Prueba de Búsqueda en Google

```java
@Test
public void pruebaBusquedaGoogle() {
    // 1. Navegar a Google
    // 2. Localizar campo de búsqueda
    // 3. Escribir "Selenium WebDriver"
    // 4. Presionar Enter
    // 5. Verificar que hay resultados
}
```

---

## 🔗 Referencias y Recursos

### Documentación Oficial

- **Selenium:** https://www.selenium.dev/
- **Gradle:** https://gradle.org/
- **JUnit 5:** https://junit.org/junit5/

### Cheat Sheet Gradle

```bash
gradle tasks
gradle build
gradle clean
gradle test
gradle test --info
gradle dependencies
```

### Cheat Sheet WebDriver

```java
driver.get(url);
driver.findElement(By.id("id"));
element.click();
element.sendKeys("texto");
driver.getTitle();
driver.getCurrentUrl();
```

### Preguntas Frecuentes (FAQ)

**1. ¿Por qué mis pruebas fallan aleatoriamente?**

Usa esperas explícitas en lugar de `Thread.sleep()`.

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elemento")));
```

**2. ¿Diferencia entre close() y quit()?**

- `close()`: Cierra la ventana actual.
- `quit()`: Cierra todas las ventanas y finaliza la sesión.

---

## 🎓 Conclusiones

- Selenium WebDriver es la herramienta líder para automatización de pruebas web.
- La arquitectura se basa en drivers específicos por navegador.
- Los localizadores son clave para interactuar con elementos.
- Las esperas explícitas mejoran la estabilidad de las pruebas.
- Page Object Model facilita el mantenimiento del código.
- Gradle simplifica la gestión de dependencias y construcción.

**Próximos pasos:** practicar, aplicar POM, explorar TestNG y Selenium Grid, e integrar con CI/CD.

---

## 🛠️ Dependencias del Proyecto

El proyecto utiliza las siguientes dependencias (configuradas en `build.gradle`):

- **Selenium Java 4.16.0** - Framework principal de automatización
- **WebDriverManager 5.6.2** - Gestión automática de drivers
- **JUnit Jupiter 5.10.1** - Framework de testing

## 📝 Notas Importantes

- **WebDriverManager** descarga y configura automáticamente los drivers necesarios, por lo que no necesitas descargarlos manualmente.
- Los ejemplos utilizan **Chrome** como navegador por defecto. Para usar otro navegador, cambia `ChromeDriver()` por `FirefoxDriver()`, `EdgeDriver()`, etc.
- Algunos ejemplos usan `Thread.sleep()` para visualización. En producción, siempre usa **esperas explícitas** con `WebDriverWait`.
- Los screenshots se guardan en la carpeta `screenshots/` (se crea automáticamente).

## 🐛 Solución de Problemas

### Error: "chromedriver not found"
- WebDriverManager debería descargarlo automáticamente. Si falla, verifica tu conexión a internet.

### Error: "Chrome version mismatch"
- WebDriverManager maneja esto automáticamente. Si persiste, actualiza Chrome a la última versión.

### Los tests fallan intermitentemente
- Asegúrate de usar esperas explícitas (`WebDriverWait`) en lugar de `Thread.sleep()`.
- Verifica que los elementos esperados existan en la página.

## 📞 Contribuciones

Este es un proyecto educativo. Siéntete libre de:
- Agregar más ejemplos
- Mejorar la documentación
- Reportar problemas
- Sugerir mejoras

---

*Material educativo para el curso de Automatización de Pruebas Funcionales · Última actualización: Noviembre 2025*

