// Author: Arda Baran
import java.util.*;
public class Dijkstra {
DirectedGraph graph;
HashMap<Station,Integer>shortestDistances;
KnownStationSet setOfVisitedStations;
public Dijkstra(DirectedGraph graph) {
	this.graph=graph;
    this.shortestDistances=new HashMap<>();
    this.setOfVisitedStations= new KnownStationSet(graph.getNumOfStationsInTheGraph());
    for(Station stations:graph.getAllStationsInTheGraph()) {
    	this.shortestDistances.put(stations, Integer.MAX_VALUE);
    }
}



public KnownStationSet getSetOfVisitedStations() {
	return setOfVisitedStations;
}



public void setSetOfVisitedStations(KnownStationSet setOfVisitedStations) {
	this.setOfVisitedStations = setOfVisitedStations;
}



public HashMap<Station, Integer> getShortestDistances() {
	return shortestDistances;
}


public void setShortestDistances(HashMap<Station, Integer> shortestDistances) {
	this.shortestDistances = shortestDistances;
}


public DirectedGraph getGraph() {
	return graph;
}


public void setGraph(DirectedGraph graph) {
	this.graph = graph;
}

public int getShortestDistanceToStation(Station station) {
	return getShortestDistances().get(station);
}

public void changeShortestDistanceOfStation(Station station,int newDistance) {
	this.shortestDistances.replace(station, newDistance);
}
public int FindLineIdBetweenTwoConnectedStations(Station from,Station to) {
	  for (Edge edge : getGraph().getAdjList().get(from)) { 
	        if (edge.getTo() == to) {
	            return edge.getLineId();
	        }
	    }
	    return -1; 
}

public int getLinkCost(Station from, Station to) {
    for (Edge edge : getGraph().getAdjList().get(from)) { 
        if (edge.getTo() == to) {
            return edge.getWeight();
        }
    }
    return -1; 
}
public int getTotalCost(Station from,Station to) {

int lineIdThatConnectsFromAndTo=FindLineIdBetweenTwoConnectedStations(from,to);
int waitTimeForLineToMove=from.findWaitingTimeForLine(getGraph().getLineById(lineIdThatConnectsFromAndTo),getShortestDistanceToStation(from));
return getShortestDistanceToStation(from) + waitTimeForLineToMove + getLinkCost(from,to);
	 	
}
public void updateShortestDistance(Station currentStation,Station neighborOfCurrentStation) {
	int updatedShortestDistance = getTotalCost(currentStation,neighborOfCurrentStation);
	if(updatedShortestDistance < getShortestDistanceToStation(neighborOfCurrentStation)) {
		changeShortestDistanceOfStation(neighborOfCurrentStation,updatedShortestDistance);
	}
}

public List<Station> getNeighborsOfStation(Station station) {
	List<Edge> edges = getGraph().getNeighbors(getGraph().getStation(station));
	List<Station> neighbors=new ArrayList<>();
	for (Edge edge : edges) {
		Station neighbor = edge.getTo();
		neighbors.add(neighbor);
	}
	return neighbors;
}
public List<Station> getUnreachableStationsFromStartStation(Station startStation) {
    List<Station> unreachableStations = new ArrayList<>();
    Set<Station> visited = new HashSet<>();
    Queue<Station> queue = new LinkedList<>();

    // BFS Traversal Başlat
    queue.add(startStation);
    visited.add(startStation);

    while (!queue.isEmpty()) {
        Station current = queue.poll();

        // Komşuları sıraya ekle
        for (Station neighbor : getNeighborsOfStation(current)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.add(neighbor);
            }
        }
    }

    
    for (Station station : getGraph().getAllStationsInTheGraph()) {
        if (!visited.contains(station)) {
            unreachableStations.add(station);
        }
    }

    return unreachableStations;
}
public void findMinWeightedStationAndUpdateDistances() {
	//----------------------------------------------------------------------------
	//Summary:unvisited vertex with shortest path cost is chosen,all distances are updated , ancestors are set and the new discovered	
	//with the shortest path cost is added to the nodeSet.
	//-------------------------------------------------------------------------------			
	int minWeight = Integer.MAX_VALUE;
	Station currentStation = getSetOfVisitedStations().getLastAddedStationInTheSet();
	Station minWeightedStation = null;
	        // Update distances
	   for (Station neighbor : getGraph().getAllStationsInTheGraph()) {
	      if (currentStation != neighbor && getNeighborsOfStation(currentStation).contains(neighbor) && getSetOfVisitedStations().isContain(currentStation) && !getSetOfVisitedStations().isContain(neighbor)) {
	        updateShortestDistance(currentStation, neighbor);
	            }
	        }
	        // Find the minimum weighted vertex
	   for (Station neighbor : getGraph().getAllStationsInTheGraph()) {
	       if (!getSetOfVisitedStations().isContain(neighbor) && getShortestDistanceToStation(neighbor) < minWeight) {
	         minWeight = getShortestDistanceToStation(neighbor);
	         minWeightedStation = neighbor;
	            }
	        }
	        // Add the minimum weighted vertex to the set
	        if (minWeightedStation != null) {
	        	getSetOfVisitedStations().addNodeToSet(minWeightedStation);
	        }
	    }
public void dijkstraAlgorithm(Station source) {
	//----------------------------------------------------------------------------
	//Summary:Performs Dijkstra's algorithm.Dijkstra's algorithm starts with a vertex named source.at the beginning the shortest 
	//distance from source to itself is set to 0 , the vertices whose connected directly to the source are set to the value 
	//of the linkCost between source and the neighbors of the source.Also ancestors are set for neighbors of source as source.
	//the distance is set to 0 for vertices that are not directly connected directly with the source vertex.
	//ancestors are set.after performing the dijkstra's algorithm ,shortest paths from a single source to all other vertices are
	//printed.	
	//-------------------------------------------------------------------------------
	getSetOfVisitedStations().addNodeToSet(source);
	changeShortestDistanceOfStation(source,0);
	List<Station>unreachableStations=getUnreachableStationsFromStartStation(source);
	for(Station unreachable : unreachableStations) {
		getSetOfVisitedStations().addNodeToSet(unreachable);
		changeShortestDistanceOfStation(unreachable,-1);
	}
	
	for (Station neighbor : getGraph().getAllStationsInTheGraph()) {
	     if (neighbor != source && getNeighborsOfStation(source).contains(neighbor)) {
	       changeShortestDistanceOfStation(neighbor,getTotalCost(source,neighbor));
	     
	     }
	      }
	while (!getSetOfVisitedStations().areAllShortestPathsKnown()) {
		findMinWeightedStationAndUpdateDistances();
	}

	}
public void printShortestDistances(Station startStation) {
   
    for (Map.Entry<Station, Integer> entry : shortestDistances.entrySet()) {
        Station station = entry.getKey();
        int distance = entry.getValue();
        
        if (!station.equals(startStation)) { // start station is not included because source is excluded
            System.out.print(distance+" ");
        }
    }
}


}

