package kr.co.javaproject.commonSource;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int a = StringUtils.intValue("11a",6);
		String b = StringUtils.stringValue(null,"aafddsaf");
		System.out.println("a = " +a);
		System.out.println("b = " + b);
		
	}

}