/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Guest Account
 */
@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int product_Id;
    @Column(length=2000 , name= "ptitle")
    private String product_title;
  
    private String product_Desc;
   
    private String product_Pic;
    private int product_Price;
    
    private int product_Discount;
    
    private int product_Quantity;
    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(int product_Id, String product_title, String product_Desc, String product_Pic, int product_Price, int product_Discount, int product_Quantity) {
        this.product_Id = product_Id;
        this.product_title = product_title;
        this.product_Desc = product_Desc;
        this.product_Pic = product_Pic;
        this.product_Price = product_Price;
        this.product_Discount = product_Discount;
        this.product_Quantity = product_Quantity;
    }

    public Product(String product_title, String product_Desc, String product_Pic, int product_Price, int product_Discount, int product_Quantity , Category category) {
        this.product_title = product_title;
        this.product_Desc = product_Desc;
        this.product_Pic = product_Pic;
        this.product_Price = product_Price;
        this.product_Discount = product_Discount;
        this.product_Quantity = product_Quantity;
        
        this.category= category;
    }

    public int getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(int product_Id) {
        this.product_Id = product_Id;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_Desc() {
        return product_Desc;
    }

    public void setProduct_Desc(String product_Desc) {
        this.product_Desc = product_Desc;
    }

    public String getProduct_Pic() {
        return product_Pic;
    }

    public void setProduct_Pic(String product_Pic) {
        this.product_Pic = product_Pic;
    }

    public int getProduct_Price() {
        return product_Price;
    }

    public void setProduct_Price(int product_Price) {
        this.product_Price = product_Price;
    }

    public int getProduct_Discount() {
        return product_Discount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    

    public void setProduct_Discount(int product_Discount) {
        this.product_Discount = product_Discount;
    }

    public int getProduct_Quantity() {
        return product_Quantity;
    }

    public void setProduct_Quantity(int product_Quantity) {
        this.product_Quantity = product_Quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "product_Id=" + product_Id + ", product_title=" + product_title + ", product_Desc=" + product_Desc + ", product_Pic=" + product_Pic + ", product_Price=" + product_Price + ", product_Discount=" + product_Discount + ", product_Quantity=" + product_Quantity + '}';
    }
    
    
    
    
}
