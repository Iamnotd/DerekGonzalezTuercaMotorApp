package org.derekgonzalez.view;

import java.util.List;
import java.util.Scanner;
import org.derekgonzalez.model.Repuestos;

public class RepuestosView {
    private final Scanner leer = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE REPUESTOS ---");
        System.out.println("1. Registrar nuevo repuesto");
        System.out.println("2. Listar inventario de repuestos");
        System.out.println("3. Buscar repuesto por Código");
        System.out.println("6. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(leer.nextLine());
    }

    public long solicitaCodigoRepuesto() {
        System.out.print("Ingrese el Código (ID) del repuesto: ");
        return Long.parseLong(leer.nextLine());
    }

    public String solicitaNombre() {
        System.out.print("Ingrese la descripción/nombre del repuesto: ");
        return leer.nextLine();
    }

    public double solicitaPrecio() {
        System.out.print("Ingrese el precio unitario: Q");
        return Double.parseDouble(leer.nextLine());
    }

    public int solicitaStock() {
        System.out.print("Ingrese el stock / cantidad inicial en inventario: ");
        return Integer.parseInt(leer.nextLine());
    }

    public void mostrarTodos(List<Repuestos> lista) {
        System.out.println("\n+++ INVENTARIO ACTUAL DE REPUESTOS +++");
        for (Repuestos r : lista) {
            System.out.println("Código: " + r.getCodigo() 
                + " | Repuesto: " + r.getNombre() 
                + " | Precio: Q" + r.getPrecioUnitario() 
                + " | Stock: " + r.getStock() + " unidades");
        }
    }

    public void mostrarDetalle(Repuestos r) {
        System.out.println("\n+++ FICHA DE REPUESTO ENCONTRADO +++");
        System.out.println("CÓDIGO: " + r.getCodigo());
        System.out.println("DESCRIPCIÓN: " + r.getNombre());
        System.out.println("PRECIO UNITARIO: Q" + r.getPrecioUnitario());
        System.out.println("STOCK DISPONIBLE: " + r.getStock() + " unidades");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}