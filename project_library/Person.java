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
public String getData() {
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

}
public void enterData(ArrayList<Person> list)
{
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
					System.out.println("Id document is exist!!please enter again");
					pressContinue();
				}

				
			}
    
    System.out.println("");
}

  
}

