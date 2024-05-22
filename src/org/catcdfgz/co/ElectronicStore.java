package org.catcdfgz.co;

import org.catcdfgz.co.electronicstore.StoreElectronic;
import static org.catcdfgz.co.menusstores.MenuStore.menuStore;
import static org.catcdfgz.co.models.Role.ADMINISTRATOR;

import org.catcdfgz.co.models.Role;
import org.catcdfgz.co.models.User;

import java.util.Scanner;

public class ElectronicStore
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StoreElectronic electronicStore = new StoreElectronic();
        User AdminUser = new User("jack", "password1@", ADMINISTRATOR);
        electronicStore.createUsers(AdminUser.getName(), AdminUser);//create AdminUser
        int option;
        do {
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Salir.");
            System.out.print("Ingrese su opción: ");
            option = sc.nextInt();
            switch (option){
                case 1:
                    sc.nextLine();
                    System.out.println("Bienvenido Inicia Sesion para Continuar =)");
                    System.out.print("Digita Tu nombre de usuario: ");
                    String userName = sc.nextLine();
                    System.out.print("Digita ahora tu Password: ");
                    String userPassword = sc.nextLine();
                    User user = electronicStore.login(userName, userPassword);//login
                    if(user == null){
                        System.out.println("Username o Passowrd incorrectos o no existe el usuario");
                    }else {
                        Role userRol = user.getRoleUser();
                        menuStore(userRol,electronicStore);
                    }
                    break;
                case 2:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }while(option != 2);
    }
}
