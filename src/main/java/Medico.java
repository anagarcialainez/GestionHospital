public class Medico extends Persona {
    private final String especialidad;
    private final String sala;

    public Medico(String nombre, String identificacion, String especialidad, String sala) {
        super(nombre, identificacion);
        this.especialidad = especialidad;
        this.sala = sala;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getSala() {
        return sala;
    }
}
