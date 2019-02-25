/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Customer;
import static entity.OrderLine_.id;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juste
 */
public class tester2 {
     public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        try{ 
            em.getTransaction().begin();
            Customer cus = em.find(Customer.class, 1);
             em.remove(cus);
             em.getTransaction().commit();
            }finally{
              em.close();
           }
       
    }

}
