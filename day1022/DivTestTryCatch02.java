class DivTestTryCatch02
{
	public static void main(String[] args) 
	{	try{
		int a= Integer.parseInt(args[0]);
		int b= Integer.parseInt(args[1]);
		int result= a/b;
		System.out.println("결과: "+result);
	}catch(ArrayIndexOutOfBoundsException e){
		System.out.println("실행 시에 나누기할 두 수를 입력하세요");
	}catch(ArithmeticException e){
		System.out.println("나누는 수는 0이 될 수 없습니다");
	}catch(NumberFormatException e){
		System.out.println("문자는 안됩니다.숫자를 입력해주세요");
	}
	}
}
