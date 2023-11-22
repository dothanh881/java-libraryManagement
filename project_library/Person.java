package project_library;

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
   System.out.println("id     : "+this.id);
   System.out.println("name   : "+this.name);
   System.out.println("gender : "+this.gender);
   System.out.println("address:"+this.adress);
   System.out.println("age    : "+this.age);

}
public void enterData(ArrayList<Person> list)
{
    System.out.println("enter name person ");
    this.name=sc.nextLine();
    System.out.println("enter adress");
    this.adress=sc.nextLine();
    while(true)
		{
            try 
            {
			   System.out.println("enter age person ");
			   this.age=sc.nextInt();
			   sc.nextLine();
			   break;
		    }
            catch(Exception e)
		    {
			    System.out.println(" age you enterd is not ividial ");
			    sc.nextLine();
				pressContinue();
	        	

		    }
		}
    id: while(true)
			{
				int flag=0;int index=-1;int i=0;

				System.out.println("enter Id: ");
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
					list.get(index).display();
					System.out.println("Id person is exist!!please enter again");
					pressContinue();
				}

				
			}
    
    gender:while(true)
    {
        int flag=0;
        try
        {
        ClearScreen.clear();
        System.out.println("choose gender ");
        System.out.println("1. Women");
        System.out.println("2. Men");
        System.out.println("3. Other");
        int choose;
        System.out.println("enter gender follow number ");
        choose=sc.nextInt();
        sc.nextLine();
          switch (choose)
           {
               case 1:
                this.gender="Women";
                flag=1;
                break;
                case 2:
                this.gender="Men";
                flag=1;
                break;
                case 3:
                this.gender="Other";
                flag=1;
                break;
                default:
                System.out.println("you entered number is ividial !! please enter again");
                pressContinue();
                break;
           }
        }
        catch(Exception e)
        {
            System.out.println("choose is not suitable ! please enter again");
            sc.nextLine();
            pressContinue();
        }
        if(flag==1) break gender;

    }

}
public void Statistic()
{
    int a=Staff.SumStaff()+Reader.getNoReader();
    System.out.println("total person: "+a);
    int b=Staff.AddStaff()+Reader.getNoAddReader();
    System.out.println("total person add"+b);
}
public abstract double serviceFee();


  
}

