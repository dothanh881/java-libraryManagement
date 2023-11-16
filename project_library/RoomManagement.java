package project_library;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomManagement implements LibraryManagement {
    Scanner sc=new Scanner(System.in);
	private ArrayList<Room> list;
    
    //Hàm khởi tạo không tham số
    public RoomManagement()
    {
    	list=new ArrayList<Room>();
    }
    
    //Hàm khởi tạo có tham số
    public RoomManagement(ArrayList<Room> arr )
    {
		list=arr;
    }
    
    // Hàm hiển thị dữ liệu
    public void Add() {
    	int choose;
    	while(true)
    	{
    		System.out.println("1. add service room ");
    		System.out.println("2. add read room ");
    		System.out.println("enter object want to add ");
    		choose=sc.nextInt();
    		sc.nextLine();
    		switch(choose)
    		{
    		case 1:
    			while(true)
    			{
    				ServiceRoom srv=new ServiceRoom();
    				srv.enterData(); int flag=0;
    				for(Room r:list)
    				{
    					if(r instanceof ServiceRoom)
    					{
    						ServiceRoom s=(ServiceRoom)r;
    						if(s.getNoRoom()==srv.getNoRoom()) flag=1;
    						else if(s.getRoomId()==srv.getRoomId()) flag=2;
    					    if(flag==0)
    					    {
    					    	list.add(srv);
    					    	System.out.println("add room service successfully ");
    					    	
    					    	break;
    					    	
    					    }
    					    else if(flag==1)
    					    {
    					    	
    					    }
    						
    					}
    					
    				}
    				
    			}
    			
    			
    		}
    		
    	
    	}
    	
    };
    public void Delete() {};
   public void Edit () {};
   public  void Search() {};
  
     
    public void Display()
    {
    	ArrayList<ServiceRoom> service=new ArrayList<ServiceRoom>();
    	System.out.println("list of read room: ");
    	for(Room listTest:list)
    	{
    		if(listTest instanceof ReadRoom)
    		{
    			ReadRoom rd=(ReadRoom)listTest;
    			rd.display();
                System.out.println("\n ");
    		}
    		else if(listTest instanceof ServiceRoom)
    		{
    			ServiceRoom sr=(ServiceRoom)listTest;
    			service.add(sr);
    		}
    	}
        System.out.println("===============*==============");
    	System.out.println("list of service room: ");
    	for(ServiceRoom sr:service)
    	{
    		sr.display();
            System.out.println("\n ");

    	}
    	
    }

	
  
  
}

