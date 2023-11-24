package project_library;

import java.util.ArrayList;

public class CardNormal extends Card {
    int timeUse;
    private static int numberCardNormal=0;

	public CardNormal(String idCard, String idOnwer, int timeUse) 
	{
		super(idCard, idOnwer);
		this.timeUse = timeUse;
         numberCardNormal++;
	}

	public CardNormal()
	{
		super();
		this.timeUse = 0;
        numberCardNormal++;
	}
    public static int getNumberCardNormal()
    {
        return numberCardNormal;
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
        System.out.println("time use: "+this.timeUse+" day");
        System.out.println("\n ");
    }

    public int enterIdOwner()
    {
        if(Card.testIdOwner().isEmpty()==true)
        {
            System.out.println("plesase add reader (normal) before add card normal");
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
                      r.display();
                 }
                 System.out.println("plesase add reader (normal) before add card normal");
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
                       System.out.println("enter id owner card ");
                       System.out.println("enter 'e' to end");
                       System.out.println("\n");
                       for(Reader al:alts)
                       {
                           al.display();
                       }
                       choose=sc.nextLine();
                       choose=(choose.toLowerCase()).trim();
                       if(choose.contentEquals("e")==true) break idOnwer;
                       if(idlist.contains(choose)!=true)
                       {
                         System.out.println("id you need incorrect or is not exist ! please enter again");
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
                System.out.println("enter time use of card ");
                this.timeUse=sc.nextInt();
                sc.nextLine();
                break;
            }
            catch(Exception e)
            {
                System.out.println("data invidial! please again");
                sc.nextLine();
                pressContinue();
            }
        }
	}
	
}
