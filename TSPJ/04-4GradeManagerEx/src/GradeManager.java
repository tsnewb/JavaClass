import java.util.Scanner;

public class GradeManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GradeManager gm = new GradeManager(7);
		Grade ob1 = new Grade("홍 길동", 65, 80);
		gm.st[0] = ob1;
		Grade ob2 = new Grade("김 철수", 40, 32);
		gm.st[1] = ob2;
		Grade ob3 = new Grade("파 송송", 94, 57);
		gm.st[2] = ob3;

		while (true) {
			String ans = gm.menuAns(sc);
			switch (ans) {
			case "ins":
				gm.insertSt(sc);
				break;
			case "shw":
				gm.showSt();
				break;
			case "chg":
				gm.changeSt(sc);
				break;
			case "del":
				gm.deleteSt(sc);
				break;
			case "cmp":
				gm.compareSt(sc);
				break;
			case "end": {
				System.out.println("종료합니다.");
				return;
			}
			default:
				System.out.println("잘못된 입력.");

			}
		}
	}

	Grade[] st;

	GradeManager(int size) {
		st = new Grade[size]; // 초기화 하지 않으면 null
	}

	GradeManager() {
		this(10);
	}

	String menuAns(Scanner in) {
		System.out.printf(
				"================\nins : 객체 추가\nshw : 배열 내역 출력\nchg : 객체 수정\ndel : 객체 삭제\ncmp : 객체 비교\nend : 종료\n명령을 입력하세요 >> ");
		String inp = in.next();
		in.nextLine();
		return inp;
	}

	Grade makeGrade(Scanner in) {
		System.out.print("이름 : ");
		String name = in.nextLine();
		System.out.print("수학 점수 : ");
		int math = in.nextInt();
		System.out.print("영어 점수 : ");
		int eng = in.nextInt();
		Grade tmp = new Grade(name, math, eng);
		return tmp;
	}

	void showSt() {
		System.out.println("==================");
		for (int i = 0; i < st.length; i++) {
			if (st[i] != null)
				st[i].showGrade();
		}
		System.out.println("==================");
	}

	void insertSt(Scanner in) {
		int idx = 0;
		for (; st[idx] != null; idx++) {
			if (idx == st.length - 1) {
				System.out.println("Arry-Full");
				return;
			}
		}
		st[idx] = makeGrade(in);
		// idx 안쓰고 만들어보기
//		for(Grade x:st) {
//			if(x==null) {
//				x = makeGrade(in);
//				return;
//			}
//		}
//		System.out.println("Arry-Full");
	}

	void changeSt(Scanner in) {
		System.out.print("이름 : ");
		String name = in.nextLine();
		for (int i = 0; i < st.length; i++) {
			if (st[i] == null)
				continue;
			else if (st[i].name.equals(name)) {
				st[i].showGrade();
				System.out.print("수학 점수 : ");
				st[i].math = in.nextInt();
				System.out.print("영어 점수 : ");
				st[i].eng = in.nextInt();
				st[i].showGrade();
				return;
			}
		}
		System.out.println("해당학생 없음");
	}

	void deleteSt(Scanner in) {
		System.out.print("학번 : ");
		int id = in.nextInt();
		id = isExit(id);
		if (id!=-1) {
			st[id].showGrade();
			System.out.println("삭제확인(Y/N)");
			char x = in.next().charAt(0);
			in.nextLine();
			if (x == 'y' || x == 'Y') {
				st[id] = null;
				System.out.println("삭제 완료");
			} else if(x == 'n' || x == 'N')
				System.out.println("삭제 취소");
			else 
				System.out.println("잘못된 입력");
			return;
		} else
			System.out.println("해당학생 없음");
	}

	Grade compareSt(Scanner in) {
		System.out.print("학번1 : ");
		int id1 = in.nextInt();
		id1 = isExit(id1);
		if (id1==-1) {
			System.out.println("해당학생 없음");
			return null;
		}
		System.out.print("학번2 : ");
		int id2 = in.nextInt();
		id2 = isExit(id2);
		if (id2==-1) {
			System.out.println("해당학생 없음");
			return null;
		}
		System.out.println("=== 평균이 큰 학생 ===");
		st[id1].compareAvg(st[id2]).showGrade();
		return st[id1].compareAvg(st[id2]);
	}

	int isExit(int id) {
		for (int i = 0; i < st.length; i++) {
			if(st[i]!=null && st[i].id == id)
				return i;
		}
		return -1;
	}
}

class Grade {
	static int serialNumber;
	int id; // 학번
	String name;
	int math;
	int eng;

	Grade(String name, int math, int eng) {
		this.name = name;
		this.math = math;
		this.eng = eng;
		id = ++serialNumber;
	}

	Grade() {
		this("xxx",-99, -99);
	}

	double average() {
		return (math + eng) / (double) 2;
	}

	void showGrade() {
		System.out.printf("id:%d, 이름:%s, math:%d, eng:%d, 평균:%.2f\n",id,name,math,eng,average());
	}

	Grade compareAvg(Grade x) {
		return average() > x.average() ? this : x;
	}
}