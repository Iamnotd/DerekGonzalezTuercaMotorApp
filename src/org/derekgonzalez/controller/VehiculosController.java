package org.derekgonzalez.controller;

import org.derekgonzalez.model.dao.VehiculosDAO;
import org.derekgonzalez.model.dao.VehiculosDAOImpl;
import org.derekgonzalez.model.Vehiculos;
import org.derekgonzalez.view.VehiculosView;
import java.util.List;

public class VehiculosController {
    private final VehiculosView vista;
    private final VehiculosDAO dao;

    public VehiculosController(VehiculosView vista) {
        this.vista = vista;
        this.dao = new VehiculosDAOImpl();
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
                    buscarPorPlaca();
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
            String placa = vista.solicitaPlaca();
            String marca = vista.solicitaMarca();
            String color = vista.solicitaColor();
            String modelo = vista.solicitaModelo();
            // CORREGIDO: Aquí estaba el error de dedo
            long cui = vista.solicitaCuiCliente(); 

            Vehiculos nuevoVehiculo = new Vehiculos(placa, marca, color, modelo, cui);
            boolean exito = dao.insertar(nuevoVehiculo);

            if (exito) {
                vista.mostrarMensaje("¡Vehículo registrado con éxito!");
            } else {
                vista.mostrarMensaje("ERROR: No se pudo registrar el vehículo (Verifique el CUI del cliente).");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("ERROR en los datos ingresados: " + e.getMessage());
        }
    }

    private void listar() {
        List<Vehiculos> lista = dao.listar();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("NO HAY VEHÍCULOS REGISTRADOS");
        } else {
            vista.mostrarTodos(lista);
        }
    }

    private void buscarPorPlaca() {
        String placa = vista.solicitaPlaca();
        Vehiculos v = dao.buscar(placa);

        if (v != null) {
            vista.mostrarDetalle(v);
        } else {
            vista.mostrarMensaje("No se encontró ningún vehículo con la placa ingresada.");
        }
    }
}