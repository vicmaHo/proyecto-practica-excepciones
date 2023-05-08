package model;

import java.util.ArrayList;

public class Modelo {
    // Creo los dos arrays que requiero
    private ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    private ArrayList<Pelicula> peliculasSeleccionadas = new ArrayList<>();

    // El consctructor se encarga de crear objetos Pelicula y agregarlos a la lista
    public Modelo() {
        Pelicula pelicula1 = new Pelicula("Duro de matar", "Luchar hasta la muerte","Accion", 135);
        peliculas.add(pelicula1);

        Pelicula pelicula2 = new Pelicula("Whiplash", "Intensa, emocionante, impactante.","Drama", 95);
        peliculas.add(pelicula2);

        Pelicula pelicula3 = new Pelicula("Masacre en texas", "Mucho gore","Drama", 90);
        peliculas.add(pelicula3);
        
        Pelicula pelicula4 = new Pelicula("A la deriva", "Un huracan devastador","Romance", 96);
        peliculas.add(pelicula4);

        Pelicula pelicula5 = new Pelicula("A dos metros de ti", "Una enfermedad prohibe todo","Romance", 117);
        peliculas.add(pelicula5);

        Pelicula pelicula6 = new Pelicula("Kimi no na wa", "Cambiando de cuerpo","Romance", 112);
        peliculas.add(pelicula6);

        Pelicula pelicula7 = new Pelicula("Interestelar", "Un viaje muy largo","Drama", 169);
        peliculas.add(pelicula7);

        Pelicula pelicula8 = new Pelicula("El camino hacia el dorado", "Una ciudad de oro","Accion", 89);
        peliculas.add(pelicula8);

        Pelicula pelicula9 = new Pelicula("Avatar", "Explorando","Accion", 189);
        peliculas.add(pelicula9);
    }
    public ArrayList<Pelicula> getPeliculas(){
        return peliculas;
    }

    public void mostrarPeliculas(){
        for (Pelicula pelicula : peliculas) {
            pelicula.mostrarInformacion();
        }
    }

    // Agrego una pelicula al arrayList de peliculas selccionadas
    public void agregarPeliculasAlCarrito(Pelicula pelicula){
        peliculasSeleccionadas.add(pelicula);
    }

    public ArrayList<Pelicula> getPeliculasSeleccionadas(){
        return peliculasSeleccionadas;
    }

    //Extraigo el costo total de las peliculas seleccionadas
    public int costoTotal(){
        int total = 0;
        total = peliculasSeleccionadas.size() * Pelicula.PRECIO;
        return total;
    }
    // Extraigo la duración total de las peliculas seleccionadas
    public int duracionTotal(){
        int duracionTotal = 0;
        for (Pelicula pelicula : peliculasSeleccionadas) {
            duracionTotal += pelicula.getDuracion();
        }
        return duracionTotal;
    }

    // Borro los datos de las peliculas seleccionadas
    public void elimiarDatos(){
        peliculasSeleccionadas.clear();
    }
}
