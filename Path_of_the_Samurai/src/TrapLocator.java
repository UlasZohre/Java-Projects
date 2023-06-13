import java.util.*;

public class TrapLocator {
    public List<Colony> colonies;

    private boolean[] marked;        // marked[v] = has vertex v been marked?
    private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
    private boolean[] onStack;       // onStack[v] = is vertex on the stack?
    private Stack<Integer> cycle;    // directed cycle (or null if no such cycle)

    public TrapLocator(List<Colony> colonies) {
        this.colonies = colonies;
    }

    public List<List<Integer>> revealTraps() {

        // Trap positions for each colony, should contain an empty array if the colony is safe.
        // I.e.:
        // 0 -> [2, 15, 16, 31]
        // 1 -> [4, 13, 22]
        // 3 -> []
        // ...
        List<List<Integer>> traps = new ArrayList<>();

        // Identify the time traps and save them into the traps variable and then return it.
        // TODO: Your code here

        for (int i = 0; i < colonies.size(); i++){


            dfs(colonies.get(i).roadNetwork, i, traps);

        }

        return traps;
    }

    private void dfs(HashMap<Integer, List<Integer>> roadNetwork, int v, List<List<Integer>> traps) {
        onStack[v] = true;
        marked[v] = true;

        for(int u = 0; u < roadNetwork.size(); u++){
            for (int w : roadNetwork.get(u)) {

                // short circuit if directed cycle found
                if (cycle != null) return;

                    // found new vertex, so recur
                else if (!marked[w]) {
                    edgeTo[w] = v;
                    dfs(roadNetwork, w, traps);
                }

                // trace back directed cycle
                else if (onStack[w]) {
                    cycle = new Stack<Integer>();
                    for (int x = v; x != w; x = edgeTo[x]) {
                        cycle.push(x);
                    }
                    cycle.push(w);
                    cycle.push(v);

                    List<Integer> temp = new ArrayList<>();

                    while(!cycle.empty()){
                        temp.add(cycle.pop());
                    }
                    List<Integer> trap = new ArrayList<>();
                    for(int i = 0; i< temp.size();i++ ){
                        trap.add(0, temp.get(i));
                    }

                    traps.add(trap);
                    assert check();
                }
            }
        }

        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    private boolean check() {

        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }
        return true;
    }

    public void printTraps(List<List<Integer>> traps) {
        // For each colony, if you have encountered a time trap, then print the cities that create the trap.
        // If you have not encountered a time trap in this colony, then print "Safe".
        // Print the your findings conforming to the given output format.
        // TODO: Your code here


        System.out.println("Danger exploration conclusions:");

        for(int i = 0; i<traps.size(); i++) {
            System.out.print("Colony " + i + 1 + ": ");

            if (traps.get(i).isEmpty()) {
                System.out.print("Safe\n");
            } else {

                System.out.print("Dangerous. Cities on the dangerous path: [");
                for (int j = 0; j < traps.get(i).size(); j++) {
                    System.out.print(traps.get(i).get(j) + ", ");
                }

                System.out.print("]\n");
            }
        }


    }

}
