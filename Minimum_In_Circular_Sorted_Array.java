package sample.questions;

/*
 * Time Complexity: O(log n)
 */

public class Minimum_In_Circular_Sorted_Array {
	
	public Minimum_In_Circular_Sorted_Array() {
		
	}
	public int min(int x, int y) {
		return x < y ? x : y;
	}
	/*
	 * The function will find the minimum element by dividing the array in the middle.
	 * 
	 * @params: int array, start position, end position, size of array
	 * 
	 * @return value: the minimum element
	 */
	public int binarySearch(int a[], int start, int end, int n) {
		
		int middle;
		middle = (start + end) / 2;
		int result = 0;
		if(n == 1) {
			result =  a[start];
			return result;
		}
		/* If a[middle] is less than both its left and right, then a[middle] is the least element*/
		if((a[middle - 1] > a[middle]) && (a[middle + 1] > a[middle])) {
			result =  a[middle];
		}
		/* If middle is greater than both left and right, then search the right sub array */
		else if((a[middle - 1] < a[middle]) && (a[middle + 1] < a[middle])) {
				result = binarySearch(a, middle + 1, end, n %2 == 0 ? n - n / 2 : n - n / 2 - 1);
			}
			/* If middle is greater than left but smaller than right, then minimum of both the sub arrays will be the least element*/
			else if((a[middle - 1] < a[middle]) && (a[middle + 1] > a[middle])) {
				result = min(binarySearch(a, middle + 1, end, n %2 == 0 ? n - n / 2 : n - n / 2 - 1), binarySearch(a, start, middle - 1, n % 2 == 0 ? n - n / 2 : n - n / 2 - 1));
			}
		
		return result;
	}
	
	public static void main(String s[]) {
		Minimum_In_Circular_Sorted_Array mcsa = new Minimum_In_Circular_Sorted_Array();
		int a[] = {5, 8, 19, 27, 2, 3, 4};
		int n = a.length;
		System.out.println("Minimum element is: " + mcsa.binarySearch(a, 0, n - 1, n));
	}
}
