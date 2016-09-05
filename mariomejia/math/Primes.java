package mariomejia.math;
import java.util.*;

public class Primes {
	public static boolean naiveAproach(int n){
		int count = 0;
		
		for(int i=1; i<=n; i++)
			if(n % i == 0)
				count++;
		
		return count == 2;
	}
	
	public static boolean squareApproach(int n){
		int count = 0;
		
		for(int i=1; i*i < n; i++){
			if(n % i == 0)
				if( i * i == n )
                    count++;
                else                                                     
                    count += 2;
		}
		
		return count == 2;
	}
	
	//this method will return a boolean array array[index] = true when index is prime
	public static boolean [] eratosthenesSieve(int n){
		boolean [] primes = new boolean [n+1];
		Arrays.fill(primes, true);
		
		primes[0] = false;
		primes[1] = false;
		
		for(int i=2; i*i <= n; i++)
			if(primes[i])
				for(int j = i*i; j<=n; j += i)
					primes[j] = false;
		
		return primes;
	}
}
