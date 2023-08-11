import config.Configuracion;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    //    private static EventoDAO eventoDAO = new EventoDAOMemory();
    static EventoDAO eventoDAO;


    public static void main(String[] args) {

        String rutaConfiguracion = "config.properties"; // Ruta relativa al archivo config.properties
        Configuracion config = new Configuracion(rutaConfiguracion);
        String tipoAlmacenamiento = config.obtenerTipoAlmacenamiento();

        // Utilizar la configuración para decidir qué tipo de almacenamiento usar
        switch (tipoAlmacenamiento) {
            case "memoria":
                eventoDAO = new EventoDAOMemory();
                break;
            case "archivos":
//                eventoDAO = new EventoDAOFile();
                break;
            case "basedatos":
//                eventoDAO = new EventoDAOBaseDatos();
                break;
            default:
                System.out.println("Tipo de almacenamiento no válido.");
        }


        //Backup generado cada 10 segundos durante 1 minuto
        BackupThread backupThread = new BackupThread(eventoDAO);
        backupThread.start();


        //Implementacion del menu principal
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    operacionesEvento();
                    break;
                case 2:
                    consultasEvento();
                    break;
                case 3:
                    Expositor.crearExpositor();
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }


    }


    // Método para mostrar el menú
    private static void mostrarMenu() {
        System.out.println("== == == == == == == == == ==");
        System.out.println("==         MENU            ==");
        System.out.println("== 1. Operaciones Evento   ==");
        System.out.println("== 2. Consultas evento     ==");
        System.out.println("== 3. Crear expositor      ==");
        System.out.println("== 5. Salir                ==");
        System.out.println("== == == == == == == == == ==");
        System.out.print("Seleccione una opción: ");
    }

    private static void operacionesEvento() {

        System.out.println("== == == == == == == == == ==");
        System.out.println("==   OPERACIONES EVENTOS   ==");
        System.out.println("== 1. Crear evento         ==");
        System.out.println("== 2. Actualizar evento    ==");
        System.out.println("== 3. Mostrar eventos      ==");
        System.out.println("== 4. Eliminar evento      ==");
        System.out.println("== 5. Regresar al menu     ==");
        System.out.println("== == == == == == == == == ==");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                eventoDAO.crearEvento();
                break;
            case 2:
                eventoDAO.actualizarEvento();
                break;
            case 3:
                eventoDAO.mostrarTodosLosEventos();
                break;
            case 4:
                eventoDAO.eliminarEvento();
                break;
            case 5:
                mostrarMenu();
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }

    }


    private static void consultasEvento() {
        System.out.println("== == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==");
        System.out.println("==  EVENTOS:                                                                                                                        ==");
        System.out.println("== 1.Mostrar lista de eventos ordenados por fecha ascendente y descendente                                                          ==");
        System.out.println("== 2.Mostrar lista de eventos filtrados por fechas con rango (fecha inicial y fecha final)                                          ==");
        System.out.println("== 3.Mostrar el nombre, mes, día, día de semana del evento con capacidad máxima y mínima                                            ==");
        System.out.println("== 4.Mostrar el promedio, mínimo y máximo de costos de los eventos. La cantidad de eventos superiores al costo promedio             ==");
        System.out.println("== 5.El día de la semana y el mes en el que se hacen más eventos                                                                    ==");
        System.out.println("== 6.Las cantidades de eventos por día y por mes                                                                                    ==");
        System.out.println("== 7.Lista de eventos del periodo 2020-Q3                                                                                           ==");
        System.out.println("== 8.Regresar al menu                                                                                                               ==");
        System.out.println("== == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==");
        System.out.print(" Seleccione una opción: ");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                eventoDAO.mostrarEventosOrdenadosPorFecha();
                break;
            case 2:
                eventoDAO.filtrarEventosPorRangoDeFechas();
                break;
            case 3:
                eventoDAO.mostrarEventosCapacidadMinMax();
                break;
            case 4:
                eventoDAO.mostrarEstadisticasCostos();
                break;
            case 5:
                eventoDAO.mostrarDiaSemanaMesMasEventos();
                break;
            case 6:
                eventoDAO.mostrarCantidadesEventosPorDiaMes();
                break;
            case 7:
                eventoDAO.mostrarEventosPorPeriodo();
                break;
            case 8:
                mostrarMenu();
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }

    }


}
