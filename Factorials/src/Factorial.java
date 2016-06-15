
public class Factorial {

	public static int factorialSolver(int num){
		
		if (num<0){
			System.out.print("POSITIVES ONLY");
			return 0;
		}
		
		for (int i = num; i>0; i--){
			int ans = 1;
			ans = ans*i;
			return ans;
		}
		return 0;
	}
}
