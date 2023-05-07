import java.util.ArrayList;

import model.Pelicula;

public class App {

    private static ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    public static void main(String[] args) throws Exception {
        
        Pelicula pelicula1 = new Pelicula("Duro de matar", "Luchar hasta la muerte", 135);
        peliculas.add(pelicula1);

        Pelicula pelicula2 = new Pelicula("Whiplash", "Un maestro y alumno dispuestos a todo", 123);
        peliculas.add(pelicula2);

        Pelicula pelicula3 = new Pelicula("Masacre en texas", "El asesino de la piel", 145);
        peliculas.add(pelicula3);

        for (Pelicula pelicula : peliculas) {
            pelicula.mostrarInformacion();
        }
    }
}
