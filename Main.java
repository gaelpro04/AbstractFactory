import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String plataforma = "email";
        String proveedor = "sendgrid";
        String[] parametros = {"SG-123456","miempresa.com"};
        String[] mensajeYdestino = {"cliente@email.com","Su orden #1234 está lista"};
        ArrayList<NotificacionFactory> factories = new ArrayList<>();
        factories.add(new SendGridFactory());
        factories.add(new FireBaseFactory());
        factories.add(new TwilioFactory());


        NotificacionFactory factory = obtenerFactory(plataforma, proveedor);

        SistemaNotificaciones sistema = new SistemaNotificaciones(factories);
        sistema.inicializar(factory);

        sistema.configurarSistema(parametros);

        System.out.println("\n=== Probando Plantilla ===");
        sistema.probarPlantilla("Su pedido ha sido enviado");

        System.out.println("\n=== Enviando Notificación ===");
        sistema.enviarNotificacion(mensajeYdestino[0], mensajeYdestino[1]);

    }

    private static NotificacionFactory obtenerFactory(String plataforma, String proveedor) {
        switch (plataforma + "-" + proveedor) {
            case "email-sendgrid":
                return new SendGridFactory();
            case "sms-twilio":
                return new TwilioFactory();
            case "push-firebase":
                return new FireBaseFactory();
            default:
                throw new IllegalArgumentException("Combinación no soportada");
        }

    }
}
