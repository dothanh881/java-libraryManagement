package test;

import java.io.Console;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class maintest {
	
     public static void main(String args[]) throws IOException 
     {
    	 Scanner sc=new Scanner(System.in);
    	 	String a;

    	 int choose;
    	while(true)
    	{

            System.out.print("\033[H\033[2J");  
			System.out.flush();
    		System.out.println("1. Enter number 1");
    		System.out.println("2. enter number 2 ");
    		System.out.println("enter number");
    		choose=sc.nextInt();
            sc.nextLine();
    		switch(choose)
    		{
    		case 1:
    			System.out.println("number "+1);
                System.out.println("Press Enter to continue... ");
                System.in.read();
    			break;
    		case 2:
    			System.out.println("number "+2);
                     System.out.println("Press Enter to continue... ");
                     a=sc.nextLine();
    			break;
    		}
    		System.out.println("\u000C");

    		
    	}
    	 
     }
  
}

