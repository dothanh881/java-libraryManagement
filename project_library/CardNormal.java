package project_library;

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
	
}
