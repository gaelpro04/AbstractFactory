public class TwilioFactory implements NotificacionFactory {

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
}
