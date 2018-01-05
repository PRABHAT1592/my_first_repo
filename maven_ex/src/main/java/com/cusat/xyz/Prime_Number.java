package com.cusat.xyz;

import java.io.*;
import java.util.Scanner;
public class Prime_Number {
     public static void main(String args[]) {
    	 Scanner scan=new Scanner(System.in);
    	 System.out.println("enter the Number=");
    	 int num=scan.nextInt();
    	 int i=0;
    	 for(int p=2;p<=num;p++) {
    		 if(num%p==0) {
    			 i++;
    			 break;
    		 }
    	 }
    	 if(i==1) {
    		 System.out.println("Not a prime number");
    	 }
    	 else {
    		 System.out.println("Prime Number");
    	 }
     }
}