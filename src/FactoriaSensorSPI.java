public class FactoriaSensorSPI extends FactoriaSensorIoT {
    public SensorAmbiental crearSensor(String puerto, String direccion) throws Exception {
        if (puerto == null || puerto.isEmpty() || direccion == null || direccion.isEmpty()) {
            throw new Exception("Puerto SPI o dirección de registro inválida.");
        }
        return new SensorSPI(puerto, direccion);
    }
}