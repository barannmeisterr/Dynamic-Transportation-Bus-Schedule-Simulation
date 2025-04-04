// Author: Arda Baran

import java.util.*;

public class DirectedGraph {

int numOfStationsInTheGraph;
int numOfLinesInTheGraph;

List<Line> linesInTheGraph;
Map<Station, List<Edge>> adjList;



public DirectedGraph(int numOfStationsInTheGraph,int numOfLinesInTheGraph) {
this.numOfStationsInTheGraph=numOfStationsInTheGraph;	
this.numOfLinesInTheGraph=numOfLinesInTheGraph;

this.linesInTheGraph=new ArrayList<>();
this.adjList=new HashMap<>();
	
}

public Map<Station, List<Edge>> getAdjList() {
	return adjList;
}



public void setAdjList(Map<Station, List<Edge>> adjList) {
	this.adjList = adjList;
}



public int getNumOfStationsInTheGraph() {
	return numOfStationsInTheGraph;
}



public void setNumOfStationsInTheGraph(int numOfStationsInTheGraph) {
	this.numOfStationsInTheGraph = numOfStationsInTheGraph;
}



public int getNumOfLinesInTheGraph() {
	return numOfLinesInTheGraph;
}



public void setNumOfLinesInTheGraph(int numOfLinesInTheGraph) {
	this.numOfLinesInTheGraph = numOfLinesInTheGraph;
}





public List<Line> getLinesInTheGraph() {
	return linesInTheGraph;
}

public void setLinesInTheGraph(List<Line> linesInTheGraph) {
	this.linesInTheGraph = linesInTheGraph;
}

public void addEdge(int lineId, Station from, Station to, int weight) {
    Edge edge = new Edge(lineId, from, to, weight);
    
   
    adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(edge);
}
public void initializeGraph() {
	assignLinesToStations();
	for(Line l : getLinesInTheGraph()) {
		for(Pair p : l.getPairs()) {
			addEdge(l.getLineId(),p.getFrom(),p.getTo(),1);
		}
	}
	initializeInOutDegrees();
	initializeGetOnOffStatusForStations();
	

}


public void printAdjList() {
    for (Map.Entry<Station, List<Edge>> entry : adjList.entrySet()) {
        Station station = entry.getKey();
        List<Edge> edges = entry.getValue();

        System.out.print("From Station ID: " + station.getStationID() + " -> ");

        if (edges.isEmpty()) {
            System.out.println("No Connections...");
        } else {
            for (Edge edge : edges) {
                System.out.print(" [To Station ID: " + edge.getTo().getStationID() + ", Line ID: " + edge.getLineId() + ", Weight: " + edge.getWeight() + "] ");
            }
            System.out.println();
        }
    }
}
public List<Edge> getNeighbors(Station station) {
    return adjList.getOrDefault(station, Collections.emptyList());
}
public void initializeStations(MyHashSet<Integer> stations) {
	ArrayList<Integer> stationIndexList = stations.getList();
	Collections.sort(stationIndexList);
	for (Integer stationID : stationIndexList) {
        Station station = new Station(stationID);
        
        adjList.put(station, new ArrayList<>()); 
    }
}
public void initializeLines(List<Line> lines) {
	for(Line l : lines) {
		linesInTheGraph.add(l);
	}
}
public void initializeGetOnOffStatusForStations() {
	 for (Map.Entry<Station, List<Edge>> entry : adjList.entrySet()) {
	        Station station = entry.getKey();
	       if(station.getOutdegree() > 1) {
	    	   station.setCanSwitchLine(true);
	       }else {
	    	   station.setCanSwitchLine(false);  
	       }
	    }	
}
public void assignLinesToStations() {
	for(Line l : getLinesInTheGraph()) {
		l.addThisLineToStations();
	}
}
public void printLines() {
	for(Line l : getLinesInTheGraph()) {
	System.out.println("----------------------------------------------");	
		System.out.println("Line ID: "+l.getLineId()+" Number Of Stations On The Line: "+l.getNumOfStations());
		System.out.println();
		l.printStations();
		System.out.println();
	System.out.println("-------------------------------------------------");
	}
}
public void initializeInOutDegrees() {
    
    for (Map.Entry<Station, List<Edge>> entry : adjList.entrySet()) {
        Station station = entry.getKey();
        List<Edge> edges = entry.getValue();
        station.setOutdegree(edges.size()); 
    }

    
    for (Map.Entry<Station, List<Edge>> entry : adjList.entrySet()) {
        List<Edge> edges = entry.getValue();
        for (Edge edge : edges) {
            Station toStation = getStation(edge.getTo());
            if (toStation != null) {
                toStation.setIndegree(toStation.getIndegree() + 1);
            }
        }
    }
}



public Station getStation(Station station) {
	for(Station s : adjList.keySet()) {
		if(s.equals(station)) {
			return s;
		}
	}
return null;
}

public Station getStationById(int stationId) {
    for (Station station : adjList.keySet()) {
        if (station.getStationID() == stationId) {
            return station; 
        }
    }
    return null; 
}
public List<Station> getAllStationsInTheGraph() {
    List<Station> stationList = new ArrayList<>();
	for (Station station : adjList.keySet()) {
        stationList.add(station);
    }
     return stationList;
}
public Line getLineById(int lineId) {
	for(Line l : getLinesInTheGraph()) {
		if(l.getLineId()==lineId) {
			return l;
		}
	}
return null;
}


}
