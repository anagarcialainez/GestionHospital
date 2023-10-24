import java.util.*;

public class MainHospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Medico> medicos = new ArrayList<>();
        medicos.add(new Medico("Dr. García", "MG001", "Medicina General", "Sala 1"));
        medicos.add(new Medico("Dr. Rodas", "MT005", "Traumatología", "Sala 8T"));
        medicos.add(new Medico("Dr. Parra", "MN023", "Neurología", "Sala U"));

        Map<Integer, Paciente> pacientes = new HashMap<>();
        Paciente paciente1 = new Paciente("Juan Pérez");
        Paciente paciente2 = new Paciente("María Rodríguez");
        Paciente paciente3 = new Paciente("Carlos González");

        pacientes.put(1, paciente1);
        pacientes.put(2, paciente2);
        pacientes.put(3, paciente3);


        while (true) {
            System.out.println("****Menú Hospital****\n " +
                    "1. Dar de alta un paciente.\n " +
                    "2. Asignar una cita.\n " +
                    "3. Anular una cita.\n " +
                    "4. Consultar las citas de un paciente.\n " +
                    "5. Consultar las citas de un médico.\n " +
                    "6. Salir.\n " +
                    "Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Para consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombrePaciente = scanner.nextLine();
                    Paciente nuevoPaciente = new Paciente(nombrePaciente);

                    // El número de paciente se asigna automáticamente al crear el paciente
                    // basándose en la cantidad actual de pacientes en el mapa.

                    // Agregar al paciente al map de pacientes
                    pacientes.put(pacientes.size() + 1, nuevoPaciente);
                    System.out.println("Paciente dado de alta con número: " + (pacientes.size()));
                    break;
                case 2:
                    // Lógica para asignar una cita al paciente
                    System.out.print("Número del paciente: ");
                    int pacienteId = scanner.nextInt();
                    Paciente paciente = pacientes.get(pacienteId);

                    if (paciente != null) {
                        // Solicitar detalles de la cita
                        System.out.print("Fecha de la cita (DD/MM/AAAA): ");
                        String fechaCita = scanner.next();
                        System.out.print("Hora de la cita (HH:MM): ");
                        String horaCita = scanner.next();

                        // Mostrar información sobre los médicos disponibles
                        System.out.println("Médicos disponibles:");
                        for (int i = 0; i < medicos.size(); i++) {
                            System.out.println(i + 1 + ". " + medicos.get(i).getNombre());
                        }

                        System.out.print("Seleccione un médico (1-" + medicos.size() + "): ");
                        int medicoSeleccionado = scanner.nextInt();

                        if (medicoSeleccionado >= 1 && medicoSeleccionado <= medicos.size()) {
                            Medico medicoAsignado = medicos.get(medicoSeleccionado - 1);

                            // Crear una nueva cita
                            Cita nuevaCita = new Cita(fechaCita, horaCita, medicoAsignado);

                            // Asignar la cita al paciente
                            paciente.asignarCita(nuevaCita);
                            System.out.println("Cita asignada con éxito.");
                        } else {
                            System.out.println("Selección de médico no válida.");
                        }
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 3:
                    // Lógica para anular una cita del paciente
                    System.out.print("Número del paciente: ");
                    pacienteId = scanner.nextInt();
                    paciente = pacientes.get(pacienteId);

                    if (paciente != null) {
                        List<Cita> citas = paciente.consultarCitas();

                        if (citas.isEmpty()) {
                            System.out.println("El paciente no tiene citas programadas.");
                        } else {
                            System.out.println("Citas del paciente:");
                            for (int i = 0; i < citas.size(); i++) {
                                Cita cita = citas.get(i);
                                System.out.println(i + 1 + ". Fecha: " + cita.getFecha() + " Hora: " + cita.getHora());
                            }

                            System.out.print("Seleccione el número de cita a anular (1-" + citas.size() + "): ");
                            int numeroCitaAAnular = scanner.nextInt();

                            if (numeroCitaAAnular >= 1 && numeroCitaAAnular <= citas.size()) {
                                // Obtener la cita a anular
                                Cita citaAAnular = citas.get(numeroCitaAAnular - 1);
                                // Anular la cita
                                paciente.anularCita(numeroCitaAAnular - 1);
                                System.out.println("Cita anulada con éxito.");
                            } else {
                                System.out.println("Selección de número de cita no válida.");
                            }
                        }
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 4:
                    //Lógica para consultar las citas de un paciente
                    System.out.print("Número del paciente: ");
                    pacienteId = scanner.nextInt();
                    paciente = pacientes.get(pacienteId);

                    if (paciente != null) {
                        List<Cita> citas = paciente.consultarCitas();

                        if (citas.isEmpty()) {
                            System.out.println("El paciente no tiene citas programadas.");
                        } else {
                            System.out.println("Citas del paciente:");
                            for (Cita cita : citas) {
                                System.out.println("Fecha: " + cita.getFecha());
                                System.out.println("Hora: " + cita.getHora());
                                System.out.println("Médico: " + cita.getMedico().getNombre());
                                System.out.println("Especialidad: " + cita.getMedico().getEspecialidad());
                                System.out.println("Sala: " + cita.getMedico().getSala());
                                System.out.println(); // Salto de línea entre citas
                            }
                        }
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 5:
                    // Lógica para consultar citas de un médico
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }

    }
}
