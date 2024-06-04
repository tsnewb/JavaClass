package packScore;

public class ScoreExp extends Score{
    private static double addRate=1.5;   // 경력가산율
    private int career;      //경력년수                  
    public static final int many = 2;     //성적배열의 크기=응시과목개수
    
    public ScoreExp(String No,int career){
    	//super()없다
    	super(No,many); //super의 sc배열이 private여도 super()로 생성가능 
    	this.career = career;
    }
    @Override
    public double getAvg() {
    	return super.getAvg()+career*addRate;
    }
    @Override
    public String toString() {
    	StringBuffer sb = new StringBuffer(super.toString());
    	sb.append(" 경력("+career+"년)");
    	return sb.toString();
    }
    public int getCarrer() {
    	return career;
    }
    public static double getAddRate() {
    	return addRate;
    }
}