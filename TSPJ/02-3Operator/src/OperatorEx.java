import java.util.Scanner;

public class OperatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner sc = new Scanner(System.in);
		int time = 1;
		while(time!=0) {
		System.out.print("정수 입력 : ");
		time = sc.nextInt();
		int second = time % 60;
		int minute = (time / 60)%60;
		int hour = time / 3600;
		
		System.out.printf("%d초는 %d시간, %d분, %d초입니다.\n",time,hour,minute,second);
		}
		sc.close();
		 */
		Scanner sc = new Scanner(System.in);
		System.out.printf("금액을 입력하세요 : ");
		int money = sc.nextInt();
		int oman = money / 50000;
		money %= 50000;
		int man = money / 10000;
		money %= 10000;
		int ochun = money / 5000;
		money %= 5000;
		int chun = money / 1000;
		money %= 1000;
		System.out.printf("오만원 :%5d장\n",oman);
		System.out.printf("만원  :%5d장\n",man);
		System.out.printf("오천원 :%5d장\n",ochun);
		System.out.printf("천원  :%5d장\n",chun);
		System.out.printf("나머지 :%5d원",money);
		sc.close();
	}

}
