package service;

import entity.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static List<Product> productList;

    static{
        productList = new ArrayList<>();
        productList.add(new Product(1, "T-Shirt men", 100000, 1));
        productList.add(new Product(2, "Polo shirt", 150000, 1));
        productList.add(new Product(3, "Dress", 200000, 2));
        productList.add(new Product(4, "Jacket", 500000, 2));
        productList.add(new Product(5, "Adidas", 2000000, 3));
        productList.add(new Product(6, "Bitis hunter", 800000, 3));
        productList.add(new Product(5, "Toys", 300000, 4));
        productList.add(new Product(6, "Milk", 1000000, 4));

    }

    public List<Product> getProductListByCategoryId(Integer categoryId) {
        List<Product> resultList = new ArrayList<>();
        for(Product element : productList){
            if(element.getCategoryId() == categoryId){
                resultList.add(element);
            }
        }
        return resultList;
    }

    public Product getById(Integer productId) {
        for(Product element : productList){
            if(element.getId() == productId){
                return element;
            }
        }
        return null;
    }
}
