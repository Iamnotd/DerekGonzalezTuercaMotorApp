package org.derekgonzalez.controller;

import org.derekgonzalez.model.dao.ClientesDAO;
import org.derekgonzalez.model.dao.ClientesDAOImpl;
import org.derekgonzalez.model.Clientes;
import org.derekgonzalez.view.ClientesView;
import java.util.List;

public class ClientesController {
    private final ClientesView vista;
    private final ClientesDAO dao;

    public ClientesController(ClientesView vista) {
        this.vista = vista;
        this.dao = new ClientesDAOImpl();
    }
    
    public void iniciar(){
        int opcion;
        do {            
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 2:
                    listar();
                    break;
                case 6:
                    System.out.println("Si hay");
                    break;
                default:
                    System.out.println("No hay");
            }
        } while (opcion != 6);
    }
    
    private void listar(){
        List<Clientes> lista = dao.listar();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("NO HAY CLIENTES");
        } else {
            vista.mostrarTodos(lista);
        }
    }
}
