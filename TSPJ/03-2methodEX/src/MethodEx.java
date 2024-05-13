import java.util.Scanner;
public class MethodEx {
// main 함수는 문법 적으로 class 안에 작성돼야 한다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String level = null;
		do {
			System.out.print("근내지방도 : ");
			int fat = sc.nextInt();		
			level = makelevel(fat);
			System.out.println("등급 : "+level);
			//if(level.equals("???")) break;
		}while(!level.equals("???"));
	

		int arr[][] = randomArr();
		printArr(arr);
		System.out.printf("총 합계 : %d\n",makeSum(arr));
		sc.close();
	}
	static int[][] randomArr() {
		int tmp[][]=new int[3][4];
		for(int i=0;i<3;i++) {
			for(int t=0;t<4;t++) {
				tmp[i][t]=(int)(Math.random()*10);
			}
		}
		return tmp;
	}
	static void printArr(int[][] tmp) {
		for(int []x:tmp) {
			for(int y:x) {
				System.out.print(y+"\t");
			}
			System.out.println();
		}
	}
	static int makeSum(int[][] tmp) {
		int sum=0;
		int tmpsum=0;
		int i=0;
		for(int []x:tmp) {
			tmpsum =0;
			for(int y:x) {
				tmpsum+=y;
			}
			sum+=tmpsum;
			System.out.printf("%d행 합계 : %d\n",i++,tmpsum);
		}
		return sum;
	}
	static String makelevel(int n) {
		switch(n){
		case 8:
		case 7:
			return "1++";
		case 6:
			return "1+";
		case 4,5:
			return "1";
		case 2,3:
			return "2";
		case 1:
			return "3";
		default : return "???";
		}
	}
}