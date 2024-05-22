package org.catcdfgz.co.electronicstore;

import org.catcdfgz.co.exceptions.ReadDataException;
import org.catcdfgz.co.models.Product;
import org.catcdfgz.co.models.Sell;
import org.catcdfgz.co.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StoreElectronic implements CrudAndGenerateRep {
    private List<Product> products;//to save products
    private Map<String, User> users;//to save users
    private List<Sell> sells; // to save sells

    public StoreElectronic() {
        this.products = new ArrayList<>();
        this.users = new HashMap<>();
        this.sells = new ArrayList<>();
    }

    public void createUsers(String name, User user){ //Create Users
        if(users.containsKey(name)){
            System.out.println("El nombre de usuario ya esta en uso..");
        }else {
            this.users.put(name, user);
        }
    }

    public User login(String name, String password){
        if(users != null){
            String lowercaseName = name.toLowerCase();
            if(users.containsKey(lowercaseName)){
                User user = users.get(lowercaseName);
                if(user.getPassword().equals(password)){
                    return user;
                }
            }
        }
        //if there is not a User with these name
        return null;
    }
    @Override
    public List<Product> list() {
        return products;
    }

    public String generateInventory(){
        if(products.isEmpty()){
            return "Aun no hay Productos registrados.";//exception
        } else {
            StringBuilder sb = new StringBuilder("\nInventario: ");
            for (Product product : products) {
                sb.append("\nID:")
                        .append(product.getId())
                        .append("\nNombre:")
                        .append(product.getName())
                        .append("\nDescripcion:")
                        .append(product.getDescription())
                        .append("\nPrecio:")
                        .append(product.getPrice())
                        .append("\nStock:")
                        .append(product.getAmount())
                        .append("\n***********************************************");
            }
            return sb.toString();
        }
    }

    @Override
    public String generateSellReport() {
        if(sells.isEmpty()){
            return "Aun no hay Ventas registradas."; //exception
        } else {
            StringBuilder sb = new StringBuilder("\nRegistro de Ventas: ");
            for (Sell sell : sells) {
                sb.append("\nID:")
                        .append(sell.getId())
                        .append("\nFecha y Hora de la Venta:")
                        .append(sell.getDateHourSold())
                        .append("\n****Producto Vendido****");
                        for(Product sellP : sell.getProductsSold()){
                            sb.append("\nID:")
                                    .append(sellP.getId())
                                    .append("\nNombre:")
                                    .append(sellP.getName())
                                    .append("\nPrecio unidad:")
                                    .append(sellP.getPrice());

                        }
                sb.append("\nCantidad Vendida:")
                        .append(sell.getAmountSold())
                        .append("\nTotal del la Venta:")
                        .append(sell.getTotalSales())
                        .append("\n***********************************************");
            }
            return sb.toString();
        }
    }

    @Override
    public Product byId(Integer id) { //to find a Product Object with the ID
        Product result = null;
        for(Product prod : products){
            //verify the id of the Product don't be null and equals to id assigned in the method
            if(prod.getId() != null && prod.getId().equals(id)){
               result = prod;
               break;
            }
        }
        return result;//returns the object with its id
    }

    @Override
    public void create(Product product) {
        this.products.add(product);
    }//create products
    @Override
    public void create(Sell sell){
        this.sells.add(sell);
    } //create sells

    @Override
    public void edit(Product product){
        //First find the product
        Product p = this.byId(product.getId()); //exception
        if(p == null){
            System.out.println("No se encontron coincidencias con el ID dado");
        }else {
            p.setName(product.getName());
            p.setDescription(product.getDescription());
            p.setPrice(product.getPrice());
            p.setAmount(product.getAmount());
            System.out.println(STR."Producto con el id \{p.getId()} Editado Correctamente");
        }
    }

    @Override
    public void delete(Integer id) {
        Product idDel = this.byId(id); //exception
        if(idDel == null){
            System.out.println("No se encontron coincidencias con el ID dado");
        }else {
            this.products.remove(idDel);
            System.out.println(STR."Producto con el id \{idDel.getId()} Editado Correctamente");
        }
    }
}
