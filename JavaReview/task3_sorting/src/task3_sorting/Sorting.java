package task3_sorting;
import java.lang.Math;

public class Sorting {
	int[] arr= new int[10];
	public static void main(String[] args) {
		Sorting st = new Sorting();
		for(int i=0;i<5;i++) {
			st.CustomSorting();
			st.ShowResult();
			st.Init();
		}
	}
	public Sorting() {
		System.out.println("20233102 김태수");
		Init();
	}
	void Init() {
		for(int i=0;i<10;i++) {
			this.arr[i] = (int) (Math.random()*50);
		}
	}
	void CustomSorting() {
		int temp;
		for(int i=9;i>=0;i--) {
			for(int t=0;t<i;t++) {
				if(arr[t]>arr[t+1]) {
					temp = arr[t+1];
					arr[t+1]=arr[t];
					arr[t]=temp;
				}
			}
		}
	}
	void ShowResult() {
		System.out.print("Result = ");
		for (int i=0;i<9;i++) {
			System.out.print(arr[i]+":");
		}
		System.out.println(arr[9]);
	}

}
