package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-28T13:54:33")
@StaticMetamodel(Computer.class)
public class Computer_ { 

    public static volatile SingularAttribute<Computer, String> psu;
    public static volatile SingularAttribute<Computer, String> ssd;
    public static volatile SingularAttribute<Computer, Double> price;
    public static volatile SingularAttribute<Computer, String> motherboard;
    public static volatile SingularAttribute<Computer, String> cpu;
    public static volatile SingularAttribute<Computer, String> chassi;
    public static volatile SingularAttribute<Computer, String> internalMemory;
    public static volatile SingularAttribute<Computer, Long> id;
    public static volatile SingularAttribute<Computer, String> gpu;

}