package project_library;

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
    }

    @Override
    public void serviceFee() {
        
    };
    
}
