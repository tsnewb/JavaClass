package packUser;

import java.util.ArrayList;
import packBook.Book;

public class User implements Comparable<User> {
	private static int SN=0;
	private String name;
	private int uID;
	private ArrayList <Book> brwLst;
	
	public User(String name) {
		uID = ++SN;
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
	public ArrayList<Book> getBrwLst(){
		return brwLst;
	}
	public boolean brw(Book b) {
		for(Book x : brwLst) {
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
		}
		System.out.println("빌린 내역에 없음");
		return false;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(uID+"-"+name+">>대출내역:");
		for(Book x: brwLst) {
			sb.append(x.toStringSimple()+" ");
		}
		sb.append("총 "+brwLst.size()+"권");
		return sb.toString();
	}
	@Override
	public int compareTo(User o) {
		return this.getBrwLst().size()-o.getBrwLst().size();
	}
	
}
