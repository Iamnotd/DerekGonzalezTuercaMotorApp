package org.derekgonzalez.view;

import java.util.List;
import java.util.Scanner;
import org.derekgonzalez.model.Vehiculos;

public class VehiculosView {
    private final Scanner leer = new Scanner(System.in);
    public long sol;

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE VEHÍCULOS ---");
        System.out.println("1. Registrar nuevo vehículo");
        System.out.println("2. Listar todos los vehículos");
        System.out.println("3. Buscar vehículo por Placa");
        System.out.println("6. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(leer.nextLine());
    }

    public String solicitaPlaca() {
        System.out.print("Ingrese la placa del vehículo (Max 8 car.): ");
        return leer.nextLine();
    }

    public String solicitaMarca() {
        System.out.print("Ingrese la marca: ");
        return leer.nextLine();
    }

    public String solicitaColor() {
        System.out.print("Ingrese el color: ");
        return leer.nextLine();
    }

    public String solicitaModelo() {
        System.out.print("Ingrese el modelo/año: ");
        return leer.nextLine();
    }

    public long solicitaCuiCliente() {
        System.out.print("Ingrese el CUI del dueño (Cliente): ");
        return Long.parseLong(leer.nextLine());
    }

    public void mostrarTodos(List<Vehiculos> lista) {
        System.out.println("\n+++ LISTA DE VEHÍCULOS +++");
        for (Vehiculos v : lista) {
            System.out.println("Placa: " + v.getPlaca() + " | Marca: " + v.getMarca() + " | Dueño (CUI): " + v.getCuiCliente());
        }
    }

    public void mostrarDetalle(Vehiculos v) {
        System.out.println("\n+++ DETALLE DEL VEHÍCULO +++");
        System.out.println("PLACA: " + v.getPlaca());
        System.out.println("MARCA: " + v.getMarca());
        System.out.println("COLOR: " + v.getColor());
        System.out.println("MODELO: " + v.getModelo());
        System.out.println("CUI DUEÑO: " + v.getCuiCliente());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}