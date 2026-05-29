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
                case 1:
                    guardar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscarPorCui();
                    break;
                case 6:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida");
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

    private void guardar() {
        long cui = vista.soliciarID(); 
        String nombre = vista.solicitaNombre();
        String apellido = vista.solicitaApellido();
        String direccion = vista.solicitaDireccion();
        String telefono = vista.solicitaTelefono();

        Clientes nuevoCliente = new Clientes(cui, nombre, apellido, direccion, telefono);
        boolean exito = dao.insertar(nuevoCliente);

        if (exito) {
            vista.mostrarMensaje("¡Cliente registrado con éxito!");
        } else {
            vista.mostrarMensaje("ERROR: No se pudo registrar el cliente.");
        }
    }

    private void buscarPorCui() {
        long cui = vista.soliciarCui();
        Clientes clienteEncontrado = dao.buscar(cui);
        
        if (clienteEncontrado != null) {
            vista.mostrarCategoria(clienteEncontrado);
        } else {
            vista.mostrarMensaje("No se encontró ningún cliente con el CUI ingresado.");
        }
    }
}