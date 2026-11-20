public class SensorSPI implements SensorAmbiental {
    private String puerto;
    private String direccion;
    private String estado;

    public SensorSPI(String puerto, String direccion) {
        this.puerto = puerto;
        this.direccion = direccion;
        this.estado = "ACTIVO";
    }

    public String leerDato() {
        String lectura = "[SPI | " + puerto + " | Dir: " + direccion + "] Presión atmosférica: 1012.8 hPa";
        System.out.println(lectura);
        return lectura;
    }

    public void reiniciarCanal() {
        this.estado = "REINICIADO";
        System.out.println("[SPI | " + puerto + "] Línea SPI restablecida.");
    }

    public String obtenerEstado() {
        return estado;
    }
}