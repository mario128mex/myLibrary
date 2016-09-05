import java.io.*;
import java.util.*;

class Main{
	public static void main(String [] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String line;
		double a, b, c;
		int t = 1;
		
		while(!(line = br.readLine()).equals("0 0 0")){
			st = new StringTokenizer(line);
			
			a = Double.parseDouble(st.nextToken());
			b = Double.parseDouble(st.nextToken());
			c = Double.parseDouble(st.nextToken());
			
			if(a < 0){
				a = c * c - b * b;
				
				out.println("Triangle #"+t);
				if(a <= 0)
					out.println("Impossible.");
				else{
					a = Math.sqrt(a);
					out.printf("a = %.3f\n", a);
				}
			}
			else if(b <= 0){
				b = c * c - a * a;
				
				out.println("Triangle #"+t);
				if(b <= 0)
					out.println("Impossible.");
				else{
					b = Math.sqrt(b);
					out.printf("b = %.3f\n", b);					
				}
			}
			else if(c < 0){
				c = a * a + b * b;
				c = Math.sqrt(c);
				
				out.println("Triangle #"+t);
				out.printf("c = %.3f\n", c);
			}
			out.println();
			t++;
		}
		
		out.flush();
	}
}