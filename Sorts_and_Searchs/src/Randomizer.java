import java.util.Random;

public class Randomizer {


    public static int random(int[] arr){

        int temp;

        Random random = new Random();

        temp = random.nextInt(arr.length);

        return temp;
    }
}
