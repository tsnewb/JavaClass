import java.util.Scanner;
public class IfelsEx {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("나이를 입력하시오 : ");
//		int age = sc.nextInt();
//		if(age>19 && age<30)
//			System.out.println("20대, "+age+"세");
//		else
//			System.out.println("20대가 아닙니다.");
//		sc.close();
//		=========================================

		//		<ppt p.9 / 실습 2>
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요(0~100) : ");
		int score = sc.nextInt();
		System.out.print("학년을 입력하세요(1~4) : ");
		int age = sc.nextInt();
		if(score>100||score<0||age>4||age<1) {
			System.out.print("입력 오류");
		}
		else {
			if(age>3) {
				if(score>=70)
					System.out.print("합격");
				else
					System.out.print("불합격");
			}
			else {
				if(score>=60)
					System.out.print("합격");
				else
					System.out.print("불합격");
			}
		} */
// =============================================
	/*	
		Scanner sc = new Scanner(System.in);
		System.out.print("월(1~12)을 입력하세요 : ");
		int mth = sc.nextInt();
		switch(mth) {
		case 1,2,12:
			System.out.print("겨울"); break;
		case 3,4,5:
			System.out.print("봄"); break;
		case 6,7,8:
			System.out.print("여름"); break;
		case 9,10,11:
			System.out.print("가을"); break;
		default:
			System.out.print("입력 오류");
		}
		sc.close();
	*/
//		===============================================
		/* 
//		 	< ppt19 실습1 >
		Scanner sc = new Scanner(System.in);
		System.out.print("무슨 커피 드릴까요? : ");
		String menu = sc.next();
		switch(menu) {
		case "에스프레소","카푸치노","카페라떼":
			System.out.printf("%s는 3500원입니다.",menu); break;
		case "아메리카노":
			System.out.printf("%s는 2000원입니다.",menu); break;
		default:
			System.out.print("메뉴에 없습니다.");
		}
		sc.close();
		*/
//		=================================================
		
		Scanner sc = new Scanner(System.in);
		System.out.print("무슨 커피 드릴까요? : ");
		int price = 0;
		int count = 0;
		String order = sc.next();
		if(order.equals("에스프레소")) {
			price = 2000;
			System.out.print("몇 잔 드릴까요? : ");
			count = sc.nextInt();
			if(count>6) {
				price *= count;
				price = price - price/10;
			}
			else if(count>0)
				price *= count;
			else {
				System.out.print("입력 오류");
				return;
			}
		}
		else if (order.equals("아메리카노")) {
			price = 2500;
			System.out.print("몇 잔 드릴까요? : ");
			count = sc.nextInt();
			if(count>4) {
				price *= count;
				price = (int)(price*0.9);
			}
			else if(count>0)
				price *= count;
			else {
				System.out.print("입력 오류");
				return;
			}
		}
		else {
			System.out.print("메뉴에 없습니다.");
			return;
		}
		System.out.print(price);
		sc.close();
	}

}
