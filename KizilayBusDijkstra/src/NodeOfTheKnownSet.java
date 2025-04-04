// Author: Arda Baran
public class NodeOfTheKnownSet {
	Station station;
	NodeOfTheKnownSet next;
	public NodeOfTheKnownSet(Station station) {
		this.station=station;
		this.next=null;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public NodeOfTheKnownSet getNext() {
		return next;
	}
	public void setNext(NodeOfTheKnownSet next) {
		this.next = next;
	}

}
