public class TwilioNotificador implements Notificador {

    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("[Twilio] Enviando SMS a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("SMS enviado exitosamente via Twilio");
    }

    @Override
    public boolean verificarConexion() {
        System.out.println("[Twilio] Verificando señal...");
        //Simulacion de fallo
        boolean hayFallo = true;
        return hayFallo;
    }
}
