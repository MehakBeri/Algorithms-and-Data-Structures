/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * QUESTION 1. Write a program to sort a list of numbers in ascending order using selection sort. The numbers are stored in a single linked list.

You have head of the list. As you sort the list, DO NOT swap the numbers in each link But unlink the node and relink it at the correct position.

Execute your program for at least 10 numbers . Store them in the list randomly. First traverse the list before sorting to show unsorted list. Then traverse the list after sorting is complete to show the sorted list.

Submit screen shot of execution.

Also submit the code along with read me file.
 *
 * @author Mehak Beri
 */

class Node{
    protected int element;
    protected Node next;
    
    public Node(){
        this(0,null);
    }
    
    public Node(int a, Node n){
        element=a;
        next=n;
    }
    
    public void setNext(Node v){
        next=v;
    }
    public void setElement(int x){
        element=x;
    }
    public int getElement(){
        return element;
    }
    public Node getNext(){
        return next;
    }
}

class LinkedList{
    protected Node head;
    protected Node end; //current last node of the linked list
    public int size=0;
    LinkedList(){
        head=null;
        end=null;
    }
    
    //method to add a node at the end of the linked list
    public void addNode(int a){
        size++;
        Node v= new Node(a,null);
        if (head==null){
            head=v;
            
            end=head;
        }
        else{
           end.setNext(v);
           end=v;            
        }
    }
    public void size(){
        System.out.println("The size of this linked list is "+size);
    }
    public void display(){
        if(head==null){
            System.out.println("No node");
        }
        else{
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.getElement() + " ->");
                temp=temp.next;
            }
            System.out.print(" null\n");
        }
    }
}


public class Assign21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList unsorted= new LinkedList(); 
        unsorted.addNode(23);
        unsorted.addNode(44);
        unsorted.addNode(-9);
        unsorted.addNode(10);
        unsorted.addNode(12);
        unsorted.addNode(98);
        unsorted.addNode(3);
        unsorted.addNode(74);
        unsorted.addNode(92);
        unsorted.addNode(100);
        unsorted.addNode(121);
        unsorted.addNode(18);
        System.out.println("Unsorted List:");
        unsorted.display();
        unsorted.size();
	System.out.println("\nSorting the linked list using Selection Sort.\n");
        selectionSort(unsorted);
        
    }
    
    public static void selectionSort(LinkedList l){
        Node temphead;
        Node currMin;
        Node start=l.head;
        Node head=l.head;
        
        while(start.next!=null){
            currMin=start;
            
            temphead=start.next;
            while(temphead!=null){
                if(currMin.getElement()>temphead.getElement())
                {
                    currMin=temphead;
                }
                temphead=temphead.next;
            }
            System.out.println("Swapping "+currMin.getElement()+" and "+start.getElement());
            start=swap(l,currMin,start); //function swaps values and returns the value of start
            
            l.display();
            start=start.getNext();
            
        }
        System.out.println("\n\nSorted linked list:");
        l.display();
    }
    public static Node swap(LinkedList l,Node a, Node b){
        Node temp=l.head;
        Node prev1=null;
        Node next1=null;
        Node prev2=null;
        Node next2 = null;
        if(a==l.head)
        {
            prev1=null;
            next1=a.next;
        }
        if(b==l.head)
        {
            prev2=null;
            next2=b.next;
        }
        
        while(temp.next!=null){
            
            if(temp.next==a)
            {
               prev1= temp;
               next1=a.next;
            }
            if(temp.next==b)
            {
                prev2=temp;
                next2=b.next;
            }
            temp=temp.next;
        }
        //to unlink and re-link two nodes
        if(prev1==null && prev2!=null) //a was head
        {
            l.head=b;
            prev2.next=a;
        }
        if(prev2==null && prev1!=null) //b was head
        {
            l.head=a;
            prev1.setNext(b);
        }
        if(prev1!=null && prev2!=null){
        prev1.setNext(b);
        prev2.setNext(a);
        
        }
        b.setNext(next1);
        if(a!=next2){
        a.setNext(next2);} //to avoid loop in case a and b are adjacent to each other
        else{
            a.setNext(b);
        }
        return a;
    }
    
}
