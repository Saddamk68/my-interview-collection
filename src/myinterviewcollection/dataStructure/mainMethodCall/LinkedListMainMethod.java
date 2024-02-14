/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.dataStructure.mainMethodCall;

import myinterviewcollection.dataStructure.list.LinkedListCust;

/**
 *
 * @author Saddam Khan
 */
public class LinkedListMainMethod implements MainMethodInterface {
    
    @Override
    public void call() {
    
        LinkedListCust myLinkedList = new LinkedListCust(4);

        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        System.out.println("\nLinked List:");
        myLinkedList.printList();

        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);

        System.out.println("\nLinked List after addLast():");
        myLinkedList.printList();

        myLinkedList.removeLast();
        System.out.println("\nLinked List after removeLast():");
        myLinkedList.printList();

        myLinkedList.addFirst(1);
        System.out.println("\nLinked List after addFirst():");
        myLinkedList.printList();

        myLinkedList.removeFirst();
        System.out.println("\nLinked List after removeFirst():");
        myLinkedList.printList();

        System.out.println("\nget value from given index:" + myLinkedList.get(2).value);

        myLinkedList.set(2, 99);
        System.out.println("\nLinked List after set():");
        myLinkedList.printList();

        myLinkedList.insert(1, 2);
        System.out.println("\nLinked List after insert(2) in middle:");
        myLinkedList.printList();

        myLinkedList.insert(0, 0);
        System.out.println("\nLinked List after insert(0) at beginning:");
        myLinkedList.printList();

        myLinkedList.insert(4, 4);
        System.out.println("\nLinked List after insert(4) at end:");
        myLinkedList.printList();

        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        System.out.println("\nLinked List before remove():");
        myLinkedList.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(2).value);
        System.out.println("\nLinked List after remove() in middle:");
        myLinkedList.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(0).value);
        System.out.println("\nLinked List after remove() of first node:");
        myLinkedList.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(2).value);
        System.out.println("\nLinked List after remove() of last node:");
        myLinkedList.printList();

        myLinkedList.addLast(6);
        myLinkedList.addLast(6);
        myLinkedList.insert(3, 5);
        myLinkedList.reverse();
        System.out.println("\nLinked List after reverse():");
        myLinkedList.printList();
        
        System.out.println("\nMiddle element of linked myinterviewcollection.DataStructure.list is : " + myLinkedList.getMiddleElem().value);
        
        myLinkedList.removeDuplicates();
        System.out.println("\nLinked List after removing duplicates : ");
        myLinkedList.printList();
        
    }   
}
