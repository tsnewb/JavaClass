//
//public class ArrayObjProc {
//
//	public static void main(String[] args) {
//		ArrObj ob1 = new ArrObj(1, 5);
//		ob1.showMe();
//		ArrObj ob2 = new ArrObj(2, 7);
//		ob2.showMe();
//		ArrObj high = ob1.whatHigh(ob2);
//		
//		
//		ArrObj obR[]= new ArrObj[10];
//		for(int i=0;i<10;i++) {
//			obR[i] = new ArrObj(i+1, (int)((Math.random()*0.7+0.3)*10));
//			obR[i].showMe();
//		}
//		high = obR[0];
//		for(ArrObj x:obR) {
//			high = high.whatHigh(x);
//			if(high!=null) {
//				System.out.print("값이 큰 배열 : ");
//				high.showMe();
//			}
//		}
//		
//	}
//
//}
//class ArrObj{
//	int No;
//	double arrA[];
//	
//	ArrObj(int n, int size){
//		No = n;
//		arrA = new double[size];
//		for(int i=0;i<size;i++) {
//			arrA[i] = Math.random();
//		}
//	}
//	
//	void showMe() {
//		System.out.print(No+" :");
//		for(double x:arrA) {
//			System.out.printf(" %.3f",x);
//		}
//		System.out.println();
//	}
//	ArrObj whatHigh(ArrObj x) {
//		int cnt = 0;
//		int leng = (this.arrA.length <= x.arrA.length) ? this.arrA.length : x.arrA.length;
//		for(int i = 0 ;i<leng;i++) {
//			if(this.arrA[i]>x.arrA[i]) cnt++;
//		}
//		if(cnt*2>leng) return this;
//		else if(cnt*2<leng) return x;
//		else {
//			System.out.println("비김");
//			//return null;
//			return (this.arrA.length >= x.arrA.length) ? this : x;
//		}
//	}
//}