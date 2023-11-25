package project_library;

import java.util.ArrayList;

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
    public Disk( String id, String name, String author, String type,double time,double Ram,String potion)
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
        System.out.println("disk RAM : "+this.Ram+" Gb ");
        System.out.println("time     : "+this.time +" minute");
    }
    public void displayTable()
    {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-14s | %-37s | %-25s |%-17s |%-15s |%-15s |\n","ID ", "Name", "Author  ","Type ","Time (minute) ","Ram (Gb) ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-14s | %-37s | %-25s |%-17s |%-15s |%-15s |\n",this.getId(), this.getName(), this.getAuthor(),this.getType(),this.getTime(),this.getRam());

    }
     public void enterData(ArrayList<ReadRoom> listrd)
    {
        super.enterData( listrd);
        while(true)
        {
            try{
                System.out.println("enter time of disk: ");
                this.time=sc.nextDouble();
                System.out.println("enter Ram of disk ");
                this.Ram=sc.nextDouble();
                sc.nextLine();
                break;

            }catch(Exception e)
            {
                System.out.println("data invidial !!please enter again ");
                sc.nextLine();
                pressContinue();

            }

        }
    }
}
