package project_library;

import java.util.ArrayList;

public class CardBorrow extends Card {
        private ArrayList<CardDetail> listBorrow=new ArrayList<CardDetail>();

	public CardBorrow(String idCard, String idOnwer, ArrayList<CardDetail> listBorrow) {
		super(idCard, idOnwer);
		this.listBorrow = listBorrow;
	}
	public CardBorrow() {
		super();
		this.listBorrow = null;
	}
	public ArrayList<CardDetail> getListBorrow() {
		return listBorrow;
	}
	public void setListBorrow(ArrayList<CardDetail> listBorrow) {
		this.listBorrow = listBorrow;
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

}
