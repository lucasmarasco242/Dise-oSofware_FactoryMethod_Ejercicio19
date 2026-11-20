public abstract class FactoriaSensorIoT {
    public abstract SensorAmbiental crearSensor(String puerto, String direccion) throws Exception;

    public SensorAmbiental inicializarConMetricas(String puerto, String direccion) {
        try {
            SensorAmbiental sensor = crearSensor(puerto, direccion);
            System.out.println("Métrica inicial -> Puerto: " + puerto + " | Dir: " + direccion + " | Estado: " + sensor.obtenerEstado());
            return sensor;
        } catch (Exception e) {
            System.out.println("Error al inicializar sensor (" + puerto + " / " + direccion + "): " + e.getMessage());
            return null;
        }
    }
}