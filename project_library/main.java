package project_library;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class main implements Serializable {
	
	public static void main(String [] args) 
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
		try{
		   BufferedReader br=new BufferedReader(new FileReader("c:\\users\\admin\\desktop\\ReadRoom.txt"));
			BufferedReader sf=new BufferedReader(new FileReader("c:\\users\\admin\\desktop\\shelf.txt"));
			String line=sf.readLine();
			String[] arrs;
			arrs=line.split(",");
			while(line!=null)
			{
				shelf s=new shelf(arr.)
			}
             
		}catch(Exception e)
		{
			System.out.println("open file ReadRoom.txt or file shelf.txt failed!! ");
		}
	

		RoomManagement rmt=new  RoomManagement(room);
		
        // đọc dữ liệu cho Book
		try {
			
		BufferedReader br=new BufferedReader( new FileReader("c:\\users\\admin\\desktop\\project-java\\Book.txt "));
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

		
	
		
		
		
		
		
	}

	

}

