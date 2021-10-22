class DivTestTryCatch
{
	public static void main(String[] args) 
	{	try{
		int a= Integer.parseInt(args[0]);
		int b= Integer.parseInt(args[1]);
		int result= a/b;
		System.out.println("결과: "+result);
	}catch(ArrayIndexOutOfBoundsException e){
		System.out.println("실행 시에 나누기할 두 수를 입력하세요");
	}
	}
}
