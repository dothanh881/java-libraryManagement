package project_library;

import java.util.ArrayList;

public class ReadRoom extends Room {
	private static String name="read room";
	private ArrayList<String> idShelf;
	
	// hàm khởi tạo không tham số
	public ReadRoom()
	{
		super();
		idShelf=new ArrayList<String>();
	}
	
	// hàm khởi tạo có tham số
	public ReadRoom(int noRoom,String roomId,ArrayList<String> list)
	{
		super(noRoom,roomId);
		idShelf=list;
	}

	// hàm lấy giá trị mảng danh sách id kệ sách
	public ArrayList<String> getIdShelf() {
		return idShelf;
	}
	


	// hàm truyền giá trị mới cho danh sách id kệ sách
	public void setIdShelf(ArrayList<String> idShelf) {
		this.idShelf = idShelf;
	}
	

	public void display()
	{
		super.display();
		System.out.println("list id shelf in read room number  "+this.noRoom+" :");
		for(String list:idShelf)
		{
			System.out.println(list+" ");
		}
	}
	
	public void enterData()
	{
		super.enterData();
		int numberShelf;String idsf;

		while(true)
		{
		  try
		  {
			  System.out.println("enter number shelf of read room "+this.noRoom);
			numberShelf=sc.nextInt();
			   sc.nextLine();
			   break;
		  }catch(Exception e)
		  {
			  System.out.println("data invidial!! please enter again");
			  sc.nextLine();
		  }
		}
		
		System.out.println("enter id shelf of number read room "+this.noRoom);
		for(int i=0;i<numberShelf;i++)
		{
			int b=i+1;
			System.out.println("enter id of shelf "+b+": " );
			idsf=sc.nextLine();
			idShelf.add(idsf);
			
		}
	}
	public static String getName()
	{
		return name;
	}
}
	