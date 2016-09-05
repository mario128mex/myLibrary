package mariomejia.sort;

public class MergeSort {
	public int array [];
	
	public MergeSort(int [] array){
		this.array = array;
	}
	
	public static void sort(int [] array){
		mergeSort(array, 0, array.length-1);
	}
	
	//end should not pass array.length-1
	public static void mergeSort(int [] array, int start, int end){
		if(start < end){
			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid+1, end);
			
			merge(array, start, mid, end);
		}
	}
	
	public static void merge(int [] array, int start, int mid, int end){
		//indexA: the start of the firts array; indexB: the second one; index: the temp array index
		int indexA = start, indexB = mid+1, index = 0;
		
		int [] tempArr = new int [end - start+1];
		
		for(int i = start ;i <= end ;i++) {
			if(indexA > mid)      //checks if first part comes to an end or not .
				tempArr[ index++ ] = array[ indexB++] ;

			else if ( indexB > end)   //checks if second part comes to an end or not
				tempArr[ index++ ] = array[ indexA++ ];

			else if( array[ indexA ] < array[ indexB ])     //checks which part has smaller element.
				tempArr[ index++ ] = array[ indexA++ ];

			else
				tempArr[ index++ ] = array[ indexB++];
	   }
		
	   for (int i=0 ; i< index ;i ++) {
		   //updating the ordered section of the array
	       array[ start++ ] = tempArr[i] ;                          
	   }
	}
}
