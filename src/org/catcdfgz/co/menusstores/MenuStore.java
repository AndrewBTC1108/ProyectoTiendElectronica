package org.catcdfgz.co.menusstores;

import org.catcdfgz.co.electronicstore.StoreElectronic;
import static org.catcdfgz.co.menusstores.AdministratorMenu.menuAdministrator;
import static org.catcdfgz.co.menusstores.MenuSalesman.menuSalesman;
import static org.catcdfgz.co.menusstores.MenuManager.menuManager;
import org.catcdfgz.co.models.Role;

import java.util.List;
import java.util.Scanner;

public class MenuStore {
    public static void menuStore(Role userRol, StoreElectronic electronicStore){
        System.out.println(STR."Iniciando Sesion como \{userRol}");
        switch (userRol){
            case ADMINISTRATOR:
                menuAdministrator(electronicStore);
                break;
            case SALESMAN:
                menuSalesman(electronicStore);
                break;
            case MANAGER:
                menuManager(electronicStore);
                break;
        }
    }
}
