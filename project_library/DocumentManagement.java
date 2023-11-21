package project_library;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
public class DocumentManagement implements LibraryManagement {
    Scanner sc=new Scanner(System.in);
	private ArrayList<Document> list;
	private ArrayList<ReadRoom>listrd;
    
    public DocumentManagement()
    {
        list=new ArrayList<Document>();
    }

    public DocumentManagement(ArrayList<Document> arr,ArrayList<ReadRoom> ars)
    {
      list=arr;
	  listrd=ars;
    }

    // hàm xóa màn hình
	public void clearScreen()
	{
		System.out.print("\033[H\033[2J");  // clear sreen
		System.out.flush();
	}

	// hàm dừng màn hình
	public void pressContinue()
	{
		String keyContinue;
		System.out.println("Press Enter to continue... ");
		keyContinue=sc.nextLine();
	}

	// hàm kiểm tra id trùng
	public int checkIdRoom( String m)
	{
		m.toLowerCase();
		int flag=0;int i=0;int index=-1;
		for(Document r:list)
		{
			
				if(r.getId().toLowerCase().contentEquals(m))
				{
					flag=1;
					index=i;
			
				}
			
			i++;
		}
		if(flag==1) return index;
       return -1;
	}

	public void Add() 
	{		
      while(true)
	  {
		try
		{
		    int choose;       
            work_add:while(true)
    	    {
			    clearScreen();
			    System.out.println("0. press number 0 to end add document");
    		    System.out.println("1. press number 1 to add book ");
    		    System.out.println("2. press number 2 to add read disk ");
    		    System.out.println("enter type document want to add ");
		     	choose=sc.nextInt();
		    	sc.nextLine();
			    if(choose==0) break work_add ;			
    		    switch(choose)
    	    	{
				
    	        case 1: // thêm sách
    			Book bk=new Book();
				bk.enterData(list, listrd);
				list.add(bk);
				System.out.println("add book successfully");
				pressContinue();
				break;

			    case 2:
				Disk dk=new Disk();
				dk.enterData(list, listrd);
				list.add(dk);
				System.out.println("add disk successfully");
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
    	
    };


  public  void Delete()
    {
	    Display();
		String request;
		System.out.println("enter id document you want to delete ");
		request=sc.nextLine();
		request.toLowerCase();
		Room r=new Room();int flag=0;String choice;int i=0;int index=0;
		int checkId=checkIdRoom(request);
		
		if(checkId==-1) {
			System.out.println("room you want to delete no exits or is deleted before");
			pressContinue();

		}
		else if(checkId!=-1)
		{
			String yes="y";
			String no="n";
			clearScreen();
			list.get(checkId).display();
			
            action:while(true)
			{			
			   System.out.println("are you sure want to delete  this document (yes/no)? ");			
			   System.out.println("enter 'y' to choose 'yes' and enter 'n' to choose 'no' ");
			   choice=sc.nextLine();
			   choice.toLowerCase();
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
    }

public  void Edit()
{
	
	Display();
	String request;String save;int type=0;
	System.out.println("enter id document you want to edit ");
	request=sc.nextLine();String end=" ";int new_num;
	request.toLowerCase();
	int checkId=checkIdRoom(request);
		
	if(checkId==-1)
	{
		System.out.println("document you want to edit no exits ");
		pressContinue();
	}
	else
	{
		Book temp=new Book();
		if(list.get(checkId) instanceof Book)
		{
		     temp= (Book)list.get(checkId);
			 type =1;
		}	
 
		Disk temp1=new Disk();
		if(list.get(checkId) instanceof Disk)
		{
			temp1= (Disk)list.get(checkId);
			type=2;
		}	
		list.remove(checkId);
 
		if(type==1)
		{
			Book sr=new Book();
			temp.display();
			System.out.println("enter data new for book");
			sr.enterData(list, listrd);							
 			list.add(checkId, sr);				    

		}				 
		else if(type==2)
		{
			Disk rd=new Disk();
			temp1.display();
			System.out.println("enter data new for disk");
			rd.enterData(list, listrd);            
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
		 		 
}
public  void Search()
{
	String request; ArrayList <Document>cmm=new ArrayList<Document>();
	ArrayList<Document> cmn= new ArrayList<Document>();
	System.out.println("enter key word document (id,author,name,type) you want to search ");
	request=sc.nextLine();
	String temp=(request.toLowerCase()).trim();
	int flag=0;
	for(Document dm:list)
	{
		String gn=((dm.getName()).toLowerCase()).trim();
		String ga=((dm.getAuthor()).toLowerCase()).trim();
		String gd=((dm.getId()).toLowerCase()).trim();
		String gt=((dm.getType()).toLowerCase()).trim();
		if(temp.contentEquals(gn)||temp.contentEquals(ga)||temp.contentEquals(gd)||temp.contentEquals(gt))
		{
			cmm.add(dm);
			flag=1;
		}
		else if(gn.contains(temp)||ga.contains(temp)||gd.contains(temp)||gt.contains(temp))
		{
			cmn.add(dm);
			flag=2;
		}
	}
	if(flag==1)
	{
		System.out.println("document you want find ");
		for(Document c: cmm)
		{
			if(c instanceof Book)
			{
				Book cr=(Book) c;
				cr.display();
				cr.searchLocation(listrd);
			}
			else if( c instanceof Disk)
			{
				Disk dr= (Disk) c;
				dr.display();
				dr.searchLocation(listrd);
			}

		}

	}
	else if(flag==2)
	{
		System.out.println("document suggest: ");
		for(Document c:cmn)
		{
			if(c instanceof Book)
			{
				Book cr=(Book) c;
				cr.display();
				cr.searchLocation(listrd);
			}
			else if( c instanceof Disk)
			{
				Disk dr= (Disk) c;
				dr.display();
				dr.searchLocation(listrd);
			}
		}
	}
	if(flag==0) System.out.println("No documents found matching the keyword!!");
	pressContinue();
	
	
}

  public   void Display()
  {
    ArrayList<Disk> disk=new ArrayList<Disk>();
		System.out.println("===============*==============");
    	System.out.println("list of book: ");
		System.out.println("\n");
    	for(Document listTest:list)
    	{
    		if(listTest instanceof Book)
    		{
    			Book bk=(Book)listTest;
    			bk.display();
				System.out.println("\n");
    		}
    		else if(listTest instanceof Disk)
    		{
    			Disk dk=(Disk)listTest;
    			disk.add(dk);
    		}
    	}
				
        System.out.println("\n");
        System.out.println("===============*==============");
    	System.out.println("list of disk: ");
    	for(Disk sr:disk)
    	{
    		sr.display();
            System.out.println("\n ");

    	}

  }
    
    
}
