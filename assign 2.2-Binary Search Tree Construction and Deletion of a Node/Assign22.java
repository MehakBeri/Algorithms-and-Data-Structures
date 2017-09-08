/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
/**
 *QUESTION 2.2
 * 2. Make a Binary Search tree.  Write program to delete a number in the binary search tree.

You will first make the BST for atleast 15 numbers. do inorder traversal

Now delete a number in the tree. The number to be deleted should NOT be a leaf node.

do inorder traversal again to show the number is deleted.

run again to try and delete a number not in the tree, it should display a message saying number not found.

submit screen shot of execution

submit read me file and the code.
 * @author Mehak Beri
 */

class Node{
    int element;
    Node left; //left child
    Node right; //right child
    Node(int a){
        element=a;
        left=null;
        right=null;
    }
}
class BinarySearchTree{
    protected Node root;
    BinarySearchTree(){
        root=null;
    }
    
    public void insert(int a){
        root= addNode(root,a);
    }
    public Node addNode(Node root,int a){
        Node n= new Node(a); 
        if(root==null)
        {
            root=n;
            return root;
        }
        if(a<=root.element)
        {
            root.left= addNode(root.left,a);
            
        }
        if(a>root.element)
        {
            root.right=addNode(root.right,a);
            
        }
        return root;
    }
    public void delete(int k){
        root=deleteNode(root,k);
    }
    public Node deleteNode(Node root,int k){
        boolean found=false;
        if(root==null){
            if(!found)
            {
                System.out.println("Number not found");
            }
            return root; //base case if tree is empty
        }
        if(root.element==k)
            {   found=true;
                //if only one child, then deleted root shall be replaced with its child
                if(root.left==null)
                {
                    return root.right;
                }
                else if(root.right==null)
                {
                    return root.left;
                }
                //if both children are present, replace root node with successor or predecessor. here replacing with successor
                Node temp=root.right;
                int key=temp.element;
                while(temp!=null)
                {
                    key=temp.element;
                    temp=temp.left;
                    
                }
                root.element=key;
                root.right=deleteNode(root.right,root.element);
                return root;
            }
            
        if(k<=root.element)
                {
                    root.left= deleteNode(root.left,k);
                }
        if(k>root.element)
                {
                    root.right= deleteNode(root.right,k);
                }
        //if key does not exist
       
        return root;
    }
    public void PrintInorderTraversal(){
        System.out.print("Inorder traversal:  ");
        InorderTraversal(root);
    }
    public void InorderTraversal(Node root){
        if(root!=null)
        {
        InorderTraversal(root.left);
        System.out.print(root.element+ " ");
        InorderTraversal(root.right);
        }
    }
}
public class Assign22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner m= new Scanner(System.in);
        BinarySearchTree a= new BinarySearchTree();
        a.insert(76);
        a.insert(23);
        a.insert(1);
        a.insert(21);
        a.insert(56);
        a.insert(49);
        a.insert(50);
        a.insert(10);
        a.insert(60);
        a.insert(100);
        a.insert(6);
        a.insert(63);
        a.insert(11);
        a.insert(22);
        a.insert(96);
        a.insert(19);
        a.insert(86);
        a.insert(15);
        a.insert(57);
        a.insert(110);
        a.PrintInorderTraversal();
        char x='y';
        while(x=='y'){
        System.out.print("\nEnter the number that you want to delete: ");
        int del=m.nextInt();
        System.out.println("Deleting node " + del + " from tree.");
        a.delete(del);
        a.PrintInorderTraversal();
        System.out.print("\n\nType y if you want to delete more numbers: ");
        x=m.next().charAt(0);
        }
    }
    
}
