package project_library;

import java.util.ArrayList;

public class CardBorrow extends Card {
        private ArrayList<CardDetail> listBorrow;
        private static int numberCardBorrow=0;

	public CardBorrow(String idCard, String idOnwer, ArrayList<CardDetail> listBorrow) {
		super(idCard, idOnwer);
		this.listBorrow = listBorrow;
        numberCardBorrow++;
	}
	public CardBorrow() {
		super();
		this.listBorrow =new ArrayList<CardDetail>();;
        numberCardBorrow++;
	}
    public static int getNumberCardBorrow()
    {
        return numberCardBorrow;
    }
	public ArrayList<CardDetail> getListBorrow() {
		return listBorrow;
	}
	public void setListBorrow(ArrayList<CardDetail> listBorrow) {
		this.listBorrow = listBorrow;
	}

    // hàm dừng màn hình
	public void pressContinue()
	{
		String keyContinue;
		System.out.println("Press Enter to continue... ");
		keyContinue=sc.nextLine();
	}

    public String getNameDocument(String iddocument)
    {
        iddocument=(iddocument.toLowerCase()).trim();
        String fg="n";
        for(Document dt:main.dmt.getDocumentManagement())
        {
            String temp=((dt.getId()).toLowerCase()).trim();
            if(iddocument.contentEquals(temp))
            {
                fg=dt.getName();
                break;
            }
        }
        return fg;

    }

    public void displayDetails()
    {
        super.display();
        for(CardDetail cdt: listBorrow)
        {
            if(getNameDocument(cdt.getIdDocument()).contentEquals("n"))
            {
            System.out.println("name document: null");
            System.out.println("borrow day: null");
            System.out.println("return day: null");
            }
            else
            {
            System.out.println("name document: "+getNameDocument(cdt.getIdDocument()));
            System.out.println("borrow day: "+cdt.getTimeBorrow());
            System.out.println("return day: "+cdt.getTimeReturn());
            }

        }
        System.out.println("\n");
    }

    public void display()
    {
        super.display();
        int flag=0;
        System.out.println("list of document borrow: ");
        for(CardDetail cdt: listBorrow)
        {
            if(getNameDocument(cdt.getIdDocument()).contentEquals("n"))
            {
            System.out.println("name document: null");
            
            }
            else
            {
            System.out.println("name document: "+getNameDocument(cdt.getIdDocument()));
            }

        }
        System.out.println("time use: 1 year ");        
        System.out.println("\n");
    }

    public int enterIdOwner()
    {
        if(Card.testIdOwner().isEmpty()==true)
        {
            System.out.println("plesase add reader (bussiness or vip ) before add card borrow");
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
                if(temp.contentEquals("vip")||temp.contentEquals("business"))
                {
                    alts.add(r);
                }
            }
            if(alts.isEmpty()==true)
            {
                main.pmt.Display();
                 System.out.println("plesase add reader (bussiness or vip ) before add card borrow");
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
                   
                       
                       for(Reader al:alts)
                       {
                           al.display();
                       }
                       System.out.println("\n");
                       System.out.println("enter id owner card ");
                       System.out.println("enter 'e' to end");
                       System.out.println("\n");
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
    public void enterDocumentBorrow()
    {
        int numbers;
        number:while(true)
        {
            try
            {
                System.out.println("enter number book want to borrow");
                numbers=sc.nextInt();
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
        main.dmt.Display();
       
        ArrayList<String>ListIdDocument=new ArrayList<String>();
        for(Document a:main.dmt.getDocumentManagement())
        {
            String temp12=((a.getId()).toLowerCase()).trim();
            ListIdDocument.add(temp12);
        }
        System.out.println("enter id of "+numbers+" document you want borrow and borrow day ,return day");
        int i=0;int in=i+1;
        System.out.println("\n");
        String choice;
       borrow: while (true)
        {
            CardDetail cd=new CardDetail();
            System.out.println("enter id document+"+in+ " want borrow");
            choice=sc.nextLine();
            choice=(choice.toLowerCase()).trim();
            if(ListIdDocument.contains(choice)!=true)
            {
                System.out.println("id document you entered that is not correct or is not exist !please enter again ");
                continue borrow;
            }
            else
            {
                System.out.println("enter day borrow");
                Date ab=new Date();
                ab.enterDate();
                String db=ab.DayString();
                System.out.println("\n");
                System.out.println("enter day return ");
                Date ar=new Date();
                ar.enterDate();
                String dr=ar.DayString();

                CardDetail moi =new CardDetail(choice,db,dr);
                pressContinue();
                this.listBorrow.add(moi);
                i++;
                in=i+1;
                 if(i==numbers) break borrow;

            }

            
        }


        
        
       
    }

}
