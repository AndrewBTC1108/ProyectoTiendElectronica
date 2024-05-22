package org.catcdfgz.co.menusstores;

import org.catcdfgz.co.ElectronicStore;
import org.catcdfgz.co.electronicstore.StoreElectronic;
import org.catcdfgz.co.models.Product;
import org.catcdfgz.co.models.Sell;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuSalesman {
    public static Scanner sc = new Scanner(System.in);
    public static int option;
    public static void menuSalesman(StoreElectronic storeElectronic){
        List<Product> products = storeElectronic.list();
        do {
            System.out.println("1. Generar informe de Inventarios");
            System.out.println("2. Realizar Venta");
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
                    if(products.isEmpty()){
                        System.out.println("Aun no hay Productos registrados Para la Venta");
                    }else {
                        Sell sell = new Sell();
                        System.out.print("Digita el ID del producto a vender: ");
                        int IDP = sc.nextInt();
                        Product product = storeElectronic.byId(IDP);

                        if(product == null){
                            System.out.println("No existe ningun Producto con ese ID.");
                        }else {
                            System.out.println(STR."En el Stock hay una cantidad de \{product.getAmount()} del producto");
                            System.out.print("Cuantos deseas llevar?: ");
                            int mount = sc.nextInt();
                            sell.addProduct(product, mount);
                            storeElectronic.create(sell);
                        }
                    }
                    break;
            }
        }while(option != 3);
    }
}
