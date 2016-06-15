public class PrimeNumberChecker{
	
	
	//Returns true if num is prime
	//Returns false if num is not Prime
	public static boolean isPrime(int num){		
		
		if (num<2)
			return false;
		else if (num==2)
			return true;
		else if (num%2==0)
			return false;
		
		for (int i = 3; i <= Math.sqrt(num);i = i+2){
			if (num%i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[]args){
		EasyReader console = new EasyReader();
		
		int repeat = 1;
		
	//	System.out.print("\nNumber  =");
		int number = -23; //console.readInt();
		
		if (isPrime(number)){
			System.out.print(number+" is prime.\n");
		}
		
		else
			System.out.print(number+" is not prime.\n");
	}
}