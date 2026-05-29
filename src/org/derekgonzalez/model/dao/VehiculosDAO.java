package org.derekgonzalez.model.dao;

import java.util.List;
import org.derekgonzalez.model.Vehiculos;

public interface VehiculosDAO {
    public boolean insertar(Vehiculos vehiculo);
    public List<Vehiculos> listar();
    public Vehiculos buscar(String placa);
}