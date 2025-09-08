public class TwilioFactory implements NotificacionFactory {

    private final String[] parametrosEmergencia = {"EM999999","contrasenia","666-3433343"};

    @Override
    public Notificador crearNotificador() {
        return new TwilioNotificador();
    }

    @Override
    public Configurador crearConfigurador() {
        return new TwilioConfigurador();
    }

    @Override
    public Plantilla crearPlantilla() {
        return new TwilioPlantilla();
    }

    @Override
    public String[] getParametros() {
        return parametrosEmergencia;
    }

}
