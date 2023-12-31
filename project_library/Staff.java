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
     
    public String getWorkroom()
    {
        return this.workRoom;
    }
    

    public void display()
    {
        super.display();
        System.out.println("position: "+this.position);
        System.out.println("\n");
    }
    public void displayTable()
    {
        System.out.println("-----------------------------------------------------------------------------------------------------------------");	
        System.out.printf("| %-10s | %-28s | %-8s |%-21s |%-8s |%-13s |%-11s |\n","ID ", "Name", "Gender  ","Address ","Age ","Position ","area work");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");	
        System.out.printf("| %-10s | %-28s | %-8s |%-21s |%-8s |%-13s |%-11s |\n",this.getId(), this.getName(), this.getGender(),this.getAddress(),this.getAge(),this.getPosition(),this.getWorkroom());
		System.out.println("-----------------------------------------------------------------------------------------------------------------");	

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
            System.out.println("Choose position: ");
            System.out.println("1. Director");
            System.out.println("2. Manager");
            System.out.println("3. Employee");
            int choose;
            System.out.println("Enter position follow number: ");
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
                    System.out.println("Entered data is not suitable !! Please enter again!");
                    pressContinue();
                    break;
               }
            }
            catch(Exception e)
            {
                System.out.println("Choice is not suitable ! Please enter again!");
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
				System.out.println("Number room: "+r.getNoRoom());
                System.out.println("Name room: "+r.getName());
				System.out.println("Area: "+r.getAreaPlace());
				System.out.println("\n");
			  }
			
				int flag1=0;
				try{
                  System.out.println("Enter the number of the room you want work in: ");
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
					  System.out.println("Number room you enter does not exist !! Please enter again!");
					  pressContinue();
					  System.out.println("\n");
				   }
				}catch(Exception e)
				{
					System.out.println("Error data");
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
				System.out.println("Service room can be deleted before");
			 }
			 else
			 {
				System.out.println("Staff work in room: ");
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
    

    
}
