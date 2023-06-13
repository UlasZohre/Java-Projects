import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        DataReader.dataReader(args[0]);

        int[] xAxis = {500,1000, 2000 ,4000 ,8000, 16000, 32000, 64000, 128000, 250000};

        int index;
        int counter;
        long begin;
        long end;
        double avg = 0;
        double[][] avgs = new double[3][10];
        int avgIndex = 0;
        for (index = 0; index < 10 ; index++ ){
            for (counter = 0; counter < 10; counter++){
                begin = System.currentTimeMillis();
                QuickSort.quickSort(DataReader.FinalSet[index].clone(),0, DataReader.FinalSet[index].length);
                end = System.currentTimeMillis();
                avg += (end-begin);
            }
            avg = avg/10;

            System.out.println("Random quick sort " +xAxis[avgIndex] + " " +avg );
            avgs[0][avgIndex] = avg;
            avgIndex++;
            avg = 0;
        }
        avgIndex= 0;

        for (index = 0; index < 10 ; index++ ){
            for (counter = 0; counter < 10; counter++){
                begin = System.currentTimeMillis();
                BucketSort.bucketSort(DataReader.FinalSet[index].clone(), DataReader.FinalSet[index].length);//TODO buraya bak
                end = System.currentTimeMillis();
                avg += (end-begin);
            }
            avg = avg/10;

            System.out.println("Random bucket sort " +xAxis[avgIndex] + " "+ avg );
            avgs[1][avgIndex] = avg;
            avgIndex++;
            avg = 0;
        }
        avgIndex = 0;

        for (index = 0; index < 10 ; index++ ){
            for (counter = 0; counter < 10; counter++){
                begin = System.currentTimeMillis();
                SelectionSort.selectionSort(DataReader.FinalSet[index].clone());
                end = System.currentTimeMillis();
                avg += (end-begin);
            }
            avg = avg/10;
            System.out.println("Random selection sort " +xAxis[avgIndex] + " "+ avg );
            avgs[2][avgIndex] = avg;
            avgIndex++;
            avg = 0;
        }


        avgIndex = 0;
        Charts.showAndSaveChart("Random Sort",xAxis, avgs, 0 );

        for (index = 0; index < 10 ; index++ ){
            int[] temp = DataReader.FinalSet[index].clone();
            Arrays.sort(temp);
            for (counter = 0; counter < 10; counter++){
                begin = System.currentTimeMillis();
                QuickSort.quickSort(temp,0, temp.length);
                end = System.currentTimeMillis();
                avg += (end-begin);
            }
            avg = avg/10;

            System.out.println("Sorted quick sort "+xAxis[avgIndex] + " " + avg );
            avgs[0][avgIndex] = avg;
            avgIndex++;
            avg = 0;
        }
        avgIndex = 0;

        for (index = 0; index < 10 ; index++ ){
            int[] temp = DataReader.FinalSet[index].clone();
            Arrays.sort(temp);
            for (counter = 0; counter < 10; counter++){
                begin = System.currentTimeMillis();
                BucketSort.bucketSort(temp, temp.length);//TODO buraya bak
                end = System.currentTimeMillis();
                avg += (end-begin);
            }
            avg = avg/10;

            System.out.println("Sorted bucket sort "+xAxis[avgIndex] + " " + avg );
            avgs[1][avgIndex] = avg;
            avgIndex++;
            avg = 0;
        }
        avgIndex = 0;

        for (index = 0; index < 10 ; index++ ){

            int[] temp = DataReader.FinalSet[index].clone();
            Arrays.sort(temp);
            for (counter = 0; counter < 10; counter++){
                begin = System.currentTimeMillis();
                SelectionSort.selectionSort(temp);
                end = System.currentTimeMillis();
                avg += (end-begin);
            }
            avg = avg/10;

            System.out.println("Sorted selection sort"+xAxis[avgIndex] + " " + avg );
            avgs[2][avgIndex] = avg;
            avgIndex++;
            avg = 0;
        }
        avgIndex = 0;
        Charts.showAndSaveChart("Sorted Sort",xAxis, avgs, 1 );


        for (index = 0; index < 10 ; index++ ){
            int[] temp = DataReader.FinalSet[index].clone();

            Arrays.sort(temp);


            for (counter = 0; counter < 10; counter++){
                temp = Reverse.reverse(temp);
                begin = System.currentTimeMillis();
                QuickSort.quickSort(temp,0, temp.length);
                end = System.currentTimeMillis();
                avg += (end-begin);
            }
            avg = avg/10;

            System.out.println("reverse quicksort "+xAxis[avgIndex] + " " + avg );
            avgs[0][avgIndex] = avg;
            avgIndex++;
            avg = 0;
        }
        avgIndex = 0;

        for (index = 0; index < 10 ; index++ ){
            int[] temp = DataReader.FinalSet[index].clone();

            Arrays.sort(temp);
            temp = Reverse.reverse(temp);

            for (counter = 0; counter < 10; counter++){
                begin = System.currentTimeMillis();
                BucketSort.bucketSort(temp, temp.length);//TODO buraya bak
                end = System.currentTimeMillis();
                avg += (end-begin);
            }
            avg = avg/10;

            System.out.println("reverse bucket " +xAxis[avgIndex] + " "+ avg );
            avgs[1][avgIndex] = avg;
            avgIndex++;
            avg = 0;
        }
        avgIndex = 0;

        for (index = 0; index < 10 ; index++ ){

            int[] temp = DataReader.FinalSet[index].clone();

            Arrays.sort(temp);
            temp= Reverse.reverse(temp);

            for (counter = 0; counter < 10; counter++){
                begin = System.currentTimeMillis();

                SelectionSort.selectionSort(temp);
                end = System.currentTimeMillis();
                avg += (end-begin);
            }
            avg = avg/10;

            System.out.println("reverse selection "+xAxis[avgIndex] + " " + avg );
            avgs[2][avgIndex] = avg;
            avgIndex++;
            avg = 0;
        }
        Charts.showAndSaveChart("Reverse sorted Sort",xAxis, avgs , 2);

        avgIndex = 0;

        int temp;


        for (index = 0; index < 10; index++){


            for (counter = 0; counter < 1000; counter++){
                temp = Randomizer.random(DataReader.FinalSet[index]);
                begin = System.nanoTime();
                LinearSearch.linearSearch(DataReader.FinalSet[index],temp );
                end = System.nanoTime();

                avg = (end - begin);
            }
            avg = avg/1000;

            System.out.println("random linear search"+xAxis[avgIndex] + " " + avg );

            avgs[0][avgIndex] = avg;
            avgIndex++;
            avg= 0;

        }

        avgIndex = 0;


        for(index = 0; index < 10; index++){
            int[] tempArr = DataReader.FinalSet[index].clone();
            Arrays.sort(tempArr);

            for (counter = 0; counter < 1000; counter++){
                temp = Randomizer.random(DataReader.FinalSet[index]);

                begin = System.nanoTime();
                LinearSearch.linearSearch(tempArr, temp);
                end = System.nanoTime();
                avg = (end - begin);
            }
            avg = avg/1000;
            System.out.println("sorted linear search" +xAxis[avgIndex] + " "+ avg );


            avgs[1][avgIndex] = avg;
            avgIndex++;
            avg = 0;



        }

        avgIndex = 0;

        for(index = 0; index < 10; index++){
            int[] tempArr = DataReader.FinalSet[index].clone();
            Arrays.sort(tempArr);

            for (counter = 0; counter < 1000; counter++){
                temp = Randomizer.random(DataReader.FinalSet[index]);

                begin = System.nanoTime();
                BinarySearch.binarySearch(tempArr, temp);
                end = System.nanoTime();
                avg = (end - begin);
            }
            avg = avg/1000;


            System.out.println("binary search "+xAxis[avgIndex] + " " + avg );
            avgs[2][avgIndex] = avg;
            avgIndex++;
            avg = 0;



        }


        Charts.showAndSaveChart("Searches", xAxis, avgs, 3);




        
        





        
    }
}