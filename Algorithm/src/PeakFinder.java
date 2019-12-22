
public class PeakFinder {
	
	// A binary search based function that returns index of a peak 
    // element 
	//n = array's length
    
	static int findPeakUtil(int arr[], int front, int end, int n) 
    { 
        // Find index of middle element 
        int mid = front + (end - front)/2;  /* (low + high)/2   avoid overflow */ 
  
        // Compare middle element with its neighbours (if neighbours 
        // exist) 
        
        if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 || 
             arr[mid+1] <= arr[mid])) 
            return mid; 
        
        
        //如果 mid-1 > mid , 回傳從左邊 front 到 mid-1 進行比較
        else if (mid > 0 && arr[mid-1] > arr[mid]) 
        	return findPeakUtil(arr, front, (mid -1), n); 
        
        
        //如果 mid+1> mid, 回傳右邊 mid+1 到 end 進行比較
        else return findPeakUtil(arr, (mid + 1), end, n); 
    } 
  
	
    static int findPeak(int arr[], int n)    
    { 
        return findPeakUtil(arr, 0, n-1, n); 
    } 
  
    // Driver method 
    public static void main (String[] args) 
    { 
        int arr[] = {1, 3, 20, 4, 1, 0}; 
        int n = arr.length; 
        System.out.println("Index of a peak point is " + 
                            findPeak(arr, n)); 
    } 
}
