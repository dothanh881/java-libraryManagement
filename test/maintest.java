package test;

import java.io.Console;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class maintest {
	
     public static void main(String args[]) throws IOException 
     {
    	 Scanner sc=new Scanner(System.in);
    	 	String a="thanh nien VIT NAM ";

       try{
          FileWriter fw= new FileWriter("c:\\users\\admin\\desktop\\input.txt");
          fw.write(a);
          fw.write(",");
          fw.write("\n");
          fw.write(1);
          System.out.println("sucess");
          fw.close();

       }catch(Exception e)
       {
          System.out.println(e);
       }
    	 

    		
    	
    	 
     }
  
}

