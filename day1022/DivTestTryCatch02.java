class DivTestTryCatch02
{
	public static void main(String[] args) 
	{	try{
		int a= Integer.parseInt(args[0]);
		int b= Integer.parseInt(args[1]);
		int result= a/b;
		System.out.println("���: "+result);
	}catch(ArrayIndexOutOfBoundsException e){
		System.out.println("���� �ÿ� �������� �� ���� �Է��ϼ���");
	}catch(ArithmeticException e){
		System.out.println("������ ���� 0�� �� �� �����ϴ�");
	}catch(NumberFormatException e){
		System.out.println("���ڴ� �ȵ˴ϴ�.���ڸ� �Է����ּ���");
	}
	}
}