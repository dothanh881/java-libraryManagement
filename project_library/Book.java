package project_library;

public class Book extends Document {
    private int page;

    // hàm thiết lập không tham số
    public Book()
    {
        super();
        page=0;
    }

    // hàm thiết lập có tham số
    public Book(String id, String name, String author, String type,int page,String potion)
    {
        super( id, name, author,  type, potion);
        this.page=page;
    }
    
    public int getPage()
    {
        return this.page;
    }

    public void setPage(int page)
    {
        this.page=page;
    }
    public void display()
    {
        super.display();
        System.out.println("book page: "+this.page);
    }
    
}

