package org.derekgonzalez.view;

import java.util.Scanner;
import org.derekgonzalez.controller.ClientesController;
import org.derekgonzalez.controller.MecanicosController;
import org.derekgonzalez.controller.VehiculosController;

public class MenuPrincipal {
    private final Scanner leer = new Scanner(System.in);

    public void iniciarSistema() {
        int opcion;
        do {
            System.out.println("\n=================================");
            System.out.println("   SISTEMA TALLER TUERCAMOTOR    ");
            System.out.println("=================================");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Vehículos");
            System.out.println("3. Gestión de Mecánicos"); 
            System.out.println("4. Salir del Sistema");
            System.out.print("Seleccione un módulo: ");
            
            try {
                opcion = Integer.parseInt(leer.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    ClientesView cv = new ClientesView();
                    ClientesController cc = new ClientesController(cv);
                    cc.iniciar();
                    break;
                case 2:
                    VehiculosView vv = new VehiculosView();
                    VehiculosController vc = new VehiculosController(vv);
                    vc.iniciar();
                    break;
                case 3: // NUEVO CASO: Ejecuta el módulo de mecánicos
                    MecanicosView mv = new MecanicosView();
                    MecanicosController mc = new MecanicosController(mv);
                    mc.iniciar();
                    break;
                case 4:
                    System.out.println("¡Gracias por utilizar el sistema TuercaMotor! Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }
}