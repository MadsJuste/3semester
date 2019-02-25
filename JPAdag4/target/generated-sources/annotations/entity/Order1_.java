package entity;

import entity.Customer;
import entity.OrderLine;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-24T22:18:42")
@StaticMetamodel(Order1.class)
public class Order1_ { 

    public static volatile SingularAttribute<Order1, Integer> id;
    public static volatile ListAttribute<Order1, OrderLine> OL;
    public static volatile SingularAttribute<Order1, Customer> customer;

}