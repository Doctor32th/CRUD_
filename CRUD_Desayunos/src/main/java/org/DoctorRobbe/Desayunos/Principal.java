package org.DoctorRobbe.Desayunos;

import org.DoctorRobbe.models.PedidoModel;
import org.DoctorRobbe.models.ProductoModel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PedidoModel pedido = new PedidoModel();
        ProductoModel producto = new ProductoModel();
        DAOPedido daoPedido = new DAOPedido();
        DAOProducto daoProducto = new DAOProducto();

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
                        System.out.println("Por favor, escriba el número del producto que desea");
                        System.out.println("Creando pedido...");
                        Thread.sleep(2000);
                        System.out.println("Su pedido se ha creado con éxito");
                        break;
                    case 2:
                        System.out.println("Por favor, escriba el número del pedido que desea eliminar");
                        System.out.println("Eliminando pedido...");
                        Thread.sleep(2000);
                        System.out.println("Su pedido ha sido eliminado con éxito");
                        break;
                    case 3:
                        System.out.println("Listando todos sus pedidos...");
                        Thread.sleep(4000);
                        break;
                    case 4:
                        System.out.println("Listando todos sus pedidos de hoy...");
                        Thread.sleep(2000);
                        break;
                    case 5:
                        System.out.println("Mostrando carta de desayunos...");
                        Thread.sleep(4000);
                        break;
                    case 6:
                        System.out.println("Saliendo del programa. Por favor, espere...");
                        Thread.sleep(3000);
                        salir = true;
                        break;
                    default:
                        System.out.println("La opción a elegir no figura en el menú actual. " +
                                "Inténtelo de nuevo");
                }
            } catch (InputMismatchException | InterruptedException ex) {
                System.out.println("Debe insertar un número para elegir");
                sc.next();
            }
        }
    }

}
