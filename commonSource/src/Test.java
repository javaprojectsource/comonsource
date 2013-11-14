import kr.co.javaproject.commonSource.FileUtils;
import kr.co.javaproject.commonSource.StringUtils;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int a = StringUtils.intValue("11a",6);
		String b = StringUtils.stringValue(null,"aafddsaf");
		System.out.println("a = " +a);
		System.out.println("b = " + b);
		System.out.println(FileUtils.copy("C:/test/11.txt","C:/test/112.txt"));
	}

}
