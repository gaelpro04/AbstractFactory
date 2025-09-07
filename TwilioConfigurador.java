public class TwilioConfigurador implements Configurador {

    private String acctSID;
    private String authToken;
    private String numero;

    @Override
    public void configurar(String[] parametros) {
        this.acctSID = parametros[0];
        this.authToken = parametros[1];
        this.numero = parametros[2];
    }

    @Override
    public String obtenerConfiguracion() {
        return "Twilio - account SID: " + acctSID + " Auth token: " + authToken + " Numero remitente: " + numero;
    }
}
