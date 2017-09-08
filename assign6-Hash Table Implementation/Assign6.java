/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/**
 *
 * @author Mehak Beri
 */
public class Assign6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s;
        System.out.println("The following phrases will be hashed and put in a hashing table using ASCII table values:");
        System.out.println("Dallas\t\t\tComputer\t\t\tUSA\t\t\tDept2\t\t\tTom Hill");
        System.out.println("1984\t\t\tcar POOL\t\t\tA bat\t\t\t20 Cats\t\t\thappy");
        System.out.println("Houses\t\t\tChickPea\t\t\tate\t\t\tc2c\t\t\tbook");
        System.out.println("A rope\t\t\t35 jobs\t\t\t\tfriends\t\t\tPeterPan\t\tpRoGrAm\n\n");
        //store all phrases in an array
        String[] phrases = {"Dallas","Computer","USA","Dept2","Tom Hill","1984","car POOL","A bat","20 Cats","happy","Houses","ChickPea","ate","c2c","book","A rope","35 jobs","friends","PeterPan","pRoGrAm"};
        String[] hashtable = ASCIIhash(phrases);
        System.out.println("\n\nFinal Hashed Table");
        for(int i=0; i<hashtable.length; i++)
        {
            s=hashtable[i];
            System.out.println("Index "+i+" "+s);
        }
    }
    public static String[] ASCIIhash(String[] p){
        //initially hashtable size is 31
        int i=1;
        System.out.println("Iteration "+i);
        int hashtableSize=31;
        String[] hashtable= hash(p,hashtableSize);
        double loadFactor= loadFactor(hashtable,hashtableSize);
        
        //increasing table size and rehashing
        while(loadFactor>0.5)
        {
            i++;
            System.out.println("\nNeed to extend table since loadfactor has become greater than 0.5");
            System.out.println("Resizing table and rehashing...");
            System.out.println("Iteration "+i);
            hashtableSize= nextPrimeSize(hashtableSize);
            hashtable=hash(p,hashtableSize);
            loadFactor= loadFactor(hashtable,hashtableSize);
           
        }
        return hashtable;
    }  
    public static String[] hash(String[] p, int hashtableSize) 
    {
        String[] hashtable = new String[hashtableSize];
        int val;
        int sum;
        char[] ch;
        int collisions=0;
        int it; //iterator
        double loadFactor= loadFactor(hashtable,hashtableSize);
        for(int i=0; i<p.length && loadFactor<=0.5 ;i++)
        {
            sum=0;
            it=1;
            int temp;
            ch= p[i].toCharArray();
            for(int j=0; j<ch.length; j++)
            {
                sum = sum + (int)ch[j];  //add ascii values of each character to sum
            }
            val= sum % hashtableSize;
            temp=val;
            while(hashtable[val]!=null)
            {
                //quadratic probing
                val=temp+(it*it);
                collisions++;
                it++;
            }
            hashtable[val] = p[i]; 
            loadFactor= loadFactor(hashtable,hashtableSize);
            
        }
        System.out.println("Loadfactor is: "+loadFactor);   
        System.out.println("Number of collisions: "+collisions);
        return hashtable;
    }
    public static double loadFactor(String[] hashtable, int hashtableSize)
    {//check number of elements in the  hashtable after hashing
        double N=0;
        for(String s: hashtable)
        {
            if(s!=null)
            {
                N++;
            }
        }
        return N/(double)hashtableSize;
    }
    public static int nextPrimeSize(int h)
    {
        //new table size is nearest double prime number
        int n= h*2;
        int p;
        for(int k=n+1;;k++)
        {
            for(int i=2; i<=k;i++)
            {
                if(i==k)
                {
                     p=i;
                     System.out.println("Hashtable resized to size: "+p);
                     return p;
                }
                if(k%i==0)
                {
                    break;
                }
            }  
        }      
        
    }
}
    

