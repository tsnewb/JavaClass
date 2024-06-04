import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GradeManager gm = new GradeManager(20);
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

	GradeManager(int x) {
		st = new Grade[x];
	}

	GradeManager() {
		this(10);
	}

	String menuAns(Scanner sc) {
		System.out.printf(
				"===================\nins : 객체 추가\nshw : 배열 내역 출력\nchg : 객체 수정\ndel : 객체 삭제\ncmp : 객체 비교\nend : 종료\n명령을 입력하세요 >> ");
		while (true) {
			String in = sc.next();
			sc.nextLine();
			switch (in) {
			case "ins":
			case "shw":
			case "chg":
			case "del":
			case "cmp":
			case "end":
				return in;
			}
			System.out.println("잘못된 입력");
			System.out.print("재입력>> ");
		}
	}

	Grade makeGrade(Scanner sc) {
		Grade tmp = null;
		System.out.print("이름(공백시 자동입력): ");
		String name = sc.nextLine();
		if (name.equals(""))
			return tmp = new Grade();
		System.out.print("수학 : ");
		int math = intInput(sc);
		System.out.print("영어 : ");
		int eng = intInput(sc);
		System.out.print("과학 : ");
		int sci = intInput(sc);
		if (math * eng * sci == 0)
			return tmp = new Grade(name);
		return tmp = new Grade(name, math, eng, sci);
	}

	int intInput(Scanner sc) {
		while (true) {
			try {
				String scr = sc.nextLine();
				if (scr.equals(""))
					return 0;
				return Integer.parseInt(scr);
			} catch (NumberFormatException e) {
				System.out.println("정수를 입력하세요.");
				System.out.print(">> ");
			}
		}
	}
	
	void showSt() {
		System.out.println("==================");
		for (int i = 0; i < st.length; i++) {
			if (st[i] != null)
				st[i].showGrade();
		}
		System.out.println("==================");
	}

	void insertSt(Scanner sc) {
		for (int i = 0; i < st.length; i++) {
			if (st[i] == null) {
				st[i] = makeGrade(sc);
				return;
			}
		}
		System.out.println("Array-Full");
	}

	void changeSt(Scanner sc) {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		for (int i = 0; i < st.length; i++) {
			if (st[i] != null && st[i].name.equals(name)) {
				st[i].showGrade();
				System.out.print("수학 : ");
				st[i].math = intInput(sc);
				System.out.print("영어 : ");
				st[i].eng = intInput(sc);
				System.out.print("과학 : ");
				st[i].sci = intInput(sc);
				st[i].showGrade();
				return;
			}
		}
		System.out.println("해당학생 없음");
	}

	boolean yesORno(Scanner sc) {
		while (true) {
			char end = sc.next().charAt(0);
			if (end == 'y' || end == 'Y')
				return true;
			else if (end == 'n' || end == 'N')
				return false;
			else
				System.out.println("입력오류");
		}
	}

	void deleteSt(Scanner sc) {
		System.out.print("학번 : ");
		int id = intInput(sc);
		for (int i = 0; i < st.length; i++) {
			if (st[i] != null && st[i].id == id) {
				st[i].showGrade();
				System.out.print("삭제확인(Y/N) : ");
				if (yesORno(sc)) {
					st[i] = null;
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 취소");
				}
				return;
			}
		}
		System.out.println("해당학생 없음");
	}

	void compareSt(Scanner sc) {
		System.out.print("학번1 : ");
		int id1 = intInput(sc);
		Grade st1 = idFind(id1);
		if (st1 == null)
			return;
		System.out.print("학번2 : ");
		int id2 = intInput(sc);
		Grade st2 = idFind(id2);
		if (st2 == null)
			return;
		System.out.println("== 평균이 큰 학생 ==");
		st1.compareAvg(st2).showGrade();

	}

	Grade idFind(int id) {
		for (int i = 0; i < st.length; i++) {
			if (st[i] != null && st[i].id == id)
				return st[i];
		}
		System.out.println("해당학생 없음");
		return null;
	}

}

class Grade {
	static int serialNum = 0;
	int id;
	String name;
	int math;
	int eng;
	int sci;

	Grade(String name, int math, int eng, int sci) {
		id = ++serialNum;
		this.name = name;
		this.math = math;
		this.eng = eng;
		this.sci = sci;
	}

	Grade(String name) {
		this(name, (int) (Math.random() * 100 + 1), (int) (Math.random() * 100 + 1), (int) (Math.random() * 100 + 1));
	}

	Grade() {
		this(String.valueOf(serialNum + 1 + "번 학생"), (int) (Math.random() * 100 + 1), (int) (Math.random() * 100 + 1),
				(int) (Math.random() * 100 + 1));
	}

	double average() {
		return (math + eng + sci) / 3;
	}

	void showGrade() {
		System.out.printf("id[%d]>>이름:%s 수학:%d 영어:%d 과학:%d 평균:%.3f\n", id, name, math, eng, sci, average());
	}

	Grade compareAvg(Grade x) {
		return average() > x.average() ? this : x;
	}
}