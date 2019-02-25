package entity;

import entity.ItemType;
import entity.Order1;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-24T22:18:42")
@StaticMetamodel(OrderLine.class)
public class OrderLine_ { 

    public static volatile SingularAttribute<OrderLine, Integer> quantity;
    public static volatile SingularAttribute<OrderLine, Integer> id;
    public static volatile SingularAttribute<OrderLine, ItemType> it;
    public static volatile SingularAttribute<OrderLine, Order1> order1;

}