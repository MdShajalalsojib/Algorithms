public class QuickSort {

        // Quick Sort function
        static void quick_sort(int arr[], int left, int right) {
            if (left < right) {
                int pos = partition(arr, left, right);
                quick_sort(arr, left, pos - 1);  // Sort left part
                quick_sort(arr, pos + 1, right); // Sort right part
            }
        }
    
        // Partition function using the last element as pivot
        static int partition(int arr[], int left, int right) {
            int pivot = arr[right];
            int k = left;
    
            for (int i = left; i < right; i++) {
                if (arr[i] < pivot) {
                    // Swap arr[i] and arr[k]
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                    k++;
                }
            }
    
            // Place pivot in the correct position
            int temp = arr[right];
            arr[right] = arr[k];
            arr[k] = temp;
    
            return k;
        }
    
        // Main function to test Quick Sort
        public static void main(String[] args) {
            int arr[] = {2, 5, 1, 3, 7, 6, 9, 10, 8};
            int len = arr.length - 1;
    
            quick_sort(arr, 0, len);
    
            System.out.println("Sorted array:");
            for (int i = 0; i <= len; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
     

