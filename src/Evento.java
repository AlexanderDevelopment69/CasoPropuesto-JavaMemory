import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Evento {
    private int id;
    private String nombre;
    private Date fecha;
    private String direccion;
    private int capacidad;
    private Categoria categoria;
    private int duracion;
    private double costo;
    private Expositor expositor;



    // Constructor, getters y setters


    public Evento(int id, String nombre, Date fecha, String direccion, int capacidad, Categoria categoria, int duracion, double costo, Expositor expositor) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.categoria = categoria;
        this.duracion = duracion;
        this.costo = costo;
        this.expositor = expositor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Expositor getExpositor() {
        return expositor;
    }

    public void setExpositor(Expositor expositor) {
        this.expositor = expositor;
    }


    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", direccion='" + direccion + '\'' +
                ", capacidad=" + capacidad +
                ", categoria=" + categoria +
                ", duracion=" + duracion +
                ", costo=" + costo +
                ", expositor=" + expositor +
                '}';
    }
}