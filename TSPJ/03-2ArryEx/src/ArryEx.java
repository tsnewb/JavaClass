import java.util.Scanner;
public class ArryEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int arr[];
//		arr = new int[5];
//		
//		String str = new String("hello");
//		
//		int k =300;
//		System.out.println(arr.length);  //length 변수
//		System.out.println(str.length()); //length 함수
//		//System.out.println();
		
		
//		System.out.print("배열 크기 : ");
//		int size = sc.nextInt();
//		int arr[]=new int[size];
//		int sum=0;
//		System.out.println(size+"개의 정수를 입력하세요");
//		for(int i=0;i<size;i++) {
//			arr[i]=sc.nextInt();
//			sum+=arr[i];
//		}
//		double avg = (double)sum/arr.length;
//		System.out.printf("평균은 %.2f\n",avg);
//		
//		for(int x : arr) 
//			System.out.printf("%d ",x);
//		System.out.println();
		
// String 생성 방법 여러가지
//		String f[]= {"dfasd","fds","fjhdg","fa"};
//		String st1 = "dfasd";
//		String st2 = new String("dfsafg");
//		String st3 = String.valueOf("num :"+i);
//		
// **new 로 생성되는 배열은 초기값 설정 안하면 0(null)으로 초기화**
		
		int arr[][]=new int[3][4];
		for(int i=0;i<3;i++) {
			for(int t=0;t<4;t++) {
				arr[i][t]=(int)(Math.random()*10);
			}
		}
		int sum=0;
		int tmpsum=0;
		int i=0;
		for(int []x:arr) {
			tmpsum =0;
			for(int y:x) {
				tmpsum+=y;
			}
			sum+=tmpsum;
			System.out.printf("%d행 합계 : %d\n",i++,tmpsum);
		}
		System.out.printf("총 합계 : %d\n",sum);;
	}

}
