package com.terbas1.loginentregar.repository;

import com.orm.SugarRecord;
import com.terbas1.loginentregar.models.Product;

import java.util.List;

public class ProductRepository {
    public static List<Product> list(){
        List<Product> products = SugarRecord.find(Product.class, "productstate NOT IN (?)","ARCHIVADO");
        return products;
    }

    public static void create(String product_name, String product_price, String product_desc, String product_state, Long id_user){
        Product product = new Product(product_name, product_price,  product_desc, product_state, id_user);
        SugarRecord.save(product);
    }

    public static List<Product> listFavorite(){
        List<Product> products = SugarRecord.find(Product.class, "productstate = ?","FAVORITOS");
        return products;
    }
    public static List<Product> listArchived(){
        List<Product> products = SugarRecord.find(Product.class, "productstate = ?","ARCHIVADO");
        return products;
    }

    public static void updateState(String product_state, Long id){
        Product product= SugarRecord.findById(Product.class, id);
        product.setProduct_state(product_state);
        SugarRecord.save(product);
    }

}
