package project_library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class main {

	
	
	public static void main(String [] args)
	{
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
      rmt.Display();
		
		
	
		
		
		
		
		
	}

	

}

