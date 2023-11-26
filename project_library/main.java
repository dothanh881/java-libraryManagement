package project_library;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	static ArrayList<Room>room=new ArrayList<Room>();
    public static  RoomManagement rmt=new RoomManagement(room);
	static ArrayList<Document> document=new ArrayList<Document>();
	public static DocumentManagement dmt=new DocumentManagement(document);
	static ArrayList<Person> person=new ArrayList<Person>();
	public static PersonManagement pmt=new PersonManagement(person);
	static ArrayList<Card> card=new ArrayList<Card>();
	public static CardManagement cmt=new CardManagement(card);

	public static void  displayWork()
	{   System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.printf("| %-14s | %-14s | %-14s |%-14s |%-14s |%-14s |\n"," 1. ADD "," 2. DELETE ","  3. EDIT ","  4 .SEARCH ", "  5. DISPLAY ","  0. END ");
	    System.out.println("----------------------------------------------------------------------------------------------------");
  	    System.out.println("choose work");
		/*System.out.println("1.Add ");
		System.out.println("2.Delete");
		System.out.println("3.Edit");
		System.out.println("4.Search ");
		System.out.println("5.Display ");
		System.out.println("0.end");
		System.out.println("choose work");*/

	}
	public static int numberTryCatch()
	{
		Scanner sc=new Scanner(System.in);

		int a=0;
		number:while(true)
        {
            try
            {
                System.out.println("enter number to follow button to work");
                a=sc.nextInt();
                sc.nextLine();
                break;
            }
            catch(Exception e)
            {
                System.out.println("data invidial! please again");
                sc.nextLine();
                pessContinue.press();
            }
        }
		return a;

	}

	

	public static void main(String [] args) throws IOException
	{
			Scanner sc=new Scanner(System.in);
		
		String[] arr=new String[10];

		// đọc dữ liệu cho ServiceRoom
		try {
			
		BufferedReader br=new BufferedReader( new FileReader("ServiceRoom.txt"));
		String line=br.readLine();
			while(line!=null)
			{
                arr=line.split(",");
				if(arr.length>1)
                {ServiceRoom sr=new ServiceRoom(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3]);
                room.add(sr);
				}
                line=br.readLine();
				
			}
			br.close();		
		}
		catch(Exception e)
		{
			System.out.println("error open file!! ");
			e.printStackTrace();
			pessContinue.press();

		}
		
		// đọc dữ liệu cho ReadRoom
		
		try {
		BufferedReader br=new BufferedReader( new FileReader("ReadRoom.txt "));
		String line=br.readLine();
			while(line!=null)
			{
                arr=line.split(",");    
				if(arr.length>1)
				{        
                ReadRoom rd=new ReadRoom(Integer.parseInt(arr[0].trim()),arr[1],arr[2]);
                room.add(rd);
				}
                line=br.readLine();
				
			}
			br.close();		
		}
		catch(Exception ex)
		{
			System.out.println("error open file!! ");
			ex.printStackTrace();
		}
		
		ArrayList<ReadRoom> rdl=new ArrayList<ReadRoom>();
		rdl=rmt.getReadRoom();

		//Đọc dữ liệu cho sách
		try {
			
		BufferedReader br=new BufferedReader( new FileReader("Book.txt"));
		String line=br.readLine();
		 	while(line!=null)
			{
                arr=line.split(",");
				if(arr.length>1)
				{
				  Book bk=new Book(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4].trim()),arr[5]);
				  document.add(bk);
				}
				line=br.readLine();

			}
			br.close();		
		}
		catch(Exception ex)
		{
			System.out.println("error open file book !! ");
			ex.printStackTrace();
		}
		//Đọc dữ liệu cho đĩa
	 	try {
			
		BufferedReader br=new BufferedReader( new FileReader("Disk.txt"));
		String line=br.readLine();
			while(line!=null)
			{
                arr=line.split(",");
				if(arr.length>1)
				{
                Disk dk=new Disk(arr[0],arr[1],arr[2],arr[3],Double.parseDouble(arr[4].trim()),Double.parseDouble(arr[5].trim()),arr[6]);
                document.add(dk);
				}
                line=br.readLine();
				
			}
			br.close();		
		}
		catch(Exception ex)
		{
			System.out.println("error open file disk!! ");
			ex.printStackTrace();
		}

		//Đọc dữ liệu cho nhân viên
		try {
			
		BufferedReader br=new BufferedReader( new FileReader("Staff.txt"));
		String line=br.readLine();
			while(line!=null)
			{
                arr=line.split(",");
				if(arr.length>1)
				{
                Staff dk=new Staff(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4].trim()),arr[5],arr[6]);
                person.add(dk);
				}
                line=br.readLine();
				
			}
			br.close();		
		}
		catch(Exception ex)
		{
			System.out.println("error open file staff!! ");
			ex.printStackTrace();
		}
		//Đọc dữ liệu cho người đọc
		try {
			
		BufferedReader br=new BufferedReader( new FileReader("Reader.txt"));
		String line=br.readLine();
			while(line!=null)
			{
                arr=line.split(",");
				if(arr.length>1)
				{
                Reader dk=new Reader(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4].trim()),arr[5],arr[6],arr[7]);
                person.add(dk);
				}
                line=br.readLine();
			}
			br.close();		
		}
		catch(Exception ex)
		{
			System.out.println("error open file reader!! ");
			ex.printStackTrace();
		}

		//Đọc dữ liệu cho thẻ thường
		try {
			
		BufferedReader br=new BufferedReader( new FileReader("NormalCard.txt"));
		String line=br.readLine();
			while(line!=null)
			{
                arr=line.split(",");
				if(arr.length>1)
				{
                CardNormal dk=new CardNormal(arr[0],arr[1],Integer.parseInt(arr[2].trim()));
                card.add(dk);
				}
                line=br.readLine();
			}
			br.close();		
		}
		catch(Exception ex)
		{
			System.out.println("error open file normal card!! ");
			ex.printStackTrace();
		}

		// Đọc dữ liệu cho thẻ mượn
		int b=0;int c=0;
		try {
			
		BufferedReader br=new BufferedReader( new FileReader("BorrowCard.txt"));
		String line=br.readLine();
		ArrayList<CardDetail> cdl=new ArrayList<CardDetail>();
		ArrayList<CardDetail> ctemp;
		flag:while(line!=null)
			{

				if(line.contains("/"))
				{
					arr=line.split("/");
					if(arr.length>1)
					{
					CardDetail cd=new CardDetail(arr[0],arr[1],arr[2]);
					cdl.add(cd);
					}
					line=br.readLine();

				}
				else
				{
					ctemp=(ArrayList<CardDetail>) cdl.clone();
					arr=line.split(",");
					if(arr.length>1)
					{
					CardBorrow cb=new CardBorrow(arr[0],arr[1],ctemp);
					card.add(cb);					
					cdl.clear();
					}
					line=br.readLine();
				}
             
			}
			br.close();		
		}
		catch(Exception ex)
		{
			System.out.println("error open file borrow card!! ");
			ex.printStackTrace();
			 System.out.println("Press Enter to continue... ");
		 String key1;
		 key1=sc.nextLine();
		}		
		
		int chooseObject;int chooseRoom;int chooseDocument;int choosePerson;int chooseCard;
	rdpr:while(true)
		{
			object:while(true)
			{
				
				ClearScreen.clear();
				System.out.println("-------------------------------------------------------------------------------------");
		        System.out.printf("| %-14s | %-14s | %-14s |%-14s |%-14s |\n"," 1. ROOM "," 2. DOCUMENT ","  3. PERSON ","  4 .CARD ","  0. END ");
	            System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("choose object to work");
				/*System.out.println("choose object to work");
				System.out.println("1.room ");
				System.out.println("2.document");
				System.out.println("3.person");
				System.out.println("4.card ");
				System.out.println("0.end ");*/
				chooseObject=numberTryCatch();
				if(chooseObject==0) break rdpr;
				else if(chooseObject==1)
				{
					or:while(true)
					{
				    ClearScreen.clear();
					System.out.println("    ROOM   ");
				    displayWork();
					chooseRoom=numberTryCatch();
					if(chooseRoom==1)
					{
						rmt.Add();
						pessContinue.press();
					}
					else if(chooseRoom==2)
					{
						rmt.Delete();
						pessContinue.press();
					}
					else if(chooseRoom==3)
					{
						rmt.Edit();
						pessContinue.press();
					}
					else if(chooseRoom==4)
					{
						rmt.Search();
						pessContinue.press();
					}
					else if(chooseRoom==5)
					{
						rmt.Display();
						pessContinue.press();
					}
					else if(chooseRoom==0) break or;

				    }
			    }
				else if(chooseObject==2)
				{
					od:while(true)
					{
				    ClearScreen.clear();
					System.out.println("    DOCUMENT   ");
				    displayWork();
					chooseDocument=numberTryCatch();
					if(chooseDocument==1)
					{
						ClearScreen.clear();
						dmt.Add();
						pessContinue.press();
					}
					else if(chooseDocument==2)
					{
						ClearScreen.clear();
						dmt.Delete();
						pessContinue.press();
					}
					else if(chooseDocument==3)
					{
						ClearScreen.clear();
						dmt.Edit();
						pessContinue.press();
					}
					else if(chooseDocument==4)
					{
						ClearScreen.clear();
						dmt.Search();
						pessContinue.press();
					}
					else if(chooseDocument==5)
					{
						ClearScreen.clear();
						dmt.Display();
						pessContinue.press();
					}
					else if(chooseDocument==0) break od;
				    }
				}
				else if(chooseObject==3)
				{
				    ClearScreen.clear();
					ops:while(true)
					{
					System.out.println("    PERSON   ");
				    displayWork();
					choosePerson=sc.nextInt();
					sc.nextLine();
					if(choosePerson==1)
					{
						ClearScreen.clear();
						pmt.Add();
						pessContinue.press();
					}
					else if(choosePerson==2)
					{
						ClearScreen.clear();
						pmt.Delete();
						pessContinue.press();
					}
					else if(choosePerson==3)
					{
						ClearScreen.clear();
						pmt.Edit();
						pessContinue.press();
					}
					else if(choosePerson==4)
					{
						ClearScreen.clear();
						pmt.Search();
						pessContinue.press();
					}
					else if(choosePerson==5)
					{
						ClearScreen.clear();
						pmt.Display();
						pessContinue.press();
					}
					else if(choosePerson==0) break ops;
				    }
				}
				else if(chooseObject==4)
				{
					ocd:while(true)
					{
				    ClearScreen.clear();
					System.out.println("     CARD     ");
				    displayWork();
					chooseCard=numberTryCatch();
					if(chooseCard==1)
					{
						ClearScreen.clear();
						cmt.Add();
						pessContinue.press();
					}
					else if(chooseCard==2)
					{
						ClearScreen.clear();
						cmt.Delete();
						pessContinue.press();
					}
					else if(chooseCard==3)
					{
						ClearScreen.clear();
						cmt.Edit();
						pessContinue.press();
					}
					else if(chooseCard==4)
					{
					    ClearScreen.clear();
						cmt.Search();
						pessContinue.press();
					}
					else if(chooseCard==5)
					{
						ClearScreen.clear();
						cmt.Display();
						pessContinue.press();
					}
					else if(chooseCard==0) break ocd;
					
			      	}
					
				}
				
			}
		    
 
		} 

	
	}
		
	
		
		
				
}

	



