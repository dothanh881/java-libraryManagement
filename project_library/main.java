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

	public static void main(String [] args) throws IOException
	{
			Scanner sc=new Scanner(System.in);
		
		String[] arr=new String[10];

		// đọc dữ liệu cho ServiceRoom
		try {
			
		BufferedReader br=new BufferedReader( new FileReader("c:\\users\\admin\\desktop\\project-java\\ServiceRoom.txt "));
		String line=br.readLine();
			while(line!=null)
			{
                arr=line.split(",");
				
                ServiceRoom sr=new ServiceRoom(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3]);
                room.add(sr);
                line=br.readLine();
			}
			br.close();		
		}
		catch(Exception e)
		{
			System.out.println("error open file!! ");
			e.printStackTrace();
		}
		
		// đọc dữ liệu cho ReadRoom
		
		try {
		BufferedReader br=new BufferedReader( new FileReader("c:\\users\\admin\\desktop\\project-java\\ReadRoom.txt "));
		String line=br.readLine();
			while(line!=null)
			{
                arr=line.split(",");            
                ReadRoom rd=new ReadRoom(Integer.parseInt(arr[0].trim()),arr[1],arr[2]);
                room.add(rd);
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
			
		BufferedReader br=new BufferedReader( new FileReader("C:\\Users\\ADMIN\\Desktop\\project-java\\Book.txt"));
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
			
		BufferedReader br=new BufferedReader( new FileReader("C:\\Users\\ADMIN\\Desktop\\project-java\\Disk.txt"));
		String line=br.readLine();
			while(line!=null)
			{
                arr=line.split(",");
                Disk dk=new Disk(arr[0],arr[1],arr[2],arr[3],Double.parseDouble(arr[4].trim()),Double.parseDouble(arr[5].trim()),arr[6]);
                document.add(dk);
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
			
		BufferedReader br=new BufferedReader( new FileReader("C:\\Users\\ADMIN\\Desktop\\project-java\\Staff.txt"));
		String line=br.readLine();
			while(line!=null)
			{
                arr=line.split(",");
                Staff dk=new Staff(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4].trim()),arr[5],arr[6]);
                person.add(dk);
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
			
		BufferedReader br=new BufferedReader( new FileReader("C:\\Users\\ADMIN\\Desktop\\project-java\\Reader.txt"));
		String line=br.readLine();
			while(line!=null)
			{
                arr=line.split(",");
                Reader dk=new Reader(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4].trim()),arr[5],arr[6],arr[7]);
                person.add(dk);
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
			
		BufferedReader br=new BufferedReader( new FileReader("C:\\Users\\ADMIN\\Desktop\\project-java\\NormalCard.txt"));
		String line=br.readLine();
			while(line!=null)
			{
                arr=line.split(",");
                CardNormal dk=new CardNormal(arr[0],arr[1],Integer.parseInt(arr[2].trim()));
                card.add(dk);
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
			
		BufferedReader br=new BufferedReader( new FileReader("C:\\Users\\ADMIN\\Desktop\\project-java\\BorrowCard.txt"));
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
		
		int a;
		while(true)
		{
			ClearScreen.clear();
			System.out.println("1. display");
			System.out.println("2.add");
			System.out.println("3.delete");
			System.out.println("4.edit");
			System.out.println("5.search");
			System.out.println("6.search room");
			System.out.println("7.add person");
			System.out.println(" 8.edit room");
			System.out.println("9.delete");
			System.out.println("10.statictis");
			System.out.println("0.end");
			a=sc.nextInt();
			sc.nextLine();
			if(a==1)
			{
				
				cmt.Display();
				System.out.println("Press Enter to continue... ");
		        String key1;
		         key1=sc.nextLine();
				

			}
			else if(a==2)
			{
				cmt.Add();
			}
			else if(a==3)
			{
				cmt.Delete();
			}
			else if(a==4)
			{
				cmt.Edit();
			}
			else if(a==5)
			{
				pmt.Search();
			}
			else if(a==6) pmt.Search();
			else if (a==7) pmt.Add();
			else if (a==8) rmt.Edit();
			else if(a==9) rmt.Delete();
			else if(a==0) break;
 
		} 

		
		
	


		

		
      
	}
		
	
		
		
				
}

	



