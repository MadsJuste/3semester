/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Address;
import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juste
 */
public class tester {
     public static void main(String args[]){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "PU" );
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
       
        Customer cus = new Customer("mads","justesem");
        em.persist(cus);
        Address add = new Address("nærum", "skodsborgvej");
        add.addCustomer(cus);
        em.persist(add);
        cus.addAddress(add);
        em.persist(cus);
        Address add2 = new Address("holte", "skodsborgvej");
        add2.addCustomer(cus);
        em.persist(add2);
        cus.addAddress(add2);
        em.persist(cus);
        Customer cus2 = new Customer("tom","justesem");
        em.persist(cus2);
        Address add3 = new Address("nykøbing", "skodsborgvej");
        add3.addCustomer(cus2);
        em.persist(add3);
        cus2.addAddress(add3);
        em.persist(cus2);
  
        
             
        
        em.getTransaction().commit();
        em.close();

    }
}
