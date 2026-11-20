public class FactoriaSensorModBus extends FactoriaSensorIoT {
    public SensorAmbiental crearSensor(String puerto, String direccion) throws Exception {
        if (puerto == null || puerto.isEmpty() || direccion == null || direccion.isEmpty()) {
            throw new Exception("Puerto o registro ModBus inválido.");
        }
        return new SensorModBus(puerto, direccion);
    }
}