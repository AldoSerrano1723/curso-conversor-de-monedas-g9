# Conversor de Monedas (CONVERT3000)

Aplicación de consola en Java para convertir montos entre monedas comunes usando la API pública de ExchangeRate. El programa muestra un menú interactivo y realiza la consulta en línea para ofrecer la tasa y el resultado de la conversión.

## Requisitos
- Java 17 o superior (usa `HttpClient`).
- [Gson](https://github.com/google/gson) en el classpath para deserializar la respuesta JSON de la API.
- Conexión a internet para consultar las tasas de cambio.

## Estructura del proyecto
- `Principal.java`: ciclo principal, manejo del menú y entrada de usuario.
- `InterfazUsuario.java`: imprime el menú de opciones.
- `ConsultarMoneda.java`: realiza la llamada HTTP a la API y transforma la respuesta en un registro Java.
- `ResultadoConversion.java`: `record` que modela la respuesta de la API (códigos de moneda, tasa y monto convertido).

## Ejecución
1. Descarga la dependencia de Gson (por ejemplo, `gson-2.10.1.jar`).
2. Compila los archivos fuente:
   ```bash
   javac -cp gson-2.10.1.jar src/*.java
   ```
3. Ejecuta el programa desde el directorio raíz del proyecto:
   ```bash
   java -cp gson-2.10.1.jar:src Principal
   ```

> En Windows, sustituye `:` por `;` en el classpath.

## Uso
1. Selecciona la opción del menú (1-7) para elegir el par de monedas.
2. Ingresa el monto a convertir cuando se solicite.
3. El programa mostrará el monto original, la tasa aplicada y el resultado en la moneda destino.
4. Usa la opción 7 para salir.

### Monedas soportadas
- MXN ➜ USD, EUR, GBP
- USD ➜ MXN, BRL, COP

## Notas
- La clave de la API está incrustada en `ConsultarMoneda`. Si necesitas otra clave, cámbiala en la constante `url`.
- Los errores de formato en la entrada (letras en lugar de números) se gestionan mostrando un mensaje y permitiendo un nuevo intento.
