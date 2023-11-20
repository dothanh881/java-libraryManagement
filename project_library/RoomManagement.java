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
		int flag=0;int i=0;int index=-1;
		for(Room r:list)
		{
			
				if(r.getRoomId().toLowerCase().contentEquals(m))
				{
					flag=1;
					index=i;
			
				}
			
			i++;
		}
		if(flag==1) return index;
       return -1;
	}

	// hàm kiểm tra trùng số phòng dịch vụ
	public int checkNoRoomService( int m)
	{
		int flag=0;int i=0;int index=-1;
		for(Room r:list)
		{
			if(r instanceof ServiceRoom)
			{
                ServiceRoom sr=(ServiceRoom) r;
				if(sr.getNoRoom()==m)
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

	// kiểm tra trùng số phòng đọc
	public int checkNoRoomRead(int m)
	{
		int flag=0;int i=0;int index=0;
		for(Room r:list)
		{
			 if( r instanceof ReadRoom)
			{
				ReadRoom rd=(ReadRoom) r;
				if(rd.getNoRoom()==m)
				{
					flag=1;
					index=i;
					break;
				}
			}
			i++;
		}
		if(flag==1) return index;
		return -1;
	}

	//hàm lấy danh sách phòng đọc
	public ArrayList<ReadRoom> getReadRoom()
	{
		ArrayList<ReadRoom> rd= new ArrayList<ReadRoom>();
		for( Room r:list)
		{
			if(r instanceof ReadRoom)
			{
				ReadRoom a= (ReadRoom)r;
				rd.add(a);
			}
		}
		return rd;
	}

    // hàm lấy danh sách phòng dịch vụ
	public ArrayList<ServiceRoom> getServiceRoom()
	{
		ArrayList<ServiceRoom> sv= new ArrayList<ServiceRoom>();
		for( Room r:list)
		{
			if(r instanceof ServiceRoom)
			{
				ServiceRoom a= (ServiceRoom)r;
				sv.add(a);
			}
		}
		return sv;
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
    				srv.enterData(); 

    				int checkId=checkIdRoom(srv.getRoomId());
                    int checkNo=checkNoRoomService(srv.getNoRoom());

					if(checkId==-1&&checkNo==-1) // thông báo nhập thành công
    					    {
    					    	list.add(srv);
    					    	System.out.println("add room service successfully ");
    					    	pressContinue();
    					    	break;
    					    	
    					    }
    					else if(checkNo!=-1) // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng số phòng
    					    {
								
								System.out.println("number room service you enter is exits !! ");
								list.get(checkNo).display();
								System.out.println("please enter again");
								pressContinue();

    					    }

							else if(checkId!=-1) // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng id phòng
							{
								System.out.println("id room you enter is exits!! please enter again ");
								System.out.println("id room service you enter is exits !! ");
								list.get(checkId).display();
								System.out.println("please enter again");
								pressContinue();
							}
    				break;
						}
						break;
    			
				case 2:
				    while(true){
    				ReadRoom rd=new ReadRoom();
    				rd.enterData(); 

    				int checkId=checkIdRoom(rd.getRoomId());
                    int checkNo=checkNoRoomRead(rd.getNoRoom());

					if(checkId==-1&&checkNo==-1) // thông báo nhập thành công
    					    {
    					    	list.add(rd);
    					    	System.out.println("add room read successfully ");
    					    	pressContinue();
    					    	break;
    					    	
    					    }
    					else if(checkNo!=-1) // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng số phòng
    					    {
								
								System.out.println("number room read you enter is exits !! ");
								list.get(checkNo).display();
								System.out.println("please enter again");
								pressContinue();

    					    }

							else // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng id phòng
							{
								System.out.println("id room you enter is exits!! please enter again ");
								System.out.println("id room read you enter is exits !! ");
								list.get(checkId).display();
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
		int checkId=checkIdRoom(request);
		
		if(checkId==-1) {
			System.out.println("room you want to delete no exits or is deleted before");
			pressContinue();

		}
		else if(checkId!=-1)
		{
			String yes="y";
			String no="n";
			clearScreen();
			list.get(checkId).display();
			
            action:while(true){
			
			System.out.println("are you sure want to delete this (yes/no)? ");
			
			System.out.println("enter 'y' to choose 'yes' and enter 'n' to choose 'no' ");
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
		String request;String save;int type=0;
		System.out.println("enter id room you want to edit ");
		request=sc.nextLine();String end=" ";int new_num;
		request.toLowerCase();
		int checkId=checkIdRoom(request);
       
		if(checkId==-1) {
			System.out.println("room you want to edit no exits ");
              pressContinue();
		}
		else
		{
                ServiceRoom temp=new ServiceRoom();
				if(list.get(checkId) instanceof ServiceRoom)
				{
					temp= (ServiceRoom)list.get(checkId);
					type =1;

				}	

			    ReadRoom temp1=new ReadRoom();
			    if(list.get(checkId) instanceof ReadRoom)
				{
					temp1= (ReadRoom)list.get(checkId);
					type=2;
				}	
				list.remove(checkId);

				if(type==1)
				{
					ServiceRoom sr=new ServiceRoom();
				    System.out.println("enter data new for service room");
					sr.enterData();				
					checkType1:while(true)
					{
						int checktype1=checkIdRoom(sr.getRoomId());
				        int checktype2=checkNoRoomService(sr.getNoRoom());

						if(checktype1==-1&&checktype2==-1)
						{
							break checkType1;
						}

						if(checktype1!=-1 )
						{
                            System.out.println("\n");
					        list.get(checktype1).display();
					        System.out.println("id room is exist !! please enter again id room");
					        System.out.println("\n");
				         	end=sc.nextLine();
				        	sr.setRoomId(end);
				        	continue checkType1;
						}
						else if(checktype2!=-1 )
						{
                          list.get(checktype2).display();
					      System.out.println("\n");
						  while(true)
						  {
							try
							{
								System.out.println("number room is exist !! please enter again number room");
                                 new_num=sc.nextInt();
								 sc.nextLine();
								 break;
							}catch(Exception e)
							{
								System.out.println("data invidial!! please enter again");
								sc.nextLine();

								pressContinue();
							}
						  }
					      sr.setNoRoom(new_num);
					      continue checkType1;
						}

					}
					list.add(checkId, sr);				    
				}
				else if(type==2)
				{
					ReadRoom rd=new ReadRoom();
				    System.out.println("enter data new for read room");
					rd.enterData();
					checkType2:while(true)
					{
						int checktype1=checkIdRoom(rd.getRoomId());
				        int checktype2=checkNoRoomRead(rd.getNoRoom());
						
						if((checktype1==-1&&checktype2==-1))
						{
							break checkType2;
						}

						if(checktype1!=-1 )
						{
                            System.out.println("\n");
					        list.get(checktype1).display();
					        System.out.println("iD room is exist !! please enter again id room");
					        System.out.println("\n");
				         	end=sc.nextLine();
				        	rd.setRoomId(end);
				        	continue checkType2;
						}
						else if(checktype2!=-1 )
						{
						  System.out.println("\n");
                          list.get(checktype2).display();
						   System.out.println("\n");
					       while(true)
						  {
							try
							{
								System.out.println("number room is exist !! please enter again number room");
                                 new_num=sc.nextInt();
								 sc.nextLine();
								 break;
							}catch(Exception e)
							{
								System.out.println("data invidial!! please enter again");
								sc.nextLine();
								pressContinue();
							}
						  }
						  rd.setNoRoom(new_num);
					      continue checkType2;
						}
					}
					list.add(checkId,rd);
				}
				action:while(true)
				{
					System.out.println("are you sure want to save change this (yes/no)? ");
			        System.out.println("enter 'y' to choose 'yes' and enter 'n' to choose no");
			        save=sc.nextLine();
		         	save.toLowerCase();

		           if(save.contentEquals("y"))
			       {
				     System.out.println("you have save change sucessful ");
				     pressContinue();
				     break action;
			       }
			       else if(save.contentEquals("n"))
			       {
				    list.remove(checkId);
			     	System.out.println("save change failed");
			    	if(type==1)
			    	list.add(checkId,temp);
			    	else if(type==2) list.add(checkId,temp1); 
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
		System.out.println("===============*==============");
    	System.out.println("list of read room: ");
		System.out.println("\n");
    	for(Room listTest:list)
    	{
    		if(listTest instanceof ReadRoom)
    		{
    			ReadRoom rd=(ReadRoom)listTest;
    			rd.display();
    		}
    		else if(listTest instanceof ServiceRoom)
    		{
    			ServiceRoom sr=(ServiceRoom)listTest;
    			service.add(sr);
    		}
    	}
				
        System.out.println("\n");
        System.out.println("===============*==============");
    	System.out.println("list of service room: ");
    	for(ServiceRoom sr:service)
    	{
    		sr.display();
            System.out.println("\n ");

    	}
    	
    }

}

