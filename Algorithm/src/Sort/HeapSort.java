package Sort;
// Java program for implementation of Heap Sort 

public class HeapSort 
{ 
		
    public void heap_sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build Max_heap,set Root as 0
        for (int i = n / 2 - 1; i >= 0; i--) 
            Maxheapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call Maxheapify on the reduced heap 
            Maxheapify(arr, i, 0); //From 0 to n-1
        } 
    } 
  
    void Maxheapify(int arr[], int length, int root) 
    { 
        int largest = root; // Initialize largest as root 
        
        //Set root as 0
        int left = 2*root + 1 ; 
        int right = 2*root + 2; 
  
        // If left child is larger than root 
        if (left < length && arr[left] > arr[largest]) 
            largest = left; 
  
        // If right child is larger than largest so far 
        if (right < length && arr[right] > arr[largest]) 
            largest = right; 
  
        // If largest is not root 
        if (largest != root) 
        { 
        	//swap(arr[largest],arr[root]);
            int swap = arr[root]; 
            arr[root] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively Maxheapify the affected sub-tree 
            Maxheapify(arr, length, largest); 
        } 
    } 
    
 
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; i++) 
        System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        HeapSort ob = new HeapSort(); 
        ob.heap_sort(arr); 
  
        System.out.println("Sorted array is"); 
        printArray(arr); 
    } 
} 

