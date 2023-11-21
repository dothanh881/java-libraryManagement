package project_library;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonManagement implements LibraryManagement {
Scanner sc=new Scanner(System.in);
private ArrayList<Person> list;
public PersonManagement()
{
    list=new ArrayList<Person>();
}

public PersonManagement(ArrayList<Person> arr)
{
  list=arr;
}

public void pressContinue()
	{
		String keyContinue;
		System.out.println("Press Enter to continue... ");
		keyContinue=sc.nextLine();
	}
    public void Add(){};
    public void Delete(){};
    public void Edit(){};
    public void Search(){};
    public void Display()
    {
        ArrayList<Reader> disk=new ArrayList<Reader>();
		System.out.println("===============*==============");
    	System.out.println("list of book: ");
		System.out.println("\n");
    	for(Person listTest:list)
    	{
    		if(listTest instanceof Staff)
    		{
    			Staff bk=(Staff)listTest;
    			bk.display();
				System.out.println("\n");
    		}
    		else if(listTest instanceof Reader)
    		{
    			Reader dk=(Reader)listTest;
    			disk.add(dk);
    		}
    	}
				
        System.out.println("\n");
        System.out.println("===============*==============");
    	System.out.println("list of disk: ");
    	for(Reader sr:disk)
    	{
    		sr.display();
            System.out.println("\n ");

    	}

    }
}
