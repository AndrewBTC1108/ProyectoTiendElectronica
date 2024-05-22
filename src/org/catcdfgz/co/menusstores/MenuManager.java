package org.catcdfgz.co.menusstores;

import org.catcdfgz.co.electronicstore.StoreElectronic;
import org.catcdfgz.co.models.Product;
import org.catcdfgz.co.models.Sell;

import java.util.List;
import java.util.Scanner;

public class MenuManager {
    public static Scanner sc = new Scanner(System.in);
    public static int option;
    public static void menuManager(StoreElectronic storeElectronic){
        List<Product> products = storeElectronic.list();
        do {
            System.out.println("1. Generar informe de Inventarios");
            System.out.println("2. Generar informe de Ventas");
            System.out.println("3. Cerrar Sesion.");
            System.out.print("Ingrese su opción: ");
            option = sc.nextInt();
            switch (option){
                case 1:
                    System.out.println("Inventario de Productos");
                    String productsI = storeElectronic.generateInventory();
                    System.out.println(productsI);
                    break;
                case 2:
                    String salesReport = storeElectronic.generateSellReport();
                    System.out.println(salesReport);
                    break;
            }

        }while(option != 3);
    }
}
