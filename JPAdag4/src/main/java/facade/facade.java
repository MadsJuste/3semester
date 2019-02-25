/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import entity.Order1;
import entity.OrderLine;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Juste
 */
public class facade {
     EntityManagerFactory emf;
    
    public facade(EntityManagerFactory emf) {
    this.emf = emf;
    }

    public facade() {
        
    }
    EntityManager getEntityManager(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    return emf.createEntityManager();
    }
    
    public void createCustomer(String name, String email){
        EntityManager em = getEntityManager();
        Customer cust = new Customer(name,email);
        try{
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            }finally{
              em.close();
           }
       
    }
    
    public Customer findCustomer(int id){
        EntityManager em = getEntityManager();
        Customer cust = new Customer();
        try{
            cust = em.find(Customer.class, id);
            }finally{
              em.close();
           }
        return cust;
    }
    
    public List<Customer> getAllCustomers(){
        EntityManager em = getEntityManager();
        List<Customer> cust = new ArrayList();
        try{
            cust = em.createNamedQuery("Customer.findAll").getResultList();
            }finally{
              em.close();
           }
        return cust;
    }
    
    public void createOrder(Order1 order){
        EntityManager em = getEntityManager();
        Order1 o = new Order1();
        try{
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            }finally{
              em.close();
           }
    }
    
    public void addOrder(int oid, int cid){
        EntityManager em = getEntityManager();
        Order1 o = em.find(Order1.class, oid);
        o.setCustomer(em.find(Customer.class, cid));
        try{
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            }finally{
              em.close();
           }
    }
    
    public Order1 findOrder(int oid){
        EntityManager em = getEntityManager();
        Order1 o = new Order1();
        try{
            o = em.find(Order1.class, oid);
            }finally{
              em.close();
           }
        return o;
    }
    
    public List<Order1> getAllOrdersForCustomer(int cid){
        EntityManager em = getEntityManager();
        List<Order1> o = new ArrayList();
        try{
            Query query = em.createQuery("SELECT o FROM Order1 o WHERE o.customer = :cid");
            query.setParameter("cid", cid);
            o = query.getResultList();
            }finally{
              em.close();
           }
        return o; 
        
    }
    
    public void createOL(OrderLine ol, int oid){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();  
            Order1 o = em.find(Order1.class, oid);
            ol.setOrder1(o);
            em.persist(ol);
            em.getTransaction().commit();
            }finally{
              em.close();
           }
    }
    
}
