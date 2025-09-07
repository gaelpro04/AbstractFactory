public class SendGridPlantilla implements Plantilla {

    private String estilo;

    @Override
    public String aplicarPlantilla(String mensaje) {
        return "[Generico] - [" + estilo + "]\n" + mensaje + "\nSistema de notifiaciones";
    }

    @Override
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
