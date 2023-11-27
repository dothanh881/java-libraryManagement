package project_library;

import java.security.AlgorithmParameterGeneratorSpi;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Person {
  private String name;
  private String gender;
  private String adress;
  private int age;
  private String id;
  Scanner sc=new Scanner(System.in);
  public void pressContinue()
	{
		String keyContinue;
		System.out.println("Press Enter to continue... ");
		keyContinue=sc.nextLine();
	}
public Person(String name, String gender, String adress, String id,int age) {
	this.name = name;
	this.gender = gender;
	this.adress = adress;
	this.id = id;
    this.age=age;
}
public Person() {
	this.name = " ";
	this.gender = " ";
	this.adress = " ";
	id = " ";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAge() {
	return age;
}
public void setAge(int Age) {
	this.age = Age;
}
public String getAddress() {
	return adress;
}
public void setData(String data) {
	this.adress = data;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public void display()
{
   System.out.println("Id     : "+this.id);
   System.out.println("Name   : "+this.name);
   System.out.println("Gender : "+this.gender);
   System.out.println("Address:"+this.adress);
   System.out.println("Age    : "+this.age);

}
public void displayTable()
{

}
public void enterData(ArrayList<Person> list)
{
    System.out.println("Enter name of the person: ");
    this.name=sc.nextLine();
    System.out.println("Enter address: ");
    this.adress=sc.nextLine();
    while(true)
		{
            try 
            {
			   System.out.println("Enter age of the person: ");
			   this.age=sc.nextInt();
			   sc.nextLine();
			   break;
		    }
            catch(Exception e)
		    {
			    System.out.println(" Entered data is not suitable!! ");
			    sc.nextLine();
				pressContinue();
	        	

		    }
		}
    id: while(true)
			{
				int flag=0;int index=-1;int i=0;

				System.out.println("Enter ID: ");
		        this.id=sc.nextLine();
				String temp=((this.id).toLowerCase()).trim();
				for(Person d:list)
				{
					String gd =((d.getId()).toLowerCase()).trim();
					if(temp.contentEquals(gd))
					{
						flag=1;
						index=i;
					}
					i++;

				}
				if(flag==0) break id;
				if(flag==1) 
				{
					System.out.println("\n");
					list.get(index).displayTable();
					System.out.println("Id person exists !! Please enter again!");
					pressContinue();
				}

				
			}
    
    gender:while(true)
    {
        int flag=0;
        try
        {
        ClearScreen.clear();
        System.out.println("Choose gender: ");
        System.out.println("1. Female");
        System.out.println("2. Male");
        System.out.println("3. Other");
        int choose;
        System.out.println("Enter the gender follow number: ");
        choose=sc.nextInt();
        sc.nextLine();
          switch (choose)
           {
               case 1:
                this.gender="Female";
                flag=1;
                break;
                case 2:
                this.gender="Male";
                flag=1;
                break;
                case 3:
                this.gender="Other";
                flag=1;
                break;
                default:
                System.out.println("Entered data is not suitable!! Please enter again!");
                pressContinue();
                break;
           }
        }
        catch(Exception e)
        {
            System.out.println("Choice is not suitable ! Please enter again!");
            sc.nextLine();
            pressContinue();
        }
        if(flag==1) break gender;

    }

}

public abstract double serviceFee();


  
}

