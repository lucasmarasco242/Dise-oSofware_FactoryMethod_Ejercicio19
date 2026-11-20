Ejercicio 19 - Fábrica Avanzada de Sensores Ambientales para IoT

Explicación del programa

En este ejercicio se implementó el patrón de diseño Factory Method junto con registro dinámico de factorías, validación de parámetros de hardware y direcciones de memoria, manejo de excepciones y registro de estado operativo inicial para sensores ambientales (ModBus, I2C y SPI), sin utilizar librerías externas ni imports.
El programa cuenta con:
- Una interfaz SensorAmbiental con los métodos leerDato(), reiniciarCanal() y obtenerEstado().
- Tres clases concretas (SensorModBus, SensorI2C y SensorSPI) que gestionan la lectura de datos y el estado del canal.
- Una clase abstracta FactoriaSensorIoT con el método de fábrica crearSensor(String puerto, String direccion) y el método inicializarConMetricas(String puerto, String direccion) con captura de excepciones y métricas iniciales.
- Tres factorías concretas (FactoriaSensorModBus, FactoriaSensorI2C y FactoriaSensorSPI) que validan parámetros de hardware y lanzan excepciones ante fallos.
- Una clase RegistroSensoresIoT con métodos sincronizados para registrar nuevas factorías en tiempo de ejecución e inicializar sensores.

Luego, dentro del método main, se registran las factorías y se prueban lecturas, reinicio de canal y casos con dirección inválida.

Lógica utilizada

La lógica del programa consiste en:
- Definir una interfaz común SensorAmbiental para unificar lectura, reinicio y consulta de estado.
- Delegar la validación de puerto/dirección y creación de cada protocolo a su factoría concreta, lanzando excepciones si los datos son inválidos.
- Centralizar en FactoriaSensorIoT la inicialización segura y el registro de métricas operativas iniciales.
- Permitir el registro dinámico de factorías en RegistroSensoresIoT mediante métodos sincronizados sin modificar el código base.

Resultado de la ejecución

La ejecución del programa muestra en la consola lo siguiente:
Métrica inicial -> Puerto: 10.0.1.50:502 | Dir: REG-4001 | Estado: ACTIVO
[ModBus | 10.0.1.50:502 | Dir: REG-4001] Temperatura: 23.4°C
[ModBus | 10.0.1.50:502] Canal restablecido.
Métrica inicial -> Puerto: BUS-0 | Dir: 0x48 | Estado: ACTIVO
[I2C | BUS-0 | Dir: 0x48] Humedad relativa: 58%
Métrica inicial -> Puerto: SPI-1-CS0 | Dir: 0x1A | Estado: ACTIVO
[SPI | SPI-1-CS0 | Dir: 0x1A] Presión atmosférica: 1012.8 hPa
Error al inicializar sensor (BUS-0 / ): Puerto I2C o dirección hexadecimal inválida.
Inicialización abortada por dirección de memoria inválida.

Captura de pantalla

<img width="865" height="376" alt="image" src="https://github.com/user-attachments/assets/a2719775-bf00-47ca-aec2-c5f1be0bf04d" />
