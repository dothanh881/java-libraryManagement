package project_library;

import java.util.ArrayList;

public class ReadRoom extends Room {
	private static String name="read room";
	private String IdDocument;
	private static double readFee=2;

	
	// hàm khởi tạo không tham số
	public ReadRoom()
	{
		super();
		IdDocument=" ";
	}
	
	// hàm khởi tạo có tham số
	public ReadRoom(int noRoom,String roomId,String IdDocument)
	{
		super(noRoom,roomId);
		this.IdDocument=IdDocument;

	}

	
	public static double getFeeBasic()
	{
		 return readFee;
	}

	public void pressContinue()
	   {
		  String keyContinue;
		  System.out.println("Press Enter to continue... ");
		  keyContinue=sc.nextLine();
	   }

	// hàm lấy giá trị mảng danh sách id kệ sách
	public String IdDocument() {
		return this.IdDocument;
	}
	
	// hàm truyền giá trị mới cho danh sách id kệ sách
	public void setIdDocuemt(String IdDocument) {
		this.IdDocument = IdDocument;
	}
	

	public void display()
	{
		super.display();
		System.out.println("ID document "+this.IdDocument);
	}
	public void displayTable()
	{
	 System.out.println("--------------------------------------------------");
     System.out.printf("| %-15s | %-15s | %-15s |\n", "number room ", "room id", "ID document ");
	 System.out.println("--------------------------------------------------");
	 System.out.printf("| %-15s | %-15s | %-15s |\n",this.getNoRoom(), this.getRoomId(),this.IdDocument());        
	 System.out.println("--------------------------------------------------");


	}
	
	public void enterIdDocument(ArrayList<Room> list)
	{
		id: while(true)
			{
				int flag=0;int index=-1;int i=0;

				System.out.println("Enter Id document : ");
		        this.IdDocument=sc.nextLine();
				String temp=((this.IdDocument).toLowerCase()).trim();
				for(Room d:list)
				{
					if(d instanceof ReadRoom)
					{
						ReadRoom r= (ReadRoom) d;
					String gd =((r.IdDocument()).toLowerCase()).trim();
					if(temp.contentEquals(gd))
					{
						flag=1;
						index=i;
					}
					i++;
				   }

				}
				if(flag==0) break id;
				else if(flag==1) 
				{
					System.out.println("\n");
					list.get(index).display();
					System.out.println("Id document is exist!!please enter again");
					pressContinue();
				}

				
			}
	}
	public static String getName()
	{
		return name;
	}
}
	