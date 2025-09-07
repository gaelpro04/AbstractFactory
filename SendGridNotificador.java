public class SendGridNotificador implements  Notificador {

    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("[SendGrid] Enviando email a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Email enviado exitosamente via SendGrid");
    }

    @Override
    public boolean verificarConexion() {
        System.out.println("[SendGrid] Verificando conexión API...");
        return true;
    }
}
