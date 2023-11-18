package project_library;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

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

	// hàm xóa màn hình
	public void clearScreen()
	{
		System.out.print("\033[H\033[2J");  // clear sreen
		System.out.flush();
	}

	// hàm dừng màn hình
	public void pressContinue()
	{
		String keyContinue;
		System.out.println("Press Enter to continue... ");
		keyContinue=sc.nextLine();
	}

	// hàm kiểm tra id trùng
	public int checkIdRoom( String m)
	{
		m.toLowerCase();
		int flag=0;int i=0;int index=0;
		for(Room r:list)
		{
			if(r instanceof ServiceRoom)
			{
                ServiceRoom sr=(ServiceRoom) r;
				if(sr.getRoomId().toLowerCase().contentEquals(m))
				{
					flag=1;
					index=i;
					
				}
			}
			else if( r instanceof ReadRoom)
			{
				ReadRoom rd=(ReadRoom) r;
				if(rd.getRoomId().toLowerCase().contentEquals(m))
				{
					flag=1;
					index=i;
				}
			}
			i++;
		}
		if(flag==1) return index;
       return -1;
	}

	
    
	// hàm thêm dữ liệu phòng
    public void Add() {
		
	    
    	while(true){
			try{
		int choose;
       
    	work_add:while(true)
    	{
			clearScreen();
			System.out.println("0. press number 0 to end add");
    		System.out.println("1. press number 1 to add service room ");
    		System.out.println("2. press number 2 to add read room ");
    		System.out.println("enter type room want to add ");
			choose=sc.nextInt();
			sc.nextLine();
			if(choose==0) break work_add ;
			
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
    						else if(s.getRoomId().toLowerCase().contentEquals(srv.getRoomId().toLowerCase())) {flag=2;a=s;break;}
    					       						
    					}
    					
    				}

					if(flag==0) // thông báo nhập thành công
    					    {
    					    	list.add(srv);
    					    	System.out.println("add room service successfully ");
    					    	pressContinue();
    					    	break;
    					    	
    					    }
    					else if(flag==1) // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng số phòng
    					    {
								
								System.out.println("number room service you enter is exits !! ");
								a.display();
								System.out.println("please enter again");
								pressContinue();

    					    }

							else // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng id phòng
							{
								System.out.println("id room you enter is exits!! please enter again ");
								System.out.println("id room service you enter is exits !! ");
								a.display();
								System.out.println("please enter again");
								pressContinue();
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
    						else if(s.getRoomId().toLowerCase().contentEquals(rd.getRoomId().toLowerCase())) {flag=2;a=s;break;}
    					       						
    					}
    					
    				}

					if(flag==0) // thông báo nhập thành công
    					    {
    					    	list.add(rd);
    					    	System.out.println("add room service successfully ");
    					    	pressContinue();
    					    	break;
    					    	
    					    }
    					else if(flag==1) // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng số phòng
    					    {
								
								System.out.println("number room service you enter is exits !! ");
								a.display();
								System.out.println("please enter again");
								pressContinue();
    					    	
    					    }
							else // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng id phòng
							{
								System.out.println("id room you enter is exits!! please enter again ");
								System.out.println("id room service you enter is exits !! ");
								a.display();
								System.out.println("please enter again");
								pressContinue();
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
		pressContinue();
	}
    }
    	
    };

	// Hàm xóa
    public void Delete() {

		Display();
		String request;
		System.out.println("enter id room you want to delete ");
		request=sc.nextLine();
		request.toLowerCase();
		Room r=new Room();int flag=0;String choice;int i=0;int index=0;
		for(Room rg:list)
		{
          if(request.contentEquals(rg.getRoomId().toLowerCase()))
		  {
			r=rg;
			flag=1;
			index=i;
		  }
		  	i++;

		}
		if(flag==0) {
			System.out.println("room you want to delete no exits or is deleted before");
			pressContinue();

		}
		else if(flag==1)
		{
			String yes="y";
			String no="n";
			clearScreen();
			if( r instanceof ServiceRoom)
			{
				r.display();
				System.out.println("\n ");
			}
			else if(r instanceof ReadRoom)
			{
				r.display();
				System.out.println("\n");
			}
            action:while(true){
			
			System.out.println("are you sure want to delete this (yes/no)? ");
			
			System.out.println("enter 'y' to choose 'yes' and enter 'n' to choose no");
			choice=sc.nextLine();
			choice.toLowerCase();
		      if(choice.contentEquals(yes))
			  {
				list.remove(index);
				System.out.println("you have deleted sucessful ");
				pressContinue();
				break action;
			  }
			  else if(choice.contentEquals(no))
			  {
				System.out.println("deletion failed");
				pressContinue();
				break action;
			  }
			  else
			  {
				System.out.println("your choice is unsuitable!! please enter again");
				pressContinue();

			  }
			}
			

		}

	}


    // hàm sửa 
   public void Edit()
   {

		Display();
		String request;
		System.out.println("enter id room you want to edit ");
		request=sc.nextLine();
		request.toLowerCase();
		Room r=new Room();int flag=0;String choice;int i=0;int index=0;int save=0;
		for(Room rg:list)
		{
          if(request.contentEquals(rg.getRoomId().toLowerCase()))
		  {
			r=rg;
			flag=1;
			index=i;
		  }
		  	i++;

		}
		if(flag==0) {
			System.out.println("room you want to edit no exits ");
			System.out.println("Press Enter to continue... ");
              pressContinue();
		}
		else if(flag==1)
		{
			list.get(index).display();
			String choice_edit;
			String change;
			ServiceRoom sr=new ServiceRoom();
			ReadRoom rd=new ReadRoom();
			
			if( r instanceof ServiceRoom)
			{
				
				active:while(true)
				{
					clearScreen();
					r.display();
					System.out.println("\n");
					System.out.println("enter 'a' to edit all information room ");
					System.out.println("enter 'id ' to edit room id ");
					System.out.println("enter 'nb' to edit numer room");
					System.out.println("enter 'nm' to edit name room ");
					System.out.println("enter 'e' to end edit room this ");
					choice_edit=sc.nextLine();
					choice_edit.toLowerCase();

					if(choice_edit.contentEquals("e"))
					{
                        System.out.println("stop edit ");
						pressContinue();
						break active;
					}

					else if(choice_edit.contentEquals("id"))
					{
						System.err.println("enter id new for room ");
						change=sc.nextLine();int point=0;

						for(Room l:list)
						{
							if(l.getRoomId().toLowerCase().contentEquals(change.toLowerCase()))
							{
								
								System.out.println("id is exist !! please enter again");
								pressContinue();	 
								continue active;
							}
						}
						list.get(index).setRoomId(change);
						System.out.println("edit id sucessfull");
					    pressContinue(); 
						
					}
                 
					else if(choice_edit.contentEquals("nb"))
					{
					number:while(true)
					{
						try
						{
							int num;
							System.out.println("enter number room new for room");
							num=sc.nextInt();
							sc.nextLine();
							for(Room l:list)
							{
								if(l instanceof ServiceRoom)
								{
									ServiceRoom srn= (ServiceRoom)l;
                                     if(srn.getNoRoom()==num)
									 {
										System.err.println("number room is exits!!please enter again");
										pressContinue();
										 break number;
									 }
								}
							}
								list.get(index).setNoRoom(num);
							System.out.println("edit number room sucessfull");
							pressContinue();
							break;

						}catch(Exception e)
						{
							System.out.println("data error! ");
		                   sc.nextLine();
		                  pressContinue();
						}
					}
				}
				

				else if(choice_edit.contentEquals("nm"))
				{
				System.out.println("enter new name for room");
				change=sc.nextLine();
				((ServiceRoom) list.get(index)).setName(change);
				System.out.println("edit name sucessfull");
				pressContinue();
				}
				}

			}
			else if(r instanceof ReadRoom)
			{				
				active:while(true)
				{
					clearScreen();
					r.display();
					System.out.println("\n");
					System.out.println("enter 'a' to edit all information room ");
					System.out.println("enter 'id ' to edit room id ");
					System.out.println("enter 'nb' to edit numer room");
					System.out.println("enter 'e' to end edit room this ");
					choice_edit=sc.nextLine();
					choice_edit.toLowerCase();

					if(choice_edit.contentEquals("e"))
					{
                        System.out.println("stop edit ");
						pressContinue();
						break active;
					}

					else if(choice_edit.contentEquals("id"))
					{
						System.err.println("enter id new for room ");
						change=sc.nextLine();int point=0;

						for(Room l:list)
						{
							if(l.getRoomId().toLowerCase().contentEquals(change.toLowerCase()))
							{
								
								System.out.println("id is exist !! please enter again");
								pressContinue(); 
								continue active;
							}
						}
						list.get(index).setRoomId(change);
						System.out.println("edit id sucessfull");
						pressContinue();
						
					}
                 
					else if(choice_edit.contentEquals("nb"))
					{
					number:while(true)
					{
						try
						{
							int num;
							System.out.println("enter number room new for room");
							num=sc.nextInt();
							sc.nextLine();
							for(Room l:list)
							{
								if(l instanceof ServiceRoom)
								{
									ServiceRoom srn= (ServiceRoom)l;
                                     if(srn.getNoRoom()==num)
									 {
										System.err.println("number room is exits!!please enter again");
									pressContinue();
										 break number;
									 }
								}
							}
								list.get(index).setNoRoom(num);
							System.out.println("edit number room sucessfull");
							pressContinue();	
							break;

						}catch(Exception e)
						{
							System.out.println("data error! ");
		                   sc.nextLine();
		                 pressContinue();
						}
					}

				}

				}
			}

		}
   }


   // hàm tìm kiếm
   public  void Search() {
	String keyContinue;
    String request; ArrayList <Room>rsr=new ArrayList<Room>();
	System.out.println("enter id or name room you want to search ");
	request=sc.nextLine();
	request.toLowerCase();
	int flag=0;
	work_search:for(Room r:list)
	{
		if(r instanceof ServiceRoom)
		{
			ServiceRoom srs= (ServiceRoom) r;
			if(request.contentEquals(srs.getName().toLowerCase())||request.contentEquals(srs.getRoomId().toLowerCase()))
			{
				flag=1;
				rsr.add(srs);
				break work_search;
			}
			else
			{
				if((srs.getName().toLowerCase()).contains(request)==true||(srs.getRoomId()).toLowerCase().contains(request)==true)
				{
                  flag=2;
				  rsr.add(srs);
				}
			}

		}
		else if(r instanceof ReadRoom)
		{
			ReadRoom rds=(ReadRoom) r;
			if(request.contentEquals((rds.getRoomId()).toLowerCase())||request.contentEquals(ReadRoom.getName()))
			{
				flag=1;
				rsr.add(rds);

			}
			else
			{
				if(ReadRoom.getName().contains(request)==true||(rds.getRoomId()).toLowerCase().contains(request)==true)
				{
                  flag=2;
				  rsr.add(rds);
				}
			}
		}
	}
	if(flag==0)
	{
		System.out.println("id or name room you entered no exist");
		pressContinue();
	}
	else if(flag==1)
	{
		System.out.println("information room you need search ");
		for(Room r:rsr)
    	{
    		if(r instanceof ReadRoom)
    		{
    			ReadRoom rd=(ReadRoom)r;
    			rd.display();
                System.out.println("\n ");
    		}
    		else if(r instanceof ServiceRoom)
    		{
    			ServiceRoom sr=(ServiceRoom)r;
    			sr.display();
				System.out.println("\n ");

    		}
    	}
		pressContinue();
	}
	else if(flag==2)
	{
		System.out.println("list of room can you want to search");
		for(Room r:rsr)
    	{
    		if(r instanceof ReadRoom)
    		{
    			ReadRoom rd=(ReadRoom)r;
    			rd.display();
                System.out.println("\n ");
    		}
    		else if(r instanceof ServiceRoom)
    		{
    			ServiceRoom sr=(ServiceRoom)r;
    			sr.display();
				System.out.println("\n ");

    		}
    	}
		pressContinue();

	}

   };


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
