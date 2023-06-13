import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();//algae
        int D = scanner.nextInt();//days
        int N = scanner.nextInt();
        scanner.nextLine();

        int necessary = A/D;

        PriorityQueue<Shrimp> shrimps = new PriorityQueue<>();

        String[] objs = scanner.nextLine().split(" ");

        int index;
        int inner_index;
        int code = 1;

        for (index = 0; index < objs.length; index++){

            String[] parameters = objs[index].split(",");



            Shrimp shrimp = new Shrimp(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]),Integer.parseInt(parameters[2]), code);
            code++;
            shrimps.add(shrimp);

        }

        Boolean check = true;
        int price = 0;
        int count = 0;
        index  = 0;

        Shrimp[] sh = new Shrimp[N];

        int[] counts = new int[N];

        for (int i = 0; i <N ;i++){
            sh[i] = shrimps.remove();
        }

        while (necessary > 0){

            Shrimp temp = sh[index];
            necessary -= temp.eats;

            price += temp.cost;
            counts[index] += 1;
            temp.bought++;

            if(temp.bought == temp.count){
                index++;
            }

            if(necessary > 0 && index == sh.length ){
                check = false;
                break;
            }

        }


        if (check){

            for (index = 0; index < sh.length; index++){
                if (sh[index].bought == 0) {

                    break;
                }
                System.out.println("Bought " + sh[index].bought + " of shrimp " + sh[index].code + ".");
            }
            System.out.println("Total: " +price + "$.");
        }

        else{
            System.out.println("Infeasible");
        }
    }
}


class Shrimp implements Comparable<Shrimp> {
    int cost;
    int eats;
    int count;
    int code;
    float cal;
    int bought = 0;



    public Shrimp(int costin, int eatsin, int countin, int codein){
        cost = costin;
        eats = eatsin;
        count = countin;
        code = codein;
    }

    @Override
    public int compareTo(Shrimp o) {

        cal = (float) eats/cost;
        o.cal = (float) o.eats/o.cost;

        return Float.compare(o.cal, this.cal);
    }
}
