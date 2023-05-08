package controller;

import model.Modelo;
import model.Pelicula;
import view.InterfazPelicula;
import view.Page1;
import view.Page2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exceptions.AlquilerException;
import exceptions.DescuentoException;

public class Controlador implements ActionListener {
    private InterfazPelicula interfazPeli;
    private Page1 page1;
    private Page2 page2;
    private Modelo model;

    public String prueba;

    public Controlador(InterfazPelicula interfazPeli, Page1 page1, Page2 page2, Modelo model) {
        this.interfazPeli = interfazPeli;
        this.page1 = page1;
        this.page2 = page2;
        this.model = model;

        // Aagrego las acciones de los elementos en page1
        this.page1.btnAgregarPelicula.addActionListener(this);
        this.page1.btnPagar.addActionListener(this);
        // Acciones de los elementos en page2
        this.page2.btnSalir.addActionListener(this);
        this.page2.txtInformacionFactura.setEditable(false);

    }

    // Metodo para inicializar la ventana principal
    public void iniciar() {
        // agrego la pagina uno al panel de contenido del jFrame, esto para que funcione
        // la page1 que estoy creando
        // como atributo en esta clase. Ademas inicia la app en la page1
        page1.setSize(610, 340);
        page1.setLocation(0, 0);

        interfazPeli.contenido.removeAll();
        interfazPeli.contenido.add(page1, BorderLayout.CENTER);
        interfazPeli.contenido.revalidate();
        interfazPeli.contenido.repaint();

        // Agrego disponibles a al combobox
        agregarPeliculasAlCombobox();

        // agrego el titulo de la interfaz
        interfazPeli.setTitle("Alquiler de pelis GOD");
        interfazPeli.setLocationRelativeTo(null);

    }

    /*
     * agrega la lista de peliculas al combobox, primero transforma los nombres a un
     * array de strings y luego
     * los agrga al comobox
     */
    public void agregarPeliculasAlCombobox() {
        ArrayList<String> peliculasDisponibles = new ArrayList<>();
        for (Pelicula pelicula : model.getPeliculas()) {
            peliculasDisponibles.add(pelicula.getNombre());
        }
        String[] peliculasArray = peliculasDisponibles.toArray(new String[peliculasDisponibles.size()]);
        page1.cbPeliculas.setModel(new javax.swing.DefaultComboBoxModel<>(peliculasArray));
    }

    /*
     * agrega las peliculas selccionadas a una lista que las muestra, primero
     * transforma los nombres de las peliculas
     * seleccionadas y despues las agrega al JList
     */
    public void agregarPeliculasALista() {
        ArrayList<String> peliculasDelCarro = new ArrayList<>();
        for (Pelicula pelicula : model.getPeliculasSeleccionadas()) {
            peliculasDelCarro.add(pelicula.getNombre());
        }
        String[] peliculasArray = peliculasDelCarro.toArray(new String[peliculasDelCarro.size()]);
        page1.lsListaPeliculas.setModel(new javax.swing.DefaultComboBoxModel<>(peliculasArray));
    }

    /*
     * Genero la informacion de la factura. Uso toda la informacion de las peliculas
     * seleccionadas, y la convierto
     * a un formato que se almacena en una variable String que posteriormente es
     * agregada al textArea
     */
    public void agregoInformacionAfactura(boolean descuento) {
        String informacion = "";
        for (Pelicula pelicula : model.getPeliculasSeleccionadas()) {
            informacion += "Nombre: " + pelicula.getNombre() + "| Descripcion: " + pelicula.getDescripcion() +
                    "| Genero: " + pelicula.getGenero() + "| Duracion " + pelicula.getDuracion() + "min";
            informacion += "\n";
        }
        informacion += "\nDuracion Total: " + model.duracionTotal() + "min\n";
        // Si el descuento es true, realiza est accion, de lo contraio no descuenta
        if (descuento){
            informacion += "Usted tiene un descuento de 5000!!\nPrecio Total: " + model.costoTotal() + "\n" + 
            "Precio con descuento: " + (model.costoTotal()-5000) + "\n";
        }else{
            informacion += "Precio Total: " + model.costoTotal() + "\n";
        }
        

        page2.txtInformacionFactura.setText(informacion);
    }

    /* Verifica  si todas las peliculas son romanticas, para usar en una excepcion */
    public boolean verificarRomanticas(){
        int cantPeliculas = model.getPeliculasSeleccionadas().size();
        int cantRomanticas = 0;
        for (Pelicula pelicula : model.getPeliculasSeleccionadas()) {
            if(pelicula.getGenero().toLowerCase().equals("romance")){
                cantRomanticas += 1;
            }
        }
        return cantPeliculas==cantRomanticas;
    }

    // Funciones de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        // agrego una pelicula cuando presiono el boton, la manda a las peliculas
        // seleccionadas en el modelo
        if (e.getSource() == page1.btnAgregarPelicula) {
            Pelicula peliculaSeleccionada = new Pelicula();
            String opcionSeleccionada = (String) page1.cbPeliculas.getSelectedItem();
            for (Pelicula pelicula : model.getPeliculas()) {
                if (opcionSeleccionada.equals(pelicula.getNombre())) {
                    peliculaSeleccionada = pelicula;
                }
            }
            model.agregarPeliculasAlCarrito(peliculaSeleccionada);
            agregarPeliculasALista();

        // Presiono el boton pagar, me manda a la pagina de la factura
        } else if (e.getSource() == page1.btnPagar) {
            boolean descuento = false;
            // Agrego las excepciones necesarias
            try {
                if(model.getPeliculasSeleccionadas().size() == 0){
                    throw new AlquilerException("Agregue peliculas antes de pagar!!");
                }
                else if(model.getPeliculasSeleccionadas().size() > 10){
                    throw new AlquilerException("No se pueden alquilar mas de 10 peliculas");
                }else if(verificarRomanticas()){
                    throw new AlquilerException("No todas las peliculas pueden ser romanticas");
                }else if(model.getPeliculasSeleccionadas().size() == 7){
                    throw new DescuentoException("Por el alquiler de 7 peliculas tendra un descuento!!");
                }
                
            } catch (AlquilerException alqE) {
                JOptionPane.showMessageDialog(interfazPeli, "Ocurrió un error: " + alqE.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                model.elimiarDatos();
                agregarPeliculasALista();
                return;
            // para poder agregar la excepcion de descuento he creado otra que realiza algo difernte, en este caso
            // transformar una varible boolena
            } catch (DescuentoException alqE){
                JOptionPane.showMessageDialog(interfazPeli, "Descuento: " + alqE.getMessage(), "Descuento", JOptionPane.INFORMATION_MESSAGE);
                descuento = true;
            }
            // Agrego la informacion al txtArea de la factura
            agregoInformacionAfactura(descuento);
            // Cambio a la pagina de la factura
            page2.setSize(610, 340);
            page2.setLocation(0, 0);
            interfazPeli.contenido.removeAll();
            interfazPeli.contenido.add(page2, BorderLayout.CENTER);
            interfazPeli.contenido.revalidate();
            interfazPeli.contenido.repaint();

        }
        // Presiono el boton salir, sale de la pagina de la factura y va a la pagina inicial. Primero 
        // muestra un mensaje y despues elimina los datos de las peliculas seleccionadas y limpia la lista
        // de la pagina de inicio
        else if (e.getSource() == page2.btnSalir) {
            JOptionPane.showMessageDialog(interfazPeli, "Muchas gracias por su compra.");
            model.elimiarDatos();
            agregarPeliculasALista(); // limpio la lista, ya  que se eliminaron los datos
            // Cambio a la pagina de inicio
            page1.setSize(610, 340);
            page1.setLocation(0, 0);
            interfazPeli.contenido.removeAll();
            interfazPeli.contenido.add(page1, BorderLayout.CENTER);
            interfazPeli.contenido.revalidate();
            interfazPeli.contenido.repaint();
        }

    }

}
