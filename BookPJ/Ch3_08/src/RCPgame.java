import java.util.Scanner;

public class RCPgame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String player, pc;
		System.out.println("<< 게임 시작 >>");
		while (true) {
			String chs[] = { "가위", "바위", "보" };
			pc = chs[(int) (Math.random() * 3)];
			System.out.print("가위 바위 보! >> ");
			player = sc.next();
			if (player.equals("그만")) {
				System.out.println("게임을 종료합니다....."); 
				break;
			}
			else if (player.equals(pc))
				System.out.println("사용자 : " + player + ", 컴퓨터 : " + pc + ", 비겼습니다.");
			else {
				if (player.equals("가위")) {
					if (pc.equals(chs[2]))
						System.out.println("사용자 : " + player + ", 컴퓨터 : " + pc + ", 사용자 승리.");
					else
						System.out.println("사용자 : " + player + ", 컴퓨터 : " + pc + ", 컴퓨터 승리");
				} else if (player.equals("바위")) {
					if (pc.equals(chs[0]))
						System.out.println("사용자 : " + player + ", 컴퓨터 : " + pc + ", 사용자 승리.");
					else
						System.out.println("사용자 : " + player + ", 컴퓨터 : " + pc + ", 컴퓨터 승리");
				} else if(player.equals("보")) {
					if (pc.equals(chs[1]))
						System.out.println("사용자 : "+player+", 컴퓨터 : "+pc+", 사용자 승리.");
					else
						System.out.println("사용자 : "+player+", 컴퓨터 : "+pc+", 컴퓨터 승리");
				}
				else
					System.out.println("잘못된 입력");
			}
		}
		sc.close();
	}

}
