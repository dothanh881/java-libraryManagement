package project_library;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
public class DocumentManagement implements LibraryManagement {
    Scanner sc=new Scanner(System.in);
	private ArrayList<Document> list;
    
    public DocumentManagement()
    {
        list=new ArrayList<Document>();
    }

    public DocumentManagement(ArrayList<Document> arr)
    {
      list=arr;
    }

    // hàm xóa màn hình
	public void clearScreen()
	{
		System.out.print("\033[H\033[2J");  // clear sreen
		System.out.flush();
	}

	// hàm dừng màn hình
	public void pressContinue()
	{
		String keyContinue;
		System.out.println("Press Enter to continue... ");
		keyContinue=sc.nextLine();
	}

   
 







   public void Add(){};
  public  void Delete(){};
  public   void Edit(){};
  public  void Search(){};

  public   void Display()
  {
    ArrayList<Disk> disk=new ArrayList<Disk>();
		System.out.println("===============*==============");
    	System.out.println("list of book: ");
		System.out.println("\n");
    	for(Document listTest:list)
    	{
    		if(listTest instanceof Book)
    		{
    			Book bk=(Book)listTest;
    			bk.display();
    		}
    		else if(listTest instanceof Disk)
    		{
    			Disk dk=(Disk)listTest;
    			disk.add(dk);
    		}
    	}
				
        System.out.println("\n");
        System.out.println("===============*==============");
    	System.out.println("list of disk: ");
    	for(Disk sr:disk)
    	{
    		sr.display();
            System.out.println("\n ");

    	}

  }
    
    
}
