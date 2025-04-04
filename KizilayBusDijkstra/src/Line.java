// Author: Arda Baran
import java.util.*;
public class Line {

int lineId,numOfStations;
Station[] stations;

public Line(int lineId,int numOfStations,Station[] stations) {
this.lineId=lineId;
this.numOfStations=numOfStations;
this.stations=stations;

}

public int getLineId() {
	return lineId;
}

public void setLineId(int lineId) {
	this.lineId = lineId;
}

public int getNumOfStations() {
	return numOfStations;
}

public void setNumOfStations(int numOfStations) {
	this.numOfStations = numOfStations;
}

public Station[] getStations() {
	return stations;
}

public void setStations(Station[] stations) {
	this.stations = stations;
}
public int getIndexOfTheStationOnTheRoute(int stationIndex) {
	int i = 0;
	int searchedIndex=-1;

	for(Station s:getStations()) {
		
		if(s!=null &&s.getStationID()==stationIndex) {
			searchedIndex = i;
		}
	i++;
	}
return searchedIndex;
}
public void printStations() {
	if(getStations()!=null) {
		
		for(Station s :getStations()) {
			System.out.print(s.getStationID()+" ");
		}

		
		
	}
}


public List<Pair> getPairs() {
List<Pair>allPairs=new ArrayList<>();
Station[] sts = getStations();
Pair p;
for(int i = 0 ,j=i+1;j<getNumOfStations();i++,j++) {
Station from = sts[i];
Station to = sts[j];
p=new Pair(from,to);
allPairs.add(p);
	
	
}
Station lastStation=sts[getNumOfStations()-1];
Station firstStation=sts[0];
Pair lastConnection=new Pair(lastStation,firstStation);
allPairs.add(lastConnection);
return allPairs;	
	
}
public  void printPairs() {
	List<Pair>allPairs=getPairs();
	for(Pair p :allPairs) {
		if(p!=null) {
			System.out.println(p);
		}
	}
}
public void addThisLineToStations() {
	for(Station s : getStations()) {
		if(s!=null) {
			s.addLineToStation(this);
		}
	}
}
}
