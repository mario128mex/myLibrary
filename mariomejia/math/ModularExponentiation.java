package mariomejia.math;

public class ModularExponentiation {
	public static long naiveApproach(long a, long b, long c){
		long answer = 1;
		
		for(int i=1; i <= b; i++){
			answer *= a;
			answer %= c;
		}
		
		return answer;
	}
	
	public static long binaryApproach(long a, long b, long c){
		long answer = 1;
		
		while(b != 0){
			if(b % 2 == 1)
				answer = (answer * a) % c;
			
			a = (a * a) % c;
			b >>= 1;
		}
		
		return answer;
	}
}
