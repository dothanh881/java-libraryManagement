package project_library;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class main {
 
	
	public static void main(String [] args) throws IOException
	{
			Scanner sc=new Scanner(System.in);
			

		ArrayList<Room>room=new ArrayList<Room>();
		String[] arr;

		// đọc dữ liệu cho ServiceRoom
		try {
			
		BufferedReader br=new BufferedReader( new FileReader("c:\\users\\admin\\desktop\\project-java\\ServiceRoom.txt "));
		String line=br.readLine();
			while(line!=null)
			{
                arr=line.split(",");
                ServiceRoom sr=new ServiceRoom(Integer.parseInt(arr[0]),arr[1],arr[2]);
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
            
                ReadRoom rd=new ReadRoom(Integer.parseInt(arr[0]),arr[1],arr[2]);
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
		 RoomManagement rmt=new RoomManagement(room);
		ArrayList<ReadRoom> rdl=new ArrayList<ReadRoom>();
		rdl=rmt.getReadRoom();

		//Đọc dữ liệu cho sách
		ArrayList<Document> document=new ArrayList<Document>();
		try {
			
		BufferedReader br=new BufferedReader( new FileReader("C:\\Users\\ADMIN\\Desktop\\project-java\\Book.txt"));
		String line=br.readLine();
		 	while(line!=null)
			{
                arr=line.split(",");
				Book bk=new Book(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4]),arr[5]);
				document.add(bk);
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
                Disk dk=new Disk(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4]),Integer.parseInt(arr[5]),arr[6]);
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
		DocumentManagement dmt=new DocumentManagement(document,rdl);
		int a;
		while(true)
		{
			ClearScreen.clear();
			System.out.println("1. display");
			System.out.println("2.add");
			System.out.println("3.delete");
			System.out.println("4.edit");
			System.out.println("5.search");
			System.out.println("0.end");
			a=sc.nextInt();
			sc.nextLine();
			if(a==1)
			{
				dmt.Display();
				String keyContinue;
		System.out.println("Press Enter to continue... ");
		keyContinue=sc.nextLine();

			}
			else if(a==2)
			{
				dmt.Add();
			}
			else if(a==3)
			{
				dmt.Delete();
			}
			else if(a==4)
			{
				dmt.Edit();
			}
			else if(a==5)
			{
				dmt.Search();
			}
			else if(a==6) rmt.Search();

		} 

		/*String an="  The Count of MONTE Cristo " ;
         System.out.println(an.toLowerCase());
		 String b=" Monte ";
          b.toLowerCase();
		 if(an.toLowerCase().contains(b)==true)
		 {
			System.out.println("yes");
		 }*/
		
	


		

		
      
	}
		
	
		
		
				
}

	



