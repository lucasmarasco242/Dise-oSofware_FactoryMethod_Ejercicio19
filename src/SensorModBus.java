public class SensorModBus implements SensorAmbiental {
    private String puerto;
    private String direccion;
    private String estado;

    public SensorModBus(String puerto, String direccion) {
        this.puerto = puerto;
        this.direccion = direccion;
        this.estado = "ACTIVO";
    }

    public String leerDato() {
        String lectura = "[ModBus | " + puerto + " | Dir: " + direccion + "] Temperatura: 23.4°C";
        System.out.println(lectura);
        return lectura;
    }

    public void reiniciarCanal() {
        this.estado = "REINICIADO";
        System.out.println("[ModBus | " + puerto + "] Canal restablecido.");
    }

    public String obtenerEstado() {
        return estado;
    }
}