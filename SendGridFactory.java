public class SendGridFactory implements NotificacionFactory {

    private SendGridNotificador sdNotificador;
    private SendGridConfigurador sdConfigurador;

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
}
