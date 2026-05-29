package org.derekgonzalez.model.dao;

import java.util.List;
import org.derekgonzalez.model.DetallesOrdenes;

public interface DetallesOrdenesDAO {
    public boolean insertar(DetallesOrdenes detalle);
    public List<DetallesOrdenes> listar();
}