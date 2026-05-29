package org.derekgonzalez.view;
import java.util.Scanner;
import org.derekgonzalez.controller.ClientesController;

public class MenuPrincipal {
    //herramienta de scanner: lee datos de usuario
    private final Scanner leer = new Scanner(System.in);

    public void iniciarSistema() {
        int opcion;
        //ciclo para el menu: do while
        do {            
            System.out.println("-----------------------------------------");
            System.out.println("   SISTEMA CENTRAL LIBRERIA - IN4CM");
            System.out.println("-----------------------------------------");
            System.out.println("1. Entrar a CLIENTES");
            System.out.println("2. Entrar a MECANICOS");
            System.out.println("3. Entrar a REPUESTOS DE MECANICOS");
            System.out.println("3. Entrar a ORDEN DE SERVICIO");
            System.out.println("3. Entrar a REPUESTOS");
            System.out.println("3. Entrar a VEHICULOS");
            System.out.println("4. SALIR DEL SISTEMA");
            System.out.println("Seleccione una opcion: ");
            
            opcion = Integer.parseInt(leer.nextLine());
            
            //switch / case
            switch (opcion) {
                case 1:
                    //instanciar la vista Clientes
                    ClientesView vista = new ClientesView();
                    ClientesController control = new ClientesController(vista);
                    control.iniciar();
                    break;
                case 2:
                    //instanciar la vista EDITORIALES
                    System.out.println("EDITORIALES");
                    break;
                case 3:
                    //instanciar la vista LIBROS
                    System.out.println("LIBROS");
                    break;
                case 4:
                    //instanciar la vista LIBROS
                    System.out.println("\n Hasta la próxima");
                    break;
                default:
                    System.out.println("no existe la opcion");
            }
            
        } while (opcion != 4);
        
        
    }
}
