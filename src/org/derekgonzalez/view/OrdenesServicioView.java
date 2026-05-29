package org.derekgonzalez.view;

import java.util.List;
import java.util.Scanner;
import org.derekgonzalez.model.OrdenesServicio;
import java.sql.Date;

public class OrdenesServicioView {
    private final Scanner leer = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE ÓRDENES DE SERVICIO ---");
        System.out.println("1. Crear nueva orden de servicio");
        System.out.println("2. Listar todas las órdenes");
        System.out.println("3. Buscar orden por ID");
        System.out.println("6. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(leer.nextLine());
    }

    public int solicitaIdOrden() {
        System.out.print("Ingrese el ID de la orden: ");
        return Integer.parseInt(leer.nextLine());
    }

    public Date solicitaFecha() {
        System.out.print("Ingrese la fecha (Formato: YYYY-MM-DD): ");
        return Date.valueOf(leer.nextLine());
    }

    public double solicitaPresupuesto() {
        System.out.print("Ingrese el presupuesto inicial: ");
        return Double.parseDouble(leer.nextLine());
    }

    public String solicitaPlaca() {
        System.out.print("Ingrese la placa del vehículo: ");
        return leer.nextLine();
    }

    public long solicitaNoMecanico() {
        System.out.print("Ingrese el número de empleado del mecánico: ");
        return Long.parseLong(leer.nextLine());
    }

    public String solicitaHoras() {
        System.out.print("Ingrese las horas dedicadas (HH:MM:SS): ");
        return leer.nextLine();
    }

    // CORREGIDO: Aquí ya no hay UnsupportedOperationException, recorre e imprime la lista real
    public void mostrarTodos(List<OrdenesServicio> lista) {
        System.out.println("\n+++ HISTORIAL DE ÓRDENES DE SERVICIO +++");
        for (OrdenesServicio o : lista) {
            System.out.println("ID: " + o.getIdOrden() 
                + " | Fecha: " + o.getFechaIngreso() 
                + " | Vehículo: " + o.getPlacaVehiculo() 
                + " | Mecánico ID: " + o.getNoMecanico() 
                + " | Presupuesto: Q" + o.getPresupuesto());
        }
    }

    public void mostrarDetalle(OrdenesServicio o) {
        System.out.println("\n+++ DETALLE DE LA ORDEN +++");
        System.out.println("ID ÓRDEN: " + o.getIdOrden());
        System.out.println("FECHA: " + o.getFechaIngreso());
        System.out.println("PRESUPUESTO: Q" + o.getPresupuesto());
        System.out.println("PLACA: " + o.getPlacaVehiculo());
        System.out.println("MECÁNICO ID: " + o.getNoMecanico());
        System.out.println("TIEMPO: " + o.getHorasDedicadas());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}