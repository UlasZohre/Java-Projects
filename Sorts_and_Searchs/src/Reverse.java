public class Reverse {

    public static int[] reverse(int[] array){
        int[] temp = new int[array.length];


        int index = 0;

        for(int counter = array.length-1; counter > -1; counter--){

            temp[index] = array[counter];
            index++;
        }

        return temp;
    }
}
