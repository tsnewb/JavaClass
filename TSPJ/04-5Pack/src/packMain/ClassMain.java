package packMain;
import packAAA.ClassAAA;

public class ClassMain {

	public static void main(String[] args) {
		ClassM ob1 = new ClassM();
		System.out.println(ob1.field1);
		//System.out.println(ob1.field2);
		ClassAAA ob2 = new ClassAAA(); //AAA생성자
		System.out.println(ob2.field1);
		//System.out.println(ob2.field2); //field2 멤버
		System.out.println(ob2.getField2());

	}

}
