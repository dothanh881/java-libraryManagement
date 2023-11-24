package project_library;
import java.util.Scanner;
import java.lang.String;
public class Date {
    Scanner sc= new Scanner(System.in);
    private int day;
    private int month;
    private int year;

    public Date()           
    {
       this. day=0;
       this. month=0;
        year=0;
    }
    public Date(int day,int month,int year)
    {
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public void pressContinue()
	   {
		  String keyContinue;
		  System.out.println("Press Enter to continue... ");
		  keyContinue=sc.nextLine();
	   }
    public int getDay()
    {
        return day;
    }
    public void setDay(int days)
    {
        if(days>31)
        {
            this.day=31;
        }
        else if(days<=0)
        {
            this.day=1;
        }
        else
        {
            this.day=days;
        }

    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int months)
    {
      
        if(months>12)
        {
            this.month=12;
        }
        else if(months<=0)
        {
            this.month=1;
        }
        else
        {
            this.month=months;
        }
    }

    public int getYear()
    {
        return year;
    }
    public void setYear(int years)
    {
      
        if(years>2025)
        {
            this.month=2025;
        }
        else if(years<=0)
        {
            this.month=2023;
        }
        else
        {
            this.year=years;
        }
    }

    public void enterDate()
    {
       day: while(true)
        {
            try
            {
                System.out.println("enter day: ");
                this.day=sc.nextInt();
                sc.nextLine();
                  if(day>31)
                   {
                        System.out.println("day must be greater than 0 and less than 32 !!please enter again day ");
                        pressContinue();
                        continue day;
                        
                   }
                   else if(day<=0)
                   {
                        System.out.println("day must be greater than 0 and less than 32 !!please enter again day ");
                        pressContinue();
                        continue day;
                    }
                   else
                    {
                      break day;
                    }


            }
            catch(Exception e)
            {
                System.out.println("data invidial !!please again");
                sc.nextLine();
                pressContinue();

            }

        }

        month: while(true)
        {
            try
            {
                System.out.println("enter month: ");
                this.month=sc.nextInt();
                sc.nextLine();
                  if(this.month>12)
                   {
                        System.out.println("day must be greater than 0 and less than 13 !!please enter again month ");
                        pressContinue();
                        continue month;
                        
                   }
                   else if(this.month<=0)
                   {
                        System.out.println("day must be greater than 0 and less than 13 !!please enter again month ");
                        pressContinue();
                        continue month;
                    }
                   else
                    {
                      break month;
                    }


            }
            catch(Exception e)
            {
                System.out.println("data invidial !!please again");
                sc.nextLine();
                pressContinue();

            }

        }
        year: while(true)
        {
            try
            {
                System.out.println("enter year: ");
                this.year=sc.nextInt();
                sc.nextLine();
                  if(this.year<=2022)
                   {
                        System.out.println("day must be greater than 2022 and less than 2026 !!please enter again month ");
                        pressContinue();
                        continue year;
                        
                   }
                   else if(this.year>2025)
                   {
                        System.out.println("day must be greater than 2022 and less than 2026 !!please enter again month ");
                        pressContinue();
                        continue year;
                    }
                   else
                    {
                      break year;
                    }


            }
            catch(Exception e)
            {
                System.out.println("data invidial !!please again");
                sc.nextLine();
                pressContinue();

            }

        }

       
    }
    public String DayString()
    {
        String tempMonth;
        tempMonth=String.valueOf(this.month);
        String tempDay;
        tempDay=String.valueOf(this.day);
        String tempYears;
        tempYears=String.valueOf(this.year);
        String tempDate=tempMonth+"-"+tempDay+"-"+tempYears;
        return tempDate;
    }

    

}
