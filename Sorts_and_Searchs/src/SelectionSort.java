public class SelectionSort {

    public static int[]  selectionSort(int[] arr){

        int minValue, minIndex, temp= 0;

        for (int i = 0; i < arr.length; i++ ){

            minValue = arr[i];
            minIndex = i;

            for (int j = i; j < arr.length; j++ ){

                if (arr[j] < minValue){

                    minValue = arr[j];
                    minIndex = j;
                }
            }

            if ( minValue < arr[i]){

                temp = arr[i];
                arr[i] = minValue;
                arr[minIndex] = temp;
            }
        }

        return arr;
    }
}
