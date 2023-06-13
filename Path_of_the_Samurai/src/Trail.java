public class Trail implements Comparable<Trail> {
    public Location source;
    public Location destination;
    public int danger;

    public Trail(Location source, Location destination, int danger) {
        this.source = source;
        this.destination = destination;
        this.danger = danger;
    }

    @Override
    public int compareTo(Trail o) {
        if(this.danger == o.danger){
            return 0;
        }

        else if (this.danger > o.danger){
            return 1;
        }

        return -1;
    }
}
