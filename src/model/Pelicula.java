package model;

public class Pelicula {
    public static final int PRECIO = 10000;

    private String nombre;
    private String descripcion;
    private int duracion;

    //  Constructor
    public Pelicula(String nombre, String descripcion, int duracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
    }

    // Setters y getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }


    public void mostrarInformacion(){
        System.out.printf(  "----------\n" +
                            "Nombre: %s\n" +
                            "Descripcion: %s\n" +
                            "Duracion: %d%n",nombre, descripcion, duracion );
    }

}
