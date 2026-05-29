package org.derekgonzalez.model.dao;

import java.util.List;
import org.derekgonzalez.model.Mecanicos;

public interface MecanicosDAO {
    public boolean insertar(Mecanicos mecanico);
    public List<Mecanicos> listar();
    public Mecanicos buscar(long noEmpleado);
}