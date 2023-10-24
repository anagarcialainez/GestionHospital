public class Cita {
    private static int contadorCitas = 0;
    private final int numeroCita;
    private final String fecha;
    private final String hora;
    private final Medico medico;

    public Cita(String fecha, String hora, Medico medico) {
        this.numeroCita = ++contadorCitas;
        this.fecha = fecha;
        this.hora = hora;
        this.medico = medico;
    }

    public int getNumeroCita() {
        return numeroCita;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public Medico getMedico() {
        return medico;
    }

}
