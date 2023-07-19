package model.dao;

import java.util.List;

import exceptions.DAOException;

public interface DAO<T> {
    
    public void insertar(T t) throws DAOException;
    public void modificar(T t) throws DAOException;
    public void eliminar(T t) throws DAOException;
    public List<T> obtenerTodos() throws DAOException;
    public T obtener(String nombre) throws DAOException;
}
