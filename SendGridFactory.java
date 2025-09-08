public class SendGridFactory implements NotificacionFactory {

    private final String[] parametros = {"SG-53472E78","fallos.com"};

    @Override
    public Notificador crearNotificador() {
        return new SendGridNotificador();
    }

    @Override
    public Configurador crearConfigurador() {
        return new SendGridConfigurador();
    }

    @Override
    public Plantilla crearPlantilla() {
        return new SendGridPlantilla();
    }

    @Override
    public String[] getParametros() {
        return parametros;
    }
}
