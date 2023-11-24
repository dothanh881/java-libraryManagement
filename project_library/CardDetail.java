package project_library;

import javax.print.Doc;

public class CardDetail {
    private String idDocument;
     private String timeBorrow;
     private String timeReturn;
     
     
     
	public CardDetail(String idDocument, String timeBorrow, String timeReturn) {
		this.idDocument = idDocument;
		this.timeBorrow = timeBorrow;
		this.timeReturn = timeReturn;
	}
	
	public CardDetail() {
		this.idDocument = "no ";
		this.timeBorrow = "no ";
		this.timeReturn = "no ";
	}
	
	public String getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(String idDocument) {
		this.idDocument = idDocument;
	}
	public String getTimeBorrow() {
		return timeBorrow;
	}
	public void setTimeBorrow(String timeBorrow) {
		this.timeBorrow = timeBorrow;
	}
	public String getTimeReturn() {
		return timeReturn;
	}
	public void setTimeReturn(String timeReturn) {
		this.timeReturn = timeReturn;
	}

    public void display()
    {
        for(Document dt:main.dmt.getDocumentManagement())
        {
			String temp=((dt.getId()).toLowerCase()).trim();
			String tempthis=(this.idDocument.toLowerCase()).trim();
            if(temp.contentEquals(tempthis))
            {
                System.out.println("name book: "+dt.getName());
				System.out.println("day borrow "+this.timeBorrow);
				System.out.println("day return "+this.timeReturn);
            }
        }
    }
}
