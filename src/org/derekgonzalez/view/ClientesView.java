package org.derekgonzalez.view;
import java.util.List;
import java.util.Scanner;
import org.derekgonzalez.model.Clientes;

public class ClientesView {
    private final Scanner leer = new Scanner(System.in);
    
    public int mostrarMenu(){
        System.out.println("\n--- GESTION DE CATEGORIAS ---");
        System.out.println("1. Registrar nuevo cliente");
        System.out.println("2. Listar todas los clientes");
        System.out.println("3. Buscar un cliente por cui");
        System.out.println("4. Buscar por direccion");
        System.out.println("5. Buscar por telefono");
        System.out.println("6. Regresar al menu principal");
        System.out.println("Seleccione una opción: ");
        return Integer.parseInt(leer.nextLine());
    }
    
    public String solicitaNombre(){
        System.out.println("Ingrese el nombre del cliente: ");
        return leer.nextLine();
    }
    
    public int soliciarID(){
        System.out.println("Ingrese el Cui del cliente ");
        return Integer.parseInt(leer.next());
    }
    
    //List = vector de objetos
    public void mostrarTodos(List<Clientes> categorias){
        System.out.println("\n+++ LISTA DE CLIENTES +++");
        // FOR EACH = ciclo para vectores de objeto
        for (Clientes categoria : categorias) {
            System.out.println(categoria.getCuiClientes()+ "" + categoria.getNombreClientes()+ "\n");
            
        }
    } 
    public void mostrarCategoria(Clientes clientes){
        System.out.println("\n DETALLE DE LOS CLIENTES");
        System.out.println("ID: "+ clientes.getCuiClientes() );
        System.out.println("NOMBRE: "+ clientes.getNombreClientes() );
    }
    
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
}