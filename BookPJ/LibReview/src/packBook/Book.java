package packBook;

import packUser.User;

public class Book extends Item {
	
	private User brwer;
	
	public Book(String title) {
		super(title);
		
	}
		
	public User getBrwer()
	{
		return brwer;
	}
	
	public void brw(User u)
	{
		brwer = u;		
	}
	
	public void rtn( )
	{
		brwer = null;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(super.toString());
		if(brwer == null)
			sb.append(": 대출가능");
		else
			sb.append(": 대출됨>>고객ID-"+brwer.getuID());
		return sb.toString();
	}
	
	public String toStringSimple() {
		return super.toString();
	}
		
}

