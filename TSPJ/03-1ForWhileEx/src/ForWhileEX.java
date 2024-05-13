import java.util.Scanner;
public class ForWhileEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/*
		int n =0,sum=0,count=0;
		System.out.println("정수를 입력하고 마지막에 -1을 입력하세요.");
		while(n!=-1) {
			sum+=n;
			count++;
			n = sc.nextInt();
		}
		// do-while 은 ';' 필요 : 한번은 실행 할 떄 사용
		count--;
		if(count==0) System.out.println("입력된유효 수가 없습니다.");
		else {
			System.out.println("정수의 개수는 "+count+"개");
			System.out.println("평균은 "+(double)sum/count);
		}
		sc.close();
		*/
//====================================================
		/* <실습 1>
		System.out.print("입력할 정수 :");
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i=n;i>0;i--) {
			System.out.print(i+" ");
		}
		System.out.println();
		n=1;
		int sum=0;
		while(n>0) {
			n = sc.nextInt();
			if(n%3==0)sum+=n;
		}
		System.out.println("합계 : "+sum);
		*/
//======================================================
		/* <실습 2>
		int x;
		for(int i=0;i<5;i++) {
			for(int t=0;t<4;t++) {
				x = (int)(Math.random()*9)+1;
				System.out.print(x+" ");
			}
			System.out.println();
		}
		*/
//=======================================================
		/* 
		// <실습 3>
		System.out.println("make1");
		make1();
		System.out.println("make2");
		make2();
		System.out.println("make3");
		make3();
		*/
//=====================================================
		// <실습 4>
		while(true) {
			System.out.print("정수 입력(-1 입력시 종료) : ");
			int n = sc.nextInt();
			if(n==-1) break;
			do {
				System.out.print(n%10+" ");
				n /= 10;
			}while(n > 0);
			System.out.println();
		}
		System.out.print("입력 종료");
		
	}
	public static void make1() {
		for(int i=0;i<5;i++) {
			for(int t=0;t<10;t++) {
				System.out.print(t);
			}
			System.out.println();
		}
	}
	public static void make2() {
		for(int i=9;i>=0;i--) {
			for(int t=0;t<=i;t++) {
				System.out.print(t);
			}
			System.out.println();
		}
	}
	public static void make3() {
		for(int i=0;i<10;i++) {
			for(int p=0;p<i;p++) {
				System.out.print(" ");
			}
			for(int t=i;t<=9;t++) {
				System.out.print(t);
			}
			System.out.println();
		}
	}

}
