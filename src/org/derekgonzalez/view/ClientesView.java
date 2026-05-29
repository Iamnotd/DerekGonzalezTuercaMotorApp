package org.derekgonzalez.view;

import java.util.List;
import java.util.Scanner;
import org.derekgonzalez.model.Clientes;

public class ClientesView {
    private final Scanner leer = new Scanner(System.in);
    
    public int mostrarMenu(){
        System.out.println("\n--- GESTION DE CLIENTES ---");
        System.out.println("1. Registrar nuevo cliente");
        System.out.println("2. Listar todos los clientes");
        System.out.println("3. Buscar un cliente por cui");
        System.out.println("4. Buscar por direccion");
        System.out.println("5. Buscar por telefono");
        System.out.println("6. Regresar al menu principal");
        System.out.println("Seleccione una opción: ");
        return Integer.parseInt(leer.nextLine());
    }
    
    public long soliciarID(){
        System.out.println("Ingrese el Cui del cliente a registrar: ");
        return Long.parseLong(leer.nextLine());
    }

    public long soliciarCui(){
        System.out.println("Ingrese el Cui del cliente a buscar: ");
        return Long.parseLong(leer.nextLine());
    }

    public String solicitaNombre(){
        System.out.println("Ingrese el nombre del cliente: ");
        return leer.nextLine();
    }
    
    public String solicitaApellido(){
        System.out.println("Ingrese el apellido del cliente: ");
        return leer.nextLine();
    }

    public String solicitaDireccion(){
        System.out.println("Ingrese la dirección del cliente: ");
        return leer.nextLine();
    }

    public String solicitaTelefono(){
        System.out.println("Ingrese el teléfono del cliente: ");
        return leer.nextLine();
    }
    
    public void mostrarTodos(List<Clientes> categorias){
        System.out.println("\n+++ LISTA DE CLIENTES +++");
        for (Clientes categoria : categorias) {
            System.out.println(categoria.getCuiClientes() + " - " + categoria.getNombreClientes() + " " + categoria.getApellidoClientes());
        }
    } 
    
    public void mostrarCategoria(Clientes clientes){
        System.out.println("\n+++ DETALLE DEL CLIENTE +++");
        System.out.println("CUI: " + clientes.getCuiClientes());
        System.out.println("NOMBRE: " + clientes.getNombreClientes());
        System.out.println("APELLIDO: " + clientes.getApellidoClientes());
        System.out.println("DIRECCIÓN: " + clientes.getDireccionClientes());
        System.out.println("TELÉFONO: " + clientes.getTelefonoClientes());
    }
    
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}