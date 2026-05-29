package org.derekgonzalez.view;

import java.util.List;
import java.util.Scanner;
import org.derekgonzalez.model.DetallesOrdenes;

public class DetallesOrdenesView {
    private final Scanner leer = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE DETALLES DE ÓRDENES ---");
        System.out.println("1. Asignar repuesto/material a una Orden");
        System.out.println("2. Ver listado de repuestos utilizados");
        System.out.println("6. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(leer.nextLine());
    }

    public int solicitaIdOrden() {
        System.out.print("Ingrese el ID de la Orden de Servicio: ");
        return Integer.parseInt(leer.nextLine());
    }

    public long solicitaCodigoRepuesto() {
        System.out.print("Ingrese el Código del repuesto a utilizar: ");
        return Long.parseLong(leer.nextLine());
    }

    public int solicitaCantidad() {
        System.out.print("Ingrese la cantidad de unidades utilizadas: ");
        return Integer.parseInt(leer.nextLine());
    }

    public double solicitaPrecioMomento() {
        System.out.print("Ingrese el precio de venta actual: Q");
        return Double.parseDouble(leer.nextLine());
    }

    public void mostrarTodos(List<DetallesOrdenes> lista) {
        System.out.println("\n+++ DESGLOSE DE REPUESTOS EN ÓRDENES +++");
        for (DetallesOrdenes d : lista) {
            System.out.println("Detalle ID: " + d.getIdDetalle() 
                + " | Orden ID: " + d.getIdOrden() 
                + " | Repuesto Cód: " + d.getCodigoRepuesto() 
                + " | Cantidad: " + d.getCantidadUsada()
                + " | Precio: Q" + d.getPrecioMomento());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}