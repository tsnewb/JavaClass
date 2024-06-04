import java.util.InputMismatchException;
import java.util.Scanner;

public class RCPgame {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean cnt = true;
		int pnum = 0;
		while (cnt) {
			try {
				System.out.print("플레이어의 수를 입력 하세요(음수=종료) : ");
				pnum = sc.nextInt();
				sc.nextLine();
				if (pnum <= 0) {
					System.out.println(">>> 게임 종료 <<<");
					return;
				}
				cnt = false;
			} catch (InputMismatchException e) {
				System.out.println("!!! Errer : 정수를 입력 하세요. !!!");
				sc.nextLine();

			}
		}

		RCPgame con = new RCPgame(pnum);
		System.out.println("<<< Player 명단 >>>");
		RCPgame.listPlayer(con.PL);
		Player Winner = null;
		Winner = con.round(con.PL);
		System.out.println();
		System.out.println("<<<<<<<<<<<< 우승자 >>>>>>>>>>>>");
		System.out.println(Winner.plid + "번 " + Winner.name);
	}

	Player PL[];
	int pnum;

	RCPgame(int pnum) {
		this.pnum = pnum;
		PL = new Player[pnum];
		char auto;
		while (true) {
			System.out.print("자동입력 Y / N : ");
			auto = sc.nextLine().charAt(0);
			if (auto == 'Y' || auto == 'y') {
				for (int i = 0; i < pnum; i++) {
					PL[i] = new Player();
				}
				break;
			} else if (auto == 'N' || auto == 'n') {
				for (int i = 0; i < pnum; i++) {
					PL[i] = makePlayer(i + 1);
				}
				break;
			}else {
				System.out.println("입력 오류");
			}
				
		}

	}

	Player makePlayer(int num) {
		System.out.println("<< " + num + "번 Player 입력 >>");
		String name = null;
		do {
			System.out.print("Player 이름 입력(5자 이하) : ");
			name = sc.nextLine();
		} while (name.length() > 5);
		String chs = null;
		do {
			System.out.print("가위 바위 보 (공백=랜덤) : ");
			chs = sc.nextLine();
		} while (!isChs(chs));
		Player tmp;
		if (name.equals("") || chs.equals("")) {
			if (!name.equals(""))
				tmp = new Player(name);
			else
				tmp = new Player();
		} else
			tmp = new Player(name, chs);
		return tmp;
	}

	boolean isChs(String chs) {
		switch (chs) {
		case "가위":
		case "바위":
		case "보":
		case "":
			return true;
		default:
			System.out.println("입력이 올바르지 않습니다.");
			return false;
		}
	}

	int isWin(String p1, String p2) {
		switch (p1) {
		case "가위":
			if (p2.equals("가위"))
				return 0;
			else if (p2.equals("바위"))
				return -1;
			else
				return 1;
		case "바위":
			if (p2.equals("바위"))
				return 0;
			else if (p2.equals("보"))
				return -1;
			else
				return 1;
		case "보":
			if (p2.equals("보"))
				return 0;
			else if (p2.equals("가위"))
				return -1;
			else
				return 1;
		default:
			System.out.println("승부 판단 오류");
			return 0;
		}
	}

	Player whoWin(Player p1, Player p2) {
		while (true) {
			int tmp = isWin(p1.choise, p2.choise);
			if (tmp == 1) {
				return p1;
			} else if (tmp == -1) {
				return p2;
			} else {
				p1.choise = Player.random();
				p2.choise = Player.random();
			}
		}
	}

	Player round(Player[] pl) {
		int pnum = pl.length;
		Player king = null;
		if (pnum == 1) { // 플레이어가 1명이 되면 재귀 종료
			return pl[0];
		}
		Player winner[] = new Player[pnum - pnum / 2];
		int idx = -1;
		for (int i = 0; i < pnum; i += 2) {
			if (i == pnum - 1) {
				winner[++idx] = pl[i];
				winner[idx].choise = Player.random();
			}
			else {
				winner[++idx] = whoWin(pl[i], pl[i + 1]);
				winner[idx].choise = Player.random();
			}
		}
		if (idx == winner.length - 1) {
			System.out.println("<<< Round Winner >>>");
			RCPgame.listPlayer(winner);
			king = round(winner);
		}
		return king;
	}

	static void listPlayer(Player[] PL) {
		for (int i = 0; i < PL.length; i++) {
			System.out.println(PL[i].plid + "번 " + PL[i].name + " : " + PL[i].choise);
		}
	}

}

class Player {
	String name;
	String choise;
	static int id = 0;
	int plid;

	Player(String name, String ch) {
		this.name = name;
		this.choise = ch;
		plid = ++id;
	}

	Player() {
		this(String.valueOf("player" + (id + 1)), random());
	}

	Player(String name) {
		this(name, random());
	}

	static String random() {
		switch ((int) (Math.random() * 3) + 1) {
		case 1:
			return "가위";
		case 2:
			return "바위";
		case 3:
			return "보";
		default:
			return "";
		}
	}
}
