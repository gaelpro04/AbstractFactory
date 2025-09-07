public class FireBaseFactory implements NotificacionFactory {
    @Override
    public Notificador crearNotificador() {
        return new FireBaseNotificador();
    }

    @Override
    public Configurador crearConfigurador() {
        return new FireBaseConfigurador();
    }

    @Override
    public Plantilla crearPlantilla() {
        return new FireBasePlantilla();
    }
}
