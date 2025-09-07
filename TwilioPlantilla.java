public class TwilioPlantilla implements Plantilla {

    private String estilo;

    @Override
    public String aplicarPlantilla(String mensaje) {
        return "[Generico] - " + mensaje + " este mensaje es " + estilo;
    }

    @Override
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
