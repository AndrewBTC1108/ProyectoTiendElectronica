package org.catcdfgz.co.menusstores;

import org.catcdfgz.co.electronicstore.StoreElectronic;
import org.catcdfgz.co.models.Product;
import org.catcdfgz.co.models.User;
import static org.catcdfgz.co.models.Role.MANAGER;
import static org.catcdfgz.co.models.Role.SALESMAN;

import java.util.List;
import java.util.Scanner;

public class AdministratorMenu {
    public static Scanner sc = new Scanner(System.in);
    public static int option;
    public static void menuAdministrator(StoreElectronic electronicStore){
        //Listar
        List<Product> products = electronicStore.list();
        do {
            System.out.println("1. Crear Producto");
            System.out.println("2. Actualizar Producto.");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Generar informe de Ventas");
            System.out.println("5. Generar informe de Inventarios");
            System.out.println("6. Crear Usuario para el Negocio");
            System.out.println("7. Cerrar Sesion.");
            System.out.print("Ingrese su opción: ");
            option = sc.nextInt();
            switch (option){
                case 1:
                    System.out.print("Cuantos productos añadiras al Inventario?: ");
                    int numeroProd = sc.nextInt();
                    for(int i = 1; i <= numeroProd; i++ ){
                        sc.nextLine();
                        System.out.print(STR."Digita el nombre del producto \{i}: ");
                        String nameELC = sc.nextLine();
                        System.out.print("Digita la descripcion del producto: ");
                        String descriptionELC = sc.nextLine();
                        System.out.print("Digita el precio: ");
                        double priceELC = sc.nextDouble();
                        System.out.print("Digita la cantidad en Stock: ");
                        int amount = sc.nextInt();
                        //create
                        electronicStore.create(new Product(nameELC, descriptionELC, priceELC, amount));
                    }
                    break;
                case 2:
                    if(products.isEmpty()){
                        System.out.println("Aun no hay Productos registrados Comienza creando uno");
                    } else {
                        System.out.print("Digita el ID del producto a actualizar: ");
                        Integer id = sc.nextInt();
                        sc.nextLine();
                        System.out.print(STR."Digita el nuevo nombre del producto : ");
                        String NewnameELC = sc.nextLine();
                        System.out.print("Digita la nueva descripcion del producto: ");
                        String NewdescriptionELC = sc.nextLine();
                        System.out.print("Digita nuevo el precio: ");
                        double NewpriceELC = sc.nextDouble();
                        System.out.print("Digita la nueva cantidad en Stock: ");
                        int Newamount = sc.nextInt();
                        Product productChanged = new Product(NewnameELC, NewdescriptionELC, NewpriceELC, Newamount);
                        productChanged.setId(id);
                        electronicStore.edit(productChanged);//edit the old product
                    }
                    break;
                case 3:
                    if(products.isEmpty()){
                        System.out.println("Aun no hay Productos registrados Comienza creando uno");
                    }else {
                        System.out.print("Digita el ID del producto a Eliminar del stock : ");
                        Integer idDel = sc.nextInt();
                        electronicStore.delete(idDel);
                    }
                    break;
                case 4:
                    System.out.println("Reporte total de Ventas");
                    String salesReport = electronicStore.generateSellReport();
                    System.out.println(salesReport);
                    break;
                case 5:
                    System.out.println("Inventario de Productos");
                    String productsI = electronicStore.generateInventory();
                    System.out.println(productsI);
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("Crear Usuario para el Negocio");
                    System.out.print("Digita el nombre de usuario: ");
                    String userName = sc.nextLine();
                    System.out.print("Digita su Password: ");
                    String password = sc.nextLine();
                    System.out.println("Elige su Rol");
                    System.out.println("1. Gerente");
                    System.out.println("2. Vendedor");
                    int rol = sc.nextInt();
                    if(rol == 1){
                        User Gerente = new User(userName, password, MANAGER);
                        electronicStore.createUsers(Gerente.getName(), Gerente);
                        System.out.println("Gerente Creado con exito.");
                    }else if(rol == 2){
                        User Vendedor = new User(userName, password, SALESMAN);
                        electronicStore.createUsers(Vendedor.getName(), Vendedor);
                        System.out.println("Vendedor Creado con exito.");
                    }else {
                        System.out.println("Opcion no valida");
                    }
                    break;
            }
        }while(option != 7);
    }
}