/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Mehak Beri
 */
public class Assign3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // an array consisting of 16 random numbers. a[0] indicates the size of the array
        //a[0]=15=size of array
        int[] initialArray= {15,11,18,73,81,6,-9,109,32,91,29,33,-40,55,28,2}; 
        System.out.print("The initial array is: ");
        printArray(initialArray);
        //create a max heap out of the given array. pass the number of elements in the heapify function
        int[] maxHeap= heapify(initialArray, initialArray[0]);
        System.out.print("\nThe max heap from the given array is: ");
        printArray(maxHeap);
        //sort the max heap using heap sort
        int[] sortedHeap= heapSort(maxHeap);
        System.out.print("\nAfter Heap sorting: ");
        printArray(sortedHeap);
    }
    
    public static int[] heapify(int[] a,int n){
        int x= n; //number of elements to heapify
        while((n/2)>0)
        {   
            if(a[n/2]<a[n])
            {   
                a=swap(a,n,(n/2));
                n=x;
            }
            else
            {
                n=n-1;
            }
            
        }
        return a;
    }
    
    public static void printArray(int[] a)
    {
        System.out.print("[");
        for(int i=0; i<a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
    }
    
    public static int[] heapSort(int[] a){
        int n=1;
        int largest=1;
        int last;
        while(n<a[0]-1) //a[0]-1 because heapify does not work for if number of elements is one. so one iteration was getting wasted.
        { 
            last =(a.length)-n;
            a=swap(a,largest,last);
            //now ignore largest node in the heap temporarily and heapify using the other nodes
            a=heapify(a,a[0]-n-1);
            n++;
        }
        return a;
    }
    
    public static int[] swap(int a[],int i,int j)
    {
        int temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
        return a;
    }
    
}
