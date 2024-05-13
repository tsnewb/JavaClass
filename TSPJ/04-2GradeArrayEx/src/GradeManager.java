import java.util.Scanner;

import javax.xml.transform.stax.StAXSource;

public class GradeManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GradeManager gm = new GradeManager();
		
		gm.st[0] = new Grade("홍길동", 34, 46);
		gm.st[1] = new Grade("김김김", 94, 99);
		gm.st[2] = new Grade("이이이", 100, 44);
		gm.lastidx += 3;
		
		Grade maxOb= gm.st[0].compareAvg(gm.st[1]);
// **예상문제** 반복문으로 제일 큰 객체 찾기 >> 매소드로 구현
		System.out.print("평균이 큰 객체 = ");
		maxOb.showGrade1Line();
		System.out.print("평균이 가장 큰 객체 = ");
		gm.findMaxOb().showGrade1Line();
		
		while(true) {
			int ans = gm.menuAns(sc);
			//if(ans==1) gm.st[gm.lastidx++]=gm.makeGrade(sc);
			//else if(ans==2) gm.showStArr();
			//else if(ans==0) return;
			//else System.out.println("1,2,3,4,0 중에 입력하세요.");
			switch (ans) {
			case 1:
				gm.st[gm.lastidx++]=gm.makeGrade(sc);
				break;
			case 2:
				gm.showStArr();
				break;
			case 3:
				gm.changeStElement(sc);
				break;
			case 4:
				gm.deleteStElement(sc);
				break;
			case 0:
				System.out.println("종료.");
				return;
			default:
				System.out.println("1,2,0 중에 입력하세요.");
			}
		}
	}
	
	Grade[] st;
	int lastidx;
	
	public GradeManager(int x) {
		st = new Grade[x]; // 필드에 정의된 st, lastidx에 접근한다
		lastidx = 0;
		/*
		 * Grade[] st = new Grade[x]; int lastidx = 0;
		 * 필드가 아닌 (생성자 함수의 안) 지역 변수에 저장되어 사라진다
		 */
	}
	public GradeManager() {
		this(10);
	}
	int menuAns(Scanner in) {
		System.out.printf("1.객체추가\n2.배열출력\n3.객체수정\n4.객체삭제\n0.종료\n1,2,3,4,0 중에 선택하세요. : ");
		int ans = in.nextInt();
		in.nextLine();
		return ans;
	}
	Grade makeGrade(Scanner in) {
		System.out.print("이름 : ");
		String name = in.nextLine();
		System.out.print("수학점수 : ");
		int math = in.nextInt();
		System.out.print("영어점수 : ");
		int eng = in.nextInt();
		Grade tmp = new Grade(name, math, eng);
		in.nextLine();
		return tmp;
	}
	void showStArr() {
		System.out.println("=======================");
		for(int i=0;i<lastidx;i++) {
			if(st[i]==null) {
				System.out.println("자료없음");
				continue;
			}
			st[i].showGrade1Line();if(st[i]==null) {
				System.out.println("자료없음");
				continue;
			}
			st[i].showGrade1Line();
		}
//		for(Grade x:st) {
//			if(x==null) {
//				System.out.println("자료없음");
//				continue;
//			}
//			x.showGrade1Line();
//		}
		System.out.println("=======================");
	}
	void changeStElement(Scanner in) {
		System.out.print("수정할 번호 : ");
		int n = in.nextInt();
		in.nextLine();
		if(n<lastidx && n>=0) {
			System.out.println("수정할 내용");
			st[n].showGrade();
			System.out.print("이름 : ");
			String name = in.nextLine();
			System.out.print("수학점수 : ");
			int math = in.nextInt();
			System.out.print("영어점수 : ");
			int eng = in.nextInt();
			st[n].name = name;
			st[n].math = math;
			st[n].eng = eng;
			in.nextLine();
			System.out.println("수정된 내용");
			st[n].showGrade();
		}
		else {
			System.out.println("해당 번호 자료 없음");
			return;
		}
	}
	void deleteStElement(Scanner in) {
		System.out.print("삭제할 번호 : ");
		int n = in.nextInt();
		in.nextLine();
		if(n<lastidx && n>=0) {
			System.out.println("삭제할 내용");
			st[n].showGrade();
			System.out.println("삭제(Y/N) : ");
			char yn = in.next().charAt(0);
			in.nextLine();
			if(yn == 'Y' || yn == 'y')
				st[n] = null;
		}
		else {
			System.out.println("해당 번호 자료 없음");
			return;
		}
	}
	Grade findMaxOb() {
		Grade max = st[0];
		for(int i=0;i<lastidx;i++) {
			max = max.compareAvg(st[i]);
		}
		return max;
	}
}
class Grade{
	String name;
	int math;
	int eng;
	
	public Grade() {
		/*
		 * name = "입력필요"; math = -99; eng = -99;
		 */
		this("입력필요",-99,-99); 
		//this()는 생성자의 첫줄에 적는다 
	}
	public Grade(String name,int math,int eng) {
		// 매개변수와 멤버 변수의 이름을 같게하고 구분하기 위해
		this.name = name;
		this.math = math;
		this.eng = eng;
	}
	
	double average() {
		return (double)(math+eng)/2;
	}
	Grade compareAvg(Grade x) {
		if(this.average()>=x.average()) return this;
		else return x;
		/*
		 * this => 나의 객체 
		 * this. => 나의 필드의 
		 * this() => 생성자
		 */
	}
	void showGrade() {
		System.out.println("==========");
		System.out.println("Name : "+name);
		System.out.println("Math : "+math+", English : "+eng);
		System.out.println("Average : "+average());
		System.out.println("==========");
		
	}
	void showGrade1Line() {
		System.out.print("Name : "+name);
		System.out.print(", Math : "+math+", English : "+eng);
		System.out.println(", Average : "+average());
		
	}
}
