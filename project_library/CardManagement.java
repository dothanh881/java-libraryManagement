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
			  System.out.println("data error! ");
			  sc.nextLine();
			  pressContinue();
		  }
		}
   }
   public void Delete(){};
   public void Edit(){};
   public void Search(){};
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
