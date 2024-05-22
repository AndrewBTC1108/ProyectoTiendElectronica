package org.catcdfgz.co.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sell extends BaseSell
{
    private List<Product> productsSold;
    private double totalSales;
    private Date date;
    private SimpleDateFormat dateFormat;
    private String dateHourSold;
    private int amountSold;

    public Sell() {
        this.productsSold = new ArrayList<>();
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.date = new Date();
        this.dateHourSold = dateFormat.format(date);
    }
    public List<Product> getProductsSold() {
        return productsSold;
    }

    public String getDateHourSold() {
        return dateHourSold;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public int getAmountSold() {
        return amountSold;
    }

    public void addProduct(Product product, int mount){
        if(product.getAmount() == 0){
            System.out.println("No se puede Generar venta por que el producto se agoto");
        } else {
            this.productsSold.add(product);//add producto to the productsSold List
            this.amountSold = mount;//amount sold
            int productMount = product.getAmount();//get the current amount of the Product
            product.setAmount(productMount - amountSold);//less amount to the Product
            System.out.println(STR."Venta realizada con exito!, Total a pagar \{this.totalSell(amountSold, product)}");
        }
    }

    public double totalSell(int mount, Product product){
        this.totalSales = mount* product.getPrice();
        return totalSales;
    }

}
