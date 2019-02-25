/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Juste
 */
public class CustomerFacade {
    EntityManagerFactory emf;
    public CustomerFacade(EntityManagerFactory emf) {
    this.emf = emf;
    }
    EntityManager getEntityManager(){
    return emf.createEntityManager();
    }
    
    
    public Customer getCustomer(int id){
        EntityManager em = getEntityManager();
        Customer cus = new Customer();
        try{
         cus = em.find(Customer.class, id);
            }finally{
              em.close();
           }
        return cus;
        
    }

    public List<Customer> getCustomers(){
        EntityManager em = getEntityManager();
        List<Customer> customers = null;
        try{
        customers = em.createQuery("SELECT p FROM Customer p").getResultList();
            }finally{
              em.close();
           }
        return customers;
        
    }

    public void addCustomer(Customer cust){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            }finally{
              em.close();
           }
        
    }

    public void deleteCustomer(int id){
        EntityManager em = getEntityManager();
        try{
             em.createNamedQuery("DELETE FROM Customer c WHERE c.ID = :id").executeUpdate();
            }finally{
              em.close();
           }
    } 
    
    public void editCustomer(Customer cust){
        EntityManager em = getEntityManager();
        try{
        Customer c = em.find(Customer.class, cust.getId());
        em.getTransaction().begin();
        c = cust;
        em.persist(c);
        em.getTransaction().commit();
            }finally{
              em.close();
           }
    }
}
