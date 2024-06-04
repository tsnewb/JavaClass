package packMain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import packScore.*;

class ApplyMng {

	HashMap<String, Score> apply;
	static Scanner in = new Scanner(System.in);

	ApplyMng() {
		apply = new HashMap<String, Score>(); //앞에서 선언 했기에 제너릭 생략가능
	}

	void menu() {
		System.out.println("-------------");
		System.out.println("1. 입력  2. 검색  3. 삭제  4. 출력");
		System.out.println("5. 경력5년이상출력  6. 설정조회  7. 정렬(평균기준)  9. 종료");
		System.out.print("선택 : ");
	}
//	int isThere(String x) 
//	컬렉션 메서드로 제공한다.
//	int emptyIdx() {
//	컬렉션는 저장 공간이 가변적이기 때문에 빈자리 찾을 필요없다.
	String keyInNo() {
		System.out.print("응시번호(일반N~,경력E~): ");
		String x = in.nextLine().trim();
		return x;
	}
	@Override
	public String toString() {//오버라이딩한 메서드의 반환형 바꿀수 없나?
		StringBuffer sb = new StringBuffer("==응시리스트==\n");
		int i= 0;
		for(Score x:apply.values()) {
			sb.append(++i+"--"+x.toString()).append("\n");
		}

		sb.append("총원 : "+apply.size()+"명");
		return sb.toString();
	}
	public String toString2() {
		StringBuffer sb = new StringBuffer("==응시리스트==\n");
		Set <String> ks = apply.keySet();
		Iterator<String> it = ks.iterator();
		int i =0;
		while(it.hasNext()) {
			sb.append(++i+"--"+apply.get(it.next()).toString()+"\n");
		}
		sb.append("총원 : "+apply.size()+"명");
		return sb.toString();
	}
	void insertApply() {
		String no = keyInNo();
		if(apply.containsKey(no)) {
			System.out.println("해당번호있음");
			return;
		}
		Score ep; //if문 안에 선언하면 지역변수가 된다
		if(no.charAt(0)=='N')
			ep = new Score(no);
		else if(no.charAt(0)=='E') {
			System.out.print("경력기간(년):");
			int year = in.nextInt();
			in.nextLine();
			ep = new ScoreExp(no, year);
		}
		else {
			System.out.println("구분오류");
			return;
		}
		System.out.print("점수를,(콤마)로 열거하시오.:");
		String txt = in.nextLine();
		if(ep.putScore(txt)) {
//			int idx = emptyIdx();
//			if(idx == -1)
//				System.out.println("공간 없음");
//			else
//				apply[idx]=ep;
			apply.put(no, ep);
			System.out.println(apply.get(no));
		}
	}
	void searchApply() {
		String no = keyInNo();
		if(!apply.containsKey(no)) {
			System.out.println("해당번호없음");
			return;
		}
		System.out.println(apply.get(no));
	}
	void deleteApply() {
		String no = keyInNo();
		if(!apply.containsKey(no)) {
			System.out.println("해당번호없음");
			return;
		}
		System.out.println(apply.remove(no)+"---삭제 완료");
//		키를 넣는 해시맵 리무브는 삭제되는 벨류를 반환한다
	}
	void show5ExpApply() {
		int cnt = 0;
		for(Score x : apply.values()) {
			// ================= 다운캐스팅 가능 확인하기
			//instanceof 는 null에 false를 반환
			//if(apply[i]!=null && apply[i] instanceof ScoreExp) {
			if(x instanceof ScoreExp) {
				if (((ScoreExp)x).getCarrer()>=5) {
					System.out.println(++cnt+"-- "+x);
				}
			}
		}
		System.out.println("총원: "+cnt+"명");
	}
	void showCntRate() {
		//Score.many
		//ScoreExp.many
		//퍼블릭 스태틱 변수
		System.out.println("======\n일반응시과목개수:"+Score.many+"\n경력응시과목개수:"+ScoreExp.many+"\n경력1년당가산율:"+ScoreExp.getAddRate());
	}
	
	void mng() {
		while (true) {
		
			menu();
			int choice = in.nextInt();
			in.nextLine();
			if (choice == 9)
				break;
			switch (choice) {
		        case 1 : insertApply( );    break;		   
		        case 2 : searchApply( );    break;
		        case 3 : deleteApply( );    break;
		        case 4 : System.out.println(this);   break;  
		        case 5 : show5ExpApply( );    break;  
		        case 6 : showCntRate( );     break;
		        case 7 : break;   //정렬은 다음에 하자  
                case 9 : break; 
			}
		}
	}
//	Object k = new Object();c
//	Integer i = new Integer(5);
//	벡터의 remove는 int를 넣으면 idx로 찾아서 삭제
//	객체를 넣으면 객체의 class에 맞게 equals매서드를 통해 일치하는 객체를 찾아서 삭제
	

	public static void main(String[] args) {
		Score s0 = new Score("N001");
		s0.putScore("5,6,8");
		Score s1 = new ScoreExp("E123", 6);
		s1.putScore("6,7");
		Score s2 = new Score("N011");
		s2.putScore("6,6,9");
		Score s3 = new ScoreExp("E001", 2);
		s3.putScore("5,  9"); //trim으로 공백제거한다
		Score s4 = new ScoreExp("E107", 5);
		s4.putScore("5,  7");

		ApplyMng am = new ApplyMng();
		am.apply.put(s0.getNo(), s0);
		am.apply.put(s1.getNo(), s1);
		am.apply.put(s2.getNo(), s2);
		am.apply.put(s3.getNo(), s3);
		am.apply.put(s4.getNo(), s4);
		am.mng();
		
//		Iterator<Score> it = am.apply.iterator();
//		while(it.hasNext()) {
		
//			System.out.println(it.next()); 
//		}
//		System.out.println("==============");
//		for(Score x: am.apply) {
//			System.out.println(x);
//		}
		
//		for each 구문으로 컬렉션을 순회하고 요소를 삭제 후 다시 순회하면 에러가 발생한다
//		하지만 Iterator의 next와 remove를 사용하여 순회와 삭제를 하면 순회 중 삭제하고
//		다시 순회하여도 에러가 발생하지 않는다.
//		이는 컬렉션은 요소의 추가, 삭제등이 일어나면 컬렉셔 내부 구조가 변경되기에
//		for each는 컬렉션 자체에 접근해서 순회하는 것이기에 순회 도중 컬렉션이 수정되면 순회 하는것을 막는다
//		하지만 Iterator는 컬렉션의 요소들의 래퍼런스를 가지고 있고 이를 통해 요소에 접근하기 때문에
//		삭제 후 next 매서드로 다시 순회하여도 오류가 발생하지 않는다
//		(iterator로 삭제 후 for each로 순회 가능 할까??)
//		Iterator도 원본 컬렉션이 수정되면 다시 만들어야 한다
	}

}