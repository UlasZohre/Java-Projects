import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

public class TravelMap {

    // Maps a single id to a single Location.
    public Map<Integer, Location> locationMap = new HashMap<>();

    // List of locations, read in the given order
    public List<Location> locations = new ArrayList<>();

    // List of trails, read in the given order
    public List<Trail> trails = new ArrayList<>();

    // TODO: You are free to add more variables if necessary.
    private ArrayList<ArrayList<Trail>> t = new ArrayList<>();

    public void initializeMap(String filename) {
        // Read the XML file and fill the instance variables locationMap, locations and trails.
        // TODO: Your code here

        try
        {
            File xmlDoc = new File(filename);
            DocumentBuilderFactory dbFac = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuild = dbFac.newDocumentBuilder();
            Document doc = dbBuild.parse(xmlDoc);
            doc.getDocumentElement().normalize();
            int i;


            NodeList LocationList = ((Element)(((Element)doc.getChildNodes().item(0)).getElementsByTagName("Locations").item(0))).getElementsByTagName("Location");
            for (i = 0; i < LocationList.getLength(); i++){

                Node temp = LocationList.item(i);

                if (temp.getNodeType() == Node.ELEMENT_NODE){
                    Element e = (Element) temp;
                    String name = e.getElementsByTagName("Name").item(0).getTextContent();
                    int id = Integer.parseInt(e.getElementsByTagName("Id").item(0).getTextContent());

                    Location loc = new Location(name, id);
                    locations.add(loc);
                }
            }

            for(i = 0; i < locations.size(); i++)
                t.add(new ArrayList<Trail>());

            NodeList TrailList = ((Element)(((Element)doc.getChildNodes().item(0)).getElementsByTagName("Trails").item(0))).getElementsByTagName("Trail");

            for(i = 0; i < TrailList.getLength(); i++){

                Node temp = TrailList.item(i);

                if(temp.getNodeType() == Node.ELEMENT_NODE){
                    Element e = (Element) temp;
                    int SourceID = Integer.parseInt(e.getElementsByTagName("Source").item(0).getTextContent());
                    int DestinationID = Integer.parseInt(e.getElementsByTagName("Destination").item(0).getTextContent());
                    int Danger = Integer.parseInt(e.getElementsByTagName("Danger").item(0).getTextContent());


                    int j = 0;

                    while(SourceID != locations.get(j).id){
                        j++;
                    }

                    Location source = locations.get(j);
                    j = 0;

                    while (DestinationID != locations.get(j).id){
                        j++;
                    }

                    Location destination = locations.get(j);
                    Trail trail = new Trail(source, destination, Danger);
                    trails.add(trail);

                    ArrayList<Trail> a;


                    a = t.get(source.id);
                    a.add(trail);

                    a = t.get(destination.id);
                    a.add(new Trail(destination, source, Danger));


                }
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<Trail> getSafestTrails() {

        List<Trail> safestTrails = new ArrayList<>();
        // Fill the safestTrail list and return it.
        // Select the optimal Trails from the Trail list that you have read.
        // TODO: Your code here

        PriorityQueue<Trail> tempList = new PriorityQueue<>();

        Location s = trails.get(0).source;
        s.painted = true;
        for(Trail tr: t.get(s.id))
            if (!tr.destination.painted)
                tempList.add(tr);

        while(!tempList.isEmpty()){

            Trail temp = tempList.poll();

            if (!temp.destination.painted){
                safestTrails.add(temp);
                temp.destination.painted = true;
                for(Trail tr: t.get(temp.destination.id))
                    if (!tr.destination.painted)
                        tempList.add(tr);
            }

        }

        return safestTrails;
    }

    public void printSafestTrails(List<Trail> safestTrails) {
        // Print the given list of safest trails conforming to the given output format.
        // TODO: Your code here

        System.out.println("Safest trails are:");
        int totalDanger = 0;
        for (int i = 0; i < safestTrails.size(); i++){

            System.out.println("The trail from " + safestTrails.get(i).source.name + " to " +
                    safestTrails.get(i).destination.name + " with danger " + safestTrails.get(i).danger);

            totalDanger += safestTrails.get(i).danger;

        }
        System.out.println("Total danger is: " + totalDanger);
    }
}
