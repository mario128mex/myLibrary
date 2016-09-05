package mariomejia.math;

public class ExendedEuclidAlgorithm {
	public int d; //GCD
	
	//this algorithm has the property that it can always be represented in 
	//the form Ax + By = GCD(A, B)
	public int x;
	public int y;
	
	public ExendedEuclidAlgorithm(){
		this.d = 0;
		this.x = 0;
		this.y = 0;
	}
	
	//at the end of the recursive calls of this methods, we will get
	//the GCD and the coeficients x and y
	public void extendedEuclid(int a, int b){
		if(b == 0){
			d = a;
			x = 1;
			y = 0;
		}
		else{
			extendedEuclid(b, a % b);
			int temp = x;
			x = y;
			y = temp - (a/b)*y;
		}
	}
	
	public void resetValues(){
		this.d = 0;
		this.x = 0;
		this.y = 0;
	}
}
