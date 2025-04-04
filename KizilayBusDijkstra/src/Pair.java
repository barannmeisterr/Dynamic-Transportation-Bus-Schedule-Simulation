// Author: Arda Baran
public class Pair {
Station from,to;
public Pair(Station from,Station to) {
	this.from=from;
	this.to=to;
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
@Override
public String toString() {
	if(from==null || to==null) {
		return "No pair exist...";
	}else {
		return "From:"+getFrom().getStationID()+" ,To:"+getTo().getStationID();
	}


}
}
