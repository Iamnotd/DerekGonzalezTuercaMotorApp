package org.derekgonzalez.controller;

import org.derekgonzalez.model.dao.MecanicosDAO;
import org.derekgonzalez.model.dao.MecanicosDAOImpl;
import org.derekgonzalez.model.Mecanicos;
import org.derekgonzalez.view.MecanicosView;
import java.util.List;

public class MecanicosController {
    private final MecanicosView vista;
    private final MecanicosDAO dao;

    public MecanicosController(MecanicosView vista) {
        this.vista = vista;
        this.dao = new MecanicosDAOImpl();
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
                    buscarPorNoEmpleado();
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
            long noEmpleado = vista.solicitaNoEmpleado();
            String nombre = vista.solicitaNombre();
            String apellido = vista.solicitaApellido();

            Mecanicos nuevoMecanico = new Mecanicos(noEmpleado, nombre, apellido);
            boolean exito = dao.insertar(nuevoMecanico);

            if (exito) {
                vista.mostrarMensaje("¡Mecánico registrado con éxito!");
            } else {
                vista.mostrarMensaje("ERROR: No se pudo registrar el mecánico.");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("ERROR en los datos ingresados: " + e.getMessage());
        }
    }

    private void listar() {
        List<Mecanicos> lista = dao.listar();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("NO HAY MECÁNICOS REGISTRADOS");
        } else {
            vista.mostrarTodos(lista);
        }
    }

    private void buscarPorNoEmpleado() {
        try {
            long noEmpleado = vista.solicitaNoEmpleado();
            Mecanicos m = dao.buscar(noEmpleado);

            if (m != null) {
                vista.mostrarDetalle(m);
            } else {
                vista.mostrarMensaje("No se encontró ningún mecánico con el número de empleado ingresado.");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("ERROR: " + e.getMessage());
        }
    }
}