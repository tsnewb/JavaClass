package AAA;

import java.util.Vector;

class ObclassTest {

	public static void main(String[] args) {
		Object ob = new Object();
		System.out.println("ob: "+ob);
		System.out.println("ob.tostring: "+ob.toString());
		System.out.println("hashcode: "+ob.hashCode());
		System.out.println("getclass: "+ob.getClass());
		System.out.println("Class.getname: "+ob.getClass().getName());
		
		Integer a = Integer.valueOf(10);
		Integer b = Integer.valueOf(10);
		if(a==b)
		{
			System.out.println("태수바보");
		}
		Vector<Integer> v = new Vector<Integer>();
		v.add(6);
		v.add(9);
		v.add(3);
		v.add(7);
		v.add(4);
		Integer[] Intarr = (Integer[]) v.toArray();
		//toAttay는 Object객체 배열을 반환한다.
		//Object로 업캐스팅 되었다가 Integer로 다운캐스팅 된다
		
		//int n = v.get(0);
		System.out.println(v.remove(3));
		System.out.println(Intarr);
	}

}
