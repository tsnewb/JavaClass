package packBBB;
import packAAA.*;

class Student extends Person  {
	public void set() {
		//age = 30; 다른 패키지에 있는 super의 default 멤버
		name = "홍길동";
		height = 175;
		//weight = 99; super의 private멤버
		setWeight(99);
	}
}
