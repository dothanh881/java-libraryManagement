package project_library;

import java.util.ArrayList;

public class CardNormal extends Card {
    int timeUse;

	public CardNormal(String idCard, String idOnwer, int timeUse) 
	{
		super(idCard, idOnwer);
		this.timeUse = timeUse;
	}

	public CardNormal()
	{
		super();
		this.timeUse = 0;
	}
   

	public int getTimeUse() {
		return timeUse;
	}

	public void setTimeUse(int timeUse) {
		this.timeUse = timeUse;
	}

    public void display()
    {
        super.display();
        System.out.println("Time use: "+this.timeUse+" day");
        System.out.println("\n ");
    }

    public void displayTable()
    {
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
	    System.out.printf("| %-14s |%-15s | %-36s | %-15s |%-20s |\n","ID Reader ","ID Card", "Name Reader", "Type Card  ","Time Use(day) ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-14s |%-15s | %-36s | %-15s |%-20s |\n",this.getIdReader(), this.getIdCard(), this.getNameReader(),this.getIdTypeCard(),this.getTimeUse());
        System.out.println("-----------------------------------------------------------------------------------------------------------------");

    }



    public int enterIdOwner()
    {
        if(Card.testIdOwner().isEmpty()==true)
        {
            System.out.println("Please add reader (normal) before adding normal card! ");
            pressContinue();
            return 0;

        }
        else
        {
            ArrayList<Reader> alts=new ArrayList<Reader>();
            ArrayList<String> idlist=new ArrayList<String>();
            for(Reader r:Card.testIdOwner())
            {
                String temp=((r.getTypeCard()).toLowerCase()).trim();
                if(temp.contentEquals("normal"))
                {
                    alts.add(r);
                }
            }
            if(alts.isEmpty()==true)
            {
				 for(Reader r:Card.testIdOwner())
                 {
                      r.displayTable();
                 }
                 System.out.println("Please add reader (normal) before adding normal card! ");
                 pressContinue();
				 return 0;
            }
            else
            {
                for(Reader r:alts)
                {
                    idlist.add(((r.getId()).toLowerCase()).trim());
                }
              idOnwer: while(true)
                {
                    int flag=0;String choose;
                   
                       ClearScreen.clear();
                       for(Reader al:alts)
                       {
                           al.displayTable();
                       }
                       System.out.println("\n ");
                       System.out.println("Enter id of the reader you want to create for card: ");
                       System.out.println("Enter 'e' to end");
                       choose=sc.nextLine();
                       choose=(choose.toLowerCase()).trim();
                       if(choose.contentEquals("e")==true) return 0;
                       if(idlist.contains(choose)!=true)
                       {
                         System.out.println("Id you entered that is incorrect or does not exist ! Please enter again!");
                         pressContinue();
                       }
                       else
                       {
                        int index=0;int i=0;
                         for(Reader rr:alts)
                         {
                            String temp11=((rr.getId()).toLowerCase()).trim();
                            if(temp11.contentEquals(choose))
                            {
                                index=i;
                            }
                            i++;
                         }
                         this.idOnwer=alts.get(index).getIdcard();
                         break idOnwer;
            
                       }
                }
            }
        }
		return 1;
    }
	public void enterTimeUse()
	{
		int numbers;
        number:while(true)
        {
            try
            {
                System.out.println("Enter time use of card: ");
                this.timeUse=sc.nextInt();
                sc.nextLine();
                break;
            }
            catch(Exception e)
            {
                System.out.println("Error data! Please enter again!");
                sc.nextLine();
                pressContinue();
            }
        }
	}
	
}
