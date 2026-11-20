public class SensorI2C implements SensorAmbiental {
    private String puerto;
    private String direccion;
    private String estado;

    public SensorI2C(String puerto, String direccion) {
        this.puerto = puerto;
        this.direccion = direccion;
        this.estado = "ACTIVO";
    }

    public String leerDato() {
        String lectura = "[I2C | " + puerto + " | Dir: " + direccion + "] Humedad relativa: 58%";
        System.out.println(lectura);
        return lectura;
    }

    public void reiniciarCanal() {
        this.estado = "REINICIADO";
        System.out.println("[I2C | " + puerto + "] Bus reiniciado.");
    }

    public String obtenerEstado() {
        return estado;
    }
}
