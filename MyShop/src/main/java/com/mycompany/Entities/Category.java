/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Guest Account
 */
@Entity
public class Category {
     @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int category_id;
    private String category_Title;
    private String catrgory_Description;
    @OneToMany(mappedBy="category")
    private List<Product> products=new ArrayList<>();

    public Category() {
    }

    public Category(int category_id, String category_Title, String catrgory_Description) {
        this.category_id = category_id;
        this.category_Title = category_Title;
        this.catrgory_Description = catrgory_Description;
    }

    public Category(String category_Title, String catrgory_Description , List<Product> products) {
        this.category_Title = category_Title;
        this.catrgory_Description = catrgory_Description;
        this.products=products;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }

    
    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_Title() {
        return category_Title;
    }

    public void setCategory_Title(String category_Title) {
        this.category_Title = category_Title;
    }

    public String getCatrgory_Description() {
        return catrgory_Description;
    }

    public void setCatrgory_Description(String catrgory_Description) {
        this.catrgory_Description = catrgory_Description;
    }
    
    
}
