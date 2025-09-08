import java.util.ArrayList;
import java.util.Scanner;

public class SistemaNotificaciones {
    private ArrayList<NotificacionFactory> factories;
    private Notificador notificador;
    private Configurador configurador;
    private Plantilla plantilla;

    public SistemaNotificaciones(ArrayList<NotificacionFactory> factories) {
        this.factories = factories;
    }

    public void inicializar(NotificacionFactory factory) {
        this.notificador = factory.crearNotificador();
        this.configurador = factory.crearConfigurador();
        this.plantilla = factory.crearPlantilla();
    }

    public void configurarSistema(String[] parametros) {
        configurador.configurar(parametros);
        System.out.println("\nConfiguración: " + configurador.obtenerConfiguracion());
    }

    public void enviarNotificacion(String destinatario, String mensaje) {
        enviarNotificacionRec(destinatario, mensaje, 0);
    }

    private void enviarNotificacionRec(String destinatario, String mensaje, int index) {
        if (index > factories.size()) {
            System.out.println("Error: No hay conexión con ningun proveedor");
            return;
        }

        if (notificador.verificarConexion()) {
            String mensajeFormateado = plantilla.aplicarPlantilla(mensaje);
            notificador.enviar(destinatario, mensajeFormateado);
        } else {
            System.out.println("Error: No hay conexión con el proveedor se intenará cambiar de proveedor...");
            inicializar(factories.get(index));
            Scanner sc = new Scanner(System.in);
            //FALTA AQUI OBTENER PARAMETROS NUEVOS Y DESTINATARIO NUEVO;
            configurarSistema(factories.get(index).getParametros());
            enviarNotificacionRec(destinatario, mensaje, index+1);
        }
    }

    public void probarPlantilla(String mensaje) {
        plantilla.setEstilo("urgente");
        String resultado = plantilla.aplicarPlantilla(mensaje);
        System.out.println("Plantilla aplicada: " + resultado);
    }
}
