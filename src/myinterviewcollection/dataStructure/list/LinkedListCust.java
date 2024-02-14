package myinterviewcollection.dataStructure.list;

import java.util.HashMap;

public class LinkedListCust {

    Node head;
    Node tail;
    int length;
    
    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedListCust(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // act as linkFirst method of linked myinterviewcollection.DataStructure.list
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // act as linkLast method of linked myinterviewcollection.DataStructure.list
    public void addLast(int value) {
        Node temp = tail;
        Node newNode = new Node(value);
        tail = newNode;
        if (head == null) {
            head = newNode;
        } else {
            temp.next = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (head == null) {
            // throw exception
            return null;
        }

        Node temp = head;
        head = temp.next;
        temp.next = null;
        length--;

        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node removeLast() {
        if (head == null) {
            // throw exception
            return null;
        }

        Node temp = head;
        while (temp.next != null) {
            tail = temp;
            temp = temp.next;
        }
        tail.next = null;
        length--;

        if (length == 0) {
            tail = null;
            head = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            // throw exception
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value)  {
        if (index < 0 || index > length) {
            // throw exception
            return false;
        }
        if (index == 0) {
            addFirst(value);
            return true;
        }
        if (index == length) {
            addLast(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length-1) {
            return removeLast();
        }

        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;        
        Node after = null;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }        
    }
    
    // if we don't have length of the myinterviewcollection.DataStructure.list
    public Node getMiddleElem() {
        Node middle = head;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.next != null) {
                middle = middle.next;
                temp = temp.next;
            }
        }
        return middle;
    }
    
    // find middle node using slow and fast pointer-
    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // remove duplicates
    public void removeDuplicates() {
        Node temp = head;
        HashMap<Integer, Node> map = new HashMap<>();
        
        Node prev = null;
        while(temp != null) {
//        for (int i = 0; i < length; i++) {
            if (map.containsKey(temp.value)) {
                prev.next = temp.next;
            } else {
                map.put(temp.value, temp);
                prev = temp;
            }
            temp = temp.next;
        }
    }

}
