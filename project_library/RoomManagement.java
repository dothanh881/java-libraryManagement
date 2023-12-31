package project_library;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class  RoomManagement implements LibraryManagement {
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
		String temp=(m.toLowerCase()).trim();

		int i=0;int index=-1;
		for(Room r:list)
		{
			String gd=((r.getRoomId()).toLowerCase()).trim();
				if(gd.contentEquals(temp))
				{
					index=i;
			
				}
			
			i++;
		}
		return index;
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

	//hàm lấy dữ liệu phòng đọc
	public ArrayList<ReadRoom> getReadRoom()
	{
		ArrayList<ReadRoom> a =new ArrayList<ReadRoom>();
		for(Room r:list)
		{
           if(r instanceof ReadRoom)
		   {
              ReadRoom m=(ReadRoom) r;
			  a.add(m);
		   }
		}
		return a;
	}
	//hàm lấy dữ liệu phòng dịch vụ
	public ArrayList<ServiceRoom> getServiceRoom()
	{
		ArrayList<ServiceRoom> a =new ArrayList<ServiceRoom>();
		for(Room r:list)
		{
           if(r instanceof ServiceRoom)
		   {
              ServiceRoom m=(ServiceRoom) r;
			  a.add(m);
		   }
		}
		return a;
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
    
	// hàm thêm dữ liệu phòng
    public void Add() {
		
    	while(true){
			try{
		int choose;
       
    	work_add:while(true)
    	{
			clearScreen();
			/*System.out.println("0. press number 0 to end add");
    		System.out.println("1. press number 1 to add service room ");
    		System.out.println("2. press number 2 to add read room ");*/
			System.out.println("          ADD ROOM        ");
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.printf("| %-27s | %-27s | %-27s |\n"," 1. ADD SERVICE ROOM "," 2. ADD READ ROOM ","          0. END ");
			System.out.println("-------------------------------------------------------------------------------------------");
    		System.out.println("Enter type room want to add ");
			choose=sc.nextInt();
			sc.nextLine();
			if(choose==0) break work_add ;
			
    		switch(choose)
    		{
				
    		case 1: // thêm phòng dịch vụ
    			while(true){
    				ServiceRoom srv=new ServiceRoom();
    				srv.enterData(); 
					srv.enterAreaPlace(list);
                     pressContinue();
    				int checkId=checkIdRoom(srv.getRoomId());
                    int checkNo=checkNoRoomService(srv.getNoRoom());

					if(checkId==-1&&checkNo==-1) // thông báo nhập thành công
    					    {
    					    	list.add(srv);
    					    	System.out.println("Add room service successfully ");
    					    	pressContinue();
    					    	break;
    					    	
    					    }
    					else if(checkNo!=-1) // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng số phòng
    					    {
								
								System.out.println("Number room service you enter that is exits !! ");
								list.get(checkNo).displayTable();
								System.out.println("please enter again");
								pressContinue();

    					    }

							else if(checkId!=-1) // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng id phòng
							{
								System.out.println("Id room service you enter that is exits !! ");
								//System.out.println("id you enter: "+srv.getRoomId());
								//System.out.println("\n id trung: "+list.get(checkId));
								list.get(checkId).displayTable();
								System.out.println("Please enter again");
								pressContinue();
							}
    				break;
						}
						break;
    			
				case 2:
				    while(true){
    				ReadRoom rd=new ReadRoom();
    				rd.enterData(); 
					rd.enterIdDocument(list);
    				int checkId=checkIdRoom(rd.getRoomId());
                    int checkNo=checkNoRoomRead(rd.getNoRoom());

					if(checkId==-1&&checkNo==-1) // thông báo nhập thành công
    					    {
    					    	list.add(rd);
    					    	System.out.println("Add room read successfully ");
    					    	pressContinue();
    					    	break;
    					    	
    					    }
    					else if(checkNo!=-1) // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng số phòng
    					    {
								
								System.out.println("Number room read you enter that is exits !! ");
								list.get(checkNo).displayTable();
								System.out.println("Please enter again");
								pressContinue();

    					    }

							else // báo lỗi và yêu cầu nhập lại nếu người dùng nhập trùng id phòng
							{
								System.out.println("Id room you enter is that exits!! please enter again ");
								list.get(checkId).displayTable();
								System.out.println("Please enter again");
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
		System.out.println("Data error! ");
		sc.nextLine();
		pressContinue();
	}
    }
    	
    };

	// Hàm xóa
    public void Delete() {

		Display();
		String request;
		System.out.println("Enter id room you want to delete ");
		request=sc.nextLine();
		request.toLowerCase();
		String choice;
		int checkId=checkIdRoom(request);
		
		if(checkId==-1) {
			System.out.println("Room you want to delete that does not  exits or is deleted before");
			pressContinue();

		}
		else if(checkId!=-1)
		{
			String yes="y";
			String no="n";
			clearScreen();
			list.get(checkId).displayTable();
			System.out.println("\n");
            action:while(true){
			
			System.out.println("Are you sure want to delete this (yes/no)? ");
			
			System.out.println("Enter 'y' to choose 'yes' and enter 'n' to choose 'no' ");
			choice=sc.nextLine();
			choice.toLowerCase();
		      if(choice.contentEquals(yes))
			  {
				list.remove(checkId);
				System.out.println("You have deleted sucessful ");
				pressContinue();
				break action;
			  }
			  else if(choice.contentEquals(no))
			  {
				System.out.println("Deletion failed");
				pressContinue();
				break action;
			  }
			  else
			  {
				System.out.println("Your choice is unsuitable!! please enter again");
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
		System.out.println("Enter id room you want to edit ");
		request=sc.nextLine();String end=" ";int new_num;
		request=(request.toLowerCase()).trim();
		int checkId=checkIdRoom(request);
       
		if(checkId==-1) {
			System.out.println("Room you want to edit that does not exits ");
              pressContinue();
		}
		else
		{
                ServiceRoom temp=new ServiceRoom();
				String areawork=" ";
				if(list.get(checkId) instanceof ServiceRoom)
				{
					temp= (ServiceRoom)list.get(checkId);
					type =1;
					areawork=temp.getAreaPlace();

				}	

			    ReadRoom temp1=new ReadRoom();
                 String positionBook=" ";
			    if(list.get(checkId) instanceof ReadRoom)
				{
					temp1= (ReadRoom)list.get(checkId);
					type=2;
					positionBook=temp1.IdDocument();
				}	
				
				list.remove(checkId);

				if(type==1)
				{
					ServiceRoom sr=new ServiceRoom();
					temp.displayTable();
				    System.out.println("Enter new data for service room");
					sr.enterData();	
					sr.setAreaPlace(areawork);
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
					        list.get(checktype1).displayTable();
					        System.out.println("Id room is exist !! please enter again id room");
					        System.out.println("\n");
				         	end=sc.nextLine();
				        	sr.setRoomId(end);
				        	continue checkType1;
						}
						else if(checktype2!=-1 )
						{
                          list.get(checktype2).displayTable();
					      System.out.println("\n");
						  while(true)
						  {
							try
							{
								System.out.println("Number room is exist !! Please enter again number room");
                                 new_num=sc.nextInt();
								 sc.nextLine();
								 break;
							}catch(Exception e)
							{
								System.out.println("Data error !! Please enter again");
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
					temp1.displayTable();
				    System.out.println("Enter new data  for read room");
					rd.enterData();
					rd.setIdDocuemt(positionBook);
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
					        list.get(checktype1).displayTable();
					        System.out.println("ID room is exist !! Please enter again id room");
					        System.out.println("\n");
				         	end=sc.nextLine();
				        	rd.setRoomId(end);
				        	continue checkType2;
						}
						else if(checktype2!=-1 )
						{
						  System.out.println("\n");
                          list.get(checktype2).displayTable();
						   System.out.println("\n");
					       while(true)
						  {
							try
							{
								System.out.println("Number room is exist !! Please enter again number room");
                                 new_num=sc.nextInt();
								 sc.nextLine();
								 break;
							}catch(Exception e)
							{
								System.out.println("Data error !! Please enter again");
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
					System.out.println("Are you sure want to save change this (yes/no)? ");
			        System.out.println("Enter 'y' to choose 'yes' and enter 'n' to choose no");
			        save=sc.nextLine();
		         	save.toLowerCase();

		           if(save.contentEquals("y"))
			       {
				     System.out.println("You have save change sucessfully! ");
				     pressContinue();
				     break action;
			       }
			       else if(save.contentEquals("n"))
			       {
				    list.remove(checkId);
			     	System.out.println("Save change failed !");
			    	if(type==1)
			    	list.add(checkId,temp);
			    	else if(type==2) list.add(checkId,temp1); 
			     	pressContinue();
			    	break action;
			       }
			        else
			       {
				    System.out.println("Your choice is unsuitable!! please enter again");
				    pressContinue();
			        }
				}

		}
		
	}
			
   // hàm tìm kiếm
   public  void Search() {
    String request; ArrayList<Room> rsr=new ArrayList<Room>();
	ArrayList<Room> srsm =new ArrayList<Room>();
	System.out.println("Enter id or name room you want to search ");
	request=sc.nextLine();
	String temp=(request.toLowerCase()).trim();
	int flag=0;int flagsg=0;
	work_search:for(Room r:list)
	{
		if(r instanceof ServiceRoom)
		{
			ServiceRoom srs= (ServiceRoom) r;
			String gn=((srs.getName()).toLowerCase()).trim();
			String gd=((srs.getRoomId()).toLowerCase()).trim();
			if(temp.contentEquals(gn)||temp.contentEquals(gd))
			{
				flag=1;
				rsr.add(srs);
			}
			else
			{
				if(gn.contains(temp)==true||gd.contains(temp)==true)
				{
                  flagsg=2;
				  srsm.add(srs);
				}
				if(temp.contains(gn)==true||temp.contains(gd)==true)
				{
                  flagsg=2;
				  srsm.add(srs);
				}
			}

		}
		else if(r instanceof ReadRoom)
		{
			ReadRoom srs= (ReadRoom) r;
			String gn=((ReadRoom.getName()).toLowerCase()).trim();
			String gd=((srs.getRoomId()).toLowerCase()).trim();
			if(temp.contentEquals(gn)||temp.contentEquals(gd))
			{
				flag=1;
				rsr.add(srs);
			}
			else
			{
				if(gn.contains(temp)==true||gd.contains(temp)==true)
				{
                  flagsg=2;
				  srsm.add(srs);
				}
				if(temp.contains(gn)==true||temp.contains(gd)==true)
				{
                  flagsg=2;
				  srsm.add(srs);
				}
			}
        }
	}
	 if(flag==1)
	{
		System.out.println("Information room you need search ");
		for(Room rm:rsr)
    	{
    		if(rm instanceof ReadRoom)
    		{
    			ReadRoom rd=(ReadRoom)rm;
    			rd.display();
    		}
    		else if(rm instanceof ServiceRoom)
    		{
    			ServiceRoom sr=(ServiceRoom)rm;
    			sr.display();

    		}
    	}
	}
	 if(flagsg==2)
	{
		System.out.println("list of room can you want to search");
		for(Room rm:srsm)
    	{
    		if(rm instanceof ReadRoom)
    		{
    			ReadRoom rd=(ReadRoom)rm;
    			rd.displayTable();
                System.out.println("\n ");
    		}
    		else if(rm instanceof ServiceRoom)
    		{
    			ServiceRoom sr=(ServiceRoom)rm;
    			sr.displayTable();
				System.out.println("\n ");

    		}
    	}

		pressContinue();

	}
	else if(flag==0&&flagsg==0)
	{
		System.out.println("Id or name room you entered that does not  exist");
		pressContinue();
	}
	

   
}



    // Hàm hiển thị dữ liệu
    public void Display()
    {
		ArrayList<ServiceRoom> service=new ArrayList<ServiceRoom>();
		System.out.println("        READ ROOM LIST       ");
        System.out.println("--------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s |\n", "number room ", "room id", "ID document ");
        System.out.println("--------------------------------------------------");

            for (Room listTest :list) 
			{
                if (listTest instanceof ReadRoom) {
                    ReadRoom clothing = (ReadRoom) listTest;
                    System.out.printf("| %-15s | %-15s | %-15s |\n",clothing.getNoRoom(), clothing.getRoomId(),clothing.IdDocument());        
                }
				else if(listTest instanceof ServiceRoom)
    		   {
    			ServiceRoom sr=(ServiceRoom)listTest;
    			service.add(sr);
    		   }
            }
		System.out.println("--------------------------------------------------");

		System.out.println("\n");

		System.out.println("        SERVICE ROOM LIST       ");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-35s | %-15s |\n","number room ", "room id", "name ","area ID");       
        System.out.println("------------------------------------------------------------------------------------------");

            for (Room listTest :list) {
                if (listTest instanceof ServiceRoom) {
                    ServiceRoom clothing = (ServiceRoom) listTest;
                    System.out.printf("| %-15s | %-15s | %-35s |  %-15s |\n",clothing.getNoRoom(), clothing.getRoomId(),clothing.getName(), clothing.getAreaPlace());

                }
				else if(listTest instanceof ServiceRoom)
    		   {
    			ServiceRoom sr=(ServiceRoom)listTest;
    			service.add(sr);
    		   }
            }
        }

    }
		

    	/*ArrayList<ServiceRoom> service=new ArrayList<ServiceRoom>();
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
    	
    }*/

	
  



