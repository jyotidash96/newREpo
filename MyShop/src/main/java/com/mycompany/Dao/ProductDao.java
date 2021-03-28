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
    
    public int saveProduct(Product p){
        Session s=this.sessionfactory.openSession();
        Transaction t=s.beginTransaction();
        int pid=(int)s.save(p);
        t.commit();
        s.close();
        
        return pid;
    
    }
    
}
