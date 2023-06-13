import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int column = scanner.nextInt();

        scanner.nextLine();

        String line = scanner.nextLine();

        String[] temp = line.split(" ");

        int index;

        int[] weights = new int[temp.length];

        for (index= 0; index < temp.length ; index++){
            weights[index] = Integer.parseInt(temp[index]);
        }

        boolean[][] matrix = new boolean[row+1][column+1];

        matrix[0][0] = true;

        for ( index = 0; index < row+1; index++ ){

            for(int inner_index = 1; inner_index < column +1; inner_index++){

                if (index == 0 ){
                    matrix[index][inner_index] = true;
                }

                else if (weights[inner_index-1] > index ) {
                    matrix[index][inner_index] =  matrix[index][inner_index-1];
                }

                else{

                    boolean bool1 = matrix[index][inner_index - 1];

                    boolean bool2;

                    if (index - weights[inner_index - 1]< 0){

                        bool2 = false;
                    }

                    else{
                        bool2 = matrix[index - weights[inner_index - 1]][inner_index-1];
                    }

                    matrix[index][inner_index] = bool1 || bool2;
                }
            }
        }


        int max = row;

        while (!matrix[max][column]){

            max--;
        }


        System.out.println(max);


        for (int i = 0; i <row+1; i++){
            for(int j = 0; j < column +1; j++ ){

                if (matrix[i][j]){
                    System.out.print("T");
                }

                else{
                    System.out.print("F");
                }
            }
            System.out.print("\n");
        }
    }
}