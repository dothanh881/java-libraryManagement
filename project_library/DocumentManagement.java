package project_library;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
public class DocumentManagement implements LibraryManagement {
    Scanner sc=new Scanner(System.in);
	private ArrayList<Document> list;
    

    public DocumentManagement()
    {
        list=new ArrayList<Document>();
    }

    public DocumentManagement(ArrayList<Document> arr)
    {
      list=arr;
    }

	public ArrayList<Document> getDocumentManagement()
	{
             return list;
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
		m=(m.toLowerCase()).trim();
		int flag=0;int i=0;int index=-1;
		for(Document r:list)
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
			  /*   System.out.println("0. press number 0 to end add document");
    		    System.out.println("1. press number 1 to add book ");
    		    System.out.println("2. press number 2 to add read disk ");
				*/
				System.out.println("          ADD DOCUMENT        ");
				System.out.println("-----------------------------------------------------------------------");
				System.out.printf("| %-20s | %-20s | %-20s |\n"," 1. ADD BOOK "," 2. ADD DISK ","  0. END ");
				System.out.println("-----------------------------------------------------------------------");
    		    System.out.println("enter type document want to add ");
		     	choose=sc.nextInt();
		    	sc.nextLine();
			    if(choose==0) break work_add ;			
    		    switch(choose)
    	    	{
				
    	        case 1: // thêm sách
    			Document bk=new Book();
				bk.enterData( main.rmt.getReadRoom());
				bk.enterId(list);
				list.add(bk);
				System.out.println("add book successfully");
				pressContinue();
				break;

			    case 2:
				Document dk=new Disk();
				dk.enterData( main.rmt.getReadRoom());
				dk.enterId(list);
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
		String choice;
		int checkId=checkIdRoom(request);
		
		if(checkId==-1) {
			System.out.println("document you want to delete no exits or is deleted before");
			pressContinue();

		}
		else if(checkId!=-1)
		{
			String yes="y";
			String no="n";
			clearScreen();
			list.get(checkId).displayTable();
			System.out.println("\n");
            action:while(true)
			{			
			   System.out.println("are you sure want to delete  this document (yes/no)? ");			
			   System.out.println("enter 'y' to choose 'yes' and enter 'n' to choose 'no' ");
			   choice=sc.nextLine();
			   (choice.toLowerCase()).trim();
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
	request=sc.nextLine();
	request=(request.toLowerCase()).trim();
	int checkId=checkIdRoom(request);
		
	if(checkId==-1)
	{
		System.out.println("document you want to edit no exits ");
		pressContinue();
	}
	else
	{
		Book temp=new Book();
		String id=" ";
		if(list.get(checkId) instanceof Book)
		{
		     temp= (Book)list.get(checkId);
			 type =1;
			  id=temp.getId();
		}	
 
		Disk temp1=new Disk();
		String id1=" ";
		if(list.get(checkId) instanceof Disk)
		{
			temp1= (Disk)list.get(checkId);
			type=2;
			 id1=temp1.getId();
		}	
		list.remove(checkId);
 
		if(type==1)
		{
			Document sr=new Book();
			temp.displayTable();
			System.out.println("\n");
			System.out.println("enter data new for book");
			sr.enterData( main.rmt.getReadRoom());	
			sr.setId(id);						
 			list.add(checkId, sr);				    

		}				 
		else if(type==2)
		{
			Document rd=new Disk();
			temp1.displayTable();
			System.out.println("\n");
			System.out.println("enter data new for disk");
			rd.enterData( main.rmt.getReadRoom()); 
			rd.setId(id1);           
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
	int flag=0;int flagsg=0;
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
		System.out.println("document you want find ");
		for(Document c: cmm)
		{
			if(c instanceof Book)
			{
				Book cr=(Book) c;
				cr.display();
				cr.searchLocation(main.rmt.getReadRoom());
			}
			else if( c instanceof Disk)
			{
				Disk dr= (Disk) c;
				dr.display();
				dr.searchLocation(main.rmt.getReadRoom());
			}

		}

	}
	 if(flagsg==2)
	{
		System.out.println("document suggest: ");
		for(Document c:cmn)
		{
			if(c instanceof Book)
			{
				Book cr=(Book) c;
				cr.displayTable();
				//cr.searchLocation(main.rmt.getReadRoom());
			}
			else if( c instanceof Disk)
			{
				Disk dr= (Disk) c;
				dr.displayTable();
			//	dr.searchLocation(main.rmt.getReadRoom());
			}
		}
	}
	if(flag==0&&flagsg==0) System.out.println("No documents found matching the keyword!!");
	pressContinue();
	
	
}

  public   void Display()
  {    ArrayList<Disk> disk=new ArrayList<Disk>();   
	    System.out.println("        BOOK LIST      ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-50s | %-30s |%-23s |%-5s |\n","ID ", "Name", "Author  ","Type ","Page ");
		for(Document listTest:list)
    	{
    		if(listTest instanceof Book)
    		{
    			Book bk=(Book)listTest;
				System.out.printf("| %-15s | %-50s | %-30s |%-23s |%-5s |\n",bk.getId(), bk.getName(), bk.getAuthor(),bk.getType(),bk.getPage());

    		}
    		else if(listTest instanceof Disk)
    		{
    			Disk dk=(Disk)listTest;
    			disk.add(dk);
    		}
    	}
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");
        System.out.println("          DISK LIST");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-14s | %-37s | %-25s |%-17s |%-15s |%-15s |\n","ID ", "Name", "Author  ","Type ","Time (minute) ","Ram (Gb) ");
    	for(Disk sr:disk)
    	{
    		System.out.printf("| %-14s | %-37s | %-25s |%-17s |%-15s |%-15s |\n",sr.getId(), sr.getName(), sr.getAuthor(),sr.getType(),sr.getTime(),sr.getRam());

    	}
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------");


   /*  ArrayList<Disk> disk=new ArrayList<Disk>();
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

  }*/
    
   }
}
