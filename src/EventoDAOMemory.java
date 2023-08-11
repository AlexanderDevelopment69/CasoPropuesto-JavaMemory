import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EventoDAOMemory implements EventoDAO {
    private static List<Evento> eventos = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);


    @Override
    public void crearEvento() {
        System.out.println("Creación de nuevo evento:");

        // Solicitar entrada de datos al usuario
        System.out.print("Ingrese el ID del evento: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese el nombre del evento: ");
        String nombre = scanner.nextLine();

        Date fecha = obtenerFecha();

        System.out.print("Ingrese la dirección del evento: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese la capacidad del evento: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Categoria categoria = Categoria.seleccionarCategoria();

        System.out.print("Ingrese la duracion del evento en horas: ");
        int duracion = scanner.nextInt();


        double costo = categoria.getCosto();

        Expositor expositor = Expositor.seleccionarExpositor();

        // Crear un nuevo evento
        Evento evento = new Evento(id, nombre, fecha, direccion, capacidad, categoria, duracion, costo, expositor);

        // Agregar el evento a la lista de eventos
        eventos.add(evento);

        System.out.println("Evento creado exitosamente.");
    }

    @Override
    public void actualizarEvento() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados para actualizar.");
            return;
        }

        System.out.print("Ingrese el ID del evento que desea actualizar: ");
        int idEventoActualizar = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Evento eventoEncontrado = null;
        for (Evento evento : eventos) {
            if (evento.getId() == idEventoActualizar) {
                eventoEncontrado = evento;
                break;
            }
        }

        if (eventoEncontrado == null) {
            System.out.println("No se encontró ningún evento con el ID ingresado.");
            return;
        }

        System.out.println("Ingrese los nuevos detalles del evento:");

        System.out.print("Nombre: ");
        String nuevoNombre = scanner.nextLine();
        eventoEncontrado.setNombre(nuevoNombre);

        System.out.print("Fecha (dd/MM/yyyy): ");
        String nuevaFechaStr = scanner.nextLine();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
            Date nuevaFecha = dateFormat.parse(nuevaFechaStr);
            eventoEncontrado.setFecha(nuevaFecha);
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. El evento no se ha actualizado.");
            return;
        }

        // Resto de la actualización de detalles (duración, expositor, etc.)

        System.out.println("Evento actualizado con éxito.");


    }

    @Override
    public void eliminarEvento() {
        System.out.print("Ingrese el ID del evento que desea eliminar: ");
        int idEvento = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Evento eventoEncontrado = null;
        for (Evento evento : eventos) {
            if (evento.getId() == idEvento) {
                eventoEncontrado = evento;
                break;
            }
        }

        if (eventoEncontrado != null) {
            eventos.remove(eventoEncontrado);
            System.out.println("Evento eliminado exitosamente.");
        } else {
            System.out.println("Evento no encontrado.");
        }


    }

    @Override
    public void mostrarTodosLosEventos() {

        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        System.out.println("Lista de todos los eventos:");

        for (Evento evento : eventos) {
            System.out.println("ID: " + evento.getId());
            System.out.println("Nombre: " + evento.getNombre());
            System.out.println("Fecha: " + evento.getFecha());
            System.out.println("Duración: " + evento.getDuracion() + " horas");
            System.out.println("Expositor: " + evento.getExpositor().getNombreCompleto());
            System.out.println("Capacidad: " + evento.getCapacidad());
            System.out.println("Categoría: " + evento.getCategoria());
            System.out.println("Costo: " + evento.getCosto());
            System.out.println("-----------");
        }
    }

    @Override
    public List<Evento> obtenerTodosLosEventos() {
        return eventos;
    }

    @Override
    public Date obtenerFecha() {
        Date fecha = null;
        boolean fechaValida = false;
        while (!fechaValida) {
            System.out.print("Ingrese la fecha del evento (dd/mm/yyyy): ");
            String fechaStr = scanner.nextLine();
            try {
                fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
                fechaValida = true;
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
            }
        }
        return fecha;
    }

    @Override
    public void mostrarEventosOrdenadosPorFecha() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        List<Evento> eventosOrdenadosAscendente = new ArrayList<>(eventos);
        eventosOrdenadosAscendente.sort(Comparator.comparing(Evento::getFecha));

        List<Evento> eventosOrdenadosDescendente = new ArrayList<>(eventosOrdenadosAscendente);
        Collections.reverse(eventosOrdenadosDescendente);

        System.out.println("Eventos ordenados por fecha ascendente:");
        mostrarListaEventos(eventosOrdenadosAscendente);

        System.out.println("\nEventos ordenados por fecha descendente:");
        mostrarListaEventos(eventosOrdenadosDescendente);

    }

    @Override
    public void mostrarListaEventos(List<Evento> listaEventos) {
        for (Evento evento : listaEventos) {
            System.out.println(evento);
        }
    }

    @Override
    public void filtrarEventosPorRangoDeFechas() {
        Date fechaInicial = obtenerFecha();
        Date fechaFinal = obtenerFecha();

        System.out.println("Eventos en el rango de fechas:");
        for (Evento evento : eventos) {
            if (evento.getFecha().compareTo(fechaInicial) >= 0 && evento.getFecha().compareTo(fechaFinal) <= 0) {
                System.out.println(evento);
            }

        }
    }

    @Override
    public void mostrarEventosCapacidadMinMax() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        Evento eventoMaxCapacidad = Collections.max(eventos, Comparator.comparing(Evento::getCapacidad));
        Evento eventoMinCapacidad = Collections.min(eventos, Comparator.comparing(Evento::getCapacidad));

        System.out.println("Evento con capacidad máxima:");
        mostrarDetallesEvento(eventoMaxCapacidad);

        System.out.println("\nEvento con capacidad mínima:");
        mostrarDetallesEvento(eventoMinCapacidad);
    }

    @Override
    public void mostrarDetallesEvento(Evento evento) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(evento.getFecha());

        int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        int mes = calendar.get(Calendar.MONTH);

        String nombreDiaSemana = obtenerNombreDiaSemana(diaSemana);
        String nombreMes = obtenerNombreMes(mes);

        System.out.println("Nombre del evento: " + evento.getNombre());
        System.out.println("Mes: " + nombreMes);
        System.out.println("Día: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Día de la semana: " + nombreDiaSemana);
        System.out.println("Capacidad: " + evento.getCapacidad());
    }

    @Override
    public void mostrarEstadisticasCostos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        double costoTotal = eventos.stream().mapToDouble(Evento::getCosto).sum();
        double costoPromedio = costoTotal / eventos.size();
        double costoMinimo = eventos.stream().mapToDouble(Evento::getCosto).min().getAsDouble();
        double costoMaximo = eventos.stream().mapToDouble(Evento::getCosto).max().getAsDouble();

        long eventosSuperioresAlPromedio = eventos.stream()
                .filter(evento -> evento.getCosto() > costoPromedio)
                .count();

        System.out.println("Estadísticas de costos de eventos:");
        System.out.println("Costo promedio: " + costoPromedio);
        System.out.println("Costo mínimo: " + costoMinimo);
        System.out.println("Costo máximo: " + costoMaximo);
        System.out.println("Eventos con costo superior al promedio: " + eventosSuperioresAlPromedio);
    }

    @Override
    public void mostrarDiaSemanaMesMasEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        Map<Integer, Integer> eventosPorDiaSemana = new HashMap<>();
        Map<Integer, Integer> eventosPorMes = new HashMap<>();

        for (Evento evento : eventos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(evento.getFecha());

            int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
            int mes = calendar.get(Calendar.MONTH);

            eventosPorDiaSemana.put(diaSemana, eventosPorDiaSemana.getOrDefault(diaSemana, 0) + 1);
            eventosPorMes.put(mes, eventosPorMes.getOrDefault(mes, 0) + 1);
        }

        int diaSemanaMasEventos = obtenerMaximoValor(eventosPorDiaSemana);
        int mesMasEventos = obtenerMaximoValor(eventosPorMes);

        System.out.println("Día de la semana con más eventos: " + obtenerNombreDiaSemana(diaSemanaMasEventos));
        System.out.println("Mes con más eventos: " + obtenerNombreMes(mesMasEventos));
    }

    @Override
    public int obtenerMaximoValor(Map<Integer, Integer> mapa) {
        int maximoValor = 0;
        int maximoClave = 0;

        for (Map.Entry<Integer, Integer> entry : mapa.entrySet()) {
            if (entry.getValue() > maximoValor) {
                maximoValor = entry.getValue();
                maximoClave = entry.getKey();
            }
        }

        return maximoClave;
    }

    @Override
    public void mostrarCantidadesEventosPorDiaMes() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        Map<Integer, Integer> eventosPorDia = new HashMap<>();
        Map<Integer, Integer> eventosPorMes = new HashMap<>();

        for (Evento evento : eventos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(evento.getFecha());

            int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
            int mes = calendar.get(Calendar.MONTH);

            eventosPorDia.put(diaSemana, eventosPorDia.getOrDefault(diaSemana, 0) + 1);
            eventosPorMes.put(mes, eventosPorMes.getOrDefault(mes, 0) + 1);
        }

        System.out.println("Cantidades de eventos por día de la semana:");
        mostrarCantidades(eventosPorDia, "Día de la semana");

        System.out.println("\nCantidades de eventos por mes:");
        mostrarCantidades(eventosPorMes, "Mes");
    }

    @Override
    public void mostrarCantidades(Map<Integer, Integer> mapa, String titulo) {
        String[] nombres = titulo.equals("Día de la semana") ?
                new String[]{"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"} :
                new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        for (Map.Entry<Integer, Integer> entry : mapa.entrySet()) {
            System.out.println(nombres[entry.getKey() - 1] + ": " + entry.getValue());
        }
    }

    @Override
    public String obtenerNombreDiaSemana(int dia) {
        String[] nombresDias = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        return nombresDias[dia - 1];
    }

    @Override
    public String obtenerNombreMes(int mes) {
        String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return nombresMeses[mes];
    }

    @Override
    public void mostrarEventosPorPeriodo() {
        System.out.print("Ingrese el año para determinar en qué período se encuentra (ejemplo: 2020): ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        List<Evento> eventosPeriodo = new ArrayList<>();
        List<Evento> eventosAntiguos = new ArrayList<>();
        List<Evento> eventosNuevos = new ArrayList<>();

        for (Evento evento : eventos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(evento.getFecha());

            int eventoYear = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);

            if (eventoYear == year) {
                eventosPeriodo.add(evento);
            } else if (eventoYear < year) {
                eventosAntiguos.add(evento);
            } else {
                eventosNuevos.add(evento);
            }
        }

        String nombrePeriodo = obtenerNombrePeriodo(year);

        System.out.println("Eventos del período " + nombrePeriodo + ":");
        mostrarEventosConPeriodo(eventosPeriodo, nombrePeriodo);

        System.out.println("\nEventos antiguos (anteriores al " + nombrePeriodo + "):");
        mostrarEventosConPeriodo(eventosAntiguos, "Antiguo");

        System.out.println("\nEventos nuevos (posteriores al " + nombrePeriodo + "):");
        mostrarEventosConPeriodo(eventosNuevos, "Nuevo");
    }

    @Override
    public void mostrarEventosConPeriodo(List<Evento> listaEventos, String periodo) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat trimestreFormat = new SimpleDateFormat("MMM");

        for (Evento evento : listaEventos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(evento.getFecha());

            int month = calendar.get(Calendar.MONTH);
            String nombreTrimestre = obtenerNombreTrimestre(month);

            System.out.println("Evento: " + evento.getNombre());
            System.out.println("Fecha: " + dateFormat.format(evento.getFecha()));
            System.out.println("Período: " + periodo + " (" + nombreTrimestre + ")");
            System.out.println();
        }
    }

    @Override
    public String obtenerNombrePeriodo(int year) {
        return year + "Q" + ((Calendar.getInstance().get(Calendar.MONTH) / 3) + 1);
    }

    @Override
    public String obtenerNombreTrimestre(int mes) {
        return switch (mes) {
            case Calendar.JANUARY, Calendar.FEBRUARY, Calendar.MARCH -> "Q1";
            case Calendar.APRIL, Calendar.MAY, Calendar.JUNE -> "Q2";
            case Calendar.JULY, Calendar.AUGUST, Calendar.SEPTEMBER -> "Q3";
            default -> "Q4";
        };
    }


}
