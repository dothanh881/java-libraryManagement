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

public ArrayList<Reader> geListReader()
{
	ArrayList<Reader> rdr=new ArrayList<Reader>();
	for(Person p: list)
	{
          if(p instanceof Reader)
		  {
			Reader r=(Reader) p;
			rdr.add(r);
		  }
	}
	return rdr;
}

public void pressContinue()
	{
		String keyContinue;
		System.out.println("Press Enter to continue... ");
		keyContinue=sc.nextLine();
	}

	// kiểm tra id trùng
	public int checkIdPerson( String m)
	{
		m=(m.toLowerCase()).trim();
		int flag=0;int i=0;int index=-1;
		for(Person r:list)
		{
			
				if(((r.getId().toLowerCase()).trim()).contentEquals(m))
				{
					flag=1;
					index=i;
			
				}
			
			i++;
		}
		if(flag==1) return index;
       return -1;
	}

	//Hàm thêm
    public void Add()
	{
		while(true)
		{
		  try
		  {
			  int choose;       
			  work_add:while(true)
			  {
				  ClearScreen.clear();
				 /*  System.out.println("0. press number 0 to end add person");
				  System.out.println("1. press number 1 to add staff ");
				  System.out.println("2. press number 2 to add reader ");
				  System.out.println("enter type person want to add follow number  ");*/
                  System.out.println("         ADD PERSON          ");
				  System.out.println("-----------------------------------------------------------------------");
				  System.out.printf("| %-20s | %-20s | %-20s |\n"," 1. ADD STAFF "," 2. ADD READER ","  0. END ");
				  System.out.println("-----------------------------------------------------------------------");
				  System.out.println("enter type person want to add follow number  ");
				   choose=sc.nextInt();
				  sc.nextLine();
				  if(choose==0) break work_add ;			
				  switch(choose)
				  {
				  
				  case 1: // thêm staff
				  
				  Staff bk=new Staff();
				  bk.enterData(list,main.rmt.getServiceRoom());
				  list.add(bk);
				  System.out.println("add staff successfully");
				  pressContinue();
				  break;
  
				  case 2:
				  Reader dk=new Reader();
				  dk.enterData(list);
				  dk.enterIdcard(list);
				  list.add(dk);
				  System.out.println("add reader successfully");
				  pressContinue();
				  break;				   
				  }
					
			  }
  
			  break;
		  }
		  catch(Exception e)
		  {
			  System.out.println("data error! ");
			  sc.nextLine();
			  pressContinue();
		  }
		}
		pessContinue.press();
		ClearScreen.clear();
	}


    public void Delete()
	{
		Display();
		String request;
		System.out.println("enter id person you want to delete ");
		request=sc.nextLine();
		request.toLowerCase();
		String choice;
		int checkId=checkIdPerson(request);
		
		if(checkId==-1) {
			System.out.println("person you want to delete no exits or is deleted before");
			pressContinue();

		}
		else if(checkId!=-1)
		{
			String yes="y";
			String no="n";
			ClearScreen.clear();
			list.get(checkId).displayTable();
			
            action:while(true)
			{			
			   System.out.println("are you sure want to delete  this person (yes/no)? ");			
			   System.out.println("enter 'y' to choose 'yes' and enter 'n' to choose 'no' ");
			   choice=sc.nextLine();
			  choice=(choice.toLowerCase()).trim();
		        if(choice.contentEquals(yes))
			    {
				    list.remove(checkId);
				    System.out.println("you have deleted sucessful ");
				    pressContinue();
				    break action;
			    }
			    else if(choice.contentEquals(no))
			    {
				    System.out.println("delete failed");
				    pressContinue();
				    break action;
			    }
			    else
			    {
				    System.out.println("your choice is unsuitable!! please enter again");
				    pressContinue();
			    }
			}
			

		}
		pressContinue();
		ClearScreen.clear();
	}

	//
    public void Edit()
	{
		Display();
		String request;String save;int type=0;
		System.out.println("enter id person you want to edit ");
		request=sc.nextLine();
		request=(request.toLowerCase()).trim();
		int checkId=checkIdPerson(request);
			
		if(checkId==-1)
		{
			System.out.println("person you want to edit no exits ");
			pressContinue();
		}
		else
		{
			Staff temp=new Staff();
			if(list.get(checkId) instanceof Staff)
			{
				 temp= (Staff)list.get(checkId);
				 type =1;
			}	
	 
			Reader temp1=new Reader();
			String idcards=" ";
			if(list.get(checkId) instanceof Reader)
			{
				temp1= (Reader)list.get(checkId);
				type=2;
				idcards=temp1.getIdcard();
			}	
			list.remove(checkId);
	 
			if(type==1)
			{
				Staff sr=new Staff();
				temp.displayTable();
				System.out.println("enter data new for Staff");
				sr.enterData(list, main.rmt.getServiceRoom());							
				 list.add(checkId, sr);				    
	
			}				 
			else if(type==2)
			{
				Reader rd=new Reader();
				temp1.displayTable();
				System.out.println("enter data new for Reader");
				rd.enterData(list);   
				rd.setIdcard(idcards);         
				list.add(checkId,rd);
			}
			action:while(true)
					{
						System.out.println("are you sure want to save change this (yes/no)? ");
						System.out.println("enter 'y' to choose 'yes' and enter 'n' to choose no");
						save=sc.nextLine();
						save.toLowerCase();
						if(save.contentEquals("y"))
						{
						  System.out.println("you have save change sucessful ");
						  pressContinue();
						  break action;
						}
						else if(save.contentEquals("n"))
						{
						  list.remove(checkId);
						  System.out.println("save change failed");
						  if(type==1) list.add(checkId,temp);					
						  else if(type==2) list.add(checkId,temp1); 
						  pressContinue();
						  break action;
						}
						else
						{
						  System.out.println("your choice is unsuitable!! please enter again");
						  pressContinue();
						}
					}
	 
		}
		pressContinue();
		ClearScreen.clear();
	}

	// Tìm kiếm
    public void Search()
	{
		String request; ArrayList <Person>cmm=new ArrayList<Person>();
	ArrayList<Person> cmn= new ArrayList<Person>();
	System.out.println("enter key word person (id,address,name,gender) you want to search ");
	request=sc.nextLine();
	String temp=(request.toLowerCase()).trim();
	int flag=0;int flagsg=0;
	for(Person dm:list)
	{
		String gn=((dm.getName()).toLowerCase()).trim();
		String ga=((dm.getGender()).toLowerCase()).trim();
		String gd=((dm.getId()).toLowerCase()).trim();
		String gt=((dm.getAddress()).toLowerCase()).trim();
		if(temp.contentEquals(gn)||temp.contentEquals(ga)||temp.contentEquals(gd)||temp.contentEquals(gt))
		{
			cmm.add(dm);
			flag=1;
		}
		else if(gn.contains(temp)||ga.contains(temp)||gd.contains(temp)||gt.contains(temp))
		{
			cmn.add(dm);
			flagsg=2;
		}
		else if(temp.contains(gn)||temp.contains(ga)||temp.contains(gd)||temp.contains(gt))
		{
			cmn.add(dm);
			flagsg=2;
		}
	}
	if(flag==1)
	{
		System.out.println("person you want find ");
		for(Person c: cmm)
		{
			if(c instanceof Staff)
			{
				Staff cr=(Staff) c;
				cr.display();
				cr.searchLocation(main.rmt.getServiceRoom());
				cr.serviceFee();
			}
			else if( c instanceof Reader)
			{
				Reader dr= (Reader) c;
				dr.display();
				dr.serviceFee();
			}

		}

	}
	 if(flagsg==2)
	{
		System.out.println("Suggest person: ");
		for(Person c:cmn)
		{
			if(c instanceof Staff)
			{
				Staff cr=(Staff) c;
				cr.displayTable();
				cr.searchLocation(main.rmt.getServiceRoom());
		
			}
			else if( c instanceof Reader)
			{
				Reader dr= (Reader) c;
				dr.displayTable();
			}
		}
	}
	if(flag==0 && flagsg==0) System.out.println("No person found matching the keyword!!");
	pressContinue();
	ClearScreen.clear();

	}

	//Hàm xuất kết quả
    public void Display()
    {
        ArrayList<Reader> disk=new ArrayList<Reader>();
		System.out.println("        STAFF LIST       ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-27s | %-10s |%-20s |%-10s |%-15s |\n","ID ", "Name", "Gender  ","Address ","Age ","Position ");
        for(Person listTest:list)
    	{
    		if(listTest instanceof Staff)
    		{
    			Staff bk=(Staff)listTest;
				System.out.printf("| %-15s | %-27s | %-10s |%-20s |%-10s |%-15s |\n",bk.getId(), bk.getName(), bk.getGender(),bk.getAddress(),bk.getAge(),bk.getPosition());
    		}
    		else if(listTest instanceof Reader)
    		{
    			Reader dk=(Reader)listTest;
    			disk.add(dk);
    		}
    	} 
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
         System.out.println("\n");

		System.out.println("        READER LIST       ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-27s | %-10s |%-20s |%-10s |%-15s |%-15s |\n","ID ", "Name", "Gender  ","Address ","Age ","Type card ","Job ");
        for(Reader bk:disk)
    	{
    		
			System.out.printf("| %-15s | %-27s | %-10s |%-20s |%-10s |%-15s |%-15s |\n",bk.getId(), bk.getName(), bk.getGender(),bk.getAddress(),bk.getAge(),bk.getTypeCard(),bk.getJob());
    		
    	} 
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

		/*System.out.println("===============*==============");
    	System.out.println("list of Staff: ");
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
    	System.out.println("list of reader: ");
    	for(Reader sr:disk)
    	{
    		sr.display();
            System.out.println("\n ");
    	}*/
        pessContinue.press();
		ClearScreen.clear();
    }

   

}
