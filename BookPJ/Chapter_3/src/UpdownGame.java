import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdownGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UpdownGame gm = new UpdownGame();
		do {
			System.out.println("0~99 숨겨진 수를 찾으세요.");
			gm.Round(sc);
		} while (gm.ctnue(sc));
	}

	static int inCnt = 1;

	boolean ctnue(Scanner sc) {
		System.out.print("Retry? (Y/N) : ");
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

	void Round(Scanner sc) {
		inCnt = 1;
		int crct = (int) (Math.random() * 100);
		int ans = -1;
		while (ans != crct) {
			ans = ansIn(sc);
			if (ans > crct)
				System.out.println("▽▽▽ Lower ▽▽▽");
			else if (ans < crct)
				System.out.println("▲▲▲ Hihger ▲▲▲");
			else
				System.out.println("*** CORRECT ***");
		}
	}

	static int ansIn(Scanner sc) {
		while (true) {
			try {
				System.out.print(inCnt + " : ");
				int ans = sc.nextInt();
				inCnt++;
				return ans;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("<<< 입력오류 >>>");
			}
		}
	}

}
