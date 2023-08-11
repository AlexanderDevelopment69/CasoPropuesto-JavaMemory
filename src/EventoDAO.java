import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EventoDAO {


    //CRUD DE OPERACIONES
    void crearEvento();

    void actualizarEvento();

    void eliminarEvento();

    void mostrarTodosLosEventos();

    List<Evento> obtenerTodosLosEventos();

    //DEMAS FUNCIONES
    Date obtenerFecha();

    void mostrarEventosOrdenadosPorFecha();

    void mostrarListaEventos(List<Evento> listaEventos);

    void filtrarEventosPorRangoDeFechas();

    void mostrarEventosCapacidadMinMax();

    void mostrarDetallesEvento(Evento evento);

    void mostrarEstadisticasCostos();

    void mostrarDiaSemanaMesMasEventos();

    int obtenerMaximoValor(Map<Integer, Integer> mapa);

    void mostrarCantidadesEventosPorDiaMes();

    void mostrarCantidades(Map<Integer, Integer> mapa, String titulo);

    String obtenerNombreDiaSemana(int dia);

    String obtenerNombreMes(int mes);
    void mostrarEventosPorPeriodo();
    void mostrarEventosConPeriodo(List<Evento> listaEventos, String periodo);
    String obtenerNombrePeriodo(int year);
    String obtenerNombreTrimestre(int mes);
}
