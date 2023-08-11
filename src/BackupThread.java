import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BackupThread extends Thread {
//    private List<Evento> eventos;


    private EventoDAO eventoDAO;

    private volatile boolean running = true;


    public BackupThread(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }


    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + TimeUnit.MINUTES.toMillis(1);

        while (running && System.currentTimeMillis() < endTime) {
            realizarBackup();
            try {
                TimeUnit.SECONDS.sleep(10); // Esperar 10 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void detener() {
        running = false;
    }

    private void realizarBackup() {

        // Crear la carpeta "eventos" si no existe
        File eventosFolder = new File("C:/Eventos");
        if (!eventosFolder.exists()) {
            eventosFolder.mkdirs();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String nombreArchivo = "evento-" + sdf.format(new Date()) + ".txt";

        try (FileWriter writer = new FileWriter(new File("C:/Eventos", nombreArchivo))) {
            // Obtener eventos del DAO y realizar el respaldo
            for (Evento evento : eventoDAO.obtenerTodosLosEventos()) {
                writer.write(evento.toString() + System.lineSeparator());
            }
//                System.out.println("Copia de seguridad realizada: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//        System.out.println("Hilo de copia de seguridad detenido después de 1 minuto.");


}


