package project_library;

import java.util.ArrayList;

public class ServiceRoom extends Room{
  private String name;
  private String areaPlace;
  
  /* hàm khởi tạo không tham số*/
  public ServiceRoom()
  {
	  super();
	  name=" ";
  }
  
  /* hàm khởi tạo có tham số*/
  public ServiceRoom(int noRoom, String roomId, String name,String areaPlace)
  {
      super(noRoom, roomId);
      this.name = name;
      this.areaPlace=areaPlace;
  }
  // hàm dừng màn hình
	public void pressContinue()
	{
		String keyContinue;
		System.out.println("Press Enter to continue... ");
		keyContinue=sc.nextLine();
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
public String getAreaPlace()
{
	return this.areaPlace;
}

/* hàm nhận giá trị tên */
public void setAreaPlace(String name) {
	this.areaPlace = name;
}

public void display()
{
	super.display();
	System.out.println("name room: " +name+" ");
  System.out.println("arae work: "+this.areaPlace);

}
public void enterData()
{
	super.enterData();
	System.out.println("enter name room: ");
	name=sc.nextLine();

  
}
public void enterAreaPlace(ArrayList<Room>list)
{  
  ap: while(true)
  {
      int index=-1;int i=0;

    System.out.println("enter area place: ");
        this.areaPlace=sc.nextLine();
        String temp=((this.areaPlace).toLowerCase()).trim();
    for(Room d:list)
    {
          if(d instanceof ServiceRoom)
          {
            ServiceRoom sd=(ServiceRoom) d;
            String gap=((sd.getAreaPlace()).toLowerCase()).trim();
            if(gap.contentEquals(temp))
            {
              index=i;
            }
          }
       i++;
    }
    if(index==-1) break ap;
    else 
    {
      System.out.println("\n");
      list.get(index).display();
      System.out.println("Area work is exist!!please enter again");
      pressContinue();
    }

    
  }
}
}
