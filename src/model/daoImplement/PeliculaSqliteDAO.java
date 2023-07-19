package model.daoImplement;

import java.sql.Connection;
import java.util.List;

import model.Pelicula;
import model.dao.PeliculaDAO;

public class PeliculaSqliteDAO implements PeliculaDAO{

    private Connection conn;

    public PeliculaSqliteDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Pelicula t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void modificar(Pelicula t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public void eliminar(Pelicula t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public List<Pelicula> obtenerTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodos'");
    }

    @Override
    public Pelicula obtener(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtener'");
    }
    
}
