package packMain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import packBook.Book;
import packUser.User;

class Lib {
	
	
	HashMap < String, ArrayList<Book> > bkTitleMap;
	HashMap < Integer, Book> bookMap;
	HashMap < Integer, User> userMap;
	static Scanner scan = new Scanner(System.in);	
	
	Lib(){
		bkTitleMap = new HashMap<String, ArrayList<Book>>();
		bookMap = new HashMap<Integer, Book>();
		userMap = new HashMap<Integer, User>();
	}
	
	void init()
	{
		Book b1 = new Book("토토로");
		Book b2 = new Book("토토로");
		Book b3 = new Book("자바");
		bookMap.put(b1.getID(), b1);
		bookMap.put(b2.getID(), b2);
		bookMap.put(b3.getID(), b3);
		
		ArrayList<Book> lst = new ArrayList() ;
		lst.add(b1);  lst.add(b2);
		bkTitleMap.put(b1.getTitle(), lst);
		
		lst = new ArrayList() ;
		lst.add(b3); 
		bkTitleMap.put(b3.getTitle(), lst);
		
		User u = new User("김철수");
		userMap.put(u.getuID(), u);	
		u = new User("이선수");
		userMap.put(u.getuID(), u);	
		u = new User("강감찬");
		userMap.put(u.getuID(), u);	
		u = new User("강감찬");
		userMap.put(u.getuID(), u);	
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("==도서목록==\n");
		Iterator<String> t = bkTitleMap.keySet().iterator();
		while(t.hasNext()) {
			Iterator<Book> b = bkTitleMap.get(t.next()).iterator();
			while(b.hasNext()) {
				sb.append(b.next().toString()+" ");
			}
			sb.append("\n");
		}
		sb.append("==고객목록==\n");
		Collection<User> u = userMap.values();
		for(User x :u) {
			sb.append(x.toString()+"\n");
		}
		return sb.toString();
	}
	User inuID() {
		while(true) {
			try {
				System.out.print("고객 ID:");
				Integer uid = scan.nextInt();
				return userMap.get(uid); //고객ID 없으면 null반환

			} catch (InputMismatchException e) {
				System.out.println("고객ID는 정수를 입력해야 합니다. 다시 입력하세요.");
				scan.nextLine();
			}
		}
	}
	Book inbID() {
		while(true) {
			try {
				System.out.print("책 ID:");
				Integer bid = scan.nextInt();
				return bookMap.get(bid); 

			} catch (InputMismatchException e) {
				System.out.println("책ID는 정수를 입력해야 합니다. 다시 입력하세요.");
				scan.next();
			}
		}
	}
	void borrowBook() {
		System.out.print("대출할 책 이름:");
		String title = scan.nextLine().trim();
		ArrayList<Book> b = bkTitleMap.get(title);
		if(b == null) {
			System.out.println("해당책 없음");
			return;
		}
		for(Book x:b) {
			if(x.getBrwer()==null) {
				User u = inuID();
				if(u==null) {
					System.out.println("해당고객ID 없음");
					return;
				}
				if(u.brw(x)) {
					x.brw(u);
					System.out.println("대출합니다");
					System.out.println(x);
					System.out.println(u);
					return;
				}else {
					return;
				}
			}
				
		}
		System.out.println("모두 대출됨");
			
	}
	void returnBook() {
		User u = inuID();
		if(u==null) {
			System.out.println("해당고객ID 없음");
			return;
		}
		System.out.print("반납할 ");
		Book b = inbID();
		if(b == null) {
			System.out.println("해당책 없음");
			return;
		}
		if(u.rtn(b)) {
			b.rtn();
			System.out.println(b);
			System.out.println(u);
		}
		else
			return;
	}
	void addBook() {
		System.out.println("구입한 책 이름:");
		String title = scan.nextLine().trim();
		Book b = new Book(title);
		bookMap.put(b.getID(), b);
		ArrayList<Book> lb = bkTitleMap.get(title);
		if(lb==null) {
			lb = new ArrayList<Book>();
			lb.add(b);
			bkTitleMap.put(title, lb);
		}else {
			lb.add(b);
		}
		System.out.println(b);
	}
	void delBook() {
		System.out.println("폐기할 ");
		Book b = inbID();
		if(b == null) {
			System.out.println("해당책 없음");
			return;
		}
		if(b.getBrwer() != null) {
			System.out.println("해당책 대출중입니다.");
			return;
		}
		ArrayList<Book> lb = bkTitleMap.get(b.getTitle());
		if(lb==null) {
			System.out.println("해당책 없음");
			return;
		}
		lb.remove(b);
		if(lb.size() == 0) {
			bkTitleMap.remove(b.getTitle());
		}
		System.out.println(bookMap.remove(b.getID()));
		System.out.println("폐기되었습니다.");
	}
	void searchBookMap() {
		System.out.print("책 이름:");
		String title = scan.nextLine().trim();
		ArrayList<Book> lb = bkTitleMap.get(title);
		if(lb==null) {
			System.out.println("해당책 없음");
			return;
		}
		for(Book x:lb) {
			System.out.println(x);
		}
		return;
	}
	void searchUserMap() {
		User u = inuID();
		if(u==null) {
			System.out.println("해당고객 없음");
			return;
		}
		System.out.println(u);
		return;
	}
	void searchUserMapName() {
		int cnt = 0;
		System.out.print("고객 이름:");
		String name = scan.nextLine().trim();
		Collection<User> ul = userMap.values();
		for(User u:ul) {
			if(u.getName().equals(name)) {
				System.out.println(u);
				cnt++;
			}
		}
		if(cnt==0)
			System.out.println("해당고객 없음");
		return;
	}
	void userMapSort() {
		ArrayList<User> ul = new ArrayList<User>(userMap.values());
		Collections.sort(ul,Collections.reverseOrder());
		for(User u:ul) {
			System.out.println(u);
		}
	}
		
	void mng()
	{
		while(true)
		{
			menu();
			int ch = scan.nextInt();
			scan.nextLine();
			if( ch == 99 ) break;
			switch(ch)
			{
			  case 1 : this.searchBookMap(); break;
			  case 2 : this.searchUserMap(); break;
			  case 3 : this.borrowBook(); break;
			  case 4 : this.returnBook(); break;
			  case 5 : System.out.print(this); break;
			  case 6 : this.searchUserMapName(); break;
			  case 7 : this.addBook(); break;
			  case 8 : this.delBook(); break;
			  case 9 : this.userMapSort(); break;
			  case 99 : break;
			}
		}
	}
	
	void menu()
	{
		System.out.print("-------------\n"
	            + "1.책조회 2.고객조회 3.대출 4.반납 5.리스트출력 6.고객ID찾기 7.책구입 8.책폐기 9. 대출권수 순으로 고객 리스트  99.종료\n"
				+"선택?"); 
	}
	
	
	public static void main(String[] args) {
		Lib lib = new Lib();
		lib.init();
		lib.mng();
		scan.close();
	}

}

