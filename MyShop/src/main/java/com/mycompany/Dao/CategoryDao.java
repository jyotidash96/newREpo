/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao;

import com.mycompany.Entities.Category;
import com.mycompany.myshop.FactoryProvider;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


/**
 *
 * @author Guest Account
 */
public class CategoryDao {
    
    private SessionFactory sessionfactory;
    
    public CategoryDao(SessionFactory sessionfactory){
    this.sessionfactory=sessionfactory;
    }
    
    
    public int saveCategory(Category cat){
         
       
        
        Session session = this.sessionfactory.openSession();
            Transaction t = session.beginTransaction();
            int  catId= (int) session.save(cat);
              t.commit();
              session.close();
        
        
       
        
       
          return catId; 
    
    
    }
    
    
    public List<Category> getCategories(){
        
        Session s = this.sessionfactory.openSession();
        Query q=s.createQuery("from Category");
        
        List<Category> list=q.list();
        return list;
    
    }
 
    
}
