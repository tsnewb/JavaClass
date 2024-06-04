package packMain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import packScore.*;

class ApplyMng {

	Score apply[];
	static Scanner in = new Scanner(System.in);
	// static >> 모든 appltmng 객체가 공유한다

	ApplyMng(int size) {
		apply = new Score[size];
	}

	void menu() {
		System.out.println("-------------");
		System.out.println("1. 입력  2. 검색  3. 삭제  4. 출력");
		System.out.println("5. 경력5년이상출력  6. 설정조회  7. 정렬(평균기준)  9. 종료");
		System.out.print("선택 : ");
	}
	int isThere(String x) {
		for(int i=0;i<apply.length;i++) {
			if(apply[i]==null)
				continue;
			if(apply[i].getNo().equals(x))
				return i;
		}
		return -1;
	}
	int emptyIdx() {
		for(int i=0;i<apply.length;i++) {
			if(apply[i]==null)
				return i;
		}
		System.out.println("공간없음");
		return -1;
	}
	String keyInNo() {
		System.out.print("응시번호(일반N~,경력E~): ");
		String x = in.nextLine().trim();
		return x;
	}
	@Override
	public String toString() {//오버라이딩한 메서드의 반환형 바꿀수 없나?
		StringBuffer sb = new StringBuffer("==응시리스트==\n");
		int cnt=0;
		for(int i=0;i<apply.length;i++) {
			if(apply[i]==null)
				continue;
			sb.append(i+"--"+apply[i].toString()).append("\n");
			cnt++;
		}
		sb.append("총원 : "+cnt+"명");
		return sb.toString();
	}
	void insertApply() {
		String no = keyInNo();
		if(isThere(no)>-1) {
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
			int idx = emptyIdx();
			if(idx == -1)
				System.out.println("공간 없음");
			else
				apply[idx]=ep;
		}
	}
	void searchApply() {
		String no = keyInNo();
		int idx = isThere(no);
		if(idx==-1) {
			System.out.println("해당번호없음");
			return;
		}
		System.out.println(apply[idx]);
		//aplly가 score 배열이어도 score안에도 toString 매서드가 있기때문에
		//ScoreExp가 오버라이딩한 메서드를 읽을 수 있다.
	}
	void deleteApply() {
		String no = keyInNo();
		int idx = isThere(no);
		if(idx==-1) {
			System.out.println("해당번호없음");
			return;
		}
		System.out.print(apply[idx]);
		apply[idx] = null;
		System.out.println("---삭제 완료");
	}
	void show5ExpApply() {
		ScoreExp exp; //업캐스팅용 변수
		ApplyMng am = new ApplyMng(apply.length);
		int cnt = 0;
		for(int i =0;i<apply.length;i++) {
			// ================= 다운캐스팅 가능 확인하기
			//instanceof 는 null에 false를 반환
			//if(apply[i]!=null && apply[i] instanceof ScoreExp) {
			if(apply[i] instanceof ScoreExp) {
				if (((ScoreExp)apply[i]).getCarrer()>4) {
					System.out.println(i+"-- "+apply[i]);
					cnt++;
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
		        case 7 : Arrays.sort(apply,Comparator.nullsLast(Comparator.reverseOrder()));
		        // null을 뒤로 밀고 내림차순(리버스)으로 한다
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
		System.out.println(s0); // toString 호출된다
		Score s1 = new ScoreExp("E123", 6);
		s1.putScore("6,7");
		System.out.println(s1);
		Score s2 = new Score("N011");
		s2.putScore("6,6,9");
		Score s3 = new ScoreExp("E001", 2);
		s3.putScore("5,  9"); //trim으로 공백제거한다
		Score s4 = new ScoreExp("E107", 5);
		s4.putScore("5,  7");

		ApplyMng am = new ApplyMng(20);
		am.apply[0] = s0;
		am.apply[9] = s1;
		am.apply[2] = s2;
		am.apply[3] = s3;
		am.apply[15] = s4;
		am.mng();
	}

}