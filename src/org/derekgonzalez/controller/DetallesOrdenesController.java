package org.derekgonzalez.controller;

import org.derekgonzalez.model.dao.DetallesOrdenesDAO;
import org.derekgonzalez.model.dao.DetallesOrdenesDAOImpl;
import org.derekgonzalez.model.DetallesOrdenes;
import org.derekgonzalez.view.DetallesOrdenesView;
import java.util.List;

public class DetallesOrdenesController {
    private final DetallesOrdenesView vista;
    private final DetallesOrdenesDAO dao;

    public DetallesOrdenesController(DetallesOrdenesView vista) {
        this.vista = vista;
        this.dao = new DetallesOrdenesDAOImpl();
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
            int idOrden = vista.solicitaIdOrden();
            long codigoRepuesto = vista.solicitaCodigoRepuesto();
            int cantidad = vista.solicitaCantidad();
            double precio = vista.solicitaPrecioMomento();

            DetallesOrdenes nuevoDetalle = new DetallesOrdenes(idOrden, codigoRepuesto, cantidad, precio);
            boolean exito = dao.insertar(nuevoDetalle);

            if (exito) {
                vista.mostrarMensaje("¡Repuesto cargado con éxito a la Orden de Servicio!");
            } else {
                vista.mostrarMensaje("ERROR: Asegúrese de que el ID de Orden y el Código de Repuesto existan en el sistema.");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("ERROR en formatos de entrada: " + e.getMessage());
        }
    }

    private void listar() {
        List<DetallesOrdenes> lista = dao.listar();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("NO SE ENCONTRARON REGISTROS DE REPUESTOS ASIGNADOS");
        } else {
            vista.mostrarTodos(lista);
        }
    }
}