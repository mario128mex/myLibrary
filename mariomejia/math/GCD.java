package mariomejia.math;

public class GCD {
	public static int naiveApproach(int a, int b) {
	    int m = Math.min(a, b), gcd = 0;
	    
	    for(int i = m; i > 0; --i)
	        if(a % i == 0 && b % i == 0) {
	            gcd = i;
	            break;
	        }
	    
	    return gcd;
	}
	
	public static int euclidApproach(int a, int b){
		if(b == 0)
			return a;
		else
			return euclidApproach(b, a % b);
	}
}
