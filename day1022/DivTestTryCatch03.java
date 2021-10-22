class DivTestTryCatch03
{
	public static void main(String[] args) 
	{	try{
		int a= Integer.parseInt(args[0]);
		int b= Integer.parseInt(args[1]);
		int result= a/b;
		System.out.println("결과: "+result);
	}catch(ArithmeticException e){
		System.out.println("나누는 수는 0이 될 수 없습니다");
	}		
	catch(Exception e){
		System.out.println("두 번째 수가 0이 아닌 두 개의 숫자를 전달해주세요");
	}
}
}
