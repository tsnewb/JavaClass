package packBook;

public class Item  {
	private static int SN=0;
	private int ID;
	private String title;
		
	public Item(String title)
	{
		SN++;
		ID = SN;
		this.title = title; 
	}
		
	public String getTitle()
	{
		return this.title;
	}
	
	public int getID()
	{
		return ID;
	}
	
	@Override
	public String toString() {
		return ID+"-"+title;
	}
	
}

