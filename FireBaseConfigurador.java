public class FireBaseConfigurador implements Configurador {

    private String apiKey;
    private String proyecto;

    @Override
    public void configurar(String[] parametros) {
        apiKey = parametros[0];
        proyecto = parametros[1];
    }

    @Override
    public String obtenerConfiguracion() {
        return "FireBase = API Key - " + apiKey + " Proyecto: " + proyecto;
    }
}
