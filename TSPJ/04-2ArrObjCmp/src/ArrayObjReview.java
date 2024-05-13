import java.util.Scanner;

public class ArrayObjReview {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrObj ob1 = new ArrObj(1, 5);
		ob1.showMe();
		ArrObj ob2 = new ArrObj(2, 10);
		ob2.showMe();
		ArrObj high = ob1.whatHigh(ob2);
		if(high != null) {
			System.out.println("<<< The Winner!!! >>>");
			high.showMe();
		}
	}

}
class ArrObj{
	int no;
	double arrA[];
	
	ArrObj (int no, int size){
		this.no = no;
		arrA = new double[size];
		for(int i=0;i<size;i++) {
			arrA[i]=(int)(Math.random()*1000)/(double)1000;
		}
	}
	void showMe() {
		System.out.print(no+" : ");
		for(double x:arrA) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
	ArrObj whatHigh(ArrObj ob) {
		int win=0, lose=0;
		int shortleng = arrA.length<ob.arrA.length ? arrA.length : ob.arrA.length;
		for(int i=0;i<shortleng;i++) {
			if(arrA[i]>ob.arrA[i])
				win++;
			else if(arrA[i]<ob.arrA[i])
				lose++;
		}
		if(win>lose)
			return this;
		else if(win<lose)
			return ob;
		else {
			System.out.println("<< Derw >>");
			return null;
		}
	}
}