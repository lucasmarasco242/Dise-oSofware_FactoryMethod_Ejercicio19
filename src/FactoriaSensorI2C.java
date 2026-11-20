public class FactoriaSensorI2C extends FactoriaSensorIoT {
    public SensorAmbiental crearSensor(String puerto, String direccion) throws Exception {
        if (puerto == null || puerto.isEmpty() || direccion == null || !direccion.startsWith("0x")) {
            throw new Exception("Puerto I2C o dirección hexadecimal inválida.");
        }
        return new SensorI2C(puerto, direccion);
    }
}