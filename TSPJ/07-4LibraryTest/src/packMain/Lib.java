package packMain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import packBook.Book;
import packUser.User;

class Lib {
	
	
	HashMap < String, ArrayList<Book> > bkTitleMap; //key:title
	HashMap < Integer, Book> bookMap; //key:ID
	HashMap < Integer, User> userMap; //key:uID
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
		
		ArrayList<Book> lst = new ArrayList<>();
		lst.add(b1);  lst.add(b2);
		bkTitleMap.put(b1.getTitle(), lst);
		
		lst = new ArrayList<>();
		lst.add(b3); 
		bkTitleMap.put(b3.getTitle(), lst);
		
		User u = new User("김철수");
		userMap.put(u.getuID(), u);	
		u = new User("이선수");
		userMap.put(u.getuID(), u);	
		u = new User("강감찬");
		userMap.put(u.getuID(), u);	
		u = new User("이선수");
		userMap.put(u.getuID(), u);	
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("==도서목록==\n");
		Iterator<String> iter1 = bkTitleMap.keySet().iterator();
		//Iterator<ArrayList<Book>> iter1 = bkTitleMap.keySet().iterator(); 가능
		while(iter1.hasNext()) {
			Iterator<Book> iter2 = bkTitleMap.get(iter1.next()).iterator();
			while(iter2.hasNext()) {
				sb.append(iter2.next().toString()+"  ");
			}
			sb.append("\n");
			//책을 폐기해서 책제목만 남아있고 ArrayList<Book>의 요소가 비어있을경우 줄만 늘어 날 수 있다.
			//ArrayList<Book>의 요소가 전부 지워지면 key와 함께 해시맵에서 지워지나? >> ㄴㄴ 남아 있다
		}
		sb.append("==고객목록==\n");
		Iterator<Integer> iter3 = userMap.keySet().iterator();
		while(iter3.hasNext()) {
			sb.append(userMap.get(iter3.next()).toString()+"\n");
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
				scan.next();
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
		String btitle = scan.nextLine().trim();
		ArrayList<Book> blist = bkTitleMap.get(btitle);
		if(blist == null) {
			System.out.println("해당책 없음");
			return;
		}
		Book b = null;
		for(Book x:blist) {
			if(x.getBrwer()==null) {
				b = x;
				break;
			}
		}
		if(b==null) {
			System.out.println("모두 대출됨");
			return;
		}
		User u = inuID();
		if(u == null) {
			System.out.println("해당고객ID 없음");
			return;
		}
		if(u.brw(b)) {
			b.brw(u); 
			System.out.println("대출합니다");
			System.out.println(b);
			System.out.println(u);
		}else {
			System.out.println("대출오류");
		}
	}
	
	void returnBook() {
		User u = inuID();
		if(u == null) {
			System.out.println("해당고객ID 없음");
			return;
		}
		System.out.print("반납할 ");
		Book b = inbID();
		if(b==null) {
			System.out.println("해당책ID 없음");
			return;
		}
		if(u.rtn(b)) {
			b.rtn();
			System.out.println(b);
			System.out.println(u);
		}else {
			System.out.println("반납오류");
		}
	}
		
	Book addBook() {
		System.out.print("구입한 책 이름:");
		String btitle = scan.nextLine().trim();
		Book b = new Book(btitle);
		bookMap.put(b.getID(), b);
		ArrayList<Book> blist = bkTitleMap.get(btitle);
		if(blist == null) {
			blist = new ArrayList<Book>();
			blist.add(b);
			bkTitleMap.put(btitle, blist); 
			//b.getTitle() 대신 btitle 써도 해시맵에서 같은지 검사 할 때 
			//equals로 하면 String은 주소가 아닌 내용으로 비교하기 때문에 문제 없다?
		}else {
			blist.add(b);
		}
		return b;
	}
	void delBook() { 
		System.out.print("폐기할 ");
		Book b = inbID();
		if(b==null) {
			System.out.println("해당책ID 없음");
			return;
		}
		//대출된 책을 삭제하려고 하면? >> 유저기록엔 남아있다 >> 삭제된 책 반납 불가능하다 >> 대출중인 책 삭제 막기
		if(b.getBrwer() != null) {
			System.out.println("해당책 대출중입니다.");
			return;
		}
		ArrayList<Book> blist = bkTitleMap.get(b.getTitle());
		//if(blist == null) bookmap에 있다면 bktitle에 제목 저장된다
		blist.remove(b);
		//blist가 비게되면 bktitle에서 키도 지워야 하나? >> 지우기. 리스트출력 할 때 공백 출련된다 
		if(blist.size() == 0) {
			bkTitleMap.remove(b.getTitle());
		}
		System.out.println(bookMap.remove(b.getID()));
		System.out.println("폐기되었습니다.");
	}
	
	void searchBookMap() {
		System.out.print("책 이름:");
		String btitle = scan.nextLine().trim();
		ArrayList<Book> blist = bkTitleMap.get(btitle);
		if(blist == null) {
			System.out.println("해당책 없음");
			return;
		}
		for(Book x:blist) {
			System.out.println(x);
		}
	}
	
	void searchUserMap() {
		User u = inuID();
		if(u == null) {
			System.out.println("해당고객 없음");
			return;
		}
		System.out.println(u);
	}
	
	void searchUserMapName() {
		System.out.print("고객 이름:");
		String name = scan.nextLine().trim();
		Iterator<User> iter = userMap.values().iterator();
		while(iter.hasNext()) {
			User u = iter.next();
			if(u.getName().equals(name)) {
				System.out.println(u);
//				return;
			}
		}
		System.out.println("해당고객 없음");
	}
	
	void userMapSort() {
		ArrayList<User> users = new ArrayList<User>(userMap.values());
		Collections.sort(users, Comparator.reverseOrder());
		for(User x:users) {
			System.out.println(x);
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
