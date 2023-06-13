public class BinarySearch {

    public static int binarySearch(int[] arr, int value){

        int first = 0;
        int size = arr.length -1;

        int mid;
        int counter =0;
        while (size - first > 1){
            mid = size/2 + first/2;

            if(arr[mid] == value){
                return mid ; }
            if (value > arr[mid] ){
                first = mid +1;
            }

            else{
                size = mid -1;
            }




        }

        if (arr[first] == value){
            return first;
        }

        else if (arr[size] == value){
            return size;
        }

        return -1;
    }
}
