/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Mehak Beri
 */
public class Assign1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Initialize a non corrupted linked list         
            linkedList nonCorrupted = new linkedList();
            nonCorrupted.add(5);
            nonCorrupted.add(32);
            nonCorrupted.add(7);
            nonCorrupted.add(8); 
            nonCorrupted.add(21);
            nonCorrupted.add(23);
            nonCorrupted.add(90);
            nonCorrupted.add(45);
            nonCorrupted.add(56);
            nonCorrupted.add(77);
        // end of non corrupter linked list
        //    nonCorrupted.printLinkedList(); //print it
            
        //Initialize a corrupted linked list
            linkedList corrupted = new linkedList();
            corrupted.add(12);
            corrupted.add(2);
            corrupted.add(45);
            corrupted.add(78);
            corrupted.add(9);
            corrupted.add(23);
            corrupted.add(90);
            corrupted.add(45);
            corrupted.add(56);
            corrupted.add(77);
        //end of corrupted linked list
            corrupted.printLinkedList(); //correct order of linked list
            corrupted.corrupt(); //corrupt a node's next pointer   
        //after corruption, there exists a loop in the linked list, so prints infinite nodes
          //  corrupted.printLinkedList(); //print corrupted order of linked list
            
            linkedList check= corrupted; //linked list that needs to be checked if it is corrupted or not
            Node a= check.head(); //head of linked list
            Node b= a.getNext(); //second node of linked list
            boolean result=isCorrupted(a,b); //function call to initialize checking whether linked list is corrupted
            System.out.println("The given linked list is corrupted: " + result);
               
    }
    
    private static boolean isCorrupted(Node a, Node b)
    {
        //first condition. only one element in linked list. assuming that linked list cannot be null.
        if(a.getValue()==0 && b==null)
        {
            return false; 
        }
        
        while(a.getNext()!=null || b.getNext()!=null)
        {
        //if corrupted, loop exists and we do not reach a node that points to null
        if(a==b)
            {
                return true;
            }
        else
            {   
                if(a.getNext()==null || b.getNext()==null)
                {
                    break;
                }
                return isCorrupted(a.getNext(),b.getNext().getNext());
            }
            
        }
        return false;
    }
    
}

//class to create node
class Node{
    private int value; //node stores an integer
    private Node next; // pointer to next node
    //constructors
    public Node(){
        this(0,null); //assume that head's value cannot be null. if value is not declared, assume node's value to be 0.
    }
    public Node(int i, Node n){
        value=i;
        next=n;
    }
    //Accessor methods
    int getValue(){
        return value;
    }
    Node getNext(){
        return next;
    }
    //Modifier methods
    void setValue(int j){
        value = j;
    }
    void setNext(Node newNext){
        next = newNext;
    }
}

//class to implement linked list
class linkedList{
    public Node head= new Node();
    private int size;
    private Node current; //current node saved
    //head accessor function
    public Node head(){
        return head;
    }
    public void add(int nodeValue){
        Node n = new Node(nodeValue,null);
        if(size==0)
        {
            head=n;
            head.setValue(nodeValue);
            head.setNext(null);
            size++;
           // System.out.println("\nhead added, value= " + n.getValue());
        }
        else
        {
            current.setNext(n);
            n.setValue(nodeValue);
            n.setNext(null);
            size++;
          //  System.out.println("node added, value= " + n.getValue());
        }
        current=n;
    }
    //random corruption in order to create a loop in the example linked list
    public void corrupt(){
        current=head.getNext().getNext().getNext().getNext().getNext().getNext();
        current.setNext(head.getNext());
        System.out.println("\nCorrupted node with value " + current.getValue() + ". It's next pointer points to node with value = " + current.getNext().getValue());
    }
    public void delete(){
        head = head.getNext();
        size--;
       // System.out.println("Deleted last node!");
    }
    public void printLinkedList(){
        Node x=head;
        int i=0;
        //System.out.println("Size of linked list: "+size);
        System.out.println("Actual linked list");
        
        while(x.getNext()!=null){
            System.out.print(x.getValue()+" -> ");
            x = x.getNext();
            i++;
        }
        System.out.println(x.getValue());
    }
    
}


