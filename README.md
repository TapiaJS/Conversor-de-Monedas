# Conversor de Monedas

Bienvenido al **Conversor de Monedas**, una aplicación Java que permite convertir entre diversas monedas utilizando tasas de cambio en tiempo real. Este proyecto demuestra cómo consumir una API de tasas de cambio, procesar datos JSON, y proporcionar una interfaz de usuario para la conversión de monedas.

## Contenidos

- [Descripción del Proyecto](#descripción-del-proyecto)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Archivos Clave](#archivos-clave)

## Descripción del Proyecto

Este proyecto implementa un Conversor de Monedas que permite a los usuarios convertir cantidades entre diferentes monedas. El programa realiza las siguientes operaciones:

- Consulta una API de tasas de cambio.
- Filtra y procesa la respuesta JSON.
- Convierte valores entre distintas monedas.
- Proporciona un menú interactivo para seleccionar la conversión deseada.

## Requisitos

Para ejecutar este proyecto, necesitarás:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) 11 o superior.
- Una conexión a internet para realizar solicitudes a la API de tasas de cambio.

## Instalación

Sigue estos pasos para clonar y configurar el proyecto en tu entorno local:

1. **Clonar el Repositorio**:
    ```bash
    git clone https://github.com/TapiaJS/conversor-de-monedas.git
    ```
2. **Navegar al Directorio del Proyecto**:
    ```bash
    cd conversor-de-monedas
    ```
3. **Compilar el Proyecto**:
    ```bash
    javac -d bin src/*.java
    ```
4. **Ejecutar la Aplicación**:
    ```bash
    java -cp bin Main
    ```

## Uso

Una vez que la aplicación esté en ejecución, sigue las instrucciones en la terminal para convertir entre las siguientes opciones de monedas:

1. **Dólar (USD) a Peso argentino (ARS)**
2. **Peso argentino (ARS) a Dólar (USD)**
3. **Dólar (USD) a Real brasileño (BRL)**
4. **Real brasileño (BRL) a Dólar (USD)**
5. **Dólar (USD) a Peso colombiano (COP)**
6. **Peso colombiano (COP) a Dólar (USD)**
7. **Salir**

Ingresa la opción deseada y luego el valor a convertir según se te solicite.

### Archivos Clave:

- **Main.java**: Contiene la lógica principal de la aplicación y el menú interactivo.
- **ConversorDeMonedas.java**: Realiza la conversión entre diferentes monedas.
- **Colors.java**: Maneja la salida de texto con colores en la consola.
- **ConsultaDivisa.java**: Consulta la API de tasas de cambio y procesa la respuesta JSON.
- **Divisa.java**: Modela los datos obtenidos de la API.
- **Moneda.java**: Representa una moneda y su tasa de cambio.
