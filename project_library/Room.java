package project_library;

import java.util.Scanner;
public class Room
{
Scanner sc=new Scanner(System.in);
	protected int noRoom;
	protected String roomId;
	private static String libraryName="KLF Sai Gon University";
	
	/* khởi tạo không tham số */
	public Room()
	{
		noRoom=0;
		roomId=" ";
	}
	
	/* khởi tạo có tham số */
	public Room(int noRoom,String roomId)
	{
		this.noRoom=noRoom;
		this.roomId=roomId;
	}
	
	/* lấy giá trị số phòng*/

	public int getNoRoom() {
		return noRoom;
	}
	
	/* hàm sửa giá trị số phòng */	
	public void setNoRoom(int noRoom) {
		this.noRoom = noRoom;
	}
	
	/* lấy giá trị id phòng */
	public String getRoomId() {
		return roomId;
	}
	
	/* sửa giá trị id phòng */
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
	/* in tên thư viện */
	public static void displayNameLibrary()
	{
		System.out.println(libraryName);
	}
	
	// in thong tin số phòng , id phòng
	public void display()
	{
		System.out.println("number room: "+this.noRoom);
		System.out.println("id room: "+this.roomId);
	}
    public void displayTable()
	{

	};

	
	// nhập dữ liệu
	public void enterData()
	{
		while(true)
		{try {
			System.out.println("enter number room ");
			this.noRoom=sc.nextInt();
			sc.nextLine();

			break;
		}catch(Exception e)
		{
			System.out.println(" you entered invalid data number room !! plese enter again ");
			sc.nextLine();
				System.out.println("Press Enter to continue... ");
		String keyContinue=sc.nextLine();
		System.out.print("\033[H\033[2J");  // clear sreen
			System.out.flush();

		}
		}
		System.out.println("enter id room ");
		this.roomId=sc.nextLine();
		
		
		
	}
	
	
	


	
}