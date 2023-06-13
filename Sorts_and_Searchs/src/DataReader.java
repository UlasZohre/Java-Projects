import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DataReader {

    //500 1000 2000 4000 8000 16000 32000 64000 128000 250000


    static int[][] FinalSet = new int[10][];

    public static void dataReader(String data) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(data));

        ArrayList<Integer> DataSet = new ArrayList<>();

        String line = br.readLine() ;

        while ((line = br.readLine()) != null){



            String[] row = line.split(",");

            DataSet.add(Integer.parseInt(row[6]));
        }

        int[] Data500 = new int[500];
        int[] Data1000 = new int [1000];
        int[] Data2000 = new int[2000];
        int[] Data4000 = new int[4000];
        int[] Data8000 = new int[8000];
        int[] Data16000 = new int[16000];
        int[] Data32000 = new int[32000];
        int[] Data64000 = new int[64000];
        int[] Data128000 = new int[128000];
        int[] Data250000 = new int[250000];

        for (int counter = 0; counter < 250000; counter++){
            if (counter < 500){
                Data500[counter] = DataSet.get(counter);
            }
            if (counter < 1000){
                Data1000[counter] = DataSet.get(counter);
            }
            if (counter < 2000){
                Data2000[counter] = DataSet.get(counter);
            }
            if (counter < 4000){
                Data4000[counter] = DataSet.get(counter);
            }
            if (counter < 8000){
                Data8000[counter] = DataSet.get(counter);
            }
            if (counter < 16000){
                Data16000[counter] = DataSet.get(counter);
            }
            if (counter < 32000){
                Data32000[counter] = DataSet.get(counter);
            }
            if (counter < 64000){
                Data64000[counter] = DataSet.get(counter);
            }
            if (counter < 128000){
                Data128000[counter] = DataSet.get(counter);
            }
            Data250000[counter] = DataSet.get(counter);
        }



        FinalSet[0] = Data500;
        FinalSet[1] = Data1000;
        FinalSet[2] = Data2000;
        FinalSet[3] = Data4000;
        FinalSet[4] = Data8000;
        FinalSet[5] = Data16000;
        FinalSet[6] = Data32000;
        FinalSet[7] = Data64000;
        FinalSet[8] = Data128000;
        FinalSet[9] = Data250000;
    }
}
