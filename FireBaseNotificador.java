public class FireBaseNotificador implements Notificador {


    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("[FireBase] Enviando mensaje a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Mensaje enviado exitosamente via FireBase");
    }

    @Override
    public boolean verificarConexion() {
        System.out.println("[FireBase] Verificando conexion WI-FI...");
        return true;
    }
}
