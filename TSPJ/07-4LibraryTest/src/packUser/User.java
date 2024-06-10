package packUser;

import java.util.ArrayList;

import packBook.Book;

public class User implements Comparable<User> {
	private static int SN=0;
	private String name;
	private int uID;
	private ArrayList <Book> brwLst;
	
	public User(String name)
	{
		SN++;
		uID = SN;
		this.name = name;
		brwLst = new ArrayList<Book>();
	}
		
	public String getName()
	{
		return name;
	}
	
	public int getuID( )
	{
		return uID;
	}
	
	public ArrayList<Book> getBrwLst() {
		return brwLst;
	}
	
	public boolean brw(Book b) {
		// 이미 대출중인 책을 빌리면? >> 대출 가능한 책만 인자로 들어온다
		for(Book x:brwLst) {
			if(x.getTitle().equals(b.getTitle())) {
				System.out.println("이미 같은 제목의 책을 빌렸음");
				return false;
			}
		}
		brwLst.add(b);
		return true;
	}
	
	public boolean rtn(Book b) {
		if(brwLst.remove(b)) {
			return true;
		}else {
			System.out.println("빌린 내역에 없음");
			return false;
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(uID+"-"+name+" >> 대출내역:");
		//만약 brwlst가 비어 있으면 동작 안하나?
		for(Book x:brwLst) { 
			sb.append(" "+x.getID()+"-"+x.getTitle());
		}
		sb.append(" 총 "+brwLst.size()+"권");
		return sb.toString();
	}
	
	@Override
	public int compareTo(User o) {
		return this.brwLst.size()-o.brwLst.size();
	}
	
}
