public class FireBasePlantilla implements Plantilla {

    private String estilo;

    @Override
    public String aplicarPlantilla(String mensaje) {
        return mensaje;
    }

    @Override
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
