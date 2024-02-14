/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.dataStructure.mainMethodCall;

import myinterviewcollection.dataStructure.list.DoublyLinkedListCust;

/**
 *
 * @author Saddam Khan
 */
public class DoublyLinkedListMainMethod implements MainMethodInterface {
    
    @Override
    public void call() {
        
        DoublyLinkedListCust myDLL = new DoublyLinkedListCust(7);

        myDLL.getHead();
        myDLL.getTail();
        myDLL.getLength();

        System.out.println("\nDoubly Linked List:");
        myDLL.printList();        

        myDLL.append(1);
        myDLL.append(2);
        myDLL.append(3);

        System.out.println("\nDoubly Linked List after append():");
        myDLL.printList();
        
        myDLL.removeLast();
        System.out.println("\nDoubly Linked List after removeLast():");
        myDLL.printList();
        
        myDLL.prepend(4);
        System.out.println("\nDoubly Linked List after prepend():");
        myDLL.printList();

        myDLL.removeFirst();
        System.out.println("\nDoubly Linked List after removeFirst():");
        myDLL.printList();
                
        System.out.println("\nget value from given index:" + myDLL.get(2).value);
                
        myDLL.set(2, 99);
        System.out.println("\nDoubly Linked List after set():");
        myDLL.printList();
        
        myDLL.insert(1, 2);
        System.out.println("\nDoubly Linked List after insert(2) in middle:");
        myDLL.printList();

        myDLL.insert(0, 0);
        System.out.println("\nDoubly Linked List after insert(0) at beginning:");
        myDLL.printList();

        myDLL.insert(4, 4);
        System.out.println("\nDoubly Linked List after insert(4) at end:");
        myDLL.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myDLL.remove(2).value);
        System.out.println("\nDoubly Linked List after remove() in middle:");
        myDLL.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myDLL.remove(0).value);
        System.out.println("\nDoubly Linked List after remove() of first node:");
        myDLL.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myDLL.remove(2).value);
        System.out.println("\nDoubly Linked List after remove() of last node:");
        myDLL.printList();

    }
    
}
