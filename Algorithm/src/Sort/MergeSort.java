/* Java program for Merge Sort */
public class MergeSort 
{   
    // Conquer:Merges two subarrays of arr[]. 
    // First subarray is arr[front..end] 
    // Second subarray is arr[middle+1..end] 
    void merge(int arr[], int front, int middle, int end) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = middle - front + 1; 
        int n2 = end - middle; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[front + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[middle + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = front; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
     //Divide 將數列對半分拆成兩個,之後再merge
    void sort(int arr[], int front, int end) 
    { 
        if (front < end) 
        { 
            // Find the middle point 
            int middle = (front+end)/2; 
  
            // Sort first and second halves 
            sort(arr, front, middle); 
            sort(arr , middle+1, end); 
  
            // Merge the sorted halves 
            merge(arr, front, middle, end); 
        } 
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; i++) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
} 


