// Author: Arda Baran
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	 public static void main(String[] args) {
	        String filePath = "src/resources/file1.txt"; // file path

	        // reads stations before reading routes in order to add these stations to directed graph
	        MyHashSet<Integer> set = FileHelper.readStationIdsFromFile(filePath);

	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            // reads first row from txt: number of stations and number of lines
	            String[] firstLine = br.readLine().split(" ");
	            int numOfStations = Integer.parseInt(firstLine[0]);
	            int numOfLines = Integer.parseInt(firstLine[1]);

	            // creates DirectedGraph instance then initializes stations
	            DirectedGraph graph = new DirectedGraph(numOfStations, numOfLines);
	            graph.initializeStations(set);

	            // reads rows in txt which contains line informations(number of stations on the line and id of stations)
	            List<Line> lines = new ArrayList<>();
	            int lineId = 1;
	            String lineText;
	            while ((lineText = br.readLine()) != null) {
	                String[] parts = lineText.split(" ");
	                int stationCount = Integer.parseInt(parts[0]);

	                // gets stations on the line
	                Station[] lineStations = new Station[stationCount];
	                for (int i = 0; i < stationCount; i++) {
	                    lineStations[i] = graph.getStationById(Integer.parseInt(parts[i + 1]));
	                }

	                // creates a new line then adds these created line to line list
	                lines.add(new Line(lineId++, stationCount, lineStations));
	            }

	            // initializes lines in directed graph by using line list
	            graph.initializeLines(lines);
	            
	           //all connections and configurations are performed for the directed graph
	            graph.initializeGraph();
	            //creates Dijkstra class instance in order to perform dijkstra algorithm by using graph
	            Dijkstra dijkstra = new Dijkstra(graph);
	           //Applies dijkstra algorithm in order to find all shortest distances from source station
	            dijkstra.dijkstraAlgorithm(dijkstra.getGraph().getStationById(1));
	           //prints all shortest paths from source station
	            dijkstra.printShortestDistances(dijkstra.getGraph().getStationById(1));
	           
     } catch (IOException e) {
         e.printStackTrace();
     }
	}

}
