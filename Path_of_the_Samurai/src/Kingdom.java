import java.io.*;
import java.util.*;

public class Kingdom {

    boolean[] marked;
    int count;
    int[] id;
    public ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();



    // TODO: You should add appropriate instance variables.
    public void initializeKingdom(String filename) {
        // Read the txt file and fill your instance variables
        // TODO: Your code here

        ArrayList<int[]> directions = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;

        int i;
        int j;

        while(scanner.hasNext()){

            line = scanner.nextLine();
            String[] tempS = line.split(" ");
            if(id == null){
                id = new int[tempS.length];
            }
            int[] temp = new int[tempS.length];

            for(i = 0; i < tempS.length; i++){
                temp[i] = Integer.parseInt(tempS[i]);
            }

            directions.add(temp);
        }

        marked = new boolean[directions.size()];

        count = 0;


        for (i = 0; i < directions.size(); i++){
            ArrayList<Integer> temp = new ArrayList<>();
            adjList.add(temp);
        }

        for(i = 0; i < directions.size(); i++){

            for ( j = 0; j< directions.get(i).length; j++ ){

                if ( directions.get(i)[j] == 1){
                    adjList.get(i).add(j);

                }
            }
        }


        ArrayList<ArrayList<Integer>> tempAdjList = new ArrayList<ArrayList<Integer>>();
        for (i = 0; i < adjList.size(); i++)
            tempAdjList.add(new ArrayList<Integer>());

        for (i = 0; i < adjList.size(); i++){
            for (j = 0; j < adjList.get(i).size(); j++){
                tempAdjList.get(i).add(adjList.get(i).get(j));
                tempAdjList.get(adjList.get(i).get(j)).add(i);
            }
        }

        for (i = 0; i < tempAdjList.size();i++){
            if (!marked[i]){

                dfs(tempAdjList, i);
                count++;
            }
        }
    }

    public List<Colony> getColonies() {
        List<Colony> colonies = new ArrayList<>();
        // TODO: DON'T READ THE .TXT FILE HERE!
        // Identify the colonies using the given input file.
        // TODO: Your code here

        int ColonyID = 0;

        while (ColonyID < count){
            Colony temp = new Colony();
            temp.ColonyID = ColonyID;
            ColonyID++;
            colonies.add(temp);
        }

        for(int i = 0; i <id.length; i++){
            int j = 0;
            while(colonies.get(j).ColonyID != id[i]){
                j++;
            }
            colonies.get(j).cities.add(i + 1);

            colonies.get(j).roadNetwork.put(i, adjList.get(i));
        }


        return colonies;
    }

    public void printColonies(List<Colony> discoveredColonies) {
        // Print the given list of discovered colonies conforming to the given output format.
        // TODO: Your code here

        System.out.println("Discovered colonies are: ");

        for(int i = 0; i < discoveredColonies.size(); i++){
            System.out.print("Colony " + (discoveredColonies.get(i).ColonyID+1)
                    + ": [");

            for (int j = 0; j< discoveredColonies.get(i).cities.size(); j++){
                System.out.print(discoveredColonies.get(i).cities.get(j));

                if(j+1 < discoveredColonies.get(i).cities.size()){
                    System.out.print(", ");
                }
            }

            System.out.print("]\n");
        }
    }


    public void dfs(ArrayList<ArrayList<Integer>> adjList, int x){

        marked[x] = true;

        id[x] = count;

        for(int w: adjList.get(x)){
            if(!marked[w]){

                dfs(adjList, w);
            }
        }
    }
}
