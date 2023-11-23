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
