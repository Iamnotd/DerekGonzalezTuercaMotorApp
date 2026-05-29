package org.derekgonzalez.model.dao;

import java.util.List;
import org.derekgonzalez.model.Clientes;

public interface ClientesDAO {
    public boolean insertar(Clientes clientes);
    public List<Clientes> listar();
    public Clientes buscar(long cui);
    
    // IMPORTANTE: Estos dos métodos deben estar declarados aquí para que ClientesDAOImpl no falle
    public List<Clientes> buscarPorDireccion(String direccion);
    public List<Clientes> buscarPorTelefono(String telefono);
    
    public boolean actualizar(Clientes clientes);
    public boolean eliminar(long cui);
}