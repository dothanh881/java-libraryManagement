package project_library;

import java.util.ArrayList;

public class Reader extends Person {
    private String typeCard;
    private String idCard;
    private int flagAdd;
    private String job;
    private Double moneyFee;
    private static int noReader=0;
    private static int noAddReader=0;
	public Reader(String name, String gender, String adress, String id,int age,String typeCard, String idcard,String job) {
        super(name, gender, adress, id,age);
        this.typeCard = typeCard;
		this.idCard = idcard;
        this.job=job;
        noReader++;
        
	}
    public Reader(int flagAdd)
    {
        noAddReader--;
    }
    public Reader()
    {
        super();
        this.typeCard = " ";
		this.idCard = " ";
        job=" ";
        noAddReader++;
        noReader++;
    }
    
    public static int getNoReader()
    {
        return noReader;
    }
     public static int getNoAddReader()
    {
        return noAddReader;
    }

	public String getTypeCard() {
		return typeCard;
	}
	public void setTypeCard(String typeCard) {
		this.typeCard = typeCard;
	}
    public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getIdcard() {
		return idCard;
	}
	public void setIdcard(String idcard) {
		idCard = idcard;
	}
	public int getFlagAdd() {
		return flagAdd;
	}
	public void setFlagAdd(int flagAdd) {
		this.flagAdd = flagAdd;
	}
	public Double getMoneyFee() {
		return moneyFee;
	}
	public void setMoneyFee(Double moneyFee) {
		this.moneyFee = moneyFee;
	}

    public void display()
    {
        super.display();
        System.out.println("job: "+this.job);
        System.out.println("type card: "+this.typeCard);
        
    }

    public void enterIdcard(ArrayList<Person> list)
    {
        ap: while(true)
        {
            int index=-1;int i=0;
      
          System.out.println("enter Id Card( Can not Change): ");
              this.idCard=sc.nextLine();
              String temp=((this.idCard).toLowerCase()).trim();
          for(Person d:list)
          {
                if(d instanceof Reader)
                {
                  Reader sd=(Reader) d;
                  String gap=((sd.getIdcard()).toLowerCase()).trim();
                  if(gap.contentEquals(temp))
                  {
                    index=i;
                  }
                }
             i++;
          }
          if(index==-1) break ap;
          else 
          {
            System.out.println("\n");
            list.get(index).display();
            System.out.println("Id Card is exist!!please enter again");
            pressContinue();
          }
      
          
        }
    }

    public void enterData(ArrayList<Person> list)
    {
       super.enterData(list);
       typecard:while(true)
        {
            int flag=0;
            try
            {
            ClearScreen.clear();
            System.out.println("choose type Card ");
            System.out.println("1. Normal");
            System.out.println("2. Business");
            System.out.println("3. Vip");
            int choose;
            System.out.println("enter type Card follow number ");
            choose=sc.nextInt();
            sc.nextLine();
              switch (choose)
               {
                   case 1:
                    this.typeCard="Normal";
                    flag=1;
                    break;
                    case 2:
                    this.typeCard="Business";
                    flag=1;
                    break;
                    case 3:
                    this.typeCard="Vip";
                    flag=1;
                    break;
                    default:
                    System.out.println("you entered number is ividial !! please enter again");
                    pressContinue();
                    break;
               }
            }
            catch(Exception e)
            {
                System.out.println("choose is not suitable ! please enter again");
                sc.nextLine();
                pressContinue();
            }
            if(flag==1) break typecard;
    
        }
        System.out.println("enter job of reader");
        this.job=sc.nextLine();
       
    }

    @Override
    public double serviceFee() 
    {
        this.moneyFee=0.0;
        String temp=((this.typeCard).toLowerCase()).trim();
        if(temp.contentEquals("normal"))
        {
            this.moneyFee=ServiceRoom.getSalaryBasic()*1;
        }    
        else if(temp.contentEquals("business"))
        {
            this.moneyFee=ServiceRoom.getSalaryBasic()*10;
        }
        else if(temp.contentEquals("vip"))
        {
            this.moneyFee=ServiceRoom.getSalaryBasic()*20.5;

        }
        else
        {
            this.moneyFee=0.0;
        }
        System.out.println("Fee read : "+this.moneyFee+" USD");

        return moneyFee;
    };
    public void Statistic()
   {
    int a=Reader.getNoReader();
    System.out.println("total reader: "+a);
    int b=Reader.getNoAddReader();
    System.out.println("total reader add: "+b);
   }
    
    
}
