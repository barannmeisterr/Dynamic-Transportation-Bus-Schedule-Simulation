// Author: Arda Baran
//Class:Edge
//Description:This class defines the directed edge structure between two stations.An edge on the graph consists of ID of a line that connects two stations,
//From station, To station and link cost as weight.
public class Edge {
int lineId;
Station from , to;
int weight;
public Edge(int lineId,Station from,Station to,int weight) {
	this.lineId=lineId;
	this.from=from;
	this.to=to;
	this.weight=weight;
}
public int getLineId() {
	return lineId;
}
public void setLineId(int lineId) {
	this.lineId = lineId;
}
public Station getFrom() {
	return from;
}
public void setFrom(Station from) {
	this.from = from;
}
public Station getTo() {
	return to;
}
public void setTo(Station to) {
	this.to = to;
}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}


}
