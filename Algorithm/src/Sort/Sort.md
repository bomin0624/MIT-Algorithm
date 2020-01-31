# Counting Sort & Radix Sort

###### tags: `Algorithm` `sort`


## Counting Sort

Time complexity:O(n+k)
Space complexity:O(n+k)

1.找出待排序的陣列中最大和最小的元素
2.統計陣列中每個值為i的元素出現的次數，存入陣列C的第i項
3.對所有的計數累加（從C中的第一個元素開始，每一項和前一項相加）
4.反向填充目標陣列：將每個元素i放在新陣列的第C[i]項，每放一個元素就將C[i]減去1

Features:
Non-Comparsion Algorithm
只能用來排序已知數值範圍的序列

[Counting Sort in Java](https://www.baeldung.com/java-counting-sort)

### Implement

```
// Counting sort which takes negative numbers as well  

public class CountingSort { 
  
    static void countSort(int[] arr) { 
        
        int max = Arrays.stream(arr).max().getAsInt(); 
        int min = Arrays.stream(arr).min().getAsInt(); 
        int range = max - min + 1; 
        int count[] = new int[range]; 
        int output[] = new int[arr.length]; 
        
        for (int i = 0; i < arr.length; i++){ 
            count[arr[i] - min]++; 
        } 
  
        for (int i = 1; i < count.length; i++){ 
            count[i] += count[i - 1]; 
        } 
  
        for (int i = arr.length - 1; i >= 0; i--){ 
            output[count[arr[i] - min] - 1] = arr[i]; 
            count[arr[i] - min]--; 
        } 
        
        for (int i = 0; i < arr.length; i++){ 
            arr[i] = output[i]; 
        } 
    } 
}  
```

Radix Sort
---
以排序n個不同整數來舉例，假設這些整數以b為底，這樣每位數都有b個不同的數字，k = logbN 雖然有B個不同的數字，需要B個不同的桶，但在每一輪處理中，判斷每個待排序資料項只需要一次計算確定對應數位的值，因此在每一輪處理的時候都需要平均n次操作來把整數放到合適的桶中去

Features: Non-Comparative Sorting Algorithm

Time complexity:O(kn)
Space complexity:O(k+n)

1.在數列找出最大的數
2.最大的數的位數 ex:100->3位數
3.讓其他也變同位數 ex: 100 is biggest and 50->050
4.從右邊開始比較

[Radix Sort - step by step guide](https://www.youtube.com/watch?v=YXFI4osELGU)


### Implement

想法：用Counting Sort 來比較每一位數 由右至左

```
    // The main function to that sorts arr[] of size n using Radix Sort 
    
    static void radixsort(int arr[], int n){ 
        
        // Find the max num to know number of digits 
        int m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        // m/exp 取整數 
        
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
```
