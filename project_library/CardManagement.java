package project_library;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
public class CardManagement implements LibraryManagement {
   Scanner sc=new Scanner(System.in);
	private ArrayList<Card> list;
    
    public CardManagement()
    {
        list=new ArrayList<Card>();
    }

    public CardManagement(ArrayList<Card> arr)
    {
      list=arr;
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

   public ArrayList<Card> getListCards()
   {
      return list;
   }

   public ArrayList <String> getIdOnwer()
   {
      ArrayList <String> a=new ArrayList<String>();
      for(Card cd:list)
      {
         a.add(cd.getIdOnwer());
      }
      return a;
   }

   
	public ArrayList<CardBorrow> getListCardBorrow()
	{
		ArrayList<CardBorrow> a =new ArrayList<CardBorrow>();
		for(Card r:list)
		{
           if(r instanceof CardBorrow)
		   {
              CardBorrow m=(CardBorrow) r;
			  a.add(m);
		   }
		}
		return a;
	}
	public ArrayList<CardNormal> getListCardNormal()
	{
		ArrayList<CardNormal> a =new ArrayList<CardNormal>();
		for(Card r:list)
		{
           if(r instanceof CardNormal)
		   {
              CardNormal m=(CardNormal) r;
			  a.add(m);
		   }
		}
		return a;
	}

   public int checkIdCard( String m)
	{
		m=(m.toLowerCase()).trim();
		int flag=0;int i=0;int index=-1;
		for(Card r:list)
		{
			
				if(((r.getIdCard().toLowerCase()).trim()).contentEquals(m))
				{
					flag=1;
					index=i;
			
				}
			
			i++;
		}
		if(flag==1) return index;
       return -1;
	}

	public int checkIdOwner( String m)
	{
		m=(m.toLowerCase()).trim();
		int flag=0;int i=0;int index=-1;
		for(Card r:list)
		{
			
			
				if(((r.getIdOnwer().toLowerCase()).trim()).contentEquals(m))
				{
					flag=1;
					index=i;
			
				}
			
			i++;
		}
		if(flag==1) return index;
       return -1;
	}

	public ArrayList<String> getIdOwnerFromFullName(String nameReader)
	{
		ArrayList<String>temp=new ArrayList<String>();
		nameReader=(nameReader.toLowerCase()).trim();
		for(Reader rdr:main.pmt.geListReader())
		{
             String a=((rdr.getName()).toLowerCase()).trim();
			 if(a.contentEquals(nameReader))
			 {
				temp.add(rdr.getIdcard());
			 }
		}
		return temp;
	}

	public  ArrayList<String> getIdOwnerFromSuggestName(String nameReader)
	{
		ArrayList<String>temp=new ArrayList<String>();
		nameReader=(nameReader.toLowerCase()).trim();
        for(Reader rdr:main.pmt.geListReader())
		{
             String a=((rdr.getName()).toLowerCase()).trim();
			 if(a.contains(nameReader))
			 {
				temp.add(rdr.getIdcard());
			 }
			 else if(nameReader.contains(a))
			 {
				temp.add(rdr.getIdcard());
			 }
		}

		return temp;

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
				ClearScreen.clear();

				 // System.out.println("0. press number 0 to end add card");
				//  System.out.println("1. press number 1 to add card normal ");
				//  System.out.println("2. press number 2 to add card borrow(vip,bussines) ");
				System.out.println("          ADD CARD        ");
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.printf("| %-25s | %-25s | %-25s |\n"," 1. ADD CARD NORMAL "," 2. ADD CARD BORROW ","  0. END ");
				System.out.println("-------------------------------------------------------------------------------------");
    		    System.out.println("Enter type card want to add: ");
				  choose=sc.nextInt();
				  sc.nextLine();
				  if(choose==0) break work_add ;			
				switch(choose)
				{
				  
				  case 1: // thêm thẻ thường			  
				  CardNormal bk=new CardNormal();
                  int flag1=-1;
                   flag1=bk.enterIdOwner();
                   if(flag1==0)
                   {
                       System.out.println("Add normal card unsuccessfully!");
				       pressContinue();
                   }
                   else
                   {
				     bk.enterIdcard(list); 
                     bk.enterTimeUse();
				     list.add(bk);
				     System.out.println("Add normal card successfully!");
				     pressContinue();
                  }
				  break;
  
				  case 2:
				  CardBorrow dk=new CardBorrow();
                  int flag2= dk.enterIdOwner();
				  ClearScreen.clear();
                  if(flag2==0)
                  {
                       System.out.println("Add borrow card unsuccessfully!");
				       pressContinue();
                  }
                  else
                  {
			        	dk.enterIdcard(list);
                        dk.enterDocumentBorrow();
			        	list.add(dk);
				        System.out.println("Add borrow card successfully!");
				        pressContinue();
                  }
				  break;				   
				  }
					
			   }
  
			  break;
		   }
		   catch(Exception e)
		   {
			  System.out.println("Data error! Please enter again!");
			  	sc.nextLine();
			  e.printStackTrace();
			  pressContinue();
		   }
		}
   }

   public void Delete()
   {
	Display();
		String request;
		System.out.println("Enter id of the person you want to delete: ");
		request=sc.nextLine();
		request.toLowerCase();
		String choice;
		int checkId=checkIdCard(request);
		
		if(checkId==-1) {
			System.out.println("Person you want to delete that does not exit or can be deleted before!");
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
			   System.out.println("Are you sure want to delete  this card (yes/no)? ");			
			   System.out.println("Enter 'y' to choose 'yes' and enter 'n' to choose 'no' ");
			   choice=sc.nextLine();
			  choice=(choice.toLowerCase()).trim();
		        if(choice.contentEquals(yes))
			    {
				    list.remove(checkId);
				    System.out.println("You have deleted sucessfully! ");
				    pressContinue();
				    break action;
			    }
			    else if(choice.contentEquals(no))
			    {
				    System.out.println("Delete failed");
				    pressContinue();
				    break action;
			    }
			    else
			    {
				    System.out.println("Your choice is unsuitable!! Please enter again!");
				    pressContinue();
			    }
			}
			

		}
   }
   public void Edit()
   {
	Display();
	String request;String save;int type=0;
	System.out.println("Enter id of the card you want to edit: ");
	request=sc.nextLine();
	request=(request.toLowerCase()).trim();
	int checkId=checkIdCard(request);
		
	if(checkId==-1)
	{
		System.out.println("Card you want to edit does not exit!");
		pressContinue();
	}
	else
	{
		CardNormal temp=new CardNormal();
		String idCard=" ";
		if(list.get(checkId) instanceof CardNormal)
		{
			 temp= (CardNormal)list.get(checkId);
			 type =1;
			 idCard=temp.getIdOnwer();
		}	
 
		CardBorrow temp1=new CardBorrow();
		String idcards=" ";
		ArrayList<CardDetail>listTemp=new ArrayList<CardDetail>();
		if(list.get(checkId) instanceof CardBorrow)
		{
			temp1= (CardBorrow)list.get(checkId);
			type=2;
			idcards=temp1.getIdOnwer();
			listTemp=temp1.getListBorrow();
		}	
		list.remove(checkId);
 
		if(type==1)
		{
			CardNormal sr=new CardNormal();
			temp.displayTable();
			System.out.println("Enter new data for normal card: ");
			sr.enterIdcard(list);
			sr.enterTimeUse();
			sr.setIdOnwer(idCard);
			 list.add(checkId, sr);				    

		}				 
		else if(type==2)
		{
			CardBorrow rd=new CardBorrow();
			temp1.displayTable();
			System.out.println("Enter new data for borrow card: ");
			rd.enterIdcard(list);
			actions:while(true)
				{
					System.out.println("Are you sure want to change list borrow document (yes/no)? ");
					System.out.println("Enter 'y' to choose 'yes' and enter 'n' to choose no: ");
					save=sc.nextLine();
					save.toLowerCase();
					if(save.contentEquals("y"))
					{
					  rd.enterDocumentBorrow();
					  break actions;
					}
					else if(save.contentEquals("n"))
					{
					   rd.setListBorrow(listTemp);
					   break actions;
					}
					else
					{
					  System.out.println("Your choice is unsuitable!! Please enter again!");
					  pressContinue();
					}
				}
			rd.setIdOnwer(idcards);        
			list.add(checkId,rd);
		}
		action:while(true)
				{
					System.out.println("Are you sure want to save  this change (yes/no)? ");
					System.out.println("Enter 'y' to choose 'yes' and enter 'n' to choose no: ");
					save=sc.nextLine();
					save.toLowerCase();
					if(save.contentEquals("y"))
					{
					  System.out.println("You have saved the change sucessfully! ");
					  pressContinue();
					  break action;
					}
					else if(save.contentEquals("n"))
					{
					  list.remove(checkId);
					  System.out.println("Save change failed");
					  if(type==1) list.add(checkId,temp);					
					  else if(type==2) list.add(checkId,temp1); 
					  pressContinue();
					  break action;
					}
					else
					{
					  System.out.println("Your choice is unsuitable!! Please enter again!");
					  pressContinue();
					}
				}
 
	}
   }

   public void Search()
   {
	String request; ArrayList <Card>cmm=new ArrayList<Card>();
	ArrayList<Card> cmn= new ArrayList<Card>();
	System.out.println("Enter id or name owner you want to search: ");
	request=sc.nextLine();
	String temp=(request.toLowerCase()).trim();
	int flag=0;int flagsg=0;
	ArrayList<String> fullname= new ArrayList<String>();
	fullname=getIdOwnerFromFullName(temp);
	ArrayList<String> suggestname=new ArrayList<String>();
	suggestname=getIdOwnerFromSuggestName(temp);
	if(suggestname.isEmpty()!=true ||fullname.isEmpty()!=true)
	{
	if(fullname.isEmpty()!=true)
	{
		System.out.println("Card you want to find: ");
		for(String n:fullname)
		{
			int indexful=checkIdOwner(n);
			if(indexful!=-1)
			{
				if(list.get(indexful) instanceof CardNormal)
				{
					CardNormal cdl=(CardNormal) list.get(indexful);
					cdl.display();
					System.out.println("\n");
					//cdl.display();
				}
				else if(list.get(indexful) instanceof CardBorrow)
				{
					CardBorrow cdb=(CardBorrow) list.get(indexful);
					cdb.displayDetails();
					System.out.println("\n");
				}
			}
		}
	}
	if(suggestname.isEmpty()!=true)
	{
		System.out.println("Suggest Card you want to find: ");
		for(String n:suggestname)
		{
			int indexsug=checkIdOwner(n);
			if(indexsug!=-1)
			{
				if(list.get(indexsug) instanceof CardNormal)
				{
					CardNormal cdl=(CardNormal) list.get(indexsug);
					cdl.displayTable();
				}
				else if(list.get(indexsug) instanceof CardBorrow)
				{
					CardBorrow cdb=(CardBorrow) list.get(indexsug);
					cdb.displayTable();
				}
			}
		}
	}
    }
	else
	{
	for(Card dm:list)
	{
		
			
		String gd=((dm.getIdCard()).toLowerCase()).trim();
		if(temp.contentEquals(gd))
		{
			cmm.add(dm);
			flag=1;
		}
		else if(gd.contains(temp))
		{
			cmn.add(dm);
			flagsg=2;
		}
		else if(temp.contains(gd))
		{
			cmn.add(dm);
			flagsg=2;
		}
	}
	if(flag==1)
	{
		System.out.println("Card you want to find:");
		for(Card c: cmm)
		{
			if(c instanceof CardNormal)
			{
				CardNormal cr=(CardNormal) c;
				//cr.display();
				cr.display();
				
			}
			else if( c instanceof CardBorrow)
			{
			  CardBorrow  dr= (CardBorrow) c;
				dr.displayDetails();
			}

		}

	}
	 if(flagsg==2)
	{
		System.out.println("\n ");
		System.out.println("Suggest CARD: ");
		for(Card c:cmn)
		{
			if(c instanceof CardNormal)
			{
				CardNormal cr=(CardNormal) c;
				cr.displayTable();
				
			}
			else if( c instanceof CardBorrow)
			{
			  CardBorrow  dr= (CardBorrow) c;
				dr.displayTable();
			}

		}
	}
	if(flag==0 && flagsg==0) System.out.println("No card found matching the keyword!!");
    }
	pressContinue();

   }


   public void Display()
   {
	ArrayList<CardBorrow> cardnormals=new  ArrayList<CardBorrow>();
	System.out.println("        NORMAL CARD LIST      ");
	System.out.println("-----------------------------------------------------------------------------------------------------------------");
	System.out.printf("| %-14s |%-15s | %-36s | %-15s |%-20s |\n","ID Reader ","ID Card", "Name Reader", "Type Card  ","Time Use(day) ");
	System.out.println("-----------------------------------------------------------------------------------------------------------------");
	for(Card listTest:list)
	{
		if(listTest instanceof CardNormal)
		{
			CardNormal bk=(CardNormal)listTest;
			System.out.printf("| %-14s |%-15s | %-36s | %-15s |%-20s |\n",bk.getIdReader(), bk.getIdCard(), bk.getNameReader(),bk.getIdTypeCard(),bk.getTimeUse());

		}
		else if(listTest instanceof CardBorrow)
		{
			CardBorrow dk=(CardBorrow)listTest;
			cardnormals.add(dk);
		}
	}
	System.out.println("-----------------------------------------------------------------------------------------------------------------");
	System.out.println("\n");
	System.out.println("          BORROW CARD    ");
	System.out.println("-----------------------------------------------------------------------------------------------------------------");
	System.out.printf("| %-14s | %-15s | %-36s |%-15s |%-20s |\n","ID Reader ", "ID Card", "Name Reader  ","Type Card ","Time Use ");
	System.out.println("-----------------------------------------------------------------------------------------------------------------");

	for(CardBorrow sr:cardnormals)
	{
		System.out.printf("| %-14s | %-15s | %-36s |%-15s |%-20s |\n",sr.getIdReader(), sr.getIdCard(), sr.getNameReader(),sr.getIdTypeCard()," 1 Year ");

	}
	System.out.println("-----------------------------------------------------------------------------------------------------------------");




     /*  ArrayList<CardBorrow> cardnormals=new  ArrayList<CardBorrow>();
		System.out.println("===============*==============");
    	System.out.println("list of card normal: ");
		System.out.println("\n");
    	for(Card listTest:list)
    	{
    		if(listTest instanceof CardNormal)
    		{
    			CardNormal bk=(CardNormal)listTest;
    			bk.display();
				System.out.println("\n");
    		}
    		else if(listTest instanceof CardBorrow)
    		{
    			CardBorrow dk=(CardBorrow)listTest;
    			cardnormals.add(dk);
    		}
    	}
				
        System.out.println("\n");
        System.out.println("===============*==============");
    	System.out.println("list of card allow borrow: ");
    	for(CardBorrow sr:cardnormals)
    	{
    		   sr.display();
            System.out.println("\n ");

    	}*/
   }
}
