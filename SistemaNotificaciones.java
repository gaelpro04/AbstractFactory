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

    public void enviarNotificacion(String destinatario, String mensaje) throws InterruptedException {
        enviarNotificacionRec(destinatario, mensaje, 0);
    }

    private void enviarNotificacionRec(String destinatario, String mensaje, int index) throws InterruptedException {
        if (index > factories.size()) {
            System.out.println("Error: No hay conexión con ningun proveedor");
            return;
        }

        if (notificador.verificarConexion()) {
            String mensajeFormateado = plantilla.aplicarPlantilla(mensaje);
            notificador.enviar(destinatario, mensajeFormateado);
        } else {
            System.out.println("Error: No hay conexión con el proveedor se intentará cambiar de proveedor...");
            inicializar(factories.get(index));
            configurarSistema(factories.get(index).getParametros());
            System.out.println("Update: Se esta estableciendo una nueva conexion con parametros de emergencia con el nuevo " +
                    "proveedor...");
            Thread.sleep(2000);
            Scanner sc = new Scanner(System.in);
            System.out.println("Update: Ingrese el nuevo destinatario para el nuevo proveedor:");
            destinatario = sc.nextLine();
            enviarNotificacionRec(destinatario, mensaje, index+1);
        }
    }

    public void probarPlantilla(String mensaje) {
        plantilla.setEstilo("urgente");
        String resultado = plantilla.aplicarPlantilla(mensaje);
        System.out.println("Plantilla aplicada: " + resultado);
    }
}
