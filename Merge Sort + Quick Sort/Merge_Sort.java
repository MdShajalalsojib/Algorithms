public class Merge_Sort {
    
        // Merge Sort function
        static void merge_sort(int arr[], int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                merge_sort(arr, left, mid);       // Sort left half
                merge_sort(arr, mid + 1, right);  // Sort right half
                merge(arr, left, mid, right);     // Merge both halves
            }
        }
    
        // Function to merge two sorted subarrays
        static void merge(int arr[], int left, int mid, int right) {
            int n1 = (mid - left) + 1;
            int n2 = right - mid;
    
            int leftArr[] = new int[n1];
            int rightArr[] = new int[n2];
    
            // Copy data to temporary arrays
            for (int i = 0; i < n1; i++) {
                leftArr[i] = arr[left + i];
            }
            for (int j = 0; j < n2; j++) {
                rightArr[j] = arr[mid + 1 + j];
            }
    
            int i = 0, j = 0, k = left;
    
            // Merge the temporary arrays
            while (i < n1 && j < n2) {
                if (leftArr[i] <= rightArr[j]) {
                    arr[k] = leftArr[i];
                    i++;
                } else {
                    arr[k] = rightArr[j];
                    j++;
                }
                k++;
            }
    
            // Copy remaining elements
            while (i < n1) {
                arr[k] = leftArr[i];
                i++;
                k++;
            }
            while (j < n2) {
                arr[k] = rightArr[j];
                j++;
                k++;
            }
        }
    
        // Main method to test the merge sort
        public static void main(String[] args) {
            int arr[] = {2, 5, 1, 3, 7, 6, 9, 10, 8};
            int len = arr.length - 1;
    
            merge_sort(arr, 0, len);
    
            System.out.println("Sorted array:");
            for (int i = 0; i <= len; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
    

