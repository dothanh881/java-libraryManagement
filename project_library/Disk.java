package project_library;

public class Disk extends Document {
    private double time;
    private double Ram;

    public Disk()
    {
        super();
        time=0;
        Ram=0;
    }

    // hàm thiết lập có tham số
    public Disk( String id, String name, String author, String type,int time,int Ram,String potion)
    {
        super(id, name, author,  type, potion);
        this.time=time;
        this.Ram=Ram;
    }
    
    public double getTime()
    {
        return this.time;
    }
    
    public double getRam()
    {
        return this.Ram;
    }

    public void setTime(double time)
    {
        this.time=time;
    }

    public void setRam(double Ram)
    {
        this.Ram=Ram;
    }

    public void display()
    {
        super.display();
        System.out.println("disk RAM : "+this.Ram);
        System.out.println("time   : "+this.time);
        
    }
}
