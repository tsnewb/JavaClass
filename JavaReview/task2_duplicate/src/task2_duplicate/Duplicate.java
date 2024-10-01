package task2_duplicate;
import java.lang.Math;
import java.util.ArrayList;


public class Duplicate {
	int[] arr = new int[10];
	boolean result = false;
	int temp;
	ArrayList<Integer> LI = new ArrayList<>();
	
	public static void main(String[] args) {
		Duplicate dp = new Duplicate();
		for(int i=0;i<5;i++) {
			dp.CheckDuplicate();
			dp.ShowResult();
			dp.Init();
		}
	}
	public Duplicate() {
		System.out.println("20233102 김태수");
		this.Init();
	}
	void Init() {
		for(int i=0;i<10;i++) {
			this.arr[i] = (int) (Math.random()*30);
		}
	}
	void CheckDuplicate() {
		LI.clear();
		result=false;
		for(int i=0;i<9;i++) {
			for(int t =i+1;t<10;t++) {
				if(arr[i]==arr[t]) {
					if(!LI.contains(arr[t]))
						LI.add(arr[i]);
					result = true;
					break;
				}
			}
		}
	}
	void ShowResult() {
		for (int i=0;i<9;i++) {
			System.out.print(arr[i]+":");
		}
		System.out.print(arr[9]+" -> ");
		if(result == true) {
			System.out.println("중복된 숫자="+LI);
		}
		else {
			System.out.println("중복 없음");
		}
	}
}
