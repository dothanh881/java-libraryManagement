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
    
	// hàm thêm dữ liệu phòng
    public void Add() {
		
	    
		String keyContinue; // để dừng màn hình - nhấn phím enter để tiếp tục
    	while(true){
			try{
		int choose;
       
    	work:while(true)
    	{
			System.out.print("\033[H\033[2J");  // clear sreen
			System.out.flush();
			System.out.println("0. press number 0 to end add");
    		System.out.println("1. press number 1 to add service room ");
    		System.out.println("2. press number 2 to add read room ");
    		System.out.println("enter type room want to add ");
			choose=sc.nextInt();
			sc.nextLine();
			if(choose==0) break work ;
			
    		switch(choose)
    		{
				
    		case 1: // thêm phòng dịch vụ
    			while(true){
    				ServiceRoom srv=new ServiceRoom();
    				srv.enterData(); int  flag=0; ServiceRoom a=new ServiceRoom();

    				for(Room r:list)
    				{
    					if(r instanceof ServiceRoom)
    					{
    						ServiceRoom s=(ServiceRoom)r;
    						if(s.getNoRoom()==srv.getNoRoom()){ flag=1;a=s;break;} 
    						else if(s.getRoomId()==srv.getRoomId()) {flag=2;a=s;break;}
    					       						
    					}
    					
    				}

					if(flag==0) // thông báo nhập thành công
    					    {
    					    	list.add(srv);
    					    	System.out.println("add room service successfully ");
    					    	System.out.println("Press Enter to continue... ");
								keyContinue=sc.nextLine();
    					    	break;
    					    	
    					    }
    					else if(flag==1) // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng số phòng
    					    {
								
								System.out.println("number room service you enter is exits !! ");
								a.display();
								System.out.println("please enter again");
								System.out.println("Press Enter to continue... ");
								keyContinue=sc.nextLine();

    					    	
    					    }
							else // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng id phòng
							{
								System.out.println("id room you enter is exits!! please enter again ");
								System.out.println("id room service you enter is exits !! ");
								a.display();
								System.out.println("please enter again");
								System.out.println("Press Enter to continue... ");
								keyContinue=sc.nextLine();
							}
    				break;
						}
						break;
    			
				case 2:
				    while(true){
    				ReadRoom rd=new ReadRoom();
    				rd.enterData(); int flag=0; ReadRoom a=new ReadRoom();

    				for(Room r:list)
    				{
    					if(r instanceof ReadRoom)
    					{
    						ReadRoom s=(ReadRoom)r;
    						if(s.getNoRoom()==rd.getNoRoom()){ flag=1;a=s;break;} 
    						else if(s.getRoomId()==rd.getRoomId()) {flag=2;a=s;break;}
    					       						
    					}
    					
    				}

					if(flag==0) // thông báo nhập thành công
    					    {
    					    	list.add(rd);
    					    	System.out.println("add room service successfully ");
    					    	System.out.println("Press Enter to continue... ");
								keyContinue=sc.nextLine();
    					    	break;
    					    	
    					    }
    					else if(flag==1) // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng số phòng
    					    {
								
								System.out.println("number room service you enter is exits !! ");
								a.display();
								System.out.println("please enter again");
								System.out.println("Press Enter to continue... ");
								keyContinue=sc.nextLine();

    					    	
    					    }
							else // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng id phòng
							{
								System.out.println("id room you enter is exits!! please enter again ");
								System.out.println("id room service you enter is exits !! ");
								a.display();
								System.out.println("please enter again");
								System.out.println("Press Enter to continue... ");
								keyContinue=sc.nextLine();
							}
    				break;
						}
						break;
    			
    		}
    		
    	
    	}
		break;
	}catch(Exception e)
	{
		System.out.println("data error! ");
		sc.nextLine();
		System.out.println("Press Enter to continue... ");
		keyContinue=sc.nextLine();
	}
    }
    	
    };

	// Hàm xóa
    public void Delete() {
       

	}

   public void Edit () {};
   public  void Search() {};


    // Hàm hiển thị dữ liệu
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

