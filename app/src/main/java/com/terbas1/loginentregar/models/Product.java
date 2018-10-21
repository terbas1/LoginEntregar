package com.terbas1.loginentregar.models;

import com.orm.dsl.Table;

@Table
public class Product {
    private Long id;
    private String product_name;
    private String product_price;
    private String product_desc;
    private String product_state;
    private Long id_user;

    public  Product(){

    }

    public Product(String product_name, String product_price, String product_desc, String product_state, Long id_user) {
        this.product_name = product_name;
        this.product_price= product_price;
        this.product_desc = product_desc;
        this.product_state = product_state;
        this.id_user = id_user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getProduct_state() {
        return product_state;
    }

    public void setProduct_state(String product_state) {
        this.product_state = product_state;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }




}

