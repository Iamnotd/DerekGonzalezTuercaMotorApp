package org.derekgonzalez.model.dao;

import java.util.List;
import org.derekgonzalez.model.Repuestos;

public interface RepuestosDAO {
    public boolean insertar(Repuestos repuesto);
    public List<Repuestos> listar();
    public Repuestos buscar(long codigo);
}