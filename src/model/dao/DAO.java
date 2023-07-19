package model.dao;

import java.util.List;

public interface DAO<T> {
    
    public void insertar(T t);
    public void modificar(T t);
    public void eliminar(T t);
    public List<T> obtenerTodos();
    public T obtener(int id);
}
