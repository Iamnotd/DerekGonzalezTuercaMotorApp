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

    public void iniciar() {
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
                case 4:
                    buscarPorDireccion();
                    break;
                case 5:
                    buscarPorTelefono();
                    break;
                case 6:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);
    }

    private void guardar() {
        try {
            long cui = vista.solicitaCui();
            String nombre = vista.solicitaNombre();
            String apellido = vista.solicitaApellido();
            String direccion = vista.solicitaDireccion();
            String telefono = vista.solicitaTelefono();

            Clientes nuevoCliente = new Clientes(cui, nombre, apellido, direccion, telefono);
            boolean exito = dao.insertar(nuevoCliente);

            if (exito) {
                vista.mostrarMensaje("¡Cliente registrado con éxito!");
            } else {
                vista.mostrarMensaje("ERROR: No se pudo registrar al cliente.");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("ERROR en los datos: " + e.getMessage());
        }
    }

    private void listar() {
        List<Clientes> lista = dao.listar();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("NO HAY CLIENTES REGISTRADOS");
        } else {
            vista.mostrarTodos(lista);
        }
    }

    private void buscarPorCui() {
        try {
            long cui = vista.solicitaCui();
            Clientes c = dao.buscar(cui);
            if (c != null) {
                vista.mostrarDetalle(c);
            } else {
                vista.mostrarMensaje("No se encontró ningún cliente con ese CUI.");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("ERROR: CUI inválido.");
        }
    }

    private void buscarPorDireccion() {
        String direccionInput = vista.solicitaDireccion();
        List<Clientes> encontrados = dao.buscarPorDireccion(direccionInput);
        if (encontrados.isEmpty()) {
            vista.mostrarMensaje("No se encontraron clientes en esa dirección.");
        } else {
            vista.mostrarTodos(encontrados);
        }
    }

    private void buscarPorTelefono() {
        String telefonoInput = vista.solicitaTelefono();
        List<Clientes> encontrados = dao.buscarPorTelefono(telefonoInput);
        if (encontrados.isEmpty()) {
            vista.mostrarMensaje("No se encontraron clientes con ese teléfono.");
        } else {
            vista.mostrarTodos(encontrados);
        }
    }
}