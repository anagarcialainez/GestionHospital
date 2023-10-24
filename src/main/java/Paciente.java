import java.util.*;

public class Paciente extends Persona {
    private static int contadorPacientes=0;
    private final int numeroHospital;
    private List<Cita> citas = new ArrayList<>();
    private List<String> diagnosticos = new ArrayList<>();

    public Paciente(String nombre){
        super(nombre, "0098766H");
        this.numeroHospital = ++ contadorPacientes;
    }

    public void asignarCita(Cita cita){
        citas.add(cita);
    }

    public void anularCita(int numeroCita){
        if(numeroCita >= 0 && numeroCita<citas.size()){
            citas.remove(numeroCita);
        }else{
            throw new IllegalArgumentException("Número de cita inválido");
        }
    }

    public List<Cita> consultarCitas(){
        return citas;
    }

    public List<String> getDiagnosticos() {
        return diagnosticos;
    }
}
