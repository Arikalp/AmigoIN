import java.util.*;

public class Array {

    public static int Linear_Search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if not found
    }

    public static int[] Bubble_sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr; // Return the sorted array
    }

    public static int[] Quick_Sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            Quick_Sort(arr, low, pi - 1);
            Quick_Sort(arr, pi + 1, high);
        }
        return arr; // Return the sorted array
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++; // increment index of smaller element
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the partitioning index
    }

    public static int[] Merge_Sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort first and second halves
            Merge_Sort(arr, left, mid);
            Merge_Sort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
        return arr;
    }

    public static int[] Insertion_sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr; // Return the sorted array
    }

    public static int[] Selection_sort(int[] arr) {
        int len=arr.length;
        for(int i=0;i<len;i++)
        {
            int mini=i;
            for(int j=i+1;j<len;j++) if(arr[j]<arr[mini]) mini=j;
        
            int temp=arr[i];
            arr[i]=arr[mini];
            arr[mini]=temp; // Swap the found minimum element with the first element
        }
        
        return arr; // Return the sorted array
    }  

    public static void merge(int arr[], int left, int mid, int right) {
        int[] leftarr = Arrays.copyOfRange(arr, left, mid);
        int[] rightarr = Arrays.copyOfRange(arr, mid + 1, right);

        int i = 0, j = 0, k = left;
        while (i < leftarr.length && j < rightarr.length) {
            if (leftarr[i] <= rightarr[j]) {
                arr[k++] = leftarr[i++];
            } else {
                arr[k++] = rightarr[j++];
            }
        }

        while (i < leftarr.length) {
            arr[k++] = leftarr[i++];
        }

        while (j < rightarr.length) {
            arr[k++] = rightarr[j++];
        }
    }

    public static int Binary_Search(int[] arr, int target, int low, int high) {

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid; // Return the index if found
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return -1; // Return -1 if not found
    }

    public static void main(String[] args) {
        // Declare and initialize an array of integers

        int[] numbers = { 20, 22, 35, 199, 4, 12 };
        int target = 35;
        int high = 0, low = 0, low1 = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] > target) {

                high = i;
                low1 = i + 1;
                break;
            }
        }

        int ans1 = 0, ans2 = 0;

        // ans2 = Binary_Search(numbers, target, low, high);
        // System.out.println("Found at:" + ans2);
        // ans1 = Binary_Search(numbers, target, low1, numbers.length - 1);
        // System.out.println("Found at:" + ans1);
        System.out.println("Unsorted array: " + Arrays.toString(numbers));
        System.out.println("Sorted array: " + Arrays.toString(Selection_sort(numbers)));

        // Example usage of Linear_Search
        // System.out.println("Enter target value to search:");
        // int target = new Scanner(System.in).nextInt();

        // int index = Linear_Search(numbers, target);
        // System.out.println("Index of target value " + Linear_Search(numbers,
        // target));

        // Print the elements of the array
        // for (int i = 0; i < numbers.length; i++) {
        // System.out.println("Element at index " + i + ": " + numbers[i]);
        // }

        // // Print the entire array
        // System.out.print("Array contents: ");
        // for (int num : numbers) {
        // System.out.print(num + " ");
        // }

        // Arrays.sort(numbers); // Sort the array
        // System.out.println("\nSorted array:"+numbers[numbers.length-1]);
        // System.out.println("minimum number in the array: " + numbers[0]);

        // // Print the maximum number in the array
        // System.out.println("maximum number in the array: " + numbers[numbers.length -
        // 1]);
    }
}
