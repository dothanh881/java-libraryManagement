package project_library;

import java.util.ArrayList;

public class ReadRoom extends Room {
	private static String name="read room";
	private ArrayList<shelf> idShelf;
	private String idsf;

	
	// hàm khởi tạo không tham số
	public ReadRoom()
	{
		super();
		idShelf=new ArrayList<shelf>();
	}
	
	// hàm khởi tạo có tham số
	public ReadRoom(int noRoom,String roomId,ArrayList<shelf> list)
	{
		super(noRoom,roomId);
		idShelf=list;
	}

	// Hàm khởi tạo có idsf
	public ReadRoom(int noRoom,String roomId,String idsf)
	{
		super(noRoom,roomId);
		this.idsf=idsf;
	}

	// hàm lấy giá trị mảng danh sách id kệ sách
	public ArrayList<shelf> getIdShelf() {
		return idShelf;
	}
	


	// hàm truyền giá trị mới cho danh sách id kệ sách
	public void setIdShelf(ArrayList<shelf> idShelf) {
		this.idShelf = idShelf;
	}
	

	public void display()
	{
		super.display();
		System.out.println("list id shelf in read room number  "+this.noRoom+" :");
		for(shelf list:idShelf)
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
		
	}
	public static String getName()
	{
		return name;
	}
}
	