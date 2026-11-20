public class RegistroSensoresIoT {
    private String[] protocolos = new String[20];
    private FactoriaSensorIoT[] factorias = new FactoriaSensorIoT[20];
    private int cantidad = 0;

    public synchronized void registrar(String protocolo, FactoriaSensorIoT factoria) {
        if (protocolo == null || factoria == null || cantidad >= protocolos.length) {
            return;
        }
        int indice = buscarIndice(protocolo);
        if (indice != -1) {
            factorias[indice] = factoria;
        } else {
            protocolos[cantidad] = protocolo;
            factorias[cantidad] = factoria;
            cantidad++;
        }
    }

    public SensorAmbiental inicializar(String protocolo, String puerto, String direccion) {
        int indice = buscarIndice(protocolo);
        if (indice == -1) {
            System.out.println("Protocolo de sensor no registrado: " + protocolo);
            return null;
        }
        return factorias[indice].inicializarConMetricas(puerto, direccion);
    }

    private synchronized int buscarIndice(String protocolo) {
        if (protocolo == null) {
            return -1;
        }
        for (int i = 0; i < cantidad; i++) {
            if (protocolos[i].equals(protocolo)) {
                return i;
            }
        }
        return -1;
    }
}