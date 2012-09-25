package sample.questions;

/*
 * Time Complexity: O(log n)
 */

public class Median {
	
	public Median () {
		
	}
	/*
	 * The function calculates the median
	 * 
	 * @params: int array1, int array2, start, end, size
	 * 
	 * @return value: median of the 2 arrays 
	 */
	int findMedian(int a[], int b[], int start, int end, int n) {
		int i, j;
		 
	    /* We have reached at the end (left or right) of a[] */
	    if(start > end)
	        return findMedian(a, b, 0, n-1, n);
	 
	    i = (start + end)/2;
	    j = n - i - 1;  /* Index of b[] */
	 
	    /* Termination condition */
	    if (a[i] > b[j] && (j == n-1 || a[i] <= b[j+1])) {
	        /*a[i] is decided as median 2, now select the median 1 to get the average of both*/
	        if (b[j] > a[i-1] || i == 0)
	            return (a[i] + b[j])/2;
	        else
	            return (a[i] + b[i-1])/2;
	    }	 
	    /*Search in left half of a[]*/
	    else if (a[i] > b[j] && j != n-1 && a[i] > b[j+1]) {
	    	return findMedian(a, b, start, i-1, n);
	    }	      	 
	    /*Search in right half of a[]*/
	    /* a[i] is smaller than both b[j] and b[j+1]*/
	    else {
	    	return findMedian(a, b, i+1, end, n);
	    }	        
	}
	
	public static void main(String s[]) {
		Median m = new Median();
		int a[] = {3, 5, 7, 9, 11};
		int b[] = {2, 4, 6, 8, 10};
		int size1 = a.length;
		int size2 = b.length;
		if(size1 == size2) {
			System.out.println("Median is: " + m.findMedian(a, b, 0, size1 -1 , size1));			
		}
		else {
			System.out.println("The size of both arrays need to be the same");
		}
	}
}