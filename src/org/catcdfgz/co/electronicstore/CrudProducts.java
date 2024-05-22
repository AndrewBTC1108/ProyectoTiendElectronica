package org.catcdfgz.co.electronicstore;

import org.catcdfgz.co.exceptions.ReadDataException;
import org.catcdfgz.co.models.Product;

import java.util.List;

public interface CrudProducts {
     List<Product> list(); //reuturns a List with Products
     Product byId(Integer id); //returns a Object with these id
     void create(Product product); //create a product of Product Object
     void edit(Product product); ////Edit a product of Product Object
     void delete(Integer id); //Delete a Product by id

}
