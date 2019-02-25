/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Customer;
import entity.Order1;
import entity.OrderLine;
import facade.facade;
import javax.persistence.Persistence;
import javax.persistence.criteria.Order;

/**
 *
 * @author Juste
 */
public class tester {
    public static void main(String[] args)
    {
       facade f = new facade( Persistence.createEntityManagerFactory( "PU" ) );
      
       Customer c = new Customer();
       f.createCustomer("Madsjuste89@gmail.com", "Mads");
       Order1 o = new Order1(c);
       f.createOrder(o);
       f.addOrder(1, 1);
       OrderLine ol = new OrderLine(o,4);
       f.createOL(ol, 1);
       
       

    }
}
