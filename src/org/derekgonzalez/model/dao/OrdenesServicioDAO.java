/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.derekgonzalez.model.dao;

import java.util.List;
import org.derekgonzalez.model.OrdenesServicio;

/**
 *
 * @author roxyl
 */
public interface OrdenesServicioDAO {

    public OrdenesServicio buscar(int id);

    public List<OrdenesServicio> listar();

    public boolean insertar(OrdenesServicio nuevaOrden);
    
}
