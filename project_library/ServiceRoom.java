package project_library;

import java.util.ArrayList;

public class ServiceRoom extends Room{
  private String name;
  
  /* hàm khởi tạo không tham số*/
  public ServiceRoom()
  {
	  super();
	  name=" ";
  }
  
  /* hàm khởi tạo có tham số*/
  public ServiceRoom(int noRoom, String roomId, String name)
  {
      super(noRoom, roomId);
      this.name = name;
  }
  
  /* hàm lấy giá trị tên */
public String getName()
{
	return name;
}

/* hàm nhận giá trị tên */
public void setName(String name) {
	this.name = name;
}

public void display()
{
	super.display();
	System.out.println("name room: " +name+" ");
}
public void enterData()
{
	super.enterData();
	System.out.println("enter name room: ");
	name=sc.nextLine();

  
}
}
