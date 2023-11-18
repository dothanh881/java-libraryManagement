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
		catch(Exception ex)
		{
			System.out.println("error open file!! ");
			ex.printStackTrace();
		}
		
		// đọc dữ liệu cho ReadRoom
		
		try {

		BufferedReader br=new BufferedReader( new FileReader("c:\\users\\admin\\desktop\\project-java\\ReadRoom.txt "));
		String line=br.readLine();
			while(line!=null)
			{
    			ArrayList<String> idsf=new ArrayList<String>();
                arr=line.split(",");
                for(String l:arr)
                {
                	idsf.add(l);
                }
                line=br.readLine();
                arr=line.split(",");
                ReadRoom rd=new ReadRoom(Integer.parseInt(arr[0]),arr[1],idsf);
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
		
      RoomManagement rmt=new  RoomManagement(room);
	  int a; String keyContinue;
     while(true)
	 {
		System.out.print("\033[H\033[2J");  // clear sreen
			System.out.flush();
        System.out.println("1. to add ");
		System.out.println(" 2. to display ");
		System.out.println("3.search");
		System.out.println("4.delete");
		System.out.println("enter choose ");
		a=sc.nextInt();
		sc.nextLine();
		if(a==0) break;
		else if(a==1)
		{
			rmt.Add();
		}
		else if(a==3)
		{
			rmt.Search();
		}
		else if(a==4)
		{
			rmt.Delete();
		}
		else if(a==5)
		{
			rmt.Edit();
		}
		else
		{
			rmt.Display();
			System.out.println("Press Enter to continue... ");
								keyContinue=sc.nextLine();
		}
	 }
		
	
		
		
		
		
		
	}

	

}

