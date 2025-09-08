public class FireBaseFactory implements NotificacionFactory {

    private final String[] parametrosEmergencia = {"454D455247454E4359","proyectoFallBack"};

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

    @Override
    public String[] getParametros() {
        return parametrosEmergencia;
    }
}
