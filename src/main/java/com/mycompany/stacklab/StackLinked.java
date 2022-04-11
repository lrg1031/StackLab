package com.mycompany.stacklab;

public class StackLinked {
    
    class Node{
    public int data;
    public Node next;
    }
    
    private Node top;
    private int length;

    public StackLinked() {
        top = null;
    }
    
    void push(int item) {
        Node temp;
        temp = new Node();
        temp.data = item;
        temp.next = top;
        top = temp;
        length++;
    }
    
    int pop() {
        Node temp = top;
        int data = top.data;
        top = top.next;
        return data;
    }
    
    //currently, this builds stack backwards!
    public StackLinked(StackLinked stack) {
        top = null;
        Node current = stack.top;
        while(current != null) {
            this.push(current.data);
            current = current.next;
        }
    }
    
    void show() {
        Node location = top;
        while(location != null) {
            System.out.println(location.data);
            location = location.next;
        }
    }
    
    void makeEmpty() {
        top = null;
    }
    
    boolean isEmpty() {
        return(top == null);
    }
    
    boolean isFull() {
        Node location;
        try{
            location = new Node();
            location = null;
            return false;
        }
        catch (OutOfMemoryError one){
            return true;
        }
    }
    
    //this one works!
    void copy(StackLinked source) {
        top = null;
        copy(source.top);
    }
    
    //code to copy a node, used by copy2
    void copy(Node sourceNode) {
        if(sourceNode != null) {
            copy(sourceNode.next);
            push(sourceNode.data);
        }
    }
    
    public static void main(String[] args) {
        StackLinked sl = new StackLinked();
        sl.push(10);
        sl.push(20);
        sl.push(30);
        StackLinked s2 = new StackLinked();
        s2.copy(sl);
        s2.show();
        System.out.println();
        sl.show();
    }
    
}
