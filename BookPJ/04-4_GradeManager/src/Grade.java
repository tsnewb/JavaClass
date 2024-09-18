
public class Grade {
	public static void main(String[] args) {
		test1 ts = new test2(10);
		System.out.println(ts.n);
	}
}
class test1{
	int n = 0;
	test1(){
		n++;
	}
}
class test2 extends test1{
	int n = 0;
	test2(int n){
		this.n =n;
	}
}