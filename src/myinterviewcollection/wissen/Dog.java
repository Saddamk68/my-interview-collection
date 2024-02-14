/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.wissen;

/**
 *
 * @author Saddam Khan
 */
public class Dog extends Animal {

    public static void main(String[] args) {
        Animal snoopy = new Dog();
        snoopy.setVegetarian(false);
        snoopy.setEats("chicken");
        snoopy.setNoOfLegs(4);
        snoopy.printInfo();
    }

    public void printInfo() {
        System.out.println("Snoopy has " + getNoOfLegs() + " legs, eats " + getEats());
    }
    
}
