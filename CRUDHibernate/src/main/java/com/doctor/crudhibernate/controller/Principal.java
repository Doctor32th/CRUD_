package com.doctor.crudhibernate.controller;

import com.doctor.crudhibernate.models.Pedido;
import com.doctor.crudhibernate.models.Producto;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Doctor
 */
public class Principal {

    /**
     * Esta clase no solo englobará al menu, también llevará 
     * Los métodos que vamos a implementar con las consultas adjuntas
     * De manera que las clases interaccionen entre sí gracias a la foreign
     * key que establecimos en la base de datos y la relación one-to-many
     * @param args 
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Pedido pedido = new Pedido();
        Producto producto = new Producto();

        boolean salir = false;
        int opcion;

        while (!salir) {

            System.out.println("****************************");
            System.out.println("      CHOCOLATE FACTORY     ");
            System.out.println("****************************");
            System.out.println("        BIENVENIDO!!        ");
            System.out.println("============================");
            System.out.println("-----1. Crear pedido-----");
            System.out.println("-----2. Eliminar pedido-----");
            System.out.println("-----3. Listar pedidos-----");
            System.out.println("-----4. Listar pedidos de hoy-----");
            System.out.println("-----5. Mostrar Carta-----");
            System.out.println("-----6. Salir-----");
            System.out.println("============================");

            try {
                System.out.println("Elige una opción, por favor");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Por favor, escriba el número del"
                                + " producto que desea");
                        System.out.println("Creando pedido...");
                        Thread.sleep(2000);
                        System.out.println("Su pedido se ha creado con éxito");
                        break;
                    case 2:
                        System.out.println("Por favor, escriba el número del"
                                + " pedido que desea eliminar");
                        System.out.println("Eliminando pedido...");
                        Thread.sleep(2000);
                        System.out.println("Su pedido ha sido eliminado"
                                + " con éxito");
                        break;
                    case 3:
                        System.out.println("Listando todos sus pedidos...");
                        Thread.sleep(4000);
                        break;
                    case 4:
                        System.out.println("Listando todos sus pedidos"
                                + " de hoy...");
                        Thread.sleep(2000);
                        break;
                    case 5:
                        System.out.println("Mostrando carta de"
                                + " desayunos...");
                        Thread.sleep(4000);
                        break;
                    case 6:
                        System.out.println("Saliendo del programa."
                                + " Por favor, espere...");
                        Thread.sleep(3000);
                        salir = true;
                        break;
                    default:
                        System.out.println("La opción a elegir no figura"
                                + " en el menú actual. "
                                + "Inténtelo de nuevo");
                }
            } catch (InputMismatchException | InterruptedException ex) {
                System.out.println("Debe insertar un número para elegir");
                sc.next();
            }
        }
        
    }
    
}
