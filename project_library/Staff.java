package project_library;

import java.util.ArrayList;

public class Staff extends Person{
    private String workRoom;
    private String position;
    private int flagAdd;
    private Double salary;
    private static int noStaff=0;
    private static int noAddStaff=0;
    public Staff(String name, String gender, String adress, String id,int age, String workRoom, String position) {
        super(name, gender, adress, id,age);
        this.workRoom = workRoom;
        this.position = position;
        noStaff++;
    }
    public Staff()
    {
        super();
        this.workRoom=" ";
        this.position=" ";
        noStaff++;
        noAddStaff++;

    }
    public Staff(int flagAdd)
    {
        noAddStaff--;
    }

    public static int SumStaff()
    {
        return noStaff;
    }

    public static int AddStaff()
    {
        return noAddStaff;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String potion) {
        this.position = potion;
    }
    public void display()
    {
        super.display();
        System.out.println("position: "+this.position);
        System.out.println("\n");
    }
    public void displayTable()
    {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-27s | %-10s |%-20s |%-10s |%-15s |\n","ID ", "Name", "Gender  ","Address ","Age ","Position ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-27s | %-10s |%-20s |%-10s |%-15s |\n",this.getId(), this.getName(), this.getGender(),this.getAddress(),this.getAge(),this.getPosition());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

    }
      

    public void  enterData(ArrayList<Person>list,ArrayList<ServiceRoom>listsr)
    {
        super.enterData(list);
        gender:while(true)
        {
            int flag=0;
            try
            {
            ClearScreen.clear();
            System.out.println("choose position ");
            System.out.println("1. Director");
            System.out.println("2. Manager");
            System.out.println("3. Employee");
            int choose;
            System.out.println("enter position follow number ");
            choose=sc.nextInt();
            sc.nextLine();
              switch (choose)
               {
                   case 1:
                    this.position="Director";
                    flag=1;
                    break;
                    case 2:
                    this.position="Manager";
                    flag=1;
                    break;
                    case 3:
                    this.position="Employee";
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
            if(flag==1) break gender;
    
        }

	position:while(true)
			{
				int m;
              for(ServiceRoom r:listsr)
			  {
				System.out.println("number room: "+r.getNoRoom());
                System.out.println("name room: "+r.getName());
				System.out.println("area: "+r.getAreaPlace());
				System.out.println("\n");
			  }
			
				int flag1=0;
				try{
                  System.out.println("enter number room you want work ");
				  m=sc.nextInt();
				  sc.nextLine();
				  int index1=-1;
				  int i=0;
				   for(ServiceRoom r:listsr)
			       {
				       if(r.getNoRoom()==m)
					   {
						flag1=1;
						index1=i;
					   }

					   i++;
			       }
				   if(flag1==1) 
				   {
					this.workRoom=listsr.get(index1).getAreaPlace();
					break position;
				   }
				   else if(flag1==0)
				   {
					System.out.println("\n");
					  System.out.println("number room you enter is exist !!please enter again");
					  pressContinue();
					  System.out.println("\n");
				   }
				}catch(Exception e)
				{
					System.out.println("data invidial ");
					sc.nextLine();
					pressContinue();
					continue position;

				}
				ClearScreen.clear();
			  

			}


    }

    public void searchLocation(ArrayList<ServiceRoom> listrd)
		{
			listrd=main.rmt.getServiceRoom();
			ArrayList<ServiceRoom> rdd=new ArrayList<ServiceRoom>();
			String temp=(this.workRoom.toLowerCase()).trim();
		     for( ServiceRoom r:listrd)
			 {
				String rm=(r.getAreaPlace()).toLowerCase().trim();
				if(temp.contentEquals(rm))
				{
                   rdd.add(r);
				}
			 }
			 if(rdd.isEmpty()==true)
			 {
				System.out.println("service room is delete before");
			 }
			 else
			 {
				System.out.println("staff work in room: ");
			    for(ServiceRoom r:rdd)
			    {
					r.display();
					System.out.println();

			    }
                System.out.println("\n");

			 }

		}
    





    @Override
    public double serviceFee()
    {
        this.salary=0.0;
        String temp=((this.position).toLowerCase()).trim();
        if(temp.contentEquals("director"))
        {
            this.salary=ServiceRoom.getSalaryBasic()*4;
        }    
        else if(temp.contentEquals("employee"))
        {
            this.salary=ServiceRoom.getSalaryBasic()*1.5;
        }
        else if(temp.contentEquals("manager"))
        {
            this.salary=ServiceRoom.getSalaryBasic()*2.5;

        }
        else
        {
            this.salary=0.0;
        }
        System.out.println("Salary of Staff: "+this.salary+" USD");
        System.out.println("==============*===============");
        return this.salary;
    }
    public void Statistic()
    {
    int a=Staff.SumStaff();
    System.out.println("total staff: "+a);
    int b=Staff.AddStaff();
    System.out.println("total staff add"+b);
    }

    
}
