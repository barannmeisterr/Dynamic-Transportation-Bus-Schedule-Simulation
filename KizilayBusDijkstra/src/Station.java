// Author: Arda Baran
import java.util.*;
public class Station {
int waitingTime;
boolean canSwitchLine;
int stationID;
List<Line> lines;
int currentTime;
int indegree;
int outdegree;

public Station(int stationID) {
	this.stationID=stationID;
	this.canSwitchLine=false;
	this.waitingTime=0;
    this.lines=new ArrayList<>();	
	this.currentTime=0;
    this.indegree=0;
    this.outdegree=0;	
}



public int getIndegree() {
	return indegree;
}



public void setIndegree(int indegree) {
	this.indegree = indegree;
}



public int getOutdegree() {
	return outdegree;
}



public void setOutdegree(int outdegree) {
	this.outdegree = outdegree;
}



public int getWaitingTime() {
	return waitingTime;
}

public void setWaitingTime(int waitingTime) {
	this.waitingTime = waitingTime;
}

public boolean isCanSwitchLine() {
	return canSwitchLine;
}

public void setCanSwitchLine(boolean canSwitchLine) {
	this.canSwitchLine = canSwitchLine;
}

public int getStationID() {
	return stationID;
}

public void setStationID(int stationID) {
	this.stationID = stationID;
}

public List<Line> getLines() {
	return lines;
}

public void setLines(List<Line> lines) {
	this.lines = lines;
}

public int getCurrentTime() {
	return currentTime;
}

public void setCurrentTime(int currentTime) {
	this.currentTime = currentTime;
}
public void addLineToStation(Line line) {
if(line==null) {
	return;
}
this.lines.add(line);
}
public int findWaitingTimeForLine(Line line,int shortestKnownDistance) {
	int totalNumberOfStationsInTheRoute=line.getNumOfStations();
	int stationIndexInTheRoute=line.getIndexOfTheStationOnTheRoute(getStationID());
	int totalWastedTime=shortestKnownDistance;
	int waitTime=0;
	if(totalWastedTime < totalNumberOfStationsInTheRoute) {
		
		if((stationIndexInTheRoute > totalWastedTime)) {
			waitTime = stationIndexInTheRoute - totalWastedTime ;
			
		}else if( totalWastedTime==stationIndexInTheRoute || totalWastedTime % totalNumberOfStationsInTheRoute == 0 ) {
			waitTime= 0;
		}	
		else {
			int newArrivalTime = stationIndexInTheRoute;
			while(newArrivalTime < totalWastedTime) {
				newArrivalTime +=totalNumberOfStationsInTheRoute;
			}
			waitTime = newArrivalTime - totalWastedTime;
		}
		
		}else {

	if(totalWastedTime % totalNumberOfStationsInTheRoute ==0 )		
			
		waitTime= stationIndexInTheRoute;
	else {
		waitTime= (totalWastedTime % totalNumberOfStationsInTheRoute) - stationIndexInTheRoute;
	}
			
			
			
			
		}
	return waitTime;	
	}

@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Station station = (Station) obj;
    return stationID == station.stationID;
}
public void printLines() {
	for(Line l:getLines()) {
		System.out.println("Station ID: "+getStationID()+", Line ID: "+l.getLineId()+" Get Index Of Station On The Line: "+l.getIndexOfTheStationOnTheRoute(this.getStationID()));
	}
}
@Override
public int hashCode() {
    return Objects.hash(stationID);
}
@Override
public String toString() {
	return "Station ID: "+getStationID()+ " inDegree:  "+getIndegree()+ " outDegree:  "+getOutdegree() + " Can Switch Line:  "+isCanSwitchLine();
}

}
