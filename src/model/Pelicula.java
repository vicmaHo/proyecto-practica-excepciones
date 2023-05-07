package model;

public class Pelicula {
    public static final int PRECIO = 10000;
    // Atributos
    private String nombre;
    private String descripcion;
    private String genero;
    private int duracion;

    //  Constructores
    public Pelicula(){
        nombre = "";
        descripcion = "";
        genero = "";
        duracion = 0;
    }

    public Pelicula(String nombre, String descripcion,String genero, int duracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.genero = genero;
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
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
