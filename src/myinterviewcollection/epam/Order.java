/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.epam;

import java.time.LocalDate;
/**
 *
 * @author Saddam Khan
 */
public class Order {
    
    public String name;
    public LocalDate orderDate;
    
    public Order(String name, LocalDate orderDate) {
        this.name = name;
        this.orderDate = orderDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

}
