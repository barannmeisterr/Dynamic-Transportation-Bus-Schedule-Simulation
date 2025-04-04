// Author: Arda Baran
public class KnownStationSet {

	NodeOfTheKnownSet root;
	int capacity;
	public KnownStationSet(int capacity) {
		this.capacity=capacity;
		this.root=null;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int size() {
		int count=0;
		NodeOfTheKnownSet curr=root;
		while(curr!=null) {
			count++;
			curr=curr.getNext();
		}
	return count;
	}
	public boolean areAllShortestPathsKnown() {
		return (size()==getCapacity());
	}
	public NodeOfTheKnownSet addNodeToSet(NodeOfTheKnownSet n,Station s) {
	//--------------------------------------------------
	//Summary:adds station to the set recursively.
	//--------------------------------------------------	
		if(n==null) {
			return new NodeOfTheKnownSet(s);
		}
	n.setNext(addNodeToSet(n.getNext(),s));
	return n;
	}
	public void addNodeToSet(Station s) {
	root=addNodeToSet(root,s);	
	}
	public NodeOfTheKnownSet getLastAddedNodeInTheSet() {
	//--------------------------------------------------------
	//Summary:Returns the last element of the list.Stack data structure is referenced.	
	//--------------------------------------------------------	
		if(root==null) {
			return null;
		}
	if(root.getNext()==null) {
		return root;
	}
	NodeOfTheKnownSet curr=root;
	while(curr.getNext()!=null) {
		curr=curr.getNext();
	}
	return curr;
	}
	public Station getLastAddedStationInTheSet() {
		return getLastAddedNodeInTheSet().getStation();
	}
	public boolean isContain(NodeOfTheKnownSet n ,Station s) {
		if(n==null) {
			return false;
		}
	if(n.getStation()==s) {
		return true;
	}
	return isContain(n.getNext(),s);
	}
	public boolean isContain(Station s) {
		return isContain(root,s);
	}
}