package org.derekgonzalez.view;

import java.util.List;
import java.util.Scanner;
import org.derekgonzalez.model.Clientes;

public class ClientesView {
    private final Scanner leer = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE CLIENTES ---");
        System.out.println("1. Registrar nuevo cliente");
        System.out.println("2. Listar todos los clientes");
        System.out.println("3. Buscar cliente por CUI");
        System.out.println("4. Buscar cliente por Dirección");
        System.out.println("5. Buscar cliente por Teléfono");
        System.out.println("6. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(leer.nextLine());
    }

    public long solicitaCui() {
        System.out.print("Ingrese el número de CUI del cliente: ");
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

    public String solicitaDireccion() {
        System.out.print("Ingrese la dirección: ");
        return leer.nextLine();
    }

    public String solicitaTelefono() {
        System.out.print("Ingrese el número de teléfono: ");
        return leer.nextLine();
    }

    public void mostrarTodos(List<Clientes> lista) {
        System.out.println("\n+++ LISTA DE CLIENTES +++");
        for (Clientes c : lista) {
            System.out.println("CUI: " + c.getCui() + " | " + c.getNombre() + " " + c.getApellido() + " | Tel: " + c.getTelefono());
        }
    }

    public void mostrarDetalle(Clientes c) {
        System.out.println("\n+++ DETALLE DEL CLIENTE +++");
        System.out.println("CUI: " + c.getCui());
        System.out.println("NOMBRE: " + c.getNombre() + " " + c.getApellido());
        System.out.println("DIRECCIÓN: " + c.getDireccion());
        System.out.println("TELÉFONO: " + c.getTelefono());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}