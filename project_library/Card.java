package project_library;

import java.util.ArrayList;
import java.util.Scanner;

public class Card {
    Scanner sc=new Scanner(System.in);
    private static int numberCard=0;

    protected String idCard;
	protected String idOnwer;

	public Card(String idCard, String idOnwer)
	{
		this.idCard = idCard;
		this.idOnwer = idOnwer;
        numberCard++;
	}
	public Card()
	{
		this.idCard = " ";
		this.idOnwer = " ";
        numberCard++;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getIdOnwer() {
		return idOnwer;
	}
	public void setIdOnwer(String idOnwer) {
		this.idOnwer = idOnwer;
	}

    public void pressContinue()
	{
		String keyContinue;
		System.out.println("Press Enter to continue... ");
		keyContinue=sc.nextLine();
	}

	public String getNameReader()
	{
		String m="NULL";
		 for(Reader pn:main.pmt.geListReader() )
        {
            String temp=((this.idOnwer).toLowerCase()).trim();
            String gid=((pn.getIdcard()).toLowerCase()).trim();
            if(temp.contentEquals(gid))
            {
               m=pn.getName();
                break;
            }
            
        }
		return m;
	}
	public String getIdReader()
	{
		String m="NULL";
		 for(Reader pn:main.pmt.geListReader() )
        {
            String temp=((this.idOnwer).toLowerCase()).trim();
            String gid=((pn.getIdcard()).toLowerCase()).trim();
            if(temp.contentEquals(gid))
            {
               m=pn.getId();
                break;
            }
            
        }
		return m;
	}
	public String getIdTypeCard()
	{
		String m="NULL";
		 for(Reader pn:main.pmt.geListReader() )
        {
            String temp=((this.idOnwer).toLowerCase()).trim();
            String gid=((pn.getIdcard()).toLowerCase()).trim();
            if(temp.contentEquals(gid))
            {
               m=pn.getTypeCard();
                break;
            }
            
        }
		return m;
	}
	
	

    public void display()
    {
        int flag=0;
        System.out.println("id card: "+this.idCard);
        for(Reader pn:main.pmt.geListReader() )
        {
            String temp=((this.idOnwer).toLowerCase()).trim();
            String gid=((pn.getIdcard()).toLowerCase()).trim();
            if(temp.contentEquals(gid))
            {
                System.out.println("id reader: "+pn.getId());
                System.out.println("name reader: "+pn.getName());
                System.out.println("type card: "+pn.getTypeCard());
                flag=1;
                break;
            }
            
        }
        if(flag==0)
        {
            System.out.println("id reader: NULL ");
            System.out.println("name reader: NULL");
        }
    }

	public void displayTable()
	{
		
	}


	

	public static ArrayList<Reader> testIdOwner()
	{
		ArrayList<Reader> tio=new ArrayList<Reader>();
		for(Reader cd:main.pmt.geListReader())
		{
          String temp=((cd.getIdcard()).toLowerCase()).trim();
		  if((main.cmt.getIdOnwer()).contains(temp)!=true)
		  {
			tio.add(cd);
	
		  }
		}
		return tio;
	}

    public void enterIdcard(ArrayList<Card> list)
    {
      id: while(true)
			{
				int flag=0;int index=-1;int i=0;

				System.out.println("enter Id card: ");
		        this.idCard=sc.nextLine();
				String temp=((this.idCard).toLowerCase()).trim();
				for(Card d:list)
				{
					String gd =((d.getIdCard()).toLowerCase()).trim();
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
					System.out.println("Id card is exist!!please enter again");
					pressContinue();
				}

			}
    }



    


	 
}
