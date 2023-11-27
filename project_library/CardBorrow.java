package project_library;

import java.util.ArrayList;

public class CardBorrow extends Card {
        private ArrayList<CardDetail> listBorrow;

	public CardBorrow(String idCard, String idOnwer, ArrayList<CardDetail> listBorrow) {
		super(idCard, idOnwer);
		this.listBorrow = listBorrow;
	}
	public CardBorrow() {
		super();
		this.listBorrow =new ArrayList<CardDetail>();;
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
            System.out.println("Name document: null");
            System.out.println("Borrow day: null");
            System.out.println("Return day: null");
            }
            else
            {
            System.out.println("Name document: "+getNameDocument(cdt.getIdDocument()));
            System.out.println("Borrow day: "+cdt.getTimeBorrow());
            System.out.println("Return day: "+cdt.getTimeReturn());
            }

        }
        System.out.println("\n");
    }

    public void display()
    {
        super.display();
        System.out.println("List of document borrow: ");
        for(CardDetail cdt: listBorrow)
        {
            if(getNameDocument(cdt.getIdDocument()).contentEquals("n"))
            {
            System.out.println("Name document: null");
            
            }
            else
            {
            System.out.println("Name document: "+getNameDocument(cdt.getIdDocument()));
            }

        }
        System.out.println("Time use: 1 year ");        
        System.out.println("\n");
    }

    public void displayTable()
    {
        int i=0;
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-9s | %-9s | %-17s |%-41s |%-12s |%-12s |\n","ID Reader","ID Card", "Name Reader ","Name Document ","Day Borrow","Day Return");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        for(CardDetail cdt: listBorrow)
        {
            if(i==0)
            {
            if(getNameDocument(cdt.getIdDocument()).contentEquals("n"))
            {
             System.out.printf("| %-9s | %-9s | %-17s |%-41s |%-12s |%-12s |\n",this.getIdReader(), this.getIdCard(), this.getNameReader(),"NUll ","NULL","NULL ");
             i++;
            }
            else
            {
                 System.out.printf("| %-9s | %-9s | %-17s |%-41s |%-12s |%-12s |\n",this.getIdReader(), this.getIdCard(), this.getNameReader(),getNameDocument(cdt.getIdDocument()),cdt.getTimeBorrow(),cdt.getTimeReturn());
                 i++;
            }
            }
            else
            {
              if(getNameDocument(cdt.getIdDocument()).contentEquals("n"))
              {
                 System.out.printf("| %-9s | %-9s | %-17s |%-41s |%-12s |%-12s |\n"," ", " ", " ","NUll ","NULL","NULL ");
                 i++;
              }
               else
              {
                 System.out.printf("| %-9s | %-9s | %-17s |%-41s |%-12s |%-12s |\n"," " , " ", " ",getNameDocument(cdt.getIdDocument()),cdt.getTimeBorrow(),cdt.getTimeReturn());
                 i++;
              }
            }

        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------");

    }



    public int enterIdOwner()
    {
        if(Card.testIdOwner().isEmpty()==true)
        {
            System.out.println("Please add reader (bussiness or vip ) before adding borrow card! ");
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
                 System.out.println("Please add reader (bussiness or vip ) before adding borrow card !");
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
                           al.displayTable();
                           System.out.println("\n");
                       }
                       System.out.println("Enter id reader you want create for card:");
                       System.out.println("Enter 'e' to end");
                       choose=sc.nextLine();
                       choose=(choose.toLowerCase()).trim();
                       if(choose.contentEquals("e")==true) return 0;
                       if(idlist.contains(choose)!=true)
                       {
                         System.out.println("Id you need incorrect or does not exist ! Please enter again!");
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
                System.out.println("Enter the number of books want to borrow: ");
                numbers=sc.nextInt();
                sc.nextLine();
                break;
            }
            catch(Exception e)
            {
                System.out.println("Entered data is not suitable! Please enter again!");
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
        System.out.println("Enter id of "+numbers+" document you want to borrow and borrow day ,return day: ");
        int i=0;int in=i+1;
        System.out.println("\n");
        String choice;
       borrow: while (true)
        {
            CardDetail cd=new CardDetail();
            System.out.println("Enter id document "+in+ " want to borrow: ");
            choice=sc.nextLine();
            choice=(choice.toLowerCase()).trim();
            if(ListIdDocument.contains(choice)!=true)
            {
                System.out.println("Id document you entered that is not correct or does not exist ! Please enter again !!");
                continue borrow;
            }
            else
            {
                System.out.println("Enter borrow day: ");
                Date ab=new Date();
                ab.enterDate();
                String db=ab.DayString();
                System.out.println("\n");
                System.out.println("enter return day: ");
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
