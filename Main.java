import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] plataformas = {"email", "sms", "push"}; // email, sms, push
        String[] proveedores = {"sendgrid", "twilio", "firebase"}; // sendgrid, twilio, firebase
        String[] destinos = {"cliente@email.com", "Juanito Perez", "Oscar trabajo"};
        String[] mesnajes = {"Su orden #1234 está lista","Tu orden #1234 ya esta lista","Tu orden #1234 esta lista!"};
        ArrayList<ArrayList<String>> configs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            configs.add(new ArrayList<>());
        }

        //SendGrid
        configs.getFirst().add("SG-123456");
        configs.getFirst().add("miempresa.com");

        //Twilio
        configs.get(1).add("AC123456");
        configs.get(1).add("contrasenia");
        configs.get(1).add("555-2323436");

        //FireBase
        configs.get(2).add("AAAABBBBCCCCDDDD");
        configs.get(2).add("proyectoPro");


        for (int i = 0; i < plataformas.length; i++) {
            NotificacionFactory factory = obtenerFactory(plataformas[i], proveedores[i]);

            SistemaNotificaciones sistema = new SistemaNotificaciones(factory);
            sistema.inicializar();

            String[] config = configs.get(i).toArray(new String[0]);
            sistema.configurarSistema(config);

            System.out.println("\n=== Probando Plantilla ===");
            sistema.probarPlantilla("Su pedido ha sido enviado");

            System.out.println("\n=== Enviando Notificación ===");
            sistema.enviarNotificacion(destinos[i],mesnajes[i]);
        }
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
