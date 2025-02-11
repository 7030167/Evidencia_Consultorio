import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Doctor {
    private String id;
    private String nombre;
    private String especialidad;

    public Doctor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
}

class Paciente {
    private String id;
    private String nombre;
    private String telefono;

    public Paciente(String id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
}

class Cita {
    private String id;
    private String idDoctor;
    private String idPaciente;
    private String fechaHora;
    private String nombrePaciente;
    private String nombreDoctor;
    private String especialidad;

    public Cita(String id, String idDoctor, String idPaciente, String fechaHora, String nombrePaciente, String nombreDoctor, String especialidad) {
        this.id = id;
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
        this.fechaHora = fechaHora;
        this.nombrePaciente = nombrePaciente;
        this.nombreDoctor = nombreDoctor;
        this.especialidad = especialidad;
    }

    public String getId() { return id; }
    public String getIdDoctor() { return idDoctor; }
    public String getIdPaciente() { return idPaciente; }
    public String getFechaHora() { return fechaHora; }
    public String getNombrePaciente() { return nombrePaciente; }
    public String getNombreDoctor() { return nombreDoctor; }
    public String getEspecialidad() { return especialidad; }
}

class Administrador {
    private String username;
    private String password;

    public Administrador(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
}

class SistemaAdministracionCitas {
    private Map<String, Doctor> doctores = new HashMap<>();
    private Map<String, Paciente> pacientes = new HashMap<>();
    private Map<String, Cita> citas = new HashMap<>();
    private Map<String, Administrador> administradores = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public SistemaAdministracionCitas() {
        // Agregar administradores predefinidos
        administradores.put("Tecmilenio", new Administrador("Tecmilenio", "1234"));
    }

    public void agregarDoctor() {
        System.out.println("Ingrese el ID del doctor:");
        String id = scanner.nextLine();
        System.out.println("Ingrese el nombre del doctor:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la especialidad del doctor:");
        String especialidad = scanner.nextLine();
        Doctor doctor = new Doctor(id, nombre, especialidad);
        doctores.put(id, doctor);
        System.out.println("Doctor agregado exitosamente.");
        guardarDoctores();
    }

    public void agregarPaciente() {
        System.out.println("Ingrese el ID del paciente:");
        String id = scanner.nextLine();
        System.out.println("Ingrese el nombre del paciente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el teléfono del paciente:");
        String telefono = scanner.nextLine();
        Paciente paciente = new Paciente(id, nombre, telefono);
        pacientes.put(id, paciente);
        System.out.println("Paciente agregado exitosamente.");
        guardarPacientes();
    }

    public void crearCita() {
        System.out.println("Ingrese el ID de la cita:");
        String id = scanner.nextLine();
        System.out.println("Ingrese el ID del doctor:");
        String idDoctor = scanner.nextLine();
        System.out.println("Ingrese el nombre del doctor:");
        String nombreDoctor = scanner.nextLine();
        System.out.println("Ingrese la especialidad del doctor:");
        String especialidad = scanner.nextLine();
        System.out.println("Ingrese el ID del paciente:");
        String idPaciente = scanner.nextLine();
        System.out.println("Ingrese el nombre del paciente:");
        String nombrePaciente = scanner.nextLine();
        System.out.println("Ingrese la fecha y hora de la cita (YYYY-MM-DD HH:MM):");
        String fechaHora = scanner.nextLine();
        Cita cita = new Cita(id, idDoctor, idPaciente, fechaHora, nombrePaciente, nombreDoctor, especialidad);
        citas.put(id, cita);
        System.out.println("Cita creada exitosamente.");
        guardarCitas();
    }

    public boolean autenticarAdministrador() {
        System.out.println("Ingrese el nombre de usuario del administrador:");
        String username = scanner.nextLine();
        System.out.println("Ingrese la contraseña:");
        String password = scanner.nextLine();

        Administrador admin = administradores.get(username);
        if (admin != null && admin.getPassword().equals(password)) {
            System.out.println("Autenticación exitosa.");
            return true;
        } else {
            System.out.println("Autenticación fallida. Nombre de usuario o contraseña incorrectos.");
            return false;
        }
    }

    public void mostrarMenu() {
        if (!autenticarAdministrador()) {
            return;
        }

        while (true) {
            System.out.println("\nSistema de Administración de Citas");
            System.out.println("1. Dar de alta doctor");
            System.out.println("2. Dar de alta paciente");
            System.out.println("3. Crear cita");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    agregarDoctor();
                    break;
                case 2:
                    agregarPaciente();
                    break;
                case 3:
                    crearCita();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public void guardarDoctores() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("doctores.txt", true))) {
            for (Doctor doctor : doctores.values()) {
                writer.write(doctor.getId() + "," + doctor.getNombre() + "," + doctor.getEspecialidad());
                writer.newLine();
            }
            System.out.println("Información de doctores guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la información de doctores: " + e.getMessage());
        }
    }

    public void guardarPacientes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pacientes.txt", true))) {
            for (Paciente paciente : pacientes.values()) {
                writer.write(paciente.getId() + "," + paciente.getNombre() + "," + paciente.getTelefono());
                writer.newLine();
            }
            System.out.println("Información de pacientes guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la información de pacientes: " + e.getMessage());
        }
    }

    public void guardarCitas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("citas.txt", true))) {
            for (Cita cita : citas.values()) {
                writer.write(cita.getId() + "," + cita.getIdDoctor() + "," + cita.getIdPaciente() + "," + cita.getFechaHora() + "," + cita.getNombrePaciente() + "," + cita.getNombreDoctor() + "," + cita.getEspecialidad());
                writer.newLine();
            }
            System.out.println("Información de citas guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la información de citas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SistemaAdministracionCitas sistema = new SistemaAdministracionCitas();
        sistema.mostrarMenu();
    }
}
