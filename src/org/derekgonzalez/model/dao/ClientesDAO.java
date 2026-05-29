package org.derekgonzalez.model.dao;

import java.util.List;
import org.derekgonzalez.model.Clientes;


public interface ClientesDAO {
    
   boolean insertar(Clientes clientes);
   List<Clientes> listar();
   Clientes buscar(int Cui);
   boolean actualizar(Clientes clientes);
   boolean eliminar(int Cui);
}
