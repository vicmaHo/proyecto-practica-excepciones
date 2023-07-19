package model.dao.daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DAOException;
import model.Pelicula;
import model.dao.PeliculaDAO;

public class SqlitePeliculaDAO implements PeliculaDAO {

    // Declaro strings para preparar las instrucciones
    final String INSERT = "INSERT INTO peliculas (nombre, descripcion, genero, duracion) VALUES (?,?,?,?)";
    // Actualizare por nombre
    final String UPDATE = "UPDATE peliculas SET nombre=?, descripcion=?, genero=?, duracion=? WHERE nombre=?";
    // Eliminare por nombre
    final String DELETE = "DELETE FROM peliculas WHERE nombre=?";
    final String GETALL = "SELECT nombre, descripcion, genero, duracion FROM peliculas";
    final String GETONE = "SELECT nombre, descripcion, genero, duracion FROM peliculas WHERE nombre=?";

    // Atributo de conexion que es enviado al constructor posteriormente
    private Connection conn;

    // Constructor
    public SqlitePeliculaDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Pelicula t) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, t.getNombre());
            stat.setString(2, t.getDescripcion());
            stat.setString(3, t.getGenero());
            stat.setInt(4, t.getDuracion());
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Error no se ha guardado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error SQL", ex);

        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public void modificar(Pelicula t) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, t.getNombre());
            stat.setString(2, t.getDescripcion());
            stat.setString(3, t.getGenero());
            stat.setInt(4, t.getDuracion());
            stat.setString(5, t.getNombre());
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Error no se ha guardado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public void eliminar(Pelicula t) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setString(1, t.getNombre());
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Error no se ha guardado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    private Pelicula convertir(ResultSet rs) throws SQLException {
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        String genero = rs.getString("genero");
        int duracion = rs.getInt("duracion");
        Pelicula pelicula = new Pelicula(nombre, descripcion, genero, duracion);
        return pelicula;
    }

    @Override
    public List<Pelicula> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                peliculas.add(convertir(rs));
            }

        } catch (SQLException ex) {
            throw new DAOException("Error SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error sql", ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        return peliculas;
    }

    @Override
    public Pelicula obtener(String nombre) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Pelicula p = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setString(1, nombre);
            rs = stat.executeQuery();
            if (rs.next()) {
                p = convertir(rs);
            } else {
                throw new DAOException("No se ha encontrado el registro");
            }

        } catch (SQLException ex) {
            throw new DAOException("Error SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error sql", ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        return p;
    }

    // Pruebas de funcionamiento

    // public static void main(String[] args) throws SQLException {
    //     String url = "jdbc:sqlite:bd/bdpeliculas.db";
    //     Connection conn = null;
    //     try {
    //         conn = DriverManager.getConnection(url);
    //         PeliculaDAO dao = new SqlitePeliculaDAO(conn);
    //         Pelicula pelicula = null;
    //         pelicula = dao.obtener("Interestelar");
    //         pelicula.mostrarInformacion();

    //         // List<Pelicula> peliculas = dao.obtenerTodos();
    //         // for (Pelicula pelicula : peliculas) {
    //         // System.out.println(pelicula.getNombre());
    //         // }

    //     } catch (DAOException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     } finally {
    //         if (conn != null) {
    //             conn.close();
    //         }
    //     }
    // }

}
