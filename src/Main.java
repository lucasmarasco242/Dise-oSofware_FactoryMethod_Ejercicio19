public class Main {
    public static void main(String[] args) {
        RegistroSensoresIoT registro = new RegistroSensoresIoT();
        registro.registrar("MODBUS", new FactoriaSensorModBus());
        registro.registrar("I2C", new FactoriaSensorI2C());
        registro.registrar("SPI", new FactoriaSensorSPI());

        SensorAmbiental modbus = registro.inicializar("MODBUS", "10.0.1.50:502", "REG-4001");
        if (modbus != null) {
            modbus.leerDato();
            modbus.reiniciarCanal();
        }

        SensorAmbiental i2c = registro.inicializar("I2C", "BUS-0", "0x48");
        if (i2c != null) {
            i2c.leerDato();
        }

        SensorAmbiental spi = registro.inicializar("SPI", "SPI-1-CS0", "0x1A");
        if (spi != null) {
            spi.leerDato();
        }

        SensorAmbiental invalido = registro.inicializar("I2C", "BUS-0", "");
        if (invalido == null) {
            System.out.println("Inicialización abortada por dirección de memoria inválida.");
        }
    }
}