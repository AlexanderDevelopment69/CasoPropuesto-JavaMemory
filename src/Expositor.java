import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expositor {
    private String codigo;
    private String nombre;
    private String apellidos;
    private double sueldo;
    private String correo;
    private static List<Expositor> expositores = new ArrayList<>();

    // Constructor, getters y setters
    // ...

    public Expositor(String codigo, String nombre, String apellidos, double sueldo, String correo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldo = sueldo;
        this.correo = correo;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public static List<Expositor> getExpositores() {
        return expositores;
    }

    public static void setExpositores(List<Expositor> expositores) {
        Expositor.expositores = expositores;
    }

    static void crearExpositor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creación de nuevo expositor:");

        // Solicitar entrada de datos al usuario
        System.out.print("Ingrese el código del expositor: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese el nombre del expositor: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese los apellidos del expositor: ");
        String apellidos = scanner.nextLine();

        System.out.print("Ingrese el sueldo del expositor: ");
        double sueldo = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese el correo del expositor: ");
        String correo = scanner.nextLine();

        // Crear un nuevo expositor
        Expositor expositor = new Expositor(codigo, nombre, apellidos, sueldo, correo);

        // Agregar el expositor a la lista de expositores
        expositores.add(expositor);
        System.out.println("Expositor creado exitosamente.");
    }


    public static Expositor seleccionarExpositor() {
        Scanner scanner = new Scanner(System.in);
        Expositor expositor = null;
        boolean expositorValido = false;
        while (!expositorValido) {
            System.out.print("Ingrese el código del expositor: ");
            String codigoExpositor = scanner.nextLine();
            expositor = buscarExpositorPorCodigo(codigoExpositor);
            if (expositor == null) {
                System.out.println("Expositor no encontrado. Intente nuevamente.");
            } else {
                expositorValido = true;
            }
        }
        return expositor;
    }

    private static Expositor buscarExpositorPorCodigo(String codigo) {
        for (Expositor expositor : expositores) {
            if (expositor.getCodigo().equals(codigo)) {
                return expositor;
            }
        }
        System.out.println("Expositor no encontrado.");
        return null;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    @Override
    public String toString() {
        return "Expositor{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", sueldo=" + sueldo +
                ", correo='" + correo + '\'' +
                '}';
    }
}