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
				  System.out.println("0. press number 0 to end add card");
				  System.out.println("1. press number 1 to add card normal ");
				  System.out.println("2. press number 2 to add card borrow(vip,bussines) ");
				  System.out.println("enter type card want to add follow number  ");
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
                       System.out.println("add normal card unsuccessfully");
				       pressContinue();
                   }
                   else
                   {
				     bk.enterIdcard(list); 
                     bk.enterTimeUse();
				     list.add(bk);
				     System.out.println("add normal card successfully");
				     pressContinue();
                  }
				  break;
  
				  case 2:
				  CardBorrow dk=new CardBorrow();
                  int flag2= dk.enterIdOwner();
				  ClearScreen.clear();
                  if(flag2==0)
                  {
                       System.out.println("add borrow card unsuccessfully");
				       pressContinue();
                  }
                  else
                  {
			        	dk.enterIdcard(list);
                        dk.enterDocumentBorrow();
			        	list.add(dk);
				        System.out.println("add borrow card successfully");
				        pressContinue();
                  }
				  break;				   
				  }
					
			   }
  
			  break;
		   }
		   catch(Exception e)
		   {
			  System.out.println("data error! cho nay ne ");
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
		System.out.println("enter id person you want to delete ");
		request=sc.nextLine();
		request.toLowerCase();
		Room r=new Room();int flag=0;String choice;int i=0;int index=0;
		int checkId=checkIdCard(request);
		
		if(checkId==-1) {
			System.out.println("person you want to delete no exits or is deleted before");
			pressContinue();

		}
		else if(checkId!=-1)
		{
			String yes="y";
			String no="n";
			ClearScreen.clear();
			list.get(checkId).display();
			
            action:while(true)
			{			
			   System.out.println("are you sure want to delete  this card (yes/no)? ");			
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
   }
   public void Edit()
   {
	Display();
	String request;String save;int type=0;
	System.out.println("enter id card you want to edit ");
	request=sc.nextLine();String end=" ";int new_num;
	request=(request.toLowerCase()).trim();
	int checkId=checkIdCard(request);
		
	if(checkId==-1)
	{
		System.out.println("card you want to edit no exits ");
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
			temp.display();
			System.out.println("enter data new for card normal");
			sr.enterIdcard(list);
			sr.enterTimeUse();
			sr.setIdOnwer(idCard);
			 list.add(checkId, sr);				    

		}				 
		else if(type==2)
		{
			CardBorrow rd=new CardBorrow();
			temp1.display();
			System.out.println("enter data new for card borrow");
			rd.enterIdcard(list);
			actions:while(true)
				{
					System.out.println("are you sure want to change list borrow document (yes/no)? ");
					System.out.println("enter 'y' to choose 'yes' and enter 'n' to choose no");
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
					  System.out.println("your choice is unsuitable!! please enter again");
					  pressContinue();
					}
				}
			rd.setIdOnwer(idcards);        
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

   public void Search()
   {
	String request; ArrayList <Card>cmm=new ArrayList<Card>();
	ArrayList<Card> cmn= new ArrayList<Card>();
	System.out.println("enter id or name owner you want to search ");
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
		System.out.println("Card you want to find");
		for(String n:fullname)
		{
			int indexful=checkIdOwner(n);
			if(indexful!=-1)
			{
				if(list.get(indexful) instanceof CardNormal)
				{
					CardNormal cdl=(CardNormal) list.get(indexful);
					cdl.display();
				}
				else if(list.get(indexful) instanceof CardBorrow)
				{
					CardBorrow cdb=(CardBorrow) list.get(indexful);
					cdb.displayDetails();
				}
			}
		}
	}
	if(suggestname.isEmpty()!=true)
	{
		System.out.println("suggest Card you want to find");
		for(String n:suggestname)
		{
			int indexsug=checkIdOwner(n);
			System.out.println("index: "+indexsug);
			list.get(indexsug);
			if(indexsug!=-1)
			{
				if(list.get(indexsug) instanceof CardNormal)
				{
					CardNormal cdl=(CardNormal) list.get(indexsug);
					cdl.display();
				}
				else if(list.get(indexsug) instanceof CardBorrow)
				{
					CardBorrow cdb=(CardBorrow) list.get(indexsug);
					cdb.display();
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
		System.out.println("card you want find ");
		for(Card c: cmm)
		{
			if(c instanceof CardNormal)
			{
				CardNormal cr=(CardNormal) c;
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
				cr.display();
				
			}
			else if( c instanceof CardBorrow)
			{
			  CardBorrow  dr= (CardBorrow) c;
				dr.display();
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

    	}
   }
}
