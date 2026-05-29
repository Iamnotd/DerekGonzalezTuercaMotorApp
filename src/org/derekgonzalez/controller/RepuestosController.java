package org.derekgonzalez.controller;

import org.derekgonzalez.model.dao.RepuestosDAO;
import org.derekgonzalez.model.dao.RepuestosDAOImpl;
import org.derekgonzalez.model.Repuestos;
import org.derekgonzalez.view.RepuestosView;
import java.util.List;

public class RepuestosController {
    private final RepuestosView vista;
    private final RepuestosDAO dao;

    public RepuestosController(RepuestosView vista) {
        this.vista = vista;
        this.dao = new RepuestosDAOImpl();
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
                    buscarPorCodigo();
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
            String nombre = vista.solicitaNombre();
            double precio = vista.solicitaPrecio();
            int stock = vista.solicitaStock();

            Repuestos nuevoRepuesto = new Repuestos(nombre, precio, stock);
            boolean exito = dao.insertar(nuevoRepuesto);

            if (exito) {
                vista.mostrarMensaje("¡Repuesto registrado e integrado al inventario correctamente!");
            } else {
                vista.mostrarMensaje("ERROR: No se pudo efectuar el registro en la BD.");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("ERROR en los formatos ingresados: " + e.getMessage());
        }
    }

    private void listar() {
        List<Repuestos> lista = dao.listar();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("EL INVENTARIO DE REPUESTOS SE ENCUENTRA VACÍO");
        } else {
            vista.mostrarTodos(lista);
        }
    }

    private void buscarPorCodigo() {
        try {
            long codigo = vista.solicitaCodigoRepuesto();
            Repuestos r = dao.buscar(codigo);

            if (r != null) {
                vista.mostrarDetalle(r);
            } else {
                vista.mostrarMensaje("No existe ningún repuesto registrado con el código provisto.");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("ERROR: Formato de entrada no válido. " + e.getMessage());
        }
    }
}