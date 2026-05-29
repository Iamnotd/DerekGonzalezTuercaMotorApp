package org.derekgonzalez.controller;

import org.derekgonzalez.model.dao.OrdenesServicioDAO;
import org.derekgonzalez.model.dao.OrdenesServicioDAOImpl;
import org.derekgonzalez.model.OrdenesServicio;
import org.derekgonzalez.view.OrdenesServicioView;
import java.sql.Date;
import java.util.List;

public class OrdenesServicioController {
    private final OrdenesServicioView vista;
    private final OrdenesServicioDAO dao;

    public OrdenesServicioController(OrdenesServicioView vista) {
        this.vista = vista;
        this.dao = new OrdenesServicioDAOImpl();
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
                    buscarPorId();
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
            Date fecha = vista.solicitaFecha();
            double presupuesto = vista.solicitaPresupuesto();
            String placa = vista.solicitaPlaca();
            long mecanico = vista.solicitaNoMecanico();
            String horas = vista.solicitaHoras();

            OrdenesServicio nuevaOrden = new OrdenesServicio(fecha, presupuesto, placa, mecanico, horas);
            boolean exito = dao.insertar(nuevaOrden);

            if (exito) {
                vista.mostrarMensaje("¡Orden de servicio aperturada exitosamente!");
            } else {
                vista.mostrarMensaje("ERROR: No se pudo crear la orden. Revise que la placa del vehículo y el ID del mecánico existan.");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("ERROR en el formato de datos ingresados: " + e.getMessage());
        }
    }

    private void listar() {
        List<OrdenesServicio> lista = dao.listar();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("NO HAY ÓRDENES DE SERVICIO REGISTRADAS");
        } else {
            vista.mostrarTodos(lista);
        }
    }

    private void buscarPorId() {
        try {
            int id = vista.solicitaIdOrden();
            OrdenesServicio o = dao.buscar(id);

            if (o != null) {
                vista.mostrarDetalle(o);
            } else {
                vista.mostrarMensaje("No se encontró ninguna orden con el ID especificado.");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("ERROR: Entrada inválida. " + e.getMessage());
        }
    }
}