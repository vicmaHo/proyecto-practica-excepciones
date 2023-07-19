

import controller.Controlador;
import model.Modelo;
import view.InterfazPelicula;
import view.Page1;
import view.Page2;

public class App {

    public static void main(String[] args) throws Exception {

        Modelo model = new Modelo();
        InterfazPelicula interfazPelicula = new InterfazPelicula();
        Page1 page1 = new Page1();
        Page2 page2 = new Page2();

        // Agrego las interfaces y el modelo, inicio
        Controlador controller = new Controlador(interfazPelicula, page1, page2, model);
        controller.iniciar();
        interfazPelicula.setVisible(true);
    }
}
