package project_library;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;

public class Document {
       Scanner sc=new Scanner(System.in);
        protected String potion;
	    protected String id;
	    protected String name;
	    protected String author;
	    protected String type;

	    
		public Document( String id, String name, String author, String type,String potion) {
			this.potion=potion;
			this.id = id;
			this.name = name;
			this.author = author;
			this.type = type;
		}
		public Document() {
			this.id = " ";
			this.name = " ";
			this.author = " ";
			this.type = " ";
			
		}
		public void pressContinue()
	   {
		  String keyContinue;
		  System.out.println("Press Enter to continue... ");
		  keyContinue=sc.nextLine();
	   }
		public String getPotion() {
			return potion;
		}
		public void setPotion(String potion) {
			this.potion = potion;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
		public void display()
		{
			System.out.println("Id    : "+this.id);
			System.out.println("Name  : "+this.name);
			System.out.println("Author:"+this.author);
			System.out.println("Type  : "+this.type);
			System.out.println("Id document: "+this.potion);
		}
		public void displayTable()
		{

		}

		public void searchLocation(ArrayList<ReadRoom> listrd)
		{
			listrd=main.rmt.getReadRoom();
			ArrayList<ReadRoom> rdd=new ArrayList<ReadRoom>();
			String temp=(this.potion.toLowerCase()).trim();
		     for(ReadRoom r:main.rmt.getReadRoom())
			 {
				String rm=((r.IdDocument()).toLowerCase()).trim();
				if(temp.contentEquals(rm))
				{
                   rdd.add(r);
				}
			 }
			 if(rdd.isEmpty()==true)
			 {
				System.out.println("Read room is deleted before");
				pressContinue();
			 }
			 else
			 {
				System.out.println("Book is put in: ");
			    for(ReadRoom r:rdd)
			    {
					System.out.println("\n");
					r.displayTable();
					System.out.println();
			    }
			 }

		}
		
		public void enterId(ArrayList<Document> list)
		{
           id: while(true)
			{
				int flag=0;int index=-1;int i=0;

				System.out.println("Enter Id: ");
		        this.id=sc.nextLine();
				String temp=((this.id).toLowerCase()).trim();
				for(Document d:list)
				{
					String gd =((d.getId()).toLowerCase()).trim();
					if(temp.contentEquals(gd))
					{
						flag=1;
						index=i;
					}
					i++;

				}
				if(flag==0) break id;
				if(flag==1) 
				{
					System.out.println("\n");
					list.get(index).displayTable();
					System.out.println("Id document exist!!please enter again");
					pressContinue();
				}

				
			}
		}

		public void enterData(ArrayList<ReadRoom> listrd)
		{
			
			System.out.println("Enter name: ");
			name=sc.nextLine();
			System.out.println("Enter name of the author : ");
			author=sc.nextLine();
			System.out.println("Enter type: ");
			type=sc.nextLine();

			position:while(true)
			{
				int m;
              for(ReadRoom r:listrd)
			  {
				System.out.println("Number room: "+r.getNoRoom());
				System.out.println(r.IdDocument());
				System.out.println("\n");
			  }
			
				int flag1=0;
				try{
                  System.out.println("Enter number room you want to put in book ");
				  m=sc.nextInt();
				  sc.nextLine();
				  int index1=-1;
				  int i=0;
				   for(ReadRoom r:listrd)
			       {
				       if(r.getNoRoom()==m)
					   {
						flag1=1;
						index1=i;
					   }

					   i++;
			       }
				   if(flag1==1) 
				   {
					this.potion=listrd.get(index1).IdDocument();
					break position;
				   }
				   else if(flag1==0)
				   {
					System.out.println("\n");
					  System.out.println("Number room you entered that doesn't exist !!Please enter again");
					  pressContinue();
					  System.out.println("\n");
				   }
				}catch(Exception e)
				{
					System.out.println("data error!! Please enter again! ");
					sc.nextLine();
					pressContinue();
					continue position;

				}
				ClearScreen.clear();

			}

			

		}

		
		

}
