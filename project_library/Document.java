package project_library;

public class Document {

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
			System.out.println("id    : "+this.id);
			System.out.println("name  : "+this.name);
			System.out.println("author:"+this.author);
			System.out.println("type  : "+this.type);
		}

		
		

}
