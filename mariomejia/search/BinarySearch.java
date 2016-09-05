package mariomejia.search;

//in order to binary search works, the array must be sorted in ascending order
public class BinarySearch {
	
	public static int find(int [] array, int item){
		return binarySearch(array, 0, array.length-1, item);
	}
	
	//recursive binary search
	public static int binarySearch(int [] array, int left, int right, int item){
		if(left <= right){
			int mid = left + (right - left) / 2;
			
			if(array[mid] == item)
				return mid;
			else if(item < array[mid])
				return binarySearch(array, left, mid-1, item);
			else
				return binarySearch(array, mid+1, right, item);
		}
		else
			return -1;
	}
	
	//linear binary search
	public static int linearBinarySearch(int [] array, int item){
		int left = 0, right = array.length-1;
		
		while(left <= right){
			int mid = left + (right - left) / 2;
			
			if(array[mid] == item)
				return mid;
			else if(item < array[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		return -1;
	}
	
	public static int firstOcurrence(int [] array, int item){
		int left = 0, right = array.length - 1, mid = 0, result = -1;
		
		while(left <= right){
			mid = left + (right - left) / 2;
			
			if(array[mid] == item){
				result = mid;
				right = mid - 1;
			}
			else if(item < array[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		return result;
	}
	
	public static int lastOcurrence(int [] array, int item){
		int left = 0, right = array.length - 1, mid = 0, result = -1;
		
		while(left <= right){
			mid = left + (right - left) / 2;
			
			if(array[mid] == item){
				result = mid;
				left = mid + 1;
			}
			else if(item < array[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		return result;
	}
	
	//this method assumes that item exist at least once in the array
	public static int numberOfOcurrences(int [] array, int item){
		int left = firstOcurrence(array, item);
		int right = lastOcurrence(array, item);
		
		if(array[left] == item && array[right] == item)
			return (right - left + 1);
		else
			return 0;
	}
}
