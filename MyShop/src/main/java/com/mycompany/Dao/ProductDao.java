/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao;

import com.mycompany.Entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Guest Account
 */
public class ProductDao {
    
    private SessionFactory sessionfactory;
    
    
    public ProductDao(SessionFactory sessionfactory){
    this.sessionfactory=sessionfactory;
    }
    
    public boolean saveProduct(Product p){
        
        boolean f=false;
        try{
        
        Session s=this.sessionfactory.openSession();
        Transaction t=s.beginTransaction();
        s.save(p);
        t.commit();
        s.close();
        f=true;
        }catch(Exception e){
        e.printStackTrace();
        f=false;
        }
        
        
        return f;
    
    }
    
}
