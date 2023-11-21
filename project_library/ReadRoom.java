package project_library;

import java.util.ArrayList;

public class ReadRoom extends Room {
	private static String name="read room";
	private String IdDocument;

	
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
		System.out.println("Id Document: "+this.IdDocument);
	}
	
	public void enterIdDocument()
	{
		System.out.println("enter id document of room read ");
		this.IdDocument=sc.nextLine();
	}
	public static String getName()
	{
		return name;
	}
}
	