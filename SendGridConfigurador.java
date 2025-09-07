public class SendGridConfigurador implements Configurador {

    private String apiKey;
    private String dominio;

    @Override
    public void configurar(String[] parametros) {
        this.apiKey = parametros[0];
        this.dominio = parametros[1];

    }

    @Override
    public String obtenerConfiguracion() {
        return "SendGrid - API Key: " + apiKey + ", Dominio: " + dominio;
    }
}
