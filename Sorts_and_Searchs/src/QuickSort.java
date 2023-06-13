public class QuickSort {

    public static int[] quickSort(int[] arr, int low, int high){

        int[] stack = new int[high - low + 1];

        int top = -1;

        stack[++top] = low;
        stack[++top] = high;

        while ( top >= 0){

            high = stack[top--];
            low = stack[top--];

            int pivot = partition(arr, low, high-1);

            if (pivot - 1 > low){

                stack[++top] = low;
                stack[++top] = pivot - 1;
            }

            if (pivot + 1 > high){
                stack[++top] = pivot + 1;
                stack[++top] = high;
            }
        }

        return arr;
    }
    public static int partition(int[] arr, int low, int high){

        int pivot = arr[high];

        int i = low - 1;

        int temp;

        for (int j = 0; j <= high-1; j++){

            if (arr[j] <= pivot){

                i++;
                temp = arr[i];

                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i+1];
        arr[i+1] = pivot;
        arr[high] = temp;

        return i+1;
    }
}












