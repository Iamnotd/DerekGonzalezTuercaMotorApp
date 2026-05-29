package org.derekgonzalez.view;

import java.util.List;
import java.util.Scanner;
import org.derekgonzalez.model.Mecanicos;

public class MecanicosView {
    private final Scanner leer = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE MECÁNICOS ---");
        System.out.println("1. Registrar nuevo mecánico");
        System.out.println("2. Listar todos los mecánicos");
        System.out.println("3. Buscar mecánico por Número de Empleado");
        System.out.println("6. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(leer.nextLine());
    }

    public long solicitaNoEmpleado() {
        System.out.print("Ingrese el número de empleado: ");
        return Long.parseLong(leer.nextLine());
    }

    public String solicitaNombre() {
        System.out.print("Ingrese el nombre: ");
        return leer.nextLine();
    }

    public String solicitaApellido() {
        System.out.print("Ingrese el apellido: ");
        return leer.nextLine();
    }

    public void mostrarTodos(List<Mecanicos> lista) {
        System.out.println("\n+++ LISTA DE MECÁNICOS +++");
        for (Mecanicos m : lista) {
            System.out.println("No. Empleado: " + m.getNoEmpleado() + " | Nombre: " + m.getNombre() + " " + m.getApellido());
        }
    }

    public void mostrarDetalle(Mecanicos m) {
        System.out.println("\n+++ DETALLE DEL MECÁNICO +++");
        System.out.println("NÚMERO DE EMPLEADO: " + m.getNoEmpleado());
        System.out.println("NOMBRE completo: " + m.getNombre() + " " + m.getApellido());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}