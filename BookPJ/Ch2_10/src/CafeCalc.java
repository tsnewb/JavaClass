import java.util.Scanner;

public class CafeCalc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menu;
		int cnt;
		System.out.print("커피를 주문하세요 : ");
		menu = sc.next();
		if(menu.equals("에스프레소")) {
			cnt = sc.nextInt();
			if(cnt>9) {
				System.out.println((int)(2000*cnt*0.95)+"원입니다.");
			}
			System.out.println((2000*cnt+"원입니다."));
		}
		else if(menu.equals("아메리카노")) {
			cnt = sc.nextInt();
			System.out.println((2500*cnt+"원입니다."));
		}
		else if(menu.equals("카푸치노")) {
			cnt = sc.nextInt();
			System.out.println((3000*cnt+"원입니다."));
		}
		else if(menu.equals("카페라떼")) {
			cnt = sc.nextInt();
			System.out.println((3500*cnt+"원입니다."));
		}
		else {
			System.out.println("없는 메뉴 입니다.");
		}
	}

}
