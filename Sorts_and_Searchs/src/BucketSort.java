import java.lang.Math;
import java.util.ArrayList;

public class BucketSort {

    public static int[] bucketSort(int[] arr, int n){

        int NOB = (int) Math.sqrt(arr.length);

        ArrayList<Integer>[] buckets = new ArrayList[NOB];

        int max = 0;
        int temp;

        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }

        for (int i = 0; i < NOB; i++){
            buckets[i] = new ArrayList<>();
        }

        for (int a: arr){
            temp = hash(a, max, NOB);
            buckets[temp].add(a);
        }

        for (ArrayList<Integer> bucket : buckets) {
            if (!bucket.isEmpty()) {
                bucket.sort(Integer::compare);
            }
        }

        int[] sortedArr = new int[n];

        int index = 0;
        for(ArrayList<Integer> bucket: buckets){
            if(!bucket.isEmpty()){
                for (int i: bucket){
                    sortedArr[index] = i;
                    index++;
                }
            }
        }

        return sortedArr;
    }

    public static int hash(int i, int max, int NOB){

        double temp = i/max;
        int conc = (int) Math.floor((temp*(NOB-1)));
        return conc;
    }

}
