package packScore;

public interface InterScore {
	//public static final int many = 3;
	int many = 3; //public static final 생략가능
	boolean putScore(String txt); //public abstract 생략됨
	double getAvg();
	String getNo();
	@Override
	String toString();
}
