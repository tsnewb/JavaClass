package packScore;

public class ScoreExp extends Score {
    private static double addRate=1.5;   // 경력가산율
    private int career;      //경력년수                  
    public static final int many = 2;     //성적배열의 크기=응시과목개수
 
    public ScoreExp(String No, int year) {
    	super(No,many);
    	career = year;
    }
    public double getAvg() {
    	return super.getAvg()+career*addRate;
    }
    @Override
    public String toString() {
    	StringBuffer sb = new StringBuffer(super.toString());
    	sb.append("경력("+career+")");
    	return sb.toString();
    }
    public int getCarrer() {
    	return career;
    }
    public static double getAddRate() {
    	return addRate;
    }
}
